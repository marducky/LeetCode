//import java.util.LinkedList;
//
//public class AddTwoNumber {
//    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//       int carry=0;
//       ListNode newHead=new ListNode(0);
//       ListNode p1=l1,p2=l2,p3=newHead;
//       while (p1!=null||p2!=null){
//           if (p1!=null){
//               carry+=p1.val;
//               p1=p1.next;
//           }
//       }
//    return null;
//    }
//
//}
/**************************************************************
 * Copyright (c) 2016
 * All rights reserved.
 * 版 本 号：v1.0
 * 题目描述：You are given two linked lists representing two non-negative numbers.
 * 			The digits are stored in reverse order and each of their nodes contain a single digit.
 * 			Add the two numbers and return it as a linked list.
 * 			Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 *			Output: 7 -> 0 -> 8
 *			给定两个包含正数的链表，这个链表只能存储个位数，以链表的形式返回这个链表各位相加的和。
 * 输入描述：wu
 * 程序输出： 算法1的输出为：
 *			0->0->10->
 *			算法2的输出为：
 *			8->0->0->2->
 * 问题分析：不能试着将链表计算的和赋给其中一个链表，并返回，应当重新建立一个新的链表，用来保存相加的和
 * 算法描述：这是个只能保存个位的链表，即在相加的过程中可能出现进位，例如：9->9->9链表和8这个链表相加的结果应为0->0->0->1，
 * 			所以应当重新定义一个链表。不能将两个链表相加的和作为L1或L2链表返回，因为这要会很麻烦，
 * 			应该重新建立一个链表，保存每个节点相加和进位的和。最后应该判断，进位标志位是否任然不为0，
 * 			这时应该继续创建新的节点，并将进位标志作为节点的值。
 * 完成时间：2016-11-01
 ***************************************************************/

class ListNode{
    int val;
    ListNode next;
    ListNode(){

    }
    ListNode(int x){
        val = x;
    }
    public String toString(){
        return val + "";
    }
}
class SolutionMethod1{
    public ListNode addTwoNumbers(ListNode l1,ListNode l2){
        if(l1 == null && l2 == null)
            return null;
        if(l1 == null && l2 != null)
            return l2;
        if(l1 != null && l2 == null)
            return l1;

        int tmp;
        ListNode root = new ListNode(0);

        root.next = l2;
        while(l1 != null && l2 != null){

            tmp = l1.val + l2.val;
            if(tmp >=10 && l1.next != null){
                tmp = tmp - 10;
                ++l1.next.val;
                if(l1.next.val >=10 && l1.next.next != null){
                    l1.next.val = l1.next.val - 10;
                    ++l1.next.next.val;

                }
                else if(l1.next.val >=10 && l1.next.next == null){
                    l1.next.val = l1.next.val - 10;
                    l1.next.next = new ListNode(1);
                }
            }
            l2.val = tmp;
            if(l2.next == null){
                l2.next = l1.next;
                l1 = l1.next;
                break;
                //l2.val = 0;
            }else{
                l1 = l1.next;
                l2 = l2.next;
            }
        }
        return root.next;
    }
}
class SolutionMethod2{
    public ListNode addTwoNumbers(ListNode l1,ListNode l2){
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }

        ListNode head = new ListNode(0);			//重新定义一个链表
        ListNode point = head;
        int carry = 0;								//进位标志位
        while(l1 != null && l2 != null){			//当两个链表都不为空时，即先计算两个链表都有节点的部分
            int sum = carry + l1.val + l2.val;		//和为进位+l1+l2
            point.next = new ListNode(sum%10);		//和10取余，作为返回的链表的每个节点的结果
            carry = sum/10;							//判断家和后是否有进位标志位
            l1 = l1.next;
            l2 = l2.next;
            point = point.next;
        }

        while(l1 != null){							//l1不为null时，表示l1后面还有节点
            int sum = carry + l1.val;				//进位和l1节点值相加
            point.next = new ListNode(sum%10);
            carry = sum/10;
            l1 = l1.next;
            point = point.next;
        }

        while(l2 != null){
            int sum = carry + l2.val;
            point.next = new ListNode(sum%10);
            carry = sum/10;
            l2 = l2.next;
            point = point.next;
        }

        if(carry != 0){
            point.next = new ListNode(carry);	//如果两个链表相加后，还有进位，则重新建立一个节点，并将point指向该节点
        }
        return head.next;			//返回head.next，即point链表
    }
}
public class AddTwoNumber {
    public static void main(String[] args){
        ListNode list11 = new ListNode(8);
        ListNode list12 = new ListNode(9);
        ListNode list13 = new ListNode(9);

        ListNode list21 = new ListNode(2);

        list11.next = list12;
        list12.next = list13;
        list13.next = null;
        list21.next = null;

//		ListNode list11 = new ListNode(9);
//		ListNode list12 = new ListNode(9);
////		ListNode list13 = new ListNode(3);
////		ListNode list14 = new ListNode(1);
////		ListNode list15 = new ListNode(5);
//
//	//	ListNode list11 = null;
//		ListNode list21 = new ListNode(9);
////		ListNode list22 = new ListNode(6);
////		ListNode list23 = new ListNode(6);
//
////		ListNode list24 = new ListNode(6);
////		ListNode list25 = new ListNode(4);
////		ListNode list21 = null;
//
////		list11.next = null;
//		list11.next = list12;
//		list12.next = null;
////		list12.next = list13;
////		list13.next = list14;
////		list14.next = list15;
////		list15.next = null;
//	//	list13.next = null;
//
//		list21.next = null;
//	//	list21.next = list22;
////		list22.next = list23;
////		list23.next = list24;
////		list24.next = list25;
////		list25.next = null;
////		list23.next = null;
        System.out.println("算法1的输出为：");
        SolutionMethod1 solution1 = new SolutionMethod1();
        ListNode result1 = solution1.addTwoNumbers(list11, list21);

        SolutionMethod2 solution2 = new SolutionMethod2();
        ListNode result2 = solution2.addTwoNumbers(list11, list21);


        while(result1 != null){				//打印输出链表结果的方法
            System.out.print(result1 + "->");
            result1 = result1.next;
        }
        System.out.println();
        System.out.println("算法2的输出为：");
        while(result2 != null){				//打印输出链表结果的方法
            System.out.print(result2 + "->");
            result2 = result2.next;
        }
    }
}
