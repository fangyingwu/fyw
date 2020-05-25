package algor.queue7;

public class ArrayQueue {

    private String[] data;

    private int n=0;

    //head表示对头下标，tail表示队尾下标
    private int head = 0;
    private int tail = 0;

    public ArrayQueue(int capacity){
        data = new String[capacity];
        n = capacity;
    }

    //入队
    public boolean enQueue(String val){
        if(tail == n){
            if(head == 0){
                return false;
            }
            for(int i=head;i<tail;i++){
               data[i-head] = data[i];
            }
            tail -= head;
            head=0;
        }
        data[tail] = val;
        tail++;
        return true;
    }

    //出队
    public String deQueue(){
        if(head == tail){
            return null;
        }
        String val = data[head];
        head++;
        return val;
    }

}
