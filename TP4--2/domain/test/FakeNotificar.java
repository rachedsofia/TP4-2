package test;

import Domian.portsout.Mandar;

public class FakeNotificar implements Mandar {
	private String mensaje;

	@Override
	public void enviar(String destinatario, String asunto, String mensaje) {
		this.mensaje = destinatario + asunto + mensaje;

	}

	public String getMensaje() {
		return this.mensaje;
	}

}
