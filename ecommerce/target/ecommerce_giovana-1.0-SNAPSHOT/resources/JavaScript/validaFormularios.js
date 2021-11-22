/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//alert("Sua senha é: " +senha);

$(document).ready(function () {
    $('#cpf').mask('000.000.000-00', {reverse: true});
    $('#cadastroCliente').submit(function (e) {
        var erro = false;
        var nome = $('#nome').val();
        var email = $('#email').val();
        var cpf = $('#cpf').val();
        var senha = $('#senha').val();
        var rua = $('#rua').val();
        var bairro = $('#bairro').val();
        var num = $('#num').val();
        var cidade = $('#cidade').val();
        var uf = $('#uf').val();
        var confirmaSenha = $('#confirmaSenha').val();       
        if (nome == '') {
            $('#nome').css("border-color", "red");
            $('#nome').css("border-width", "2px");
            $('#nome').focus();
            erro = true;
        } else {
            $('#nome').css("border-color", "#ccc");
            $('#nome').css("border-width", "1px");
        }
        if (email == '') {
            $('#email').css("border-color", "red");
            $('#email').css("border-width", "2px");
            $('#email').focus();
            erro = true;
        } else {
            $('#email').css("border-color", "#ccc");
            $('#email').css("border-width", "1px");
        }
        if (cpf == '') {
            $('#cpf').css("border-color", "red");
            $('#cpf').css("border-width", "2px");
            $('#cpf').focus();
            erro = true;
        } else {
            $('#cpf').css("border-color", "#ccc");
            $('#cpf').css("border-width", "1px");
        }
        if (senha == '') {
            $('#senha').css("border-color", "red");
            $('#senha').css("border-width", "2px");
            $('#senha').focus();
            erro = true;
        } else {
            $('#senha').css("border-color", "#ccc");
            $('#senha').css("border-width", "1px");
        }
        if (confirmaSenha != senha || confirmaSenha == '') {
            $('#confirmaSenha').css("border-color", "red");
            $('#confirmaSenha').css("border-width", "2px");
            $('#confirmaSenha').focus();
            erro = true;
        } else {
            $('#confirmaSenha').css("border-color", "#ccc");
            $('#confirmaSenha').css("border-width", "1px");
        }
        if (rua == '') {
            $('#rua').css("border-color", "red");
            $('#rua').css("border-width", "2px");
            $('#rua').focus();
            erro = true;
        } else {
            $('#rua').css("border-color", "#ccc");
            $('#rua').css("border-width", "1px");
        }
        if (bairro == '') {
            $('#bairro').css("border-color", "red");
            $('#bairro').css("border-width", "2px");
            $('#bairro').focus();
            erro = true;
        } else {
            $('#bairro').css("border-color", "#ccc");
            $('#bairro').css("border-width", "1px");
        }
        if (num == '') {
            $('#num').css("border-color", "red");
            $('#num').css("border-width", "2px");
            $('#num').focus();
            erro = true;
        } else {
            $('#num').css("border-color", "#ccc");
            $('#num').css("border-width", "1px");
        }
        if (cidade == '') {
            $('#cidade').css("border-color", "red");
            $('#cidade').css("border-width", "2px");
            $('#cidade').focus();
            erro = true;
        } else {
            $('#cidade').css("border-color", "#ccc");
            $('#cidade').css("border-width", "1px");
        }        
        if (erro) {
            e.preventDefault();
        }
    });
});

$(document).ready(function () {
    $('#validarLogin').submit(function (e) {
        var erro = false;
        var usuario = $('#usuario').val();
        var senhaLogin = $('#senhaLogin').val();
        if (usuario == '') {
            $('#usuario').css("border-color", "red");
            $('#usuario').css("border-width", "2px");
            $('#usuario').focus();
            erro = true;
        } else {
            $('#usuario').css("border-color", "#ccc");
            $('#usuario').css("border-width", "1px");
        }
        if (senhaLogin == '') {
            $('#senhaLogin').css("border-color", "red");
            $('#senhaLogin').css("border-width", "2px");
            $('#senhaLogin').focus();
            erro = true;
        } else {
            $('#senhaLogin').css("border-color", "#ccc");
            $('#senhaLogin').css("border-width", "1px");
        }
        if (erro) {
            e.preventDefault();
        }
    });
});

$(document).ready(function () {
    $('#quant').mask('000000', {reverse: true});
    $('#valor').mask('000,000.00', {reverse: true});
    $('#cadastroProduto').submit(function (e) {
        var erro = false;
        var produto = $('#produto').val();
        var descricao = $('#descricao').val();
        var valor = $('#valor').val();
        var estoque = $('#quant').val();
        var dataModificacao = $('#modifica').val();
        var foto = $('#foto').val();
        if (produto == '') {
            $('#produto').css("border-color", "red");
            $('#produto').css("border-width", "2px");
            $('#produto').focus();
            erro = true;
        } else {
            $('#produto').css("border-color", "#ccc");
            $('#produto').css("border-width", "1px");
        }
        if (descricao == '') {
            $('#descricao').css("border-color", "red");
            $('#descricao').css("border-width", "2px");
            $('#descricao').focus();
            erro = true;
        } else {
            $('#descricao').css("border-color", "#ccc");
            $('#descricao').css("border-width", "1px");
        }
        if (valor == '') {
            $('#valor').css("border-color", "red");
            $('#valor').css("border-width", "2px");
            $('#valor').focus();
            erro = true;
        } else {
            $('#valor').css("border-color", "#ccc");
            $('#valor').css("border-width", "1px");
        }
        if (estoque == '') {
            $('#quant').css("border-color", "red");
            $('#quant').css("border-width", "2px");
            $('#quant').focus();
            erro = true;
        } else {
            $('#quant').css("border-color", "#ccc");
            $('#quant').css("border-width", "1px");
        }
        if (dataModificacao == '') {
            $('#modifica').css("border-color", "red");
            $('#modifica').css("border-width", "2px");
            $('#modifica').focus();
            erro = true;
        } else {
            $('#modifica').css("border-color", "#ccc");
            $('#modifica').css("border-width", "1px");
        }
        if (foto == '') {
            $('#foto').css("border-color", "red");
            $('#foto').css("border-width", "2px");
            $('#foto').focus();
            erro = true;
            alert("Insira uma imagem.");
        } else {
            $('#foto').css("border-color", "#ccc");
            $('#foto').css("border-width", "1px");
        }
        if (erro) {
            e.preventDefault();
        }
    });
});