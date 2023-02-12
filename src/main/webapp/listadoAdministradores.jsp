<%-- 
    Document   : listadoAdministradores
    Created on : 24 ene. 2023, 9:15:03
    Author     : ana
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listado de Administradores</title>
    </head>
    <body>

        <table class="table table-bordered">
            <thead class="thead-dark">
                <tr>
                    <th>ID</th>
                    <th>NIF</th>
                    <th>Matrícula Abogado</th>
                    <th>Nombres</th>
                    <th>Apellidos</th>
                    <th>Teléfono</th>
                    <th>Email</th>
                    <th>Estado de Cuenta</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${administradores}" var="administrador">
                    <tr>
                        <td>${administrador.idAdministrador}</td>
                        <td>${administrador.nif}</td>
                        <td>${administrador.matriculaAbogado}</td>
                        <td>${administrador.nombres}</td>
                        <td>${administrador.apellidos}</td>
                        <td>${administrador.telefono}</td>
                        <td>${administrador.email}</td>
                        <td>${administrador.estadoCuentaA}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

    </body>
</html>


