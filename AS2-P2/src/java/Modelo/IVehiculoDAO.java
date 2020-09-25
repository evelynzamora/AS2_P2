package Modelo;

import java.util.HashMap;
import javax.swing.table.DefaultTableModel;

public interface IVehiculoDAO {
    public int AgregarTipoVehiculo(Vehiculo vehiculo);
    public int ModificarTipoVehiculo(Vehiculo vehiculo);
    public int EliminarTipoVehiculo(Vehiculo vehiculo);
    
    public int AgregarVehiculo(Vehiculo vehiculo);
    public int ModificarVehiculo(Vehiculo vehiculo);
    public int EliminarVehiculo(Vehiculo vehiculo);
    
    public int CambiarAsignacion(Vehiculo vehiculo);
    public DefaultTableModel LeerVehiculo();
    public DefaultTableModel leerTipoVehiculo();
    public HashMap drop_tipo();
}
