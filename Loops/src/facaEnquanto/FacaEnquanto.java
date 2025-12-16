package facaEnquanto;

public class FacaEnquanto {

	
	public static void main(String[] args) {
		
		// a variavel contadora é inicializada antes do loop
		// o laço será iterado pelo menos uma vez.
		// o teste lógico é realizado no fim do bloco.
		
		int cont = 5;
		
		do {
			
			System.out.println(cont + " Posição...");
			
			cont--;
			
		} while(cont >= 0);

		System.out.println("\nFim do loop...");
	
	}
}
