import java.util.ArrayList;

public class ListOfAccounts {


    private final ArrayList<Account> theAccounts;
    private int noOfAccs;

    public ListOfAccounts() {
        theAccounts = new ArrayList<>();
        noOfAccs = 0;
    }


    public void addAccount(Account a) {
        theAccounts.add(a);
        noOfAccs++;
    }

    public double getTotalBalance() {
        double total = 0;
        for (int i = 0; i < noOfAccs; i++) {
            total = total + theAccounts.get(i).getBalance();
        }
        return total;
    }

    public Account findAccount(String name) {
        Account a = null; // initialize
        String foundName;
        for (int i = 0; i < noOfAccs; i++) {
            foundName = theAccounts.get(i).getName();
            if (foundName.equals(name)) { // Not ==!
                a = theAccounts.get(i);
                break;
            }
        }
        return a;
    }

    /*
     * Return a copy of the private array -
     * "return theList;" would return the address/reference
     * to the private array(!)
     */
    public Account[] getTheAccounts() {
        Account[] copy = new Account[noOfAccs];
        for (int i = 0; i < noOfAccs; i++) {
            copy[i] = theAccounts.get(i);
        }
        return copy;
    }

    @Override
    public String toString() {
        StringBuilder info = new StringBuilder();
        info.append("The accounts\n");
        info.append("============\n");
        for (int i = 0; i < noOfAccs; i++) {
            info.append(theAccounts.get(i).toString()).append("\n");
        }
        return info.toString();
    }

}