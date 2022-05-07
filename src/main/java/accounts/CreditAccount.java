package accounts;

public class CreditAccount extends Account {

    public CreditAccount(int number) {
        super(number);
        this.balance = 0;
        this.accountType = "Кредитный";
    }

    @Override
    protected boolean payBoolean(int amount) {
        balance -= amount;
        return true;
    }

    @Override
    protected boolean addMoneyBoolean(int amount) {
        if (balance + amount > 0) return false;
        balance += amount;
        return true;
    }

    @Override
    protected boolean transferBoolean(Account account, int amount) {
        final boolean result = account.addMoneyBoolean(amount);
        if (result) balance -= amount;
        return result;
    }
}