package edu.ingsoft.taller.dobles.caso02;

import java.time.LocalDate;

public record Cliente(String nombre, String correo, LocalDate nacimiento) {
}
