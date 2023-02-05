<%-- 
    Document   : listadoFacturas
    Created on : 03-feb-2023, 10:27:23
    Author     : ana
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listado de Facturas</title>
    </head>
    <body>
         <h1>Listado de Facturas</h1>
        <ul>  
            <c:forEach items="${facturas}" var="factura">
                <li>${factura.idFactura} ${factura.fechaEmision}${factura.periodo} ${factura.estadoF} ${factura.valor}</li>
            </c:forEach>
        </ul>
      
    </body>
</html>



