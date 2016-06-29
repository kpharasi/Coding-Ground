import java.util.*;
import java.lang.*;
import java.io.*;

// Question 1.8 - Cracking the Coding Interview

class Zero_Matrix
{
	public static int[][] check_zero(int [][] matrix) {
		
		boolean firstrow = false;
		boolean firstcolumn = false;
		
		for(int i=0;i<matrix[0].length;i++) {
			if(matrix[0][i]==0) {
				firstrow = true;
				break;
			}
		}
		
		for(int i=0;i<matrix.length;i++) {
			if(matrix[i][0]==0) {
				firstcolumn = true;
				break;
			}
		}
		
		
		for(int i=1;i<matrix.length;i++) {
			for(int j=1;j<matrix[0].length;j++) {
				if(matrix[i][j]==0) {
					matrix[i][0] = 0;
					matrix[0][j] = 0;
				}
			}
		}
		
		for(int i=0;i<matrix[0].length;i++) {
			if(matrix[0][i]==0) {
				matrix = replace_col_zero(matrix,i);
			}
		}
		
		for(int i=0;i<matrix.length;i++) {
			if(matrix[i][0]==0) {
				matrix = replace_row_zero(matrix,i);
			}
		}
		
		if(firstrow) {
			matrix = replace_row_zero(matrix,0);
		}
		
		if(firstcolumn) {
			matrix = replace_col_zero(matrix,0);
		}
		
		return matrix;
	}
	
	public static int[][] replace_col_zero(int [][] matrix, int index) {
		for(int i=0;i<matrix.length;i++) {
			matrix [i][index] = 0;
		}
		return matrix;
	}
	
	public static int[][] replace_row_zero(int [][] matrix, int index) {
		for(int i=0;i<matrix[0].length;i++) {
			matrix [index][i] = 0;
		}
		return matrix;
	}
	
	public static void main (String[] args) throws java.lang.Exception
	{
		int [][]matrix = {{1,2,3,0},{4,0,6,4},{7,8,9,8}};
		int [][]res = check_zero(matrix);
		System.out.println("hi");
		for(int i=0;i<res.length;i++) {
			for(int j=0;j<res[0].length;j++) {
				System.out.print(res[i][j]);
			}
			System.out.println("hi");
		}
	}
}