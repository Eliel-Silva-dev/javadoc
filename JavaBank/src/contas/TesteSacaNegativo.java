package contas;

public class TesteSacaNegativo {

	public static void main(String[] args) {
		Conta conta = new Conta();
		conta.deposita(100);
		conta.sacar(200);
		
		System.out.println(conta.getSaldo());
	}
}
