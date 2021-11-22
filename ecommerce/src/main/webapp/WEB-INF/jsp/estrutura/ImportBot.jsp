<%-- 
    Document   : ImportBot
    Created on : 15/10/2018, 15:13:12
    Author     : Giovana Borges
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!--Importações JavaScript-->
<script src="<%=request.getContextPath()%>/resources/JavaScript/jquery-3.3.1.js"></script>
<script src="<%=request.getContextPath()%>/resources/JavaScript/jquery.mask.js"></script>

<!--Importações Bootstrap-->
<script src="<%=request.getContextPath()%>/resources/Bootstrap/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/Bootstrap/css/bootstrap.min.css">

<!--Importações CSS-->
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/CSS/design.css">

<!--Tags para formulários-->
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!--Importações DataTable-->
<!--script src="<%=request.getContextPath()%>/resources/JavaScript/datatables.min.js"></script>
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/CSS/datatables.min.css"-->

<script src="<%=request.getContextPath()%>/resources/JavaScript/validaFormularios.js"></script>
<script src="<%=request.getContextPath()%>/resources/JavaScript/compra.js"></script>
<script src="<%=request.getContextPath()%>/resources/JavaScript/produto.js"></script>
<!---->

<!--%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>