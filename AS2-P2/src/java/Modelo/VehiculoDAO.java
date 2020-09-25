package Modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import javax.swing.table.DefaultTableModel;

public class VehiculoDAO implements IVehiculoDAO{
    Conexion cn;

    @Override
    public DefaultTableModel LeerVehiculo() {
        DefaultTableModel tabla = new DefaultTableModel();
        try{
            cn = new Conexion();
            cn.abrir_conexion();
            String query = "SELECT v.IdVehiculo_Detalle as id, d.TipoVehiculo as tipo, v.Placa, v.Marca, v.Modelo, v.Color, v.VIN, v.Cc, v.Tamaño_Rueda FROM Vehiculo as d INNER JOIN Vehiculo_Detalle as v on d.IdVehiculo = v.IdVehiculo_Detalle;";
            ResultSet consulta = cn.conexionBD.createStatement().executeQuery(query);
            String encabezado[]= {"id","tipo","Placa","Marca","Modelo","Color","VIN","Cc","Tamaño_Rueda"};
            tabla.setColumnIdentifiers(encabezado);
            String datos[] = new String[9];
            while (consulta.next()){
                datos[0] = consulta.getString("id");
                datos[1] = consulta.getString("tipo");
                datos[2] = consulta.getString("Placa");
                datos[3] = consulta.getString("Marca");
                datos[4] = consulta.getString("Modelo");
                datos[5] = consulta.getString("Color");
                datos[6] = consulta.getString("VIN");
                datos[7] = consulta.getString("Cc");
                datos[8] = consulta.getString("Tamaño_Rueda");
                tabla.addRow(datos);                
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            cn.cerrar_conexion();            
        }
        return tabla; 
    }
    
    @Override
    public int CambiarAsignacion(Vehiculo vehiculo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int AgregarTipoVehiculo(Vehiculo vehiculo) {
        int retorno = 0;
        try{
            PreparedStatement parametro;
            cn = new Conexion();
            String query = "INSERT INTO Vehiculo(TipoVehiculo) VALUES (?);";
            cn.abrir_conexion();
            parametro = (PreparedStatement)cn.conexionBD.prepareStatement(query);
            parametro.setString(1, vehiculo.getTipoVehiculo());
            
            retorno = parametro.executeUpdate();
            cn.cerrar_conexion();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
            retorno = 0;
        }finally{
            cn.cerrar_conexion();            
        }
        return retorno;
    }

    @Override
    public int ModificarTipoVehiculo(Vehiculo vehiculo) {
        int retorno = 0;
        try{
            PreparedStatement parametro;
            cn = new Conexion();
            String query = "UPDATE Vehiculo set TipoVehiculo=? WHERE IdVehiculo = ?;";
            cn.abrir_conexion();
            parametro = (PreparedStatement)cn.conexionBD.prepareStatement(query);
            parametro.setString(1, vehiculo.getTipoVehiculo());
            parametro.setString(2, vehiculo.getId());
            
            retorno = parametro.executeUpdate();
            cn.cerrar_conexion();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
            retorno = 0;
        }finally{
            cn.cerrar_conexion();            
        }
        return retorno;
    }

    @Override
    public int EliminarTipoVehiculo(Vehiculo vehiculo) {
        int retorno = 0;
        try{
            PreparedStatement parametro;
            cn = new Conexion();
            String query = "DELETE FROM Vehiculo WHERE IdVehiculo = ?;";
            cn.abrir_conexion();
            parametro = (PreparedStatement)cn.conexionBD.prepareStatement(query);
            parametro.setString(1, vehiculo.getId());
            
            retorno = parametro.executeUpdate();
            cn.cerrar_conexion();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
            retorno = 0;
        }finally{
            cn.cerrar_conexion();
        }
        return retorno;
    }

    @Override
    public HashMap drop_tipo() {
        HashMap <String,String> drop = new HashMap();
        try{
            String query ="SELECT IdVehiculo as id, TipoVehiculo as tipo FROM Vehiculo;";
            cn = new Conexion();
            cn.abrir_conexion();
            ResultSet consulta = cn.conexionBD.createStatement().executeQuery(query);
            while (consulta.next()){
                drop.put(consulta.getString("id"), consulta.getString("tipo"));
            }
        }catch(SQLException ex){
            ex.setNextException(ex);
        }finally{
            cn.cerrar_conexion();
        }
        return drop;
    }
    
    @Override
    public DefaultTableModel leerTipoVehiculo(){
        DefaultTableModel tabla = new DefaultTableModel();
        try{
            cn = new Conexion();
            cn.abrir_conexion();
            String query = "SELECT IdVehiculo as id, TipoVehiculo as tipo FROM Vehiculo LIMIT 100;";
            ResultSet consulta = cn.conexionBD.createStatement().executeQuery(query);
            String encabezado[]= {"id","tipo"};
            tabla.setColumnIdentifiers(encabezado);
            String datos[] = new String[2];
            while (consulta.next()){
                datos[0] = consulta.getString("id");
                datos[1] = consulta.getString("tipo");
                tabla.addRow(datos);                
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            cn.cerrar_conexion();            
        }
        return tabla;
    }

    @Override
    public int AgregarVehiculo(Vehiculo vehiculo) {
        int retorno = 0;
        try{
            PreparedStatement parametro;
            cn = new Conexion();
            String query = "INSERT INTO Vehiculo_Detalle(Placa,Marca,Modelo,Color,VIN,Cc,Tamaño_Rueda,IdVehiculo) VALUES (?,?,?,?,?,?,?,?);";
            cn.abrir_conexion();
            parametro = (PreparedStatement)cn.conexionBD.prepareStatement(query);
            parametro.setString(1, vehiculo.getPlaca());
            parametro.setString(2, vehiculo.getMarca());
            parametro.setString(3, vehiculo.getModelo());
            parametro.setString(4, vehiculo.getColor());
            parametro.setString(5, vehiculo.getVin());
            parametro.setString(6, vehiculo.getCc());
            parametro.setString(7, vehiculo.getTamaño_Rueda());
            parametro.setString(8, vehiculo.getId());
            
            retorno = parametro.executeUpdate();
            cn.cerrar_conexion();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
            retorno = 0;
        }finally{
            cn.cerrar_conexion();
        }
        return retorno;
    }

    @Override
    public int ModificarVehiculo(Vehiculo vehiculo) {
        int retorno = 0;
        try{
            PreparedStatement parametro;
            cn = new Conexion();
            String query = "UPDATE Vehiculo_Detalle SET Placa=?,Marca=?,Modelo=?,Color=?,VIN=?,Cc=?,Tamaño_Rueda=?,IdVehiculo=? WHERE Placa=?;";
            cn.abrir_conexion();
            parametro = (PreparedStatement)cn.conexionBD.prepareStatement(query);
            parametro.setString(1, vehiculo.getPlaca());
            parametro.setString(2, vehiculo.getMarca());
            parametro.setString(3, vehiculo.getModelo());
            parametro.setString(4, vehiculo.getColor());
            parametro.setString(5, vehiculo.getVin());
            parametro.setString(6, vehiculo.getCc());
            parametro.setString(7, vehiculo.getTamaño_Rueda());
            parametro.setString(8, vehiculo.getId());
            parametro.setString(9, vehiculo.getPlaca());
            retorno = parametro.executeUpdate();
            cn.cerrar_conexion();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
            retorno = 0;
        }finally{
            cn.cerrar_conexion();
        }
        return retorno;
    }

    @Override
    public int EliminarVehiculo(Vehiculo vehiculo) {
        int retorno = 0;
        try{
            PreparedStatement parametro;
            cn = new Conexion();
            String query = "DELETE FROM Vehiculo_Detalle WHERE WHERE Placa=?;";
            cn.abrir_conexion();
            parametro = (PreparedStatement)cn.conexionBD.prepareStatement(query);
            parametro.setString(1, vehiculo.getPlaca());
            
            retorno = parametro.executeUpdate();
            cn.cerrar_conexion();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
            retorno = 0;
        }finally{
            cn.cerrar_conexion();
        }
        return retorno;
    }
    
}
