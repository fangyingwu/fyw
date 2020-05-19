package algor.linkedist4;


import java.util.HashMap;
import java.util.Map;

/*
* author fyw
* 数组方式实现LRU缓存淘汰
*/
public class ArrayLru<T> {

    private static final int default_capacity = 10;

    private int capacity;

    private T[] data;

    private int count;

    private Map<T,Integer> holder;

    public ArrayLru(){
        this(default_capacity);
    }


    public ArrayLru(int capacity){
        this.capacity = capacity;
        data = (T[])new Object[capacity];
        count=0;
        holder = new HashMap<T, Integer>(capacity);
    }


    //如果




    //数组是否已满
    public boolean isFull() {
        return count == capacity;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(data[i]);
            sb.append(" ");
        }
        return sb.toString();
    }

}
