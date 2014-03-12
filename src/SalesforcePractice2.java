
public class SalesforcePractice2 {
	
		public int findMedianNumber(int[]array)
		{
			int size = array.length;
			int medianIndex = size/2;
			int median =-1;
			if(array.length %2 ==0)
			{
				int median1 =-1;
				int median2 = -1;
				while(median1==-1)
				{
					median1 = quickSortPilotInMiddle(medianIndex, array, 0, array.length-1);
				}
				while(median2==-1)
				{
					median2 = quickSortPilotInMiddle(medianIndex-1, array, 0, array.length-1);
				} 
				median = (median1+median2)/2;
			}
			else
			{
				while(median == -1)
				{
				 median = quickSortPilotInMiddle(medianIndex, array, 0, array.length-1);
				}
			}
			return median;
		}
		public int quickSortPilotInMiddle(int medianIndex, int[] array, int start, int end)
		{
			int indexStart = start;
			int indexEnd = end;
			int pilot = array[medianIndex];
			int median = -1;
			if(medianIndex<=indexEnd && medianIndex>=indexStart)
			{
				pilot = array[medianIndex];
			}
			while(start<end && start<=indexEnd && end>=indexStart)
			{
				while(start<=indexEnd && array[start]<=array[medianIndex]  )
				{
					start ++;
				}
				while(end>=indexStart && array[end]>array[medianIndex] )
				{
					end --;
				}
				if(start<end )
				{
					int temp = array[start];
					array[start] = array[end];
					array[end] = temp;
					if(end == medianIndex)
						return -1;
				}
				
			}
				array[medianIndex] = array[end];
				array[end] = pilot;
			
			if(end == medianIndex)
				 median = array[medianIndex];
			return median;
			
		}
		public static void main(String args[])
		{
			 int[] array = {13, 26, 27, 29, 4, 7, 8};
			 SalesforcePractice2 salesforcePractice = new SalesforcePractice2();
			 System.out.println("Median Number is Here " + salesforcePractice.findMedianNumber(array));
			 int[] array2 = {13, 26, 27, 29, 4, 7, 8, 5, 12};
			 System.out.println("Median Number is Here "+ salesforcePractice.findMedianNumber(array2));
			
			 int[] array3 = {13, 26, 27, 29, 4, 1, 7, 8};
			 
			 System.out.println("Median Number is Here "+salesforcePractice.findMedianNumber(array3));
			 int[] array4 = {1, 2, 7, 9, 14, 15, 17, 18};
			 
			 System.out.println("Median Number is Here "+salesforcePractice.findMedianNumber(array4));
			 int[] array5 = {1, 2, 7, 9, 14, 15, 17};
			 
			 System.out.println("Median Number is Here "+salesforcePractice.findMedianNumber(array5));
			 int[] array6 = {31, 22, 17, 16, 14, 5, 4, 3};
			 
			 System.out.println("Median Number is Here "+salesforcePractice.findMedianNumber(array6));
			 int[] array7 = {31, 22, 17, 16, 14, 5, 4};
			 
			 System.out.println("Median Number is Here "+salesforcePractice.findMedianNumber(array7));
		}
	
}
