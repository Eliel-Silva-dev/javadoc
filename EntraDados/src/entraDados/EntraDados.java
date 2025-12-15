package entraDados;

import java.util.Scanner;


public class EntraDados {
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		
		int med1, med2, med3, med4 = 0;
		
		double res = 0;
		
		System.out.print("Digite a primeira nota do aluno:");
		med1 = scan.nextInt();
		
		System.out.print("Digite a primeira nota do aluno:");
		med2 = scan.nextInt();
		
		System.out.print("Digite a primeira nota do aluno:");
		med3= scan.nextInt();
		
		System.out.print("Digite a primeira nota do aluno:");
		med4 = scan.nextInt();
		
		res = (med1 + med2 + med3 + med4) / 4;
		
		System.out.printf("Com base nas notas obtidas durante o ano legitivo: ( %s, %s, %s, %s ) a media do aluno é: %s", med1, med2, med3, med4, res);
	}
	
	
}
