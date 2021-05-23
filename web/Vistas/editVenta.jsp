<%-- 
    Document   : editarVenta
    Created on : 22 may 2021, 22:53:41
    Author     : peldd
--%>

<%@page import="ModeloDAO.VentaDAO"%>
<%@page import="java.util.Iterator"%>
<%@page import="Modelo.Venta"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
 
?<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
      <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Ventas</title>
	<!-- BOOTSTRAP STYLES-->
    <link href="assets/css/bootstrap.css" rel="stylesheet" />
     <!-- FONTAWESOME STYLES-->
    <link href="assets/css/font-awesome.css" rel="stylesheet" />
        <!-- CUSTOM STYLES-->
    <link href="assets/css/custom.css" rel="stylesheet" />
     <!-- GOOGLE FONTS-->
   <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />
</head>
<body>
     
           
          
    <div id="wrapper">
         <div class="navbar navbar-inverse navbar-fixed-top">
            <div class="adjust-nav">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".sidebar-collapse">
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="#"><i class="fa fa-square-o "></i>&nbsp; Ventas</a>
                </div>
                <div class="navbar-collapse collapse">
                    <ul class="nav navbar-nav navbar-right">
                        
                        <li><a href="#">Cerrar Sesion</a></li>
                    </ul>
                </div>

            </div>
        </div>
        <!-- /. NAV TOP  -->
        <nav class="navbar-default navbar-side" role="navigation">
            <div class="sidebar-collapse">
                <ul class="nav" id="main-menu">
                    <li class="text-center user-image-back">
                        <img src="assets/img/find_user.png" class="img-responsive" />
                     
                    </li>


                    <li>
                        <a href="index.html"><i class="fa fa-desktop "></i>Dashboard</a>
                    </li>
                

            </div>

        </nav>
        <!-- /. NAV SIDE  -->
        <div id="page-wrapper" >
            <div id="page-inner">
                <div class="row">
                    <div class="col-md-12">
                     <h2>Editar Venta</h2>   
                    </div>
                </div>              
                 <!-- /. ROW  -->
                  <hr />
                  
          <%
            VentaDAO dao= new VentaDAO();
            int id=Integer.parseInt((String)request.getAttribute("idVenta"));
            Venta v=(Venta)dao.getVenta(id);
            %>
        
        <form action="Controlador">
           <!-- ID:<br> -->
            <input id="entrada"class="form-control" type="hidden" name="txtid" value="<%=v.getIdVenta() %>">    <br>
            <label>ID: <br> <%=v.getIdVenta() %></label> <br>
            Fecha: <br>
            <input id="entrada" class="form-control" type="text" name="txtNombre" value="<%=v.getFecha()%>"><br>
            Total: <br>
            <input id="entrada" class="form-control"  type="text" name="txtDescripcion" value="<%=v.getTotal()%>"><br>
        
            <input class="btn btn-primary" type="submit" name="accion" value="Actualizar"> <br> <br> <br>
            <a class= "btn btn-dark"href="Controlador?accion=listar">Regresar</a>
            </form>
              
                 <!-- /. ROW  -->           
    </div>
             
             <!-- /. PAGE INNER  -->
            </div>
      
         <!-- /. PAGE WRAPPER  -->
        </div>
     <!-- /. WRAPPER  -->
    <!-- SCRIPTS -AT THE BOTOM TO REDUCE THE LOAD TIME-->
    <!-- JQUERY SCRIPTS -->
    <script src="assets/js/jquery-1.10.2.js"></script>
      <!-- BOOTSTRAP SCRIPTS -->
    <script src="assets/js/bootstrap.min.js"></script>
    <!-- METISMENU SCRIPTS -->
    <script src="assets/js/jquery.metisMenu.js"></script>
      <!-- CUSTOM SCRIPTS -->
    <script src="assets/js/custom.js"></script>
    
   
</body>
</html>
