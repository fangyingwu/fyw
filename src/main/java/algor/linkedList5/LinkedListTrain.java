package algor.linkedList5;

import java.util.HashSet;
import java.util.Set;

/*
* author fyw
*
1.单链表反转

2.链表中环的检测

3.两个有序的链表合并

4.删除链表倒数第 n 个结点

5.求链表的中间结点
*/
public class LinkedListTrain {


    //声明链表对象
    public class ListNode{
        private int val;
        private ListNode next;
        ListNode(int x){
            val = x;
        }
    }

    //链表反转(迭代法)
    public ListNode reverseList(ListNode head){
        ListNode pre = null;
        ListNode current = head;
        while(current != null){
            ListNode nextTemp = current.next;
            current.next = pre;
            pre = current;
            current = nextTemp;
        }
        return pre;
    }

    //链表反转(递归)
    public ListNode reverseListDg(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode current = reverseListDg(head.next);
        head.next.next = head;
        head.next = null;
        return current;
    }


    //查询连接中是否有环(哈希表)
    public boolean hasCycleHash(ListNode head){

        Set<ListNode> hash = new HashSet<ListNode>();
        while(head != null){
              if(hash.contains(head)){
                  return true;
              }else {
                  hash.add(head);
              }
              head = head.next;
        }
        return false;
    }


    //查询连接中是否有环(快慢指针)
    public boolean hasCycleFastAndSlow(ListNode head){
        if(head == null || head.next == null){
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while(slow != fast){
            if(fast == null || fast.next == null){
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }






}
