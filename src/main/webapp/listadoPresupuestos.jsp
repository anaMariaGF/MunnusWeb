<%-- 
    Document   : listadoPresupuestos
    Created on : 03-feb-2023, 11:09:48
    Author     : ana
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listado de Presupuestos</title>
    </head>
    <body>
         <h1>Listado de Presupuestos</h1>
        <ul>  
            <c:forEach items="${presupuestos}" var="presupuesto">
                <li>${presupuesto.presupuestoPK} ${presupuesto.nombreComunidad}${presupuesto.totalPresupuesto} 
                    ${presupuesto.numProtales}</li>
            </c:forEach>
        </ul>
      
    </body>
</html>


