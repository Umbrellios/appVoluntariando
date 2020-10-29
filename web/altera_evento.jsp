<%-- 
    Document   : Cadastra Eventos
    Created on : 19/11/2017, 13:07
    Author     : Home
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="model.dao.DaoUsuario"%>
<%@page import="java.util.List"%>
<%@page import="classes.Voluntarios"%>
<%@page import="classesDao.VoluntarioDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Voluntariando <--> Voluntario</title>
        <link href="assets/css/bootstrap.min.css" rel="stylesheet">
        <link href="assets/css/font-awesome.min.css" rel="stylesheet">
        <link href="assets/css/datepicker3.css" rel="stylesheet">
        <link href="assets/css/styles.css" rel="stylesheet">
        <script src="assets/js/jquery2.min.js"></script>
        <script src="assets/js/bootstrap.min.js"></script>

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
                <li ><a href="dashboard.jsp"><em class="fa fa-paper-plane">&nbsp;</em> Painel</a></li>
                <li><a href="widgets.jsp"><em class="fa fa-group">&nbsp;</em> Participações</a></li>
                <li class="active">
                    <c:if test="${userperfil=='inst'}">
                        <a href="ServletEvento">
                            <em class="fa fa-calendar">&nbsp;</em>Eventos</a>
                        </c:if>
                        <c:if test="${userperfil=='vol'}">
                        <a href="eventos.jsp">
                            <em class="fa fa-calendar">&nbsp;</em>Eventos</a>
                        </c:if>

                </li>
                <li>
                    <c:if test="${userperfil=='inst'}">
                        <a href="ServletDadosInstituicao">
                        </c:if>
                        <c:if test="${userperfil=='vol'}">
                            <a href="ServletDadosVoluntario">
                            </c:if>
                            <c:if test="${userperfil=='admin'}">
                                <a href="ServletDadosAdministrador">
                                </c:if>

                                <em class="fa fa-book" aria-hidden="true">&nbsp;</em> Dados Cadastrais</a>
                            </li>
                            <li><a href="assets/panels.html"><em class="fa fa-bell">&nbsp;</em> Alertas</a></li>
                            <li>
                                <a href="#myModal" data-toggle="modal" data-target="#myModal"><em class="fa fa-power-off" >&nbsp;</em> Logout</a>
                            </li>
                            </ul>
                            </div><!--/.sidebar-->

                            <div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">
                                <div class="row">
                                    <ol class="breadcrumb">
                                        <li><a href="#">
                                                <em class="fa fa-home"></em>
                                            </a></li>
                                        <li class="active">Eventos</li>
                                    </ol>
                                </div><!--/.row-->

                                <div class="row">
                                    <div class="col-lg-12">
                                        <h1 class="page-header">Eventos Ativos</h1>
                                    </div>
                                </div><!--/.row-->


                                <div class="row">
                                    <div class="col-lg-12">
                                        <div class="panel panel-default">
                                        </div>
                    <!-- /.panel-->
                        <div class="panel panel-default">
                            <div class="panel-heading">Dados do Evento</div>
                                <div class="panel-body">
                                    <form role="form" method="POST" action="ServletAtualizaEvento" name="AtualizaEvento">
                                        <div class="col-md-3">
                                            <div class="form-group">
                                                <label>Idade Minima</label>
                                                <input class="form-control" type="text" name="even_idade_faixa1" value="${eventos.idadeFaixa1}"/>
                                            </div>
                                            <div class="form-group">
                                                <label>Especialidade 1</label>
                                                <select class="form-control" name="even_espec" id="even_espec">
                                                    <option value="${eventos.getEspecialidades().get(0).getCodigo()}">${eventos.getEspecialidades().get(0).getEspecialidade()}</option>
                                                    <c:forEach var="listaEspecialidades" items="${listaEspecialidades}">
                                                        <option value="${listaEspecialidades.codigo}">${listaEspecialidades.especialidade}</option> 
                                                    </c:forEach>
                                                </select>
                                            </div>
                                            <div class="form-group" style="width: 241%">
                                                <label>Localidade</label>
                                                <input class="form-control" type="text" name="even_local" value="${eventos.local}"/>
                                            </div>
                                            <div class="form-group" style="width: 241%">
                                                <label>Descrição</label>
                                                <textarea class="form-control" name ="even_descricao" cols="50" rows="5" style="resize: none">${eventos.descricao}</textarea>
                                            </div>
                                                <div class="form-group">
                                                <a href="ServletEvento" class="btn btn-primary">Cancelar</a>
                                                </div>
                                                <div class="form-grou">
                                                    <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal_Atualiza">Confirmar Alteração</button>
                                                    <div class="modal fade" id="myModal_Atualiza" role="dialog">
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
                                        </div>
                                        <div class="col-md-3">
                                            <div class="form-group">
                                                <label>Idade Maxima</label>
                                                <input class="form-control" type="text" name="even_idade_faixa2" value="${eventos.idadeFaixa2}"/>
                                            </div>
                                            <div class="form-group">
                                                <label>Especialidade 2</label>
                                                <select class="form-control" name="even_espec" id="even_espec">
                                                    <option value="${eventos.getEspecialidades().get(1).getCodigo()}">${eventos.getEspecialidades().get(1).getEspecialidade()}</option>
                                                    <c:forEach var="listaEspecialidades" items="${listaEspecialidades}">
                                                        <option value="${listaEspecialidades.codigo}">${listaEspecialidades.especialidade}</option> 
                                                    </c:forEach>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="col-md-3">
                                            <div class="form-group">
                                                <label>Data</label>
                                                <input class="form-control" type="date" name="even_data" value="${eventos.data}"/>
                                            </div>
                                            <div class="form-group">
                                                <label>Especialidade 3</label>
                                                <select class="form-control" name="even_espec" id="even_espec">
                                                    <option value="${eventos.getEspecialidades().get(2).getCodigo()}">${eventos.getEspecialidades().get(2).getEspecialidade()}</option>
                                                    <c:forEach var="listaEspecialidades" items="${listaEspecialidades}">
                                                        <option value="${listaEspecialidades.codigo}">${listaEspecialidades.especialidade}</option> 
                                                    </c:forEach>
                                                </select>
                                            </div>
                
                                        </div> 

                                    </form>
                                    
                                </div>
                        </div><!-- /.panel-->
                </div><!-- /.col-->
            </div>  
        </div><!-- /.row -->
                            </div><!--/.main-->



    </body>
</html>



