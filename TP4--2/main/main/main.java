package main;

import infraestructure.data.LecturaDeArchivo;
import infraestructure.ui.MandarMail;
import model.DefaultSaludarEmpleado;

public class main {
	public static void main(String[] args) {

		DefaultSaludarEmpleado saludar = new DefaultSaludarEmpleado(new LecturaDeArchivo("Empleados"),
				new MandarMail());

		saludar.enviarSaludo();

	}

}
