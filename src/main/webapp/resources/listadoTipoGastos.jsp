<%-- 
    Document   : listadoTipoGastos
    Created on : 03-feb-2023, 11:37:42
    Author     : ana
--%>


<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listado de Tipo Gastos</title>
    </head>
    <body>
         <h1>Listado de Tipo Gastos</h1>
        <ul>  
            <c:forEach items="${tipoGastos}" var="gasto">
                <li>${gasto.idTipoGasto} ${gasto.descripcion}</li>
            </c:forEach>
        </ul>
      
    </body>
</html>

