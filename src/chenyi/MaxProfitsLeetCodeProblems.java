package chenyi;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.EmptyStackException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;



public class MaxProfitsLeetCodeProblems {
	public int maxProfit(int[] prices)
	{
		int min=0;
		int profits = 0;
		for(int i=0;i<prices.length;i++)
		{
			if(prices[i]<prices[min])
				min = i;
			int diff = prices[i]-prices[min];
			if(diff>profits)
			{
				profits = diff; 
			}
		}
		return profits;
	}
	public int maxProfitEnhanced(int[] prices)
	{
		int profits = 0;
		if(prices.length==0 || prices.length==1)
			return profits;
		int minPrice = prices[0];
		for(int i=1;i<prices.length;i++)
		{
			if(prices[i]<prices[i-1])
			{
				profits = prices[i-1] - minPrice+profits;
				minPrice = prices[i];
			}						
		}
		if(prices[prices.length-1]>minPrice)
		{
			profits = profits + prices[prices.length-1]-minPrice;
		}
		
		return profits;
	}
	/*My Submissions
	Say you have an array for which the ith element is the price of a given stock on day i.

	Design an algorithm to find the maximum profit. You may complete at most two transactions.

	Note:
	You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).*/
	public int maxProfitEnhanced3(int[] prices) 
	{
		int maxProfits = 0;
		for(int i=1;i<prices.length;i++)
		{
			if(prices[i]>prices[i-1])
			{
				int profits1 = maxProfit(prices, 0, i);
				int profits2 = maxProfit(prices,i+1, prices.length-1);
				if(profits1+profits2>maxProfits)
				{
					maxProfits = profits1+profits2;
				}
			}
			
		}
		return maxProfits;
    }
	
	public int maxProfit(int[] prices,int start,int end)
	{
		int min= start;
		int profits = 0;
		for(int i=start;i<=end;i++)
		{
			if(prices[i]<prices[min])
				min = i;
			int diff = prices[i]-prices[min];
			if(diff>profits)
			{
				profits = diff; 
			}
		}
		return profits;
	}
	/*Evaluate the value of an arithmetic expression in Reverse Polish Notation.

Valid operators are +, -, *, /. Each operand may be an integer or another expression.

Some examples:
  ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
  ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6


*/
	public int evalRPN(String[] tokens) 
	{
		if(tokens.length==0)
			return Integer.MAX_VALUE;
		StackObjectCollection stack = new StackObjectCollection();
		String operators = "+-*/";
		int number = Integer.valueOf(tokens[0]);
		for(int i = 0;i<tokens.length;i++)
		{
			if(operators.contains(tokens[i]))
			{
				int number1 = (Integer)stack.peek();
				int number2 = (Integer)stack.peek();
				switch(operators.indexOf(tokens[i]))
				{
					case 0:
						number = number2+number1;
						break;
					case 1:
						number = number2-number1;
						break;
					case 2:
						number = number2*number1;
						break;
					case 3:
						if(number1==0)
							return Integer.MAX_VALUE;
						number = number2/number1;
						break;
				}
				stack.push(number);
			}
			else
			{
				stack.push(Integer.valueOf(tokens[i]));
			}
		}
		return number;
	}
	public int evalRPNRetarded(String[] tokens) throws Exception 
	{
		if(tokens.length==0)
			return Integer.MIN_VALUE;
		if(tokens.length==1)
			return Integer.valueOf(tokens[0]);
		String operators = "+-*/";
		StackObject<String> stack = new StackObject<String>();
		int number = Integer.MIN_VALUE;
		for(int i= tokens.length-1;i>=0;i--)
		{
			String  s = tokens[i];
			while(!stack.isEmpty())
			{			
				String temp = (String) stack.peek();
				if(!operators.contains(temp) && !operators.contains(s))
				{
					stack.pop();
					String operator = (String)stack.pop();
					int index = operators.indexOf(operator);
					switch(index)
					{
						case 0:
							number = Integer.valueOf(s) + Integer.valueOf(temp);
							break;
						
						case 1:						
							number = Integer.valueOf(s) - Integer.valueOf(temp);
							break;
						case 2:						
							number = Integer.valueOf(s) * Integer.valueOf(temp);
							break;
						case 3:						
							if(Integer.valueOf(temp) == 0)
								return Integer.MIN_VALUE;
							else
								number = Integer.valueOf(s) / Integer.valueOf(temp);
							break;
					}
					s = String.valueOf(number);														
				}
				else
				{
					stack.push(s);
					break;
				}
			}			
			if(stack.isEmpty())
				stack.push(s);
			
				
		}
		return number;
        
    }
	
