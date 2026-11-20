package edu.ingsoft.taller.dobles.caso05;

/** SDK oficial del banco (no modificable). Autorizar devuelve null si se rechaza. */
public final class SdkBanco {
    private SdkBanco() {
    }

    public static String autorizar(String tarjeta, long monto) {
        throw new IllegalStateException("Conexión con el banco no disponible");
    }

    public static void capturar(String codigoAutorizacion) {
        throw new IllegalStateException("Conexión con el banco no disponible");
    }
}
