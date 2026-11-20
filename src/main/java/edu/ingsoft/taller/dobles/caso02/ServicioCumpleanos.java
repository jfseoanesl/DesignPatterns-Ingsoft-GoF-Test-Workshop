package edu.ingsoft.taller.dobles.caso02;

import java.time.LocalDate;
import java.time.MonthDay;

public class ServicioCumpleanos {

    /** Envía el saludo a quienes cumplen años hoy; devuelve cuántos correos envió. */
    public int enviarSaludos() {
        LocalDate hoy = LocalDate.now();
        ClienteSmtp smtp = new ClienteSmtp("smtp.almacenes.co", 587);
        int enviados = 0;
        for (Cliente c : BaseDatos.consultarClientes()) {
            if (cumpleHoy(c.nacimiento(), hoy)) {
                smtp.enviar(c.correo(), "¡Feliz cumpleaños, " + c.nombre() + "!",
                        "Celébralo con 15 % de descuento usando el cupón CUMPLE15.");
                enviados++;
            }
        }
        return enviados;
    }

    private boolean cumpleHoy(LocalDate nacimiento, LocalDate hoy) {
        MonthDay cumple = MonthDay.from(nacimiento);
        if (cumple.equals(MonthDay.of(2, 29)) && !hoy.isLeapYear()) {
            cumple = MonthDay.of(2, 28);
        }
        return cumple.equals(MonthDay.from(hoy));
    }
}
