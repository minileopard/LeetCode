package lls;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class No1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		List<String> list = new ArrayList<String>();
		String temp;
		//���ػس����ܽ�ֹ���룬��OJϵͳ�޷�ͨ��
//		while(!(temp = in.nextLine()).equals(""))
//		{
//			list.add(temp);
//		}
		//OJϵͳ�ܹ�ͨ������Ϊ��������ļ������Ǳ����޷������в��ԣ���Ϊ�����޷�ֹͣ
		while(in.hasNext())
		{
			temp = in.nextLine();
			list.add(temp);
		}
		in.close();
		int listsize = list.size();
		int listcol = list.get(0).split(" ").length;
		int nums[][] = new int[listsize][listcol];
		for(int i = 0; i < listsize; i++)
		{
			String[] temps = list.get(i).split(" ");
			for(int j = 0; j < listcol; j++)
			{
				nums[i][j] = Integer.parseInt(temps[j]);
			}
		}
		
	}

}
