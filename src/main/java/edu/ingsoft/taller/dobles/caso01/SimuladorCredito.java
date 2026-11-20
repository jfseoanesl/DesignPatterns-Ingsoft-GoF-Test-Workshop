package edu.ingsoft.taller.dobles.caso01;

public class SimuladorCredito {
    private final ProveedorTasas tasas;

    public SimuladorCredito(ProveedorTasas tasas) {
        this.tasas = tasas;
    }

    public Simulacion simular(long monto, int meses) {
        if (meses < 6) {
            throw new IllegalArgumentException("El plazo mínimo es de 6 meses");
        }
        double i;
        try {
            i = tasas.tasaMensual();
        } catch (TasaNoDisponibleException e) {
            return new Simulacion(false, 0, "Tasa no disponible");
        }
        double cuota = monto * i / (1 - Math.pow(1 + i, -meses));
        return new Simulacion(true, Math.round(cuota / 100) * 100, "OK");
    }
}
