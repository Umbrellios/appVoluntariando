<%-- 
    Document   : altera_voluntario
    Created on : 01/06/2017, 16:35:01
    Author     : Home
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="model.dao.DaoUsuario"%>
<%@page import="java.util.List"%>
<%@page import="classes.Voluntarios"%>
<%@page import="classesDao.VoluntarioDAO"%>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="ISO-8859-1">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Voluntariando <--> Voluntario</title>
        <link href="assets/css/bootstrap.min.css" rel="stylesheet">
        <link href="assets/css/font-awesome.min.css" rel="stylesheet">
        <link href="assets/css/datepicker3.css" rel="stylesheet">
        <link href="assets/css/styles.css" rel="stylesheet">
        <script src="assets/js/jquery2.min.js"></script>
        <script src="assets/js/bootstrap.min.js"></script>
        <script type="text/javascript" src="assets/js/lista_estado_cidade.js"></script>
        <script type="text/javascript" src="assets/js/jquery-1.7.1.js"></script>

        <!--Custom Font-->
        <link href="https://fonts.googleapis.com/css?family=Montserrat:300,300i,400,400i,500,500i,600,600i,700,700i" rel="stylesheet">
        <!--[if lt IE 9]>
        <script src="js/html5shiv.js"></script>
        <script src="js/respond.min.js"></script>
        <![endif]-->
    </head>
    <body>
        <nav class="navbar navbar-custom navbar-fixed-top" role="navigation">
            <div class="container-fluid">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#sidebar-collapse"><span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span></button>
                    <a class="navbar-brand" href="#"><span>Volunta</span>riando</a>
                    
                    
                </div>
            </div><!-- /.container-fluid -->
        </nav>
        

        <div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">
            <div class="row">
                <ol class="breadcrumb">
                    <li><a href="#">
                            <em class="fa fa-home"></em>
                        </a></li>
                    <li class="active">Novo Cadastro</li>
                </ol>
            </div><!--/.row-->

            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Cadastro de Voluntario</h1>
                </div>
            </div><!--/.row-->


            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                    </div><!-- /.panel-->


                    <div class="panel panel-default">
                        <div class="panel-heading">Voluntario</div>
                        <div class="panel-body">
                            <div class="col-md-4">
                                <form role="form" method="post" name="AtualizaVoluntario" action="ServletCadastraVoluntario">
                                    
                                    <div class="form-group">
                                        <label>Nome</label>
                                        <input class="form-control" name="vol_nome"/>

                                    </div>
                                    <div class="form-group">
                                        <label>Email</label>
                                        <input class="form-control" name="vol_email"/>
                                    </div>
                                    <div class="form-group">
                                        <label>Especialidade 1</label>
                                        <select class="form-control" name="vol_espec" id="vol_espec">
                                            <option value="1"></option>
                                            <c:forEach var="listaEspecialidades" items="${listaEspecialidades}">
                                                <option value="${listaEspecialidades.codigo}">${listaEspecialidades.especialidade}</option> 
                                            </c:forEach>
                                        </select>
                                    </div>
                                    <div class="form-group" style="width:166%">
                                        <label>Endereço</label>
                                        <input class="form-control" name="vol_endereco"/>
                                    </div>
                                    <div class="form-group">
                                        <label>Cidade</label>
                                        <select name="cidade" id="cidade"class="form-control">
                                            <option selected="${user.id_cidade}" value="${user.id_cidade}"></option>
                                        </select>
                                    </div>
                                    <div class="form-group">
                                        <label> Nova Senha </label>
                                        <input type="password"  requerid placeholder="Insira a nova Senha" class="form-control" id="vol_senha" name="vol_senha"/>
                                    </div>
                                    <div class class="form-group">
                                        <label> Digite Novamente </label>
                                        <input type="password" class="form-control" required placeholder="Repita a Senha" name="repetir_senha" oninput="validaSenha(this)"/>
                                    </div>
                                    <div class="form-group" style="width:166%">
                                        <label>Quem Sou</label>
                                        <textarea class="form-control" cols="50" rows="5" style="resize: none" name="vol_descricao" id="vol_descricao">${user.descricao}</textarea>
                                    </div>
                                    <a href="login.jsp" class="btn btn-primary">Cancelar</a>
                                    <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal_cadastro">Confirmar Cadastro</button>
                                    <div class="modal fade" id="myModal_cadastro" role="dialog">
                                        <div class="modal-dialog">
                                            <div class="modal-content">
                                                <div class="modal-header">
                                                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                                                    <h4 class="modal-title">Confirmação</h4>
                                                </div>
                                                <div class="modal-body">
                                                    <p>Os dados inseridos estão corretos?</p>
                                                    <input type="submit" class="btn btn-primary" value="Sim, confirme meu cadastro."/>
                                                </div>
                                                <div class="modal-footer">
                                                    <button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                            </div>
                            <div class="col-md-4" style="width:213.333333px">
                                <div class="form-group">
                                    <div class="form-group">
                                        <label>CPF</label>
                                        <input type="text" class="form-control" name="vol_cpf"/>
                                    </div>
                                    <div class="form-group">
                                        <label>Data de Nascimento</label>
                                        <input type="date" class="form-control" name="vol_dtnasc"/>
                                    </div>
                                    <div class="form-group">
                                        <label>Especialidade 2</label>
                                        <select class="form-control" name="vol_espec" id="vol_espec">
                                            <option value="1"></option>
                                            <c:forEach var="listaEspecialidades" items="${listaEspecialidades}">
                                                <option value="${listaEspecialidades.codigo}">${listaEspecialidades.especialidade}</option> 
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-4" style="width:213.333333px">
                                <div class="form-group">
                                    <div class="form-group">
                                        <label>RG</label>
                                        <input type="text" class="form-control" name="vol_rg"/>

                                    </div>
                                    <div class="form-group">
                                        <label>Telefone</label>
                                        <input type="text" class="form-control" name="vol_telefone"/>
                                    </div>
                                    <div class="form-group">
                                        <label>Especialidade 3</label>
                                        <select class="form-control" name="vol_espec" id="vol_espec">
                                            <option value="1"></option>
                                            <c:forEach var="listaEspecialidades" items="${listaEspecialidades}">
                                                <option value="${listaEspecialidades.codigo}">${listaEspecialidades.especialidade}</option> 
                                            </c:forEach>
                                        </select>
                                    </div>
                                    <div class="form-group">
                                        <label>Estado</label>
                                        <select name="estado" id="estado" class="form-control">
                                                <c:forEach var="lista" items="${listaEstado}">
                                                <option value="${lista.getEstado().getId()}">${lista.getEstado().getNome()}</option> 
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>
                            </div>

                        </div>

                    </div>

                </div>
                </form>
            </div>
        </div>
    </div><!-- /.panel-->
</div><!-- /.col-->

</div><!-- /.row -->
</div><!--/.main-->
</body>
</html>
<script>
    function validaSenha(input) {
        if (input.value != document.getElementById('vol_senha').value) {
            input.setCustomValidity('Repita a senha corretamente');
        } else {
            input.setCustomValidity('');
        }
    }
</script>


