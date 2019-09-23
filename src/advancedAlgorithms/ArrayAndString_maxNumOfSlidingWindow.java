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
        // 特判
        if (len == 0) {
            return new int[]{};
        }
        // 结果集
        int resLen = nums.length - k + 1;
        int[] result = new int[resLen];
        // 滑动窗口，注意：保存的是索引值
        //使用双端队列，因为它的两头出队时间复杂度为O(1)
        ArrayDeque<Integer> deque = new ArrayDeque<>(k);
        for (int i = 0; i < len; i++) {
            // 当元素从左边界滑出的时候，如果它恰恰好是滑动窗口的最大值
            // 那么将它弹出
            if (i >= k && i - k == deque.getFirst()) {
                deque.pollFirst();
            }
            // 如果滑动窗口非空，新进来的数比队列里已经存在的数还要大
            // 则说明已经存在数一定不会是滑动窗口的最大值（它们毫无出头之日）
            // 将它们弹出
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                deque.pollLast();
            }
            deque.add(i);
            // 队首一定是滑动窗口的最大值的索引
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
		//需要使得list按照升序排序，最后一个元素值最大
		int left, right;
		//求后面所有最大值
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
