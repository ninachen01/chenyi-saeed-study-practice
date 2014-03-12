package chenyi;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;


/*Given two sorted integer arrays A and B, merge B into A as one sorted array.
Note:
You may assume that A has enough space to hold additional elements from B. The number of elements initialized in A and B are m and n respectively.*/
public class LeetCodeSolutionsPart3 
{
	public ArrayList<ArrayList<Integer>> generate(int numRows) 
	{
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>> ();
		if(numRows == 0)
            return list;
		ArrayList<Integer>array = new ArrayList<Integer>();
		array.add(1);
		list.add(array);
		if(numRows == 1)
		{
		
			return list;
		}
		ArrayList<Integer>array2 = new ArrayList<Integer>();
		array2.add(1);
		array2.add(1);
		list.add(array2);
		if(numRows ==2 )
		{
			return list;
		}
		else
		{
			for(int i = 3;i<=numRows;i++)
			{
				ArrayList<Integer> tempArray = new ArrayList<Integer>();
				ArrayList<Integer> pre = list.get(i-1-1);
				tempArray.add(1);
				for(int j = 1;j<pre.size();j++)
				{				
					int temp = pre.get(j)+pre.get(j-1);
					tempArray.add(temp);
					
				}
				tempArray.add(1);
				list.add(tempArray);
				
			}
		}
		return list;
			
    }
	public void merge(int A[], int m, int B[], int n) 
	{
		int C [] = new int[m];
        for(int i=0;i<m;i++)
        {
        	C[i] = A[i];
        }
        int index = 0;
        int i=0;
        int j= 0;
        while(index<m+n)
        {
        	if(i<m && j<n && C[i]<=B[j])
        	{
        		A[index] = C[i];
        		i++;
        	}
        	else if(i<m && j<n && B[j]<C[i])
        	{
        		A[index] = B[j];
        		j++;
        	}
        	else if(i==m)
        	{
        		A[index] = B[j];
        		j++;
        	}
        	else if(j==n)
        	{
        		A[index] = C[i];
        		i++;
        	}
    		index++;        	
        }
    }
	public int removeDuplicates(int[] A) 
	{
       Set<Integer> set = new TreeSet<Integer>();
       for(int i=0;i<A.length;i++)
       {
    	   set.add(A[i]);
       }
       int length = set.size();
       Iterator<Integer> iterator = set.iterator();
       int i = 0;
       while(iterator.hasNext())
       {
    	   A[i] = iterator.next();
    	   i++;
       }
       return length;
    }
	public int removeDuplicatesBetterSolution(int[] A) 
	{
		 if(A.length==0)
		        return 0;
	      int j = 0;
	      for(int i=1;i<A.length;i++)
	      {
	    	  if(A[i]!=A[j])
	    	  {
	    		  A[++j] = A[i];
	    	  }
	      }
	       return j+1;
    }
	/*Follow up for "Remove Duplicates":
		What if duplicates are allowed at most twice?

		For example,
		Given sorted array A = [1,1,1,2,2,3],

		Your function should return length = 5, and A is now [1,1,2,2,3].*/
    public int removeDuplicatesFollowUp(int[] A) 
    {
    	if(A.length ==0)
    		return 0;
    	int j = 0;
    	int count = 1;
    	for(int i=1;i<A.length;i++)
    	{
    		if(A[i]!=A[j] || count<2)
    		{
    			if(A[i]==A[j])
    			{
    				count++;
    			}
    			else
    			{
    				count = 1;
    			}
    			A[++j] = A[i];
    			
    		}
    		
    	}
    	return j+1;
        
    }
    public double powStackOverFlow(double x, int n) {
       if(x==0)
       {
    	   return 0;
       }
       if(n==0)
       {
    	   return 1;
       }
       if(n==1)
    	   return x;
       if(n>0)
       {
    	   double result = x*powStackOverFlow(x,n-1);
           return result;
       }
       else
       {
    	   n = -n;
    	   double result =1/(x*powStackOverFlow(x,n-1));
    	   return result;
       }
    }
    public double pow(double x, int n) {
        boolean positive = true;
        if(x==0)
        {
     	   return 0;
        }
        if(n==0)
        {
     	   return 1;
        }
        if(n==1)
     	   return x;
        if(n<0)
        {
        	n = -n;
        	positive = false;
        }
        if((n&1)==1)
        {
        	double result = x*pow(x,n-1);
        	if(!positive)
        	{
        		result = 1/result;
        	}
        	return result;
        }
        else
        {
        	double result = pow(x*x,n/2);
        	if(!positive)
        	{
        		result = 1/result;
        	}
        	return result;
        }
     }
    /*Given a string S, find the longest palindromic substring in S. 
     * You may assume that the maximum length of S is 1000, and there exists one unique longest palindromic substring.*/
    public String longestPalindrome(String s) {
    	int length = s.length();
    	if(length==0||length==1)
    		return s;
    	
    	String maxString=String.valueOf(s.charAt(0));
        for(int i=0;i<length;i++)
        {
        	String temp = expandAroundCenter(i,i,s);
        	if(maxString.length()<temp.length())
        	{
        		maxString = temp;        		
        	}
        }
        for(int i=0;i<length-1;i++)
        {
        	String temp = expandAroundCenter(i,i+1,s);
        	if(maxString.length()<temp.length())
        	{
        		maxString = temp;        		
        	}
        }
        return maxString;
    }
    public String expandAroundCenter(int l, int r, String s)
    {
    	int length = s.length();
    	while(l>=0 && r<=length-1 && s.charAt(l) == s.charAt(r))
    	{
    		l--;
    		r++;
    	}
    	return s.substring(++l,r);
    	
    }
    
