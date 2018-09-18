public class Main {

    public static void main(String[] args) {
        int n = 43;
        int[] memoizedArray = new int[n + 1];
        long start = System.currentTimeMillis();
        System.out.println(fibMem(n, memoizedArray));   //fibonacci memoization
        long end = System.currentTimeMillis();
        System.out.println("Time: " + (end - start) + "ms");

        start = System.currentTimeMillis();
        System.out.println(fibTab(n));  // fibonacci Tabulated
        end = System.currentTimeMillis();
        System.out.println("Time: " + (end - start) + "ms");
    }

    // ordinary and inefficient
    public static int fib(int num) {
        if (num == 0 || num == 1) {
            return num;
        }

        int fibNM1 = fib(num - 1);
        int fibNM2 = fib(num - 2);
        int fibN = fibNM1 + fibNM2;

        return fibN;
    }

    // memoized way of solving
    public static int fibMem(int num, int[] memoizedArr) {
        if (num == 0 || num == 1) {
            return num;
        }

        if (memoizedArr[num] != 0) {
            return memoizedArr[num];
        }

        int fibNM1 = fibMem(num - 1, memoizedArr);
        int fibNM2 = fibMem(num - 2, memoizedArr);

        int fibN = fibNM1 + fibNM2;

        memoizedArr[num] = fibN;
        return fibN;
    }

    public static int fibTab(int num) {
        int[] f = new int[num + 1];
        f[0] = 0;
        f[1] = 1;

        for (int x = 2; x <= num; x++) {
            f[x] = f[x - 1] + f[x - 2];
        }

        return f[num];
    }
}
