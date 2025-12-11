package contas;

public class CriaConta {
	
	public static void main(String[] args) {
		Conta primeiraConta = new Conta();
		primeiraConta.deposita(200);;
		System.out.println("O saldo da primeira conta é de: " + primeiraConta.getSaldo() + " reais.");
		
		primeiraConta.deposita(100);;
		System.out.println(primeiraConta.getSaldo());
		
		Conta segundaConta = new Conta();
		segundaConta.deposita(50);;
		
		System.out.println(primeiraConta.getSaldo());
		System.out.println(segundaConta.getSaldo());

		System.out.println(primeiraConta.agencia);
		System.out.println(primeiraConta.titular);
	

	}

}
