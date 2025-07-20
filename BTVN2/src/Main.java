import java.util.Scanner;
import java.util.Arrays;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("=== Bài 1: Nhập, Xuất, Kiểu Dữ liệu ===");
        bai1();

        System.out.println("\n=== Bài 2: Biến, Quy tắc đặt tên ===");
        bai2();

        System.out.println("\n=== Bài 3: Phép toán và Toán tử ===");
        bai3();

        System.out.println("\n=== Bài 4: Mảng ===");
        bai4();

        System.out.println("\n=== Bài 5: Vòng lặp ===");
        bai5();

        System.out.println("\n=== Bài 6: Bài tập tổng hợp ===");
        bai6();

        System.out.println("\n=== Kết thúc tất cả các bài ===");
    }

    static void bai1() {
        System.out.print("Nhập tên: ");
        String ten = sc.nextLine();
        System.out.print("Nhập tuổi: ");
        int tuoi = sc.nextInt();
        System.out.print("Nhập chiều cao (m): ");
        double cao = sc.nextDouble();
        sc.nextLine(); // clear buffer
        System.out.printf("Tên: %s Tuổi: %d Chiều cao: %.2f mét\n", ten, tuoi, cao);
    }

    static void bai2() {
        String ten;
        int tuoi, lop;
        double gpa;
        System.out.println("Biến đã được khai báo: ten, tuoi, lop, gpa");
    }

    static void bai3() {
        System.out.print("Nhập a: ");
        int a = sc.nextInt();
        System.out.print("Nhập b: ");
        int b = sc.nextInt();
        System.out.println("Tổng: " + (a + b));
        System.out.println("Hiệu: " + (a - b));
        System.out.println("Tích: " + (a * b));
        if (b != 0) {
            System.out.println("Thương: " + (a / b));
            System.out.println("Chia dư: " + (a % b));
        } else {
            System.out.println("Không thể chia cho 0");
        }
    }

    static void bai4() {
        int[] arr = new int[5];
        System.out.println("Nhập 5 số nguyên:");
        for (int i = 0; i < 5; i++) {
            System.out.print("Phần tử " + (i + 1) + ": ");
            arr[i] = sc.nextInt();
        }
        System.out.print("Các số chẵn: ");
        for (int num : arr) {
            if (num % 2 == 0) System.out.print(num + " ");
        }
        int tong = Arrays.stream(arr).sum();
        int max = Arrays.stream(arr).max().getAsInt();
        System.out.println("\nTổng: " + tong);
        System.out.println("Giá trị lớn nhất: " + max);
    }

    static void bai5() {
        System.out.println("Bảng cửu chương 5:");
        for (int i = 1; i <= 10; i++) {
            System.out.printf("5 x %d = %d\n", i, 5 * i);
        }
    }

    static void bai6() {
        System.out.print("Nhập số lượng sinh viên: ");
        int n = sc.nextInt();
        sc.nextLine();
        String[] ten = new String[n];
        int[] tuoi = new int[n];
        double[] diem = new double[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Nhập thông tin sinh viên thứ " + (i + 1));
            System.out.print("Tên: ");
            ten[i] = sc.nextLine();
            System.out.print("Tuổi: ");
            tuoi[i] = sc.nextInt();
            System.out.print("Điểm TB: ");
            diem[i] = sc.nextDouble();
            sc.nextLine();
        }

        int indexMax = 0;
        for (int i = 1; i < n; i++) {
            if (diem[i] > diem[indexMax]) {
                indexMax = i;
            }
        }

        System.out.println("\nSinh viên có điểm cao nhất:");
        System.out.printf("Tên: %s, Tuổi: %d, Điểm TB: %.2f\n", ten[indexMax], tuoi[indexMax], diem[indexMax]);
    }
}