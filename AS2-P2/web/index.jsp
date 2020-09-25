<%@page import="Modelo.VehiculoDAO"%>
<%@page import="Modelo.IVehiculoDAO"%>
<%@page import="java.util.HashMap" %>
<%@page import="javax.swing.table.DefaultTableModel" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head bgcolor ="red">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>VEHICULOS</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
</head>
    <body style="background-color: #FFCC00;">
        
        <nav class="navbar navbar-expand-sm bg-dark navbar-dark">
          <ul class="navbar-nav">
            <li class="nav-item">
              <a class="nav-link" href="index.jsp">Inicio</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="vehiculo.jsp">Vehiculo CRUD</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="detalle.jsp">Tipo Vehiculo CRUD</a>
            </li>
          </ul>
        </nav>
        
        <div>
            <table class="table table-striped">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Tipo Vehiculo</th>
                            <th>Placa</th>
                            <th>Marca</th>
                            <th>Modelo</th>
                            <th>Color</th>
                            <th>VIN</th>
                            <th>CC</th>
                            <th>Tamaño_Rueda</th>
                        </tr>
                    </thead>
                    <tbody id="tbl_vehiculo">
                        <% 
                        IVehiculoDAO vehiculo = new VehiculoDAO();
                        DefaultTableModel tabla = new DefaultTableModel();
                        tabla = vehiculo.LeerVehiculo();
                        for(int t=0;t<tabla.getRowCount();t++){
                            out.println("<tr>");
                            out.println("<td>"+ tabla.getValueAt(t, 0) +"</td>");
                            out.println("<td>"+ tabla.getValueAt(t, 1) +"</td>");
                            out.println("<td>"+ tabla.getValueAt(t, 2) +"</td>");
                            out.println("<td>"+ tabla.getValueAt(t, 3) +"</td>");
                            out.println("<td>"+ tabla.getValueAt(t, 4) +"</td>");
                            out.println("<td>"+ tabla.getValueAt(t, 5) +"</td>");
                            out.println("<td>"+ tabla.getValueAt(t, 6) +"</td>");
                            out.println("<td>"+ tabla.getValueAt(t, 7) +"</td>");
                            out.println("<td>"+ tabla.getValueAt(t, 8) +"</td>");
                            out.println("</tr>");
                        }
                        %>
                    </tbody>
            </table>
        </div>
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
    
    </body>
</html>
