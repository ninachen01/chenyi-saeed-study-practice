package chenyi;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;



public class LeetCodeSolutionsPart2 {
	/**
	 * Definition for binary tree*/
	  public class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
	  
	  public ArrayList<TreeNode> generateTrees(int n) 
	  {
		  ArrayList<TreeNode> list = new ArrayList<TreeNode>();
		  if(n==0)
          {
            TreeNode node = null;
            list.add(node);
            return list;
          }
		  list = generateTrees(1,n);
	      return list;
		    
			  
	  } 
	  public void levelRead(TreeNode root)
		{
			Queue<TreeNode> queue = new LinkedList<TreeNode>();
			if(root == null)
				System.out.println("");
			else
			{
				queue.add(root);
				queue.add(new TreeNode(Integer.MAX_VALUE));
				while(root!=null)
				{
					if(root.val == Integer.MAX_VALUE)
					{
						TreeNode tempNode = new TreeNode(Integer.MAX_VALUE);
						queue.add(tempNode);
						queue.poll();
						root = queue.peek();
						if(root.val==Integer.MAX_VALUE)
							break;
						else
							System.out.println();
						continue;
					}
					
					if(root.left!=null)
						queue.add(root.left);
					if(root.right!=null)
						queue.add(root.right);
					System.out.print(root.val+" ");
					queue.poll();
					root = queue.peek();
				}
			}
			
		}
	  public ArrayList<TreeNode> generateTrees(int start,int end)
	  {
		  ArrayList<TreeNode> list = new ArrayList<TreeNode>();
		  if(start>end)
			  return list;
		  
		  for(int i=start;i<=end;i++)
		  {
			  if(i==3)
			  {
				  System.out.println("HEY");
				  }
			  ArrayList<TreeNode> left = new  ArrayList<TreeNode>();
			  ArrayList<TreeNode> right = new  ArrayList<TreeNode>();
			  left = generateTrees(start,i-1);
			  right = generateTrees(i+1,end);
			  combineLeftRight(list, i, left, right);
			  
		  }
		  return list;
	  }
	  public void combineLeftRight(ArrayList<TreeNode> list, int i, ArrayList<TreeNode> left, ArrayList<TreeNode> right )
	  {  
		  TreeNode root = new TreeNode(i);
		  if(left.size()==0 && right.size()==0)
			  list.add(root);
		  else if(left.size()>=right.size())
		  {			  
			  for(int j=0;j<left.size();j++)
			  {
				  TreeNode leftNode = left.get(j);		  
				  if(right.size()==0)
				  {  
					  TreeNode temp = new TreeNode(i);
					  temp.left = leftNode;	
					  list.add(temp);
					  continue;
				  }
				  
				  for(int k=0;k<right.size();k++)
				  {  
					  TreeNode temp2 = new TreeNode(i);
					  temp2.left = leftNode;
					  temp2.right = right.get(k);
					  list.add(temp2);				 

				  }
				  
			  }
		  }
		  else 
		  {
				  for(int j=0;j<right.size();j++)
				  { 
					  TreeNode rightNode = right.get(j);
					  if(left.size()==0)
					  {  
						  TreeNode temp = new TreeNode(i);
						  temp.right = rightNode;
						  list.add(temp);
						  continue;
					  }
					  for(int k=0;k<left.size();k++)
					  {
						  TreeNode temp2 = new TreeNode(i);
						  temp2.right = rightNode;
						  temp2.left = left.get(k);
						  list.add(temp2);
					  }				   
				  }
			  
		  }
	  }
	public class Solution {
	    public TreeNode buildTree(int[] preorder, int[] inorder) 
	    {
	    	if(preorder.length==0)
	    		return null;
	    	if(preorder.length==1)
	    		return new TreeNode(preorder[0]);
	    	List<Integer> preorderList = new ArrayList<Integer>();
	    	for(int i=0;i<preorder.length;i++)
	    		preorderList.add(preorder[i]);
	    	int root = preorderList.remove(0);
	    	TreeNode node = new TreeNode(root);
	    	for(int j=0;j<inorder.length;j++)
	    	{
	    		if(root == inorder[j])
	    		{	    		
	    			int end = inorder.length-1;
	    			int start = 0;
	    			TreeNode leftNode = constructTree(start, j-1, preorderList, inorder);
	    			TreeNode rightNode = constructTree(j+1, end, preorderList, inorder);
	    			node.left = leftNode;
	    			node.right = rightNode;	 
	    			break;
	    		}
	    	}
	    	return node;
	        
	    }
	    public TreeNode constructTree(int start, int end, List<Integer>preorderList,int[]inorder)
	    {
	    	if(start>end)
	    		return null;
	    	if(preorderList.isEmpty())
	    		return null;
	    	int root = preorderList.remove(0);
	    	TreeNode node = new TreeNode(root);
	    	for(int i = start;i<=end;i++)
	    	{
	    		if(root == inorder[i])
	    		{
	    			TreeNode leftNode = constructTree(start, i-1,preorderList,inorder);
	    			TreeNode rightNode = constructTree(i+1, end,preorderList,inorder);
	    			node.left = leftNode;
	    			node.right = rightNode;
	    			break;
	    		}
	    		
	    	}
	    	return node;
	    }
	    
	    
	}
	public static void main(String[]args)
	{
		LeetCodeSolutionsPart2 practice = new LeetCodeSolutionsPart2();
		ArrayList<TreeNode> list = practice.generateTrees(3);
		System.out.println("The list size is"+
				list.size());
		for(int i =0;i<list.size();i++)
		{
			practice.levelRead(list.get(i));
			System.out.println("//");
		}
	}
    public ArrayList<Integer> inorderTraversal(TreeNode root) 
    {
    	ArrayList<Integer> list = new ArrayList<Integer>();
    	if(root == null)
    		return list;
    	if(root.left==null && root.right==null)
    	{
    		int value = root.val;
    		list.add(value);
    		return list;
    	}
    	LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
    	TreeNode currentNode = root;
    	while(currentNode!=null || !stack.isEmpty())
    	{
	    	while(currentNode!=null)
	    	{	    	
	    		stack.addLast(currentNode);
	    		currentNode = currentNode.left;
	    	}
	    	while(!stack.isEmpty())
	    	{
	    		TreeNode node = stack.getLast();
	    		stack.removeLast();
	    		list.add(node.val);
	    		if(node.right!=null)
	    		{
	    			currentNode = node.right;
	    			break;
	    		}
	    		
	    	}
    	}
    	return list;
        
    }
    public ArrayList<Integer> preorderTraversal(TreeNode root) 
    {
    	ArrayList<Integer> list = new ArrayList<Integer>();
    	if(root==null)
    		return list;
    	if(root.left==null && root.right==null)
    	{
    		list.add(root.val);
    		return list;
    	}
    	LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
    	TreeNode currentNode = root;
    	while(currentNode!=null || !stack.isEmpty())
    	{
	    	while(currentNode!=null)
	    	{	    	
	    		list.add(currentNode.val);
	    		stack.addLast(currentNode);
	    		currentNode = currentNode.left;
	    	}
	    	while(!stack.isEmpty())
	    	{
	    		TreeNode node = stack.getLast();
	    		stack.removeLast();
	    		if(node.right!=null)
	    		{
	    			currentNode = node.right;
	    			break;
	    		}
	    		
	    	}
    	}
    	return list;
        
    }
}
