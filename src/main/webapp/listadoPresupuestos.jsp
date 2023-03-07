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
        <table class="table">
            <thead class="thead-dark">
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">ID Presupuesto</th>
                    <th scope="col">Nombre Comunidad</th>
                    <th scope="col">Total Presupuesto</th>
                    <th scope="col">Num. Portales</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${presupuestos}" var="presupuesto">
                    <tr>
                        <th scope="row">${presupuesto.presupuestoPK}</th>
                        <td>${presupuesto.nombreComunidad}</td>
                        <td>${presupuesto.totalPresupuesto}</td>
                        <td>${presupuesto.numProtales}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>


