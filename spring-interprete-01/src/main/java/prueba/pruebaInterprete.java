package prueba;

import beans.InterpreteEsp;
import beans.Traductor;

public class pruebaInterprete {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Traductor traductor = new Traductor();
		InterpreteEsp interprete = new InterpreteEsp();
		// El interprete se inyecta manualmente
		// Y solamente puede recibir un interprete en Español
		// No un interprete en Inglés u otros idiomas
		traductor.setInterprete(interprete);
		traductor.setNombre("Carlos Esparza");
		traductor.hablar();

	}

}
