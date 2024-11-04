public class Customer {
    private String name;
    private int balance;

    public Customer(String name, int balance) {
        this.name = name;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void pay(double amount) throws Exception {
        if (amount > balance)
            throw new Exception("Insufficient balance.");
        balance -= amount;
    }
}
