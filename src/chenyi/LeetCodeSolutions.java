package chenyi;
import java.util.ArrayList;
import java.util.List;



public class LeetCodeSolutions {
	/**
	 * Definition for singly-linked list.*/
	  public class ListNode 
	  {
	      int val;
	      ListNode next;
	      ListNode(int x) {
	      val = x;
	      next = null;
	  }
	  }
	  public class Circle
	    {
	    	int x; 
	    	int y;
	    	public Circle(int x, int y)
	    	{
	    		this.x = x;
	    		this.y = y;
	    	}
			public int getX() {
				return x;
			}
			public void setX(int x) {
				this.x = x;
			}
			public int getY() {
				return y;
			}
			public void setY(int y) {
				this.y = y;
			}
	    }
	  public void moveCircle(Circle circle, int deltaX, int deltaY) {
	        // code to move origin of circle to x+deltaX, y+deltaY
	        circle.setX(circle.getX() + deltaX);
	        circle.setY(circle.getY() + deltaY);
	            
	        // code to assign a new reference to circle
	        circle = new Circle(0, 0);
	    }
	  public ListNode sortList(ListNode head) 
	  {		  
		  if(head==null || head.next==null)
			  return head;
		  ListNode currentNode = head;
		  while(currentNode.next!=null)
		  {
			  currentNode = currentNode.next;
		  }
		  ListNode end = currentNode;
		  ListNode newHead = sortList(head, end);
		  return newHead;
			  
	  }
	  public ListNode lookForMiddle(ListNode head,ListNode end)
	  {
		  if(head == null|| head.next == null)
			  return head;
		  ListNode secondHead = head;
		  while(secondHead!=end && secondHead.next!=end)
		  {
			  secondHead = secondHead.next.next;
			  head = head.next;
		  }
		  return head;
	  }
	  public ListNode sortList(ListNode head, ListNode end)
	  {
		  if(head==null||head == end)
		  {
			  head.next = null;
			  return head;
		  }
		  if(head.next==end)
		  {
			  if(head.val>end.val)
			  {
				 int value = head.val;
				 head.next = end;
				 head.val = end.val;
				 end.val = value;				 
			  }

			  end.next = null;
			  return head;
		  }
		  else
		  {
			  ListNode middleNode = lookForMiddle(head,end);	
			  ListNode rightStart = middleNode.next;
			  ListNode left = sortList(head, middleNode);
			  ListNode right = sortList(rightStart,end);
			  ListNode newHead = mergeSortList(left, right, end);
			  return newHead;
		  }
		  
	  }
	  public ListNode mergeTwoLists(ListNode l1, ListNode l2) 
	  {
		  if(l1==null)
			  return l2;
		  else if (l2==null)
			  return l1;
		  ListNode originHead = null;
		  ListNode head = null;
		  while(l1!=null||l2!=null)
		  {
			  if(l1!=null && l2!=null && l1.val<=l2.val)
			  {
				  if(head == null)
				  {
					  head = l1;
					  originHead = head;
				  }
				  else
				  {
					  head.next = l1;
					  head = head.next;
				  }
				  l1 = l1.next;
			  }
			  else if(l1!=null && l2!=null && l2.val<l1.val)
			  {
				  if(head == null)
				  {
					  head = l2;
					  originHead = head;
				  }
				  else
				  {
					  head.next = l2;
					  head = head.next;
				  }
				  l2 = l2.next;
			  }
			  else if(l1==null)
			  {
				  while(l2!=null)
				  {
					  head.next = l2;
					  head = head.next;
					  l2 = l2.next;
				  }
				  
			  }
			  else if(l2==null)
			  {
				  while(l1!=null)
				  {
					  head.next = l1;
					  head = head.next;
					  l1 = l1.next;
				  }
			  }
		  }
		  return originHead;
	        
	  }
	  public ListNode mergeSortList(ListNode left, ListNode right, ListNode end)
	  {
		  ListNode newHead = null;
		  ListNode currentNode = null;
		  while(left!=null && right!=null)
		  {
			  ListNode currentLeft = left.next;
			  ListNode currentRight = right.next;
			  if(left.val<right.val)
			  {
				  if(currentNode == null)
				  {
					  currentNode = left; 
					  newHead = left;
				  }
				  else
				  {
					  currentNode.next = left;
					  currentNode = left;
				  }
				  left = currentLeft;
			  }
			  else
			  {
				  if(currentNode == null)
				  {
					  currentNode = right;
					  newHead = right;
				  }
				  else
				  {
					  currentNode.next = right;
					  currentNode = right;
				  }
				  right = currentRight;
			  }
		  }
		  if(left == null)
		  {
			  while(right!=null)
			  {
				  currentNode.next = right;
				  currentNode = right;
				  right = right.next;
			  }
			  currentNode.next = null;
		  }
		  else if(right==null)
		  {
			  while(left!=null)
			  {
				  currentNode.next = left;
				  currentNode = left;
				  left = left.next;
			  } 
			  currentNode.next = null;
		  }
		  
		  return newHead;
	  }
	/*  public ListNode insertionSortList(ListNode head) 
	    {
	   	
	        
	    }*/
	  public ListNode detectCycle(ListNode head) 
	  {
		 ListNode originalHead = head;
	     ListNode secondHead = head;
	     while(secondHead!=null && secondHead.next!=null)
	     {
	    	 secondHead = secondHead.next.next;
	    	 head = head.next;
	    	 if(secondHead == head)
	    	 {
	    		 ListNode thirdHead = originalHead;
	    		 while(thirdHead!=secondHead)
	    		 {
	    			 secondHead = secondHead.next;
	    			 while(secondHead!=head && thirdHead!=secondHead)
	    			 {
	    				 secondHead = secondHead.next;
	    			 }
	    			 if(thirdHead == secondHead)
	    				 return thirdHead;
	    			 thirdHead = thirdHead.next;
	    		 }
	    		 return thirdHead;
	    	 }
	     }
	     return null;
	   }
    public boolean hasCycle(ListNode head) 
    {
    	ListNode secondHead = head;
    	while(secondHead!=null && secondHead.next!=null)
    	{
    		secondHead = secondHead.next.next;
    		head = head.next;
    		if(secondHead == head)
    			return true;
    	
    	}
    	return false;
        
    }
		
