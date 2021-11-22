/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function () {
    $('#tabela_produtos').dataTable({
        "ajax": "grid",
        "columns": [
            {"data": "cod"},
            {"data": "nome"},
            {"data": "categoria"},
            {"data": "valor"},
            {"data": "descricao"},
            {"data": "estoque"},
            {"data": "modificacao"},
            {"data": "editar"},
            {"data": "excluir"}
        ]
    });
});

function filtrar() {
    var categoria = $('#filtro').val();
    var i = 0;

    $.ajax({
        type: "GET",
        url: "mostrarPorCategoria",
        data: "idCategoria=" + categoria,
        success: function (data) {
            $("#mostrar_por_categoria").empty();
            var tamanho = data["data"].length;
            if (tamanho == 0) {
                $("#mostrar_por_categoria").append("<div class=\"panel panel-default\"><div class=\"panel-body\"><label>Nenhum produto encontrado nessa categoria</label><\div><\div>");
            } else {
                for (i = 0; i < tamanho; i++) {
                    var valor = data["data"][i].valor;
                    /*var valor = Number(valor);
                    valor = valor.toFixed(2);
                    valor = valor.replace('.', ',');*/
                    var cod = data["data"][i].cod;
                    var nome = data["data"][i].nome;
                    $("#mostrar_por_categoria").append("<div class=\"panel-body\"><div class=\"column\"><span class=\"glyphicon glyphicon-shopping-cart\" aria-hidden=\"true\"></span><label>&nbsp&nbspNome:&nbsp</label>" + nome + "</div><div class=\"column\"><label>Preço:&nbsp</label>" + valor + "</div><div class=\"column\"><a href=\"compra?cod=" + cod + "\" class=\"btn btn-default\">Comprar</a></div></div>");
                }
            }
        }
    });
};