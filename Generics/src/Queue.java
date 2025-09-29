
import java.util.Arrays;

public class Queue <E> {
    private E[] elements;
    private int n;
    //private Array[] = on;
    public Queue(){
        elements = (E[])new Object[10];
        n = 0;
    }
    public Queue(int capacity){
        elements = (E[]) new Object[capacity];
        n = 0;
    }

    public boolean isEmpty(){
        return n==0;
    }
    public void resize(){
        E[] tmp = (E []) new Object[elements.length*2];
        for (int i = 0; i < elements.length; i++) {
            tmp[i] = elements[i];
        }
        elements = tmp;
    }

    public E dequeue(){
        if(isEmpty()) throw new IllegalStateException("Empty");
        E element = elements[0];
        for (int i = 0; i < size(); i++) {
            elements[n+1] = elements[n];
        }
        n--;
        return element;
    }
    public int size(){
        return elements.length;
    }

    public void enqueue(E object){
        if(elements.length<=n) {
            elements[n] = object;
            n++;
        }
       // else throw new IllegalArgumentException();
    }

    @Override
    public String toString() {
        return "Queue{" +
                "elements=" + Arrays.toString(elements) +
                ", n=" + n +
                '}';
    }
}
