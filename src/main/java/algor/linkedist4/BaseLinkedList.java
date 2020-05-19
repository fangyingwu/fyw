package algor.linkedist4;
/*
* author fyw
* 单链表插入、修改和查询
*/
public class BaseLinkedList {

    private Node head = null;

    //查找对应值的结点
    public Node findByValue(int value){
        Node p = head;
        while(p != null && p.data != value){
             p = p.next;
        }
       return p;
    }

    public Node findByIndex(int index){
       Node p = head;
       int pos = 0;
       while(p != null && pos != index){
           p = p.next;
           pos++;
       }
       return p;
    }


    public void insertToHead(int value){
        Node newNode = new Node(value,null);
        insertToHead(newNode);
    }

    //插入头部
    public void insertToHead(Node newNode){
         if(head == null){
             head = newNode;
         }else{
             newNode.next = head;
             head = newNode;
         }
    }


    //插入尾部
    public void insertTail(int value){
        Node newNode = new Node(value,null);
        if(head == null){
            head = newNode;
        }else{
            Node q = head;
            while(q.next != null){
                q = q.next;
            }
            newNode.next = q.next;
            q.next = newNode;
        }
    }

    //插入某结点之后
    public void insertAfter(Node p,int value){
         Node newNode = new Node(value,null);
         insertAfter(p,newNode);
    }

    public void insertAfter(Node p,Node newNode){
       if(p == null){
           return;
       }
       newNode.next = p.next;
       p.next = newNode;
    }

    //插入某结点之前
    public void insertBefore(Node p,int value){
        Node newNode = new Node(value,null);
        insertBefore(p,newNode);
    }

    public void insertBefore(Node p,Node newNode){
        if(p == null){
            return;
        }
        if(head == p){
            insertToHead(newNode);
            return;
        }
        Node q = head;
        while(q != null && q.next != p){
            q = q.next;
        }
        if(q == null){
            return;
        }
        newNode.next = p;
        q.next = newNode;
    }


    //删除某个结点
    public void deleteByNode(Node p){
        Node q =head;
        if(q != null && q.next != p){
            q = q.next;
        }
        if(q == null){
            return;
        }
        q.next = p.next;
    }

    //根据值删除对应结点
    public void deleteByValue(int value){
        if(head == null){
            return;
        }
        Node p = head;
        if(p != null && p.data != value){
            p= p.next;
        }
        if(p == null){
            return;
        }
        p.next = p.next.next;
    }

    //生成结点
    public static Node createNode(int value){
        return new Node(value,null);
    }

    //定义结点
    public static class Node{

        private int data;

        private Node next;

        public Node(int data,Node next){
            this.data = data;
            this.next = next;
        }

        public int getData() {
            return data;
        }


    }

}
