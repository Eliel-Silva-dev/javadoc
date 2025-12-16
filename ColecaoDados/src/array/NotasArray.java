package array;

import java.util.Scanner;

public class NotasArray {

	public static void main(String[] args) {
		
		Scanner teclado = new Scanner(System.in);
		
		final int QTDQUESTOES = 5;
		
		char[] gabarito = {'a', 'b', 'c', 'd', 'e'};
		char[] respostasAluno = new char[QTDQUESTOES];
		
		int nota = 0;
		int errou = 0;
		
		for(int i = 0; i< QTDQUESTOES; i++) {
			System.out.printf("Digite a %d - nota do aluno: ", (i + 1));
			
			respostasAluno[i] = teclado.nextLine().charAt(0);
		}
		
		for (int i = 0; i< QTDQUESTOES; i++) {
			if(gabarito[i] == respostasAluno[i]) {
				nota++;
			} else {
				errou++;
			}
		}
		
		System.out.println("\n\nA nota do aluno foi: " + nota);
		System.out.printf("\nEle errou %d questões", errou);
		
	}
}
