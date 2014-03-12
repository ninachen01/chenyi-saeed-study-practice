package chenyi;
import java.util.LinkedList;


public class LinkedListPractice {
	
	public void reverseLinkedList(LinkedList linkedList)
	{
		printoutLinkedList(linkedList);
		int i=0;
		while(i<linkedList.size()&&linkedList.getLast()!=null)
		{
			linkedList.add(i, linkedList.getLast());
			linkedList.removeLast();
			i++;
		}
		printoutLinkedList(linkedList);
		
	}
	
	public void reverseLinkedListRecursion(LinkedList linkedList,int i)
	{
		if(i==linkedList.size())
			return;
		linkedList.add(i, linkedList.getLast());
		linkedList.removeLast();
		i++;
		reverseLinkedListRecursion(linkedList,i);
		
	}
	public void printoutLinkedList(LinkedList linkedList)
	{
		for(int i=0;i<linkedList.size();i++)
			System.out.print(linkedList.get(i)+" ");
		System.out.println();
	}
	public class SelfImplementLinkedList
	{
		Node head;
		public SelfImplementLinkedList (Node node)
		{
			this.head = node;
		}
		public Node reverseLinkedList(Node current)
		{
			if(head == null)
				return null;
			if(head.getNext() == null)
			{
				return head;
			}
			Node currentNode = head;
			Node pre = null;
			while(currentNode!=null)
			{
				Node temp  = currentNode.next;
				currentNode.next = pre;
				pre = currentNode;
				currentNode = temp;
			}
			head = pre;
			return head;
		}
		public void reverseLinkedListBestSolution()
		{
			if(head == null||head.getNext()==null)
				return;
			Node current = head;
			Node prev = null;
			while(current!=null)
			{
				Node nextNode = current.getNext();
				current.setNext(prev);
				prev = current;
				current = nextNode;
			}
			head = prev;
		}
		public void reverseLinkedListWithRecursion(Node current, Node prev)
		{
			if(current==null)
			{
				head = prev;
				return;
			}
			Node nextNode = current.getNext();
			current.setNext(prev);
			prev = current;
			current = nextNode;
			reverseLinkedListWithRecursion(current,prev);
		}
		public void printLinkedList()
		{
			Node node = head;
			while(node!=null)
			{
				System.out.print(node.value+" ");
				node = node.getNext();
			}
			System.out.println();
		}
	}
	public class Node
	{
		Node next;
		Object value;
		public Node(Object value)
		{
			this.value = value;
			next = null;
		}
		public void setNext(Node next)
		{
			this.next = next;
		}
		public Node getNext()
		{
			return this.next;
		}
	}
	public class ListNode 
	{
	      int val;
	      ListNode next;
	      ListNode(int x) { val = x; next = null; }
    }
	public class TreeNode 
	{
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
    }
	/*public TreeNode sortedListToBST(ListNode head) 
	{
		
        
    }*/
	public TreeNode sortedArrayToBST(int[] num) 
	{
		int size = num.length;
		if(size==0)
			return null;
		if(size==1)
		{
			TreeNode node = new TreeNode(num[0]);
			return node;
		}
		int midPos = size/2;
		TreeNode root = new TreeNode(num[midPos]);
		TreeNode left = sortedArrayToBST(0, midPos-1,num);
		TreeNode right = sortedArrayToBST(midPos+1, size-1,num);
		root.left = left;
		root.right = right;
		return root;
        
    }
	private TreeNode sortedArrayToBST(int start, int end, int[]num)
	{	
		if(start>end)
			return null;
		int midPos = (start+end)/2;
		TreeNode root = new TreeNode(num[midPos]);
		if(start == end)
			return root;
		TreeNode left = sortedArrayToBST(start, midPos-1,num);
		TreeNode right = sortedArrayToBST(midPos+1, end,num);
		root.left = left;
		root.right = right;
		return root;		
	}
    public ListNode swapPairs(ListNode head) 
    {
    	if(head == null)
    		return null;
    	if(head.next == null)
    		return head;
    	ListNode currentNode = head;
    	head = currentNode.next;
    	ListNode pre = null;
    	while(currentNode!=null && currentNode.next!=null)
    	{
    	
    		ListNode temp = currentNode.next.next;
    		ListNode nextNode = currentNode.next;
    		if(pre!=null)
    			pre.next = nextNode;
    		currentNode.next = temp;
    		nextNode.next = currentNode;
    		pre = currentNode;
    		currentNode = temp;
    		
    		
    	}
    	return head;
        
    }
    //Please be aware of what Rotate means.
   public ListNode rotateRight(ListNode head, int n) 
   {
	  if(head==null)
		  return head;
	  if(n==0)
		  return head;
	  if(head.next==null)
		  return head;	  
	  int size = 1;
	  ListNode lastNode = head;
	  while(lastNode.next!=null)
	  {
		  lastNode = lastNode.next;
		  size++;
	  }
	  if(n%size==0)
		  return head;
	  ListNode currentNode = head;
	  int i=0;
	  int step = size - n%size;
	  while(i<step)
	  {
		  lastNode.next = currentNode;
		  i++;
		  lastNode = lastNode.next;
		  currentNode = currentNode.next;
	  }
	  lastNode.next = null;
	  return currentNode;
	
	  
   }
   public ListNode insertionSortList(ListNode head) 
   {
       if(head==null)
    	   return null;
       if(head.next==null)
    	   return head;
       ListNode node = head.next;
       ListNode currentNode = head;
       ListNode pre = null;
       while(node!=null)
       {
           ListNode endNode = node.next;
    	   while(currentNode!=node)
    	   {
	    	   if(currentNode.val>node.val)
	    	   {
	    		   if(pre == null)
	    		   {
	    			   head = node;
	    		   }
	    		   else
	    			   pre.next = node;
	    		   node.next = currentNode;
	    		   while(currentNode.next!=node)
	    		   {
	    			   currentNode = currentNode.next;
	    		   }
	    		   currentNode.next = endNode;
	    		   break;
	    		   
	    	   }
	    	   else
	    	   {
	    		   pre = currentNode;
	    		   currentNode = currentNode.next;
	    	   }
    	   }
    	   currentNode = head;
    	   pre = null;
    	   node = endNode;
       }
       return head;
      }
   public ListNode partition(ListNode head, int x) 
   {
	   if(head==null)
		   return null;
	   if(head.next==null)
		   return head;
	   ListNode currentNode = head;
	   ListNode lastNode = head;
	   ListNode rightNode = null;
	   ListNode pre = null;
	   int size=0;
	   while(lastNode.next!=null)
	   {
		   lastNode = lastNode.next;
		   size++;
	   }
	   while(size>=0)
	   {
		   if(currentNode.val>=x)
		   {
			   lastNode.next = currentNode;
			   lastNode = currentNode;
			   if(rightNode == null)
				   rightNode = lastNode;
			   ListNode temp = currentNode.next;
			   if(currentNode == head)
				   head = temp;
			   if(pre!=null)
				   pre.next = temp;
			   currentNode.next = null;
			   currentNode = temp;
		   }
		   else
		   {
			   if(currentNode == rightNode)
				   break;
			   pre = currentNode;
			   currentNode = currentNode.next;
			   
		   }
		   size--;
	   }
	   return head;
       
   }
	public static void main(String[]args)
	{
		LinkedListPractice linkedlistPractice = new LinkedListPractice();
		LinkedList<Integer> linkedList = new LinkedList<Integer>();
		linkedList.add(4);
		linkedList.add(8);
		linkedList.add(10);
		linkedList.add(13);
		linkedList.add(14);
		linkedList.add(19);
		linkedList.add(23);
		linkedlistPractice.reverseLinkedList(linkedList);
		linkedlistPractice.reverseLinkedListRecursion(linkedList,0);
		linkedlistPractice.printoutLinkedList(linkedList);
		LinkedList<String> linkedListString = new LinkedList<String>();
		linkedListString.add("a");
		linkedListString.add("b");
		linkedListString.add("c");
		linkedListString.add("d");
		linkedListString.add("e");
		linkedListString.add("f");
		linkedlistPractice.reverseLinkedList(linkedListString);
		linkedlistPractice.reverseLinkedListRecursion(linkedListString,0);
		linkedlistPractice.printoutLinkedList(linkedListString);
		
		LinkedListPractice.Node node = linkedlistPractice.new Node(5);
		LinkedListPractice.SelfImplementLinkedList chenyiLinkedList= linkedlistPractice.new SelfImplementLinkedList(node);
		
		LinkedListPractice.Node node2 = linkedlistPractice.new Node(7);
		node.setNext(node2);
		LinkedListPractice.Node node3 = linkedlistPractice.new Node(15);
		node2.setNext(node3);
		LinkedListPractice.Node node4 = linkedlistPractice.new Node(18);
		node3.setNext(node4);
		System.out.println("ATTENTION");
		chenyiLinkedList.printLinkedList();
		chenyiLinkedList.reverseLinkedList(chenyiLinkedList.head);

		chenyiLinkedList.printLinkedList();

		System.out.println("ATTENTION ENDS");
		chenyiLinkedList.reverseLinkedListBestSolution();
		chenyiLinkedList.printLinkedList();

		chenyiLinkedList.reverseLinkedListWithRecursion(chenyiLinkedList.head,null);
		chenyiLinkedList.printLinkedList();
		
		LinkedListPractice.Node node5 = linkedlistPractice.new Node(18);
		LinkedListPractice.SelfImplementLinkedList chenyiLinkedList2= linkedlistPractice.new SelfImplementLinkedList(node5);
		chenyiLinkedList2.printLinkedList();
	//	chenyiLinkedList2.reverseLinkedList(null,chenyiLinkedList2.head);
		chenyiLinkedList2.printLinkedList();
		
		int[] nums={1, 2, 3, 4, 5, 6};
		TreeNode treeNode = linkedlistPractice.sortedArrayToBST(nums);
		System.out.println(treeNode.val);
		ListNode node1 = linkedlistPractice.new ListNode(4);
		ListNode lNode2 = linkedlistPractice.new ListNode(19);
		ListNode lNode3 = linkedlistPractice.new ListNode(14);
		ListNode lNode4 = linkedlistPractice.new ListNode(5);
		ListNode lNode5 = linkedlistPractice.new ListNode(-3);
		node1.next = lNode2;
		lNode2.next = lNode3;
		lNode3.next  = lNode4;
		lNode4.next = lNode5;
		ListNode head = linkedlistPractice.insertionSortList(node1);
		linkedlistPractice.printLinkedList(head);
		node1 = linkedlistPractice.new ListNode(2);
		lNode2 = linkedlistPractice.new ListNode(1);
		node1.next = lNode2;
		linkedlistPractice.partition(node1, 0);
		
	}
	public void printLinkedList(ListNode head)
	{
		while(head!=null)
		{
			System.out.print(head.val+" ");
			head = head.next;
		}
	}

	

}
