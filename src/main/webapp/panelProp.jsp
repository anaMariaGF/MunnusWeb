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
    <link rel="stylesheet" href="resources/lb/css/bootstrap.min.css">
    <link rel="stylesheet" href="resources/bootstrap-icons-1.9.1/bootstrap-icons.css">
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
        </style>
    </head>

    <body>
        <header>
            <div class="logo">
                <img src="img/munus.png" alt="Logo" />
            </div>
            <div class="menu" style="display: flex; justify-content: flex-end; align-items: center">
                <a href="#" class="icono-menu">&#9776;</a>
                <img src="ruta_de_la_foto_redonda.png" alt="Foto de perfil" class="foto-perfil"  style="width: 10%;height: auto; margin-left: 10px" />
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
    
    <div class="row mx-auto">
        <div class="col-3 mt-5">
            <div class="card">
                <div class="card-body">
                  <div class="d-flex justify-content-center">
                    <img src="img/vendedora.png" class="card-img-top mt-4 px-4" alt="..." style="width: 100%;height: auto;">
                  </div>
                  <h5 class="card-title text-center mt-4">${propietario.nombres}</h5>
                  <ul class="list-group list-group-flush">
                    <li class="list-group-item"><i class="bi bi-house-door"> ${vivienda.direccionVivienda}</i></li>
                    <li class="list-group-item"> <i class="bi bi-house-door"></i> ${vivienda.direccionVivienda}</li>
                  </ul>
                </div>
              </div>
        </div>
        <div class="col-9 mt-5">
            <nav class="navbar navbar-expand-lg navbar-light bg-white ms-5">
                <div class="container-fluid">
                    <form class="d-flex h-50rem" >
                        <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                        <button class="btn btn-outline-success" type="submit">Buscar</button>
                    </form>
                </div>
            </nav>
            <table class="table mt-5">
                <thead>
                <tr>
                    <th scope="col">
                    <span class="material-symbols-outlined">
                       
                        </span> </th>
                    <th scope="col">#</th>
                    <th scope="col">Factura</th>
                    <th scope="col">Fecha</th>
                    <th scope="col">Periodo</th>
                    <th scope="col">Valor</th>
                    <th scope="col">Estado</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                  
                    <th scope="row"><i class="bi bi-box-arrow-down"></i></th>
                    <td>Mark</td>
                    <td>Otto</td>
                    <td>@mdo</td>
                    <td>@mdo</td>
                    <td>@mdo</td>
                    <td>@mdo</td>
                </tr>
                
                <tr>
                    <th scope="row"><i class="bi bi-box-arrow-down"></i></th>
                    <td>Jacob</td>
                    <td>Thornton</td>
                    <td>@fat</td>
                    <td>@mdo</td>
                    <td>@mdo</td>
                    <td>@mdo</td>
                </tr>
                <tr>
                    <th scope="row"><i class="bi bi-box-arrow-down"></i></th>
                    <td colspan="2">Larry the Bird</td>
                    <td>@twitter</td>
                    <td>@mdo</td>
                    <td>@mdo</td>
                    <td>@mdo</td>
                </tr>
                
                </tbody>
            </table> 
        </div>
    </div>
     
    
   
    <!-- Agregamos los scripts de Bootstrap -->
    <script src="lb/js/bootstrap.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.0/js/bootstrap.bundle.min.js"></script>
</body>

</html>
        
        
        
        
        
        
        
        
        
  