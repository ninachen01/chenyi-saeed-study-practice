package chenyi;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;




public class LeetCodeBST {
	 public class TreeLinkNode 
	 {
	      int val;
	      TreeLinkNode left, right, next;
	      TreeLinkNode(int x) { val = x; }
	}  
	 public class TreeNode 
	{
	     int val;
	     TreeNode left;
	     TreeNode right;
	     TreeNode(int x) { val = x; }
    }
    public boolean isSameTree(TreeNode p, TreeNode q) 
	{
    	if(p==null && q==null)
    		return true;
    	if(p==null || q ==null)
    		return false;
    	boolean isSame = false;
    	boolean left = false;	
    	boolean right = false;
    	if(p.val == q.val)
    	{
    		left = isSameTree(p.left,q.left);
    		if(!left)
    			return false;
    		right = isSameTree(p.right,q.right);
    		if(!right)
    			return false;
    	}
    	else
    		return false;
    	if(left && right)
    		isSame = true;
    	return isSame;
	        
	}	 
     public void connect(TreeLinkNode root) 
     {
    	 if(root == null)
    		 return;
    	 if(root.left==null && root.right == null)
    	 {
    		 root.next = null;
    		 return;
    	 }
    	 TreeLinkNode currentNode = root;
    	 TreeLinkNode mark = new TreeLinkNode(Integer.MAX_VALUE);
    	 Queue<TreeLinkNode> queue = new LinkedList<TreeLinkNode>();
    	 queue.add(currentNode);
    	 queue.add(mark);
    	 while(!queue.isEmpty())
    	 {
    		 currentNode = queue.poll();
    		 if(currentNode.val==Integer.MAX_VALUE)
    		 {    			
    			 if(queue.isEmpty())
    			 {
    				 break;
    			 }
    			 else
    				 queue.add(mark);
    		 }
    		 else
    		 {
    			 TreeLinkNode temp = queue.peek();
    			 if(temp.val==Integer.MAX_VALUE)
    				 currentNode.next = null;
    			 else
    				 currentNode.next = temp;
    		 }
    		 if(currentNode.left!=null)
    		 {
    			 queue.add(currentNode.left);
    		 }
    		 if(currentNode.right!=null)
    		 {
    			 queue.add(currentNode.right);
    		 }
    	 }
		        
	 }
		
	
	public int minDepth(TreeNode root) 
	{
		if(root == null)
			return 0;
		if(root.left == null && root.right == null)
			return 1;

		int left = Integer.MAX_VALUE;
		int right = Integer.MAX_VALUE;
		if(root.left!=null)
		{
			left = 1+minDepth(root.left);
		}
		if(root.right!=null)
		{
			right = 1+minDepth(root.right);
		}
		if(left<=right)
			return left;
		else
			return right;
        
    }
    public int maxDepth(TreeNode root) 
    {
    	if(root==null)
    		return 0;
    	if(root.left==null && root.right==null)
    		return 1;
    	int leftLength = 0;
    	int rightLength = 0;
        if(root.left!=null)
        {
        	leftLength = 1+maxDepth(root.left);
        }
        if(root.right!=null)
        {
        	rightLength = 1+maxDepth(root.right);
        }
        if(leftLength>=rightLength)
        	return leftLength;
        else
        	return rightLength;
    }
    /*Given n, how many structurally unique BST's (binary search trees) that store values 1...n?

For example,
Given n = 3, there are a total of 5 unique BST's.*/
   
