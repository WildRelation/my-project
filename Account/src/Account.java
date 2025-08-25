public class Account {
    private final String name;
    private long accountNumber;
    private double balance;

    public Account(String customer){
        name = customer;
        balance = 0;
    }

    public void deposit(int amount){
        balance += amount;
    }

    public void withdraw(int amount){
        balance-= amount;
    }

    @Override
    public String toString(){
        return name + " " + balance;

    }
}
