package algor.queue7;

public class CycleQueue {

    private String[] data;
    private int n = 0;
    private int head;
    private int tail;

    public CycleQueue(int capacity){
        data = new String[capacity];
        n = capacity;
    }

    //入队
    public boolean enQueue(String val){
        if((tail +1)%n == head){
            return false;
        }
        data[tail] = val;
        tail = (tail+1)%n;
        return true;
    }

    //出队
    public String deQueue(){
        if(head == tail){
            return null;
        }
        String val = data[head];
        head = (head+1)%n;
        return val;
    }


}
