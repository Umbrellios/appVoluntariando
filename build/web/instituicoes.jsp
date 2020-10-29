<%-- 
    Document   : instituicoes
    Created on : 08/06/2017, 11:24:45
    Author     : Home
--%>

<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Voluntariando</title>
    </head>
    <body>
        <h1>Instituições</h1>

        <table border="1">
            <tr>
                <th><div>Nome</div></th>
                <th><div>CNPJ</div></th>
                <th><div>Email</div></th>
                <th><div>Telefone</div></th>
                <th><div>Endereço</div></th>
                <th><div>Responsável</div></th>
                <th><div>Tipo da Instituição</div></th>
                <th><div>Avaliar</div></th>
                <th><div>Atualizar</div></th>
            </tr>

            <%
                try {

                    Class.forName("org.postgresql.Driver");

                    Connection con = DriverManager.getConnection("jdbc:postgresql://localhost/postgres", "postgres", "postgres");

                    Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                            ResultSet.CONCUR_READ_ONLY);

                    ResultSet rs = null;

                    rs = st.executeQuery("select * from instituicao where inst_autorizacao = 1");

                    while (rs.next()) {%> 
            <tr>
                <td><p><%=rs.getString("inst_nome")%></p></td>
                <td><p><%=rs.getString("inst_cnpj")%></p></td>
                <td><p><%=rs.getString("inst_email")%></p></td>
                <td><p><%=rs.getString("inst_tel")%></p></td>
                <td><p><%=rs.getString("inst_end")%></p></td>
                <td><p><%=rs.getString("inst_resp")%></p></td>
                <td><p><%=rs.getString("inst_tipo")%></p></td>
                 
      

       <td><a id="link" href="ServletBuscaInstituicao?inst_cod=<%=rs.getInt("pk_inst_cod")%>">Avaliar</a></td>
       <td><a id="link" href="ServletBuscaAvaliaInst?inst_cod=<%=rs.getInt("pk_inst_cod")%>">Atualizar</a></td>
            </tr>
            <%          }
                } catch (ClassNotFoundException erroClass) {
                    out.println("Classe Driver JDBC não foi localizado, erro = " + erroClass);
                } catch (SQLException erroSQL) {
                    out.println("Erro de conexão com o Banco de dados, erro = " + erroSQL);
                }
            %>
            

        </table><br><br>
            <a href="javascript:window.history.go(-1)">Voltar</a>
    </body>
</html>
