package ctci;

//Question 1.1 - Cracking the Coding Interview

public class Find_Unique_Character {
	static boolean isunique(String s) {
		if(s.length()>26) {
			return false;
		}
		
		int checker = 0;
		
		for(int i=0;i<s.length();i++) {
			int val = s.charAt(i)-'a';
			if((checker & 1<<val)>0) {
				return false;
			}
			checker |= 1<<val;
		}
		return true;
	}
	
	
	public static void main(String[] args) {
		
		String s = "hoardd";
		boolean b = isunique(s);
		System.out.println(b);
		
	}
}
