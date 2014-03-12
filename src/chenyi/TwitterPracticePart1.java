package chenyi;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.regex.Pattern;


public class TwitterPracticePart1 {
	//Find Missing Number
	public int findMissingNumber(int[]array)
	{
		if(array.length==0)
			throw new IllegalArgumentException("Array is Empty");
		int result=array[0];
		for(int i=1;i<array.length;i++)
		{
			result = array[i] ^ result;
		}
		for(int i=1;i<=array.length+1;i++)
		{
			result = result ^ i;
		}
		return result;
		
	}
	//Given an array with numbers, your task is to find 4 numbers that will satisfy this equation: 
	//A + B + C = D
	//A+B=D-C;
	public int[] findNumbersForEquation(int[]array)
	{
		int[]results = new int[4];
		if(array.length==0)
			return results;

		HashMap<Integer,NumberPair> sumMap= new HashMap<Integer,NumberPair>();
		for(int i=0;i<array.length;i++)
		{
			int A = array[i];
			for(int j=i+1;j<array.length;j++)
			{
				int B = array[j];
				NumberPair pair = new NumberPair(A,B);
				sumMap.put(A+B,pair);
			}
		}
		Set<Integer> sums = sumMap.keySet();
		for(int i=0;i<array.length;i++)
		{
			int A = array[i];
			for(int j=i+1;j<array.length;j++)
			{
				int B = array[j];
				NumberPair pair = null;
				if(sums.contains(A-B))
				{
					 pair = sumMap.get(A-B);
	
				}
				else if(sums.contains(B-A))
				{
					pair = sumMap.get(B-A);
				}
				if(pair != null && pair.x!=A && pair.y!=A)
				{
					results[0] = pair.x;
					results[1] = pair.y;
					if(pair.x+pair.y+A==B)
					{
						results[2] = A;
						results[3] = B;
					}
					else
					{
						results[2] = B;
						results[3] = A;
					}
					
					return results;
				}
			}
		}
		return results;

	}
	private class NumberPair
	{
		int x;
		int y;
		public NumberPair(int x, int y)
		{
			this.x = x;
			this.y = y;
		}
	}
	public class TreeNode 
	{
	     int val;
	     TreeNode left;
	     TreeNode right;
	     TreeNode(int x) { val = x; }
	 }
	//given two nodes of a binary tree, find number of nodes on the path between the two nodes.
	public ArrayList<TreeNode> findNodesOnPath(TreeNode node1, TreeNode node2, TreeNode root)
	{
		ArrayList<TreeNode> result= new ArrayList<TreeNode>();
		if(root==null)
			return result;
		if(node1==null||node2==null)
			return result;
		ArrayList<TreeNode> leftResults = findNodePath(node1,root);
		ArrayList<TreeNode> rightResults= findNodePath(node2,root);
		TreeNode common = null;
		for(TreeNode node: leftResults)
		{
			result.add(node);
			if(rightResults.contains(node))
			{
				common = node;
				break;
			}			
		}
		if(common!=null)
		{
			for(TreeNode node:rightResults)
			{	
				if(node==common)
				{
					break;
				}
				else
					result.add(node);
				
			}
		}
		
		return result; 
		
	}
	private ArrayList<TreeNode>  findNodePath(TreeNode node, TreeNode root)
	{
		ArrayList<TreeNode> results = new ArrayList<TreeNode>();
		if(root==null)
			return results;
		if(root.val == node.val)
		{
			results.add(node);
		}
		else 
		{
			results = findNodePath(node,root.left);
			if(results.contains(node))
			{
				results.add(root);
			}
			else
			{
				results = findNodePath(node,root.right);
				if(results.contains(node))
				{
					results.add(root);
				}
					
			}

		}
		return results;
				
			
	}
	//Given a list of names. Find whether a particular name occurs inside a given tweet or not. 
	//If found return true otherwise false Time complexity should be less than O(n). 

