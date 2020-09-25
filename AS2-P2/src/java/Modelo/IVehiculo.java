package Modelo;

public interface IVehiculo {
    public String getId();
    public String getTipoVehiculo();
    public String getPlaca();
    public String getMarca();
    public String getModelo();
    public String getColor();
    public String getVin();
    public String getCc();
    public String getTamaño_Rueda();
    public void setId(String id);
    public void setTipoVehiculo(String tipoVehiculo);
    public void setPlaca(String placa);
    public void setMarca(String marca);
    public void setModelo(String modelo);
    public void setColor(String color);
    public void setVin(String vin);
    public void setCc(String cc);
    public void setTamaño_Rueda(String tamaño_rueda);
}
