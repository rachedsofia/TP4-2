package main;

import java.awt.EventQueue;
import java.sql.SQLException;

import infraestructure.data.JdbcInscripcion;
import infraestructure.ui.AgregarParticipante;
import model.DefaultNuevaInscripcion;

public class Main {
	public static void main(String[] args) throws SQLException {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new AgregarParticipante(new DefaultNuevaInscripcion(
							new JdbcInscripcion("jdbc:mysql://localhost:3306/tp4-participante", "root", "")));
				} catch (Exception e) {
					System.out.println(e);
				}
			}
		});

	}
}
