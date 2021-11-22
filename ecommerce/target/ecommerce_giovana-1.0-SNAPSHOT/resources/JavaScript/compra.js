/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function comprar() {
    var valor_unitario = $('#valor').val();
    var quant = $('#quant').val();
    var total = valor_unitario * quant;

    valor_unitario = Number(valor_unitario);
    valor_unitario = valor_unitario.toFixed(2);
    valor_unitario = valor_unitario.replace('.', ',');
    
    total = Number(total);
    total = total.toFixed(2);
    total = total.replace('.', ',');
    
    $("#modal").empty();
    $("#modal").append("<div><p>Preço: " + valor_unitario + "</p><p>Quantidade: " + quant + "</p><p>Valor total da compra: " + total + "</p></<div>");
}

$(document).ready(function () {
    $("#quant").mask('0000', {reverse: true});
    $('#compra').submit(function (e) {
        //alert("Compra realizada");
    });
});

$(document).ready(function () {
    $('#historico').dataTable({
        "ajax": "histCompras",
        "columns": [
            {"data": "nome"},
            {"data": "valor"},
            {"data": "quant"},
            {"data": "total"},
            {"data": "modificacao"},
        ]
    });
});


