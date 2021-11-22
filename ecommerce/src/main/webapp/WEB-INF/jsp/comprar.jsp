<%-- 
    Document   : comprar
    Created on : 26/11/2018, 16:40:11
    Author     : Giovana Borges
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html lang="pt-br">    
    <head>
        <%@include file="/WEB-INF/jsp/estrutura/ImportBot.jsp"%>  

        <meta charset="UTF-8" />
        <title>Comprar</title>    
    </head>

    <body>
        <%@include file="/WEB-INF/jsp/estrutura/cabecalho.jsp"%>
        <%@include file="/WEB-INF/jsp/estrutura/navbar.jsp"%>

        <div class="container-fluid col-md-8 col-md-offset-2">
            <div class="panel panel-primary">
                <div class="panel-heading">
                    ${Produto.getNome()}
                </div>
                <form action="realizarCompra" id="compra" method="POST">
                    <div class="panel-body">                                            
                        ${msg}
                        <div class="row"> 
                            <div class="col-xs-1 col-md-3">
                                <a href="#" class="thumbnail">
                                    <img alt="100%x180" data-src="holder.js/100%x180" 
                                         style="height: 150px; width: 95%; display: block;"
                                         src="recuperarImagem?id=${Produto.getCod()}" data-holder-rendered="true">
                                </a>
                            </div>
                            <br/>
                            <br/>
                            <div class="form-group">
                                <label id="produto" for="produto" class="col-md-1 control-label">Nome</label>
                                <div class="col-md-3">
                                    ${Produto.getNome()}
                                </div>
                                <input name="cod" value="${Produto.getCod()}" type="hidden" class="form-control">
                                <label for="categoria" class="col-md-1 control-label">Categoria</label>
                                <div class="col-md-3">
                                    ${Produto.getCategoria().getNome()}
                                </div>
                            </div>
                            <br/>
                            <br/>
                            <div class="form-group">
                                <label for="valor" class="col-md-1 control-label">Preço</label>
                                <div class="col-md-3">
                                    <c:set var="valor" value="${Produto.getValor()}"/>
                                    <fmt:setLocale value="pt-BR" />
                                    <fmt:formatNumber value="${valor}" type="currency"/>                                    
                                    <input id="valor" name="valor" type="hidden" value="${Produto.getValor()}" class="form-control">
                                </div>
                                <c:if test="${Produto.getQuantEstoque() == 0}"><!--Produto indisponível-->
                                    <label for="quant" class="col-md-1 control-label">Produto indisponível</label>
                                </c:if>
                                <c:if test="${Produto.getQuantEstoque() != 0}">
                                    <label for="quant" class="col-md-1 control-label">Unidades</label>
                                    <div class="col-md-3">                                    
                                        <input name="quant" id="quant" type="text" value="1" min="1" max="${Produto.getQuantEstoque()}" class="form-control">
                                    </div>                                    
                                </c:if>
                            </div>
                        </div>
                        <br/>
                        <div class="form-horizontal">
                            <label for="descricao" class="col-md-2 control-label">Descrição</label>
                            <div class="col-md-9">
                                ${Produto.getDescricao()}
                            </div>
                        </div>
                    </div>
                    <br/>
                    <center>
                        <c:if test="${Produto.getQuantEstoque() == 0}">
                            <a href="index" class="btn btn-primary">Voltar</a>
                        </c:if>
                        <c:if test="${Produto.getQuantEstoque() != 0}">
                            <c:if test="${sessionScope['usuarioLogado'] == null}">
                                Faça o login para comprar <a href="login"> Clique aqui</a>                            
                            </c:if>
                            <c:if test="${sessionScope['usuarioLogado'] != null}">
                                <center>
                                    <!-- Trigger the modal with a button -->
                                    <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal" onclick="comprar()">Comprar</button>

                                    <!-- Modal -->
                                    <div class="modal fade" id="myModal" role="dialog">
                                        <div class="modal-dialog">
                                            <!-- Modal content-->
                                            <div class="modal-content">
                                                <div class="modal-header">
                                                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                                                    <h4 class="modal-title">${Produto.getNome()}</h4>
                                                </div>
                                                <div class="modal-body" id="modal">
                                                    <p>Dados da compra</p>
                                                </div>
                                                <div class="modal-footer">
                                                    <input type="submit" class="btn btn-primary" value="Comprar" id="compra">
                                                    <button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </center>
                            </c:if>
                        </c:if>
                    </center>
                    <br>
                </form>
            </div>
        </div>                
    </body>

</html>