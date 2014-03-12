package chenyi;

public class PalindromeStringPractice 
{
	public String findLongestPalindromeSimple(String s)
	{
		String longestOne = String.valueOf(s.charAt(s.length()-1));
	
		for(int i=0;i<s.length();i++)
		{
			 String temp = expandAroundCenter(i,i,s);
			 if(longestOne.length()<temp.length())
				 longestOne = temp;
		}
		for(int i=0;i+1<s.length();i++)
		{
			 String temp = expandAroundCenter(i,i+1,s);
			 if(longestOne.length()<temp.length())
				 longestOne = temp;
		}
		return longestOne;
	}
	public String expandAroundCenter(int left, int right, String s)
	{
		int length = s.length()-1;
		while(left>=0 && right<=length && s.charAt(left) == s.charAt(right))
		{
			left--;
			right++;
		}
		return s.substring(left+1, right);
	}
	public String findLongestPalindromeDP(String s)
	{
		int index = -1;		
		int maxLength=0;
		int length = s.length();
		int[][]table=new int[s.length()][s.length()];
		for(int i =0;i<s.length();i++)
		{
			for(int j =0;j<s.length();j++)
			{
				if(i==j)
					table[i][j]=1;
				else
					table[i][j]=0;
			}
		}
		int j = 0;
		for(int i=1;i<s.length();)
		{
			if(s.charAt(i) == s.charAt(j))
			{
				table[j][i] = 1;
				index = j;
				maxLength = 2;
			}
			i++;j++;
				
		}
		for(int len=3; len<=s.length();len++)
		for(int i = 0 ;i<=length-len;i++)
		{
			j = i+len-1;
			if(s.charAt(i)==s.charAt(j) && table[i+1][j-1]==1 )
			{
				table[i][j]=1;
				index = i;
				maxLength = len;
			}
			
			
		}
		
		return s.substring(index,index+maxLength);
	}
	public int[][] lookForLengthTwoPalindromeDP(String s)
	{
		int[][]table=new int[s.length()][s.length()];
		for(int i =0;i<s.length();i++)
		{
			for(int j =0;j<s.length();j++)
				table[i][j]=0;
		}
		int j = 0;
		for(int i=1;i<s.length();)
		{
			if(s.charAt(i) == s.charAt(j))
			{
				table[j][i] = 1;
			}
			i++;
			j++;
				
		}
		
		return table;
	}
	public void printTable(int[][]table,String s)
	{
		for(int i =0;i<s.length();i++)
		{
			for(int j =0;j<s.length();j++)
				System.out.print(table[i][j]+" ");
			System.out.println();
		}
	}
	public static void main(String[]args)
	{
		PalindromeStringPractice p = new PalindromeStringPractice();
		String s = "aabbaacc";
		System.out.println(p.findLongestPalindromeDP(s));
		System.out.println(p.findLongestPalindromeSimple(s));
		String s1 = "aaabbaaaccaa";
		System.out.println(p.findLongestPalindromeDP(s1));
		System.out.println(p.findLongestPalindromeSimple(s1));
		String s2 = "ededefcabacgbbccbbghhg";
		System.out.println(p.findLongestPalindromeDP(s2));
		System.out.println(p.findLongestPalindromeSimple(s2));

	}
}
