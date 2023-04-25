package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import Domain.portsin.SaludarEmpleado;
import Domian.portsout.EmpleadoRecord;
import Domian.portsout.LeerEmpleados;
import infraestructure.ui.MandarMail;

public class DefaultSaludarEmpleado implements SaludarEmpleado {
	private LeerEmpleados leerEmpleados;
	private MandarMail mandarMail;
	private List<Empleado> listaEmpleados;

	public DefaultSaludarEmpleado(LeerEmpleados lectura, MandarMail notificar) {
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
			if (quienCumpleAnios(empleado.obtenerFecha())) {
				this.mandarMail.enviar(empleado.obtenerMail(), "Feliz Cumpleaños", " Te deseamos un hermoso día");
			}
		}
	}

	private boolean quienCumpleAnios(LocalDate fecha) {
		LocalDate fechaDeHoy = LocalDate.now();

		if (!fechaDeHoy.getMonth().equals(fecha.getMonth())) {
			return false;
		}

		if (!Integer.valueOf(fechaDeHoy.getDayOfMonth()).equals(Integer.valueOf(fecha.getDayOfMonth()))) {
			return false;
		}

		return true;
	}

}
