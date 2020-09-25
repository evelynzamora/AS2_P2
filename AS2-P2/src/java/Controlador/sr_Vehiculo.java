package Controlador;

import Modelo.Vehiculo;
import Modelo.VehiculoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class sr_Vehiculo extends HttpServlet {
    Vehiculo vehiculo;
    VehiculoDAO vehiculoDAO;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet sr_Vehiculo</title>");            
            out.println("</head>");
            out.println("<body>");
            
            vehiculo = new Vehiculo(request.getParameter("txt_id"),request.getParameter("txt_tipo"),request.getParameter("txt_placa"), request.getParameter("txt_marca"), request.getParameter("txt_modelo"), request.getParameter("optradio"), request.getParameter("txt_vin"), request.getParameter("txt_cc"), request.getParameter("txt_tamaño_rueda"));
            
            if("agregar".equals(request.getParameter("btn_agregar"))){
                if(vehiculoDAO.AgregarVehiculo(vehiculo) > 0){
                    response.sendRedirect("vehiculo.jsp");
                }else{
                    out.println("<h1>Error.............</h1>");
                    out.println("<a href-'vehiculo.jsp'>Regresar...</a>");
                }
            } 
            
            if("modificar".equals(request.getParameter("btn_modificar"))){
                if(vehiculoDAO.ModificarVehiculo(vehiculo)> 0){
                    response.sendRedirect("vehiculo.jsp");
                }else{
                    out.println("<h1>Error.............</h1>");
                    out.println("<a href-'vehiculo.jsp'>Regresar...</a>");
                }
            }   
            
            if("eliminar".equals(request.getParameter("btn_eliminar"))){
                if(vehiculoDAO.EliminarVehiculo(vehiculo) > 0){
                    response.sendRedirect("vehiculo.jsp");
                }else{
                    out.println("<h1>Error.............</h1>");
                    out.println("<a href-'vehiculo.jsp'>Regresar...</a>");
                }
            } 
            
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
