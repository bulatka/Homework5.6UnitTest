package accounts;

public class CheckingAccount extends Account {
    public CheckingAccount(int number, int balance) {
        super(number);
        this.balance = balance;
        this.accountType = "Расчётный";
    }

    @Override
    protected boolean payBoolean(int amount) {
        if (balance < amount) return false;
        balance -= amount;
        return true;
    }

    @Override
    protected boolean addMoneyBoolean(int amount) {
        balance += amount;
        return true;
    }

    @Override
    protected boolean transferBoolean(Account account, int amount) {
        if (balance < amount) return false;
        final boolean result = account.addMoneyBoolean(amount);
        if (result) balance -= amount;
        return result;
    }
}