package edu.ingsoft.taller.dobles.caso04;

import java.util.Locale;

public class EmisorCertificados {

    public String emitir(Estudiante e, TipoCertificado tipo, String formato) {
        if (tipo == TipoCertificado.MATRICULA && !e.matriculaActiva()) {
            throw new IllegalStateException("El estudiante no tiene matrícula activa");
        }
        Exportador exportador;
        switch (formato) {
            case "PDF" -> exportador = new ExportadorPdf();
            case "HTML" -> exportador = new ExportadorHtml();
            default -> throw new IllegalArgumentException("Formato no soportado: " + formato);
        }
        String nombre = tipo.name().toLowerCase() + "-" + e.nombre().replace(' ', '_');
        return exportador.exportar(nombre, redactar(e, tipo));
    }

    private String redactar(Estudiante e, TipoCertificado tipo) {
        if (tipo == TipoCertificado.NOTAS) {
            return String.format(Locale.forLanguageTag("es-CO"),
                    "Se certifica que %s, del programa %s, tiene un promedio acumulado de %.1f.",
                    e.nombre(), e.programa(), e.promedio());
        }
        return "Se certifica que " + e.nombre() + " se encuentra matriculado en " + e.programa() + ".";
    }
}
