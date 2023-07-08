public class SimpleAccount implements Account {

    private long balance;

    public SimpleAccount(long balance) {
        if (balance > 0) {
            this.balance = balance;
        }
    }

    @Override
    public void setBalance(long amount) {
        this.balance += amount;
    }

    @Override
    public long getBalance() {
        return balance;
    }

    @Override
    public boolean add(long amount) {
        if (balance >= 0) {
            setBalance(amount);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean pay(long amount) {
        if (balance - amount >= 0) {
            setBalance(amount * -1);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean readyForTransfer(long amount) {
        return true;
    }

    @Override
    public boolean transfer(Account account, long amount) {
        if (account.readyForTransfer(amount) && balance - amount >= 0) {
            setBalance(amount * -1);
            account.setBalance(amount);
            return true;
        } else {
            return false;
        }
    }
}
