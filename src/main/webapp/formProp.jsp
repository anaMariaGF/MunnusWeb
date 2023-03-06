<%-- 
    Document   : formProp
    Created on : 23-feb-2023, 1:54:42
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

	<form action="/propietarios" method="post">
		<div class="container">
			<div class="column">
				<label for="nombre">Nombre:</label>
				<input type="text" id="nombre" name="nombre">

				<label for="apellido">Apellido:</label>
				<input type="text" id="apellido" name="apellido">

				<label for="telefono">Teléfono:</label>
				<input type="text" id="telefono" name="telefono">
                              <!--  
                                <label for="numCuentaBancaria">Número de Cuenta Bancaria:</label>
				<input type="text" id="numCuentaBancaria" name="numCuentaBancaria">-->

				<label for="email">Email:</label>
				<input type="email" id="email" name="email">

				<label for="password">Contraseña:</label>
				<input type="password" id="clave" name="clave">
			</div>
			<div class="column">
				<div class="title">Crear usuario propietario</div>
				<label for="identificacion">Identificación:</label>
				<input type="text" id="identificacion" name="identificacion">

				<label for="numero_cuenta">Número de cuenta:</label>
				<input type="text" id="numero_cuenta" name="numero_cuenta">

				<input type="submit" value="Enviar">

				
				<%
				 String mensaje = (String)request.getAttribute("msgError"); 
				if(mensaje !=null){
				out.print(mensaje);
				}
				%>


			</div>
		</div>
	</form>
</body>
</html>
