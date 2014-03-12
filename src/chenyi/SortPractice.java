package chenyi;



public class SortPractice {
	
	public void quickSort(int[]array, int start, int end)
	{
		int pivotIndex = start;
		int pivot = array[start];
		int i = start;
		int j = end;
		while(start<end)
		{
			while(start<=j && array[start]<=pivot)
			{
				start++;
			}
			
			while(end>=i && array[end]>pivot)
			{
				end--;
			}
			if(start<end)
			{
				int temp = array[start] ;
				array[start] = array[end];
				array[end] = temp;
			}
		}
		int temp = array[end];
		array[end]=pivot;
		array[pivotIndex] = temp;
		if(end-1>i)
		{
			quickSort(array,i,end-1);
		}
		if(end+1<j)
		{
			quickSort(array, end+1, j);
		}
	}
	public void heapSortDescending(int[]array)
	{
		int[]maxHeap = buildMaxHeap(array);
		int size = array.length;
		for(int i=0;i<array.length;i++)
		{
			int maximum = removeFromMaxHeap(maxHeap,size);
			array[i] = maximum;
			size --;
		}
		
	}
	private int[] buildMaxHeap(int[]array)
	{
		int[]maxHeap = new int[array.length+1];
		for(int i=0;i<array.length;i++)
		{
			insertToMaxHeap(array[i],maxHeap,i+1);
		}
		return maxHeap;
	}
	private void insertToMaxHeap(int number, int[]maxHeap, int index)
	{
		maxHeap[index] = number;
		int parent = index/2;		
		while(parent>0 && maxHeap[parent]<maxHeap[index])
		{
			int temp = maxHeap[parent];
			maxHeap[parent] = maxHeap[index];
			maxHeap[index]=temp;
			index = parent;
			parent = parent/2;
		}
		
	}
	private int removeFromMaxHeap(int[]maxHeap,int size)
	{
		int number = maxHeap[1];
		int parent = 1;
		maxHeap[parent]=maxHeap[size];
		int child = parent*2;
		
		while((child<size && maxHeap[parent]<maxHeap[child])||
				(child+1<size && maxHeap[parent]<maxHeap[child+1]))
		{
			int temp = maxHeap[parent];
			if(child+1<size && maxHeap[child+1]>maxHeap[child])
			{
				maxHeap[parent] = maxHeap[child+1];
				maxHeap[child+1] = temp;
				parent = child+1;
				child = parent*2;
			}else
			{
				maxHeap[parent] = maxHeap[child];
				maxHeap[child] = temp;
				parent = child;
				child = parent*2;
			}
		
		}
		return number;
	}
	public void heapSortAscending(int[]array)
	{
		int[]minHeap = buildMinHeap(array);
		int size = array.length;
		for(int i=0;i<array.length;i++)
		{
			int minimum = removeFromMinHeap(minHeap,size);
			array[i] = minimum;
			size --;
		}
	}
	private int[] buildMinHeap(int[]array)
	{
		int[]minHeap = new int[array.length+1];
		for(int i=0;i<array.length;i++)
		{
			insertToMinHeap(array[i],minHeap,i+1);
		}
		return minHeap;
	}
	private int removeFromMinHeap(int[]minHeap,int size)
	{
		int parent = 1;
		int min = minHeap[parent];
		minHeap[parent] = minHeap[size];
		int child = parent*2;
		if (child>=size)
		{
			return min;
		}
		if(child+1<size && minHeap[child+1]<minHeap[child])
		{
			child = child+1;
		}
		
		while(minHeap[child]<minHeap[parent])
		{
			int temp = minHeap[parent];
			minHeap[parent] =  minHeap[child];
			minHeap[child] = temp;
			parent = child;
			child = parent*2;
			if(child>size)
				break;
			if(child+1<size && minHeap[child+1]<minHeap[child])
			{
				child = child+1;
			}
			
		}
		return min;		
		}

