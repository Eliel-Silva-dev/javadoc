package enquanto;

public class Enquanto {

	public static void main(String[] args) {
		
		// usado quando não se sabe quantas vezes será repetido; 
		// a variavel contadora é iniciada antes do loop, a condição é feita no inicio do loop 
		//e o incremento deve ser feito dentro do loop
		
		// -- se a condição não for atendida o laço não será executado nem mesmo 1 vez.
		// Primeiro é feito o teste e depois a execulção.
		
		int max = 5;
		int cont = 0;
		
		while(cont < max) {
			
			System.out.println(cont + " Posição...");
			cont++;
		}
		
	}
}
