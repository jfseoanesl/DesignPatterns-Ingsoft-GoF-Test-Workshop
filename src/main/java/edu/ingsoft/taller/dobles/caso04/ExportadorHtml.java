package edu.ingsoft.taller.dobles.caso04;

public class ExportadorHtml implements Exportador {
    private static final String URL = "https://portal.universidad.edu.co";

    @Override
    public String exportar(String nombre, String contenido) {
        // publica el HTML en el portal
        return URL + "/certificados/" + nombre;
    }
}
