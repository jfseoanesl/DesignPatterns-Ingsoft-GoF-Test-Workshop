package edu.ingsoft.taller.dobles.caso05;

import java.util.Map;

public class ConfirmacionCompra {
    private final Inventario inventario;

    public ConfirmacionCompra(Inventario inventario) {
        this.inventario = inventario;
    }

    public boolean confirmar(Map<String, Integer> items, String tarjeta, long total) {
        for (Map.Entry<String, Integer> item : items.entrySet()) {
            if (inventario.disponible(item.getKey()) < item.getValue()) {
                return false;
            }
        }
        items.forEach(inventario::reservar);
        String autorizacion = SdkBanco.autorizar(tarjeta, total);
        if (autorizacion == null) {
            items.forEach(inventario::liberar);
            return false;
        }
        SdkBanco.capturar(autorizacion);
        return true;
    }
}
