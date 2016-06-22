import java.util.*;
import java.lang.*;
import java.io.*;

// Question 1.4 - Cracking the Coding Interview

class Palindrome_Perm
{
    public static boolean pali_perm(String s) {
        
        Map<Character,Integer> m = new HashMap<Character,Integer>();
        char[] char1 = s.toCharArray();
        
        for(Character c:char1) {
            if(c!=' ') {
                if(m.containsKey(c)) {
                m.put(c,m.get(c)+1);
                } else {
                m.put(c,1);
                }
            }
        }
        
        int count = 0;
        
        for(Map.Entry<Character,Integer> e: m.entrySet()) {
                if(e.getValue()%2!=0) {
                count++;
            } 
        }
        
        if(count==0||count==1)
            return true;
        else 
            return false;
    }
    
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		String s = "tact ca";
		boolean b = pali_perm(s);
		System.out.println(b);
	}
}