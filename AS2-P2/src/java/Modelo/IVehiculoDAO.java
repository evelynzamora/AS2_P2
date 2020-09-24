package Modelo;

import java.util.HashMap;
import javax.swing.table.DefaultTableModel;

public interface IVehiculoDAO {
    public int LeerVehiculo(Vehiculo vehiculo);
    public int LeerDetalle(Vehiculo vehiculo);
    public int AgregarVehiculo(Vehiculo vehiculo);
    public int ModificarVehiculo(Vehiculo vehiculo);
    public int EliminarVehiculo(Vehiculo vehiculo);
    public int CambiarAsignacion(Vehiculo vehiculo);
    public DefaultTableModel leerTipoVehiculo();
    public HashMap drop_tipo();
}
