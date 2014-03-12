
public class RunnableExample implements Runnable {
	private int i;
	@Override
	public void run() {
		// TODO Auto-generated method stub
	for(i=0;i<10;i++)
		System.out.print(i+" ");
	}
	public static void main(String []args)
	{
		RunnableExample runnable =  new RunnableExample();	
		Thread t1  = new Thread(runnable);
		t1.start();

		Thread t2 = new Thread(runnable);
		t2.start();
	}

}
