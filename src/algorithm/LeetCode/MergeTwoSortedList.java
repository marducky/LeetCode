package algorithm.LeetCode;

public class MergeTwoSortedList {
    public static ListNode mergeList(ListNode head1,ListNode head2){
        ListNode newHead=head1.next;
        ListNode p1=head1.next;
        ListNode p2=head1.next;
        if (head1==null)
            return head2;
        if (head2==null)
            return head1;
        ListNode p3=newHead;
        while (p1.next!=null&&p2.next!=null){
            if (p1.val>p2.val){
                p3=p2.next;
                p2=p2.next;
            }
            else {
                p3=p1.next;
                p1=p1.next;
            }
            if (p1.next==null)
                p3=p2.next;
            else
                p3=p2.next;

        }
        return newHead;
    }
}

