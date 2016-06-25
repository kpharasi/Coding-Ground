package ctci;

//Question 1.2 - Cracking the Coding Interview

import java.util.HashMap;
import java.util.Map;

public class Check_Permutation {
	public static boolean perm(String a, String b) {
		Map<Character,Integer> s = new HashMap<Character,Integer>();
		
		if(a.length()!=b.length()) {
			return false;
		}
		
		for(int i=0;i<a.length();i++) {
			if(s.containsKey(a.charAt(i))){
				s.put(a.charAt(i), s.get(a.charAt(i))+1);
			} else {
				s.put(a.charAt(i),1);
			}
		}
		
		for(int i=0;i<b.length();i++) {
			if(s.containsKey(b.charAt(i))){
				if(s.get(b.charAt(i))==0) {
					return false;
				}
				s.put(b.charAt(i), s.get(b.charAt(i))-1);
			} else {
				return false;
			}
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a = "abc nm";
		String b = "bacnm";
		boolean res = perm(a,b);
		System.out.println(res);
	}
}
