
public class MatchingExample {
	public String reverseString(String s)
	{
		if (s.isEmpty()) return ""; 
		if(s.length() == 1) return s; 

		char cbegin = s.charAt(0); 
		char cend = s.charAt(s.length()-1); 
		return cend + reverseString(s.substring(0, s.length()-1)) ; 
	}
    public static void main(String[] args)
    {
    	String string="abcd";
    	String smallString = string.substring(0,4);
    	System.out.println(smallString);
    	MatchingExample match =  new MatchingExample();
    	String reversed = match.reverseString("this is the test");
    	System.out.println(reversed);
    	System.out.println( match.reverseString(reversed));
    }
}
