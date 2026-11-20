package edu.ingsoft.taller.dobles.caso05;

public interface Inventario {
    int disponible(String sku);

    void reservar(String sku, int cantidad);

    void liberar(String sku, int cantidad);
}
