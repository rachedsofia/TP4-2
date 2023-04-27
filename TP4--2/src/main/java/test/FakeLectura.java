package test;

import java.util.List;

import Domian.portsout.EmpleadoRecord;
import Domian.portsout.LeerEmpleados;

public class FakeLectura implements LeerEmpleados {
	private List<EmpleadoRecord> lista;

	public FakeLectura(List<EmpleadoRecord> listaEmpleados) {
		this.lista = listaEmpleados;
	}

	@Override
	public List<EmpleadoRecord> Leer() {
		return this.lista;
	}
}
