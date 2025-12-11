package cliente;

import contas.Conta;

public class testaBanco {

	public static void main(String[] args) {
		Cliente mateus = new Cliente();
		
		mateus.CPF = "111.111.111-11";
		mateus.nome = "Mateus souza da silva";
		mateus.profissao = "Programador";
		
		Conta contaDoMateus = new Conta();
		contaDoMateus.titular = mateus;
		
		System.out.println(contaDoMateus.titular.nome);
		System.out.println(contaDoMateus.titular.CPF);
		System.out.println(contaDoMateus.titular.profissao);
		System.out.println(contaDoMateus.saldo);
		
	}
}
