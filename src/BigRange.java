import java.util.ArrayList;


public class BigRange {
	ArrayList<Integer> queueArray = new ArrayList();
	int maxSum;
	int currentSum;
	int queueStart;
	int queueEnd;
	public BigRange(int maxSum, int currentSum, int start, int end)
	{
		this.maxSum = maxSum;
		this.currentSum = currentSum;
		this.queueStart= start;
		this.queueEnd = end;
	}
	public BigRange()
	{
		
	}
	public int getLast()
	{
		int endSize = queueArray.size();
		return  queueArray.get(endSize-1);
	}
	public void removeTail()
	{
		int endSize = queueArray.size();
		queueArray.remove(endSize-1);	
	}
	public void add(int number)
	{
		queueArray.add(number);
	}
	public int size()
	{
		return queueArray.size();
	}
	public BigRange findBigRange(ArrayList<Integer> dataArray)
	{
		BigRange currentRange = new BigRange();
		currentRange.add(dataArray.get(0));
		int currentSum = dataArray.get(0);	
		int maxSum = currentSum;
		currentRange.currentSum = currentSum;
		currentRange.maxSum = maxSum;
		currentRange.queueStart = 0;
		currentRange.queueEnd = 0;
		int start= 0;
		int end = 0;
		for (int i=1;i<dataArray.size();i++)
		{
			if(currentRange.currentSum<0)
			{
				currentSum =  dataArray.get(i);
				currentRange.currentSum = currentSum;
				currentRange.queueStart =i;
				currentRange.queueEnd =i;
				if(maxSum<currentRange.currentSum)
				{
					start = currentRange.queueStart;
					end = 		currentRange.queueEnd;
					maxSum = currentRange.currentSum;
					currentRange.maxSum = maxSum;
				}
				currentRange.removeTail();
				currentRange.add(dataArray.get(i));
				
			}
			
			else if (dataArray.get(i)<0 && dataArray.get(i)+currentRange.currentSum>=0)
			{
				currentRange.queueEnd = i;
				currentSum = dataArray.get(i) + currentSum;
				currentRange.currentSum = currentSum;
				currentRange.add(dataArray.get(i));
			
			}
			else if(dataArray.get(i)<0 && dataArray.get(i)+currentRange.currentSum<0)
			{
				currentRange= new BigRange();
				currentRange.add(dataArray.get(i));
				currentSum = dataArray.get(i) ;
				currentRange.currentSum = currentSum;
				currentRange.maxSum = currentRange.currentSum;
				
			}
			else if(dataArray.get(i)>0 )
			{
				currentRange.currentSum = dataArray.get(i) + currentSum;
				currentSum = currentRange.currentSum;
				currentRange.queueEnd = i;
				if(maxSum<currentRange.currentSum)
				{
					start = currentRange.queueStart;
					end = 		currentRange.queueEnd;
					maxSum = currentRange.currentSum;
					currentRange.maxSum = maxSum;
				}
				currentRange.add(dataArray.get(i));
				
			}

	
			
		}
		return new BigRange(maxSum, currentSum, start, end);

	
			
		
		
	}
	public static void main(String[] args)
	{
		
		ArrayList<Integer> dataArray = new ArrayList<Integer>();
		dataArray.add(-11);dataArray.add(1);dataArray.add(10);dataArray.add(-4);dataArray.add(-8);dataArray.add(20);dataArray.add(-21);dataArray.add(45);dataArray.add(41);
		for(int i =0;i<dataArray.size();i++)
		{
			System.out.print(dataArray.get(i)+",");
		}
		System.out.println();
		BigRange bigRange = new BigRange();
		BigRange foundRange = bigRange.findBigRange(dataArray);
		System.out.print(foundRange.maxSum+",");
		System.out.print(foundRange.currentSum+",");
		System.out.print(foundRange.queueStart+",");
		System.out.println(foundRange.queueEnd+".");
		
	
		
	}

}
