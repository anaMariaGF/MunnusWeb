<%-- 
    Document   : panelProp
    Created on : 23-feb-2023, 2:16:47
    Author     : ana
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">

    <head>
        <meta charset="UTF-8" />
        <title>Ejemplo de HTML con header y body</title>
        <!-- Agregamos los estilos de Bootstrap -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.0/css/bootstrap.min.css" />
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet" />
        <link rel="stylesheet"
              href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
        <style>
            header {
                display: flex;
                justify-content: space-between;
                align-items: center;
                padding: 10px;
                background-color: white;
            }

            .logo img {
                width: 100px;
            }

            .menu {
                display: flex;
                justify-content: flex-end;
                align-items: center;
                padding: 10px;
            }

            .menu a {
                margin-right: 10px;
            }

            nav {
                background-color: #e3e3e3;
                color: white;
                padding: 10px;
            }

            nav ul {
                list-style: none;
                display: flex;
                justify-content: center;
                margin: 0;
                padding: 0;
            }

            nav li {
                margin: 0 10px;
            }

            nav a {
                color: rgb(0, 123, 230);
                text-decoration: none;
            }

            .card {
                /*
                display: flex;
                justify-content: center;
                align-items: center;
                */
                height: 200px;
                width: 50%;
                margin: 0 auto;
                background-color: #e9e9e9;
                border-radius: 10px;
                box-shadow: 2px 2px 5px rgba(0, 0, 0, 0.3);
            }
            /*
                    .card img {
                        max-height: 100%;
                        max-width: 100%;
                        border-radius: 10px;
                    }
            
                    .tabla-dinamica {
                        width: 80%;
                        margin: 0 auto;
                    }*/
        </style>
    </head>

    <body>
        <header>
            <div class="logo">
                <img src="img/munus.png" alt="Logo" />
            </div>
            <div class="menu" style="display: flex; justify-content: flex-end; align-items: center">
                <a href="#" class="icono-menu">&#9776;</a>
                <img src="ruta_de_la_foto_redonda.png" alt="Foto de perfil" class="foto-perfil" style="margin-left: 10px" />
            </div>
        </header>


        <nav>
            <ul class="nav justify-content-around">
                <li class="nav-item">
                    <a class="nav-link" href="#">Panel de control </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Mi cuenta</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Mi Comunidad</a>
                </li>
            </ul>
        </nav>



        <div class="container">
            <div class="row mx-auto">
                <div class="col-sm-8">

                    <form class="d-flex">
                        <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                        <button class="btn btn-outline-success" type="submit">Search</button>
                    </form>

                    <div class="card" style="width: 18rem;">
                        <img src="..." class="card-img-top" alt="...">
                        <div class="card-body">
                            <h5 class="card-title">${propietario.nombres}</h5>
                            <p class="card-text">PROPIEDADES</p>
                        </div>
                        <ul class="list-group list-group-flush">
                            <li class="list-group-item">An item</li>
                            <li class="list-group-item">A second item</li>
                            <li class="list-group-item">A third item</li>
                        </ul>
          
                    </div>
                </div>       
                <div class="col-sm-12">
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
                        </tbody>
                    </table>

                </div>
            </div>
            <!-- Agregamos los scripts de Bootstrap -->
            <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.0/js/bootstrap.bundle.min.js"></script>
    </body>

</html>