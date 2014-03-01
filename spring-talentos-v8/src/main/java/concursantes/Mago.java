package concursantes;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Mago implements Adivinador {
	private String pensamientos;

	@Pointcut("execution(* concursantes.Pensador.pensarEnAlgo(String)) && args(pensamientos)")
	public void pensar(String pensamientos) {
	}

	@Before("pensar(p)")
	public void interceptarPensamientos(String p) {
		System.out.println("Magia....");
		System.out.println("Estos son los pensamientos del voluntario: "
				+ p);
		this.pensamientos = pensamientos;
	}

	public String getPensamientos() {
		return this.pensamientos;
	}
}