/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import DAO.CadastroClienteDAO;
import Mapeamentos.Cliente;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Giovana Borges
 */
@Controller
public class CadastroController {

    @RequestMapping("cadastroCliente")
    public String getCadastro(Model model, HttpSession session) {
        if(session.getAttribute("usuarioLogado") == null){
            model.addAttribute("Cliente", new Cliente());            
        }else{
            model.addAttribute("Cliente", session.getAttribute("usuarioLogado"));
        }    
        return "cadastroCliente";
    }

    @RequestMapping("salvarCliente")
    public String salvarNoBanco(@ModelAttribute("Cliente") Cliente cliente, Model model,
            HttpSession session) {
        String msg = null;
        CadastroClienteDAO dao = new CadastroClienteDAO();
        Cliente usuario = (Cliente) session.getAttribute("usuarioLogado");

        if (usuario != null) {//Tem alguém logado. Está fazendo alteração de dados
            if(usuario.getIsAdmin()){//é o admin
                cliente.setIsAdmin(true);
            }else{
                cliente.setIsAdmin(false);
            }            
            if (dao.salvar(cliente)) {
                session.setAttribute("usuarioLogado", cliente);
                msg = "<div class=\"alert alert-success\" role=\"alert\">Alterações realizadas com sucesso!</div>";
            } else {
                msg = "<div class=\"alert alert-danger\" role=\"alert\">Falha na atualização do cadastro.</div>";
            }
        } else {//Não tem ninguém logado. É um cadastro*/
            if (dao.getClienteByCpf(cliente.getCpf()) != null) {
                msg = "<div class=\"alert alert-danger\" role=\"alert\">Esse cpf já está cadastrado.</div>";
            } else {
                if (dao.getClienteByEmail(cliente.getEmail()) != null) {
                    msg = "<div class=\"alert alert-danger\" role=\"alert\">Esse email já está cadastrado.</div>";
                } else {
                    if (dao.salvar(cliente)) {
                        msg = "<div class=\"alert alert-success\" role=\"alert\">Cadastro realizado com sucesso!</div>";
                    } else {
                        msg = "<div class=\"alert alert-danger\" role=\"alert\">Falha no cadastro.</div>";
                    }
                }
            }
        }
        model.addAttribute("msg", msg);
        return "cadastroCliente";//Retorna o nome da página jsp(sempre retorne!!)
    }
}
