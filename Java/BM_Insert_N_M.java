// Question 5.1 - Cracking the Coding Interview

import java.util.*;
import java.lang.*;
import java.io.*;

class BM_Insert_N_M
{
	public static int Insert_N_M(int N, int M, int start, int end) {
		
		int count = 0; 
		
		for(int i=start;i<=end;i++) {
				N = (N & ~(1<<i));
				if((M & (1<<count))!=0) {
					N = N | (1<<i);
				}
				count++;
		}
	
		return N;
	}
	
	public static void main (String[] args) throws java.lang.Exception
	{
		int N = 0b10000000000;
		int M = 0b10011;
		
		int start =2;
		int end =6;
		
		System.out.println(Insert_N_M(N,M,start,end));
	}
}
