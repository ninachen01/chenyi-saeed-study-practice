package chenyi;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Queue;


public class BinarySearchTree {
	Node root ;
	public Node createTree(int number)
	{
		root = new Node (null,number,null);
		return root;
	}
	public Node Node(int number)
	{
		Node node = new Node(null,number, null);
		return node;
	}
	public Node insertToTree(int number,Node root)
	{
		if(root==null)
		{
			root = new Node(null,number,null);
		}
		else if (root.getNumber()<number)
		{
			Node rightNode = insertToTree(number,root.getRight());
			root.setRight(rightNode);
		}
		else if(root.getNumber()>number)
		{
			Node leftNode = insertToTree(number,root.getLeft());
			root.setLeft(leftNode);
		}
		return root;
	}
	public void inOrderReadNotRecursive(Node root)
	{
		Deque<Node> stack = new ArrayDeque<Node>();
		if(root==null)
		{
			System.out.println("");
		}
		else
		{
			Node currentNode = root;
			while(currentNode!=null||!stack.isEmpty())
			{
				while(currentNode!=null)
				{
					stack.push(currentNode);
					currentNode = currentNode.getLeft();
				}
				if(!stack.isEmpty())
				{
					currentNode = stack.pop();
					System.out.print(currentNode.getNumber()+" ");				
					currentNode = currentNode.getRight();
				}
			}
		}
	}
	public void inOrderRead(Node root)
	{
		if(root == null)
		{
			System.out.print("");
		}
		else
		{
			inOrderRead(root.getLeft());
			System.out.print(root.getNumber()+" ");
			inOrderRead(root.getRight());
		}
	}
	
