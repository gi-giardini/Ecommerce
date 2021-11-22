<%-- 
    Document   : navbar
    Created on : 15/10/2018, 16:34:47
    Author     : Giovana Borges
--%>

<!-- Navbar-->
<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li>
                    <a class="item_cabecalho" href="index">
                        <span class="glyphicon glyphicon-home" aria-hidden="true"></span>
                        <span class="sr-only">(current)</span>
                        Home
                    </a>
                </li>
            </ul>
            <c:if test="${sessionScope['usuarioLogado'] == null}">
                <ul class="nav navbar-nav navbar-right">
                    <li>
                        <a class="item_cabecalho" href="login">Login
                            <span class="glyphicon glyphicon-user" aria-hidden="true"></span>
                            <span class="sr-only">(current)</span>
                        </a>
                    </li>
                </ul>                
            </c:if>
            <c:if test="${sessionScope['usuarioLogado'] != null}">
                <ul class="nav navbar-nav navbar-right">
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle item_cabecalho" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">${usuarioLogado.nome}
                            <span class="caret"></span>
                        </a>
                        <ul class="dropdown-menu">
                            <li>
                                <a class="item_cabecalho" href="perfil">
                                    <span class="glyphicon glyphicon-user" aria-hidden="true"></span>
                                    <span class="sr-only">(current)</span>
                                    Perfil
                                </a>
                            </li>                            
                            <li><a class="item_cabecalho" href="historicoCompras">
                                    <span class="glyphicon glyphicon-barcode" aria-hidden="true"></span>
                                    <span class="sr-only">(current)</span>
                                    Histórico de Compras
                                </a>
                            </li>                                                     
                            <li><a class="item_cabecalho" href="logout">
                                    <span class="glyphicon glyphicon-off" aria-hidden="true"></span>
                                    <span class="sr-only">(current)</span>
                                    Sair                                    
                                </a>
                            </li>
                        </ul>
                    </li>                    
                </ul>
                <c:if test="${usuarioLogado.isAdmin == true}">
                    <ul class="nav navbar-nav navbar-right">
                        <li>
                            <a class="item_cabecalho" href="produtos">
                                <span class="glyphicon glyphicon-shopping-cart" aria-hidden="true"></span>                                
                                <span class="sr-only">(current)</span>
                                Produtos
                            </a>
                        </li>
                    </ul>
                </c:if>   
            </c:if>
        </div>
        <!-- /.navbar-collapse -->
    </div>
    <!-- /.container-fluid -->
</nav>
<!-- Fim Navbar-->

</body>
