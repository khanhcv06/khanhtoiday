import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BTVN5 {

    // BAI 1: Lớp Pét
    static class Pet {
        private String name;      // ten thu cung
        private double weight;    // can nang (kg)
        private String species;   // loai: "Cat" hoac "Dog"
        public Pet(String name, double weight, String species) {
            this.name = name;
            this.weight = weight;
            this.species = species;
        }
        public void printInfo() {
            System.out.println("Ten: " + name + " | Loai: " + species + " | Can nang: " + weight + " kg");
        }
        public boolean isOverweight() {
            return weight > 10.0;
        }
        public String getName() { return name; }
        public double getWeight() { return weight; }
    }
    // BAI 2: Lồng thú cưng
    static class Cage {
        private String cageCode;            // ma long
        private List<Pet> animals;          // mang cac thu trong long
        private int currentPetCount;        // so thu hien co trong long
        private final int MAX_CAPACITY;     // suc chua toi da
        public Cage(String cageCode, int maxCapacity) {
            this.cageCode = cageCode;
            this.MAX_CAPACITY = maxCapacity;
            this.animals = new ArrayList<>();
            this.currentPetCount = 0;
        }
        public void addPet(Pet pet) {
            if (currentPetCount < MAX_CAPACITY) {
                animals.add(pet);
                currentPetCount++;
                System.out.println("Da them " + pet.getName() + " vao long " + cageCode + ".");
            } else {
                System.out.println("Khong the them vao long " + cageCode + " vi da day.");
            }
        }
        public void printPetsInCage() {
            System.out.println("== Danh sach thu trong long " + cageCode + " ==");
            if (animals.isEmpty()) {
                System.out.println("Long trong.");
                return;
            }
            for (Pet p : animals) {
                p.printInfo();
            }
        }
        public List<Pet> getAnimals() { return animals; }
        public int getCurrentPetCount() { return currentPetCount; }
    }
    // Bài 3: Lớp Main
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Tao 2 long
        System.out.print("Nhap ma long 1: ");
        String code1 = sc.nextLine();
        System.out.print("Nhap suc chua long 1: ");
        int cap1 = Integer.parseInt(sc.nextLine());
        Cage c1 = new Cage(code1, cap1);
        System.out.print("Nhap ma long 2: ");
        String code2 = sc.nextLine();
        System.out.print("Nhap suc chua long 2: ");
        int cap2 = Integer.parseInt(sc.nextLine());
        Cage c2 = new Cage(code2, cap2);
        // Them thu vao long
        System.out.print("Nhap so thu muon them vao long 1: ");
        int so1 = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < so1; i++) {
            System.out.println("Nhap thu thu " + (i+1) + " cua long 1:");
            System.out.print("  Ten: ");
            String name = sc.nextLine();
            System.out.print("  Can nang: ");
            double weight = Double.parseDouble(sc.nextLine());
            System.out.print("  Loai (Cat/Dog): ");
            String species = sc.nextLine();
            c1.addPet(new Pet(name, weight, species));
        }
        System.out.print("Nhap so thu muon them vao long 2: ");
        int so2 = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < so2; i++) {
            System.out.println("Nhap thu thu " + (i+1) + " cua long 2:");
            System.out.print("  Ten: ");
            String name = sc.nextLine();
            System.out.print("  Can nang: ");
            double weight = Double.parseDouble(sc.nextLine());
            System.out.print("  Loai (Cat/Dog): ");
            String species = sc.nextLine();
            c2.addPet(new Pet(name, weight, species));
        }
        // Tong so thu
        int tongThu = c1.getCurrentPetCount() + c2.getCurrentPetCount();
        System.out.println("\nTong so thu dang nuoi: " + tongThu);
        //Thu trong tung long
        System.out.println();
        c1.printPetsInCage();
        System.out.println();
        c2.printPetsInCage();
        // Nang hon 10kg
        System.out.println("\n== Danh sach thu nang hon 10kg ==");
        List<Pet> all = new ArrayList<>();
        all.addAll(c1.getAnimals());
        all.addAll(c2.getAnimals());
        boolean coThuNangHon10 = false;
        for (Pet p : all) {
            if (p.isOverweight()) {
                p.printInfo();
                coThuNangHon10 = true;
            }
        }
        if (!coThuNangHon10) {
            System.out.println("Khong co thu nao nang hon 10kg.");
        }
        sc.close();
    }
}
