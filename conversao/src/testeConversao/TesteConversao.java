package testeConversao;

public class TesteConversao {
	
	public static void main(String[] args) {
		
		double salario = 2700.50;
		int valor = (int) salario; // cast força o java a aceitar o valor double dentro do int mas a parte fracionária será perdida.
		System.out.println(valor);
		
		int valor2 = 2000000000; // acima disso da overflow
		long numeroGrande = 3232323232323234444l; // para numero grandes é necessario especificar o cast no final com (l).
		short numeroPequeno = 22032;
		byte byt = 127;
		
	}
}
