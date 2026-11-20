package edu.ingsoft.taller.dobles.caso02;

import java.util.List;

/** Utilidad usada en todo el sistema para consultar la base de datos de producción. */
public final class BaseDatos {
    private BaseDatos() {
    }

    public static List<Cliente> consultarClientes() {
        throw new IllegalStateException("Requiere conexión a la base de datos de producción");
    }
}
