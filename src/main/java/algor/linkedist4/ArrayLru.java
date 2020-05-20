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


    //以end为结点左边全部右移
    public void  rightShift(int end){
       for(int i=end-1;i>=0;i--){
           data[i+1] = data[i];
           holder.put(data[i],i+1);
       }
    }

    //如果缓存已满，将最后一个踢出，并将数组缓存到头部
    public void removeAndCache(T object){
        T key = data[--count];
        holder.remove(key);
        cache(object,count);
    }

    //缓存数据
    public void cache(T object,int end){
        rightShift(end);
        data[0] = object;
        holder.put(object,0);
        count++;
    }

    //如果缓存中有指定的值，则更新位置


    //数组是否已满
    public boolean isFull() {
        return count == capacity;
    }


    //判断数组是否为空
    public boolean isEmpty() {
        return count == 0;
    }

    //判断数据缓存是否存在
    public boolean isContain(T object) {
        return holder.containsKey(object);
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

    //向缓存中访问某个值
    public void visit(T object){
        if(object == null){
            return;
        }
        Integer index = holder.get(object);
        if(index == null){
            if(isFull()){
                removeAndCache(object);
            }else{
                cache(object,count);
            }
        }else{
            mod(index);
        }
    }

    //如果缓存中又指定的值，则更新位置
    public void mod(int end){
        T value = data[end];
        rightShift(end);
        data[0] = value;
        holder.put(value,0);
    }


    public static void main(String[] args) {
        ArrayLru<Integer> lru = new ArrayLru<Integer>();
        lru.visit(1);
        lru.visit(2);
        lru.visit(3);
        lru.visit(4);
        lru.visit(5);
        System.out.println(lru);
        lru.visit(6);
        lru.visit(7);
        lru.visit(8);
        lru.visit(9);
        lru.visit(10);
        lru.visit(11);
        System.out.println(lru);
    }

}
