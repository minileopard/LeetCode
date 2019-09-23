package advancedAlgorithms;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class ArrayAndString_maxNumOfSlidingWindow {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] nums = {1,3,-1,-3,5,3,6,7};
//		int k = 3;
		int[] nums = {-7,-8,7,5,7,1,6,0};
		int k = 4;
		int[] res = maxSlidingWindow_ArrayDeque(nums, k);
		if(res == null)
			return;
		for(int i = 0; i < res.length; i++)
		{
			System.out.print(res[i] + " ");
		}
	}
	
	public static int[] maxSlidingWindow_ArrayDeque(int[] nums, int k)
	{
		int len = nums.length;
        // ����
        if (len == 0) {
            return new int[]{};
        }
        // �����
        int resLen = nums.length - k + 1;
        int[] result = new int[resLen];
        // �������ڣ�ע�⣺�����������ֵ
        //ʹ��˫�˶��У���Ϊ������ͷ����ʱ�临�Ӷ�ΪO(1)
        ArrayDeque<Integer> deque = new ArrayDeque<>(k);
        for (int i = 0; i < len; i++) {
            // ��Ԫ�ش���߽绬����ʱ�������ǡǡ���ǻ������ڵ����ֵ
            // ��ô��������
            if (i >= k && i - k == deque.getFirst()) {
                deque.pollFirst();
            }
            // ����������ڷǿգ��½��������ȶ������Ѿ����ڵ�����Ҫ��
            // ��˵���Ѿ�������һ�������ǻ������ڵ����ֵ�����Ǻ��޳�ͷ֮�գ�
            // �����ǵ���
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                deque.pollLast();
            }
            deque.add(i);
            // ����һ���ǻ������ڵ����ֵ������
            if (i >= k - 1) {
                result[i - k + 1] = nums[deque.peekFirst()];
            }
            for(int x:deque)
            {
            	System.out.print(x + " ");
            }
            System.out.println();
        }
        return result;
	}
	
	public static int[] maxSlidingWindow_TreeSet(int[] nums, int k)
	{
		if(nums.length == 0)
		{
			return new int[0];
		}
		int resLen = nums.length - k + 1;
		int[] res = new int[resLen];
		//��Ҫʹ��list���������������һ��Ԫ��ֵ���
		int left, right;
		//������������ֵ
		for(int i = 0; i < resLen; i++)
		{
			left = i;
			right = left + k - 1;
			res[i] = getMax(nums, left, right);
		}
		return res;

	}
	public static int getMax(int[] nums, int left, int right)
	{
		int max = nums[left];
		for(int i = left + 1; i <= right; i++)
		{
			if(nums[i] > max)
				max = nums[i];
		}
		return max;
	}
	
}
