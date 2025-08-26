public class Main {
    public static void main(String[] args){
        System.out.println("Welcome to the Bank");
        Account customer1  = new Account("Joseph Solsol");
        Account customer2 = new Account("Joseph Test", 1234567890, 400);
        System.out.println(customer1.toString());
        customer1.deposit(400);
        customer1.deposit(600);
        System.out.println(customer1.toString());                                                                       
        customer1.withdraw(800);

        customer1.printAccount();
        customer1.accNo();
        customer2.accNo();

    }
}
