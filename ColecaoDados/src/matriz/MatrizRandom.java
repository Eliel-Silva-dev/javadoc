package matriz;

import java.security.SecureRandom;

public class MatrizRandom {

	public static void main(String[] args) {
		
		final int LINHA = 3;
		final int COLUNA= 5;
		
		int[][] matriz = new int[LINHA][COLUNA];
		
		PreencheMatriz(LINHA, COLUNA, matriz);
		
		MostraMatriz(LINHA, COLUNA, matriz);
		
	}
	
	public static void PreencheMatriz (int LINHA, int COLUNA, int[][] mat) {
		for (int l = 0; l < LINHA; l++) {
			
			for(int c = 0; c < COLUNA; c++) {
				mat[l][c] = new SecureRandom().nextInt(100);
			}
		};
	}
	
	public static void MostraMatriz (int LINHA, int COLUNA, int[][] mat) {
		for (int l = 0; l < LINHA; l++) {
			
			for(int c = 0; c < COLUNA; c++) {
				System.out.printf("%d -", mat[l][c]);
			}
			System.out.printf("%n");
		};
	}
}
