package concursantes;

import org.springframework.stereotype.Component;

@Component
public class Piano implements Instrumento {

	public void tocar() {
		// TODO Auto-generated method stub
		System.out.println("Clin clin clin clin...");
	}

}
