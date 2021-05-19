<%-- 
    Document   : edit
    Created on : 23/04/2021, 12:46:04 AM
    Author     : porti
--%>

<%@page import="Modelo.Planta"%>
<%@page import="ModeloDAO.PlantaDAO"%>
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
         
        <title>Editar planta</title>
    </head>
    <body>
        <div>
            <%
            PlantaDAO dao= new PlantaDAO();
            int id=Integer.parseInt((String)request.getAttribute("idplanta"));
            Planta p=(Planta)dao.list(id);
            %>
        <h1 id="titulo-modulo">Modificiar datos de planta</h1>
        <div id="planta-form" class="col-lg-8">
        <form action="Controlador">
           <!-- ID:<br> -->
            <input id="entrada"class="form-control" type="hidden" name="txtid" value="<%=p.getIdplanta() %>">    <br>
            <label>ID: <br> <%=p.getIdplanta() %></label> <br>
            Nombre planta: <br>
            <input id="entrada" class="form-control" type="text" name="txtNombre" value="<%=p.getNombre_planta()%>"><br>
            Descripción de planta: <br>
            <input id="entrada" class="form-control"  type="text" name="txtDescripcion" value="<%=p.getDescripcion()%>"><br>
            Cantidad disponible: <br>
            <input id="entrada" class="form-control" type="text" name="txtCantidad" value="<%=p.getCantidad_disponible() %>"><br>
            Precio unitario: <br>
            <input id="entrada" class="form-control"  type="text" name="txtPrecio" value="<%= p.getPrecio_unitario() %>"><br>
            <input class="btn btn-primary" type="submit" name="accion" value="Actualizar"> <br> <br> <br>
            <a class= "btn btn-dark"href="Controlador?accion=listar">Regresar</a>
            </form>
        </div>
        </div>
    </body>
</html>
