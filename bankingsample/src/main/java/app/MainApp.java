package app;

import java.util.Scanner;

import exception.BankingException;
import service.BankService;

public class MainApp {
	public static void main(String[] args) {
		BankService bank = new BankService();
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("\n1.create 2.deposit 3.withdraw 4.check 5.exit");
			int choice = sc.nextInt();
			try {
				switch (choice) {
				case 1:
					System.out.println("acc No: ");
					int id = sc.nextInt();
					sc.nextLine();
					System.out.println("name :");
					String name = sc.nextLine();
					System.out.println("balance: ");
					double bal = sc.nextDouble();
					bank.createAccount(id, name, bal);
					break;
				case 2:
					System.out.println("account No");
					bank.deposit(sc.nextInt(), sc.nextDouble());
					break;
				case 3:
					System.out.println("accunt No");
					bank.withdraw(sc.nextInt(), sc.nextDouble());
					break;
				case 4:
					System.out.println("account No:");
					System.out.println(bank.getAccount(sc.nextInt()).getBalance());
					break;
				case 5:
					return;
				}
			} catch (BankingException e) {
				System.out.print("error " + e.getMessage());
			}
		}
	}
}