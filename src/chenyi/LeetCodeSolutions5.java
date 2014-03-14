package chenyi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCodeSolutions5 
{
	 public ArrayList<String> fullJustify(String[] words, int L) {
  	   ArrayList<String> res = new ArrayList<String>();
         if(words.length==0)
         {
      	   return res;
         }               
         int leftSpace = L;
         int wordsNumber = 0;
         int start = 0;
         int end = words.length;
  	   StringBuilder sb = new StringBuilder();
         
         // if words fits...add length and next!
         
         // else thie line is done! reset counters       
             
         while(start<end)
         {
             if(wordsNumber==0)
             {
                 // The first word has no space after it
                 sb.append(words[start]);
                 leftSpace = leftSpace-words[start].length();
                 wordsNumber++;
                 start++;
             }
              else
             {                    	
              	if(leftSpace-words[start].length()-1<0)
              	{
              		sb = addPadding(wordsNumber, leftSpace, sb);
              		leftSpace = 0;
              		
              	}
              	else 
              	{
              		 sb.append(" ");                  
              		 sb.append(words[start]);
              		 leftSpace = leftSpace-words[start].length()-1;
              		 wordsNumber++;
                       start++;
              	}
             }
             if(leftSpace == 0)
             {
                 // Aren't we lucky!
                 res.add(sb.toString());
                 wordsNumber=0;
                 sb = new StringBuilder();
                 leftSpace = L;
             }
             else if(start==end)
             {
          	   if(leftSpace>0)
          	   {
          		   sb = addPadding(wordsNumber, leftSpace, sb);
          	   }
          	   res.add(sb.toString());
             }
         }
         return res;
  }
      private StringBuilder addPadding(int wordsNumber, int leftSpace, StringBuilder sb)
  {
		int addingSpace = 0;
		int remains = 0;
		String[] wordsLine = sb.toString().split(" ");
		sb = new StringBuilder();
  	if(wordsNumber>1)
		{
			addingSpace = leftSpace/(wordsNumber-1);
			remains = leftSpace%(wordsNumber-1);
  		for(int j=0;j<wordsNumber-1;j++)
  		{
  			String word = wordsLine[j];
  			sb.append(word).append(" ");
  			int i=0;  
  			while(i<addingSpace)
  			{
  				sb.append(" ");
  				i++;
  				leftSpace--;
  			}
  			if(remains>0)
  			{
					sb.append(" ");
					remains--;
					leftSpace--;
  			}
  		
  		}

  		sb.append(wordsLine[wordsNumber-1]); 
		} 
  	else if(wordsNumber==1)
		    sb.append(wordsLine[wordsNumber-1]);
		while(leftSpace>0)
		{
			sb.append(" ");
			leftSpace--;
		}
		return sb;
  }
   
    public String intToRoman(int num) 
    {
    	if(num<=0)
    		return "";
    	String number = String.valueOf(num);
    	StringBuilder sb = new StringBuilder(number);
    	sb = sb.reverse();
    	String numberS = sb.toString();
    	sb = new StringBuilder();
    	int i = 0;
    	while(i<numberS.length())
    	{
    		int power = (int) Math.pow(10, i);
    		int currentN = numberS.charAt(i)-'0';
    		if(currentN == 4 || currentN == 9)
    		{
    			String s = getRoman((currentN*power)+power);
    			sb.append(s);
    			s = getRoman(power);
    			sb.append(s);
    		}
    		else
    		{
    			if(currentN/5>0)
    			{
    				int j = currentN%5;
    				while(j>0)
    				{
    					String s = getRoman(power);
    					sb.append(s);
    					j--;
    				}
    				String s = getRoman(5*power);
    				sb.append(s);

    				
    			}
    			else
    			{
    				int j = 0;
    				while(j<currentN)
    				{
    					String s = getRoman(power);
    					sb.append(s);
    					j++;
    				}
    			}
    		}
    		
    		i++;
    			
    	}
    	return sb.reverse().toString();
        
    }
    public String getRoman(int i)
    {
    	switch(i)
    	{
    		case 1:  return "I";
    		case 5:  return "V";
    		case 10: return "X";
    		case 50: return "L";
    		case 100:return "C";
    		case 500:return "D";
    		case 1000:return "M";
    		default: return "";
    	
    	}
    }
    public int getDecimal(char c) {
        switch(c) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }
    /*
     * For example, given array S = {-1 0 1 2 -1 -4},

    A solution set is:
    (-1, 0, 1)
    (-1, -1, 2)
    */
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) 
    {
    	 ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    	 int length = num.length;
    	 if(length<3)
    		 return result;
    	 Arrays.sort(num);
    	 List<Integer> posList = new ArrayList<Integer>();
    	 List<Integer> negList = new ArrayList<Integer>();
    	 if(num[0]>=0)
    		 return result;
    	 if(num[length-1]<=0)
    		 return result;
    	 boolean isZero=false;
    	 for(int i=1;i<length;i++)
    	 {
    		 if(num[i]==0)
    		 {
    			 isZero = true;
    		 }
    		 else if(num[i]<0)
    		 {
    			 negList.add(num[i]);
    		 }
    		 else
    		 {
    			 posList.add(num[i]);
    		 }
    		
    	 } 
    	 if(isZero)
    	 {
    		 for(int i=0;i<negList.size();i++)
    		 {
    			 int positive = 0-negList.get(i);
    			 if(posList.contains(positive))
    			 {
    				 addToResult(negList.get(i),positive, 0,result);
    			 }
    		 }
    		 
    	 }
    	 if(posList.size()>1)
    	 {
    		 int p1 = posList.size()-1;
    		 int p2 = p1-1;
	    	 for(int i=0;i<negList.size() && p1>=0;)
			 {
	    		 int tempSum = negList.get(i)+posList.get(p1)+posList.get(p2);
	    		 if(tempSum==0)
	    		 {
	    			 addToResult(negList.get(i),posList.get(p1), posList.get(p2),result);
	    		 }
	    		
	    		 else if(tempSum<0)
	    		 {
	    			i--;
	    		 }
	    		 else
	    		 {
	    			 p2--;
	    		 }
	    		 if(p2==0)
    			 {
    				 p1--;
    				 p2 = p1-1;
    			 }
			 }
    	 }
    	 if(negList.size()>1)
    	 {
    		 int p1 = negList.size()-1;
    		 int p2 = p1-1;
    		 for(int i = 0 ;i<posList.size() && p1>=0;)
    		 {
    	
    			 int tempSum = negList.get(p1) + negList.get(p2) + posList.get(i);
    			 if(tempSum == 0)
    			 {
    				 addToResult(negList.get(p1),negList.get(p2), posList.get(i),result);
    				 p1--;
    				 p2 = p1-1;
    				 i++;
    			 }
    			 else if(tempSum>0)
    			 {
    				i++;
    			 }
    			 else
    			 {
    				 p2--;
    			 }
    			 if(p2==0)
    			 {
    				 p1--;
    				 p2 = p1-1;
    			 }
    		 }
    	 }
    	 return result;
        
    }
    public void addToResult(int i, int j, int k,  ArrayList<ArrayList<Integer>> result)
    {
    	 ArrayList<Integer> list = new ArrayList<Integer>();
		 list.add(i);
		 list.add(j);
		 list.add(k);
		 if(!result.contains(list))
			 result.add(list);
    }
    public static void main(String[]args)
    {
    	String[]words={"What","must","be","shall","be."};
    	LeetCodeSolutions5 solution = new LeetCodeSolutions5();
    	ArrayList<String> res = solution.fullJustify(words, 12);
    	System.out.println(Arrays.toString(res.toArray()));
    	System.out.print(solution.intToRoman(99));
    	int[]num={-1,0,1,2, -1,-4};
    	solution.threeSum(num);
    }
     

}
