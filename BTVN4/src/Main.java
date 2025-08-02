import java.util.*;

class Student {
    private String ten;
    private int namSinh;
    private String diaChi;
    private double diemTX1;
    private double diemTX2;
    private double diemKTHP;

    public Student(String ten, int namSinh, String diaChi, double diemTX1, double diemTX2, double diemKTHP) {
        this.ten = ten;
        this.namSinh = namSinh;
        this.diaChi = diaChi;
        this.diemTX1 = diemTX1;
        this.diemTX2 = diemTX2;
        this.diemKTHP = diemKTHP;
    }

    public int getTuoi() {
        return Calendar.getInstance().get(Calendar.YEAR) - namSinh;
    }

    public double getDiemGPA() {
        return diemTX1 * 0.2 + diemTX2 * 0.3 + diemKTHP * 0.5;
    }

    public void inThongTin() {
        System.out.printf("%-15s %-6d %-15s %-8.2f %-8.2f %-10.2f %-10.2f %-6d\n",
                ten, namSinh, diaChi, diemTX1, diemTX2, diemKTHP, getDiemGPA(), getTuoi());
    }

    public String getTen() {
        return ten;
    }

    public void setThongTin(String ten, int namSinh, String diaChi, double diemTX1, double diemTX2, double diemKTHP) {
        this.ten = ten;
        this.namSinh = namSinh;
        this.diaChi = diaChi;
        this.diemTX1 = diemTX1;
        this.diemTX2 = diemTX2;
        this.diemKTHP = diemKTHP;
    }
}

public class Main {
    static ArrayList<Student> danhSachSV = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        danhSachSV.add(new Student("An", 2003, "HN", 7, 8, 9));
        danhSachSV.add(new Student("Bình", 2002, "TPHCM", 6.5, 7.5, 8));
        danhSachSV.add(new Student("Cường", 2001, "ĐN", 5, 6, 7));
        danhSachSV.add(new Student("Dũng", 2000, "HN", 9, 9, 10));
        danhSachSV.add(new Student("E", 1999, "HP", 8, 7, 9));

        themSV();
        suaSV();
        sapXepTheoTuoi();
        sapXepTheoGPA();
        sapXepTheoTietNghi();
        xoaSinhVien();
        inDanhSach();
    }

    static void themSV() {
        System.out.println("Thêm sinh viên mới:");
        System.out.print("Tên: ");
        String ten = sc.nextLine();
        System.out.print("Năm sinh: ");
        int ns = Integer.parseInt(sc.nextLine());
        System.out.print("Địa chỉ: ");
        String dc = sc.nextLine();
        System.out.print("Điểm TX1: ");
        double tx1 = Double.parseDouble(sc.nextLine());
        System.out.print("Điểm TX2: ");
        double tx2 = Double.parseDouble(sc.nextLine());
        System.out.print("Điểm KTHP: ");
        double kt = Double.parseDouble(sc.nextLine());
        danhSachSV.add(new Student(ten, ns, dc, tx1, tx2, kt));
    }
    static void suaSV() {
        System.out.println("Sửa thông tin sinh viên:");
        System.out.print("Nhập tên sinh viên cần sửa: ");
        String ten = sc.nextLine();
        for (Student sv : danhSachSV) {
            if (sv.getTen().equalsIgnoreCase(ten)) {
                System.out.print("Tên mới: ");
                String newTen = sc.nextLine();
                System.out.print("Năm sinh mới: ");
                int ns = Integer.parseInt(sc.nextLine());
                System.out.print("Địa chỉ mới: ");
                String dc = sc.nextLine();
                System.out.print("Điểm TX1: ");
                double tx1 = Double.parseDouble(sc.nextLine());
                System.out.print("Điểm TX2: ");
                double tx2 = Double.parseDouble(sc.nextLine());
                System.out.print("Điểm KTHP: ");
                double kt = Double.parseDouble(sc.nextLine());
                sv.setThongTin(newTen, ns, dc, tx1, tx2, kt);
                return;
            }
        }
    }
    static void sapXepTheoTuoi() {
        danhSachSV.sort(Comparator.comparingInt(Student::getTuoi).reversed());
        System.out.println("Danh sách theo tuổi giảm dần:");
        inDanhSach();
    }
    static void sapXepTheoGPA() {
        danhSachSV.sort(Comparator.comparingDouble(Student::getDiemGPA).reversed());
        System.out.println("Danh sách theo GPA giảm dần:");
        inDanhSach();
    }
    static void sapXepTheoTietNghi() {
        danhSachSV.sort(Comparator.comparingDouble(Student::getDiemGPA));
        System.out.println("Danh sách theo tiết nghỉ (GPA thấp nghỉ nhiều):");
        inDanhSach();
    }
    static void inDanhSach() {
        System.out.printf("%-15s %-6s %-15s %-8s %-8s %-10s %-10s %-6s\n",
                "Tên", "Năm", "Địa chỉ", "TX1", "TX2", "KTHP", "GPA", "Tuổi");
        for (Student sv : danhSachSV)
            sv.inThongTin();
    }
    static void xoaSinhVien() {
        System.out.println("Xóa sinh viên:");
        System.out.print("Nhập tên sinh viên cần xóa: ");
        String ten = sc.nextLine();
        danhSachSV.removeIf(sv -> sv.getTen().equalsIgnoreCase(ten));
    }
}
