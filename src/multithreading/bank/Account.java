package multithreading.bank;

// Account
//id
//user
//money

//BankAccount src, Account dst, int money
//transferMoney()
//Transaction.start();

//Transaction (поток)



public class Account {
    private int id;
    private String user;
    private int money;

    public Account(int id, String user, int money) {
        this.id = id;
        this.user = user;
        this.money = money;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
