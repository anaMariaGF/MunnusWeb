<%-- 
    Document   : listadoViviendas
    Created on : 03-feb-2023, 11:24:23
    Author     : ana
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listado de Viviendas</title>
    </head>
    <body>
         <h1>Listado de Viviendas</h1>
        <ul>  
            <c:forEach items="${viviendas}" var="vivienda">
                <li>${vivienda.idVivienda} ${vivienda.direccionVivienda}${vivienda.coeficienteVivienda} 
                    ${vivienda.portal} ${vivienda.parking} ${vivienda.ascensor} ${vivienda.totalPagar}</li>
            </c:forEach>
        </ul>
      
    </body>
</html>

