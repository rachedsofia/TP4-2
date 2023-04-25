package infraestructure.data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import Domian.portsout.EmpleadoRecord;
import Domian.portsout.LeerEmpleados;

public class LecturaDeArchivo implements LeerEmpleados {

	private String archivo;

	public LecturaDeArchivo(String nombreArchivo) {
		this.archivo = Objects.requireNonNull(nombreArchivo);
	}

	@Override
	public List<EmpleadoRecord> Leer() {
		List<EmpleadoRecord> lista = new ArrayList<>();

		try {
			BufferedReader bufferReader = new BufferedReader(new FileReader(this.archivo));

			String cadena;

			while ((cadena = bufferReader.readLine()) != null) {
				String[] atributos = cadena.split(",");

				String apellido = atributos[0];
				String nombre = atributos[1];
				String fechaNacimiento = atributos[2];
				String correo = atributos[3];

				EmpleadoRecord empleado = new EmpleadoRecord(nombre, apellido, correo, fechaNacimiento);
				lista.add(empleado);
			}

			bufferReader.close();

		} catch (IOException e) {

		}

		return lista;
	}

}
