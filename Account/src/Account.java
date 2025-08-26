public class Account {
    private final String name;
    private long accountNumber = 0;
    private double balance;

    public Account(String customer){
        name = customer;
        balance = 0;
    }
    public Account(String name, long accountNumber, int balance){
        this.name = name;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void accNo(){
        String info = String.format("Your account ID: %d", accountNumber);
        System.out.println(info);
    }

    public void deposit(int amount){
        balance += amount;
    }

    public void withdraw(int amount){
        balance-= amount;
    }


    public void printAccount(){

        String info = String.format("Name: %s: Balance: %.2f", name, balance);
        System.out.println(info);
    }
    @Override
    public String toString(){
        return name + " " + balance;

    }
}
