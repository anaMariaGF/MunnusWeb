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
        <%
        String mensaje = request.getParameter("Error");
        if(mensaje!=null){
                out.println(mensaje);
        }
        %>
        <h1>Listado de Viviendas</h1>
        <table class="table">
            <thead class="thead-dark">
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">ID Vivienda</th>
                    <th scope="col">Dirección Vivienda</th>
                    <th scope="col">Coeficiente Vivienda</th>
                    <th scope="col">Portal</th>
                    <th scope="col">Parking</th>
                    <th scope="col">Ascensor</th>
                    <th scope="col">Total a Pagar</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${viviendas}" var="vivienda">
                    <tr>
                        <th scope="row">${vivienda.idVivienda}</th>
                        <td>${vivienda.direccionVivienda}</td>
                        <td>${vivienda.coeficienteVivienda}</td>
                        <td>${vivienda.portal}</td>
                        <td>${vivienda.parking}</td>
                        <td>${vivienda.ascensor}</td>
                        <td>${vivienda.totalPagar}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>

