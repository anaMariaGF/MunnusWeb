<%-- 
    Document   : listadoPropietarios
    Created on : 24 ene. 2023, 9:25:55
    Author     : ana
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listado Propietarios</title>
    </head>
    <body>
        <table class="table table-bordered">
            <thead class="thead-dark">
                <tr>
                    <th>ID</th>
                    <th>Nombres</th>
                    <th>Apellidos</th>
                    <th>Teléfono</th>
                    <th>Email</th>
                    <th>Número de Cuenta Bancaria</th>
                    <th>Clave</th>
                    <th>Estado de Cuenta</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${propietarios}" var="propietario">
                    <tr>
                        <td>${propietario.idPropietario}</td>
                        <td>${propietario.nombres}</td>
                        <td>${propietario.apellidos}</td>
                        <td>${propietario.telefono}</td>
                        <td>${propietario.email}</td>
                        <td>${propietario.numeroCuentaBancaria}</td>
                        <td>${propietario.clave}</td>
                        <td>${propietario.estadoCuentaA}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

    </body>
</html>


