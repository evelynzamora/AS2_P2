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
    
    <h1 style="color: darkblue" align="center">Formulario Vehiculos</h1>
    

    <div class="container">
        
        <form action="sr_Vehiculo" method="get" class="form-group">
            
            <label for="Tipo Vehiculo"><b>Tipo Vehiculo</b></label>
            <select name="drop_tipo" id="drop_tipo" class="form-control">
                <option value='0'>--Seleccionar--</option>
                <%
                    try{
                    IVehiculoDAO tipo = new VehiculoDAO();
                    HashMap<String,String> drop = tipo.drop_tipo();
                    for(String i:drop.keySet()){
                        out.println("<option value='"+ i +"'>"+ drop.get(i) +"</option>");
                    }
                    }catch(Exception e){
                        out.println("<option value='"+e.getMessage()+"'</option>");
                    }
                %>
            </select>
            
            <label for="lbl_placa"><b>Placa</b></label>
            <input type="text" name="txt_placa" id="txt_placa" class="form-control" placeholder="Ejemplo: p123abc" required>
            
            <label for="lbl_marca"><b>Marca</b></label>
            <input type="text" name="txt_marca" id="txt_marca" class="form-control" placeholder="Ejemplo: Nissan" required>
            
            <label for="lbl_modelo"><b>Modelo</b></label>
            <input type="text" name="txt_modelo" id="txt_modelo" class="form-control" placeholder="Ejemplo: Sentra" required>
            
            <label for="lbl_color"><b>Color</b></label>
            <br>
            <div class="form-check-inline">
                <label class="form-check-label">
                    <input type="radio" class="form-check-input" name="optradio" value='Rojo'>Rojo
                </label>
            </div>
            <div class="form-check-inline">
                <label class="form-check-label">
                    <input type="radio" class="form-check-input" name="optradio" value='Blanco'>Blanco
                </label>
            </div>
            <div class="form-check-inline">
                <label class="form-check-label">
                    <input type="radio" class="form-check-input" name="optradio" value='Negro'>Negro
                </label>
            </div>
            <div class="form-check-inline">
                <label class="form-check-label">
                    <input type="radio" class="form-check-input" name="optradio" value='Azul'>Azul
                </label>
            </div>
            
            <br>
            <label for="lbl_vin"><b>VIN</b></label>
            <input type="text" name="txt_vin" id="txt_vin" class="form-control" placeholder="Ejemplo: 1HGBH41JXMN109186" required>
            
            <label for="lbl_cc"><b>CC</b></label>
            <input type="text" name="txt_cc" id="txt_cc" class="form-control" placeholder="Ejemplo: 1800cc" required>
            
            <label for="lbl_tamaño_rueda"><b>Tamaño de rueda</b></label>
            <input type="text" name="txt_tamaño_rueda" id="txt_tamaño_rueda" class="form-control" placeholder="Ejemplo: 13'" required>
            
            <br>
            <button name="btn_agregar" id="btn_agregar" value="agregar" class="btn btn-primary btn-lg">Agregar</button>
            <button name="btn_modificar" id="btn_modificar" value="modificar" class="btn btn-success btn-lg">Modificar</button>
            <button name="btn_eliminar" id="btn_modificar" value="eliminar" class="btn btn-danger btn-lg" onclick="javascript:if(!confirm('¿Desea Eliminar?'))return false">Eliminar</button>
            <br>
            <a><p onclick="limpiar()">Limpiar formulario</p></a>
            </form>
    </div>


    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
    <script type="text/javascript">
    function limpiar(){
        $("#drop_marca").val('');
        $("#txt_placa").val('');
        $("#txt_modelo").val('');
        $("#txt_vin").val('');
        $("#txt_cc").val('');
        $("#txt_tamaño_rueda").val('');
        $("#drop_marca").val(0);
    }
    </script>
</body>
</html>