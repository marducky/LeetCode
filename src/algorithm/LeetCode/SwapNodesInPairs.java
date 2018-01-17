/*
* Given a linked list, swap every two adjacent nodes and return its head.
* For example,Given 1->2->3->4, you should return the list as 2->1->4->3.
* Your algorithm should use only constant space.
* You may not modify the values in the list, only nodes itself can be changed.
*
 */
package algorithm.LeetCode;

public class SwapNodesInPairs {
    public ListNode chageNodes(ListNode head){
        if (head==null)
            return null;
        ListNode helper=new ListNode(0);
        helper.next=head;
        ListNode pre=helper;
        ListNode cur=head;
        while (cur!=null&&cur.next!=null)
        {
            ListNode below=cur.next.next;
            cur.next.next=cur;
            pre.next=cur.next;
            if (below!=null&&below.next!=null)
                cur.next=below.next;
            else
                cur.next=below;
            pre =cur;
            cur=below;
        }
        return helper.next;
    }
    public static void main(String[] args){
        ListNode l1=new ListNode(1);
        ListNode l2=new ListNode(3);
        ListNode l3=new ListNode(5);
        ListNode l4=new ListNode(7);
        l1.next=l2;
        l2.next=l3;
        l3.next=l4;
        SwapNodesInPairs swapNodesInPairs=new SwapNodesInPairs();
        ListNode NewList=swapNodesInPairs.chageNodes(l1);
        ListNode p2=NewList;
        while (p2!=null){
            System.out.print(p2.val+"->");
            p2=p2.next;
        }
    }
}
