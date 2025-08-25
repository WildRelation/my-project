import java.util.Arrays;
import java.util.Scanner;

public class Dice{
    private int value;
    private final int[] frequency;
    private int nrTimes;


    public Dice(){
        value = 1;
        frequency = new int[6];
    }
    void throwDice(){
        Scanner scan = new Scanner(System.in);
        System.out.print("How many times do you want to throw? ");
        nrTimes = scan.nextInt();
        for (int i=0; i<nrTimes; i++){
            value = (int)(Math.random()*6)+1;
            frequency[value-1]++;
        }
    }
    int getValue(){
        return value;
    }

    public int[] getFrequency() {
        return frequency;
    }


    @Override
    public String toString(){
        for(int i=0; i< frequency.length; i++)
        {
            if(frequency[i]!=0){
                System.out.println("Nr " + (i+1) + " :" + frequency[i] + " times");
            }
        }
        return  "The value is " + Arrays.toString(getFrequency());
    }


}