/*
* Given a linked list, swap every two adjacent nodes and return its head.
* For example,Given 1->2->3->4, you should return the list as 2->1->4->3.
* Your algorithm should use only constant space.
* You may not modify the values in the list, only nodes itself can be changed.
*
 */
package algorithm;

public class SwapNodesInPairsTwo {
    public ListNode chageNodesTwo(ListNode head){
       ListNode p1=new ListNode(0);
       p1.next=head;
       ListNode p4=p1;
       ListNode p2=head;
       ListNode p3=p1.next.next;

       while (p2.next.next!=null&&p3.next.next!=null){
            p4.next=p3;
            p4.next.next=p2;
            ListNode temp=p4;
            temp=p4.next.next;
            p2=p2.next.next;
            p3=p3.next.next;

       }
       return p1.next;

    }
    public static void main(String[] args){
        ListNode l1=new ListNode(1);
        ListNode l2=new ListNode(3);
        ListNode l3=new ListNode(5);
        ListNode l4=new ListNode(7);
        l1.next=l2;
        l2.next=l3;
        l3.next=l4;
        SwapNodesInPairsTwo swapNodesInPairs=new SwapNodesInPairsTwo();
        ListNode NewList=swapNodesInPairs.chageNodesTwo(l1);
        ListNode p2=NewList;
        while (p2!=null){
            System.out.print(p2.val+"->");
            p2=p2.next;
        }
    }
}
