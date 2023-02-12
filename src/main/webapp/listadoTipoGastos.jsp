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
        <table class="table">
            <thead class="thead-dark">
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">ID Tipo Gasto</th>
                    <th scope="col">Descripción</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="gasto" items="${tipoGastos}">
                    <tr>
                        <th scope="row">${gasto.idTipoGasto}</th>
                        <td>${gasto.descripcion}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>


    </body>
</html>

