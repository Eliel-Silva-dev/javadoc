package com.hydrahtec.exceptiondoc;

import com.hydrahtec.exceptiondoc.entities.AccountEntity;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Locale;
import java.util.Scanner;

@SpringBootApplication
public class ExceptiondocApplication {

	public static void main(String[] args) {
		//SpringApplication.run(ExceptiondocApplication.class, args);

		Locale.setDefault(Locale.US);

		Scanner sc = new Scanner(System.in);
		System.out.println("Informe os dados da conta");
		System.out.println("Numero: ");
		int number = sc.nextInt();

		System.out.println("Titular: ");
		sc.nextLine();
		String holder = sc.nextLine();

		System.out.println("Saldo inicial: ");
		Double balance = sc.nextDouble();

		System.out.println("Limite de saque: ");
		Double withdrawLimit = sc.nextDouble();

		AccountEntity acc = new AccountEntity(number, holder, balance, withdrawLimit);

		System.out.println();
		System.out.println("Quanto você quer sacar do saldo de: " + balance);
		double amount = sc.nextDouble();

		if (amount > acc.getWithdrawLimit()) {
			System.out.println("Erro de saque: A quantia excede o limite de saque.");
		} else if (amount > acc.getBalance()) {
			System.out.println("Erro de saque: Saldo insuficiente");
		} else {
			acc.withdraw(amount);
			System.out.printf("Novo saldo: %.2f%n", acc.getBalance());
		}

		sc.close();

	}

}
