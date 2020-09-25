package Controlador;

import Modelo.Vehiculo;
import Modelo.VehiculoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class sr_Detalle extends HttpServlet {
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
            out.println("<title>Servlet sr_Detalle</title>");            
            out.println("</head>");
            out.println("<body>");
            
            vehiculo = new Vehiculo(request.getParameter("txt_id"),request.getParameter("txt_tipo"));
            
            if("agregar".equals(request.getParameter("btn_agregar"))){
                if(vehiculoDAO.AgregarTipoVehiculo(vehiculo) > 0){
                    response.sendRedirect("detalle.jsp");
                }else{
                    out.println("<h1>Error.............</h1>");
                    out.println("<a href-'detalle.jsp'>Regresar...</a>");
                }
            } 
            
            if("modificar".equals(request.getParameter("btn_modificar"))){
                if(vehiculoDAO.ModificarTipoVehiculo(vehiculo)> 0){
                    response.sendRedirect("detalle.jsp");
                }else{
                    out.println("<h1>Error.............</h1>");
                    out.println("<a href-'detalle.jsp'>Regresar...</a>");
                }
            }   
            
            if("eliminar".equals(request.getParameter("btn_eliminar"))){
                if(vehiculoDAO.EliminarTipoVehiculo(vehiculo) > 0){
                    response.sendRedirect("detalle.jsp");
                }else{
                    out.println("<h1>Error.............</h1>");
                    out.println("<a href-'detalle.jsp'>Regresar...</a>");
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
