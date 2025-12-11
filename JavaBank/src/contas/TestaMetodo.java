package contas;

public class TestaMetodo {

	public static void main(String[] args) {
		Conta contaDoMateus = new Conta();
		
		contaDoMateus.saldo = 300;
		
		contaDoMateus.deposita(50);
		
		System.out.println("O saldo da conta do mateus é: " + contaDoMateus.saldo);
		
		contaDoMateus.sacar(100);
		
		System.out.println(contaDoMateus.saldo);

		Conta contaDaMaria = new Conta();
		contaDaMaria.deposita(1000);
		
		System.out.println("O saldo da cona da Maria é de: " + contaDaMaria.saldo + " reais.");
		
		contaDaMaria.transfere(1300, contaDoMateus);
		
		System.out.println("O saldo da cona da Maria depois da transferencia é de: " + contaDaMaria.saldo + " reais.");
		System.out.println("O saldo da conta do mateus após a transferencia é: " + contaDoMateus.saldo + " reais.");


	}
}
