
public class Question1 {
	public int findFirstIndex(int[] s, int number,int origIndex,int endIndex)
	{
		int index = s.length/2;
		int n = s[index];
		if(n == number && s[index-1]<number)
			return index;
		else if(n<number)
		{
			
			findFirstIndex(s,number,index,s.length-1);
		}
		else if(n>=number)
		{
			findFirstIndex(s,number,0,index);
		}
		return -1;
	}
	public int findLastIndex(String s,int number, int origIndex)
	{
		int index = s.length()/2;
		if(s.charAt(index)==number && s.charAt(index+1)>number)
		{
			return origIndex+index;
		}
		else if(s.charAt(index)<=number)
			{
				findLastIndex(s.substring(index,s.length()-1),number,index);
			}
			else if(s.charAt(index)>number)
		{
			findLastIndex(s.substring(0,index),number,0);
		}
		return -1;
		
	}
    public static void main(String[] args)
	{
    	Question1  quetion1 = new Question1();
		int[] string = {0,0,2,3,3,3,3,4,7,7,9};

		
		int firstIndex = quetion1.findFirstIndex(string, 3,0);
		int lastIndex = quetion1.findLastIndex(string, 3,0);
		System.out.println("first" + firstIndex);
		System.out.println("last" + lastIndex);
		
	}

}

