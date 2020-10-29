<%-- 
    Document   : altera_voluntario
    Created on : 01/06/2017, 16:35:01
    Author     : Home
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="model.dao.DaoUsuario"%>
<%@page import="java.util.List"%>
<%@page import="classes.Voluntarios"%>
<%@page import="classesDao.VoluntarioDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-15" pageEncoding="ISO-8859-1"%>


<!DOCTYPE html>
<html>
    <head>
       
        <meta charset="ISO-8859-1" Content-Type="text/html; charset=ISO-8859-1">
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
                    <ul class="nav navbar-top-links navbar-right">
                        <li class="dropdown"><a class="dropdown-toggle count-info" data-toggle="dropdown" href="#">
                                <em class="fa fa-envelope"></em><span class="label label-danger">15</span>
                            </a>
                            <ul class="dropdown-menu dropdown-messages">
                                <li>
                                    <div class="dropdown-messages-box"><a href="profile.html" class="pull-left">
                                            <img alt="image" class="img-circle" src="http://placehold.it/40/30a5ff/fff">
                                        </a>
                                        <div class="message-body"><small class="pull-right">3 mins ago</small>
                                            <a href="#"><strong>John Doe</strong> commented on <strong>your photo</strong>.</a>
                                            <br /><small class="text-muted">1:24 pm - 25/03/2015</small></div>
                                    </div>
                                </li>
                                <li class="divider"></li>
                                <li>
                                    <div class="dropdown-messages-box"><a href="profile.html" class="pull-left">
                                            <img alt="image" class="img-circle" src="http://placehold.it/40/30a5ff/fff">
                                        </a>
                                        <div class="message-body"><small class="pull-right">1 hour ago</small>
                                            <a href="#">New message from <strong>Jane Doe</strong>.</a>
                                            <br /><small class="text-muted">12:27 pm - 25/03/2015</small></div>
                                    </div>
                                </li>
                                <li class="divider"></li>
                                <li>
                                    <div class="all-button"><a href="#">
                                            <em class="fa fa-inbox"></em> <strong>All Messages</strong>
                                        </a></div>
                                </li>
                            </ul>
                        </li>
                        <li class="dropdown"><a class="dropdown-toggle count-info" data-toggle="dropdown" href="#">
                                <em class="fa fa-bell"></em><span class="label label-info">5</span>
                            </a>
                            <ul class="dropdown-menu dropdown-alerts">
                                <li><a href="#">
                                        <div><em class="fa fa-envelope"></em> 1 New Message
                                            <span class="pull-right text-muted small">3 mins ago</span></div>
                                    </a></li>
                                <li class="divider"></li>
                                <li><a href="#">
                                        <div><em class="fa fa-heart"></em> 12 New Likes
                                            <span class="pull-right text-muted small">4 mins ago</span></div>
                                    </a></li>
                                <li class="divider"></li>
                                <li><a href="#">
                                        <div><em class="fa fa-user"></em> 5 New Followers
                                            <span class="pull-right text-muted small">4 mins ago</span></div>
                                    </a></li>
                            </ul>
                        </li>
                    </ul>
                </div>
            </div><!-- /.container-fluid -->
        </nav>
        <div id="sidebar-collapse" class="col-sm-3 col-lg-2 sidebar">
            <div class="profile-sidebar">
                <div class="profile-userpic">
                    <img src="http://placehold.it/50/30a5ff/fff" class="img-responsive" alt="">
                </div>
                <div class="profile-usertitle">
                    <div class="profile-usertitle-name">${user.nome}</div>
                    <div class="profile-usertitle-status"><span class="indicator label-success"></span>Online</div>
                </div>
                <div class="clear"></div>
            </div>
            <div class="divider"></div>
            <form role="search">
                <div class="form-group">
                    <input type="text" class="form-control" placeholder="Search">
                </div>
            </form>
            <ul class="nav menu">
                <li><a href="dashboard.jsp"><em class="fa fa-dashboard">&nbsp;</em> Painel</a></li>
                <li><a href="assets/widgets.html"><em class="fa fa-calendar">&nbsp;</em> Participações</a></li>
                <li class="active"><a href="dados_voluntario.jsp"><em class="fa fa-toggle-off">&nbsp;</em> Dados Cadastrais</a></li>
                <li><a href="assets/panels.html"><em class="fa fa-clone">&nbsp;</em> Alertas</a></li>
                <li><a href="login.jsp"><em class="fa fa-power-off">&nbsp;</em> Logout</a></li>
            </ul>
        </div><!--/.sidebar-->

        <div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">
            <div class="row">
                <ol class="breadcrumb">
                    <li><a href="#">
                            <em class="fa fa-home"></em>
                        </a></li>
                    <li class="active">Conta</li>
                </ol>
            </div><!--/.row-->

            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Dados Cadastrais</h1>
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
                                <form role="form" method="post" name="AtualizaVoluntario" action="ServletAtualizaVoluntario">
                                    <input name="vol_cod" type="hidden" value="${user.cod}" />
                                    <div class="form-group">
                                        <label>Nome</label>
                                        <input class="form-control" name="vol_nome" value="${user.nome}"/>

                                    </div>
                                    <div class="form-group">
                                        <label>Email</label>
                                        <input class="form-control" name="vol_email" value="${user.email}"/>
                                    </div>
                                    <div class="form-group">
                                        <label>Especialidade 1</label>
                                        <select class="form-control" name="vol_espec" id="vol_espec">
                                            <option value="${user.especialidades.get(0).getCodigo()}">${ user.especialidades.get(0).getEspecialidade()}</option>
                                            <c:forEach var="listaEspecialidades" items="${listaEspecialidades}">
                                                <option value="${listaEspecialidades.codigo}">${listaEspecialidades.especialidade}</option> 
                                            </c:forEach>
                                        </select>
                                    </div>
                                            
                                    <div class="form-group" style="width:166%">
                                        <label>Endereço</label>
                                        <input class="form-control" name="vol_endereco" value="${user.getEndereco().getEndereco()}"/>
                                    </div>
                                    <div class="form-group">
                                        <label>Cidade</label>
                                        <select name="cidade" id="cidade"class="form-control">
                                            <option value="${user.getEndereco().getCidade().getId()}">${user.getEndereco().getCidade().getNome()}</option>
                                        </select>
                                    </div>
                                    <div class="form-group" style="width:166%">
                                        <label>Quem Sou</label>
                                        <textarea class="form-control" cols="50" rows="5" style="resize: none" name="vol_descricao" id="vol_descricao">${user.descricao}</textarea>
                                    </div>
                                    <a href="ServletDadosVoluntario" class="btn btn-primary">Cancelar</a>
                                    <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal">Confirmar Alterações</button>
                                    <div class="modal fade" id="myModal" role="dialog">
                                        <div class="modal-dialog">
                                            <div class="modal-content">
                                                <div class="modal-header">
                                                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                                                    <h4 class="modal-title">Confirmação</h4>
                                                </div>
                                                <div class="modal-body">
                                                    <p>Os dados alterados estão todos corretos?</p>
                                                    <input type="submit" class="btn btn-primary" value="Sim, confirme as alterações"/>
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
                                        <input type="text" class="form-control" name="vol_cpf" value="${user.cpf}"/>
                                    </div>
                                    <div class="form-group">
                                        <label>Data de Nascimento</label>
                                        <input type="date" class="form-control" name="vol_dtnasc" value="${user.dtnasc}"/>
                                    </div>
                                    <div class="form-group">
                                        <label>Especialidade 2</label>
                                        <select class="form-control" name="vol_espec" id="vol_espec">
                                            <option value="${user.especialidades.get(1).getCodigo()}">${ user.especialidades.get(1).getEspecialidade()}</option>
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
                                        <input type="text" class="form-control" name="vol_rg" value="${user.rg}"/>

                                    </div>
                                    <div class="form-group">
                                        <label>Telefone</label>
                                        <input type="text" class="form-control" name="vol_telefone" value="${user.telefone}"/>
                                    </div>
                                    <div class="form-group">
                                        <label>Especialidade 3</label>
                                        <select class="form-control" name="vol_espec" id="vol_espec">
                                            <option selected="${user.especialidades.get(2).getCodigo()}" value="${user.especialidades.get(2).getCodigo()}">${ user.especialidades.get(2).getEspecialidade()}</option>
                                            <c:forEach var="listaEspecialidades" items="${listaEspecialidades}">
                                                <option value="${listaEspecialidades.codigo}">${listaEspecialidades.especialidade}</option> 
                                            </c:forEach>
                                        </select>
                                    </div>
                                    <div class="form-group">
                                        <label>Estado</label>
                                        <select name="estado" id="estado" class="form-control">
                                            <option selected=""value="${user.getEndereco().getEstado().getId()}">${user.getEndereco().getEstado().getNome()}</option>
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



