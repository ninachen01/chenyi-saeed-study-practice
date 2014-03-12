import java.util.ArrayList;
import java.util.List;


public class Fibonacci {
	
	public int fib(int n, int k)
	{
		int sum=0;
		for(int i=k;i>=1;i--)
		{
		  sum += fib(n-i);	
		}
		return sum;
	}
	private int fib(int n)
	{
		if(n==0)
			return 1;
		if(n==1)
			return 1;
		else
		{
			return fib(n-1)+fib(n-2);
		}
			
		
	}
	public static void main(String[]args)
	{
		Fibonacci fibs = new Fibonacci();
		int sum = fibs.fib(4, 4);
		System.out.println(sum);
	}
}
