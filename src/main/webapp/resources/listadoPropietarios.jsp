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
        <h1>Listado de Propietarios</h1>
        <ul>
            <!--<c:forEach items="${propietarios}" var="propietario">-->
                <li>${propietario.idPropietario} ${propietario.nombres} ${propietario.apellidos}
                ${propietario.telefono} ${propietario.email} ${propietario.numeroCuentaBancaria}
                ${propietario.clave} ${propietario.estadoCuentaA}</li>
            </c:forEach>
        </ul>
        
    </body>
</html>
 