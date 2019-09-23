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
		if (head == null || head.next == null)
            return head;
        ListNode fast = head.next, slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode tmp = slow.next;
        slow.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(tmp);
        ListNode h = new ListNode(0);
        ListNode res = h;
        while (left != null && right != null) {
            if (left.val < right.val) {
                h.next = left;
                left = left.next;
            } else {
                h.next = right;
                right = right.next;
            }
            h = h.next;
        }
        h.next = left != null ? left : right;
        return res.next;
    }
//	public static ListNode merge(ListNode head, int left, int right)
//	{
//		return head;
//	}
//	public static ListNode mergeTwo(ListNode l1, ListNode l2)
//	{
//		
//		return l2;
//	}
}
