// Question 344 - LeetCode

public class Reverse_String {
    
    public static String reverseString(String s) {
        int len = s.length();
        StringBuilder t = new StringBuilder();
        
        for(int i=0;i<len;i++) {
            t = t.append(s.charAt(len-i-1));
        }
        
        return t.toString();
    }
    
    public static void main(String []args){
        String s = "This is a code to reverse a string";
        String res = reverseString(s);
        
        System.out.println(res);
     }
}

