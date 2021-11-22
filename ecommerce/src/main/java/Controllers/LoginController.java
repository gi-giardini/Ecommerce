/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import DAO.LoginDAO;
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
public class LoginController {

    @RequestMapping("login")
    public String getLogin(Model model, HttpSession session) {
        if(session.getAttribute("usuarioLogado") == null){
            model.addAttribute("Cliente", new Cliente());            
        }else{
            model.addAttribute("Cliente", session.getAttribute("usuarioLogado"));
        }
        return "login";
    }
    
    public String getCadastro(Model model, HttpSession session) {
        if(session.getAttribute("usuarioLogado") == null){
            model.addAttribute("Cliente", new Cliente());            
        }else{
            model.addAttribute("Cliente", session.getAttribute("usuarioLogado"));
        }    
        return "cadastroCliente";
    }

    @RequestMapping("validarLogin")
    public String validarLogin(
            @ModelAttribute("Cliente") Cliente cliente, Model model,
            HttpSession session) {
        String msg;
        LoginDAO dao = new LoginDAO();

        if (dao.getClienteByEmail(cliente.getEmail()) != null) {//encontrou o email digitado no banco
            if (dao.findSenha(cliente.getSenha(), cliente.getEmail()) != null) {//encontrou a senha digitada
                session.setAttribute("usuarioLogado", dao.getClienteByEmail(cliente.getEmail()));
                return "index";
            } else {
                msg = "<div class=\"alert alert-danger\" role=\"alert\">A senha digitada está incorreta.</div>";
            }
        } else {
            msg = "<div class=\"alert alert-danger\" role=\"alert\">O email digitado está incorreto.</div>";
        }
        model.addAttribute("msg", msg);
        return "login";
    }

    @RequestMapping("logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:index";
    }
    
    @RequestMapping("perfil")
    public String getPerfil(Model model) {
        model.addAttribute("Cliente", new Cliente());
        return "perfil";
    }
}
