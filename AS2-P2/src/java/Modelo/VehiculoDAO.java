package Modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import javax.swing.table.DefaultTableModel;

public class VehiculoDAO implements IVehiculoDAO{
    Conexion cn;

    @Override
    public int LeerVehiculo(Vehiculo vehiculo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int LeerDetalle(Vehiculo vehiculo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int AgregarVehiculo(Vehiculo vehiculo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int ModificarVehiculo(Vehiculo vehiculo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int EliminarVehiculo(Vehiculo vehiculo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int CambiarAsignacion(Vehiculo vehiculo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
            String query = "SELECT IdVehiculo as id, TipoVehiculo as tipo FROM Vehiculo;";
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
            return tabla;
        }
    }
    
}
