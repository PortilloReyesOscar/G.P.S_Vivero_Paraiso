<%-- 
    Document   : add
    Created on : 23/04/2021, 12:45:50 AM
    Author     : porti
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="preconnect" href="https://fonts.gstatic.com">
        <link href="https://fonts.googleapis.com/css2?family=Lobster&display=swap" rel="stylesheet">
        <link href="./CSS/modulo-vivero.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <title>Agregar nueva planta</title>
    </head>
    <body>
        <h1 id="titulo-modulo">Agregar Planta</h1>
        <div id="editar-planta-form" class="col-lg-8">
        <form>
            Nombre de la planta: <br>
            <input class="form-control" type="text" name="txtNombre"><br>
            Descripción de planta: <br>
            <input class="form-control" type="text" name="txtDescripcion"><br>
            Cantidad disponible: <br>
            <input class="form-control" type="text" name="txtCantidad"><br>
            Precio unitario: <br>
            <input class="form-control" type="text" name="txtPrecio"><br>
            <input class="btn btn-primary" type="submit" name="accion" value="Agregar"> <br> <br>
           <a class= "btn btn-dark"href="Controlador?accion=listar">Regresar</a>

        </form>
        </div>
    </body>
</html>