    public int searchInsert(int[] A, int target) 
    {
    	int i = 0 ;
    	for(i= 0;i<A.length;i++)
    	{
    		if(A[i]==target)
    			return i;
    		if(A[i]>target)
    			return i;
    	}
    	
    		return i;
    	
    }
    public int singleNumber(int[] A) 
    {
    	int singleNumber = A[0];
    	for(int i=1;i<A.length;i++)
    	{
    		singleNumber = (singleNumber ^ A[i]);
    	}
    	return singleNumber;
        
    }
    public int singleNumber2(int[] A) 
    {
    	if(A.length == 0)
    		return Integer.MAX_VALUE;
    	
    	if(A.length == 1)
    		return A[0];
    	int result=0;

    	for(int i = 0;i<32;i++)
    	{
        	int temp = 0;
	    	for(int j = 0;j<A.length;j++)
	    	{
	    		int digit = (A[j]>>i)&1;/*clears other digits other than i*/
	    		temp = temp + digit ; 
	    	}
	    	temp = temp%3;
	    	int tempResult = temp << i;
	    	result = result + tempResult;
    	}
    	return result;
        
    }
    public double findMedianSortedArrays(int A[], int B[]) 
    {
    	double median;
    	if(A.length==0 && B.length==0)
    	{
    		return Integer.MIN_VALUE;
    	}
    	int totalSize = A.length+B.length;
    	PriorityQueue<Integer> queue1 = new PriorityQueue<Integer>(totalSize,new ReverseIntegerComparator());
    	
    	PriorityQueue<Integer> queue2 = new PriorityQueue<Integer>();
    	int i=0;int j=0;
    	while(i<A.length || j<B.length)
    	{
    		if(i<A.length  && j<B.length && A[i]<B[j])
    		{
    			queue2.add(A[i]);
    			i++;
    		}
    		else if(i<A.length  && j<B.length&& A[i]>B[j])
    		{
    			queue2.add(B[j]);
    			j++;
    		}
    		else if(i<A.length)
    		{
    			queue2.add(A[i]);
    			i++;
    		}
    		else if(j<B.length)
    		{
    			queue2.add(B[j]);
    			j++;
    		}
    		if(queue2.size()>queue1.size()+1)
    		{
    			int min = queue2.poll();
    			queue1.add(min);
    		}
    	}
    	
    	if(totalSize%2==0)
    	{
    		double number1 = queue1.peek();
    		double number2 = queue2.peek();
    		median = (number1+number2)/2;
    	}
    	else
    		median = queue2.peek();
    	
    	return median;
    	
        
    }

