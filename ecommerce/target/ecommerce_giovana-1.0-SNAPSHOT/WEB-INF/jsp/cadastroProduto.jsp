<%-- 
    Document   : cadastroProduto
    Created on : 19/10/2018, 14:29:16
    Author     : Giovana Borges
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html lang="pt-br">    
    <head>
        <%@include file="/WEB-INF/jsp/estrutura/ImportBot.jsp"%>               

        <meta charset="UTF-8" />
        <title>Cadastro de Produtos</title>    
    </head>

    <body>
        <%@include file="/WEB-INF/jsp/estrutura/cabecalho.jsp"%>
        <%@include file="/WEB-INF/jsp/estrutura/navbar.jsp"%>

        <div class="container-fluid col-md-8 col-md-offset-2">
            <div class="panel panel-primary">
                <div class="panel-heading">
                    <c:if test="${Produto.getCod() == 0}">
                        Cadastro de Produtos                    
                    </c:if>
                    <c:if test="${Produto.getCod() != 0}">
                        ${Produto.getNome()}
                    </c:if>
                </div>
                <form:form action="salvarProduto" id="cadastroProduto" commandName="Produto" method="POST" enctype="multipart/form-data">
                    <div class="panel-body">
                        ${msg}                     
                        <div class="row"> 
                            <div class="col-xs-1 col-md-3">
                                <a class="thumbnail">
                                    <c:if test="${Produto.getCod() == 0}">
                                        <img alt="100%x180" data-src="holder.js/100%x180" 
                                             style="height: 150px; width: 95%; display: block;"
                                             >
                                    </c:if>
                                    <c:if test="${Produto.getCod() != 0}">
                                        <img alt="100%x180" data-src="holder.js/100%x180" 
                                             style="height: 150px; width: 95%; display: block;"
                                             src="recuperarImagem?id=${Produto.getCod()}" data-holder-rendered="true">
                                        <form:input id="imagem" path="imagem" type="hidden" name="imagem" class="form-control"/>
                                    </c:if>
                                    <input id="foto" type="file" name="file"/>
                                </a>
                            </div>
                            <br/>
                            <br/>
                            <div class="form-group">
                                <input name="cod" value="${Produto.getCod()}" type="hidden" class="form-control">
                                <label for="produto" class="col-md-1 control-label">Nome</label>
                                <div class="col-md-3">
                                    <form:input id="produto" path="nome" type="text" name="produto" class="form-control"/>
                                </div>
                                <label for="categoria" class="col-md-1 control-label">Categoria</label>
                                <div class="col-md-3">
                                    <jsp:useBean id="categoriaDAO" class="DAO.CategoriaDAO">
                                        <form:select class="col-md-2 form-control" name="Categoria" path="categoria.id">
                                            <form:options items="${categoriaDAO.getCategoria()}" itemValue="id" itemLabel="nome"></form:options>
                                        </form:select>
                                    </jsp:useBean>
                                </div>
                            </div>
                            <br/>
                            <br/>
                            <div class="form-group">
                                <label for="valor" class="col-md-1 control-label">Preço</label>
                                <div class="col-md-3">
                                    <form:input id="valor" path="valor" type="text" placeholder="" name="valor" class="form-control"/>
                                </div>                                 
                                <label for="quant" class="col-md-1 control-label">Estoque</label>
                                <div class="col-md-3">
                                    <c:if test="${Produto.getCod() == 0}">
                                        <form:input id="quant" path="quantEstoque" type="text" value="1" min="0" name="quant" class="form-control"/>
                                    </c:if>
                                    <c:if test="${Produto.getCod() != 0}">
                                        <form:input id="quant" path="quantEstoque" type="text" value="${Produto.getQuantEstoque()}" min="0" name="quant" class="form-control"/>
                                    </c:if>                                        
                                </div>
                            </div>
                        </div>
                        <br/>
                        <div class="form-horizontal">
                            <label for="descricao" class="col-md-2 control-label">Descrição</label>
                            <div class="col-md-9">
                                <form:input id="descricao" path="descricao" type="text" placeholder="" name="descricao" class="form-control"/>
                            </div>
                        </div>
                    </div>
                    <br/>
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
