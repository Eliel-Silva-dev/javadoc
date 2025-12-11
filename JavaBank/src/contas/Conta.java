package contas;

import cliente.Cliente;

//saldo, agencia, numero, titular

public class Conta {

	double saldo;
	int agencia = 42;
	int numero;
	public Cliente titular;

	public void deposita(double valor) {
		this.saldo = this.saldo + valor;
	}
	
	public boolean sacar(double valor) {
		if (this.saldo >= valor) {
			this.saldo = this.saldo - valor;
			return true;
		} else {
			System.out.println("Saldo insufuciente!!!");
			return false;
		}
	}
	
	public boolean transfere(double valor, Conta destino) {
		if (this.saldo >= valor) {
			this.saldo -= valor;
			destino.deposita(valor);
			return true;
		} else {
			System.out.println("Saldo insuficiente!!");
			return false;
		}
	}
}