	//Ex: "Katy Perry","Ronan Keating" given as a list of string. 


	public boolean findName(String tweet,List<String> names) 
	{ 
		for(String name:names)
		{
			Pattern pattern = Pattern.compile(".*"+name+".*");
			return pattern.matcher(tweet).find();
		}
		return false;
		
	}
	//  LRU Cache
	//	Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and set.
	//	get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
	//	set(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, 
	//  it should invalidate the least recently used item before inserting a new item.
	public class LRUCache {
		int capacity;
		LinkedHashMap<Integer,Integer> map =  new LinkedHashMap<Integer,Integer>();
	   
		public LRUCache(int capacity) {
	    	this.capacity = capacity;	        
	    }
	    
	    public int get(int key) {
	      if( map.get(key) ==null)
	    	  return -1;
	      else
	      {
	    	  int value = map.get(key);
	    	  map.remove(key);
	    	  map.put(key, value);
	    	  return value;
	      }
	    }
	    
	    public void set(int key, int value) 
	    {
	    	if(map.entrySet().size()==capacity)
	    	{	    		
	    		Iterator<Integer> iterator = map.keySet().iterator();
	    		Integer leastKey = null;
	    		if(iterator.hasNext())
	    		{
	    			leastKey = iterator.next();
	    		}
    			if(map.get(key)!=null && leastKey!=null && leastKey != key)
    			{
    				map.remove(key);
    			}
    			else 
	    		{
	    			map.remove(leastKey);
	    		}	    		
	    	}
	    	else if(map.get(key)!=null)
	    	{
	    		map.remove(key);
	    	}
			map.put(key, value);
    		
	    }
	}
//	Given a preorder sequence from a Binary Tree, 
	//how many unique trees can be created from this? (They want a recurrence relation and start with the easy cases): 
//	
//Given a string "aaabbcccc", write a program to find the character with the second highest frequency.
	public char getSecondHighFrequency(String s)
	{
		if(s.isEmpty())
			throw new IllegalArgumentException("String is Empty"); 
		if(s.length()==1)
			return s.charAt(0);
		int[]letters = new int[26];
		s=s.toLowerCase();
		for(int i=0;i<s.length();i++)
		{
			int index= s.charAt(i)-'a';
			letters[index]++;
		}
		PriorityQueue<LetterCount> queue = new 	PriorityQueue<LetterCount>();
		for(int i=0;i<26;i++)
		{
			if(letters[i]!=0)
			{
				char c = (char)('a'+i);
				LetterCount lc = new LetterCount(c,letters[i]);
				queue.add(lc);
			}
		}
		char firstHigh =  queue.remove().letter;
		if(queue.isEmpty())
			return firstHigh;
		char secondHigh = queue.remove().letter;
		return secondHigh;
	}
	public char getSecondHighFrequencySolution2(String s)
	{
		if(s.isEmpty())
			throw new IllegalArgumentException("String is Empty"); 
		if(s.length()==1)
			return s.charAt(0);
		HashMap<String, Integer> hashmap = new 	HashMap<String, Integer> ();
		for(int i=0;i<s.length();i++)
		{
			String key= String.valueOf(s.charAt(i));
			if(hashmap.get(key)==null)
			{
				hashmap.put(String.valueOf(s.charAt(i)), 1);
			}
			else
			{
				int value = hashmap.get(key);
				hashmap.put(String.valueOf(s.charAt(i)), ++value);
			}
		}
		Integer max=null;
		String maxC=null;
		Integer secondMax=null;
		String secondMaxC=null;
		Iterator<Entry<String,Integer>> iterator = hashmap.entrySet().iterator();
		while(iterator.hasNext())
		{
			Entry<String, Integer> entry =iterator.next();
			if(max == null)
			{
				max = entry.getValue();
				maxC = entry.getKey();
			}
			else if(entry.getValue()>max)
			{
				secondMax = max;
				secondMaxC = maxC;
				max = entry.getValue();
				maxC = entry.getKey();
			}
			else if(secondMax==null || entry.getValue()>secondMax)
			{
				secondMax = entry.getValue();
				secondMaxC = entry.getKey();
			}
		}
		if(secondMax==null)
			return maxC.charAt(0); 
		return secondMaxC.charAt(0);
	}
	public class LetterCount implements Comparable<LetterCount>
	{
		char letter;
		int count;
		public  LetterCount(char letter, int count)
		{
			this.letter = letter;
			this.count = count;
		}


