// Question 1.7 - Cracking the Coding Interview

public class Rotate_Matrix {
    
    public static int[][] rotate(int [][] m) {
        
        int len = m.length;
        
        for(int i=0;i<len/2;i++) {
            int one = i;
            int two = len - 1 - i;
            for(int j=one; j<two;j++) {
                
                int offset = j - one;
                
                int temp = m[one][j];
                m[one][j] = m[two-offset][one];
                m[two-offset][one] = m[two][two-offset];
                m[two][two-offset] = m[j][two];
                m[j][two] = temp;
            }
        }
        
        return m;
        
    }
    
    public static void main(String args[]) {
        
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        int[][] res = rotate(matrix);
        
        for(int i=0;i<res.length;i++) {
            for(int j=0;j<res[0].length;j++) {
                System.out.println(res[i][j]);
            }
        }
    }
}