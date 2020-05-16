package algor.array3;

/*
* author fyw
* 2020-05-16
* */
public class GenericArray<T> {

    private T[] data;
    private int size;


    //构造器有参
    public GenericArray(int capacity){
        data = (T[])new Object[capacity];
        size = 0;
    }

    //无参构造器
    public GenericArray(){
        this(10);
    }

    //获得数组容量
    public int getCapacity(){
        return data.length;
    }

    //获取元素个数
    public int count(){
        return size;
    }

    //判断数组是否为空
    public boolean isEmpty(){
        return size == 0;
    }

    //修改index位置的元素
    public void set(int index, T e){
        if(index < 0 || index >= size){
            throw new IllegalArgumentException("unexpected index value");
        }
        data[index] = e;
    }

    //获取对应index的元素
    public T get(int index){
        if(index < 0 || index >= size){
            throw new IllegalArgumentException("unexpected index value");
        }
        return data[index];
    }

    //查看数组是否包含元素
    public boolean contains(T e){
        for(int i=0;i<size;i++){
            if(data[i].equals(e)){
                return true;
            }
        }
        return false;
    }

    //获取元素下标，未找到，返回-1
    public int find(T e){
        for(int i=0;i<size;i++){
            if(data[i].equals(e)){
                return i;
            }
        }
        return -1;
    }

    //在index位置上插入e，时间复杂度O(m+n)
    public void add(int index,T e){
        checkIndexForAdd(index);
        if(size == data.length){
            //扩容为原始的2为
            resize(2 * data.length);
        }
        for(int i=size-1;i>=index;i--){
            data[i+1] = data[i];
        }
        data[index] = e;
        size++;
    }

    //数组头插元素
    public void addFirst(T e){
        add(0,e);
    }

    //数组尾插入元素
    public void addLast(T e){
        add(size,e);
    }


    //数组扩容 时间复杂度O(n)
    public void  resize(int capacity){
        T[] newData = (T[])new Object[capacity];
        for(int i=0;i<size;i++){
            newData[i]= data[i];
        }
        data = newData;
    }

    //删除index位置元素，并返回
    public T remove(int index){
        checkIndex(index);
        T res = data[index];
        for(int i=index+1;i<size;i++){
            data[i-1] = data[i];
        }
        size--;
        data[size] = null;
        //缩容
        if(size == data.length/4 && data.length/2 != 0){
            resize(data.length/2);
        }
        return res;
    }


    //删除第一个元素
    public void delFirst(){
        remove(0);
    }

    //删除最后一个
    public void delLast(){
        remove(size -1);
    }

    //删除数组中制定值的元素
    public void delEle(T e){
        int index = find(e);
        if(index != -1){
            remove(index);
        }
    }

   //toString
    @Override
    public String toString(){
        StringBuffer buffer = new StringBuffer("[");
        for(int i=0;i<size;i++){
            buffer.append(data[i]);
            if(i != size-1){
                buffer.append(",");
            }
        }
        buffer.append("]");
        return buffer.toString();
    }



    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Add failed! Require index >=0 and index < size.");
        }
    }

    private void checkIndexForAdd(int index) {
        if(index < 0 || index > size) {
            throw new IllegalArgumentException("remove failed! Require index >=0 and index <= size.");
        }
    }
}
