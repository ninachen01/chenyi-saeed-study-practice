package chenyi;

public class KPMStringMatching {
	public int findSubString(String string, String pattern)
	{
		int index=-1;
		int [] learnedRules = preparePattern(pattern);
		int j=0;
		System.out.println(string);
		for(int i=0;i<string.length() ;)
		{
			if(pattern.charAt(j)== string.charAt(i))
			{
				i++;
				j++;
			}
			else if(j==0)
				i++;
			else 
			{
				j = learnedRules[j-1];
			}

			if(j==pattern.length())
			{
				index = i-pattern.length();
				return index;
			}
			
		}
		return index;
	}
	public int[] preparePattern(String pattern)
	{
		int size = pattern.length();
		int [] rules = new int[size]; 
		for(int i=0;i<size;i++)
		{
			rules[i] = 0;
		}
		
		for(int j = 0,i=1;i<size;)
		{
			if(pattern.charAt(j)==pattern.charAt(i))
			{
				rules[i] = j+1;
				i++;
				j++;
			}
			else if(j == 0)
			{
				i++;
			}
			else
			{
				j = rules[j-1];
			}
			
			
		}
		System.out.print(pattern);
		System.out.println();
		return rules;
	}
	public void printPattern(int[]rules)
	{
	
		for(int i =0 ;i<rules.length;i++)
			System.out.print(rules[i]+" ");
		System.out.println();
	}
	public static void main(String[]args)
	{
		KPMStringMatching kpm = new KPMStringMatching();
		String pattern  = "1010100";
		int[]rules = kpm.preparePattern(pattern);
		kpm.printPattern(rules);
		System.out.println(kpm.findSubString("110011111110001010100", pattern));
		pattern  = "12312344";
		int []rules2 = kpm.preparePattern(pattern);
		kpm.printPattern(rules2);
		System.out.println(kpm.findSubString("123333123123445555555", pattern));
		pattern  = "aabbaabbbc";
		int []rules3 = kpm.preparePattern(pattern);
		kpm.printPattern(rules3);

		System.out.println(kpm.findSubString("aabbaabbcaabbaabbbc", pattern));
	}
}
