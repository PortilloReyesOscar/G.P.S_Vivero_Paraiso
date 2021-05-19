/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Planta;
import ModeloDAO.PlantaDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author porti
 */
@WebServlet(name = "Controlador", urlPatterns = {"/Controlador"})
public class Controlador extends HttpServlet {
String listar="Vistas/listar.jsp";
String add="Vistas/add.jsp";
String edit="Vistas/edit.jsp";
Planta planta= new Planta();
PlantaDAO plantaDAO= new PlantaDAO();
int idplanta;    

/**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Controlador</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Controlador at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String acceso="";
        String action=request.getParameter("accion");
        if(action.equalsIgnoreCase("listar"))
        {
          acceso=listar;
        }else if(action.equals("add"))
        {
         acceso=add;
        
        }
        else if(action.equalsIgnoreCase("Agregar"))
        {
         String nombre= request.getParameter("txtNombre");
         String descripcion= request.getParameter("txtDescripcion");
         String cantidad= request.getParameter("txtCantidad");
         String precio= request.getParameter("txtPrecio");
         planta.setNombre_planta(nombre);
         planta.setDescripcion(descripcion);
         planta.setCantidad_disponible(Integer.parseInt(cantidad));
         planta.setPrecio_unitario(Integer.parseInt(precio));
         plantaDAO.add(planta);
         acceso=listar;
        }else if(action.equalsIgnoreCase("editar"))
        {
         request.setAttribute("idplanta", request.getParameter("id"));
         acceso=edit;
        }else if(action.equalsIgnoreCase("Actualizar"))
        {
        
         idplanta = Integer.parseInt(request.getParameter("txtid"));
         String nombre= request.getParameter("txtNombre");
         String descripcion= request.getParameter("txtDescripcion");
         String cantidad= request.getParameter("txtCantidad");
         String precio= request.getParameter("txtPrecio");
         planta.setIdplanta(idplanta);
         planta.setNombre_planta(nombre);
         planta.setDescripcion(descripcion);
         planta.setCantidad_disponible(Integer.parseInt(cantidad));
         planta.setPrecio_unitario(Integer.parseInt(precio));
         plantaDAO.edit(planta);
         acceso=listar;
        }else if(action.equalsIgnoreCase("eliminar"))
        {
        idplanta=Integer.parseInt(request.getParameter("id"));
        planta.setIdplanta(idplanta);
        plantaDAO.eliminar(idplanta);
        acceso=listar;
        }else if(action.equalsIgnoreCase("ExportarPDF"))
        {
         DateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd");
         String nomFile= dateFormat.format(new Date());
         String variable1="Content-Disposition";
         String variable2="attachment; filename=Plantas_"+nomFile;
         response.setHeader(variable1,variable2);
        }
        RequestDispatcher vista= request.getRequestDispatcher(acceso);
        vista.forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
