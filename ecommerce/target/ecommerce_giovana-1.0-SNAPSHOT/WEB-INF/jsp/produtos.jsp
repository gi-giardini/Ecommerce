<%-- 
    Document   : produtos
    Created on : 21/11/2018, 10:01:56
    Author     : Giovana Borges
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="/WEB-INF/jsp/estrutura/ImportBot.jsp"%>    

        <!--Importações DataTable-->
        <script src="<%=request.getContextPath()%>/resources/JavaScript/datatables.min.js"></script>
        <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/CSS/datatables.min.css">

        <meta charset="UTF-8" />
        <title>Produtos</title>
    </head>
    <body>
        <%@include file="/WEB-INF/jsp/estrutura/cabecalho.jsp"%>
        <%@include file="/WEB-INF/jsp/estrutura/navbar.jsp"%>

        <div class="col-md-10 col-md-offset-1">
            ${msg}
            <table id="tabela_produtos" class="display cell-border bg-info stripe" style="width:100%">
                <thead>
                    <tr>
                        <th>Código</th>
                        <th>Nome</th>
                        <th>Categoria</th>
                        <th>Preço</th>
                        <th>Descrição</th>
                        <th>Estoque</th>
                        <th>Última Modificação</th>
                        <th>Editar</th>
                        <th>Excluir</th>
                    </tr>
                </thead>                
            </table>
            <center><a href="cadastroProduto" class="btn btn-primary">Novo</a></center>
        </div>
    </body>
</html>
