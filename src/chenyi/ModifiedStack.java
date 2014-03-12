package chenyi;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.NoSuchElementException;

	//Design a modified stack that in addition to Push and Pop can also provide minimum element present in the stack via Min function.
public class ModifiedStack
{
	LinkedList<Integer> list = new LinkedList<Integer>();
	LinkedList<Integer> minList = new LinkedList<Integer>();
	public int pop()
	{
		if(list.isEmpty())
			throw new NoSuchElementException();
		minList.removeLast();
		return list.removeLast();

	}
	public void push(Integer item)
	{
		list.addLast(item);
		if(minList.isEmpty())
			minList.add(item);
		else
		{
			int value = minList.getLast();
			if(value>item)
			{
				minList.addLast(item);
			}
			else
				minList.addLast(value);
		}
		
	}
	public int getMin()
	{
		if(minList.isEmpty())
			throw new NoSuchElementException();
		return minList.getLast();
	}
	public static void main(String[]args)
	{
		ModifiedStack stack = new ModifiedStack();
		stack.push(4);
		stack.push(14);
		stack.push(10);
		stack.push(5);
		System.out.print(stack.getMin()+" ");
		System.out.println(Arrays.toString(stack.list.toArray()));
		stack.pop();
		stack.pop();
		System.out.print(stack.getMin()+" ");
		System.out.println(Arrays.toString(stack.list.toArray()));
		stack.push(0);
		System.out.print(stack.getMin()+" ");	
		System.out.println(Arrays.toString(stack.list.toArray()));
		stack.pop();
		stack.pop();
		System.out.print(stack.getMin()+" ");	
		System.out.println(Arrays.toString(stack.list.toArray()));
	}
}
