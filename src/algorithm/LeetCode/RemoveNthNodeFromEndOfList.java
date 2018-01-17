package algorithm.LeetCode;

class ListNode{
    int val;
    ListNode next;
    ListNode(int x){val=x;}
}
public class RemoveNthNodeFromEndOfList {
    public static ListNode removeNthEnd(ListNode head, int n) {
        ListNode first = new ListNode(0);
        first.next = head;
        ListNode p1 = first;
        ListNode p2 = first;
        int i = 0;
        while (p1.next != null) {
            p1 = p1.next;
            i++;
        }
        if (n >= i)
            return head.next;
        else {
            for (int j = 0; j < i - n; j++)
                p2 = p2.next;
            p2.next = p2.next.next;
        }
        return head;
    }
    public static void main(String[] args){
        ListNode listNode1=new ListNode(1);
        ListNode listNode2=new ListNode(2);
        ListNode listNode3=new ListNode(3);
        ListNode listNode4=new ListNode(4);
        listNode1.next=listNode2;
        listNode2.next=listNode3;
        listNode3.next=listNode4;
        System.out.println(removeNthEnd(listNode1,2).next.next.val);
    }
}