	public void preOrderRead(Node root)
	{
		if(root == null)
		{
			System.out.print("");
		}
		else
		{
			System.out.print(root.getNumber()+" ");
			preOrderRead(root.getLeft());
			preOrderRead(root.getRight());
		}		
	}
	public void postOrderRead(Node root)
	{
		if(root == null)
		{
			System.out.print("");
		}
		else
		{
			postOrderRead(root.getLeft());
			postOrderRead(root.getRight());
			System.out.print(root.getNumber()+" ");
		}
	}
	public void levelRead(Node root)
	{
		Queue<Node> queue = new LinkedList<Node>();
		if(root == null)
			System.out.println("");
		else
		{
			queue.add(root);
			queue.add(new Node(null,Integer.MAX_VALUE,null));
			while(root!=null)
			{
				if(root.getNumber() == Integer.MAX_VALUE)
				{
					Node tempNode = new Node(null,Integer.MAX_VALUE,null);
					queue.add(tempNode);
					queue.poll();
					root = queue.peek();
					if(root.getNumber()==Integer.MAX_VALUE)
						break;
					else
						System.out.println();
					continue;
				}
				
				if(root.getLeft()!=null)
					queue.add(root.getLeft());
				if(root.getRight()!=null)
					queue.add(root.getRight());
				System.out.print(root.getNumber()+" ");
				queue.poll();
				root = queue.peek();
			}
		}
		
	}
	public void levelRead2(Node root)
	{
		if(root==null)
			System.out.print("");
		else
		{
			Queue<Node> queue = new LinkedList<Node>();
			queue.add(root);
			queue.add(new Node(null,Integer.MAX_VALUE,null));
			while(!queue.isEmpty())
			{
				Node currentNode = queue.poll();
				if(currentNode.getNumber()==Integer.MAX_VALUE && !queue.isEmpty())
				{
					queue.add(new Node(null,Integer.MAX_VALUE,null));
					System.out.print("\n");
					continue;
				}
				else if(queue.isEmpty())
					break;
				else
					System.out.print(currentNode.getNumber()+" ");
				if(currentNode.getLeft()!=null)
				{
					queue.add(currentNode.getLeft());
				}
				if(currentNode.getRight()!=null)
				{
					queue.add(currentNode.getRight());
				}
			}
		}
	}
	public boolean findNode(int number,Node root)
	{
		boolean found = true;
		if(root!=null)
		{
			if(root.getNumber()==number)
				found = true;
			else
			{
				if(root.getNumber()<number)
				{
					found = findNode(number, root.getRight());
				}
				else if(root.getNumber()>number)
				{
					found = findNode(number,root.getLeft());
				}
				
			}
		}
		else
			found = false;
		return found;
		
	}
	public Node removeNode(int number, Node root)
	{
		if(findNode(number,root))
		{
			if(root.getNumber()==number)
			{
				Node node = combine(root.getLeft(),root.getRight());
				return node;
			}
			else if(root.getNumber()<number)
			{
				Node node = removeNode(number,root.getRight());
				Node newNode = new Node(root.getLeft(),root.getNumber(),node);
				return newNode;
			}
			else
			{
				Node node = removeNode(number,root.getLeft());
				Node newNode = new Node(node,root.getNumber(),root.getRight());
				return newNode;
			}
			
			
		}
		else
			return root;
		
	}
	public Node findMax(Node node)
	{
		if(node!=null)
		{
			while(node.getRight()!=null)
			{
				node = node.getRight();
			}
			return node;
		}
		else
			return null;
	}
	public Node removeMax(Node node)
	{
		if(node == null)
			return null;
		else if(node.getRight()==null)
		{
			return null;
		}
		else
		{
			return new Node(node.getLeft(),node.getNumber(), removeMax(node.getRight()));
		}
		
	}
	private Node combine(Node left, Node right)
	{
		 
		if(left == null && right == null)
			return null;
		else if(left!=null)
		{
			Node rightMost = findMax(left);
			Node newLeft = removeMax(left);
			Node root = new Node(newLeft, rightMost.getNumber(),right);
			return root;
			
		}
		else
		{
			return right;
		}
			
		
	}
	public int getSuccessor(int n, Node node, int sucessor)
	{
		//Todo
		return n;
	}
	public Node reconstructBSTBasedOnPreOrderInOrder(int[]inOrder, int[]preOrder)
	{
		ArrayList<Integer>arrayList = new ArrayList();
		for(int i =0 ;i<preOrder.length;i++)
			arrayList.add(preOrder[i]);
		Hashtable<Integer,Integer> hashTable = new Hashtable();
		for(int  i=0;i<inOrder.length;i++)
		{
			hashTable.put(inOrder[i], i);
		}
		Node node =reconstructTree(arrayList, 0, 7, preOrder, hashTable);
		return node;
			
	}
	public Node reconstructTree(ArrayList<Integer> preOrderArray, int start, int end, int[]preOrder, Hashtable<Integer,Integer> hashTable)
	{
		if(start == end)
		{
			Node node =new Node(null,preOrderArray.get(0),null);
			preOrderArray.remove(0);
			return node;
		}
		if(start>end)
			return null;
		if(preOrderArray.isEmpty())
			return null;
		int number = preOrderArray.get(0);
		Node node =new Node(null,number,null);	
		int index = hashTable.get(number);
		preOrderArray.remove(0);
		Node leftNode = reconstructTree(preOrderArray, start, index-1, preOrder, hashTable);
		node.setLeft(leftNode);
		Node rightNode = reconstructTree(preOrderArray, index+1,end, preOrder,  hashTable);
		node.setRight(rightNode);
		return node;
		
	}
	public void inOrderWithoutRecursion(Node root)
	{
		 Deque<Node> stack = new ArrayDeque<Node>();
		 stack.push(root);
		 Node node = root;
		 while(!stack.isEmpty())
		 {
			 while(node!=null && node.getLeft()!=null)
			 {
				 stack.push(node.getLeft());
				 node = node.getLeft();
				 
			}
			 node = stack.pop();
			 System.out.print(node.getNumber()+" ");
			 node = node.getRight();
			 if(node!=null)
				 stack.push(node);
		 }
		System.out.println("In Order Recursion 2 Ends!");
	}
	public void levelReadPracticeAgain(Node root)
	{
		Queue<Node> queue = new LinkedList();
		queue.add(root);
		Node mark = new Node(null,Integer.MIN_VALUE,null);
		queue.add(mark);
		while(!queue.isEmpty())
		{
			Node node = queue.poll();
			if(node.getNumber()==Integer.MIN_VALUE )
			{
				if(queue.isEmpty())
					break;
				else
				{
					System.out.println();
					queue.add(mark);
					continue;
				}
			}
			System.out.print(node.getNumber()+" ");
			if(node.getLeft()!=null)
			{
				queue.add(node.getLeft());
			}
			if(node.getRight()!=null)
			{
				queue.add(node.getRight());
			}
		}
	}
private class Node
{
	private Node left;
	private Node right;
	private int number;
	public Node(Node left, int number, Node right)
	{
		this.left = left;
		this.number = number;
		this.right = right;
	}
	public Node getLeft() {
		return left;
	}
	public void setLeft(Node left) {
		this.left = left;
	}
	public Node getRight() {
		return right;
	}
	public void setRight(Node right) {
		this.right = right;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	

}
public static void main(String args[])
{
	BinarySearchTree bst = new BinarySearchTree();
	Node root = bst.createTree(4);
	bst.insertToTree(3, root);
	bst.insertToTree(7, root);
	bst.insertToTree(11, root);
	bst.insertToTree(12, root);
	bst.insertToTree(5, root);
	bst.inOrderRead(root);
	System.out.println();
	bst.preOrderRead(root);
	System.out.println();
	bst.postOrderRead(root);
	System.out.println();
	bst.levelRead(root);
	System.out.println();
	String found = String.valueOf(bst.findNode(1, root));
	System.out.println(found);
	found = String.valueOf(bst.findNode(3, root));
	System.out.println(found);
	Node newRoot = bst.removeMax(root);
	bst.levelRead(newRoot);
	System.out.println();
	newRoot = bst.removeNode(12, root);
	bst.levelRead(newRoot);
	System.out.println();

	newRoot = bst.removeNode(11, root);
	System.out.println("remove 11");
	bst.levelRead(newRoot);
	System.out.println();
	bst.insertToTree(2, root);
	bst.insertToTree(6, root);
	System.out.println("add new nodes");
	bst.levelRead(root);
	System.out.println();
	System.out.println("New Level Read");
	bst.levelRead2(root);
	System.out.println();
	newRoot = bst.removeNode(7, root);
	System.out.println("remove 7");
	System.out.println("LevelRead:");
	bst.levelRead(newRoot);
	System.out.println();
	System.out.println("InOrderRead Without Recursion:");
	bst.inOrderReadNotRecursive(root);
	System.out.println();
	System.out.println("InOrderRead Without Recursion2:");
	bst.inOrderWithoutRecursion(root);
	System.out.println();
	BinarySearchTree bst2 = new BinarySearchTree();
	root = bst.createTree(4);	
	bst2.inOrderReadNotRecursive(root);

	int[] inOrder = {1, 4, 10, 3, 7, 11, 8,2};
	int[] preOrder = {7, 10, 4, 1, 3, 2, 8, 11};
	
	Node reconstructedRoot = bst2.reconstructBSTBasedOnPreOrderInOrder(inOrder,preOrder);
	System.out.println("Reconstructed Tree");
	bst.levelReadPracticeAgain(reconstructedRoot);
}
}
