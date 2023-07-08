public interface Account {
    public abstract void setBalance(long amount);

    public abstract long getBalance();

    public abstract boolean add(long amount);

    public abstract boolean pay(long amount);

    public abstract  boolean readyForTransfer(long amount);

    public abstract boolean transfer(Account account, long amount);
}
