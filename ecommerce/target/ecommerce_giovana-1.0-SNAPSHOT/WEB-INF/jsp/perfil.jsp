<%-- 
    Document   : perfil
    Created on : 05/11/2018, 17:32:15
    Author     : Giovana Borges
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html lang="pt-br">

    <head>
        <%@include file="/WEB-INF/jsp/estrutura/ImportBot.jsp"%>    
        
        <meta charset="UTF-8" />
        <title>Perfil</title>    
    </head>

    <body>        
        <%@include file="/WEB-INF/jsp/estrutura/cabecalho.jsp"%>
        <%@include file="/WEB-INF/jsp/estrutura/navbar.jsp"%>

        <div class="container-fluid col-md-8 col-md-offset-2">
            <div class="panel panel-primary">
                <div class="panel-heading">
                    Bem vindo(a) ${usuarioLogado.nome}
                </div>
                <div class="panel-body">
                    <div class="container-fluid col-md-12 col-md-offset-0">
                        <div class="panel panel-info">
                            <div class="panel-heading">
                                Dados Cadastrais:
                            </div>
                            <div class="panel-body">
                                <ul class="list-group">
                                    <li class="list-group-item">
                                        <span class="glyphicon glyphicon-user" aria-hidden="true"></span>
                                        <label>Nome:</label> ${usuarioLogado.nome}
                                    </li>
                                    <li class="list-group-item">
                                        <span class="glyphicon glyphicon-envelope" aria-hidden="true"></span>
                                        <label>Email:</label> ${usuarioLogado.email}
                                    </li>
                                    <li class="list-group-item">
                                        <span class="glyphicon glyphicon-certificate" aria-hidden="true"></span>
                                        <label>CPF:</label> ${usuarioLogado.cpf}
                                    </li>                        
                                </ul>
                            </div>                
                        </div>
                    </div>
                    <div class="container-fluid col-md-12 col-md-offset-0">
                        <div class="panel panel-info">
                            <div class="panel-heading">
                                Dados Residenciais:
                            </div>
                            <div class="panel-body">
                                <ul class="list-group">
                                    <li class="list-group-item">
                                        <span class="glyphicon glyphicon-home" aria-hidden="true"></span>                                    
                                        <label>Rua:</label> ${usuarioLogado.rua}
                                    </li>
                                    <li class="list-group-item">
                                        <span class="glyphicon glyphicon-home" aria-hidden="true"></span> 
                                        <label>Bairro:</label> ${usuarioLogado.bairro}
                                    </li>
                                    <li class="list-group-item">
                                        <span class="glyphicon glyphicon-home" aria-hidden="true"></span> 
                                        <label>Número:</label> ${usuarioLogado.num}
                                    </li>    
                                    <li class="list-group-item">
                                        <span class="glyphicon glyphicon-home" aria-hidden="true"></span> 
                                        <label>Cidade:</label> ${usuarioLogado.cidade}
                                    </li>
                                    <li class="list-group-item">
                                        <span class="glyphicon glyphicon-home" aria-hidden="true"></span> 
                                        <label>Estado:</label> ${usuarioLogado.estado}
                                    </li>                                    
                                </ul>
                            </div>                
                        </div>
                    </div>
                </div>
                <center>
                    <br/>
                    Atualizar Cadastro<a href="cadastroCliente" class="btn btn-link">Clique aqui</a>
                    <br/>
                </center>
            </div>
        </div>
    </body>
</html>
