package calculadoraJava;

public class CalculadoraJava {
	// projeto de calculadora em Java
	
	public static void main(String[] args) {
		int pos = 7;
		
		switch(pos) {
			case 1:
				System.out.println("Primeira posição");
				break;
			case 2:
				System.out.println("Segunda posição");
				break;
			case 3:
				System.out.println("Terceira posição");
				break;
			case 4:
				System.out.println("Quarta posição");
				break;
			case 5:
				System.out.println("Quinta posição");
				break;
			default:
				System.out.println("Você não obteve pontos suficientes");
				break;
		}
		
	}

}
