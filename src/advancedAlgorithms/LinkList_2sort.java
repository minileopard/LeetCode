package advancedAlgorithms;

import java.util.ArrayList;
import java.util.Arrays;

import javax.print.attribute.IntegerSyntax;

public class LinkList_2sort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//��������
		ListNode node00 = new ListNode(8);
		ListNode node01 = new ListNode(4);
		ListNode node02 = new ListNode(5);
		ListNode node03 = new ListNode(1);
		node00.next = node01;
		node01.next = node02;
		node02.next = node03;
		//
		ListNode res = sortList(node00);
		while(res!=null)
		{
			System.out.print(res.val + " ");
			res = res.next;
		}
	}
	public static ListNode sortList(ListNode head) {
		//�鲢�����ʱ�临�Ӷ�O(nlogn)�Ƚ��ʺ�, ����ָ��ȷ���յ�
		//ʵ��1
//		if (head == null || head.next == null)
//            return head;
//        ListNode fast = head.next, slow = head;
//        while (fast != null && fast.next != null) {
//            slow = slow.next;
//            fast = fast.next.next;
//        }
//        ListNode tmp = slow.next;
//        slow.next = null;
//        ListNode left = sortList(head);
//        ListNode right = sortList(tmp);
//        ListNode h = new ListNode(0);
//        ListNode res = h;
//        while (left != null && right != null) {
//            if (left.val < right.val) {
//                h.next = left;
//                left = left.next;
//            } else {
//                h.next = right;
//                right = right.next;
//            }
//            h = h.next;
//        }
//        h.next = left != null ? left : right;
//        return res.next;
		//�鲢����ݹ�ʵ��2
		if (head == null || head.next == null)
			return head;
		//cut
        //��slow��һ���У�����SOF������43��432�������
        ListNode pre=head,slow=head,fast=head;
        while (fast!=null&&fast.next!=null){
            pre=slow;
            slow=slow.next;
            fast=fast.next.next;
        }
        pre.next=null;
		//sort
        ListNode l1,l2;
        l1=sortList(head);
        l2=sortList(slow);
        //merge
        return merge(l1,l2);
		
    }
	public static ListNode merge(ListNode listA, ListNode listB)
	{
		if(listA == null) return listB;
		if(listB == null) return listA;
		ListNode root = new ListNode(1);
		ListNode temp = root;
		while(listA!=null && listB!=null)
		{
			if(listA.val < listB.val){
				root.next = listA;
				listA = listA.next;
			}
			else
			{
				root.next = listB;
				listB = listB.next;
			}
			root = root.next;
		}
		if(listA!=null)
			root.next = listA;
		if(listB!=null)
			root.next = listB;
		return temp.next;
	}
	
}
