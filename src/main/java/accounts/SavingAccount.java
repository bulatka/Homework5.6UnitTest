package accounts;

public class SavingAccount extends Account {

    public SavingAccount(int number, int balance) {
        super(number);
        this.balance = balance;
        this.accountType = "Cберегательный";
    }

    @Override
    protected boolean payBoolean(int amount) {
        return false;
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