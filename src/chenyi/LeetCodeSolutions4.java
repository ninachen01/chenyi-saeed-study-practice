package chenyi;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;


public class LeetCodeSolutions4 {
    public ArrayList<String> letterCombinations(String digits) 
    {
    	ArrayList<String> list = new ArrayList<String>();
    	if(digits.isEmpty())
    	{
    		String s ="";
    		list.add(s);
    		return list;
    	}
    	HashMap<Integer,String> hashMap = new HashMap<Integer,String>();
    	char []data= new char[3];
    	data[0]='a';
    	data[1]='b';
    	data[2]='c';
    	hashMap.put(2,String.valueOf(data));
    	for(int i=3;i<=9;i++)
    	{
    		char temp = data[2]; 
    		if(i==8)
    			temp = data[3];
    		if(i==7||i==9)
    			data = new char[4];
    		else
    			data = new char[3];
    		for(int j =0;j<3;j++)
    		{
    			temp = (char) ((int)temp+1);
    			data[j] = temp;
    		}
    		if(i==7||i==9)
    		{
    			temp = (char) ((int)temp+1);
    			data[3] = temp;
    		}
    		hashMap.put(i,String.valueOf(data));
    	}
    	
    	ArrayList<String> charsList = new ArrayList<String>();
    	for(int i=0;i<digits.length();i++)
    	{
    		int digit = digits.charAt(i)-'0';
    		String chars = hashMap.get(digit);
    		charsList.add(chars);   		
    	}
    	list = letterCombo(charsList);
    	return list;
    	
    	 
    }
    private ArrayList<String> letterCombo(ArrayList<String> charsList)
    {
    	ArrayList<String> results = new ArrayList<String>();
    	String roots = charsList.remove(0);
    	int size = charsList.size();

		ArrayList<String> tempResults = new ArrayList<String> ();

    	if(size!=0)
    	{
    		tempResults = letterCombo(charsList);
    	}
    	for(int i = 0;i<roots.length();i++)
    	{
    		char char1 = roots.charAt(i);
			String s = String.valueOf(char1);
    		if(size == 0)
    		{
    			results.add(s);
    		}
    		else
    		{    				    		
	    		for(String temp:tempResults)
	    		{
    				temp = char1+temp;
    				results.add(temp);	    			
	    		}
    		}
    		
    	}
    	return results;
    }
    public boolean isInterleave(String s1, String s2, String s3) {
       
        if(s1.isEmpty() && s2.isEmpty())
        {
        	if(s3.isEmpty())
        		return true;
        	else
        	{
        		return false;
        	}
        }
        if(s1.isEmpty())
        {
        	if(s2.equals(s3))
        		return true;
        	else
        		return false;
        }
        if(s2.isEmpty())
        {
        	if(s1.equals(s3))
        		return true;
        	else
        		return false;
        }
        int size1 = s1.length();
        int size2 = s2.length();
        int size3=s3.length();
        if(size3!=size1+size2)
        	return false;
        boolean[][]dp = new boolean[size2+1][size1+1];
        dp[0][0]=true;
        for(int i=1;i<=size1;i++)
        {
        	boolean res = false;
        	if(s1.charAt(i-1)==s3.charAt(i-1) && dp[0][i-1])
        	{
        		res = true;
        	}
        	dp[0][i] = res;
        	
        }
        for(int i=1;i<=size2;i++)
        {
        	boolean res = false;
        	if(s2.charAt(i-1)==s3.charAt(i-1) && dp[i-1][0])
        		res=true;
        	
        	dp[i][0]=res;        		
        }
        for(int i=1;i<=size2;i++)
        {
        	for(int j=1;j<=size1;j++)
        	{
        		if(dp[i-1][j] && s2.charAt(i-1)==s3.charAt(i+j-1))
        			dp[i][j]=true;
        		if(dp[i][j-1] && s1.charAt(j-1)==s3.charAt(i+j-1))
        			dp[i][j]=true;
        	}
        }
       return dp[size2][size1];  
        
    }
    
    public class IntegerComparator implements Comparator<Integer>
    {

