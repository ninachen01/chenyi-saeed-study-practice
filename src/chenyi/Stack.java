package chenyi;
import java.util.ArrayList;

public class Stack
{
	private ArrayList<StackItem> stackArray = new ArrayList<StackItem>();
	private int minValue = Integer.MAX_VALUE;
	public int findMin()
    {
   
		int stackSize = stackArray.size();
		StackItem stackItem  = stackArray.get(stackSize-1);
		return stackItem.getMinValue();
	
	}
	public void push(int value)
	{
		if(stackArray.isEmpty())
		{
			minValue = value;
			StackItem stackItem = new StackItem (value, minValue);
			
			stackArray.add(stackItem);
		}
		else
		{
			if(value < minValue)
			{
				minValue = value;
			}
			
			StackItem stackItem = new StackItem(value, minValue);
			stackArray.add(stackItem);
		}
		
	}
	public int pop()
	{
		int stackSize = stackArray.size();
		StackItem stackItem  = stackArray.get(stackSize-1);
		stackArray.remove(stackSize-1);
		return stackItem.getValue();
	}
	private class StackItem
	{
		private int value;
		private int minValue;
		public StackItem(int value, int minValue)
		{
			this.value = value;
			this.minValue = minValue;
		}
		public int getValue()
		{
			return this.value;
		}
		public int getMinValue()
		{
			return this.minValue;
		}
	}
	public static void main(String[] args)
	{
		Stack stack = new Stack();
		stack.push(2);
		stack.push(6);
		stack.push(-19);
		stack.push(1);
		stack.push(-200);
		System.out.println(stack.findMin());
		stack.pop();
		System.out.println(stack.findMin());
		stack.pop();
		System.out.println(stack.findMin());
		stack.pop();
		System.out.println(stack.findMin());
	
		
	}
}
