<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <%@include file="/WEB-INF/jsp/estrutura/ImportBot.jsp"%>    

        <meta charset="UTF-8" />
        <title>Home</title>
    </head>

    <body>
        <%@include file="/WEB-INF/jsp/estrutura/cabecalho.jsp"%>
        <%@include file="/WEB-INF/jsp/estrutura/navbar.jsp"%>

        <div class="container col-md-8 col-md-offset-2">
            <div id="myCarousel" class="carousel slide" data-ride="carousel">
                <!-- Indicators -->
                <ol class="carousel-indicators">
                    <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
                    <li data-target="#myCarousel" data-slide-to="1"></li>                    
                </ol>

                <!-- Wrapper for slides -->
                <div class="carousel-inner">
                    <jsp:useBean id="recentesDAO" class="DAO.CadastroProdutoDAO">
                        <c:forEach var="recentes" varStatus="indice" items="${recentesDAO.getProdutosRecentes()}">
                            <c:if test="${indice.count == 1}">
                                <div class="item active">
                                    <form>
                                        <br>
                                        <br>
                                        <div class="col-md-2"></div>
                                        <div class="col-xs-3 col-md-3">
                                            <a href="compra?cod=${recentes.cod}" class="thumbnail">
                                                <img alt="100%x180" data-src="holder.js/100%x180" 
                                                     style="height: 150px; width: 95%; display: block;"
                                                     src="recuperarImagem?id=${recentes.getCod()}" data-holder-rendered="true">
                                            </a>
                                        </div>
                                        <br/><br/>                                      
                                        <label for="produto" class="col-md-1 control-label">Produto</label>
                                        <div class="form-horizontal">
                                            <div class="col-md-3">
                                                <c:out value="${recentes.nome}"></c:out>
                                                </div>                                            
                                            </div>
                                            <br/><br/>
                                            <label for="valor" class="col-md-1 control-label">Preço</label>
                                            <div class="form-horizontal">
                                                <div class="col-md-3">
                                                <c:set var="valor" value="${recentes.valor}"/>
                                                <fmt:setLocale value="pt-BR" />
                                                <fmt:formatNumber value="${valor}" type="currency"/>                                                  
                                            </div>         
                                        </div>                                        
                                        </form>
                                    </div>
                            </c:if>
                            <c:if test="${indice.count != 1}">
                                <div class="item">
                                    <form>
                                        <br>
                                        <br>
                                        <div class="col-md-2"></div>
                                        <div class="col-xs-3 col-md-3">
                                            <a href="compra?cod=${recentes.cod}" class="thumbnail">
                                                <img alt="100%x180" data-src="holder.js/100%x180" 
                                                     style="height: 150px; width: 95%; display: block;"
                                                     src="recuperarImagem?id=${recentes.getCod()}" data-holder-rendered="true">
                                            </a>
                                        </div>
                                        <br/><br/>                                      
                                        <label for="produto" class="col-md-1 control-label">Produto</label>
                                        <div class="form-horizontal">
                                            <div class="col-md-3">
                                                <c:out value="${recentes.nome}"></c:out>
                                                </div>                                            
                                            </div>
                                            <br/><br/>
                                            <label for="valor" class="col-md-1 control-label">Preço</label>
                                            <div class="form-horizontal">
                                                <div class="col-md-3">
                                                <c:set var="valor" value="${recentes.valor}"/>
                                                <fmt:setLocale value="pt-BR" />
                                                <fmt:formatNumber value="${valor}" type="currency"/>      
                                            </div>         
                                        </div>                                             
                                        <!--br/>
                                        <br/>
                                        <label for="modificacao" class="col-md-1 control-label">Data</label>
                                        <div class="form-horizontal">
                                            <div class="col-md-3">
                                                <!--c:out value="${recentes.modificacao}"><!/c:out> 
                                                </div>
                                            </div-->
                                        </form>
                                    </div>
                            </c:if>
                        </c:forEach>
                    </jsp:useBean>
                </div>
                <!-- Left and right controls -->
                <a class="left carousel-control" href="#myCarousel" data-slide="prev">
                    <span class="glyphicon glyphicon-chevron-left"></span>
                    <span class="sr-only">Previous</span>
                </a>
                <a class="right carousel-control" href="#myCarousel" data-slide="next">
                    <span class="glyphicon glyphicon-chevron-right"></span>
                    <span class="sr-only">Next</span>
                </a>
            </div>
        </div>

        <br>
        <br>
        <div class="col-md-8 col-md-offset-2">
            <br>            
            <center><h3>Filtrar produtos pela categoria</h3></center>
                <jsp:useBean id="categoriaDAO" class="DAO.CategoriaDAO">                    
                <select id="filtro" class="col-md-1 form-control" name="Categoria" onchange="filtrar()">
                    <option value="0">Todos</option>
                    <c:forEach var="categorias" items="${categoriaDAO.getCategoria()}">
                        <option value="${categorias.id}">${categorias.nome}</option>
                    </c:forEach>
                </select>
            </jsp:useBean>
        </div>

        <div class="container-fluid col-md-8 col-md-offset-2">
            <br>
            <br>
            <div class="panel panel-default" id=mostrar_por_categoria>
                <div class="panel-body">
                    <ul class="list-group">
                        <jsp:useBean id="produtoByCategoria" class="DAO.CadastroProdutoDAO">
                            <c:forEach var="produto" items="${produtoByCategoria.getAll()}">
                                <div class="column">
                                    <span class="glyphicon glyphicon-shopping-cart" aria-hidden="true"></span>
                                    <label>&nbsp&nbspNome:</label> ${produto.nome}
                                </div>
                                <div class="column">
                                    <label>Preço:</label> 
                                    <c:set var="valor" value="${produto.valor}"/>
                                    <fmt:setLocale value="pt-BR" />
                                    <fmt:formatNumber value="${valor}" type="currency"/>       
                                </div>
                                <div class="column">
                                    <a href="compra?cod=${produto.cod}" class="btn btn-default">Comprar</a>
                                </div>
                                <br>
                                <br>
                            </c:forEach>
                        </jsp:useBean>                                           
                    </ul>
                </div>                
            </div>
        </div>
        <br>
    </body>

</html>