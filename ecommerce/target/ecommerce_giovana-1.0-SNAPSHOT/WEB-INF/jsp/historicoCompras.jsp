<%-- 
    Document   : historicoCompras
    Created on : 05/12/2018, 10:53:59
    Author     : Giovana Borges
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <%@include file="/WEB-INF/jsp/estrutura/ImportBot.jsp"%>  
        
         <!--Importações DataTable-->
        <script src="<%=request.getContextPath()%>/resources/JavaScript/datatables.min.js"></script>
        <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/CSS/datatables.min.css">


        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Histórico de Compras</title>
    </head>
    <body>
        <%@include file="/WEB-INF/jsp/estrutura/cabecalho.jsp"%>
        <%@include file="/WEB-INF/jsp/estrutura/navbar.jsp"%>
        <center><h2>Histórico de compras</h2></center>
        <div class="col-md-10 col-md-offset-1">
            ${msg}
            <table id="historico" class="display cell-border bg-info stripe" style="width:100%">
                <thead>
                    <tr>
                        <th>Produto</th>                        
                        <th>Valor Unitário</th>
                        <th>Quantidade</th>
                        <th>Total da compra</th>
                        <th>Data da Compra</th>                        
                    </tr>
                </thead>                
            </table>
        </div>    
    </body>
</html>