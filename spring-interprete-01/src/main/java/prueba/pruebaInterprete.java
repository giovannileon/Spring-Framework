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
		// Y solamente puede recibir un interprete en Espa�ol
		// No un interprete en Ingl�s u otros idiomas
		traductor.setInterprete(interprete);
		traductor.setNombre("Carlos Esparza");
		traductor.hablar();

	}

}
