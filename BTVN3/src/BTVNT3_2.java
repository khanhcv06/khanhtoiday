import java.util.Scanner;
import java.util.Random;

public class BTVNT3_2 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Bài1: Tính diện tích");
        bai1();

        System.out.println("\nBài2: Chuỗi Palindrome");
        bai2();

        System.out.println("\nBài3: Trắc nghiệm phép toán");
        bai3();

        System.out.println("\nKết thúc");
    }

    // Bài 1: Tính diện tích
    static void bai1() {
        System.out.print("Nhập loại hình (Square, Triangle, Circle): ");
        String shape = sc.nextLine().trim().toLowerCase();

        switch (shape) {
            case "square" -> {
                System.out.print("Nhập cạnh a: ");
                double a = sc.nextDouble();
                System.out.println("Diện tích hình vuông = " + (a * a));
            }
            case "triangle" -> {
                System.out.print("Nhập đáy: ");
                double day = sc.nextDouble();
                System.out.print("Nhập chiều cao: ");
                double h = sc.nextDouble();
                System.out.println("Diện tích tam giác = " + (day * h / 2));
            }
            case "circle" -> {
                System.out.print("Nhập bán kính: ");
                double r = sc.nextDouble();
                System.out.println("Diện tích hình tròn = " + (Math.PI * r * r));
            }
            default -> System.out.println("Hình dạng không hợp lệ.");
        }
        sc.nextLine(); // clear buffer
    }

    // Bài 2: Kiểm tra chuỗi Palindrome
    static void bai2() {
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
            System.out.println("=> Chuỗi là đối xứng (Palindrome)");
        else
            System.out.println("=> Chuỗi KHÔNG phải đối xứng.");
    }

    // Bài 3: Trắc nghiệm ngẫu nhiên
    static void bai3() {
        Random rd = new Random();
        int a = rd.nextInt(101);
        int b = rd.nextInt(101);
        char[] ops = {'+', '-', '*', '/'};
        char op = ops[rd.nextInt(4)];

        double ketquaThucTe = switch (op) {
            case '+' -> a + b;
            case '-' -> a - b;
            case '*' -> a * b;
            case '/' -> (b != 0) ? (double) a / b : Double.NaN;
            default -> 0;
        };

        // In phép tính
        System.out.printf("Phép toán của bạn là: %d %c %d = ?\n", a, op, b);
        System.out.print("Dự đoán kết quả là đúng hay sai? (dung/sai): ");
        String doan = sc.nextLine().trim().toLowerCase();

        // Kiểm tra
        boolean isTrue = ketquaThucTe == (int) ketquaThucTe;
        if (op == '/' && b == 0) {
            System.out.println("Không thể chia cho 0.");
            return;
        }

        System.out.printf("Kết quả thật: %.2f\n", ketquaThucTe);
        System.out.print("Bạn dự đoán: ");
        if ((isTrue && doan.equals("dung")) || (!isTrue && doan.equals("sai"))) {
            System.out.println("Đúng rồi!");
        } else {
            System.out.println("Bạn đoán sai!");
        }
    }
}
