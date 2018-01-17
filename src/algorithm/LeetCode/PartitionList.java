package algorithm.LeetCode;

public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        ListNode lessNodeHead=head;
        ListNode ResLessNodeHead=lessNodeHead;
        ListNode moreOrEqualNodeHead=head;
        ListNode ResMoreOrEqualNodeHead=moreOrEqualNodeHead;
        ListNode temp=head.next;
        while (temp.next!=null){
            if (temp.val<x){
                lessNodeHead.next=temp;
                lessNodeHead=lessNodeHead.next;
            }
            else {
                moreOrEqualNodeHead.next=temp;
                moreOrEqualNodeHead=moreOrEqualNodeHead.next;
            }
            temp=temp.next;
        }
        lessNodeHead.next=ResMoreOrEqualNodeHead;
        return ResLessNodeHead;
    }
}
