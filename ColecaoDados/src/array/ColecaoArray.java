package array;

public class ColecaoArray {

	public static void main(String[] args) {
		
		// no lugar de declarar varias variaveis independentes podemos colocalas todas em um mesmo vetor
		
		int[] num = new int[5]; // instancia um objeto array de 5 posições, 
		// ira armazenar somente valores inteiros * valores default
		// os valores podem ser atribuidos acessando cada posição pelo indice
		
		num[0] = 10;
		num[1] = 20;
		num[2] = 30;
		num[3] = 40;
		num[4] = 50;
		
		int[] numeros = {10,20,30,40,50}; // cria o array e já atribui os valores diretamente
		// o tamanho do array será deduzido automaticamente
		
		System.out.println("O valor é " + numeros[3]);
	}
}
