<%-- 
    Document   : listadoDeudores
    Created on : 24 ene. 2023, 9:30:28
    Author     : ana
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listado de Deudores</title>
    </head>
    <body>
                <h1>Listado de Deudores</h1>
        <ul>
            <c:forEach items="${deudores}" var="deudor">
                <li>${deudor.username} ${deudor.password} ${deudor.persona}</li>
            </c:forEach>
        </ul>
    </body>
</html>
