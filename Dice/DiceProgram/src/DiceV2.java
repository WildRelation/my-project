import java.util.Arrays;
import java.util.Scanner;

public class DiceV2 {
    private static final int SIDES = 6;

    private int value = 1;
    private final int[] frequency = new int[SIDES];

    public int roll(){
        value = (int)(Math.random()%6+1);
        frequency[value-1]++;
        return value;
    }

    public void rollTimes(int n){
        for(int i=0; i<n; i++){
            roll();
        }
    }

    public int getValue(){
        return value;
    }

    public int[] getFrequency() {
        return Arrays.copyOf(frequency, frequency.length);
    }

    @Override
    public String toString(){
        return "value=" + value + ", frequency=" + Arrays.toString(frequency);
    }



}