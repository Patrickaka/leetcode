class Bank {

    static long[] balance;

    static int index;

    public Bank(long[] balance) {
        Bank.balance = balance;
        index = balance.length;
    }

    public boolean transfer(int account1, int account2, long money) {
        if (account1 > index || account2 > index) {
            return false;
        }
        if (balance[account1 - 1] < money) {
            return false;
        } else {
            balance[account1 - 1] -= money;
            balance[account2 - 1] += money;
            return true;
        }
    }

    public boolean deposit(int account, long money) {
        if (account > index) {
            return false;
        }
        balance[account - 1] += money;
        return true;
    }

    public boolean withdraw(int account, long money) {
        if (account > index || balance[account - 1] < money) {
            return false;
        }
        balance[account - 1] -= money;
        return true;
    }
}

/**
 * Your Bank object will be instantiated and called as such:
 * Bank obj = new Bank(balance);
 * boolean param_1 = obj.transfer(account1,account2,money);
 * boolean param_2 = obj.deposit(account,money);
 * boolean param_3 = obj.withdraw(account,money);
 */