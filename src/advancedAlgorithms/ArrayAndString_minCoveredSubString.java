package advancedAlgorithms;

import java.util.HashMap;
import java.util.Map;

public class ArrayAndString_minCoveredSubString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "ooBADOBAECODEBAC";//ooBADOBAECODEBAC
		String t = "BAC";
		System.out.println(FindMin(s,t));
	}
	public static String FindMin(String s, String t)
	{
//		if(s.length() == 0 || t.length() == 0)
//			return "";
//		//统计子串的字母
//		HashMap<Character, Integer> countSubString = new HashMap<Character, Integer>();
//		for(int i = 0; i < t.length(); i++)
//		{
//			int count = countSubString.getOrDefault(t.charAt(i), 0) + 1;
//			countSubString.put(t.charAt(i), count);
//		}
//		//统计窗口内的字母
//		HashMap<Character, Integer> countWindow =  new HashMap<Character, Integer>();
//		//滑动窗口
//		int left = 0, right = 0, required = countSubString.size(), formed = 0;
//		String minString = "";
//		int minsize = Integer.MAX_VALUE;
//		while(right < s.length())
//		{  	
//			//右边滑动，找到包含所有子串的窗口右边界
//			char c = s.charAt(right);
//			int count = countWindow.getOrDefault(c, 0) + 1;//无需区分是不是属于子串
//			countWindow.put(c, count);
//			//如果key与value均相同，则代表一种字母被完全包含了
//			if(countSubString.containsKey(c) && countSubString.get(c).intValue() == countWindow.get(c).intValue())
//			{
//				formed++;
//			}
//			//移动左边窗口
//			while (left <= right && formed == required) {
//				c = s.charAt(left);
//				int size = right - left + 1;
//				if(size < minsize)
//				{
//					minsize = size;
//					minString = s.substring(left, right + 1);
//				}
//				countWindow.put(c, countWindow.get(c) - 1);
//				if(countSubString.containsKey(c) && countSubString.get(c).intValue() > countWindow.get(c).intValue())
//				{
//					formed--;
//				}
//				left++;
//			}
//			right++;
//		}
//		return minString;
		//效率奇高的实现，可以借鉴这种利用ASCII码为128位构造数组统计字母个数的办法！！
		char[] sChars = s.toCharArray();
        char[] pChars = t.toCharArray();
        int[] pMap = new int[128];
        int i = 0, j = 0; // 考察窗口[i,j-1]
        int count = pChars.length;
        int minLen = s.length() + 1,l = 0,r = 0;
        for (char pChar : pChars)
            pMap[pChar]++;
        while (j < sChars.length) {
            //减小计数
            if (pMap[sChars[j]] > 0)
                count--;
            pMap[sChars[j]]--;
            j++;
            //计数为 0说明区间[i,j-1] 包含 p
            while (count == 0) {
                //求得一个解
                if (j - i < minLen) {
                    minLen = j - i;
                    l = i;
                    r = j;
                }
                pMap[sChars[i]]++;
                // 增加计数
                if (pMap[sChars[i]] > 0)
                    count++;
                i++;
            }
        }
        return minLen == s.length() + 1 ? "" : s.substring(l, r);
	}
}