		@Override
		public int compareTo(LetterCount o) {
			// TODO Auto-generated method stub
			if(this.count<o.count)
				return 1;
			else if(this.count>o.count)
				return -1;
			return 0;
		}
	
	}
	
	//whether a BST is valid
	public boolean isValid(TreeNode root)
	{
		if(root==null)
			return true;
		if(root.left==null && root.right==null)
			return true;
		int min = Integer.MIN_VALUE;
		int max = Integer.MAX_VALUE;
		return isValid(root, min ,max);
		
	}
	private boolean isValid(TreeNode root, int min, int max)
	{
		if(root==null)
			return true;
		if(root.val>min && root.val<max)
		{
			if(root.left!=null)
			{
				boolean result = isValid(root.left,min, root.val);
				if(!result)
					return false;
			}
			if(root.right!=null)
			{
				boolean result = isValid(root.right,root.val,max);
				if(!result)
					return false;
			}
			return true;
		}
		else
			return false;
	}
	//String getSentence(String text, Set<String> dictionary); 

	// text is a string without spaces, you need to insert spaces into text, so each word seperated by the space in the resulting string exists in the dictionary, 
	//return the resulting string 

	// running time has to be at least as good as O(n) 

	// getSentence("iamastudentfromwaterloo", {"from, "waterloo", "hi", "am", "yes", "i", "a", "student"}) -> "i am a student from waterloo"
	public String getSentence(String text, Set<String> dictionary)
	{
		if(text.isEmpty())
			return "";
		HashMap<String, LinkedList<String>> map = new HashMap<String, LinkedList<String>>();
		Iterator<String> iterator = dictionary.iterator();
		while(iterator.hasNext())
		{
			String word = iterator.next();
			String key = String.valueOf(word.charAt(0));
			LinkedList<String> value = map.get(key);
			if(value==null)
			{
				LinkedList<String> words = new LinkedList<String> ();
				words.add(word);
				map.put(key, words);
			}
			else
			{
				value.add(word);
			}			
		}
		int i=0;
		int length = text.length();
		ArrayList<String> results = new ArrayList<String>();
		String result="";
		String key=String.valueOf(text.charAt(i));
		while(i<length)
		{
			if( map.get(key)!=null)
			{				
				LinkedList<String> temp = map.get(key);
				String value = temp.getFirst();
				result = value;
				results.add(result);
				result="";
				int increment = value.length();
				temp.removeFirst();
				temp.addLast(value);
				i = i+increment;
				if(i<length)
					key = String.valueOf(text.charAt(i)); 
				else
					break;
				/*int j=i;
				while(!dictionary.contains(key))
				{
					key=key+text.charAt(++j);
				}
				result = key;
				results.add(result);
				result="";
				int increment = key.length();
				i = i+increment;
				if(i<length)
					key = String.valueOf(text.charAt(i)); 
				else
					break;*/
			}
			else 
			{
				int lastIndex = results.size();
				String lastKey = results.remove(lastIndex-1);
				key = String.valueOf(lastKey.charAt(0));
			}
			
			
		}
		StringBuilder sb = new StringBuilder();
		for(String s:results)
			sb.append(s+" ");
		return sb.toString();
	}
	//given 4 points, whose x and y coordinates are both integers. they are all different. write a function to check if they form a square. 
	//i forgot to point out that the points can be given in any order
	

