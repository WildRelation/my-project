public class Main {
    public static void main(String[] args){
        System.out.println("Welcome to the Bank");
        Account customer1  = new Account("Joseph Solsol");
        System.out.println(customer1.toString());
        customer1.deposit(400);
        customer1.deposit(600);
        System.out.println(customer1.toString());                                                                       
        customer1.withdraw(800);

        System.out.println(customer1.toString());

    }
}
