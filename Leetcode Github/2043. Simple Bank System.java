class Bank {
    private long[] balance;

    public Bank(long[] balance) {
        this.balance = balance;
    }

    public boolean transfer(int account1, int account2, long money) {
        if (!isValid(account1) || !isValid(account2)) return false;
        if (balance[account1 - 1] < money) return false;

        balance[account1 - 1] -= money;
        balance[account2 - 1] += money;
        return true;
    }

    public boolean deposit(int account, long money) {
        if (!isValid(account)) return false;
        balance[account - 1] += money;
        return true;
    }

    public boolean withdraw(int account, long money) {
        if (!isValid(account)) return false;
        if (balance[account - 1] < money) return false;

        balance[account - 1] -= money;
        return true;
    }

    private boolean isValid(int account) {
        return account >= 1 && account <= balance.length;
    }
}