	public static void main(String[]args)
	{
		TwitterPracticePart1 part1 = new TwitterPracticePart1();
		//Learn How to use Arrays.sort();
    	char[] chars ={'A','a','b','d','B','4'};
    	Arrays.sort(chars);
    	System.out.println(Arrays.toString(chars));
    	//Tests for findMissingNumber
    	int[]array1 = {2, 4, 5, 1, 8, 7,6};
    	System.out.println("Missing Number is " + part1.findMissingNumber(array1));
    	//Tests for A+B+C=D
    	int[]array = {1,2,0,5,-7,-11,-3,-6};
    	System.out.print("A+B+C=D is found: ");
    	System.out.println( Arrays.toString(part1.findNumbersForEquation(array)) );
    	List<String> names = new ArrayList<String>();
    	names.add("katty perry");
    	System.out.println(part1.findName("ababab katty perry",names ));
    	//Test for Path
    	TreeNode node1 = part1.new TreeNode(1);
    	TreeNode node2 = part1.new TreeNode(2);
    	TreeNode node3 = part1.new TreeNode(3);
    	TreeNode node4 = part1.new TreeNode(4);
    	TreeNode node5 = part1.new TreeNode(5);
      	TreeNode node6 = part1.new TreeNode(6);
    	node1.left = node2;
    	node1.right = node3;
    	node2.left = node4;
    	node2.right = node5;
    	node4.left = node6;
    	ArrayList<TreeNode> results = part1.findNodesOnPath(node5, node3, node1);
		System.out.print("I found the path ");
    	part1.printTreeNode(results);
		System.out.print("I found the path ");
    	results = part1.findNodesOnPath(node6, node5, node1);
    	part1.printTreeNode(results);
		System.out.print("I found the path ");
       	results = part1.findNodesOnPath(node4, node5, node1);
    	part1.printTreeNode(results);
		System.out.print("I found the path ");
       	results = part1.findNodesOnPath(node6, node4, node1);
    	part1.printTreeNode(results);
    	TwitterPracticePart1.LRUCache lru = part1.new LRUCache(2);    	
    	lru.set(2, 1);
    	lru.set(1, 1);
    	lru.set(2, 3); 
    	lru.set(4, 1); 
      	System.out.println(lru.get(1));
      	System.out.println(lru.get(2));
      	//Second Highest Letter
      	String test1 = "bbaaacceedddfffffccccc";
      	System.out.println("secondHigh letter " + part1.getSecondHighFrequency(test1));
      	System.out.println("secondHigh letter " + part1.getSecondHighFrequencySolution2(test1));
      	String test2="aa";
      	System.out.println("secondHigh letter " + part1.getSecondHighFrequency(test2));
      	System.out.println("secondHigh letter " + part1.getSecondHighFrequencySolution2(test2));
       	String test3="aab";
      	System.out.println("secondHigh letter " + part1.getSecondHighFrequency(test3));
      	System.out.println("secondHigh letter " + part1.getSecondHighFrequencySolution2(test3));
       	String test4="a";
      	System.out.println("secondHigh letter " + part1.getSecondHighFrequency(test4));
      	System.out.println("secondHigh letter " + part1.getSecondHighFrequencySolution2(test4));
      	Set<String> dictionary = new HashSet<String>();
      	dictionary.add("from");
      	dictionary.add("waterloo");
      	dictionary.add("hi");

      	dictionary.add("yes");
      	dictionary.add("i");
      	dictionary.add("a");
      	dictionary.add("am");
      	dictionary.add("student");
      	System.out.print(part1.getSentence("iamastudentfromwaterloo", dictionary));
      	

    	
	}
	private void printTreeNode(ArrayList<TreeNode> results)
	{
		for(TreeNode node:results)
		{
			System.out.print(node.val+" ");
		}
		System.out.println();
	}

}

