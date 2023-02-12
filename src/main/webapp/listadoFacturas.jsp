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

        <table class="table table-bordered">
            <thead class="thead-dark">
                <tr>
                    <th>ID</th>
                    <th>Fecha de Emisión</th>
                    <th>Período</th>
                    <th>Estado</th>
                    <th>Valor</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${facturas}" var="factura">
                    <tr>
                        <td>${factura.idFactura}</td>
                        <td>${factura.fechaEmision}</td>
                        <td>${factura.periodo}</td>
                        <td>${factura.estadoF}</td>
                        <td>${factura.valor}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

    </body>
</html>



