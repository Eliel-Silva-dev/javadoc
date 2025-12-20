package calculadoraJava;

import java.util.Scanner;

public class CalculadoraJava {
	// projeto de calculadora em Java
	
	public static void main(String[] args) {
		
		Scanner entrada = new Scanner(System.in);
		
		Numero num1 = new Numero();
		Numero num2 = new Numero();
		Numero res = new Numero();
		
		char opc = 's';
		
		while (opc == 's') {
			System.out.println("Calculo de soma entre dois números:");
			System.out.println("---------------------------------------");

			System.out.print("Digite o primeiro número: ");
			num1.setValor(entrada.nextInt());
			
			System.out.print("Digite o segundo número: ");
			num2.setValor(entrada.nextInt());
			
			res.setValor((num1.getValor() + num2.getValor()));
			
			System.out.printf("A soma entre %d e %d é: %d \n", num1.getValor(), num2.getValor(), res.getValor());
			
			System.out.println("Desejar realizar nova soma? (s/n) ");
			
			opc = entrada.next().toLowerCase().charAt(0);
			
		}
		
	}

}
