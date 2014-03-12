
public class KthSmalleastNumberSearch {
	//Complexity: log(m+n)
	//i+j+1 = k
	//Ai_1<Bj<Ai return Bj;
	//Bj_1<Ai<Bj return Ai;
	//Ai<Bj, get the portion of Ai+1 +, B0 - Bj_1
	//Bj<Ai, get the portion of A0 - Ai-1,  Bj+1 +
	public int findKthSmallestNumber(int[]arrayA,int startA, int endA, int[]arrayB,int startB, int endB, int k)
	{
		int number = Integer.MIN_VALUE;
		int length1 = endA-startA+1;
		int length2 = endB-startB+1;
		if(k<1)
			return number;
		if(k>length1+length1)
			return number;
		int i = length1/(length1+length2)*(k-1)+startA;
		int j = k - 1- i+startB;
		int Ai_1;
		int Bj_1;
		if(i-1<startA)
			Ai_1 = Integer.MIN_VALUE;
		else
			Ai_1 = arrayA[i-1];
		if(j-1<startB)
			Bj_1 = Integer.MIN_VALUE;
		else
			Bj_1 = arrayB[j-1];
		if(Ai_1<arrayB[j] && arrayB[j]<arrayA[i])
			number = arrayB[j];
		else if(Bj_1<arrayA[i] && arrayA[i]<arrayB[j])
			number = arrayA[i];
		else if(arrayA[i]<arrayB[j])
			number = findKthSmallestNumber(arrayA, i+1, length1-1, arrayB, 0, j-1, k);
		else if(arrayB[j]<arrayA[i])
			number = findKthSmallestNumber(arrayA, 0, i-1, arrayB, j+1, length2-1, k);
		return number;
	}
	//length1*log(length1+length2) + k*log(length1+length2)
	public int getFromMinHeap(int []arrayA, int[]arrayB, int k)
	{
		if(arrayA.length == 0 && arrayB.length ==0)
			return Integer.MIN_VALUE;
		if(arrayA.length+arrayB.length<k)
			return Integer.MIN_VALUE;
		int [] heap = new int[arrayA.length+arrayB.length+1];
		if(arrayA.length>arrayB.length)
		{	for(int i =0 ;i<arrayA.length;i++)
			{
				heap[i+1] = arrayA[i];
			}
			for(int i = 0;i<arrayB.length;i++)
			{
				insertIntoMinHeap(arrayB[i],heap,i+arrayA.length+1);
			}
		}
		else
		{
			for(int i =0 ;i<arrayB.length;i++)
			{
				heap[i+1] = arrayB[i];
			}
			for(int i = 0;i<arrayA.length;i++)
			{
				insertIntoMinHeap(arrayA[i],heap,i+arrayB.length+1);
			}
		}
		
		int min = getMinimumFromMinHeap(heap,arrayA.length+arrayB.length);
		
		for(int i=1;i<k;i++)
		{
			min = getMinimumFromMinHeap(heap,arrayA.length+arrayB.length-i);
		}
		return min;
		
	}
	public void insertIntoMinHeap(int number,int[]heap,int position)
	{
		heap[position] = number;
		while(position/2>0 && heap[position]<heap[position/2])
		{
			int temp = heap[position/2];
			heap[position/2] = heap[position];
			heap[position] = temp;
			position = position/2;
		}
	}
	public int getMinimumFromMinHeap(int[]heap,int lastIndex)
	{
		int root = 1;
		int number = heap[root];
		heap[root] = heap[lastIndex];
		int leftChild = root *2;
		while(leftChild<lastIndex)
		{
			int child = heap [leftChild];
			int childIndex = leftChild;
			if(leftChild +1 <lastIndex && heap[leftChild+1] < heap[leftChild])
			{
				child = heap[leftChild+1];
				childIndex = leftChild +1;
			}
			if(child < heap[root])
			{
				int temp  = heap[root];
				heap[root] = heap[childIndex];
				heap[childIndex] = temp;
			}
			root = childIndex;
			leftChild = childIndex*2;
		}
		return number;
		
	}
	public static void main(String[]args)
	{
		KthSmalleastNumberSearch kthSearch = new KthSmalleastNumberSearch();
		int[]arrayA = {3, 8, 10, 12, 15};
		int[]arrayB = {1, 7, 9};
		int number = kthSearch.findKthSmallestNumber(arrayA, 0,arrayA.length-1, arrayB, 0,arrayB.length-1, 4);
		System.out.println(number);

		number = kthSearch.getFromMinHeap(arrayA, arrayB, 1);
		System.out.println(number);
	}
}
