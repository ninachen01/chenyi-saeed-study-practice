package chenyi;

public class TwitterPracticePart2 {
	//找出整数二进制里边被1包围的0的最长数目，比如10001001，返回3， 11000，返回: 0.
	//Look for the max number of 0 between two 1. such as 10001001, return 3;
	//11000 return 0;
	public int lookforMaxZeros(int n)
	{
		String s = Integer.toBinaryString(n);
		Integer pre = null;
		int max = 0;
		for(int i=0;i<s.length();i++)
		{
			if(s.charAt(i)-'0'==1)
			{
				if(pre==null)
					pre = i;
				else
				{
					if(i-pre-1>max)
					{
						max = i-pre-1;
					}
					pre = i;
				}
			}
		}
		return max;
	}
	//第二题是给一个integer array，找出所有可能even pair的个数，even pair就是两个数相加的和是个偶数。要求O(n)。空间好像是1
	
	// 找出一个矩阵里“平衡数”的总个数: 
	//“平衡数”的定义： 这个数所在row之上所有row的数字之和=所在row之: 下所有row的数字之和:这个数所在column左边所有col的数字之和:=所在col右边所有col的数字之和:  
	//时间 O（mxn） 空间O（m+n）
	public static void main(String[]args)
	{
		TwitterPracticePart2 part = new TwitterPracticePart2();
		System.out.println(part.lookforMaxZeros(13));
	}


}
