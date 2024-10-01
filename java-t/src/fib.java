class Fib{
    public static void main(String[] args){
        int n = 100;
        System.out.println(FibRecursive(10));
        System.out.println(FibTD(n, new int[n+1]));
        System.out.println(FibBD(100000));
    }

    // recursive
    public static int FibRecursive(int n){
       if(n==0 || n==1){
        return n;
       }
       int fib_n = FibRecursive(n-1)+FibRecursive(n-2);
       return fib_n;
    }

    // top down
    public static int FibTD(int n, int[] stg){
        if(n==0 || n==1){
            return n;
           }

        if(stg[n]!=0){
            return stg[n];
        }
        int fib_n = FibTD(n-1, stg)+FibTD(n-2, stg);
        stg[n] = fib_n;
       return fib_n;
    }

    // bottom up
    public static int FibBD(int n){
        int[] fib = new int[n+1];
        fib[0]=0;
        fib[1]=1;
        for(int i=2;i<fib.length;i++){
            fib[i] = fib[i-1] + fib[i-2];
        }
        return fib[n];
    }
}