	public class StackObject<E>
	{
		private E[] array;
		int maxSize = 100;
		int top = -1;
		@SuppressWarnings("unchecked")
		public StackObject()
		{
			array = (E[])new Object[maxSize];
		}
		public void push(E item)
		{
			if(top == maxSize-1)
			{
				maxSize = 2*maxSize;
				array = Arrays.copyOf(array, maxSize);
			}
			array[++top] = item;
		}
		public Object pop() throws Exception
		{
			if(isEmpty())
			{
				throw new EmptyStackException();
			}
			Object item = peek();
			top--;
			return item;
		}
		public Object peek()
		{
			return array[top];
		}
		public boolean isEmpty()
		{		
			if(top==-1)
				return true;
			else
				return false;
		}
		
	}
	public class EmptyStackException extends Exception
	{
		
	}
	public class StackObjectCollection<E>
	{
		List<E> array = new ArrayList<E>();
		public void push(E item)
		{
			array.add(item);
		}
		public Object pop() throws Exception
		{
			Exception e = new EmptyStackException();
			if(array.size()==0)
				throw e;
			int lastIndex = array.size()-1;
			Object item = array.get(lastIndex);
			array.remove(lastIndex);
			return item;			
		}
		public Object peek()
		{
			int lastIndex = array.size()-1;
			return array.get(lastIndex);
		}
		public boolean isEmpty()
		{
			return array.isEmpty();
		}
		
	}
	public class StackObjectCollection2<E> extends ArrayList<E>
	{
		
		public void push(E item)
		{
			add(item);
		}
		public Object pop()
		{
			int lastIndex = size()-1;
			Object item = get(lastIndex);
			remove(lastIndex);
			return item;			
		}
		public Object peek()
		{
			int lastIndex = size()-1;
			return get(lastIndex);
		}
		public boolean isEmpty()
		{
			return isEmpty();
		}
		
	}

	public int maxProfitRetarded(int[] prices) 
	{
		if(prices.length==0)
			return 0;
		if(prices.length==1)
			return prices[0];
		HashMap<Integer, List<Integer>> priceMap = new HashMap();
		for(int i=0;i<prices.length;i++)
		{
			if(priceMap.get(prices[i])==null)
			{
				List<Integer> priceList = new ArrayList<Integer>();
				priceList.add(i);
				priceMap.put(prices[i], priceList);
			}
			else
			{
				List<Integer> priceList = priceMap.get(prices[i]);
				priceList.add(i);
			}
		}
		quickSort(prices, 0, prices.length-1);
		Integer maximumProfits = Integer.MIN_VALUE;
		for(int i=0;i<prices.length;i++)
		{
			int minPrice = prices[i];
			for(int j=prices.length-1;j>=0;j++)
			{
				int maxPrice= prices[prices.length-1];
				List<Integer> minPriceDays = priceMap.get(minPrice);
				List<Integer> maxPriceDays = priceMap.get(maxPrice);
				if(minPriceDays.get(0)<maxPriceDays.get(maxPriceDays.size()-1))
				{
					if(i==0 && j==prices.length-1)
						return maxPrice-minPrice;
					if(maxPrice-minPrice>maximumProfits)
							maximumProfits = maxPrice-minPrice;
					
				}
			}
				
		}			
		
		return maximumProfits;
		
    }
	public void quickSort(int[]prices, int start, int end)
	{
		if(start>end)
			return;
		if(prices.length==0)
			return;
		if(prices.length==1)
			return;
		int pivot = prices[start];
		int i=start; 
		int j= end;
		while(i<j)
		{
			while(i<=end && prices[i]<=pivot)
				i++;
			while(j>=start && prices[j]>pivot)
				j--;
			if(i<j)
			{
				swap(prices, i, j);
			}
		}
		if(j>start)
		{
			swap(prices, j, start);
			quickSort(prices, start, j-1);
			quickSort(prices, j+1, end);
		}
		
	}
	private void swap(int[]prices,int i,int j)
	{
		int temp = prices[i];
		prices[i] = prices[j];
		prices[j] = temp;
	}
	public static void main(String[]args)
	{
		int[]numbers={1};
		MaxProfitsLeetCodeProblems practice = new MaxProfitsLeetCodeProblems();
		practice.quickSort(numbers, 0, 1);
		for(int i=0;i<numbers.length;i++)
			System.out.print(numbers[i]+" ");
		String[] tokens = {"0","3","/"};
		practice.evalRPN(tokens);
		
		   List<String> planetsList = new ArrayList<String>();
		      planetsList.add("Mercury");
		      planetsList.add("Venus");
		      planetsList.add("Earth");
		      planetsList.add("Mars");
		      planetsList.add("Jupiter");
		      planetsList.add("Saturn");
		      planetsList.add("Uranus");
		      planetsList.add("Neptune");
		      Set<String> planetsSet = new TreeSet<String>();
		      practice.copy (planetsList, planetsSet);
		      Iterator<String> iter = planetsSet.iterator();
		      while (iter.hasNext())
		         System.out.println(iter.next());


		
	}
	public  <T> void copy(Collection<T> src, Collection<T> dest)
	   {
	      Iterator<T> iter = src.iterator();
	      while (iter.hasNext())
	         dest.add(iter.next());
	   }

}
