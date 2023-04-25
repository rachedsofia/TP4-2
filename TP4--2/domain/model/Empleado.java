package model;

import java.time.LocalDate;
import java.util.Objects;

public class Empleado {
	private String nombre;
	private String apellido;
	private String mail;
	private String fechaNacimiento;

	public Empleado(String nombre, String apellido, String mail, String fechaDeNacimiento) {
		this.nombre = Objects.requireNonNull(nombre);
		this.apellido = Objects.requireNonNull(apellido);
		this.mail = Objects.requireNonNull(mail);
		this.fechaNacimiento = Objects.requireNonNull(fechaDeNacimiento);
	}

	public String obtenerMail() {
		return this.mail;
	}

	public LocalDate obtenerFecha() {
		LocalDate fechaNac = LocalDate.parse(this.fechaNacimiento);
		return fechaNac;
	}

	public String obtenerNombre() {
		return this.nombre;
	}
}
