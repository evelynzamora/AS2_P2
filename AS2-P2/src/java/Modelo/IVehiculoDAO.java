package Modelo;

public interface IVehiculoDAO {
    public int LeerVehiculo(Vehiculo vehiculo);
    public int LeerDetalle(Vehiculo vehiculo);
    public int AgregarVehiculo(Vehiculo vehiculo);
    public int ModificarVehiculo(Vehiculo vehiculo);
    public int EliminarVehiculo(Vehiculo vehiculo);
    public int CambiarAsignacion(Vehiculo vehiculo);
}
