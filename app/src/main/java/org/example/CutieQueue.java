package org.example;
import java.util.ArrayList;


public class CutieQueue<T> {
    private ArrayList<T> queue;
    private int max_size;

    CutieQueue(int max_size){
        this.max_size = max_size;
        queue = new ArrayList<>();
    }


    CutieQueue(ArrayList<T> queue, int max_size){
        this.max_size = max_size;
        this.queue = queue;
    }

    void enqueue(T obj){
       if(queue.size() != max_size){
           queue.addLast(obj);
       }
       else System.out.println("The Queue is Full. No Changes to the Queue.");
    }

    void dequeue(){
        queue.removeFirst();
    }

    boolean full(){
        return queue.size() == max_size;
    }

    int size(){return queue.size();}

    T get (int ind){
        return queue.get(ind);
    }

}
