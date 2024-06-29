class Solution {

    //Recursion used
    
    public int fib(int n) {
        //Base Case
        if(n == 0 || n==1){
            return n;
        }
        int fbn1 = fib(n-1);
        int fbn2 = fib(n-2);

        int fibnumber = fbn1 + fbn2;
        return fibnumber;
    }
}
