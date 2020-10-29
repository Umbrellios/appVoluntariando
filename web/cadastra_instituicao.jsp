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
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="ISO-8859-1">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Voluntariando <--> Instituição</title>
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
                    </ul>
                </div>
            </div><!-- /.container-fluid -->
        </nav>
        

                            <div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">
                                <div class="row">
                                    <ol class="breadcrumb">
                                        <li><a href="#">
                                                <em class="fa fa-home"></em>
                                            </a></li>
                                        <li class="active">Nova Instituição</li>
                                    </ol>
                                </div><!--/.row-->

                                <div class="row">
                                    <div class="col-lg-12">
                                        <h1 class="page-header">Cadastro de Instituição</h1>
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
                                <form role="form" method="POST"  name="CadastraInstituicao" action="ServletCadastraInstituicao">
                                    <div class="form-group">
                                        <label>Razão Social</label>
                                        <input class="form-control" name="inst_nome"/>

                                    </div>
                                    <div class="form-group">
                                        <label>Email</label>
                                        <input class="form-control" name="inst_email"/>
                                    </div>
                                    <div class="form-group" style="width:166%">
                                        <label>Endereço</label>
                                        <input class="form-control" name="inst_endereco"/>
                                    </div>
                                    
                                    <div class="form-group">
                                        <label>Cidade</label>
                                        <select name="cidade" id="cidade"class="form-control">
                                            <option selected="${user.id_cidade}" value="${user.id_cidade}">${user.cidade}</option>
                                        </select>
                                    </div>
                                    <div class="form-group">
                                        <label> Nova Senha </label>
                                        <input type="password"  requerid placeholder="Insira a nova Senha" class="form-control" id="inst_senha" name="inst_senha"/>
                                    </div>
                                    <div class class="form-group">
                                        <label> Digite Novamente </label>
                                        <input type="password" class="form-control" required placeholder="Repita a Senha" name="repetir_senha" oninput="validaSenha(this)"/>
                                    </div><br>
                                                                       
                                    <div class="form-group" style="width:166%">
                                        <label>Principais Necessidades</label>
                                        <textarea class="form-control" name ="inst_necessidades" cols="50" rows="5" style="resize: none"></textarea>
                                    </div>
                                    
                                    <a class="btn btn-primary" href="index.jsp">Cancelar</a>
                                    <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal_confirmar">Confirmar Cadastro</button>
                                    <div class="modal fade" id="myModal_confirmar" role="dialog">
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
                                        <label>CNPJ</label>
                                        <input type="text" class="form-control" name="inst_cnpj"/>
                                    </div>
                                    <div class="form-group">
                                        <label>Dados Bancarios</label>
                                        <input type="text" class="form-control" name="inst_dadosbanco"/>
                                    </div>

                                </div>
                            </div>
                            <div class="col-md-4" style="width:213.333333px">
                                <div class="form-group">
                                    <div class="form-group">
                                        <label>Nome do Responsável</label>
                                        <input type="text" class="form-control" name="inst_nomeresp"/>

                                    </div>
                                        <div class="form-group">
                                        <label>CPF do Responsável</label>
                                        <input type="text" class="form-control" name="inst_cpfresp"/>

                                    </div>
                                    <div class="form-group">
                                        <label>Telefone</label>
                                        <input type="text" class="form-control" name="inst_telefone"/>
                                    </div>
                                    <div class="form-group">
                                        <label>Estado</label>
                                        <select name="estado" id="estado" class="form-control">
                                            <option></option>
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
        if (input.value != document.getElementById('inst_senha').value) {
            input.setCustomValidity('Repita a senha corretamente');
        } else {
            input.setCustomValidity('');
        }
    }
</script>


