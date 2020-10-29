<%-- 
    Document   : dados_voluntario
    Created on : 01/06/2017, 16:35:01
    Author     : Home
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="model.dao.DaoUsuario"%>
<%@page import="java.util.List"%>
<%@page import="classes.Voluntarios"%>
<%@page import="classesDao.VoluntarioDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-15" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="ISO-8859-1" Content-Type="text/html; charset=ISO-8859-1">
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
                <li>
                    <c:if test="${userperfil=='inst'}">
                        <a href="ServletEvento">
                            <em class="fa fa-calendar">&nbsp;</em>Eventos</a>
                    </c:if>
                     <c:if test="${userperfil=='vol'}">
                        <a href="eventos.jsp">
                            <em class="fa fa-calendar">&nbsp;</em>Eventos</a>
                    </c:if>
                      

                </li>
                <li class="active">
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
                                        <li class="active">Instituição</li>
                                    </ol>
                                </div><!--/.row-->

                                <div class="row">
                                    <div class="col-lg-12">
                                        <h1 class="page-header">Dados Instituição</h1>
                                    </div>
                                </div><!--/.row-->


                                <div class="row">
                                    <div class="col-lg-12">
                                        <div class="panel panel-default">
                                        </div><!-- /.panel-->


                    <div class="panel panel-default">
                        <div class="panel-heading">Instituição</div>
                        <div class="panel-body">
                            <div class="col-md-4">
                                <form role="form" method="POST" action="ServletAtualizaInstituicao">
                                    <div class="form-group">
                                        <label>Razão Social</label>
                                        <input class="form-control" name="inst_nome" value="${user.nome}"/>

                                    </div>
                                    <div class="form-group">
                                        <label>Email</label>
                                        <input class="form-control" name="inst_email" value="${ user.email }"/>
                                    </div>
                                    <div class="form-group" style="width:166%">
                                        <label>Endereço</label>
                                        <input class="form-control" name="inst_endereco" value="${user.getEndereco().getEndereco()}"/>
                                    </div>
                                    <div class="form-group">
                                        <label>Cidade</label>
                                        <select name="cidade" id="cidade"class="form-control">
                                            <option value="${user.getEndereco().getCidade().getId()}">${user.getEndereco().getCidade().getNome()}</option>
                                        </select>
                                    </div>
                                    <div class="form-group" style="width:166%">
                                        <label>Principais Necessidades</label>
                                        <textarea class="form-control" name ="inst_necessidades" cols="50" rows="5" style="resize: none">${user.necessidades}</textarea>
                                    </div>
                                    
                                    <a class="btn btn-primary" href="ServletDadosInstituicao">Cancelar</a>
                                    <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal_Alterar">Confirmar Alterações</button>
                                    <div class="modal fade" id="myModal_Alterar" role="dialog">
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
                                        <label>CNPJ</label>
                                        <input type="text" class="form-control" name="inst_cnpj" value="${ user.cnpj }"/>
                                    </div>
                                    <div class="form-group">
                                        <label>Dados Bancarios</label>
                                        <input type="text" class="form-control" name="inst_dadosbanco" value="${ user.dadosBanco }"/>
                                    </div>

                                </div>
                            </div>
                            <div class="col-md-4" style="width:213.333333px">
                                <div class="form-group">
                                    <div class="form-group">
                                        <label>Nome do Responsável</label>
                                        <input type="text" class="form-control" name="inst_nomeresp" value="${user.nomeResp}"/>

                                    </div>
                                        <div class="form-group">
                                        <label>CPF do Responsável</label>
                                        <input type="text" class="form-control" name="inst_cpfResp" value="${user.cpfResp}"/>

                                    </div>
                                    <div class="form-group">
                                        <label>Telefone</label>
                                        <input type="text" class="form-control" name="inst_telefone" value="${user.telefone}"/>
                                    </div>
                                    <div class="form-group">
                                        <label>Estado</label>
                                        <select name="estado" id="estado" class="form-control">
                                            <option value="${user.getEndereco().getEstado().getId()}">${user.getEndereco().getEstado().getNome()}</option>
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
<div class="col-sm-12">
    <p class="back-link">Lumino Theme by <a href="https://www.medialoot.com">Medialoot</a></p>
</div>
</div><!-- /.row -->
<!-- Div Modal para confirmação de Saida-->
<div class="modal fade" id="myModal_logout" role="dialog">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Confirmação</h4>
            </div>
            <div class="modal-body">
                <p>Deseja mesmo sair?</p>
                <a href="logoff.jsp" class="btn btn-primary"> Sim, quero sair. </a>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
            </div>
        </div>
    </div>
</div>
</div><!--/.main-->
</body>
</html>


