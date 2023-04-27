package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import Domain.portsin.SaludarEmpleado;
import Domian.portsout.EmpleadoRecord;
import Domian.portsout.LeerEmpleados;
import Domian.portsout.Mandar;

public class DefaultSaludarEmpleado implements SaludarEmpleado {
	private LeerEmpleados leerEmpleados;
	private Mandar mandarMail;
	private List<Empleado> listaEmpleados;

	public DefaultSaludarEmpleado(LeerEmpleados lectura, Mandar notificar) {
		this.leerEmpleados = Objects.requireNonNull(lectura);
		this.mandarMail = Objects.requireNonNull(notificar);
		this.listaEmpleados = new ArrayList<>();
	}

	@Override
	public void enviarSaludo() {
		List<EmpleadoRecord> listaObjetos = this.leerEmpleados.Leer();

		for (EmpleadoRecord empleadoRecord : listaObjetos) {
			listaEmpleados.add(new Empleado(empleadoRecord.apellido(), empleadoRecord.nombre(), empleadoRecord.mail(),
					empleadoRecord.fechaNacimiento()));
		}

		for (Empleado empleado : listaEmpleados) {
			if (quienCumpleAnios(empleado)) {
				this.mandarMail.enviar(empleado.obtenerMail(), "Feliz Cumpleaños", "Te deseamos un hermoso día");
			}
		}
	}

	private boolean quienCumpleAnios(Empleado empleado) {
		return empleado.cumploAnios();
	}

}
