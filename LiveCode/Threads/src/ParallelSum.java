import java.util.Random;

class SumTask extends Thread {

    private final int fromIndex, toIndex;
    private long partialSum;
    private final int[] ints;

    public SumTask(int fromIndex, int toIndex, int[] ints) {
        this.fromIndex = fromIndex;
        this.toIndex = toIndex;
        this.ints = ints;
    }

    long getPartialSum() {
        return partialSum;
    }

    @Override
    public void run() {
        partialSum = 0;
        for (int i = fromIndex; i < toIndex; i++) {
            partialSum += ints[i];
        }
    }
}

public class ParallelSum {
    /*
        Calculate the sum of a large number of int:s in four parallel threads
     */
    public static void main(String[] args) throws InterruptedException {
        int[] ints = generateInts(1_000_000_00);
        long sum = 0;
        int step = 1_000_000_00/4;
        // create four sum tasks (separate threads)
        // ...
        SumTask task1 = new SumTask(0, step, ints);
        SumTask task2 = new SumTask(step, 2*step, ints);
        SumTask task3 = new SumTask(2*step, 3*step, ints);
        SumTask task4 = new SumTask(3*step, 4*step, ints);


        // start the threads/tasks and measure the time to sum the integers in parallel
        long startTime = System.nanoTime();

        task1.start();
        task2.start();
        task3.start();
        task4.start();

        task4.join();
        task3.join();
        task2.join();
        task1.join();
        System.out.println("started");

        long elapsedTime = System.nanoTime() - startTime;

        System.out.println("elapsed time: " + elapsedTime / 1_000_000_000.0 + " s");
        sum = task1.getPartialSum()+task2.getPartialSum()+task3.getPartialSum()+task4.getPartialSum();
        System.out.println("sum: " + sum);
    }

    public static int[] generateInts(int size) {
        int[] ints = new int[size];
        Random rand = new Random();
        for (int i = 0; i < ints.length; i++) {
            ints[i] = rand.nextInt(1000);
        }
        return ints;
    }
}