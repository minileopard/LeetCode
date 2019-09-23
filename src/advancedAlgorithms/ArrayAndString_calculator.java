package advancedAlgorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ArrayAndString_calculator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "  3+5/2 *40 /3+3*2 *2*3-2 -1";
		//String s = "2*2";
		//���������Ĵ��룬�ٿ����Լ���һ���磬��Ц�ˡ���
		/*
		 * ֻ����һ������ջ������ջ��һ������sign�����ˣ�ֻ�洢��һ�����ţ���Ҫ˼�����£�
		������ת��Ϊ�ӷ���ȡ�෴����
		���ڳ˳������ȼ��ߣ�ֱ�Ӽ���
		��������һλ����>10
		���ʽ��û������
		 */
		if (s == null || s.length() == 0) {
            System.out.println(0);
            return;
        }
        s = s.trim();
        char[] sc = s.toCharArray();
        Stack<Integer> stack = new Stack<>();
        int result = 0;
        int num = 0;
        char sign = '+';
        for (int i = 0; i < sc.length; i++) {
            if (sc[i] == ' ') {
                continue;
            }
            if (sc[i] >= '0' && sc[i] <= '9') {
                num = 10 * num + sc[i] - '0';
            }
            if (sc[i] < '0' || sc[i] > '9' || i == sc.length - 1) {
                if (sign == '+') {
                    stack.push(num);
                }
                if (sign == '-') {
                    stack.push(-num);
                }
                if (sign == '*') {
                    stack.push(stack.pop() * num);
                }
                if (sign == '/') {
                    stack.push(stack.pop() / num);
                }
                //�����Ƕ���һ�μ�¼�ķ���sign�Ĳ����������µ�ǰ��sign
                sign = sc[i];
                num = 0;
            }
        }
        while (!stack.isEmpty()) {
            result += stack.pop();
        }
        System.out.println(result);
		
//		//�Ȱѿո����
//		s = s.replaceAll("\\s*", "");
//		//���ַָ�����
//		String[] nums = s.split("\\+|\\-|\\*|\\/");
//		if(nums.length == 0)
//        {
//            System.out.println(0);
//            return ;
//        }else if(nums.length == 1)
//        {
//            System.out.println(Integer.parseInt(nums[0]));
//            return ;
//        }
//		//�������ȡ����
//		List<Character> ch = new ArrayList<Character>();
//		for(int i = 0; i < s.length(); i++)
//		{
//			if(s.charAt(i) == '+' || s.charAt(i) == '-' || s.charAt(i) == '*' || s.charAt(i) == '/')
//			{
//				ch.add(s.charAt(i));
//			}
//		}
//        //���˷������������
//		List<String> l = new ArrayList<String>();
//        for(int i = 0; i < ch.size(); i++)
//        {
//            if(ch.get(i) == '+' || ch.get(i) == '-')
//            {
//                l.add(nums[i]);
//                l.add(String.valueOf(ch.get(i)));
//            }else if(ch.get(i) == '*' || ch.get(i) == '/')
//            {
//                int temp = Integer.parseInt(nums[i]);
//                do {
//                    if(ch.get(i) == '*')
//                    {
//                        temp = temp * Integer.parseInt(nums[i + 1]);
//                    }else if(ch.get(i) == '/')
//                    {
//                        temp = temp / Integer.parseInt(nums[i + 1]);
//                    }
//                    
//                    i++;
//                }while(i < ch.size() && (ch.get(i) == '*' || ch.get(i) == '/') );
//                l.add(String.valueOf(temp));
//                if(i < ch.size())
//                	l.add(String.valueOf(ch.get(i)));
//            }
//        }
//        if(ch.get(ch.size() - 1) == '+' || ch.get(ch.size() - 1) == '-')
//        {
//        	l.add(String.valueOf(nums[nums.length - 1]));
//        }
//        //����Ӽ���
//        for(String a:l)
//        	System.out.print(a + " ");
//        System.out.println();
//        int res = Integer.parseInt(l.get(0));
//        for(int i = 1; i < l.size() - 1; i = i + 2)
//        {
//            if(l.get(i).equals("+"))
//            {
//            	res = res + Integer.parseInt(l.get(i + 1));
//            }else if(l.get(i).equals("-"))
//            {
//            	res = res - Integer.parseInt(l.get(i + 1));
//            }
//        }
//        System.out.println(res);
	}

}
