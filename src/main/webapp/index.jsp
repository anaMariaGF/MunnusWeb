
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link rel="stylesheet"
        href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
    <style>
        .home {
            display: flex;
            align-items: center;
            justify-content: center;

        }

        .container {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            flex-wrap: wrap;
        }

        .left {
            display: flex;
            justify-content: center;
            align-items: center;
            width: 40%;
            height: 100%;
        }

        .left img {
            width: 100px;
        }

        .right {
            display: flex;
            justify-content: center;
            align-items: center;
            flex-direction: column;
            width: 60%;
            height: 100%;
        }

        .right h1 {
            font-family: Arial, Helvetica, sans-serif;
            font-size: 30px;
            color: #009dff;
            margin: 20px;
        }

        .iconos {
            display: flex;
            flex-direction: column;
            gap: 15px;
            align-items: flex-start;
        }


        .icon {
            margin: 0%;
            display: flex;
            justify-content: center;
            align-items: center;
            font-size: 48px;
            color: #009dff;
        }


        .link {
            text-decoration: none;
            color: #009dff;
            margin: 10px;
            font-size: large;
            padding: 10px 5px;
        }

        #logo{
            width: 10em;
        }
    </style>
</head>

<body>
    <section class="home">
        <div class="container">
            <div class="left">
                <img src="resources/img/munus.png" id="logo" alt="Logo" >
            </div>

            <div class="right">
                <h1>¡Bienvenid@ a Munnus!</h1>
                <div class="iconos">

                    <div class="icon">
                        <span class="material-symbols-outlined">
                            account_box
                        </span>
                        <a href="inicioSesionProp.jsp?tipo=prop" class="link">Propietario</a>
                    </div>

                    <div class="icon">
                        <span class="material-symbols-outlined">
                            location_away
                        </span>
                        <a href="inicioSesionAdmin.jsp?tipo=admin" class="link">Administrador</a>
                    </div>
                </div>
            </div>
        </div>
    </section>
</body>

</html>
