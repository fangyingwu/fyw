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


    //两个有序链表的合并(递归)
    public ListNode mergeDg(ListNode l1,ListNode l2){
          if(l1 == null){
              return l2;
          }else if(l2 == null){
              return l1;
          }else if(l1.val <= l2.val){
              l1.next = mergeDg(l1.next,l2);
              return l1;
          }else{
              l2.next = mergeDg(l1,l2.next);
              return l2;
          }
    }

    //两个有序链表的合并(迭代)
    public  ListNode mergeDd(ListNode l1,ListNode l2){
           ListNode prehead = new ListNode(-1);
           ListNode pre = prehead;
           while(l1 != null && l2 != null){
               if(l1.val <= l2.val){
                  pre.next = l1;
                  l1 = l1.next;
               }else{
                   pre.next = l2;
                   l2 = l2.next;
               }
               pre = pre.next;
           }
           pre.next = l1 == null?l2:l1;
           return prehead.next;
    }

    //删除倒数第n个结点(两次遍历)
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pre = head;
        ListNode node = head;
        int length = 0;
        while(head != null){
            length++;
            head = head.next;
        }
        int result = length - n;
        int index=0;

        while(node != null){
            if(index == result-1){
                break;
            }else{
                index++;
                node = node.next;
            }
        }
        if(node != null){
            ListNode temp = node.next;
            node.next = temp.next;
            temp = null;
        }else{
            pre = pre.next;
        }
        return pre;
    }


    //删除倒数第n个结点(一次遍历)
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next =head;
        ListNode first = dummy;
        ListNode second = dummy;
        for(int i=1;i<= n+1;i++){
            first = first.next;
        }
        while (first != null){
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }

    //查找中间结点(单指针)
    public ListNode middleNode1(ListNode head) {
        ListNode pre = head;
        ListNode node = head;
        int length = 0;
        while(head != null){
            length++;
            head = head.next;
        }
        int n = length/2;
        int count=0;
        while(node != null){
            if(count == n){
                return node;
            }
            count++;
            node = node.next;
        }
        return node;
    }

    //查找中间结点（数组）
    public ListNode middleNode2(ListNode head) {
        ListNode[] A = new ListNode[100];
        int t = 0;
        while (head != null) {
            A[t++] = head;
            head = head.next;
        }
        return A[t / 2];
    }

    //查找中间结点(快慢指针法)
    public ListNode middleNode3(ListNode head) {
       ListNode slow = head;
       ListNode fast = head;
       while(fast != null && fast.next != null){
           slow = slow.next;
           fast = fast.next.next;
       }
       return slow;
    }

}
