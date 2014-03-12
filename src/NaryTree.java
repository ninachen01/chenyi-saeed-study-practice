import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;


public class NaryTree {

	public class Node
	{
		int value;
		LinkedList<Node> nodeList;
		public boolean hasChildren()
		{
			return nodeList!=null;
		}
		public Node( int value,LinkedList<Node>nodeList)
		{
			this.value = value;
			this.nodeList = nodeList;
		}
	}

	public void readDFS(Node root)
	{
		if(root == null)
			return;
		
		System.out.print(root.value+" ");
		if(root.hasChildren())
		{
			LinkedList<Node> nodeList = root.nodeList;
			Iterator<Node> iterator = nodeList.iterator();
			while(iterator.hasNext())
			{
				readDFS(iterator.next());
			}
		
		}
	}
	public void readBFS(Node root)
	{
		Queue<Node> queue = new LinkedList<Node>();
		if(root == null)
			return;
		queue.add(root);
		while(!queue.isEmpty())
		{
			Node node = queue.poll();
			System.out.print(node.value+" ");
			if(node.hasChildren())
			{
				LinkedList<Node> nodeList = node.nodeList;
				Iterator<Node> iterator = nodeList.iterator();
				while(iterator.hasNext())
				{
					queue.add(iterator.next());	
				}
	
			}
	   }
	}
	
	public static void main(String[]args)
	{
		NaryTree narayTree = new NaryTree();
		
		LinkedList<Node> nodeList = new LinkedList();
		LinkedList<Node> nodeList2 = new LinkedList();
		LinkedList<Node> nodeList3 = new LinkedList();
		LinkedList<Node> nodeList4 = new LinkedList();
		
		Node node1 = narayTree.new Node(14,nodeList);
		Node node2 = narayTree.new Node(17,null);
		Node node3 = narayTree.new Node(13,nodeList4);
		Node node4 = narayTree.new Node(12,null);
		Node node5 = narayTree.new Node(11,null);
		Node node6 = narayTree.new Node(18,nodeList2);
		
		
		nodeList.add(node2);
		nodeList.add(node3);
		nodeList.add(node4);
		nodeList.add(node6);
		nodeList2.add(node2);
		nodeList3.add(node5);
		nodeList4.add(node2);
		nodeList4.add(node5);
		nodeList4.add(node6);
		narayTree.readDFS(node1);
		System.out.println();
		narayTree.readBFS(node1);

	}

}
