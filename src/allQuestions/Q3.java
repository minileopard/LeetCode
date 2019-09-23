package allQuestions;

import java.util.HashMap;

public class Q3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "abbbba";
		System.out.println(lengthOfLongestSubstring(s));
	}
	public static int lengthOfLongestSubstring(String s) {
		//滑动窗口
		int left = 0, right = 0, slen = s.length(), res = 0;
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for( ;left < slen && right < slen; right++)
		{
			char c = s.charAt(right);
			if(map.containsKey(c))//有重复的话就把left移动到上一个c的下标+1的位置
			{
				//避免left回退到前一个相同字母的位置例如：abbba最后一个时候回退到第一个b
				left = Math.max(left, map.get(c));
			}
			map.put(c, right + 1);//将c的下标+1放到map中
			res = Math.max(res, right - left + 1);
		}
        return res;
    }
}
