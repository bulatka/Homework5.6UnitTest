package accounts;

public abstract class Account {
    protected int balance;
    protected int number;
    protected String accountType;

    protected abstract boolean payBoolean(int amount);

    protected abstract boolean addMoneyBoolean(int amount);

    protected abstract boolean transferBoolean(Account account, int amount);

    public Account(int number) {
        this.number = number;
    }

    public void printBalance() {
        System.out.println("На счёте №" + number + " ("
                + accountType + ") ---- "
                + balance + " рублей");
    }

    public int getNumber() {
        return number;
    }

    public String getAccountType() {
        return accountType;
    }

    public int getBalance() {
        return balance;
    }

    public void pay(int amount) {
        if (amount < 0) {
            System.out.println("Сумма для оплаты не может быть отрицательной!");
        } else {
            if (this.payBoolean(amount)) {
                System.out.println("Счет №" + this.getNumber() + " ("
                        + this.getAccountType() + ") оплачено " + amount
                        + " рублей. Текущий баланс: " + this.getBalance() + " рублей.");
            } else {
                System.out.println("Оплата данной суммы невозможна! Текущий баланс: "
                        + this.getBalance() + " рублей.");
            }

        }
    }

    public void addMoney(int amount) {
        if (amount < 0) {
            System.out.println("Сумма для пополнения не может быть отрицательной!");
        } else {
            if (this.addMoneyBoolean(amount)) {
                System.out.println("Счет №" + this.getNumber() + " ("
                        + this.getAccountType() + ") пополнен на "
                        + amount + " рублей. Текущий баланс: "
                        + this.getBalance() + " рублей.");
            } else {
                System.out.println("Пополнение на данную суммы невозможно! Текущий баланс: "
                        + this.getBalance() + " рублей.");
            }
        }
    }

    public void transfer(Account account, int amount) {
        if (amount < 0) {
            System.out.println("Сумма для перевода не может быть отрицательной!");
        } else {
            if (this.transferBoolean(account, amount)) {
                System.out.println("Счет №" + this.getNumber() + " ("
                        + this.getAccountType() + ") переведено "
                        + amount + " рублей на Счет №" + account.getNumber() + " ("
                        + account.getAccountType() + "). Текущий баланс: "
                        + this.getBalance() + " рублей.");
            } else {
                System.out.println("Перевод данной суммы невозможен! Текущий баланс: "
                        + this.getBalance() + " рублей.");
            }
        }
    }
}