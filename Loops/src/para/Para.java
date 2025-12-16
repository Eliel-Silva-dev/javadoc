package para;

public class Para {
	
	// Usado quando se sabe quantas vezes o loop será execultado. 
	// a variavel contadora é inicialixada no inicio do loop 
	//junto com a condição e o incremento
	
	public static void main(String[] args) {
		
		for (int cont = 0; cont < 5; cont++) {
		
			System.out.println((cont + 1) + " - Posição...");
		}
		

		System.out.println("\nFim do loop");
	}
		

}
