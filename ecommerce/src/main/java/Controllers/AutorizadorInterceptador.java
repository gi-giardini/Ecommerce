/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Mapeamentos.Cliente;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 *
 * @author Giovana Borges*/

public class AutorizadorInterceptador extends HandlerInterceptorAdapter {  
    
    @Override
    public boolean preHandle(HttpServletRequest request,
            HttpServletResponse response,
            Object controller
            ) throws Exception {
        String uri = request.getRequestURI();
        String msg;
        Cliente usuario = (Cliente) request.getSession().getAttribute("usuarioLogado");
        //Verifica se está logado
        if(usuario != null){//Está logado
            if(!(uri.contains("login"))){
                //Verifica se é administrador
                //obs: ningúem pode entrar na comprar pq só pode entrar nela pelo método. Se entrar sem o método "compra", não existem as infprmações do produto
                if (usuario.getIsAdmin() && !(uri.contains("comprar"))) {
                    return true;
                } else {//Se não for administrador                  
                    if (!(uri.contains("comprar")) && !(uri.contains("cadastroProduto")) && !(uri.contains("produtos")) && !(uri.contains("editar")) && !(uri.contains("excluir"))) {
                        return true;
                    }
                }
            }
        }else{//Não está logado
            //Se não for a página de perfil nem a de cadastro de produtos
            if(!(uri.contains("comprar")) && !(uri.contains("cadastroProduto")) && !(uri.contains("historicoCompras")) && !(uri.endsWith("perfil")) && !(uri.contains("produtos")) && !(uri.contains("editar")) && !(uri.contains("excluir"))){
               return true;
            }
        }
        //model.addAttribute("msg", msg);
        response.sendRedirect("index");
        return false;
    }
}