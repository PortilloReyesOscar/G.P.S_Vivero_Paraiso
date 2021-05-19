<%-- 
    Document   : listar
    Created on : 23/04/2021, 12:45:37 AM
    Author     : porti
--%>

<%@page import="java.util.Iterator"%>
<%@page import="Modelo.Planta"%>
<%@page import="java.util.List"%>
<%@page import="ModeloDAO.PlantaDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="./CSS/modulo-vivero.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <!-- Fuentes de google-->
        <link rel="preconnect" href="https://fonts.gstatic.com">
        <link href="https://fonts.googleapis.com/css2?family=Lobster&display=swap" rel="stylesheet">
         
        <script src="https://kit.fontawesome.com/b5b706b6e5.js" crossorigin="anonymous"></script>

        <title>Inventario del vivero</title>
    </head>
    <body>
        <nav class="navbar navbar-dark bg-dark">
            <div action="Controlador">
            <a href="Controlador?accion=listar" class="nav-link" style="color:white">Control de inventario</a>
            </div>
            <div class="dropdown">
                <a style="color:white" href="#" class="nav-link dropdown-toggle"data-toggle="dropdown">Cerrar Session</a>
                <div  class="dropdown-menu text-center">
                   <a> <img src="Imagenes/user.png" height="80" width="100" alt="icono del usuario"/></a>   
                   <br> 
                   <a>${nom}</a>
                   <a>${correo}</a>
                   <div class="dropdown-divider"></div>
                   <a href="Controlador2?accion=Salir" class="dropdown-item">Salir</a>
                </div>
            </div>
        </nav>
        
        <h1 id="titulo-modulo" class="text-center">Plantas del vivero "paraiso".</h1>
        <br>
        <div  class="form-group text-center">
            <form action="Controlador">
                <button tyoe="submit" name="accion" value="ExportarPDF" id="btn-reporte" class="btn btn-danger"><i class="fas fa-file-pdf"></i>&nbsp;&nbsp;Generar reporte en PDF</button>  
            </form>
        </div>
        <a  id="btn-agregar" class="btn btn-success text-center " href="Controlador?accion=add"><i class="fa fa-plus-square"></i>  Agregar planta</a>
        <br>
        <br>
        <table class="table table-bordered table-hover table-light" id="tabla-inventario" >
            <thead class="">
                <tr>
                    <th class="text-center">ID</th>
                    <th class="text-center">NOMBRE DE LA PLANTA</th>
                    <th class="text-center">DESCRIPCIÓN</th>
                    <th class="text-center">DISPONIBLE</th>
                    <th class="text-center">PRECIO UNITARIO</th>
                    <th class="text-center"s>OPCIONES</th>
                </tr>
            </thead>
            <%
              PlantaDAO dao= new PlantaDAO();
              List<Planta>list=dao.listar();
              Iterator<Planta>iter=list.iterator();
              Planta planta=null;
              while(iter.hasNext())
              {
              planta=iter.next();
              
             
            %>
            <tbody>
                <tr>
                    <td><%= planta.getIdplanta()%></td>
                    <td><%= planta.getNombre_planta()%></td>
                    <td><%= planta.getDescripcion()%></td>
                    <td><%= planta.getCantidad_disponible()%></td>
                    <td>$<%= planta.getPrecio_unitario()%></td>
                    <td>
                        <a class="btn btn-warning" href="Controlador?accion=editar&id=<%= planta.getIdplanta()%>">Editar <i class="fa fa-edit"></i></a>
                        <a class="btn btn-danger" href="Controlador?accion=eliminar&id=<%= planta.getIdplanta()%>">Elminar <i class="fa fa-trash"></i></a>
                        
                    </td>
                </tr>
                <% }%>
            </tbody>
        </table>
   <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    </body>
</html>
