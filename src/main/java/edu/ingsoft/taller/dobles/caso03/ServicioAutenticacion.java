package edu.ingsoft.taller.dobles.caso03;

import java.util.HashMap;
import java.util.Map;

public class ServicioAutenticacion {
    static final int MAX_INTENTOS = 3;
    private final ServicioCredenciales credenciales;
    private final RegistroAuditoria auditoria;
    private final Alertas alertas;
    private final Map<String, Integer> intentos = new HashMap<>();

    public ServicioAutenticacion(ServicioCredenciales credenciales, RegistroAuditoria auditoria,
                                 Alertas alertas) {
        this.credenciales = credenciales;
        this.auditoria = auditoria;
        this.alertas = alertas;
    }

    public ResultadoLogin iniciarSesion(String usuario, String clave) {
        if (usuario == null || usuario.isBlank()) {
            throw new IllegalArgumentException("Usuario requerido");
        }
        if (intentos.getOrDefault(usuario, 0) >= MAX_INTENTOS) {
            return ResultadoLogin.BLOQUEADO;
        }
        if (credenciales.valida(usuario, clave)) {
            intentos.remove(usuario);
            return ResultadoLogin.EXITOSO;
        }
        auditoria.registrar("LOGIN_FALLIDO", usuario);
        int n = intentos.merge(usuario, 1, Integer::sum);
        if (n == MAX_INTENTOS) {
            alertas.cuentaBloqueada(usuario);
            return ResultadoLogin.BLOQUEADO;
        }
        return ResultadoLogin.FALLIDO;
    }
}