    private class ReverseIntegerComparator implements Comparator<Integer>
    {

		@Override
		public int compare(Integer arg0, Integer arg1) {
			// TODO Auto-generated method stub
			if(arg0>arg1)
				return -1;
			else if(arg0<arg1)
				return 1;
			return 0;
		}
    	
    }
    /*Given a string, find the length of the longest substring without repeating characters. 
     * For example, the longest substring without repeating letters for "abcabcbb" is "abc", 
     * which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.
     */
    public int lengthOfLongestSubstring(String s) 
    {
    	HashMap<String,Integer> hashmap = new HashMap<String,Integer>();
    	int start = 0 ;
    	int maxLength = 0;
    	int i = 0;
    	while(i<s.length())
    	{
    		char c = s.charAt(i);
    		String string = String.valueOf(c);
    		if(hashmap.get(string)!=null)
    		{   		
    			if(i-start>maxLength)
    			{
    				maxLength = i-start;    			
    			}
    			if(hashmap.get(string)+1>start)
    			{
        			start = hashmap.get(string)+1;	
    			}
    		}
			hashmap.put(string, i);
    		i++;    		
    	}
    	if(i-start>maxLength)
    	{
    		maxLength = i-start;
    	}
    	
    	return maxLength;
    }
    public int removeElement(int[] A, int elem) 
    {
    	if(A.length == 0)
    		return 0;
    	if(A.length == 1 && A[0]!=elem)
    		return 1;
    	if(A.length==1 && A[0] == elem)
    		return 0; 
    	int length = A.length;
    	int last = length-1;
    	for(int i=0;i<length;)
    	{
    		if(A[i]==elem)
    		{
    			length--;    	
    	    	A[i] = A[last];
    			last--;
    		}
    		else
    			i++;
    	}
    	return length;
    }
    public int climbStairs(int n) 
    {
    	if(n<=0)
    		return 0;
    	if(n==1)
    		return 1;
    	if(n==2)
    		return 2;
    	int[]stairs=new int[n+1];
    	stairs[0] = 0;
    	stairs[1] = 1;
    	stairs[2] = 2;
    	for(int i = 3;i<=n;i++)
    	{
    		stairs[i] = stairs[i-1]+stairs[i-2];
    	}
    	return stairs[n];
    	
    }
    public int maxSubArrayGood(int[]A)
    {
    	int max = Integer.MIN_VALUE;
    	int sum = 0;
    	for(int i=0;i<A.length;i++)
    	{
    		sum = A[i]+sum;
    		if(sum>max)
    			max = sum;
    		if(sum<0)
    			sum = 0;
    	}
    	return max;
    }
    public int maxSubArray(int[] A) {
        if(A.length==0)
        	return Integer.MIN_VALUE;
    	if(A.length==1)
        	return A[0];
    	int candidate = -1;
    	int max = Integer.MIN_VALUE;
    	int sum = Integer.MIN_VALUE;
    	
    	for(int i=0;i<A.length;i++)
    	{
    		if(i==0)
    		{
    			max = A[i];
    			sum = max;
    			if(A[i]>0)
    			{
    				candidate = i;
    			}
    		}
    		else if(A[i]<0)
    		{
    			sum = sum + A[i];
    			if(A[i]>max)
    			{
    				max = A[i];
    				sum = max;
    			}
    		}
    		
    		else if(A[i]>=0)
    		{
    			if(sum>0)
    			{
    				sum = sum + A[i];
    				if(sum>max)
    				{
    					max = sum;
    				}
    			}
    			else
    			{
    				sum = A[i];
    				candidate = i;
    				if(max<A[i])
    				{
    					max = A[i];
    				}
    				
    			}
    		}
    		
    	}
    	return max;
    }
    public void sortColors(int[] A) 
    {
    	if(A.length==0)
    		return;
        int[]bucket = new int[3];
        bucket[0] = 0;
        bucket[1] = 0;
        bucket[2] = 0;
        for(int color:A)
        {
        	bucket[color] ++;
        }
    	int k = 0;
        for(int i=0;i<bucket.length;i++)
        {
        	int count = bucket[i];
        	for(int j = 0;j<count;j++)
        	{
        		A[k] = i;
        		k++;
        	}
        }
    }
    public void sortColorsFollowUp(int[] A) 
    {
    	if(A.length==0)
    		return;
    	int start = 0;
    	int end = A.length-1;
    	for(int i = 0;i<=end;)
    	{
    		if(A[i]==0)
    		{
    			A[start++] = 0 ;
    			i++;
    		}
    		else if(A[i]==2)
    		{
    			A[i] = A[end];
    			A[end--] = 2;
    			continue;
    		}
    		else 
    		{
    			i++;
    		}

    	}
    	for(int i = start;i<=end;i++)
    	{
    		A[i] = 1;
    	}
    }
    
