package Modelo;

public interface IVehiculo {
    public int GetId();
    public String GetTipoVehiculo();
    public String GetPlaca();
    public String GetNumero_Licencia();
    public String GetMarca();
    public String GetModelo();
    public String GetColor();
    public String GetVin();
    public String GetCc();
    public String GetTamaño_Rueda();
    public void SetId(String id);
    public void SetTipoVehiculo(String tipoVehiculo);
    public void SetPlaca(String placa);
    public void SetNumero_Licencia(String numero_Licencia);
    public void SetMarca(String marca);
    public void SetModelo(String modelo);
    public void SetColor(String color);
    public void SetVin(String vin);
    public void SetCc(String cc);
    public void SetTamaño_Rueda(String tamaño_rueda);
}
