package Modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import javax.swing.table.DefaultTableModel;

public class Vehiculo implements IVehiculo{
    String tipoVehiculo, placa, marca, modelo, color, vin, cc, tamaño_Rueda, id;
    Conexion cn;

    public Vehiculo(){
    }
    
    public Vehiculo(String id, String tipoVehiculo){
        this.id = id;
        this.tipoVehiculo = tipoVehiculo;
    }
    
    public Vehiculo(String id, String tipoVehiculo, String placa, String marca, String modelo, String color, String vin, String cc, String tamaño_Rueda) {
        this.id = id;
        this.tipoVehiculo = tipoVehiculo;
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.vin = vin;
        this.cc = cc;
        this.tamaño_Rueda = tamaño_Rueda;
    }
    
    @Override
    public String getId() {
        return id;
    }
    
    @Override
    public void setId(String id) {
        this.id = id;
    }
    
    @Override
    public String getTipoVehiculo() {
        return tipoVehiculo;
    }
    @Override
    public void setTipoVehiculo(String tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }
    @Override
    public String getPlaca() {
        return placa;
    }
    @Override
    public void setPlaca(String placa) {
        this.placa = placa;
    }
    @Override
    public String getMarca() {
        return marca;
    }
    @Override
    public void setMarca(String marca) {
        this.marca = marca;
    }
    @Override
    public String getModelo() {
        return modelo;
    }
    @Override
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    @Override
    public String getColor() {
        return color;
    }
    @Override
    public void setColor(String color) {
        this.color = color;
    }
    @Override
    public String getVin() {
        return vin;
    }
    @Override
    public void setVin(String vin) {
        this.vin = vin;
    }
    @Override
    public String getCc() {
        return cc;
    }
    @Override
    public void setCc(String cc) {
        this.cc = cc;
    }
    @Override
    public String getTamaño_Rueda() {
        return tamaño_Rueda;
    }
    @Override
    public void setTamaño_Rueda(String tamaño_Rueda) {
        this.tamaño_Rueda = tamaño_Rueda;
    }
    
    //ESTO NO ESTABA PLANEADO, ES UN ACTO DE DESESPERACION Y HACE VER FEO EL CODIGO PERO FUNCIONA
    
    public int AgregarTipoVehiculo() {
        int retorno = 0;
        try{
            PreparedStatement parametro;
            cn = new Conexion();
            String query = "INSERT INTO Vehiculo(TipoVehiculo) VALUES (?);";
            cn.abrir_conexion();
            parametro = (PreparedStatement)cn.conexionBD.prepareStatement(query);
            parametro.setString(1, getTipoVehiculo());
            
            retorno = parametro.executeUpdate();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
            retorno = 0;
        }finally{
            cn.cerrar_conexion();            
        }
        return retorno;
    }

    public int ModificarTipoVehiculo() {
        int retorno = 0;
        try{
            PreparedStatement parametro;
            cn = new Conexion();
            String query = "UPDATE Vehiculo set TipoVehiculo=? WHERE IdVehiculo = ?;";
            cn.abrir_conexion();
            parametro = (PreparedStatement)cn.conexionBD.prepareStatement(query);
            parametro.setString(1, getTipoVehiculo());
            parametro.setString(2, getId());
            
            retorno = parametro.executeUpdate();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
            retorno = 0;
        }finally{
            cn.cerrar_conexion();            
        }
        return retorno;
    }

    public int EliminarTipoVehiculo() {
        int retorno = 0;
        try{
            PreparedStatement parametro;
            cn = new Conexion();
            String query = "DELETE FROM Vehiculo WHERE IdVehiculo = ?;";
            cn.abrir_conexion();
            parametro = (PreparedStatement)cn.conexionBD.prepareStatement(query);
            parametro.setString(1, getId());
            
            retorno = parametro.executeUpdate();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
            retorno = 0;
        }finally{
            cn.cerrar_conexion();
        }
        return retorno;
    }

    public int AgregarVehiculo() {
        int retorno = 0;
        try{
            PreparedStatement parametro;
            cn = new Conexion();
            String query = "INSERT INTO Vehiculo_Detalle(Placa,Marca,Modelo,Color,VIN,Cc,Tamaño_Rueda,IdVehiculo) VALUES (?,?,?,?,?,?,?,?);";
            cn.abrir_conexion();
            parametro = (PreparedStatement)cn.conexionBD.prepareStatement(query);
            parametro.setString(1, getPlaca());
            parametro.setString(2, getMarca());
            parametro.setString(3, getModelo());
            parametro.setString(4, getColor());
            parametro.setString(5, getVin());
            parametro.setString(6, getCc());
            parametro.setString(7, getTamaño_Rueda());
            parametro.setString(8, getTipoVehiculo());
            
            retorno = parametro.executeUpdate();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
            retorno = 0;
        }finally{
            cn.cerrar_conexion();
        }
        return retorno;
    }

    public int ModificarVehiculo() {
        int retorno = 0;
        try{
            PreparedStatement parametro;
            cn = new Conexion();
            String query = "UPDATE Vehiculo_Detalle SET Placa=?,Marca=?,Modelo=?,Color=?,VIN=?,Cc=?,Tamaño_Rueda=?,IdVehiculo=? WHERE Placa=?;";
            cn.abrir_conexion();
            parametro = (PreparedStatement)cn.conexionBD.prepareStatement(query);
            parametro.setString(1, getPlaca());
            parametro.setString(2, getMarca());
            parametro.setString(3, getModelo());
            parametro.setString(4, getColor());
            parametro.setString(5, getVin());
            parametro.setString(6, getCc());
            parametro.setString(7, getTamaño_Rueda());
            parametro.setString(8, getTipoVehiculo());
            parametro.setString(9, getPlaca());
            retorno = parametro.executeUpdate();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
            retorno = 0;
        }finally{
            cn.cerrar_conexion();
        }
        return retorno;
    }

    public int EliminarVehiculo() {
        int retorno = 0;
        try{
            PreparedStatement parametro;
            cn = new Conexion();
            String query = "DELETE FROM Vehiculo_Detalle WHERE Placa=?;";
            cn.abrir_conexion();
            parametro = (PreparedStatement)cn.conexionBD.prepareStatement(query);
            parametro.setString(1, getPlaca());
            
            retorno = parametro.executeUpdate();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
            retorno = 0;
        }finally{
            cn.cerrar_conexion();
        }
        return retorno;
    }
}
