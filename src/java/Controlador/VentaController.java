/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Venta;
import ModeloDAO.VentaDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import static javax.print.attribute.Size2DSyntax.MM;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author peldd
 */
@WebServlet(name = "VentaController", urlPatterns = {"/VentaController"})
public class VentaController extends HttpServlet {

    String renderizar = "Vistas/venta.jsp";
    String add = "Vistas/addVenta.jsp";
    String edit = "Vistas/editVenta.jsp";
    Venta venta = new Venta();
    VentaDAO ventaDAO = new VentaDAO();
    int idVenta;

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
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet VentaController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet VentaController at " + request.getContextPath() + "</h1>");
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
        processRequest(request, response);
        String acceso = "";
        String action = request.getParameter("accion");
         if(action.equalsIgnoreCase("renderizar"))
        {
          acceso=renderizar;}
          else if (action.equals("add")) {
            acceso = add;

        } else if (action.equalsIgnoreCase("Agregar")) {
           
            Date fecha = convertirStringToDate(request.getParameter("txtFecha"));
             double total = Double.parseDouble(request.getParameter("txtTotal"));
            venta.setFecha(fecha);
            venta.setTotal(total);

            ventaDAO.save(venta);
            acceso = renderizar;
        } else if (action.equalsIgnoreCase("editar")) {
            request.setAttribute("idVenta", request.getParameter("id"));
            acceso = edit;
        } else if (action.equalsIgnoreCase("Actualizar")) {

            idVenta = Integer.parseInt(request.getParameter("id"));
            Date fecha = convertirStringToDate(request.getParameter("txtFecha"));
            venta.setFecha(fecha);

            ventaDAO.save(venta);
            acceso = renderizar;
        } else if (action.equalsIgnoreCase("eliminar")) {
            idVenta = Integer.parseInt(request.getParameter("id"));
            ventaDAO.delete(idVenta);
            acceso = renderizar;
        } else if (action.equalsIgnoreCase("ExportarPDF")) {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String nomFile = dateFormat.format(new Date());
            String variable1 = "Content-Disposition";
            String variable2 = "attachment; filename=Plantas_" + nomFile;
            response.setHeader(variable1, variable2);
        }
        RequestDispatcher vista = request.getRequestDispatcher(acceso);
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
    public java.util.Date convertirStringToDate(String date){
          SimpleDateFormat formatoDelTexto = new SimpleDateFormat("dd-MM-yyyy");
        
            Date fecha = null;
              
            try {

                fecha = formatoDelTexto.parse(date);
          
            } catch (ParseException ex) {

                ex.printStackTrace();

            }
     return fecha;
    }
}
