$(document).ready(function () {
    $('select[name=estado]').on('change', function () {
        console.log('Console Ativo');
        $.ajax({
            contentType: "ISO-8859-1",
            type: 'GET',
            url: 'ServletListaCidade',
            data: 'codigoestado=' + $('select[name=estado]').val(),
            statusCode: {
                404: function () {
                    alert('Pagina não Encontrada');
                },
                500: function () {
                    alert('Erro no Servidor');
                }
            },
            success: function (dados) {
                $('select[name=cidade] option').remove();
                var pegadados = dados.split(":");
                if (dados == '')
                    $('select[name=cidade]').append('<option>Estado sem Cidade</option>');
                else {
                    for (var i = 0; i < pegadados.length - 1; i++) {
                        var codigocidade = pegadados[i].split("-")[0];
                        var nomecidade = pegadados[i].split("-")[1];
                        $('select[name=cidade]').append('<option value ="' + codigocidade + '">' + nomecidade + '</option>');
                    }
                }


            }


        })
    })
});