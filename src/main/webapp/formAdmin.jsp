<%-- 
    Document   : formAdmin
    Created on : 24-feb-2023, 15:39:08
    Author     : ana
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Formulario de registro</title>
        <meta charset="UTF-8">
        <style>
            .container {
                display: flex;
                flex-wrap: wrap;
                justify-content: space-between;
                align-items: center;
                margin: 20px;
            }

            .column {
                flex-basis: 45%;
            }

            input, button {
                display: block;
                margin-bottom: 10px;
                padding: 5px;
                border: none;
                border-radius: 5px;
            }

            input[type="submit"] {
                background-color: #87CEEB;
                color: white;
                cursor: pointer;
            }

            label {
                font-weight: bold;
            }

            .title {
                color: #87CEEB;
                font-size: 24px;
                font-weight: bold;
                margin-bottom: 10px;
            }
        </style>
    </head>
    <body>
        <form action="/administradores" method="post">
            <div class="container">
                <div class="column">
                    <label for="nombre">Nombres:</label>
                    <input type="text" id="nombre" name="nombre">

                    <label for="apellido">Apellidos:</label>
                    <input type="text" id="apellido" name="apellido">

                    <label for="telefono">Teléfono:</label>
                    <input type="text" id="telefono" name="telefono">

                    <label for="email">Email:</label>
                    <input type="email" id="email" name="email">

                    <label for="password">Contraseña:</label>
                    <input type="password" id="password" name="password">
                </div>
                <div class="column">
                    <div class="title">Crear usuario Administrador </div>
                    <label for="matriculaA">Matrícula Abogado:</label>
                    <input type="text" id="matriculaA" name="matriculaA">

                    <label for="nif">NIF:</label>
                    <input type="text" id="nif" name="nif">

                    <input type="submit" value="Enviar">
                </div>
            </div>
        </form>
    </body>
</html>

