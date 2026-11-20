package edu.ingsoft.taller.dobles.caso01;

/** Consulta el servicio interno de tesorería (HTTP). */
public class ProveedorTasasTesoreria implements ProveedorTasas {
    @Override
    public double tasaMensual() {
        throw new TasaNoDisponibleException("Sin conexión con tesorería");
    }
}
