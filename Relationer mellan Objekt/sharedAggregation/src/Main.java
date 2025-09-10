public class Main {
    public static void main(String[] args) {
        ListOfAccounts list = new ListOfAccounts();

        Account a = new Account("Joseph");
        Account b = new Account("Pablo");
        a.deposit(1000);
        b.deposit(500);

        list.addAccount(a);
        list.addAccount(b);
        list.addAccount(new Account("Anders"));

        list.addAccount(new Account("Pacharen"));


        System.out.println(list.toString());

        // Search for a specific Account
        System.out.println("Searching...");
        Account x;
        x = list.findAccount("hej");
        if (x != null) {
            System.out.println("Found\n" + x.toString());
        }
        else System.out.println("User not found!");
    }
}