		@Override
		public int compare(java.lang.Integer arg0, java.lang.Integer arg1) {
			// TODO Auto-generated method stub
			if(arg0>arg1)
				return 1;
			else if(arg0<arg1)
				return -1;
				
			return 0;
		}
    	
    }
    public class EmptyQueueException extends Exception
	{
		static  final long serialVersionUID=12222;
	
		public EmptyQueueException(String m, Throwable e)
		{
			super(m,e);
		}
	}

    public boolean isPalindrome(String s) 
    {
       	boolean result = true;
    	if(s==null)
    		return true;
    	if(s.isEmpty())
    		return true;
    	String letters = s.trim().toLowerCase();
    	int size = letters.length();
    	int l=0;;
    	int r=size-1;

    	while(l<r)
    	{
    		while(l<size && !((letters.charAt(l)<='z' && letters.charAt(l)>='a')||(letters.charAt(l)<='9' && letters.charAt(l)>='0')))
    		{
    			l++;    		
    		}
    		while(r>=0 && !((letters.charAt(r)<='z' && letters.charAt(r)>='a')||(letters.charAt(r)<='9' && letters.charAt(r)>='0')))
    		{
    			r--;
    		}
    		if(l>r)
    			break;
    		if(letters.charAt(l)==letters.charAt(r))
    		{
    			l++;
    			r--;
    		}
    		else
    			return false;
    	}
    	return result;
        
    }
    public boolean isPalindromeBetter(int x)
    {
    	if(x<0)
    		return false;
    	if(x == 0)
    		return true;
    	int y = x;
    	int digits=0;
    	while(y>0)
    	{
    		y=y/10;
    		digits++;
    	}
    	y = x;
    	while(x>0)
    	{
    		int i = x%10;
    		int j = y/(int)(Math.pow(10, digits-1));
    		y = y%(int)(Math.pow(10, digits-1));
    		x = x/10;
    		digits--;
    		if(i!=j)
    			return false;
    	}
    	return true;
    }
    public int reverse(int x) 
    {
    	if(x==0)
    		return x;
    	boolean inversion = false;
    	if(x<0)
    	{
    		x = -x;
    		inversion = true;
    	}
    	int number=0;
    	int y = x;
    	int i = 0;
    	while(y>0)
    	{
    		y=y/10;
    		i++;
    	}
    	while(i>0)
    	{
    		number = (int)((x%10) * Math.pow(10, i-1))+number;
    		x = x/10;
    		i--;
    	}
    	if(inversion)
    		number = -number;
    	return number;
        
    }
    public int reverseBetter(int x)
    {
    	if(x==0)
    		return x;
    	boolean inversion = false;
    	if(x<0)
    	{
    		x = -x;
    		inversion = true;
    	}
    	int res = 0;
    	while(x>0)
    	{
    		res = res*10+x%10;
    		x = x/10;
    	}
    	if(inversion)
    		res = -res;
    	return res;
    }
    public boolean isPalindrome(int x) {
    	if(x<0)
    		return false;
    	if(x == 0)
    		return true;
        int digits = (int)Math.log10(x);
        int saved=digits;
        int divided = (int)Math.pow(10, digits);
        int mid = digits/2;
        int result=0;
        int temp=-1;
        while(digits>=0)
        {       
        	int number = x/divided;
         	if(digits==mid)
        	{
        		temp = number;
        	}
         	if(digits==saved)
         		result = number;
         	else
         		result = result ^ number;
        	x = x%divided;
        	divided = divided/10;
        	digits--;
        }
        if((saved+1)%2==0)
        {
        	if(result!=0)
        		return false;
        	else
        		return true;
        }
        else
        {
        	if(result!=temp)
        		return false;
        	else
        		return true;
        }
    }
    public boolean isPalindromeBest(int x)
    {
       	if(x<0)
    		return false;
    	if(x == 0)
    		return true;
    	int div = 1;
    	while(x/div>=10)
    	{
    		div = div*10;    		
    	}
    	while(x>0)
    	{
    		int l = x/div;
    		int r = x%10;
    		if(l!=r)
    			return false;
    		x = (x%div)/10;
    		div = div/100;
    	}
    	return true;
    }
    public int longestConsecutive(int[] num) 
    {
    	int length = num.length;
    	if(length==0)
    		return 0;
    	if(length==1)
    		return 1;
    	HashMap<Integer,LinkedList<Integer>> hashmap = new HashMap<Integer,LinkedList<Integer>>();
        for(int i=0;i<length;i++)
        {
        	if(hashmap.get(num[i])==null)
        	{
            	LinkedList<Integer> list = new LinkedList<Integer>();
            	list.add(num[i]);
             	hashmap.put(num[i], list);             	
        	}
        	else
        	{
        		num[i] = Integer.MIN_VALUE;
        	}       	   
        }
        for(int i=0;i<length;)
        {
    		int key = num[i];
    		boolean possible = false;
    		if(key==Integer.MIN_VALUE || hashmap.get(key)==null)
    		{
    			i++;
    			continue;
    		}
			LinkedList<Integer> list = hashmap.get(key);
    		int number = key+1;
    		if(hashmap.get(number)!=null)
    		{
	    		while(hashmap.get(number)!=null)
	    		{   
	    			LinkedList<Integer> tempResult = hashmap.get(number);
	    			list.addAll(tempResult);
	    			hashmap.remove(number);
	        		number++;
	    		}
	    		possible = true;
    		}
    	
    		number = key-1;
    		if(hashmap.get(number)!=null)
    		{
	    		while(hashmap.get(number)!=null)
	    		{
	    			LinkedList<Integer> tempResult = hashmap.get(number);
	    			list.addAll(tempResult);
	    			hashmap.remove(number);
	        		number--;
	    		}
	    		possible = true;
    		}
        	i++;
        	if(!possible)
        		hashmap.remove(key);
        }
       int longest = 1;
       Iterator<LinkedList<Integer>> iterator = hashmap.values().iterator();
       while(iterator.hasNext())
       {
    	   LinkedList<Integer> result = iterator.next();
    	   if(longest<result.size())
    		   longest= result.size();
       }
       return longest;
    }
    public int[] plusOne(int[] digits) {
    	int length = digits.length;
    	int[] newDigits = new int[length+1];
        if(digits.length==0)
        	return newDigits;
        int lastDigit = digits[length-1];
        if(lastDigit!=9)
        {
        	digits[length-1] ++;
        	return digits;
        }
        for(int i=0;i<length;i++)
        	newDigits[i+1] = digits[i];
        plusOne(newDigits,length);
        if(newDigits[0]==0)
        {
        	for(int i=0;i<length;i++)
        		digits[i]=newDigits[i+1];
        }
        else
        	return newDigits;
        return digits;
    }
    private void plusOne(int[]digits,int i)
    {
    	if(digits[i]==9)
    	{
    		digits[i]=0;
        	plusOne(digits,i-1);
    	}
    	else
    	{
    		digits[i]++;
    	}

    }
    public void setZeroes(int[][] matrix) 
    {
    	if(matrix.length==0)
    		return;
    	LinkedList<Integer> list = new LinkedList<Integer>();
    	for(int i=0;i<matrix.length;i++)
    	{
    		setZeros(matrix,i,list);
    	}
		nullifyMatrix(matrix,list);
    }
    private void setZeros(int[][]matrix,int i,LinkedList<Integer>list)
    {
    	int row=-1;
    	for(int j = 0;j<matrix[i].length;j++)
		{
    		if(matrix[i][j]==0)
    			row = i;
    		if(list.isEmpty() && matrix[i][j]==0)
			{
				list.add(j);
			}
    		else if(!list.isEmpty() && !list.contains(j) && matrix[i][j]==0)
    		{
    			list.add(j);
    		}
		}
    	if(row!=-1)
    	{
	    	for(int j=0;j<matrix[row].length;j++)
	    	{
	    		matrix[row][j]=0;
	    	}
    	}

    }
    private void nullifyMatrix(int[][]matrix,LinkedList<Integer>list)
    {
    	for(int i=0;i<matrix.length;i++)
    	{
    		if(matrix[i][0]==0)
    			continue;
    		for(int column:list)    
	    	{
    			matrix[i][column]=0;	    	
	    	}
    	}
    	
    }
    public void setZerosBetterSolution(int[][]matrix)
    {
    	if(matrix.length==0)
    		return;
    	boolean firstRow = false;
    	boolean firstColumn = false;
    	//Since first row and first column is gonna be the marks for the rest matrix. 
    	//we need to whether they are originally supposed to be ZEROS
    	for(int i=0;i<matrix[0].length;i++)
    	{
    		if(matrix[0][i]==0)
    		{
    			firstRow = true;
    			break;
    		}
    		
    	}
    	for(int i=0;i<matrix.length;i++)
    	{
    		if(matrix[i][0]==0)
    		{
    			firstColumn = true;
    			break;
    		}
    	}
    	//Use first rown and column to be marker.
    	for(int i=1;i<matrix.length;i++)
    	{
    		for(int j=1;j<matrix[i].length;j++)
    		{
    			if(matrix[i][j]==0)
    			{
    				matrix[0][j]=0;
    				matrix[i][0]=0;
    			}
    		}
    	}
    	//Based on marker, nullify matrix.
    	for(int i=1;i<matrix[0].length;i++)
    	{
    		if(matrix[0][i]==0)
    		{
    			for(int j=1;j<matrix.length;j++)
    			{
    				matrix[j][i]=0;
    			}
    		}
    	}
    	for(int j=1;j<matrix.length;j++)
    	{
    		if(matrix[j][0]==0)
    		{
    			for(int i=1;i<matrix[j].length;i++)
    			{
    				matrix[j][i]=0;
    			}
    		}
    	}
    	//Then we can set the first row and column.
    	if(firstRow)
    	{
    		for(int i=0;i<matrix[0].length;i++)
    			matrix[0][i]=0;
    	}
    	if(firstColumn)
    	{
    		for(int i=0;i<matrix.length;i++)
    			matrix[i][0]=0;
    	}
    }
    public String multiply(String num1, String num2) 
    {
    	if(num1==null || num2==null)
    		return "";
    	if(num1.isEmpty()||num2.isEmpty())
    		return "";
    	num1 = new StringBuilder(num1).reverse().toString();
    	num2 = new StringBuilder(num2).reverse().toString();
    	int[]res = new int[num1.length()+num2.length()];
    	for(int i=0;i<num1.length();i++)
    	{		
    		int t1 = num1.charAt(i)-'0'; 	
    		for(int j=0;j<num2.length();j++)
    		{     		
        		int t2 = num2.charAt(j)-'0';
        		res[i+j] = res[i+j]+(t1*t2);
    		}
    	}
    	int carry=0;
    	StringBuilder sb = new StringBuilder();
    	for(int i=0;i<res.length;i++)
    	{
    		if(res[i]+carry>=10)
    		{
    			res[i] =res[i]+carry;
    			carry = res[i]/10;
    			res[i] = res[i]%10;
    		}
    		else 
    		{
    			res[i] = res[i]+carry;
    			carry=0;
    		}
    		sb.insert(0, res[i]);
    		
    	}
    	while(sb.length()>0&&sb.charAt(0)=='0')
    	{
    		sb.deleteCharAt(0);
    	}
    	if(sb.length()==0)
    		return sb.append(0).toString();
    	else
    		return sb.toString();
    
    }

        
    
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
    	ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
    	if(k==0||n<=0)
    		return results;
    	int i=1;
    	while(i<=n)
    	{
        	ArrayList<ArrayList<Integer>> tempResults = new ArrayList<ArrayList<Integer>>();
    		for(ArrayList<Integer> result:results)
    		{
    			ArrayList<Integer> tempCombo=new ArrayList<Integer>(result);
    			tempCombo.add(i);
    			if(tempCombo.size()<=k)
    				tempResults.add(tempCombo);
    		}
    		results.addAll(tempResults);
    		ArrayList<Integer> result = new ArrayList<Integer>();
    		result.add(i);
    		results.add(result);
    		i++;
    	}
    	Iterator<ArrayList<Integer>> iterator= results.iterator();
    	while(iterator.hasNext())
    	{
    		ArrayList<Integer> tempCombo = iterator.next();
    		if(tempCombo.size()<k)
    			iterator.remove();
    	}
    	return results;
    	
        	
    }
    public String reverseWords(String s) {
        if(s==null || s.isEmpty()||s.split(" ").length==0)
        {
       	 	return "";
        }
        String[]res = s.trim().split(" ");
        int i=0;
        s = "";
        while(i<res.length)
        {
        	if(res[i].isEmpty())
        	{
        		i++;
        		continue;
        	}
        	s = res[i]+" "+s;
       	 	i++;
        }
        return s.trim();
    }
    public boolean wordBreak1(String s, Set<String> dict) 
    {
    	if(s.isEmpty())
    		return false;    	
    	int size = s.length();
    	int i = size-1;
    	while(i>=0)
    	{
    		if(dict.contains(s.substring(i,size)))
    		{
    			if(i==0)
    				return true;
    			String subSentence = s.substring(0,i);
    			boolean result = wordBreak1(subSentence,dict);
    			if(result)
    				return true;
    		}
    		i--;
    	}
    	return false;
        
    }
    public ArrayList<String> wordBreak(String s, Set<String> dict) 
    {
    	ArrayList<String> results = new ArrayList<String>();
    	if(s.isEmpty())
    		return results;
    	int size = s.length();
    	int i = size-1;
    	StringBuilder sb = new StringBuilder();
    	while(i>=0)
    	{
    		if(dict.contains(s.substring(i,size)))
    		{
    			sb.append(s.substring(i,size));
    			if(i==0)
    			{
    				results.add(sb.toString());
    				return results;
    			}
    			String subSentence = s.substring(0,i);
    			ArrayList<String> tResults = wordBreak(subSentence,dict);
    			for(String temp : tResults)
    			{
        			StringBuilder tsb = new StringBuilder(sb);
    				tsb.insert(0, " ");
    				tsb.insert(0, temp);
    				results.add(tsb.toString());
    			}
				sb = new StringBuilder(); 
    			
    		}
    		i--;
    	}
    	return results;
        
    }

    public static void main(String[]args)
    {
    	LeetCodeSolutions4 solutions4 = new LeetCodeSolutions4();
    	ArrayList<String>  results=solutions4.letterCombinations("234");
    	for(String temp:results)
    	{
    		System.out.print(temp+" ");
    	}
    	String s1="aabaac";
    	String s2="aadaaeaaf";
    	String s3="aadaaeaabaafaac";
    	System.out.println(solutions4.isInterleave(s1, s2, s3));
    	
    	System.out.println(solutions4.isPalindrome("A man, a plan, a canal: Panama"));
    	System.out.println(solutions4.isPalindrome(".,"));
    	System.out.println(solutions4.isPalindromeBest(1001));
    	System.out.println(solutions4.isPalindrome(111));
    	solutions4.reverse(123);
    	String[]personal = new String[10];
    	String[]names=personal;
    	names[0] = "saeed";
    	personal[1]="chenyi";
    	System.out.print(personal[0]);
    	System.out.print(names[1]);
    	System.out.println();
    	Integer[]numbers=new Integer[10];
    	int[] num = {-6,-1,-1,9,-8,-6,-6,4,4,-3,-8,-1};
    	System.out.println(solutions4.longestConsecutive(num));
    	int[]digits = {9,9,9,9,9,9};
    	int[]newDigits = solutions4.plusOne(digits);
    	System.out.print(Arrays.toString(newDigits));
    	int[][]zeros={
    			{0,0,0,5},{4,3,1,4},{0,1,1,4},{1,2,1,3},{0,0,1,1}
    	};
    	solutions4.setZerosBetterSolution(zeros);
    	//solutions4.setZeroes(zeros);
    	for(int i=0;i<zeros.length;i++)
    	System.out.println(Arrays.toString(zeros[i]));
    	//Integer
    	System.out.print("multiplied string "+solutions4.multiply("123", "456"));
    	solutions4.combine(4,2);
    	solutions4.reverseWords("   a   b ");
      	Set<String> dictionary = new HashSet<String>();
      	dictionary.add("cat");
      	dictionary.add("cats");
    	dictionary.add("and");
    	dictionary.add("sand");
      	dictionary.add("dog");
      	System.out.println(solutions4.wordBreak("catsanddog", dictionary));

    }
}
