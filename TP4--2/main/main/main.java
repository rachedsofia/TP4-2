package main;

import infraestructure.data.LecturaDeArchivo;
import infraestructure.ui.MandarMail;
import model.DefaultSaludarEmpleado;

public class main {
	public static void main(String[] args) {

		DefaultSaludarEmpleado saludar = new DefaultSaludarEmpleado(new LecturaDeArchivo("Empleados"), new MandarMail(
				"from@example.com", "tom@example.com", "b78c9f4878db7f", "b4f74a52b601e4", "sandbox.smtp.mailtrap.io"));

		saludar.enviarSaludo();

	}

}