	public class Solution2 {
	    public ListNode reverseBetween(ListNode head, int m, int n) 
	    {
	    	ListNode node = head;
	    	ListNode firstNode = head;
	    	ListNode lastNode = head;
	    	ListNode prevNode = null;
	    	int i = 1;	    	
	    	while(i<=n)
	    	{
	    		if(i==m-1)
	    		{
	    			prevNode = node;
	    		}
	    		if(i<=m)
	    		{
	    			firstNode = node;
	    		}
	    		
	    		if(i<=n)
	    		{
	    			lastNode = node;
	    			
	    		}
	    		node = node.next;
	    		i++;
	    	}
	    	
	    	i = m;
	    	ListNode pre = lastNode.next;
	    	ListNode currentNode = firstNode;
	    	while(i<=n)
		    {
	    		ListNode temp = currentNode.next;
	    		currentNode.next = pre;
		    	pre = currentNode;
		    	currentNode = temp;
		    	i++;
	    	}
	    	if(prevNode!=null)
	    		prevNode.next = pre;
	    	else
	    		return pre;
	    	return head;
	    }
	    public void printListNode(ListNode node)
	    {
	    	while(node!=null)
	    	{
	    		System.out.print(node.val+" ");
	    		node = node.next;
	    	}
	    	System.out.println();
	    }
	}

	/**
	  Definition for binary tree**/
	  public class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
	
	public class Solution 
	{
		
