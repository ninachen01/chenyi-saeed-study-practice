package chenyi;
import java.util.LinkedList;


public class MyQueueClass 
    {
    	LinkedList<Integer> linkedList = new LinkedList<Integer>();
    	LinkedList<Integer> maxList = new LinkedList<Integer>();
    	
		public Integer peek()
    	{
    		return linkedList.get(0);
    	}
    	public Integer dequeue()
    	{
    		int item = linkedList.removeFirst();
    		if(item==maxList.getFirst())
    		{
    			maxList.removeFirst();
    		}
    		return item;
    	}
    	public void enqueue(Integer item)
    	{
    		linkedList.add(item); 
    		if(maxList.isEmpty())
    			maxList.add(item);
    		else
    		{
    		
    			Integer max = maxList.getLast();
    			
    			if(max>item)
    			{
    				maxList.add(item);
    			}
    			else
    			{
    				while(maxList.getLast()<item)
    				{
    					maxList.removeLast();
    				}
    				maxList.add(item);
    				
    			}
    		}
    	}  
    	public Integer pop()
    	{
    		return linkedList.removeLast();
    		
    	}
    	public int getMax()
    	{
    		return maxList.getFirst();
    		
    	}
    }
