//Given a sorted array of integers, write a function that will return the number with the biggest number of repetitions. 
//(Asked to refine the solution to be more efficient)
public class Question2 {
	public int getMostRepetitive(int []numbers)
	{
		int maxCount = 1;
		int maxNumber = numbers [0];
		int i=0;
		while(i<numbers.length)
		{
			int count = 0;
			int tempNumber = numbers[i];
			while (i< numbers.length && numbers[i] == tempNumber)
			{
				count ++;
				i++;
			}
			
			if (count>maxCount)
			{
				maxNumber = tempNumber;
				maxCount = count;
			}
		}
		return maxNumber;
	}
	public int getMostRepetitiveMoreEfficient(int []numbers)
	{
		int maxCount = 1;
		int count = 1;	
		int number = numbers[0];
		int i=0;
		while(i<numbers.length)
		{
			int tempNumber = numbers[i];
			while(i+count<numbers.length && numbers[i+count]==tempNumber)
			{
				count ++;
			}
			
			if(count>maxCount)
			{
				maxCount = count;
				number = tempNumber;
				i = i+count;
			}
			else
			{
				while(i<numbers.length && numbers[i]==tempNumber)
					i++;
			}
			
			
			
				
		}
		return number;
	}
	public static void main(String args[])
	{
		int [] numbersArray = {1, 1, 3, 3, 3, 5, 5, 7, 7, 9, 9, 9, 9};
		int [] numbersArray2 = {0, 0, 0, 0, 0, 5, 5, 5, 7, 7, 9, 9, 9, 9};
		int [] numbersArray3 = {0, 2, 2, 5, 5, 5, 5, 5, 7, 7, 9};
		int [] numbersArray4 = {0, 0, 0, 5, 5, 5, 7, 7, 9, 9, 9};
		Question2 q2 = new Question2();
		System.out.println("Biggest Repetitive Number in array1 "+q2.getMostRepetitive(numbersArray));
	
		System.out.println("Biggest Repetitive Number in array2 "+q2.getMostRepetitive(numbersArray2));
	
		System.out.println("Biggest Repetitive Number in array3 "+q2.getMostRepetitive(numbersArray3));

		System.out.println("Biggest Repetitive Number in array4 "+q2.getMostRepetitive(numbersArray4));
		System.out.println("Biggest Repetitive Number in array1 by Efficient "+q2.getMostRepetitiveMoreEfficient(numbersArray));
		
		System.out.println("Biggest Repetitive Number in array2 by Efficient"+q2.getMostRepetitiveMoreEfficient(numbersArray2));
	
		System.out.println("Biggest Repetitive Number in array3 by Efficient "+q2.getMostRepetitiveMoreEfficient(numbersArray3));
		
		System.out.println("Biggest Repetitive Number in array4 by Efficient "+q2.getMostRepetitiveMoreEfficient(numbersArray4));
		
	}
}
