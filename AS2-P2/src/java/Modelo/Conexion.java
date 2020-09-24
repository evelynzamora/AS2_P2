package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    public Connection conexionBD;
    private final String puerto= "3306";
    private final String bd= "jbarilla_as2_equipo4";
    private final String urlConexion = String.format("jdbc:mysql://192.185.4.65:%s/%s?serverTimezone=UTC",puerto, bd);
    private final String usuario = "jbarilla_as2";
    private final String contra = "agEO5ZTI.VC8";
    private final String jdbc ="com.mysql.cj.jdbc.Driver";
    
    public void abrir_conexion(){
            try{
                Class.forName(jdbc);
                conexionBD = DriverManager.getConnection(urlConexion,usuario,contra); 
            }catch(ClassNotFoundException | SQLException ex){
                    System.out.println("Error: " + ex.getMessage());
            }
    }
    
    public void cerrar_conexion(){
        try{
            conexionBD.close();
        }catch(SQLException ex){
            System.out.println("Error: " + ex.getMessage());
        }
    
    }
}