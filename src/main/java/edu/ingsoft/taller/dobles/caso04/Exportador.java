package edu.ingsoft.taller.dobles.caso04;

public interface Exportador {
    /** Exporta el contenido y devuelve la ubicación del documento generado. */
    String exportar(String nombre, String contenido);
}
