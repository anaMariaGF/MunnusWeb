<%-- 
    Document   : inicioSesionAdmin
    Created on : 24-feb-2023, 16:16:32
    Author     : ana
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="txt/css" href="estilos/styleM1.css">
        <link rel="stylesheet" href="lb/css/bootstrap.min.css">

        <title>Inicio de Sesión</title>
        <style>
            body {
                display: flex;
                justify-content: center;
                align-items: center;
                height: 100vh;
            }

            .form-container {
                display: flex;
                justify-content: center;
                align-items: center;
                flex-direction: column;
            }

            form {
                width: 100%;
                max-width: 600px;
            }

            .form-group {
                margin-bottom: 20px;

            }

            .form-control {
                height: 40px;
                font-size: 14px;
            }

            .sign-up {
                margin-top: 20px;
                font-size: 14px;
                text-align: center;
            }

        </style>
    </head>
    <body>

        <% String mensaje = (String) request.getAttribute("mensaejeError"); %>
        <!--Esto viene de iniSesionServlet-->
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-12">
                    <div class="row">
                        <div class="col-md-6 form-container">
                            <img src="resources/img/munus.png" class="rounded mx-auto d-block" alt="..." width="60%">
                        </div>
                        <div class="col-md-6 form-container">

                            <form action="/inicioSesion?rol=admin" method="post">
                                <div class="col-md-6 form-container">
                                    <div class="form-group">
                                        <input type="text" name="matricula" class="form-control form-control-sm" placeholder="Matricula Abogado" id="matricula" aria-describedby="matricula">
                                    </div>
                                </div>
                                <div class="col-md-6 form-container">
                                    <div class="form-group">
                                        <input placeholder="Password" name="clave" type="password" class="form-control form-control-sm mx-2" id="clave">
                                    </div>
                                </div>
                                <div class="col-md-6 form-container">
                                    <button type="submit" class="btn btn-primary btn-block">Entrar</button>

                                    <c:if>
                                        mensaje = ""
                                    </c:if>
                                    <%
                                        if (mensaje != null) {
                                            out.print(mensaje);
                                        }
                                    %>
                                </div>
                                <div class="col-md-6 form-container ">
                                    <a href="#" class="mt-4" style="float:right;font-size:12px;">Olvidaste tu contraseña?</a>
                                </div>
                                <div class="sign-up">
                                    No tienes una cuenta aún? <a href="/formAdmin.jsp">Crear cuenta</a>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>