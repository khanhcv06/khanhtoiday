import java.util.Scanner;

public class BTVNT3 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Bài1:Thống kê số nguyên");
        bai1();

        System.out.println("\nBài2: Tính biểu thức với Math");
        bai2();

        System.out.println("\nBài3: Kiểm tra chuỗi đối xứng (Palindrome)");
        bai3();

        System.out.println("\nBài4: Vòng lặp và phương thức (Fibonacci)");
        bai4();

        System.out.println("\nBài 5: Ma trận - Tổng 2 đường chéo");
        bai5();

        System.out.println("\nKết thúc tất cả các bài");
    }

    static void bai1() {
        System.out.print("Nhập số phần tử: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Nhập các số nguyên:");
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

        int tongLe = 0, demNT = 0;
        System.out.print("Số chẵn: ");
        for (int x : arr) {
            if (x % 2 == 0) System.out.print(x + " ");
            else tongLe += x;
            if (isPrime(x)) demNT++;
        }
        System.out.println("\nTổng số lẻ: " + tongLe);
        System.out.println("Số lượng số nguyên tố: " + demNT);
    }

    static boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    static void bai2() {
        System.out.print("Nhập a: ");
        double a = sc.nextDouble();
        System.out.print("Nhập b: ");
        double b = sc.nextDouble();
        System.out.print("Nhập x: ");
        double x = sc.nextDouble();

        double tu = Math.sqrt(Math.abs(a * a + b * b - x));
        double mau = 2 * a * b;

        if (mau != 0)
            System.out.printf("Giá trị f = %.4f\n", tu / mau);
        else
            System.out.println("Mẫu bằng 0, không thể tính được.");
    }

    static void bai3() {
        sc.nextLine(); // clear buffer
        System.out.print("Nhập chuỗi: ");
        String s = sc.nextLine();

        boolean isPalin = true;
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                isPalin = false;
                break;
            }
        }

        if (isPalin)
            System.out.println("Chuỗi là Palindrome.");
        else
            System.out.println("Không phải Palindrome.");
    }

    static void bai4() {
        System.out.print("Nhập n: ");
        int n = sc.nextInt();
        System.out.print("Dãy Fibonacci: ");
        for (int i = 0; i < n; i++) {
            System.out.print(fibo(i) + " ");
        }
        System.out.println();
    }

    static int fibo(int n) {
        if (n <= 1) return n;
        return fibo(n - 1) + fibo(n - 2);
    }

    static void bai5() {
        System.out.print("Nhập kích thước ma trận vuông n: ");
        int n = sc.nextInt();
        int[][] a = new int[n][n];
        System.out.println("Nhập ma trận:");
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                a[i][j] = sc.nextInt();

        int tongChinh = 0, tongPhu = 0;
        for (int i = 0; i < n; i++) {
            tongChinh += a[i][i];
            tongPhu += a[i][n - 1 - i];
        }

        System.out.println("Tổng đường chéo chính: " + tongChinh);
        System.out.println("Tổng đường chéo phụ: " + tongPhu);
    }
}
