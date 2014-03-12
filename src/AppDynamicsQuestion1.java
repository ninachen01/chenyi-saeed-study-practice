import java.util.ArrayList;


public class AppDynamicsQuestion1 {
	
	public boolean whetherCanBeFormed(int[]array, int targetNumber)
	{
		boolean formed = false;
		ArrayList<Integer> targetArray = new ArrayList<Integer>();
		quickSort(array, 0, array.length-1);
		for(int i=0;i<array.length;i++)
		{
			if(array[i]<=targetNumber)
			{
				targetArray.add(array[i]);
			}
			else 
				break;
			System.out.print(targetArray.get(i)+" ");
		}
		System.out.println();
		while(!formed)
		{
			int size = targetArray.size();
			if(size == 0)
				break;
			int middleIndex = (size-1)/2;
			int middleNumber = targetArray.get(middleIndex);
			int number = targetNumber - middleNumber;
			if(number == middleNumber)
			{
				if(targetArray.get(middleIndex-1) == number||targetArray.get(middleIndex+1)==number)
					return true;
				else
					return false;
			}
			formed = binarySearch(targetArray,0, size-1, number);
			int foundNumber = targetArray.remove((size-1)/2);
			if(formed)
			{
				System.out.println(targetNumber + " is formed by "+foundNumber+" and " +number);
			}
			
		}
		return formed;
	}
	private boolean binarySearch(ArrayList<Integer> targetArray, int start, int end, int number)
	{
		boolean formed = false;
		int middle = (start+end)/2;
		int middleNumber = targetArray.get(middle);
		if(middleNumber == number)
			return true;
		if(targetArray.get(start)>number)
			return false;
		if(targetArray.get(end)<number)
			return false;
		if(middleNumber<number)
		{
			formed = binarySearch(targetArray,middle+1, end, number);
		}
		else if(middleNumber>number)
		{
			formed = binarySearch(targetArray,start, middle-1, number);
		}

		return formed;
	}
	private void quickSort(int[]array,int start, int end)
	{
		if(start<end )
		{
			int i=0;
			int j=end;
			int targetNumber = array[start];
			while(i<=j)
			{
				while(array[i]<=targetNumber)
				{
					i++;
				}
				while(array[j]>targetNumber)
				{
					j--;
				}
				if(i<j)
				{
					swap(i,j,array);
				}
			}
			if(start<j)
			{
				swap(start,j,array);
			}
			quickSort(array, start, j-1);
			quickSort(array, j+1, end);
			
		}
		
	}
	private void swap(int i, int j, int[]array)
	{
		int temp =  array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	public static void main(String []args)
	{
		AppDynamicsQuestion1 question1 = new AppDynamicsQuestion1();
		int array[] ={12, 31, 1, 15, 5, 7, 29, 7};
		boolean formed = question1.whetherCanBeFormed(array, 20);
		if(formed)
			System.out.println("true");
		else
			System.out.println("false");
	}
}
