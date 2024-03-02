import java.text.DecimalFormat;

public class Main {
    public static double factorial(int n){
        if (n <= 1) return 1;
        return n * factorial(n-1);
    }

    public static double comb(int n, int k){
        return factorial(n) / (factorial(k) * factorial(n-k));
    }

    public static double eulerNumber(int n){
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
            result += Math.pow(-1, n) * eulerNumber(2*n) * Math.pow(x, 2*n) / factorial(2*n);
        }
        return result;
    }

    public static void main(String[] args) {
        double x = -1;
        int steps = 16;
        double mySec = sec(x, steps);
        double trueSec = 1/Math.cos(x);
        String formattedDouble = new DecimalFormat("#0.00").format(Math.abs(trueSec-mySec) / trueSec * 100);

        System.out.println("Моя функция: " + mySec);
        System.out.println("Истинное значение " + trueSec);
        System.out.println();
        System.out.println("Погрешность: " + formattedDouble + "%");
    }
}
