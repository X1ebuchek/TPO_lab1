public class TaylorSeries {

    public static double factorial(int n){
        if (n < 0) {
            throw new ArithmeticException("Factorial is unknown if n < 0");
        }
        if (n == 0) return 1;
        return n * factorial(n-1);
    }

    public static double comb(int n, int k){
        return factorial(n) / (factorial(k) * factorial(n-k));
    }

    public static double eulerNumber(int n){
        if (n < 0) {
            throw new ArithmeticException("Euler number is unknown if n < 0");
        }
        if (n == 0) return 1;
        double result = 0;
        for (int k = 1; k <= n; k++){
            double result_in = 0;
            for (int l = 0; l <= 2*k; l++){
                result_in += Math.pow(-1, l) * comb(2*k, l) * Math.pow(k-l, n);
            }
            result += Math.pow(-1, k) * result_in / Math.pow(2, k);
        }
        return result;
    }

    public static double sec(double x, int kol){
        double result = 0;
        for (int n = 0; n <= kol; n++){
            result += Math.pow(-1, n) * eulerNumber(2 * n) * Math.pow(x, 2 * n) / factorial(2 * n);
        }
        return result;
    }

}
