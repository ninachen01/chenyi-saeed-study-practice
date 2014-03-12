package chenyi;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.NoSuchElementException;


public class ModifiedQueue 
{
	LinkedList<Integer> list = new LinkedList<Integer>();
	LinkedList<Integer> minList = new LinkedList<Integer>();
	public void enqueue(int item)
	{
		list.addLast(item);
		if(minList.isEmpty())
			minList.addLast(item);
		else
		{
			while(!minList.isEmpty()&&item<minList.getLast())
			{
				minList.removeLast();
			}
			minList.add(item);
		}
	}
	public int dequeue()
	{
		if(list.isEmpty())
			throw new NoSuchElementException();
		if(list.getFirst()==minList.getFirst())
		{
			minList.removeFirst();
		}
		return list.removeFirst();
		
	}
	public int getMin()
	{
		if(minList.isEmpty())
			throw new NoSuchElementException();
		return minList.getFirst();
	}
	public static void main(String[]args)
	{
		ModifiedQueue queue = new ModifiedQueue();
		queue.enqueue(14);
		queue.enqueue(3);
		queue.enqueue(5);
		queue.enqueue(7);
		queue.enqueue(3);
		System.out.print(queue.getMin()+" ");
		System.out.print(Arrays.toString(queue.list.toArray()));
		System.out.println(Arrays.toString(queue.minList.toArray()));
		queue.dequeue();
		System.out.print(queue.getMin()+" ");
		System.out.print(Arrays.toString(queue.list.toArray()));
		System.out.println(Arrays.toString(queue.minList.toArray()));
		queue.dequeue();
		System.out.print(queue.getMin()+" ");
		System.out.print(Arrays.toString(queue.list.toArray()));
		System.out.println(Arrays.toString(queue.minList.toArray()));
		queue.dequeue();
		System.out.print(queue.getMin()+" ");
		System.out.print(Arrays.toString(queue.list.toArray()));
		System.out.println(Arrays.toString(queue.minList.toArray()));
		queue.dequeue();
		queue.dequeue();
		System.out.print(queue.getMin()+" ");
		System.out.print(Arrays.toString(queue.list.toArray()));
		System.out.println(Arrays.toString(queue.minList.toArray()));
	}
}
