<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Voluntariando Login/Cadastro</title>
        <link href="assets/css/bootstrap.min2.css" rel="stylesheet">
        <link href="assets/css/datepicker3.css" rel="stylesheet">
        <link href="assets/css/styles.css" rel="stylesheet">
        <link rel="stylesheet" href="assets/css/jquery-ui.css">
        <script src="assets/js/jquery-1.9.1.js"></script>
	<script src="assets/js/jquery-ui.js"></script>
        <script>
            $(function () {
                $("#tabs").tabs();
            });
        </script>
                
    </head>
    <body>
       
        <a href="index.jsp" style="margin-left:43%;"><img src="assets/img/logo.png"/></a>	
        <div id="tabs" class="ui-tabs ui-widget ui-widget-content ui-corner-all" style="margin-left:25%; margin-right:25%">
            <ul class="ui-tabs-nav ui-helper-reset ui-helper-clearfix ui-widget-header ui-corner-all" role="tablist">
                
                <li class="ui-state-default ui-corner-top" role="tab" tabindex="-1" aria-controls="voluntario" aria-labelledby="ui-id-1" aria-selected="false" style="margin-left: 146px;"><a href="#voluntario" class="ui-tabs-anchor" role="presentation" tabindex="-1" id="ui-id-1">Voluntario</a></li>
                <li class="ui-state-default ui-corner-top" role="tab" tabindex="-1" aria-controls="instituicao" aria-labelledby="ui-id-2" aria-selected="false"><a href="#instituicao" class="ui-tabs-anchor" role="presentation" tabindex="-1" id="ui-id-2">Instituição</a></li>
                <li class="ui-state-default ui-corner-top" role="tab" tabindex="0" aria-controls="administrador" aria-labelledby="ui-id-3" aria-selected="true"><a href="#administrador" class="ui-tabs-anchor" role="presentation" tabindex="-1" id="ui-id-3">Administrador</a></li>
           
            </ul>
           
            <div id="voluntario" aria-labelledby="ui-id-1" class="ui-tabs-panel ui-widget-content ui-corner-bottom" role="tabpanel" aria-expanded="false" aria-hidden="true" style="display: none;">
                <div class="row">
                    <div class="col-xs-10 col-xs-offset-1 col-sm-8 col-sm-offset-2 ">
                        <div class="login-panel panel panel-default">
                            <div class="panel-body">
                                <form role="form" method="post" action="ServletValidaLoginVol">
                                    <fieldset>
                                         <div class="form-group">
                                            ${mensagemConfirmaCadastroVol}
                                            ${mensagemLoginVol}
                                        </div>
                                        <div class="form-group">
                                            <input class="form-control" placeholder="E-mail" name="vol_email" type="email" autofocus="">
                                        </div>
                                        <div class="form-group">
                                            <input class="form-control" placeholder="Senha" name="vol_senha" type="password" value="">
                                        </div>
                                        <input class="btn btn-primary" type="submit" value="Login"/>
                                        <input class="btn btn-primary" type="button" value="Cadastre-se" onClick="window.open('ServletCadastraUsuario?userperfil=vol', '_self')"/><br>
                                        
                                    </fieldset>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>	
            </div>
            <div id="instituicao" aria-labelledby="ui-id-2" class="ui-tabs-panel ui-widget-content ui-corner-bottom" role="tabpanel" style="display: none;" aria-expanded="false" aria-hidden="true">
                <div class="row">
                    <div class="col-xs-10 col-xs-offset-1 col-sm-8 col-sm-offset-2">
                        <div class="login-panel panel panel-default">
                            <div class="panel-body">
                                <form role="form" method="post" action="ServletValidaLoginInst">
                                    <fieldset>
                                        <div class="form-group">
                                            ${mensagemConfirmaCadastroInst}
                                            ${mensagemLoginInst}
                                        </div>
                                        <div class="form-group">
                                            <input class="form-control" placeholder="E-mail" name="inst_email" type="email" autofocus="">
                                        </div>
                                        <div class="form-group">
                                            <input class="form-control" placeholder="Senha" name="inst_senha" type="password" value="">
                                        </div>
                                        <input class="btn btn-primary" type="submit" value="Login" />
                                        <input class="btn btn-primary" type="button" value="Cadastre-se" onClick="window.open('ServletCadastraUsuario?userperfil=inst', '_self')"/>
                                    </fieldset>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>	
            </div>

            <div id="administrador" aria-labelledby="ui-id-3" class="ui-tabs-panel ui-widget-content ui-corner-bottom" role="tabpanel" style="display: block;" aria-expanded="true" aria-hidden="false">
                <div class="row">
                    <div class="col-xs-10 col-xs-offset-1 col-sm-8 col-sm-offset-2">
                        <div class="login-panel panel panel-default">
                            <div class="panel-body">
                                <form role="form" method="post" action="ServletValidaLoginAdmin">
                                    <fieldset>
                                        <div class="form-group">
                                            ${mensagemConfirmaCadastroAdmin}
                                            ${mensagemLoginAdmin}
                                        </div>
                                        <div class="form-group">
                                            <input class="form-control" placeholder="E-mail" name="admin_email" type="email" autofocus="">
                                        </div>
                                        <div class="form-group">
                                            <input class="form-control" placeholder="Senha" name="admin_senha" type="password" value="">
                                        </div>
                                        <input class="btn btn-primary" type="submit" value="Login"/>
                                        <input class="btn btn-primary" type="button" value="Cadastre-se" onClick="window.open('ServletCadastraUsuario?userperfil=admin', '_self')"/>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>	
            </div>
        </div>

        









    </body>
</html>