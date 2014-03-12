package chenyi;

public class Sort {
	public void mergeSort(int[] data, int start, int end)
	{
		if(start+1 == end)
		{
			if(data[start]>data[end])
			{
				int temp = data[start];
				data[start] = data[end];
				data[end] = temp;
			}
			return ;
		}
		if(start == end)
			return;
		int firstHalf = (start+end)/2;
		int secondHalf = firstHalf +1;
		mergeSort(data,start, firstHalf);
		mergeSort(data, secondHalf, end);
		merge(data, start, firstHalf, end);
	}
	public void merge(int[] data, int start, int firstHalf, int end)
	{
		int i = start;
		for(int j=firstHalf+1;j<=end;j++)
		{
			int temp = data [j];
			while(i<j)
			{
				if(data[i]>data[j])
				{
					for(int k=j;k>i;k--)
					{
						
						data[k] = data[k-1];
						
					}
					data [i] = temp;
					i++;
					break;
				
				}
				else
				{
					i++;
				}

			}

		}
		
	}
	public static void main(String[] args)
	{
		Sort sort = new Sort();
		int[] dataArray = {3, 7, 1, 41, 2, 10, 11,2,0,-10};
		for(int i =0;i<dataArray.length;i++)
		{
			System.out.print(dataArray[i]+",");
		}
		System.out.println();
		int size = dataArray.length;
		sort.mergeSort(dataArray, 0, size-1);
		for(int i =0;i<dataArray.length;i++)
		{
			System.out.print(dataArray[i]+",");
		}
		
	
		
	}

}
