package Modelo;

public class Vehiculo implements IVehiculo{
    String tipoVehiculo, placa, marca, modelo, color, vin, cc, tamaño_Rueda, id;

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
    
    
}
