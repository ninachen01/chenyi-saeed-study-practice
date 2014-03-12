package chenyi;
import java.util.Arrays;
import java.util.Collections;
import java.util.EmptyStackException;


public class StackExamp {
public StackExamp()
{}
/*	Welcome to Stypi!

	Stypi is a realtime editor that allows multiple users to make changes to a single document at the same time. All you need to do is share the URL with others to begin collaborating!

	This editor also supports programming languages that you can access by clicking on the "</>" button on the top left. For more information on how to use Stypi please click the FAQ link on the bottom left.

	----

	There are four cards on the table; For each card one side has a color, and one side has a number. The cards are arranged so that you see:
	one is red
	one is blue
	one has '8'
	one has '3'

	Which card(s) do you have to turn over to prove or disprove that "a blue card is always even"

	Answer:blue, 3

	----

	Define an interface for a stack that has three methods:

	push: (pushes an element onto the stack)
	pop: (removes and returns the last element that was pushed)
	peek: (returns the last element that was pushed, but does not remove it from the stack)
*/
	public interface Stack<E>
	{
	    public void push(E item);
	    public E pop() throws EmptyStackException;
	    public E peek() throws EmptyStackException;
	    
	}

	public class StackObject<E> implements Stack<E>
	{
	    private E[] list;
	    private int size;
	    private int top;
	    public StackObject (int size)
	    {
	        top = -1;
	        this.size = size;
	        list = (E[])new Object[size];
	    }
	    public void push(E item)
	    {
	        if(top == size-1)
	        {
	            size = size *2;
	            list = Arrays.copyOf(list, size);
	        }
	        list[++top] = item; 
	    }
	    public E pop() throws EmptyStackException
	    {
	        if(top == -1)
	            throw new EmptyStackException();
	        E item  = list[top--];
	        return item;
	    }
	    public E peek() throws EmptyStackException
	    {
	        if(top == -1)
	            throw new EmptyStackException();
	        E item  = list[top];
	        return item;
	    }
	    public StackObject<E> copyOf(StackObject<E>origStack, StackObject<E>destStack)
	    {
	    	destStack.list = Arrays.copyOf(origStack.list, size);
	    	destStack.top = origStack.top;
	    	destStack.size = origStack.size;
	        return destStack;
	    }
	    
	}

	public class StackCreatingStack<E> 
	{
	    private StackObject<E> stack;
	    private int size;
	    public StackCreatingStack(int size)
	    {
	    	this.size = size;
	        stack = new StackObject<E>(size);
	    }
	    // returns a new copy of the stack with the element E pushed into it
	    public StackObject<E> push(E item)   
	    {
	        stack.push(item);
	        StackObject<E> newStack = new StackObject<E>(size);
	        stack.copyOf(stack, newStack);
	        size = newStack.size;
	        return newStack;
	    }
	    // returns a new copy of the stack w/o the popped element
	    public StackObject<E> pop() throws EmptyStackException
	    {
	        stack.pop();
	        StackObject<E> newStack = new StackObject<E>(size);
	        stack.copyOf(stack, newStack);
	        size = newStack.size;
	        return newStack;
	    }
	    
	  /* public Stack peek() throws EmptyStackException
	    {
	        throws new MethodNotImplementedException();
	    }*/
	}
	public static void main(String[] args)
	{
		StackExamp example = new StackExamp();
		StackCreatingStack<Integer> stack = example.new StackCreatingStack(2);
		stack.push(5);
		stack.push(10);
		stack.push(15);
		StackObject<Integer> newStack = stack.pop();

		 newStack = stack.pop();
		System.out.println(stack);
	}

}
