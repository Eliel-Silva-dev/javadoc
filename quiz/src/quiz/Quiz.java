package quiz;

import java.util.Scanner;

public class Quiz {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		final int NUM_PERGUNTAS = 5;
		
		int pontoQuestoes = 2;
		
		char[] gabarito = {'a', 'c', 'b', 'a', 'c'};
		
		String[] perguntas = {
				"Qual a maior estrela do sistema solar?",
				"Qual a primeira letra do nosso alfabeto?",
				"2x10 é igual a?",
				"O fantastico mundo de ________, (desenho anos 80)",
				"Valor de PI",
		};
		
		String[] alternativas = {
			"a) Sol | b) Lua | c) Marte",
			"a) Z | b) C | c) A",
			"a) 10 | b) 20 | c) 12",
			"a) Bob | b) Carl | c) Zec",
			"a) 3.10 | b) 3 | c) 3,14"
		};
		
		char[] respostas = new char[NUM_PERGUNTAS];
		
		char resp;
		
		int nota = 0;
		
		String aluno;
		
		System.out.print("Digige seu nome: ");
		aluno = scan.nextLine();
		
		for(int i = 0; i< NUM_PERGUNTAS; i++) {
			System.out.println("-----------------------------------------------\n");
			System.out.printf("Pergunta %d%n", i + 1);
			System.out.printf("%s%n", perguntas[i]);
			System.out.printf("%s%n", alternativas[i]);
			
			resp = scan.next().toLowerCase().charAt(0);
			
			respostas[i] = resp;
			
		}
		
		System.out.printf("%s%n", "\nFim da prova, confira o resultado: \n");
		
		for(int i = 0; i < NUM_PERGUNTAS; i++) {
			if (gabarito[i] == respostas[i]) {
				nota += pontoQuestoes;
			}
		}
		
		System.out.printf("%s Sua nota foi %d, você foi %s",aluno, nota, nota>=6? "Aprovado": "Reprovado");
		
	}
	
}