    public ArrayList<ArrayList<Integer>> subsets(int[] S) 
    {
    	ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
    	if(S.length==0)
    		return results;
    	Arrays.sort(S);
    	for(int i=0;i<S.length;i++)
    	{
    		ArrayList<ArrayList<Integer>> temp = new ArrayList<ArrayList<Integer>>();
    		for(ArrayList<Integer> array:results)
    		{
    			temp.add(new ArrayList<Integer>(array));
    		}
    		for(ArrayList<Integer> array:temp)
    		{
    			array.add(S[i]);
    		}
    		ArrayList<Integer> single = new ArrayList<Integer>();
    		single.add(S[i]);
    		temp.add(single);
    		results.addAll(temp);
    	}
    	ArrayList<Integer> emptyArray= new 	ArrayList<Integer>();
    	results.add(emptyArray);
    	return results;
    		
    }
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) 
    {
    	ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
    	if(num.length==0)
    		return results;
    	Arrays.sort(num);
    	for(int i=0;i<num.length;i++)
    	{
    		ArrayList<ArrayList<Integer>> temp = new ArrayList<ArrayList<Integer>>();
    		for(ArrayList<Integer> array:results)
    		{
    			temp.add(new ArrayList<Integer>(array));
    		}
    		for(ArrayList<Integer> array:temp)
    		{
    			array.add(num[i]);
    			if(!results.contains(array))
    			{
    				results.add(array);
    			}
    		}
    		ArrayList<Integer> single = new ArrayList<Integer>();
    		single.add(num[i]);
    		if(!results.contains(single))
    			results.add(single);
    	}
    	ArrayList<Integer> emptyArray= new 	ArrayList<Integer>();
    	results.add(emptyArray);
    	return results;
    	
    }
    /*My Submissions
Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

*/
    public int search(int[] A, int target) 
    {
    	if(A.length==0)
    		return Integer.MAX_VALUE;
    	if(A.length==1)
    	{
    		if(A[0]==target)
    			return 0;
    		else
    			return -1;
    	}
    	int size = A.length;
    	int position = searchRotated(A,0,size-1);
    	if(position==-1)
    	{
    		return binarySearch(A,target,0,size-1);
    	}
    	int result1 = binarySearch(A,target,0,position-1);
    	int result2 = binarySearch(A,target,position,size-1);
    	if(result1!=-1)
    		return result1;
    	if(result2!=-1)
    		return result2;
    	return -1;
        
    }
    public int binarySearch(int[]A,int target,int start,int end)
    {
    	int position1=-1;
    	int position2=-1;
    	if(start<=end)
    	{
	    	int middle = (start+end)/2;
	    	if(A[middle] == target)
	    		return middle;
	    	else if(A[middle]<target)
	    	{
	    		position1 = binarySearch (A,target,middle+1,end);
	    	}
	    	else if(A[middle]>target)
	    	{
	    		position2 = binarySearch (A,target,start,middle-1);
	    	}
	    	if(position1!=-1)
	    		return position1;
	    	if(position2!=-1)
	    		return position2;
    	}
    		
    	return -1;
    	
    }
    public int searchRotated(int[]A,int start,int end)
    {
    	int mid = (start+end)/2;
    	if(mid-1>=start && A[mid-1]>A[mid])
    		return mid;
    	else if(mid+1<=end && A[mid+1]<A[mid])
    		return mid+1;
    	else
    	{
    		int p1 = searchRotated(A,start,mid-1);
    		int p2 = searchRotated(A,mid+1,end);

        	if(p1!=-1)
        		return p1;
        	if(p2!=-1)
        		return p2;
    	}
    	return -1;
    		
    }
    /* 1 2 2 1   
     * 1 2 1 1
     * 1 1 2 1
     * 
     * 1 0 2
     * 1 1 2
     * 1 1 1*/
    public int candy(int[] ratings) 
    {        
    	int total = 0;
    	if(ratings.length==0)
    		return 0;
    	if(ratings.length==1)
    		return 1;
    	int []candies = new int[ratings.length];
    	for(int i=0;i<candies.length;i++)
    		candies[i]=1;
    	
    	int preRating = ratings[0];
       	for(int i=1;i<ratings.length;i++)
    	{
    		if(ratings[i]>preRating)
    		{
    			candies[i] = candies[i-1]+1;
    		}
    		else 
    		{
    			candies[i] = 1;
    		}
    		preRating = ratings[i];
    	}
       	
       	int last = ratings.length-1;
       	int postRating = ratings[last];
    	int []candies2 = new int[ratings.length];
    	for(int i=0;i<candies2.length;i++)
    		candies2[i]=1;
       	for(int i=last-1;i>=0;i--)
       	{
       		if(ratings[i]>postRating)
       		{
       			candies2[i] = candies2[i+1]+1; 
       		}
       		else
       		{
       			candies2[i] = 1;
       		}
       		postRating = ratings[i];
       	}
       	int i = 0;
       	while(i<candies.length )
       	{
       		if(candies2[i]>candies[i])
       			total = total+candies2[i];
       		else
       			total = total+candies[i];
       		i++;
       	}
    	return total;
    	
        
    }
    public static void main(String[]args)
    {
    	LeetCodeSolutionsPart3 solutions3 = new LeetCodeSolutionsPart3();
    	double result = solutions3.pow(1.00001, 123456);
    	System.out.println(result);
    	int length = solutions3.lengthOfLongestSubstring("qopubjguxhxdipfzwswybgfylqvjzhar");
    	System.out.println(length);

    	int A[]={1,2};
    	int max = solutions3.maxSubArray(A);
    	System.out.println("MAX" + max);
    	int[]num = {2,2,3,2};
    	int number = solutions3.singleNumber2(num);
    	System.out.print("single number is "+number);
    	int[] numbers = {4, 5, 4,4};
    	 number = solutions3.singleNumber2(numbers);
    	System.out.println("single number is "+number);
    	int A1[]={};
    	int B[]= {2,3};
    	double median = solutions3.findMedianSortedArrays(A1, B);
    	System.out.print(median);
    	int[] colors={2,0,2};
    	solutions3.sortColorsFollowUp(colors);
    	int[] sets={1,2,3,4,5,6,7,8,10,0};
    	solutions3.subsets(sets);
    	int[] ratings = {2,2};
    	solutions3.candy(ratings);
    	int[] rotated = { 1, 3};
    	solutions3.searchRotated(rotated, 0, 6);
    	 result = solutions3.search(rotated, 1);
    	System.out.println("rotated: "+result);
    }
}
