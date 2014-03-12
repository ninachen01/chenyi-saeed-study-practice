package chenyi;
import java.util.ArrayList;


public class MinHeap {
	
	ArrayList<Integer> heapArray ;
	public MinHeap()
	{
		heapArray = new ArrayList<Integer>();
		heapArray.add(Integer.MIN_VALUE);
	}
	
	public ArrayList<Integer> getHeapArray() {
		return heapArray;
	}
	public void insertNode(int node)
	{
		heapArray.add(node);
		int nodeIndex = heapArray.size() -1;
		int parentIndex = nodeIndex/2;
		if(parentIndex == 0)
			return;
		else 
		{
			while(parentIndex>0 && heapArray.get(parentIndex)>node)
			{
				int temp = heapArray.get(parentIndex);
				heapArray.set(parentIndex, node);
				heapArray.set(nodeIndex, temp);
				nodeIndex = parentIndex;
				parentIndex = parentIndex/2;
			}
		}
	}
		public int removeMin()
		{
			int size = heapArray.size();
			int minRoot = Integer.MIN_VALUE;
			int lastNode = Integer.MAX_VALUE;
			if(size==1)
				return minRoot;
			else if(size ==2)
			{
				return heapArray.remove(1);
			}
			else
			{
				minRoot = heapArray.get(1);
				lastNode = heapArray.get(size-1);
				heapArray.set(1, lastNode);
				heapArray.remove(size-1);
			}	
			size = heapArray.size();
			if(size==2)
			{
				return lastNode;
			}
			int childIndex;

			int tempNode = lastNode;
			int tempIndex = 1;
			do
			{
				int child1Index = tempIndex*2;
				int child2Index = tempIndex*2+1;
				if(child1Index<size)
				{
						int child1 = heapArray.get(child1Index);
						int child = child1;
						childIndex = child1Index;
					
						if(child2Index<size)
						{
							int child2 = heapArray.get(child2Index);
							if(child2<child1)
							{
								childIndex = child2Index;
								child = child2;
							}
		
						}
						if(child<tempNode)
						{
							heapArray.set(childIndex, tempNode);
							heapArray.set(tempIndex, child);
							tempIndex = childIndex;
				}
				else 
					break;
				}
				else
					break;
				
			}while(childIndex<size-1);
			return lastNode;	
		}
		
		
	
	public static void main(String args[])
	{
		MinHeap minHeap = new MinHeap();
		minHeap.insertNode(14);
		minHeap.insertNode(5);
		minHeap.insertNode(8);
		minHeap.insertNode(18);
		minHeap.insertNode(32);
		minHeap.insertNode(1);
		minHeap.insertNode(7);
		minHeap.insertNode(40);
		for(int n:minHeap.getHeapArray())
		{
			if(n == Integer.MIN_VALUE)
				continue;
			else
			{
				System.out.print(n+" ");
			}
		}
		System.out.println();
		minHeap.removeMin();
		minHeap.removeMin();
		for(int n:minHeap.getHeapArray())
		{
			if(n == Integer.MIN_VALUE)
				continue;
			else
			{
				System.out.print(n+" ");
			}
		}
		
		
	}

}
