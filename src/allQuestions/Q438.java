package allQuestions;

import java.util.ArrayList;
import java.util.List;

public class Q438 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "cbaebabacd", p = "abc";
		List<Integer> res = findAnagrams(s, p);
		for(int i:res)
		{
			System.out.print(i + " ");
		}
		System.out.println();
	}
	public static List<Integer> findAnagrams(String s, String p) {
		//滑动窗口算法
		List<Integer> res = new ArrayList<Integer>();
		int countString[] = new int[26];//只包括小写字母
		int l = 0, r = 0, countnum = p.length();
		//统计一下子串内容
		for(int i = 0; i < countnum; i++)
		{
			int index = p.charAt(i) - 'a';
			countString[index]++;
		}
		if(s.length() < p.length())
			return res;
		while(r < s.length())
		{
			//移动右边界
			while(r < l + p.length())//从l开始，窗口大小为countnum
			{
				int index = s.charAt(r) - 'a';
				if(countString[index] > 0)
					countnum--;
				countString[index]--;
				System.out.println( "l: " + l + " r: " + r);
				r++;
			}
			if(countnum==0)//如果满足条件
			{
				res.add(l);
			}
			//移动左边界
			int index = s.charAt(l) - 'a';
			countString[index]++;
			if(countString[index] > 0)
				countnum++;
			l++;
		}
		return res;
    }
}
