<%-- 
    Document   : cadastro
    Created on : 15/10/2018, 17:06:42
    Author     : Giovana Borges
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html lang="pt-br">

    <head>
        <%@include file="/WEB-INF/jsp/estrutura/ImportBot.jsp"%>    
        
        <meta charset="UTF-8" />
        <title>Cadastro</title>    
    </head>

    <body>        
        <%@include file="/WEB-INF/jsp/estrutura/cabecalho.jsp"%>
        <%@include file="/WEB-INF/jsp/estrutura/navbar.jsp"%>

        <div class="container-fluid col-md-8 col-md-offset-2">
            <div class="panel panel-primary">                
                <div class="panel-heading">
                    <c:if test="${sessionScope['usuarioLogado'] == null}">
                        Faça seu cadastro                        
                    </c:if>
                    <c:if test="${sessionScope['usuarioLogado'] != null}">
                        Atualização de cadastro
                    </c:if>
                </div>
                <form:form action="salvarCliente" id="cadastroCliente" commandName="Cliente" method="POST">
                    <div class="panel-body">                       
                        ${msg}                        
                        <div class="form-horizontal">
                            <div class="form-group">
                                <label class="col-md-1 control-label">Nome</label>
                                <div class="col-md-11">
                                    <form:input id="nome" path="nome" type="text" class="form-control"/>
                                </div>
                            </div>
                        </div>
                        <div class="form-horizontal">
                            <div class="form-group">
                                <label class="col-md-1 control-label">Email</label>
                                <div class="col-md-5">
                                    <c:if test="${sessionScope['usuarioLogado'] == null}">
                                        <form:input id="email" path="email" type="text" placeholder="Ex:xxxxxx@gmail.com" class="form-control"/>
                                    </c:if>
                                    <c:if test="${sessionScope['usuarioLogado'] != null}">
                                        <form:input readonly="" id="email" path="email" type="text" class="form-control"/>
                                    </c:if>                                                                            
                                </div>
                                <label class="col-md-1 control-label">CPF</label>
                                <div class="col-md-5">
                                    <c:if test="${sessionScope['usuarioLogado'] == null}">
                                        <form:input id="cpf" path="cpf" type="text" class="form-control"/>
                                    </c:if>
                                    <c:if test="${sessionScope['usuarioLogado'] != null}">
                                        <form:input readonly="" id="cpf" path="cpf" type="text" class="form-control"/>
                                    </c:if>
                                </div>
                            </div>                            
                        </div>
                        <div class="form-horizontal">
                            <div class="form-group">                                
                                <label class="col-md-1 control-label">Senha</label>                                                                
                                <div class="col-md-5">
                                    <form:input id="senha" path="senha" type="password" class="form-control"/>
                                </div>                                
                                <label class="col-md-1 control-label">Confirmar Senha</label>
                                <div class="col-md-5">
                                    <input id="confirmaSenha" type="password" class="form-control">                                        
                                </div>
                            </div>
                        </div>
                        <div class="form-horizontal">
                            <div class="form-group">
                                <label class="col-md-1 control-label">Rua</label>
                                <div class="col-md-11">
                                    <form:input id="rua" path="rua" type="text" class="form-control"/>                                        
                                </div>
                            </div>
                        </div>
                        <div class="form-horizontal">
                            <div class="form-group">
                                <label class="col-md-1 control-label">Bairro</label>
                                <div class="col-md-5">
                                    <form:input id="bairro" path="bairro" type="text" class="form-control"/>                                        
                                </div>
                                <label class="col-md-1 control-label">Número</label>
                                <div class="col-md-5">
                                    <form:input id="num" path="num" type="text" class="form-control"/>                                        
                                </div>
                            </div>
                            <div class="form-horizontal">
                                <div class="form-group">
                                    <label class="col-md-1 control-label">Cidade</label>
                                    <div class="col-md-5">
                                        <form:input id="cidade" path="cidade" type="text" class="form-control"/>                                            
                                    </div>
                                    <!--label class="col-md-1 control-label">UF</label-->
                                    <!--div class="col-md-5">
                                    <!--form:input id="uf" path="estado" type="text" placeholder="Ex:SP" class="form-control"/-->                                
                                    <label class="col-md-1 control-label">Estado</label>
                                    <div class="col-md-5">
                                        <form:select class="col-md-5 form-control" id="uf" path="estado">
                                            <form:option value="Acre">AC</form:option>
                                            <form:option value="Alagoas">AL</form:option>
                                            <form:option value="Amapá">AP</form:option>
                                            <form:option value="Amazonas">AM</form:option>
                                            <form:option value="Bahia">BA</form:option>
                                            <form:option value="Ceará">CE</form:option>
                                            <form:option value="Distrito Federal">DF</form:option>
                                            <form:option value="Espírito Santo">ES</form:option>
                                            <form:option value="Goiás">GO</form:option>
                                            <form:option value="Maranhão">MA</form:option>
                                            <form:option value="Mato Grosso">MT</form:option>
                                            <form:option value="Mato Grosso do Sul">MS</form:option>
                                            <form:option value="Minas Gerais">MG</form:option>
                                            <form:option value="Pará">PA</form:option>
                                            <form:option value="Paraíba">PB</form:option>
                                            <form:option value="Paraná">PR</form:option>
                                            <form:option value="Pernambuco">PE</form:option>
                                            <form:option value="Piauí">PI</form:option>
                                            <form:option value="Rio de Janeiro">RJ</form:option>
                                            <form:option value="Rio Grande do Norte">RN</form:option>
                                            <form:option value="Rio Grande do Sul">RS</form:option>
                                            <form:option value="Rondônia">RO</form:option>
                                            <form:option value="Roraima">RR</form:option>
                                            <form:option value="Santa Catarina">SC</form:option>
                                            <form:option value="São Paulo">SP</form:option>
                                            <form:option value="Sergipe">SE</form:option>
                                            <form:option value="Tocantins">TO</form:option>
                                        </form:select>
                                    </div>
                                </div>
                            </div>                            
                        </div>
                    </div>
                    <center>
                        <input type="submit" class="btn btn-primary" value="Enviar" id="enviar">
                        <input type="reset" class="btn btn-primary" value="Limpar" id="limpar">
                    </center>
                    <br>
                </form:form>
            </div>                
        </div>
    </body>

</html>