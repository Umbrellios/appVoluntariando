<%-- 
    Document   : altera_voluntario
    Created on : 04/06/2017, 16:29:15
    Author     : Home
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Voluntariando</title>
    </head>
    <body>
        <h1>Avaliação de Instituição</h1>
        <form method="post" name="CadastraAvaliacao" action="ServletCadastraAvaliacaoInst">
            <label>Nome</label>
            <input name="inst_nome" type="text" value="${inst.nome }"/><br><br>
            <label>Nota da Instiuição</label>
            <select name="inst_nota">
                <option value="0">0</option>
                <option value="2">2</option>
                <option value="4">4</option>
                <option value="6">6</option>
                <option value="8">8</option>
                <option value="10">10</option>
            </select><br><br>
            <input type="hidden" name="inst_cod" value="${inst.cod}"/>
            <input type="hidden" name="vol_cod" value="${user.cod}"/>
            <input type="submit" value="Avaliar">
            <input type="button" value="Cancelar" onClick="window.open('instituicoes.jsp')"/>
            
        </form>

    </body>
</html>
