package allQuestions;

import java.util.HashMap;

public class Q3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "abbbba";
		System.out.println(lengthOfLongestSubstring(s));
	}
	public static int lengthOfLongestSubstring(String s) {
		//��������
		int left = 0, right = 0, slen = s.length(), res = 0;
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for( ;left < slen && right < slen; right++)
		{
			char c = s.charAt(right);
			if(map.containsKey(c))//���ظ��Ļ��Ͱ�left�ƶ�����һ��c���±�+1��λ��
			{
				//����left���˵�ǰһ����ͬ��ĸ��λ�����磺abbba���һ��ʱ����˵���һ��b
				left = Math.max(left, map.get(c));
			}
			map.put(c, right + 1);//��c���±�+1�ŵ�map��
			res = Math.max(res, right - left + 1);
		}
        return res;
    }
}
