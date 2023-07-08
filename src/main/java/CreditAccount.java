public class CreditAccount implements Account {

    private long balance;
    private long creditLimit;

    public CreditAccount(long balance, long creditLimit) {
        if (balance <= 0 && balance >= creditLimit && creditLimit < 0) {
            this.balance = balance;
            this.creditLimit = creditLimit;
        }
    }

    @Override
    public void setBalance(long balance) {
        this.balance += balance;
    }

    @Override
    public long getBalance() {
        return balance;
    }

    public void setCreditLimit(long creditLimit) {
        if (creditLimit < 0 && creditLimit < this.balance) {
            this.creditLimit = creditLimit;
        }
    }

    public long getCreditLimit() {
        return creditLimit;
    }

    @Override
    public boolean add(long amount) {
        if (balance + amount <= 0) {
            setBalance(amount);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean pay(long amount) {
        if (balance - amount >= creditLimit) {
            setBalance(amount * -1);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean readyForTransfer(long amount) {
        return balance + amount <= 0;
    }

    @Override
    public boolean transfer(Account account, long amount) {
        if (account.readyForTransfer(amount) && balance - amount >= creditLimit) {
            setBalance(amount * -1);
            account.setBalance(amount);
            return true;
        } else {
            return false;
        }
    }
}


