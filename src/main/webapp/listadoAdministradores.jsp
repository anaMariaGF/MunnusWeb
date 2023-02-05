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
         <h1>Listado de Administradores</h1>
        <ul>
            <!--<c:forEach items="${administradores}" var="administrador">-->
                <li>${administrador.idAdministrador} ${administrador.nif} ${administrador.matriculaAbogado}
                {administrador.nombres} ${administrador.apellidos} ${administrador.telefono}
                {administrador.email} ${administrador.clave} ${administrador.estadoCuentaA}</li>
            </c:forEach>
        </ul>
        
    </body>
</html>


