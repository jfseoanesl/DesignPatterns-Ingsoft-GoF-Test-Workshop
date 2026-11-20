package edu.ingsoft.taller.dobles.caso02;

/** Cliente del servidor de correo corporativo. */
public class ClienteSmtp {
    private final String servidor;

    public ClienteSmtp(String servidor, int puerto) {
        this.servidor = servidor + ":" + puerto; // abre la conexión
    }

    public void enviar(String para, String asunto, String cuerpo) {
        System.out.println("[" + servidor + "] -> " + para + ": " + asunto);
    }
}
