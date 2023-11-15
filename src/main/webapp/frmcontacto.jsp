<%@page import="com.emergentes.entidades.Contacto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<%
    Contacto contacto = (Contacto) request.getAttribute("contacto");
%>
<html lang="es">
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css"/>
        <!-- Bootstrap CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

        <title>Punto de venta</title>
    </head>
    <body>
        <div class="container">
            <h1>Formulario de contactos</h1>
            <br>
            <form action="MainController" method="post">
                <input type="hidden" name="id" value="${contacto.id}">
                <div class="mb-3">
                    <label for="exampleInputEmail1" class="form-label">Nombre</label>
                    <input type="text" class="form-control" name="nombre" value="${contacto.nombre}" placeholder="Escriba su nombre">
                </div>
                <div class="mb-3">
                    <label for="exampleInputEmail1" class="form-label">Correo</label>
                    <input type="email" class="form-control" name="correo" value="${contacto.correo}" placeholder="Escriba su correo electronico">
                </div>
                <div class="mb-3">
                    <label for="exampleInputEmail1" class="form-label">Telefono</label>
                    <input type="number" class="form-control" name="telefono" value="${contacto.telefono}" placeholder="Escriba su telefono">
                </div>
                <button type="submit" class="btn btn-primary">Enviar</button> 
            </form>


        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

    </body>
</html>