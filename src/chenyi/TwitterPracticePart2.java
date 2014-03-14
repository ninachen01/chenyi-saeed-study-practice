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
	
	//	2) In a 2D matrix of dimensions M*N, find number of "equilibrium" points.  A point (i, j) is said to be an "equilibrium" point 
	//only if all following conditions hold:
//	a) sum of rows 1...(i-1) =  sum of rows (i+1)...M
//	b) sum of columns 1...(j-1)  = sum of columns (j+1)...N
	//时间 O（mxn） 空间O（m+n）
	public static void main(String[]args)
	{
		TwitterPracticePart2 part = new TwitterPracticePart2();
		System.out.println(part.lookforMaxZeros(13));
	}
//	// Given a string, check if there exists some anagram of the string which is a palindrome.
//	Function Signature: bool anagramPalindrome(string word)
//	Sample Testcases:
//	a) anagramPalindrome("rotate") returns false, no anagram of "rotate" is a palindrome
//	b) anagramPalindrome("hanna") returns true, since using letters from "hanna", we can form the palindrome "nahan"
//
	public boolean anagramPalindrome(string word)
	{
		
	}

//	2) Given a permutation which contains numbers in the range [1, N], 
	//return the length of the largest cycle in the permutation. Function Signature: int longestCycle(vector<int> perm)
	public int longestCycle(vector<int> perm)
	{
		
	}
//	Sample Testcases:
//	a) longestCycle([2 3 1]) returns 3, since only cycle is (1 2 3) whose length is 3
//	b) longestCycle([5 4 3 2 1]) returns 2, since the permutation can be decomposed into (1 5), (2 4), (3)
//
//
//
//
//	1) Find the number of "visible" nodes in a binary tree. 
	//A node is a "visible" node if the path from root to that node does not encounter any node of value higher than that node.
//
////Problem 2:
//    A non-empty zero-indexed array A consisting of N integers is given.
//    A pair of integers (P, Q) is calledK-complementary in array A if 0 ≤ P, Q < N and A[P] + A[Q] = K.
//    
//    For example, consider array A such that:
//    
//      A[0] =  1  A[1] = 8  A[2]= -3
//      A[3] =  0  A[4] = 1  A[5]=  3
//      A[6] = -2  A[7] = 4  A[8]=  5
//      
//    The following pairs are 6-complementary in array A: (0,8), (1,6), (4,8), (5,5), (6,1), (8,0), (8,4). 
//    For instance, the pair (4,8) is 6-complementary because A[4] + A[8] = 1 + 5 = 6.
//    
//    Write a function:
//    
//            class Solution { public int solution(int K, int[] A); }
//            
//    that, given an integer K and a non-empty zero-indexed array A consisting of N integers, 
//    returns the number of K-complementary pairs in array A.
//    
//    For example, given K = 6 and array A such that:
//    
//      A[0] =  1  A[1] = 8  A[2]= -3
//      A[3] =  0  A[4] = 1  A[5]=  3
//      A[6] = -2  A[7] = 4  A[8]=  5
//      
//    the function should return 7, as explained above.
//    
//    Assume that:
//            N is an integer within the range [1..50,000];
//            K is an integer within the range [−2,147,483,648..2,147,483,647];
//            each element of array A is an integer within the range [−2,147,483,648..2,147,483,647].
//            
//    Complexity:
//            expected worst-case time complexity is O(N*log(N));
//            expected worst-case space complexity is O(N), beyond input storage (not counting the storage required for input arguments).
//            
//    Elements of input arrays can be modified.


}
