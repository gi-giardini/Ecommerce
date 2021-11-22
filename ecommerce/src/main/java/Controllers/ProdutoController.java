/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import DAO.CadastroProdutoDAO;
import DAO.CompraDAO;
import Mapeamentos.Compra;
import Mapeamentos.Produto;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONArray;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Giovana Borges
 */
@Controller
public class ProdutoController {

    @RequestMapping("cadastroProduto")
    public String getCadastro(Model model) {
        model.addAttribute("Produto", new Produto());
        return "cadastroProduto";
    }

    @RequestMapping("salvarProduto")
    public String salvarNoBanco(@ModelAttribute("Produto") Produto produto,
            @RequestParam(value = "file", required = false) MultipartFile imagem,
            Model model) {
        String msg = null;
        CadastroProdutoDAO dao = new CadastroProdutoDAO();
        Date f = new Date();

        int tamanho = (int) imagem.getSize();

        if (tamanho != 0) {//não tem uma imagem cadastrada, então seta a imagem
            try {
                produto.setImagem(imagem.getBytes());
            } catch (IOException ex) {
                Logger.getLogger(ProdutoController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        int cod = produto.getCod();
        if (cod == 0) {//é um novo produto que será inserido no banco
            if (dao.salvar(produto, f)) {
                msg = "<div class=\"alert alert-success\" role=\"alert\">Cadastro realizado com sucesso!</div>";
            } else {
                msg = "<div class=\"alert alert-danger\" role=\"alert\">Falha no cadastro.</div>";
            }
        } else {//é uma edição de produto
            if (dao.editar(produto, f, produto.getCod())) {
                msg = "<div class=\"alert alert-success\" role=\"alert\">Alterações realizadas com sucesso!</div>";
            } else {
                msg = "<div class=\"alert alert-danger\" role=\"alert\">Falha na atualização do produto.</div>";
            }
        }

        model.addAttribute("msg", msg);
        return "cadastroProduto";
    }

    @ResponseBody
    @RequestMapping(value = "mostrarPorCategoria", produces = "text/json;charset=UTF-8")
    public String filtrarPorCategoria(@RequestParam(value = "idCategoria", required = false, defaultValue = "0") int idCategoria) {
        CadastroProdutoDAO dao = new CadastroProdutoDAO();
        String j;

        List<Produto> produtos = new ArrayList<Produto>();

        if (idCategoria == 0) {
            produtos = dao.getAll();
        } else {
            produtos = dao.getByCategoria(idCategoria);
        }
        if (produtos != null) {
            JSONArray json = new JSONArray();
            Map<String, String> data = new HashMap<String, String>();

            for (int i = 0; i < produtos.size(); i++) {
                data.put("cod", Integer.toString(produtos.get(i).getCod()));
                data.put("nome", produtos.get(i).getNome());

                double valor = produtos.get(i).getValor();
                DecimalFormat format = new DecimalFormat("##,###,###,##0.00", new DecimalFormatSymbols(new Locale("pt", "BR")));
                format.setMinimumFractionDigits(2);
                format.setParseBigDecimal(true);
                data.put("valor", format.format(valor));

                json.put(data);//joga tudo pro vetor json
            }
            j = "{\"data\":" + json.toString() + "}";
        } else {
            j = "{\"data\": \"\" }";
        }
        return j;
    }

    /*Mostra o dataTable*/
    @ResponseBody
    @RequestMapping(value = "grid", produces = "text/json;charset=UTF-8")
    public String grid() {
        CadastroProdutoDAO dao = new CadastroProdutoDAO();
        String j;

        List<Produto> produtos = new ArrayList<Produto>();
        produtos = dao.getAll();

        JSONArray json = new JSONArray();
        Map<String, String> data = new HashMap<String, String>();

        for (int i = 0; i < produtos.size(); i++) {
            data.put("cod", Integer.toString(produtos.get(i).getCod()));
            data.put("nome", produtos.get(i).getNome());
            data.put("categoria", Integer.toString(produtos.get(i).getCategoria().getId()));

            double valor = produtos.get(i).getValor();
            DecimalFormat formatValue = new DecimalFormat("##,###,###,##0.00", new DecimalFormatSymbols(new Locale("pt", "BR")));
            formatValue.setMinimumFractionDigits(2);
            formatValue.setParseBigDecimal(true);
            data.put("valor", formatValue.format(valor));
            
            data.put("descricao", (produtos.get(i).getDescricao()));
            data.put("estoque", Integer.toString(produtos.get(i).getQuantEstoque()));

            SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
            String dateString = format.format(produtos.get(i).getModificacao());
            data.put("modificacao", dateString);

            data.put("editar", "<a href=\"editar?cod=" + produtos.get(i).getCod() + "\" class=\"btn btn-link\">Editar</a>");
            data.put("excluir", "<a href=\"excluirProduto?cod=" + produtos.get(i).getCod() + "\" class=\"btn btn-link\">Excluir</a>");
            json.put(data);//joga tudo pro vetor json
        }
        j = "{\"data\":" + json.toString() + "}";

        return j;
    }

    //para enviar o produto que será editado para a página cadastroProduto(também edita esta página, apesar do nome)
    @RequestMapping("editar")
    public String getProdutoId(@RequestParam(value = "cod") int id, Model model) {
        CadastroProdutoDAO dao = new CadastroProdutoDAO();
        Produto p = new Produto();
        p = dao.getProdutoById(id);

        model.addAttribute("Produto", p);
        return "cadastroProduto";
    }

    @RequestMapping("excluirProduto")
    public String excluirDoBanco(@RequestParam(value = "cod") int id, Model model) {
        String msg = null;
        CompraDAO dao = new CompraDAO();
        CadastroProdutoDAO daoP = new CadastroProdutoDAO();

        List<Compra> listaProdutosComprados = new ArrayList<Compra>();

        listaProdutosComprados = dao.getProdutoCompradoById(id);//procura se o produto que se deseja excluir já foi comprado alguma vez(não pode ser excluído)
        if (listaProdutosComprados.size() > 0) {//o produto que o admin está tentando excluir já foi comprado
            msg = "<div class=\"alert alert-danger\" role=\"alert\">O produto não pode ser excluído, pois já foi comprado por algum cliente.</div>";
        } else {
            Produto p = new Produto();
            p = daoP.getProdutoById(id);
            if (daoP.deletar(p)) {
                msg = "<div class=\"alert alert-success\" role=\"alert\">Produto excluído com sucesso!</div>";
            } else {
                msg = "<div class=\"alert alert-danger\" role=\"alert\">Falha para excluir.</div>";
            }
        }

        model.addAttribute("msg", msg);
        return "produtos";
    }

    @RequestMapping("produtos")
    public String getProdutos() {
        return "produtos";
    }

    @RequestMapping(value = "recuperarImagem", method = RequestMethod.GET)
    public @ResponseBody
    String exibirImagem(@RequestParam(value = "id") int id,
            HttpServletRequest request,
            HttpServletResponse response) throws IOException {

        response.setContentType("image/jpg");

        byte[] buffer = new byte[1024];
        int bytesread = 0;

        InputStream is;
        try (ServletOutputStream out = response.getOutputStream()) {
            CadastroProdutoDAO dao = new CadastroProdutoDAO();
            Produto produto = new Produto();

            produto = dao.getProdutoById(id);

            if (produto.getImagem() == null) {
                is = request.getSession().getServletContext().getResourceAsStream("produtoSemFoto.png");
                while ((bytesread = is.read(buffer)) != -1) {
                    out.write(buffer, 0, bytesread);
                }
            } else {
                is = new ByteArrayInputStream(produto.getImagem());
                while ((bytesread = is.read(buffer)) != -1) {
                    out.write(buffer, 0, bytesread);
                }
                out.flush();
            }
        }
        is.close();

        return "imagem";
    }
}
