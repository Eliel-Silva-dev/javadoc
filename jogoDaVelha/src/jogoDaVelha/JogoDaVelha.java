package jogoDaVelha;

import java.util.Scanner;

public class JogoDaVelha {
	
	public static void main(String[] args) {
		
		Campo[][] velha = new Campo[3][3];
		char simboloAtual = 'X';
		String vitoria = "";
		boolean jogoAtivo = true;
		Scanner scan = new Scanner(System.in);
		
		iniciarJogo(velha);
		
		while (jogoAtivo) {
			
			desenhaJogo(velha);
			vitoria = verificaVitoria(velha);
			
			if(!vitoria.equals("")) {
				System.out.printf("Jogador %s venceu", vitoria);
				
				break;
			}
			
			try {
				
				if (verificaJogada(velha,jogar(scan, simboloAtual), simboloAtual)) {
					
					if(simboloAtual == 'X') {
						simboloAtual = 'O';
					} else {
						simboloAtual = 'X';
					}
				}
				
			} catch (Exception e) {
				System.out.printf("Erro");
			}
			
			
		}
		
		System.out.printf("Fim de jogo...");
	}
	
	public static void desenhaJogo(Campo[][] velha) {
		
		limparTela();
		
		System.out.println("    0   1   2");
		System.out.printf ("0   %c | %c | %c%n",velha[0][0].getSimbolo(), velha[0][1].getSimbolo(),velha[0][2].getSimbolo());
		System.out.println("   ------------");
		
		System.out.printf ("1   %c | %c | %c%n",velha[1][0].getSimbolo(), velha[1][1].getSimbolo(),velha[1][2].getSimbolo());
		System.out.println("   ------------");
		
		System.out.printf ("2   %c | %c | %c%n",velha[2][0].getSimbolo(), velha[2][1].getSimbolo(),velha[2][2].getSimbolo());
	}
	
	public static void limparTela() {
		for(int cont = 0; cont < 50; cont++) {
			System.out.println("");
		}
	}
	
	public static int[] jogar(Scanner scan, char simboloAtual) {
		
		int[] p = new int[2];
		
		System.out.printf("%s %c%n", "Quem joga: ", simboloAtual);
		
		System.out.print("Informe a linha");
		p[0] = scan.nextInt();

		System.out.print("Informe a coluna");
		p[1] = scan.nextInt();
		
		return p;
	}
	
	public static boolean verificaJogada(Campo[][] velha, int[] p, char simboloAtual) {
		if (velha[p[0]][p[1]].getSimbolo()== ' ') {
			
			velha[p[0]][p[1]].setSimbolo(simboloAtual);
			return true;
		} else {
			return false;
		}
	}
	
	public static void iniciarJogo(Campo[][] velha) {
		for(int l = 0; l<3; l++) {
			for(int c = 0; c < 3; c++) {
				velha[l][c] = new Campo();
			}
		}
	}
	
	public static String verificaVitoria(Campo[][] velha) {
		
		String res = "";
		
		// verificar por linha
		for(int l = 0; l < 3; l++) {
			
			if((velha[l][0].getSimbolo()==velha[l][1].getSimbolo()) && (velha[l][0].getSimbolo()==velha[l][2].getSimbolo())) {
				
				res = velha[l][0].getSimbolo() != ' ' ? String.valueOf(velha[l][0].getSimbolo()) : "";
				
				break;
			} else {
				continue;
			}
		}
		
		//verificar por coluna
		for(int c = 0; c < 3; c++) {
			
			if((velha[0][c].getSimbolo()==velha[1][c].getSimbolo()) && (velha[0][c].getSimbolo()==velha[2][c].getSimbolo())) {
				
				res = velha[0][c].getSimbolo() != ' ' ? String.valueOf(velha[0][c].getSimbolo()) : "";
				
				break;
			} else {
				continue;
			}
		}
		
		//verificar na trasversal
		
			
		if((velha[0][0].getSimbolo()==velha[1][1].getSimbolo()) && (velha[0][0].getSimbolo()==velha[2][2].getSimbolo())) {
			
			res = velha[0][0].getSimbolo() != ' ' ? String.valueOf(velha[0][0].getSimbolo()) : "";
			
		} 
		
		if((velha[0][2].getSimbolo()==velha[1][1].getSimbolo()) && (velha[0][2].getSimbolo()==velha[2][0].getSimbolo())) {
			
			res = velha[0][2].getSimbolo() != ' ' ? String.valueOf(velha[0][2].getSimbolo()) : "";
			
		} 
		
		return res;
		
	}
}
