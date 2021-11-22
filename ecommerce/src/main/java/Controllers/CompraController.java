/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import DAO.CadastroProdutoDAO;
import DAO.CompraDAO;
import Mapeamentos.Cliente;
import Mapeamentos.Compra;
import Mapeamentos.Produto;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.json.JSONArray;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Giovana Borges
 */
@Controller
public class CompraController {

    @RequestMapping("comprar")
    public String getComprar() {
        return "comprar";
    }

    @RequestMapping("historicoCompras")
    public String getHistorico() {
        return "historicoCompras";
    }

    @RequestMapping("compra")
    public String getProdutoId(@RequestParam(value = "cod") int id, Model model) {
        CadastroProdutoDAO dao = new CadastroProdutoDAO();
        Produto p = new Produto();
        p = dao.getProdutoById(id);

        model.addAttribute("Produto", p);
        return "comprar";
    }

    @RequestMapping("realizarCompra")
    public String salvarNoBanco(
            Model model,
            HttpSession session,
            @RequestParam(value = "cod") int cod,
            @RequestParam(value = "valor") double valor,
            @RequestParam(value = "quant") int quant
    ) {

        String msg = null;
        CompraDAO dao = new CompraDAO();
        Cliente cliente = (Cliente) session.getAttribute("usuarioLogado");
        Compra c = new Compra();
        Date f = new Date();

        CadastroProdutoDAO daoP = new CadastroProdutoDAO();
        Produto p = new Produto();

        if (cliente == null) {//A pessoa não está logada (somente quem está logado pode comprar)
            msg = "<div class=\"alert alert-danger\" role=\"alert\">Você precisa estar logado para comprar.</div>";
        } else {//A pessoa está logada e pode comprar (o admin também poderá comprar)
            p = daoP.getProdutoById(cod);//busca o produto pelo código dele
            double total = valor * quant;//o valor total será o preço unitário(valor) multiplicado pela quantidade
            int novaQuant = p.getQuantEstoque() - quant;//deve-se decrementar a quantidade do produto disponível no estoque
            if (novaQuant >= 0 && novaQuant < p.getQuantEstoque()) {//tem a quantidade que a pessoa quer comprar em estoque
                if (dao.salvar(c, f, quant, total, cliente, p)) {
                    p.setQuantEstoque(novaQuant);//seta a nova quantidade disponível
                    daoP.salvar(p, f);//salva as novas informações no banco
                    msg = "<div class=\"alert alert-success\" role=\"alert\">Compra realizada com sucesso</div>";
                } else {
                    msg = "<div class=\"alert alert-danger\" role=\"alert\">Não foi possível realizar sua compra</div>";
                }
            } else {
                msg = "<div class=\"alert alert-danger\" role=\"alert\">Desculpe, mas a quantidade de produtos escolhidos excede o disponível em estoque.</div>";
            }
        }

        model.addAttribute("msg", msg);
        return "comprar";
    }

    @ResponseBody
    @RequestMapping(value = "histCompras", produces = "text/json;charset=UTF-8")
    public String histCompras(Model model, HttpSession session) {
        Cliente cliente = (Cliente) session.getAttribute("usuarioLogado");

        CompraDAO dao = new CompraDAO();
        String j;

        List<Compra> c = new ArrayList<Compra>();
        c = dao.getHistorico(cliente.getCpf());

        if (c != null) {
            JSONArray json = new JSONArray();
            Map<String, String> data = new HashMap<String, String>();

            for (int i = 0; i < c.size(); i++) {
                data.put("nome", c.get(i).getProduto().getNome());

                double valor = c.get(i).getProduto().getValor();
                DecimalFormat formatValue = new DecimalFormat("##,###,###,##0.00", new DecimalFormatSymbols(new Locale("pt", "BR")));
                formatValue.setMinimumFractionDigits(2);
                formatValue.setParseBigDecimal(true);
                data.put("valor", formatValue.format(valor));

                data.put("quant", Integer.toString(c.get(i).getQuantCompra()));

                double total = c.get(i).getProduto().getValor() * c.get(i).getQuantCompra();//pega o valor total da compra                
                DecimalFormat formatTotal = new DecimalFormat("##,###,###,##0.00", new DecimalFormatSymbols(new Locale("pt", "BR")));
                formatTotal.setMinimumFractionDigits(2);
                formatTotal.setParseBigDecimal(true);
                data.put("total", formatTotal.format(total));
                
                SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
                String dateString = format.format(c.get(i).getProduto().getModificacao());
                data.put("modificacao", dateString);

                json.put(data);//joga tudo pro vetor json
            }
            j = "{\"data\":" + json.toString() + "}";
        } else {
            j = "{\"data\": \"\" }";
        }
        return j;
    }
}
