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
//		//ͳ���Ӵ�����ĸ
//		HashMap<Character, Integer> countSubString = new HashMap<Character, Integer>();
//		for(int i = 0; i < t.length(); i++)
//		{
//			int count = countSubString.getOrDefault(t.charAt(i), 0) + 1;
//			countSubString.put(t.charAt(i), count);
//		}
//		//ͳ�ƴ����ڵ���ĸ
//		HashMap<Character, Integer> countWindow =  new HashMap<Character, Integer>();
//		//��������
//		int left = 0, right = 0, required = countSubString.size(), formed = 0;
//		String minString = "";
//		int minsize = Integer.MAX_VALUE;
//		while(right < s.length())
//		{  	
//			//�ұ߻������ҵ����������Ӵ��Ĵ����ұ߽�
//			char c = s.charAt(right);
//			int count = countWindow.getOrDefault(c, 0) + 1;//���������ǲ��������Ӵ�
//			countWindow.put(c, count);
//			//���key��value����ͬ�������һ����ĸ����ȫ������
//			if(countSubString.containsKey(c) && countSubString.get(c).intValue() == countWindow.get(c).intValue())
//			{
//				formed++;
//			}
//			//�ƶ���ߴ���
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
		//Ч����ߵ�ʵ�֣����Խ����������ASCII��Ϊ128λ��������ͳ����ĸ�����İ취����
		char[] sChars = s.toCharArray();
        char[] pChars = t.toCharArray();
        int[] pMap = new int[128];
        int i = 0, j = 0; // ���촰��[i,j-1]
        int count = pChars.length;
        int minLen = s.length() + 1,l = 0,r = 0;
        for (char pChar : pChars)
            pMap[pChar]++;
        while (j < sChars.length) {
            //��С����
            if (pMap[sChars[j]] > 0)
                count--;
            pMap[sChars[j]]--;
            j++;
            //����Ϊ 0˵������[i,j-1] ���� p
            while (count == 0) {
                //���һ����
                if (j - i < minLen) {
                    minLen = j - i;
                    l = i;
                    r = j;
                }
                pMap[sChars[i]]++;
                // ���Ӽ���
                if (pMap[sChars[i]] > 0)
                    count++;
                i++;
            }
        }
        return minLen == s.length() + 1 ? "" : s.substring(l, r);
	}
}
