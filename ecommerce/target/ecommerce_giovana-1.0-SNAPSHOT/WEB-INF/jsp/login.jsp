<%-- 
    Document   : login
    Created on : 15/10/2018, 15:49:22
    Author     : Giovana Borges
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html lang="pt-br">

    <head>
        <%@include file="/WEB-INF/jsp/estrutura/ImportBot.jsp"%>    
        
        <meta charset="UTF-8" />
        <title>Login</title>
    </head>

    <body>
        <%@include file="/WEB-INF/jsp/estrutura/cabecalho.jsp"%>
        <%@include file="/WEB-INF/jsp/estrutura/navbar.jsp"%>

        <div class="container-fluid col-md-8 col-md-offset-2">
            <div class="panel panel-primary">
                <div class="panel-heading">
                    Faça o login para comprar
                </div>
                <form:form action="validarLogin" id="validarLogin" commandName="Cliente" method="POST">
                    <div class="panel-body">
                        ${msg}
                        <br/>
                        <div class="row">
                            <div class="col-md-5 col-md-offset-1">
                                <div class="form-group input-group">
                                    <span class="input-group-addon">
                                        <span class="glyphicon glyphicon-user"></span>
                                    </span>
                                    <form:input path="email" id="usuario" type="text" class="form-control" placeholder="email ou CPF" />
                                </div>
                            </div>
                            <div class="col-md-5">
                                <div class="form-group input-group">
                                    <span class="input-group-addon">
                                        <span class="glyphicon glyphicon-asterisk"></span>
                                    </span>
                                    <form:input path="senha" type="password" class="form-control" id="senhaLogin" placeholder="senha" />
                                </div>
                            </div>
                        </div>
                        <br/>
                        <center>
                            <input type="submit" class="btn btn-primary" value="Enviar" id="enviar">
                            <input type="reset" class="btn btn-primary" value="Limpar" id="limpar">
                        </center>
                        <center>
                            <br/>
                            Não possui cadastro?<a href="cadastroCliente" class="btn btn-link">Clique aqui</a>
                        </center>
                        <br/>
                    </div>
                </form:form>
            </div>
        </div>
    </body>
</html>