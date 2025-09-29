import java.util.Random;

public class SequentialSum {

    /*
        Sequentially calculate the sum of a large number of int:s
     */
    public static void main(String[] args) {
        int[] ints = generateInts(1_000_000_000);

        // measure the time to sum the integers sequentially
        System.out.println("started");
        long startTime = System.nanoTime();
        long sum = 0;
        for (int i = 0; i < ints.length; i++) {
            sum += ints[i];
        }
        long elapsedTime = System.nanoTime()- startTime;

        System.out.println("elapsed time: " + elapsedTime/1_000_000_000.0 + " s");
        System.out.println("sum: " + sum);
    }

    public static int[] generateInts(int size) {
        int[] ints = new int[size];
        Random rand = new Random();
        for(int i = 0; i < ints.length; i++) {
            ints[i] = rand.nextInt(1000);
        }
        return ints;
    }
}