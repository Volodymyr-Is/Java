package Classes;

public class task3 {
//    int a;
//    int b;
//    int c;
//    int d;
//
//    public task3(int a, int b, int c, int d) {
//        this.a = a;
//        this.b = b;
//        this.c = c;
//        this.d = d;
//    }

    public static int max(int a, int b, int c, int d) {
        return Math.max(Math.max(a, b), Math.max(c, d));
    }

    public static int min(int a, int b, int c, int d) {
        return Math.min(Math.min(a, b), Math.min(c, d));
    }

    public static double avg(int a, int b, int c, int d) {
        return (a + b + c + d) / 4.0;
    }

    public static int fact(int n) {
        int res = 1;
        for (int i = 1; i <= n; i++) {
            res *= i;
        }
        return res;
    }
}
