package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
		LocalDate fechaNac = LocalDate.parse(this.fechaNacimiento, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		return fechaNac;
	}

	public String obtenerNombre() {
		return this.nombre;
	}

	public boolean cumploAnios() {
		LocalDate fechaDeHoy = LocalDate.now();

		if (!fechaDeHoy.getMonth().equals(obtenerFecha().getMonth())) {
			return false;
		} // preguntarle al empleado

		if (!Integer.valueOf(fechaDeHoy.getDayOfMonth()).equals(Integer.valueOf(obtenerFecha().getDayOfMonth()))) {
			return false;
		}

		return true;
	}
}
