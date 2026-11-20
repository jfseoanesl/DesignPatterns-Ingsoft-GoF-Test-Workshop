package edu.ingsoft.taller.dobles.caso04;

public class ExportadorPdf implements Exportador {
    private static final String RUTA = "/srv/registro/certificados";

    @Override
    public String exportar(String nombre, String contenido) {
        // genera el PDF y lo escribe en el servidor de archivos
        return RUTA + "/" + nombre + ".pdf";
    }
}