	private void insertToMinHeap(int number, int[]minHeap,int index)
	{
		minHeap[index] = number;
		int child = index;
		int parent = child/2;
		while(parent>0 && minHeap[parent]>minHeap[child])
		{
			int temp = minHeap[parent];
			minHeap[parent] = minHeap[child];
			minHeap[child] = temp;
			child = parent;
			parent = child/2;
		}
	}
	public void mergeSort(int[]array, int start,int end)
	{
		int middle = (start+end)/2;
		if(start<end)
		{
			mergeSort(array,start,middle);
			mergeSort(array,middle+1, end);
			combine(start,end,array);
		}
		
	}
	private void combine(int start, int end, int[]array)
	{
		int middle = (start+end)/2;
		int[]helpArray = new int[array.length] ;
		for(int i = start;i<=end;i++)
		{
			helpArray[i] = array[i];
		}
		
		int firstHalf = start;
		int secondHalf = middle+1;
		while(firstHalf<=middle && secondHalf<=end)
		{
			if(helpArray[firstHalf]>helpArray[secondHalf])
			{
				array[start] = helpArray[secondHalf];
				secondHalf++;
			}
			else
			{
				array[start]=helpArray[firstHalf];
				firstHalf++;
			}
			start++;
		}
		while(firstHalf<=middle)
			{
				array[start]=helpArray[firstHalf];
				firstHalf++;
				start++;
			}
	}
	public void insertionSort(int[]array)
	{
		for(int i=1; i<array.length;i++)
		{
			int j = i-1;
			int number = array[i];
			while(j>=0 && number <array[j])
			{
				array[j+1] = array[j];
				j--;
			}
			array[j+1]=number;
		}
	}
	public static void main(String args[])
	{
		int[]array ={33, 35, 18, 13, 45, 90, 56, 100, 11, 4, 5,10, 101};
		SortPractice sortPractice  = new SortPractice();
		sortPractice.quickSort(array, 0, array.length-1);
		sortPractice.print(array);
		int[] array2 ={100, 90, 80, 50, 10};
		sortPractice.quickSort(array2, 0, array2.length-1);
		sortPractice.print(array2);
		int[] array3 ={10, 60, 80, 90, 100};
		sortPractice.quickSort(array3, 0, array3.length-1);
		sortPractice.print(array3);

		int[] array13 ={13, 5, 4, 7, 11};
		sortPractice.quickSort(array13, 0, array13.length-1);

	System.out.print("array13 ");
		sortPractice.print(array13);
		
		int[] array4 ={60, 10, 80, 90, 100};
		sortPractice.mergeSort(array4, 0, array4.length-1);
		sortPractice.print(array4);
		
		int[] array5 ={33, 35, 18, 13, 45, 90, 56, 100};
		sortPractice.mergeSort(array5, 0, array5.length-1);
		sortPractice.print(array5);
		
		int[] array6 ={33, 35, 18, 13, 45, 90, 56, 100};
		sortPractice.heapSortDescending(array6);
		System.out.print("heapSort Descending ");
		sortPractice.print(array6);
		

		int[] array7 ={60, 10, 80, 90, 100};
		sortPractice.heapSortDescending(array7);
		System.out.print("heapSort Descending ");
		sortPractice.print(array7);
		
		
		int[] array8 ={33, 33, 18, 13, 45, 90, 56, 100};
		sortPractice.heapSortAscending(array8);
		System.out.print("heapSort Ascending ");
		sortPractice.print(array8);
		

		int[] array9 ={60, 10, 80, 90, 100};
		sortPractice.heapSortAscending(array9);
		System.out.print("heapSort Ascending ");
		sortPractice.print(array9);
		

		int[] array10 ={60, 10, 80, 90, 100};
		sortPractice.insertionSort(array10);
		System.out.print("Insertion Sort");
		sortPractice.print(array10);
		

		int[] array11 ={33, 33, 18, 13, 45, 90, 56, 100};
		sortPractice.insertionSort(array11);
		System.out.print("Insertion Sort");
		sortPractice.print(array11);
		
	}
	public void print(int[]array)
	{
		for(int i = 0;i<array.length;i++)
			System.out.print(array[i]+" ");
		System.out.print("\n");
	}
	
}
