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
              <a class="nav-link" href="vehiculo.jsp">Vehiculo CRUD</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="detalle.jsp">Tipo Vehiculo CRUD</a>
            </li>
        </ul>
    </nav>
    
    <h1 style="color: darkblue" align="center">Formulario Tipo_vehiculo</h1>
    

    <div class="container">
        
        <form action="#" method="post" class="form-group">
            
            <label for="lbl_id"><b>ID</b></label>
            <input type="text" name="txt_id" id="txt_id" class="form-control" readonly>
            
            <label for="lbl_tipo"><b>Tipo Vehiculo</b></label>
            <input type="text" name="txt_tipo" id="txt_tipo" class="form-control" placeholder="Ejemplo: Sedan" required>
            
            <br>
            <button name="btn_agregar" id="btn_agregar" value="agregar" class="btn btn-primary btn-lg">Agregar</button>
            <button name="btn_modificar" id="btn_modificar" value="modificar" class="btn btn-success btn-lg">Modificar</button>
            <button name="btn_eliminar" id="btn_modificar" value="eliminar" class="btn btn-danger btn-lg" onclick="javascript:if(!confirm('¿Desea Eliminar?'))return false">Eliminar</button>
            <br>
            <a><p onclick="limpiar()">Limpiar formulario</p></a>
            <br>
            <table class="table table-striped">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Tipo Vehiculo</th>
                        </tr>
                    </thead>
                    <tbody id="tbl_vehiculo">
                        <% 
                        IVehiculoDAO vehiculo= new VehiculoDAO();
                        DefaultTableModel tabla = new DefaultTableModel();
                        tabla = vehiculo.leerTipoVehiculo();
                        for(int t=0;t<tabla.getRowCount();t++){
                            out.println("<tr data-id="+ tabla.getValueAt(t, 0) + ">");
                            out.println("<td>"+ tabla.getValueAt(t, 0) +"</td>");
                            out.println("<td>"+ tabla.getValueAt(t, 1) +"</td>");
                            out.println("</tr>");
                        }
                        %>
                    </tbody>
                </table>
            </form>
    </div>


    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
    <script type="text/javascript">
    function limpiar(){
        $("#txt_id").val('');
        $("#txt_tipo").val('');
    }
    
    $('#tbl_vehiculo').on('click','tr td',function(evt){
                var target,id,tipo;
                target = $(event.target);
                id = target.parent().data('id');
                tipo = target.parent("tr").find("td").eq(1).html();
                
                $("#txt_id").val(id);
                $("#txt_tipo").val(tipo);
            });
    </script>
</body>
</html>