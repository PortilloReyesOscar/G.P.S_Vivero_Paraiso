<%-- 
    Document   : VentaView
    Created on : 19 may 2021, 18:26:40
    Author     : Betzadi
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
                     <h2>Ventas</h2>   
                    </div>
                </div>              
                 <!-- /. ROW  -->
                  <hr />
                  
                       <div  class="form-group text-center">
            <form action="Controlador">
                <button tyoe="submit" name="accion" value="ExportarPDF" id="btn-reporte" class="btn btn-danger"><i class="fas fa-file-pdf"></i>&nbsp;&nbsp;Generar reporte en PDF</button>  
            </form>
        </div>
        <a  id="btn-agregar" class="btn btn-success text-center " href="Controlador?accion=add"><i class="fa fa-plus-square"></i>  Agregar Venta</a>
        <br>
        <br>
        <table class="table table-bordered table-hover table-light" id="tabla-inventario" >
          
            <thead class="">
                <tr>
                    <th class="text-center">ID</th>
                    <th class="text-center">Fecha</th>
                    <th class="text-center">Total</th>
                
                </tr>
            </thead>
         
            <%VentaDAO ventaDao=new VentaDAO();
                  List<Venta>list=ventaDao.getAll();
              Iterator<Venta>iter=list.iterator();
              Venta venta=null;
              while(iter.hasNext())
              {
                venta=iter.next();
            %>
            <tbody>
             
                <tr>
                    <td><%= venta.getIdVenta()%></td>
                    <td><%= venta.getFecha()%></td>
                    <td><%= venta.getTotal()%></td>
                  
                    <td>
                        <a class="btn btn-warning" href="VentaController?accion=editar&id=<%= venta.getIdVenta()%>">Editar <i class="fa fa-edit"></i></a>
                        <a class="btn btn-danger" href="VentaController?accion=eliminar&id=<%= venta.getIdVenta()%>">Elminar <i class="fa fa-trash"></i></a>
                        
                    </td>
                </tr>
                <% }%>
                
            </tbody>
                  </table>
              
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

