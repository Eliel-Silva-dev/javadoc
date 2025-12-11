package variaveis;

public class FloatDouble {

	public static void main(String[] args) {
		
		double hora = 3;
		System.out.println("Agora são exatamente " + hora + " horas");
		
		double conta = 3.0 / 2;
		System.out.println("Se um dos lados for do tipo double o resultado será double: 3.4 / 2 = " + conta);
		
		int conta2 = 3 / 2;
		System.out.println("Uma variavel int só aceita valores int, então uma divisão de numeros inteiros como: 3 / 2 \n"
				+ "terá resultado inteiro: " + conta2 + " desconsiderando a parte fracionaria: 0.5 ");
		
		double conta3 = 3 / 2;
		System.out.println("Mesmo mudando o tipo da variavel para double não teremos o resultado de 1.5 e sim (" + conta3 + ") \n"
				+ "porque o java faz a divisão dos inteiros, desconsidera a parte fracionária e força o resultado no formato double");
		
		double conta4 = 3.0 / 2;
		System.out.println("Para se obter um resulta double, um dos valores deve ser do tipo double: 3.0 / 2 = " + conta4);
	}
}