		public TreeNode buildTree(int[] inorder, int[] postorder) 
	    {
	        if(postorder.length==0)
	            return null;
	        if(postorder.length==1)
	    		return new TreeNode(postorder[0]);
	    	List<Integer> postorderArray = new ArrayList<Integer>();
	    	for(int i=0;i<postorder.length;i++)
	    		postorderArray.add(postorder[i]);
	    	int lastIndex = postorderArray.size()-1;
	    	
	    	int root = postorderArray.remove(lastIndex);
	    	TreeNode node = new TreeNode(root);
    		for(int j=0;j<inorder.length;j++)
    		{
        			if(inorder[j] == root)
        			{
        				int index = j;
        				TreeNode rightNode = buildTreeRecursive(index+1, inorder.length-1, postorderArray , inorder,postorder);
        				TreeNode leftNode = buildTreeRecursive(0, index-1, postorderArray, inorder, postorder);
        				node.left = leftNode;
        				node.right = rightNode;
        				break;
        			}
        	}
            		
	    	return node;	
	    }
	        
	    
	    public TreeNode buildTreeRecursive(int start, int end, List<Integer> postorderList, int[] inorder, int[] postorder)
	    {
	    	if(start > end)
	    		return null;
	    	int last = postorderList.size();
	    	int root = postorderList.remove(last-1);
	    	TreeNode node = new TreeNode(root);
	    	for(int i=start;i<=end;i++)
	    	{
	    		if(root == inorder[i])
	    		{
	    			int foundRoot = i;
    				TreeNode rightNode = buildTreeRecursive(foundRoot+1, end, postorderList, inorder,postorder);
	    			TreeNode leftNode = buildTreeRecursive(start, foundRoot-1, postorderList, inorder, postorder);
    				node.left = leftNode;
    				node.right = rightNode;
    				break;
	    		}
	    	}
	    	return node;
	    }
	    public ListNode deleteDuplicates(ListNode head) 
	    {

	    	if(head==null)
	    		return null;
	    	if(head.next==null)
	    		return head;
	    	ListNode currentNode = head;
	    	
	    	while(currentNode!=null && currentNode.next!=null)
	    	{
	    		ListNode secondNode = currentNode.next;
	    		if(currentNode.val==secondNode.val)
	    		{
	    			currentNode.next = secondNode.next;
	    			
	    		}
	    		else
	    		{
	    			currentNode = currentNode.next;
	    		}
	    	}
	    	return head;  
	        
	    }
	    /*My Submissions
Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.*/
	    public ListNode deleteDuplicates2(ListNode head) 
	    {

	    	if(head==null)
	    		return null;
	    	if(head.next==null)
	    		return head;
	    	ListNode currentNode = head;
	    	ListNode pre = null;
	    	while(currentNode!=null && currentNode.next!=null)
	    	{
	    		if(currentNode.val!=currentNode.next.val)
	    		{
	    			pre=currentNode;
	    			
	    			currentNode = currentNode.next;
	    			
	    		}
	    		while(currentNode!= null && currentNode.next!=null && currentNode.val==currentNode.next.val)
	    		{	    			
	    			currentNode = currentNode.next;
	    			
	    		}
	    		if(pre==null)
	    		{
	    			pre = currentNode;
	    		}
	    		if(pre!=null)
	    		{
	    			pre.next = currentNode;
	    		}
	    		
	    	}
	    	return head;  
	        
	    }
	    public void levelPrintBST(TreeNode node)
	    {
	    	TreeNode currentNode = node;
	    	List<TreeNode> arrayList = new ArrayList<TreeNode>();
	    	TreeNode mark = new TreeNode(Integer.MIN_VALUE);
    		arrayList.add(currentNode);
    		arrayList.add(mark);
	    	while(!arrayList.isEmpty())
	    	{
	    		currentNode = arrayList.remove(0);
	    		if(currentNode.val==Integer.MIN_VALUE)
	    		{
	    			System.out.println();
	    			if(arrayList.isEmpty())
	    			{
	    				break;
	    			}
	    			else
	    			{
	    			
	    				arrayList.add(mark);
	    				continue;
	    			}
	    		}
	    		System.out.print(currentNode.val+" ");
	    		if(currentNode.left!=null)
	    			arrayList.add(currentNode.left);
	    		if(currentNode.right!=null)
	    			arrayList.add(currentNode.right);
	    		
	    	}
	    	
	    }
	    
	    

	}
	    public static void main(String[]args)
	    {
	    	LeetCodeSolutions solutions = new LeetCodeSolutions();
	    	LeetCodeSolutions.Solution solution = solutions.new Solution();
	    	int[]inorder = {10,11, 12, 13, 17, 21, 29,35, 37};
	    	int[]postorder={10, 12, 13, 11, 21, 37, 35, 29, 17};
	    	TreeNode node =solution.buildTree(inorder,postorder);
	    	solution.levelPrintBST(node);
	    	ListNode listNode = solutions.new ListNode(10);
	    	ListNode listNode2 = solutions.new  ListNode(12);
	    	listNode.next = listNode2;
	    	ListNode listNode3 = solutions.new  ListNode(13);
	    	listNode2.next = listNode3;

	    	ListNode listNode4 = solutions.new  ListNode(14);
	    	listNode3.next = listNode4;
	    	ListNode listNode5 = solutions.new  ListNode(15);
	    	listNode4.next = listNode5;
	    	
	    	LeetCodeSolutions.Solution2 solution2 = solutions.new Solution2();
	    	solution2.printListNode(listNode);
	    	ListNode newlistNode = solution2.reverseBetween(listNode, 1, 5);
	    	solution2.printListNode(newlistNode);
	    	

	    	ListNode listNode6 = solutions.new  ListNode(3);
	    	ListNode listNode7= solutions.new  ListNode(5);
	    	listNode6.next = listNode7;
	    	solution2.printListNode(listNode6);
	    	
	    	solution2.printListNode(solution2.reverseBetween(listNode6, 1, 2));
	    	
	    	
	    	ListNode testNode1 = solutions.new ListNode(3);
	    	ListNode testNode2 = solutions.new ListNode(4);
	    	ListNode testNode3 = solutions.new ListNode(1);
	    	ListNode testNode4 = solutions.new ListNode(2);
	    	ListNode testNode5 = solutions.new ListNode(0);
	    	ListNode testNode6 = solutions.new ListNode(10);
	    	ListNode testNode7 = solutions.new ListNode(17);
	    	testNode1.next = testNode2;
	    	testNode2.next = testNode3;
	    	testNode3.next = testNode4;
	    	testNode4.next = testNode5;
	    	testNode5.next = testNode6;
	    	testNode6.next = testNode7;
	    	ListNode newHead = solutions.sortList(testNode1);
	    	while(newHead!=null)
	    	{
	    		System.out.print(newHead.val+" ");
	    		newHead = newHead.next;
	    	}
	    	Circle cirlce = solutions.new Circle(1,0);
	    	solutions.moveCircle(cirlce, 5, 6);

	    	ListNode node1 = solutions.new ListNode(2);
	    	ListNode node2 = solutions.new ListNode(1);
	    	solutions.mergeTwoLists(node1, node2);
	    }

	
}
