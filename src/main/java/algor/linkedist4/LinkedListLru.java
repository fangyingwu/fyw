package algor.linkedist4;

/*
* author fyw
*
*/
public class LinkedListLru<T> {


    private static final int default_capacity=10;

    private int capacity;

    private Node<T>  head;

    private int length;

    public LinkedListLru(){
        this.head = new Node<T>();
        this.capacity = default_capacity;
        this.length = 0;
    }

    public LinkedListLru(int capacity){
        this.head = new Node<T>();
        this.capacity = capacity;
        this.length = 0;
    }


    //删除尾结点
    private void deleteEnd(){
        Node headNode = head;
        if(headNode.getNext() == null){
            return;
        }
        while(headNode.getNext().getNext() != null){
           headNode = headNode.getNext();
        }
        Node temp = headNode.getNext();
        temp = null;
        headNode.setNext(null);
        length -- ;
    }


    //获取查找元素的前一个元素
    private Node findPreNode(T data){
        Node node = head;
        while (node.getNext() != null){
            if(data.equals(node.getNext().getElement())){
               return node;
            }
            node = node.getNext();
        }
        return null;
    }

    //链表头部插入结点
    public void insertHead( T data){
        Node temp = head;
        head=new Node(data, temp);
        length++;
    }

    //删除pre结点的下一个结点
    public void deletNext(Node pre){
        Node temp = pre.getNext();
        pre.setNext(temp.getNext());
        temp = null;
        length--;
    }

    public class Node<T> {

        private T element;

        private Node next;

        public Node(T element) {
            this.element = element;
        }

        public Node(T element, Node next) {
            this.element = element;
            this.next = next;
        }

        public Node() {
            this.next = null;
        }

        public T getElement() {
            return element;
        }

        public void setElement(T element) {
            this.element = element;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }


    //浏览数据
    public void visit(T data){
       Node pre = findPreNode(data);
       if(pre != null){
          deletNext(pre);
          insertHead(data);
       }else{
          if(length >=capacity){
              deleteEnd();
          }
          insertHead(data);
       }
    }

    //打印链表
    private void print(){
        Node node = head.getNext();
        System.out.println(head.getElement()+",");
        while(node != null){
            System.out.println(node.getElement()+",");
            node = node.getNext();
        }
    }

    public static void main(String[] args) {
        LinkedListLru lru = new LinkedListLru();
        lru.visit(1);
        lru.visit(2);
        lru.visit(3);
        lru.print();
    }

}
