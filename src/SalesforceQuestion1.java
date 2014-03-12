import java.util.HashMap;

public class SalesforceQuestion1
{
	public String findString(String s)
	{
		HashMap<Integer, Integer> hashMap = new HashMap();
		int maxStart = 0;
		int maxEnd = 0;
		int maxLength = 0;
		int j=0;
		for(int i=0;i<s.length();i++)
		{
			int index = s.charAt(i)-'a';
			if(hashMap.get(index)==null)
				hashMap.put(index,i);
			else if(hashMap.get(index)>=maxEnd)
				{
					int position = hashMap.get(index);
					hashMap.put(index, i);
					if(maxLength < i - j)
					{
						maxLength = i-j;
						maxStart = j;
						maxEnd = i;
					}
					j = position+1;
				}
		}
		String longestOne = s.substring(maxStart,maxEnd);
		return longestOne;
	}
	public static void main(String[]args)
	{
		SalesforceQuestion1 question1 = new SalesforceQuestion1();
		String s = question1.findString("abcdbed");
		System.out.println(s);
		System.out.println(question1.findString("bcdaabcdeeeee"));
		System.out.println(question1.findString("abcabcbb"));

		System.out.println(question1.findString("bbbbb"));
		
		
	}
}