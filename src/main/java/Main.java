import accounts.*;

public class Main {
    public static void main(String[] args) {
        Account account1 = new SavingAccount(1, 22000);
        Account account2 = new CreditAccount(2);
        Account account3 = new CheckingAccount(3, 10000);

        account1.pay(-1200);
        account1.pay(1500);
        account1.addMoney(-1000);
        account1.addMoney(1000);
        account1.transfer(account2, -100);
        account1.transfer(account2, 230);
        account1.transfer(account3, 250);
        account1.printBalance();
        System.out.println();

        account2.pay(-1200);
        account2.pay(1500);
        account2.addMoney(-1000);
        account2.addMoney(1000);
        account2.addMoney(700);
        account2.transfer(account1, -100);
        account2.transfer(account1, 230);
        account2.transfer(account3, 250);
        account2.printBalance();
        System.out.println();

        account3.pay(-1200);
        account3.pay(1500);
        account3.addMoney(-1000);
        account3.addMoney(1000);
        account3.addMoney(700);
        account3.transfer(account2, -100);
        account3.transfer(account2, 230);
        account3.transfer(account2, 1000);
        account3.transfer(account1, 250);
        account3.printBalance();
        System.out.println();

        account1.printBalance();
        account2.printBalance();
        account3.printBalance();
    }
}