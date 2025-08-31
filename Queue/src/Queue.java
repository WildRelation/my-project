import java.util.Arrays;

public class Queue {
    private String[] elements;
    private int n = 0;

    public Queue(int length){
        elements = new String[length];
    }

    public Queue(){
        elements = new String[10];
    }

    public int size(){
        return n;
    }

    private boolean isEmpty(){
        return n==0;
    }

    public void enqueue(String text){
        if(n >= elements.length) resize();
        elements[n] = text;
        n++;
    }

    public String dequeue(){
        if(isEmpty()) throw new IllegalArgumentException("empty!");
        String tmp = elements[0];
        elements[0] = null;
        for (int i = 0; i <n ; i++) {
            elements[i] = elements[i+1];
        }
        n--;
        return tmp;
    }

    private void resize(){
        String[] newQueue = new String[elements.length*2];
        for (int i = 0; i < elements.length ; i++) {
            newQueue[i] = elements[i];
        }
        elements = newQueue;
    }

    @Override
    public String toString(){
        if(n==0)return "[]";
        StringBuilder buffer = new StringBuilder("[" + elements[0]);

        for (int i = 1; i < n; i++) {
            buffer.append("; ").append(elements[i]);
        }
        buffer.append("]");
        return buffer.toString();

    }
}
