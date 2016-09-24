public class Solution {

    public int divide(int dividend, int divisor) {
        
        boolean neg = false;
        
        if((dividend<0 && divisor>0) || (divisor<0 && dividend>0)) {
            neg = true;
        }
        
        long aDividend = Math.abs((long)dividend);
        long aDivisor = Math.abs((long)divisor);
        
        if((aDividend==0) || (aDividend < aDivisor))
            return 0;
        
        if(aDivisor == 0)
            return Integer.MAX_VALUE;
        
        long sum = divide_helper(aDividend, aDivisor);
 
        if(sum > Integer.MAX_VALUE) {
            if(neg==true)
                return Integer.MIN_VALUE;
            else
                return Integer.MAX_VALUE;
        } else {
            if(neg==true)
                return (int) (-1 * sum);
            else
                return (int) sum;
        }
        
    }
    
    public static long divide_helper(long dividend, long divisor) {
        
        if(dividend < divisor)
            return 0;
        
        long sum = divisor;
        long multiple = 1;
        
        while((sum + sum) <= dividend) {
            sum += sum;
            multiple += multiple;
        }
        
        return multiple + divide_helper((dividend - sum), divisor);
    }

}