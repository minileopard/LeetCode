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
		//���������㷨
		List<Integer> res = new ArrayList<Integer>();
		int countString[] = new int[26];//ֻ����Сд��ĸ
		int l = 0, r = 0, countnum = p.length();
		//ͳ��һ���Ӵ�����
		for(int i = 0; i < countnum; i++)
		{
			int index = p.charAt(i) - 'a';
			countString[index]++;
		}
		if(s.length() < p.length())
			return res;
		while(r < s.length())
		{
			//�ƶ��ұ߽�
			while(r < l + p.length())//��l��ʼ�����ڴ�СΪcountnum
			{
				int index = s.charAt(r) - 'a';
				if(countString[index] > 0)
					countnum--;
				countString[index]--;
				System.out.println( "l: " + l + " r: " + r);
				r++;
			}
			if(countnum==0)//�����������
			{
				res.add(l);
			}
			//�ƶ���߽�
			int index = s.charAt(l) - 'a';
			countString[index]++;
			if(countString[index] > 0)
				countnum++;
			l++;
		}
		return res;
    }
}
