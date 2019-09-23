package advancedAlgorithms;
class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
}
public class LinkList_1k {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//��������
		ListNode[] lists = new ListNode[3];
		ListNode node00 = new ListNode(1);
		ListNode node01 = new ListNode(4);
		ListNode node02 = new ListNode(5);
		node00.next = node01;
		node01.next = node02;
		ListNode node10 = new ListNode(1);
		ListNode node11 = new ListNode(3);
		ListNode node12 = new ListNode(4);
		node10.next = node11;
		node11.next = node12;
		ListNode node20 = new ListNode(2);
		ListNode node21 = new ListNode(6);
		node20.next = node21;
		lists[0] = node00;
		lists[1] = node10;
		lists[2] = node20;
		//����1����ͨ����
		//ListNode res = mergeKLists(lists);
		//����2�����η���
		ListNode res = mergeAllList(lists);
		while(res!=null)
		{
			System.out.print(res.val + " ");
			res = res.next;
		}
	}
	//���η��������������ϲ�
	public static ListNode mergeAllList(ListNode[] lists)
	{
		if(lists.length == 0 || lists == null)
            return null;
		return merge(lists, 0, lists.length - 1);
	}
	public static ListNode merge(ListNode[] lists, int left, int right)
	{
		if(left == right)
			return lists[left];
		int mid = left + (right - left)/2;
		ListNode l1 = merge(lists, left, mid);
		ListNode l2 = merge(lists, mid + 1, right);
		return mergeTwoList(l1, l2);
	}
	public static ListNode mergeTwoList(ListNode listA, ListNode listB) 
	{
//		����1, ���ֵݹ��ʵ�ַ���Ҳ�ǳ�������ַ��ε�˼�������棬ѧϰһ�¡�
//		if(listA == null) return listB;
//		if(listB == null) return listA;
//		if(listA.val < listB.val)
//		{
//			listA.next = mergeTwoList(listA.next, listB);
//			return listA;
//		}else
//		{
//			listB.next = mergeTwoList(listA, listB.next);
//			return listB;
//		}
		//����2, ��������ʵ�֡�
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
	
	//һ�㷽����ÿ��ѡ����С�Ľ��
	public static ListNode mergeKLists(ListNode[] lists) {
		if(lists.length == 0)
            return null;
        ListNode root = new ListNode(1);
        ListNode res = root;
        int nextI = findMin(lists);
        while(lists[nextI] != null)
        {
            System.out.println(nextI);
            root.next = lists[nextI];
            root = root.next;
            lists[nextI] = lists[nextI].next;
            nextI = findMin(lists);
        }
        return res.next;
    }
    public static int findMin(ListNode[] lists)
    {
        int min = Integer.MAX_VALUE, minindex = 0;
        for(int i = 0; i < lists.length; i++)
        {
            if(lists[i] == null)
            {
                continue;
            }
            else if(lists[i].val < min)
            {
                min = lists[i].val;
                minindex = i;
            }
        }
        return minindex;
    }
}
