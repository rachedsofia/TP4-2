package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import Domian.portsout.EmpleadoRecord;
import model.DefaultSaludarEmpleado;

public class SaludarEmpleadoTest {
	@Test
	public void enviarSaludoAEmpleados() {
		List<EmpleadoRecord> listaEmpleados = new ArrayList<>();
		listaEmpleados.add(new EmpleadoRecord("Sofia", "Rached", "msofiarached@gmail.com", "2002-09-07"));
		listaEmpleados.add(new EmpleadoRecord("Luciana", "Rached", "lulurached@gmail.com", "2005-05-30"));
		listaEmpleados.add(new EmpleadoRecord("Jorge", "Rached", "msofiarached@gmail.com", LocalDate.now().toString()));

		FakeNotificar notificarFake = new FakeNotificar();
		FakeLectura lecturaFake = new FakeLectura(listaEmpleados);

		DefaultSaludarEmpleado saludarEmpleadoDefault = new DefaultSaludarEmpleado(lecturaFake, notificarFake);

		String resultadoEsperado = "msofiarached@gmail.com" + "Feliz Cumpleaños" + "Te deseamos un hermoso día";

		saludarEmpleadoDefault.enviarSaludo();

		assertEquals(resultadoEsperado, notificarFake.getMensaje());

	}
}
