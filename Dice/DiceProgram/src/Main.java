public class Main {
    public static void main(String[] args){
        Dice myDice = new Dice();
        Dice yourDice = new Dice();
        myDice.throwDice();
        yourDice.throwDice();
        System.out.println(myDice.toString());
        System.out.println(yourDice.toString());
    }
}
