package contas;

public class TestaMetodo {

	public static void main(String[] args) {
		Conta contaDoMateus = new Conta();
		
		contaDoMateus.deposita(300);
		
		contaDoMateus.deposita(50);
		
		System.out.println("O saldo da conta do mateus é: " + contaDoMateus.getSaldo());
		
		contaDoMateus.sacar(100);
		
		System.out.println(contaDoMateus.getSaldo());

		Conta contaDaMaria = new Conta();
		contaDaMaria.deposita(1000);
		
		System.out.println("O saldo da cona da Maria é de: " + contaDaMaria.getSaldo() + " reais.");
		
		contaDaMaria.transfere(1300, contaDoMateus);
		
		System.out.println("O saldo da cona da Maria depois da transferencia é de: " + contaDaMaria.getSaldo() + " reais.");
		System.out.println("O saldo da conta do mateus após a transferencia é: " + contaDoMateus.getSaldo() + " reais.");


	}
}
