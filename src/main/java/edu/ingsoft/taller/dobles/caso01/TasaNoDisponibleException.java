package edu.ingsoft.taller.dobles.caso01;

public class TasaNoDisponibleException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public TasaNoDisponibleException(String mensaje) {
        super(mensaje);
    }
}