    public int numTreesAnotherWay(int n) 
    {
        if(n==0)
    		return 1;
    	if(n==1)
    		return 1;
    	if(n==2)
    		return 2;
    	int number = 0;
    	HashMap<Integer,Integer> list = new HashMap<Integer,Integer>();
    	list.put(0, 1);
    	list.put(1, 1);
    	list.put(2, 2);
    	for(int i=1;i<=n;i++)
    	{
    		int left = 0;
    		if(list.get(i-1)!=null)
    			left = list.get(i-1);
    		else
    		{
    		    left = computeTrees(i-1,list);
    		}
    		int right = 0;
    		if(list.get(n-i)!=null)
    			right = list.get(n-i);
    		else
    		    {
    				right = computeTrees(n-i,list);
    		    }
    		number = number + left*right;
    	}
    	return number;
    	
        
    }
    public int numTrees(int n) 
    {
        if(n==0)
    		return 1;
    	if(n==1)
    		return 1;
    	if(n==2)
    		return 2;
    	int number = 0;
    	for(int i=1;i<=n;i++)
    	{
    		int left = numTrees(i-1);
    		
    		int right = numTrees(n-i);
    		number = number + left*right;
    	}
    	return number;
    	
        
    }
    public int computeTrees(int n, HashMap<Integer,Integer>list)
    {
    	int number = 0;
        if(n==0)
    		return 1;
    	if(n==1)
    		return 1;
    	if(n==2)
    		return 2;
    	for(int i=1;i<=n;i++)
    	{
    		int left = computeTrees(i-1,list);
    		int right = computeTrees(n-i,list);
    		number = number + left*right;
    	}
    	list.put(n, number);
    	return number;
    }
    public int firstMissingPositive(int[] A) 
    {
    	if(A.length==0)
    		return 1;
    	if(A.length==1)
    	{
    		if(A[0]<=0)
    			return 1;
    		else if(A[0]==1)
    			return 2;
    		else if(A[0]>1)
    			return 1;
    	}
	     for(int i=0;i<A.length;)
	     {
    		 int index = A[i];
	    	 if(A[i]==i || A[i]<0 || A[i]>=A.length||A[index] == index)
	    	 {
	    		 i++;
	    		 continue;
	    	 }
	    	 else if(A[index]!=index && A[i]!=i) 
	    	 {	    		 
    			 int temp = A[index];
        		 A[index] = A[i];
        		 A[i] = temp;        		 
	        	 
	    	 }
	     }
	     int i;
	     int candidate = Integer.MAX_VALUE;
	     for(i=0;i<A.length;i++)
	     {
	    	 if(A[i]>0 && i==0)
	    	 {
	    		candidate = A[i];
	    	 }
	    	 
	    	 else if(A[i]!=i && i>0)
	    	 {
	    		 return i;
	    	 }	    	 	    	 
	    	 
	     }
	     i--;
	     if(candidate==A[i]+1)
	    	 candidate++;
	     else
	    	 candidate = A[i]+1;
	     return candidate;
	     
     
    }
    
    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) 
    {
		ArrayList<ArrayList<Integer>> arrays  = new ArrayList<ArrayList<Integer>>();
		if(root == null)
			return arrays;
		TreeNode mark = new TreeNode(Integer.MIN_VALUE);
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		queue.add(mark);
		while(!queue.isEmpty())
		{
			TreeNode treeNode = queue.remove();
			if(treeNode.val == Integer.MIN_VALUE)
			{
				if(queue.isEmpty())
				{
	    			arrays.add(0,arrayList);
	    			break;
				}
				arrays.add(0,arrayList);
				queue.add(mark);
				arrayList = new ArrayList<Integer>();
				continue;
			}
			arrayList.add(treeNode.val);
			if(treeNode.left!=null)
			{
				queue.add(treeNode.left);
			}
			if(treeNode.right!=null)
			{
				queue.add(treeNode.right);
			}
		}
		return arrays;
}
    public boolean isSymmetric(TreeNode root) 
    {
    	boolean symmetric = false;  
    	if(root == null)
    		return true;
    	symmetric = isSymmetric(root.left,root.right);
    	return symmetric;
    }
    public boolean isSymmetric(TreeNode left, TreeNode right)
    {
    	boolean symmetricL = false;  
    	boolean symmetricR = false;
    	boolean symmetric = false;
    	if(left == null && right == null)
    		return true;
    	if(left==null||right==null)
    		return false;
    	if(left.val == right.val)
    	{
    		symmetricL = isSymmetric(left.left,right.right);    		
    		if(!symmetricL)
    			return false;
    		
    		symmetricR = isSymmetric(left.right,right.left);
    		if(!symmetricR)
    			return false;
    		
    		symmetric = true;
    	}
    	return symmetric;
    }

    /**
     * Definition for binary tree
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */

            public boolean isBalanced(TreeNode root) 
        {
        	if(root==null)
        		return true;
        	TreeNode left = root.left;
        	TreeNode right = root.right;
        	if(left == null && right == null)
        		return true;

        	int depth = findDepth(root);
    	    if(depth == -1)
    	    {
    	    	return false;
    	    }
        	else 
        	    return true;
            
        }
        private int findDepth(TreeNode root)
        {
        	if(root == null)
        		return 0;
        	int leftDepth = 1 + findDepth(root.left);
        	if(leftDepth==0)
        		return -1;

        	int rightDepth = 1 + findDepth(root.right);
        	if(rightDepth==0)
        		return -1;
        	
        	int depth = leftDepth;

        	if(leftDepth<rightDepth)
        		depth = rightDepth;
        	if(leftDepth == rightDepth || leftDepth-rightDepth==1 || rightDepth-leftDepth==1)
        		return depth;
        	else
        		return -1;
        }
        /**
         * Definition for binary tree
         * public class TreeNode {
         *     int val;
         *     TreeNode left;
         *     TreeNode right;
         *     TreeNode(int x) { val = x; }
         * }
         */
        public void flatten(TreeNode root) 
        {
        	if(root == null)
        		return ;
        	if(root.left == null && root.right==null)
        		return;
        	TreeNode currentNode  = root;
        	LinkedList<TreeNode> linkedList = new LinkedList<TreeNode>();
        	while(currentNode!=null)
        	{
        		while(currentNode!=null)
        		{   	

        			TreeNode tempNode = new TreeNode(currentNode.val);
        			tempNode.left = currentNode.left;
        			tempNode.right = currentNode.right;
        	      	linkedList.add(tempNode);
        	      	if(currentNode!=root)
        	      	{
	    				root.right = currentNode; 
	    				root.left = null;
	    				root = currentNode;
        	      	}
        			currentNode = currentNode.left;
        		}
        		while(!linkedList.isEmpty())
        		{
        			TreeNode node = linkedList.getLast();
        			linkedList.removeLast();
        			if(node.right!=null)
        			{
        				currentNode = node.right;
        				break;
        			}

        		}
        		
        	}        	
            
        }
            public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) 
            {
                ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
                if(root==null)
                    return list;

                if(root.left==null && root.right==null)
                {        
                    ArrayList<Integer> array = new  ArrayList<Integer> ();
                    array.add(root.val);
                    list.add(array);
                    return list;
                }
                TreeNode mark = new TreeNode(Integer.MAX_VALUE);
                Queue<TreeNode> queue = new LinkedList<TreeNode>();
                queue.add(root);
                queue.add(mark);
                ArrayList<Integer> array = new  ArrayList<Integer> ();
                while(!queue.isEmpty())
                {
                    TreeNode currentNode = queue.poll();
                    if(currentNode.val == Integer.MAX_VALUE)
                    {
                        list.add(array); 
                        if(queue.isEmpty())
                        {
                             break;   
                        }
                        else
                        {
                            array = new  ArrayList<Integer>();
                            queue.add(mark);
                            continue;
                        }
                    }
                    else
                    {
                        array.add(currentNode.val);
         
                        if(currentNode.left!=null)
                        {
                            queue.add(currentNode.left);
                        }
                        if(currentNode.right!=null)
                        {
                            queue.add(currentNode.right);
                        }
                    }
                    
                }
                return list;
                
                
            }
	public ArrayList<Integer> postorderTraversal(TreeNode root) 
	{
		ArrayList<Integer> result = new ArrayList<Integer> ();
		if(root==null)
			return result;
		if(root.left==null && root.right==null)
		{
			result.add(root.val);
			return result;
		}
		TreeNode currentNode = root;
		LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
		while(currentNode!=null)
		{
			while(currentNode!=null)
			{
				stack.addFirst(currentNode);
				currentNode = currentNode.left;
			}
			while(!stack.isEmpty())
			{
				TreeNode tempNode = stack.peek();
				if(tempNode.right!=null)
				{
					currentNode  = tempNode.right;
					tempNode.right = null;
					break;
				}
				else
				{
					result.add(tempNode.val);
					stack.poll();
				}

			}
		}
		return result;
	    
	}
	 public class ListNode 
	 {
		  int val;
	      ListNode next;
	      ListNode(int x) { val = x; next = null; }
	 }
    public TreeNode sortedListToBST(ListNode head) 
    {
        if(head==null)
        	return null;
        if(head.next==null)
        {
        	return new TreeNode(head.val);
        }
        TreeNode root = sortedListToBST(head,null);
        return root;
    }
    private TreeNode sortedListToBST(ListNode start,ListNode end) 
    {
        ListNode middleNode = findMiddle(start,end);
        TreeNode root = new TreeNode(middleNode.val);
        TreeNode left ;
        if(start == middleNode)
        	left = null;
        else
        	left = sortedListToBST(start,middleNode);
        TreeNode right;
        if(middleNode.next == end)
        	  right = null;
        else
        	  right = sortedListToBST(middleNode.next,end);
        root.left = left;
        root.right = right;
        return root;
    }
    public ListNode findMiddle(ListNode start,ListNode end)
    {
    	if(start == null)
    		return null;
    	if(start.next==end)
    		return start;
    	ListNode secondHead = start;
    	while(start!=null && start!=end && start.next!=end)
    	{
    		start = start.next.next;
    		secondHead = secondHead.next;
    	}
    	return secondHead;
    }
    public boolean isValidBST(TreeNode root) 
    {
    	boolean isValid = false;
    	if(root==null)
    		return true;
    	if(root.left==null && root.right==null)
    		return true;
    	
    	isValid = isValidBST(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
    	return isValid;
        
    }
    private boolean isValidBST(TreeNode root,int min, int max)
    {
    	boolean isValid;
    	if(root==null)
    		return true;
    	int tmin = min;
    	int tmax = max;
    	if(root.val<tmax && root.val>tmin)
    	{
    		if(root.left!=null)
	    	{
	    		tmax = root.val;
				isValid = isValidBST(root.left,min,tmax);
				if(!isValid)
					return false;
    		}
    		if(root.right!=null)
    		{
    			tmin = root.val;
				isValid = isValidBST(root.right,tmin,max);
				if(!isValid)
					return false;
    			
    		}
		}
    	else
    		return false;
    	
    	return true;
    	
    }
    public double pow(double x, int n) 
    {
    	if(x==0)
    		return 0;
    	if(n==1)
    		return x;
    	boolean inversion=false;
    	if(x<0)
    	{
    		inversion = true;
    		x = -x;
    	}
    	double result =1 ;
    	double temp = x;
    	while(n>0)
    	{
    		if(n%2==1)
    		{
    			result = result * temp;
    		}
    		temp = temp * temp;    		
    		n=n/2;    		
    	}
    	if(inversion)
    		result = 1/result;
    	return result;
    }
    public ArrayList<ArrayList<Integer>> zigzagLevelOrderBAD(TreeNode root) 
    {
    	ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>> ();
    	if(root==null)
    		return results;
    	Queue<TreeNode> queue = new LinkedList<TreeNode>();
    	queue.add(root);
    	TreeNode min = new TreeNode(Integer.MIN_VALUE);
    	TreeNode max = new TreeNode(Integer.MAX_VALUE);
    	ArrayList<Integer> list = new ArrayList<Integer>();
    	boolean mark = false;
    	queue.add(min);
    	while(!queue.isEmpty())
    	{
    		TreeNode currentNode = queue.remove();
    		if(currentNode.val == min.val)
    		{
    			results.add(list);
    			if(queue.isEmpty())
    				break;
    			queue.add(max);
    			mark = true;
    			list = new ArrayList<Integer>();
    			continue;
    		}
    		else if(currentNode.val == max.val)
    		{
    			results.add(list);
    			if(queue.isEmpty())
    			{
    				break;
    			}
    			queue.add(min);
    			mark = false;
    			list = new ArrayList<Integer>();
    			continue;
    		}
    		else
    		{
    			list.add(currentNode.val);
    		}
    		TreeNode left = currentNode.left;
    		TreeNode right = currentNode.right;
    		if(!mark)
    		{
    			if(right!=null)
    				queue.add(right);
    			if(left!=null)
    				queue.add(left);
    		}
    		else
    		{
    			if(left!=null)
    				queue.add(left);
    			if(right!=null)
    				queue.add(right);
    		}
    	}
    	return results;
        
    }
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) 
    {	
    	ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>> ();
    	ArrayList<Integer> list = new ArrayList<Integer>();
    	if(root==null)
    		return results;
    	LinkedList<TreeNode> currentStack = new LinkedList<TreeNode>();
    	LinkedList<TreeNode> nextLevelStack = new LinkedList<TreeNode>();
    	boolean leftToRight = true;
    	currentStack.push(root);
    	while(!currentStack.isEmpty())
    	{
    		TreeNode currentNode = currentStack.pop();
    		list.add(currentNode.val);
    		if(leftToRight)
    		{
    			if(currentNode.left!=null)
    				nextLevelStack.push(currentNode.left);
    			if(currentNode.right!=null)
    				nextLevelStack.push(currentNode.right);
    		}
    		else
    		{
    			if(currentNode.right!=null)
    				nextLevelStack.push(currentNode.right);
    			if(currentNode.left!=null)
    				nextLevelStack.push(currentNode.left);	
    		}
    		if(currentStack.isEmpty())
    		{
    			results.add(list);
    			list = new ArrayList<Integer>(); 
    			currentStack.addAll(nextLevelStack);
    			nextLevelStack.clear();
    			leftToRight = !(leftToRight);
    		}
    		
    	}
    	return results;
    }
    public static void main(String[]args)
    {
    	LeetCodeBST bst = new LeetCodeBST();
    	int number = bst.numTrees(3);
    	System.out.println(number);
    	int[]A ={1,1000};
    	 number = bst.firstMissingPositive(A);
    	 TreeNode node1 = bst.new TreeNode(2);
    	 TreeNode node2 = bst.new TreeNode(1);
    	 TreeNode node3 = bst.new TreeNode(3);
    	 node1.left = node2;
    	 node1.right = node3;
    	 bst.isValidBST(node1);
    	 TreeNode node4 = bst.new TreeNode(3);
    	 TreeNode node5 = bst.new TreeNode(3);
    	 node2.left = node4;
    	 node3.right = node5;
    	 TreeNode node6 = bst.new TreeNode(4);
    	 TreeNode node7 = bst.new TreeNode(4);
    	 node4.left  = node6;
    	 node5.right = node7;
    
    	 System.out.println(	 bst.isBalanced(node1));
    	 TreeNode root = bst.new TreeNode(1);
    	 root.right = bst.new TreeNode(2);
    	 bst.postorderTraversal(root);
    	 ListNode lNode = bst.new ListNode(1);
    	 ListNode lNode2= bst.new ListNode(2);
    	 ListNode lNode3= bst.new ListNode(3);
    	 lNode.next = lNode2;
    	 lNode2.next = lNode3;
    	 bst.sortedListToBST(lNode);
    	 bst.pow(34.00515,6);
    	 node1 = bst.new TreeNode(0);
    	 node2 = bst.new TreeNode(2);
    	 node3 = bst.new TreeNode(4);
    	 node1.left = node2;
    	 node1.right = node3;
    	 node4 = bst.new TreeNode(1);
    	 node5 = bst.new TreeNode(3);
    	 node6 = bst.new TreeNode(-1);
    	 node2.left = node4;
    	 node3.left = node5;
    	 node3.right = node6;
    	 node7 = bst.new TreeNode(5);
    	 TreeNode node8 = bst.new TreeNode(1);
    	 TreeNode node9 = bst.new TreeNode(6);
      	 TreeNode node10 = bst.new TreeNode(8);
    	 node4.left = node7;
    	 node4.right = node8;
    	 node5.right = node9;
      	 node6.right = node10;
    	 bst.zigzagLevelOrder(node1);
    	 
    }
}
