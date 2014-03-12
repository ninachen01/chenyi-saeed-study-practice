import java.util.ArrayList;


public class BinaryTree {
	public Node create(Node left, int value, Node right)
	{
		Node node = new Node(left, value,right);
		return node;
		
	}
	private class Node
	{
		Node left;
		int value;
		Node right;
		public Node(Node left, int value, Node right)
		{
			this.left = left;
			this.value = value;
			this.right = right;
		}
		public Node getLeft() {
			return left;
		}
		public void setLeft(Node left) {
			this.left = left;
		}
		public int getValue() {
			return value;
		}
		public void setValue(int value) {
			this.value = value;
		}
		public Node getRight() {
			return right;
		}
		public void setRight(Node right) {
			this.right = right;
		}
		
	}
	public Node insertNode(int value, Node root)
	{
		if (root == null)
			return create(null, value, null);
		if(value<root.getValue())
		{
			Node node = insertNode(value, root.getLeft());
			root.setLeft(node);
		}
		else
		{
			Node node = insertNode(value, root.getRight());
			root.setRight(node);
		}
			
		return root;
		
	}
	public int lookForLongestPath(Node root)
	{
		if(root == null)
			return 0;
		if(root.getLeft()==null && root.getRight()==null)
			return 0;
		int leftLength = 0;
		int rightLength =0;
		if(root.getLeft()!=null)
		{
			leftLength = lookForLongestPath(root.getLeft())+1;
		}
		if(root.getRight()!=null)
		{
			rightLength = lookForLongestPath(root.getRight())+1;
		}
		if(leftLength>rightLength)
			return leftLength;
		else
			return rightLength;
		
	}

	public Node lookForLongestPathEndLeaf(Node root)
	{
		ArrayList<Node> arrayList = new ArrayList<Node>();
		Node lastNode = null;
		if(root == null)
			return null;
		if(root.getLeft()==null && root.getRight()==null)
			return root;
		arrayList.add(root);
		while(!arrayList.isEmpty())
		{
			Node node = arrayList.get(0);
			
			if(node.getLeft()!=null)
			{
				arrayList.add(node.getLeft());
				
			}
			if(node.getRight()!=null)
			{
				arrayList.add(node.getRight());
			}
			if(arrayList.size()==1)
			{
				lastNode = node;
			}
			arrayList.remove(0);
				
		}
		return lastNode;
		
	}
	public void printLevelReadTree(Node root)
	{
		ArrayList<Node> arrayList = new ArrayList<Node>();
		if(root == null)
			return ;
		else
		{
			arrayList.add(root);
			arrayList.add(create(null,Integer.MIN_VALUE,null));
			while(!arrayList.isEmpty())
			{
				Node node = arrayList.get(0);
				int size = arrayList.size();
				if(size == 1)
				{
					System.out.print("\n");
					arrayList.remove(0);
					continue;
				}
				if(node.getValue() == Integer.MIN_VALUE )
				{
					arrayList.remove(0);
					System.out.print("\n");
					arrayList.add(create(null,Integer.MIN_VALUE,null));
					continue;
				}
				System.out.print(node.getValue());
				System.out.print(",");
				arrayList.remove(0);
				if(node.getLeft()!=null)
				{
					arrayList.add(node.getLeft());
					
				}
				if(node.getRight()!=null)
				{
					arrayList.add(node.getRight());
				}
			}
		}
			
	}
	public static void main (String args[])
	{
		BinaryTree binaryTree = new BinaryTree();
		Node root = binaryTree.create(null, 15, null);
		binaryTree.insertNode(19, root);
		binaryTree.insertNode(9, root);
		binaryTree.insertNode(18, root);
		binaryTree.insertNode(7, root);
		binaryTree.insertNode(21, root);
		binaryTree.insertNode(12, root);
		binaryTree.insertNode(13, root);
		binaryTree.insertNode(11, root);
		binaryTree.insertNode(10, root);
		binaryTree.insertNode(25, root);
		binaryTree.insertNode(30, root);
		binaryTree.insertNode(35, root);
		binaryTree.printLevelReadTree(root);
		System.out.println("LongestPath" +binaryTree.lookForLongestPath(root));
		System.out.println("LongestPathLeafNode" +binaryTree.lookForLongestPathEndLeaf(root).getValue());
		
	}

}
