import java.util.SortedMap;

public class Main {
    public static void main(String[] args) {

        Queue q1 = new Queue(3);
        q1.enqueue("xd");
        q1.enqueue("nigga");
        q1.enqueue("pantera");
        q1.enqueue("nose");
        q1.enqueue("neggy");
        Queue q2 = new Queue(7);
        System.out.println(q1);
        System.out.println(q1.size());

        q1.dequeue();
        System.out.println(q1);
        String s = q1.dequeue();
        System.out.println("Dequeued: "+ s);
        System.out.println(q1);





    }
}