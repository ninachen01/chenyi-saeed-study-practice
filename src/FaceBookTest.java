import java.util.ArrayList;
import java.util.List;

public class FaceBookTest {
	    public static void main(String args[] ) throws Exception {
	        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
	    	List<Integer> list = new ArrayList<Integer>();
	    	long sum = 0;
	    	for(int i=0;i<args.length;i++)
		    	{
		    		int number = Integer.parseInt(args[i]);
		    		list.add(number);
		    		sum = number + sum;
		    	}
		    	int size = list.size();
		    	if(size>0)
		    	{
		    	long supposedSum = (list.get(0)+list.get(size-1))*(size+1)/2;
		    	System.out.print(supposedSum - sum);
		    	}
	    	}
	    	
	    	
	    
	}

