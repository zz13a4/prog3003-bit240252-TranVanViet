package bt8;
import java.util.ArrayList;
import java.util.Scanner;

public class QuanLySinhVien {
    
    // Lớp SinhVien ở bên trong
    static class SinhVien {
        String mssv;
        String ten;
        double gpa;
        
        public SinhVien(String mssv, String ten, double gpa) {
            this.mssv = mssv;
            this.ten = ten;
            this.gpa = gpa;
        }
        
        public String toString() {
            return "MSSV: " + mssv + " | Tên: " + ten + " | GPA: " + gpa;
        }
    }
    
    // Danh sách sinh viên
    static ArrayList<SinhVien> danhSachSV = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    
    // Thêm sinh viên
    static void themSinhVien() {
        System.out.println("\n=== THÊM SINH VIÊN ===");
        
        System.out.print("Nhập MSSV: ");
        String mssv = sc.nextLine();
        
        // Kiểm tra MSSV đã tồn tại chưa
        for (SinhVien sv : danhSachSV) {
            if (sv.mssv.equals(mssv)) {
                System.out.println("MSSV đã tồn tại!");
                return;
            }
        }
        
        System.out.print("Nhập tên: ");
        String ten = sc.nextLine();
        
        System.out.print("Nhập điểm GPA: ");
        double gpa = sc.nextDouble();
        sc.nextLine(); // Xóa bộ nhớ đệm
        
        SinhVien sv = new SinhVien(mssv, ten, gpa);
        danhSachSV.add(sv);
        System.out.println("Thêm thành công!");
    }
    
    // Hiển thị danh sách
    static void hienThiDanhSach() {
        System.out.println("\n=== DANH SÁCH SINH VIÊN ===");
        if (danhSachSV.isEmpty()) {
            System.out.println("Chưa có sinh viên nào!");
        } else {
            for (int i = 0; i < danhSachSV.size(); i++) {
                System.out.println((i+1) + ". " + danhSachSV.get(i));
            }
        }
    }
    
    // Tìm kiếm theo tên
    static void timKiemTheoTen() {
        System.out.println("\n=== TÌM KIẾM SINH VIÊN ===");
        System.out.print("Nhập tên cần tìm: ");
        String tenTim = sc.nextLine().toLowerCase();
        
        boolean found = false;
        for (SinhVien sv : danhSachSV) {
            if (sv.ten.toLowerCase().contains(tenTim)) {
                System.out.println(sv);
                found = true;
            }
        }
        
        if (!found) {
            System.out.println("Không tìm thấy sinh viên nào!");
        }
    }
    
    // Xóa theo MSSV
    static void xoaTheoMSSV() {
        System.out.println("\n=== XÓA SINH VIÊN ===");
        System.out.print("Nhập MSSV cần xóa: ");
        String mssvXoa = sc.nextLine();
        
        for (int i = 0; i < danhSachSV.size(); i++) {
            if (danhSachSV.get(i).mssv.equals(mssvXoa)) {
                danhSachSV.remove(i);
                System.out.println("Đã xóa sinh viên có MSSV: " + mssvXoa);
                return;
            }
        }
        
        System.out.println("Không tìm thấy MSSV: " + mssvXoa);
    }
    
    // Hiển thị menu
    static void hienThiMenu() {
        System.out.println("\n=== MENU QUẢN LÝ SINH VIÊN ===");
        System.out.println("1. Thêm sinh viên");
        System.out.println("2. Hiển thị danh sách");
        System.out.println("3. Tìm kiếm theo tên");
        System.out.println("4. Xóa theo MSSV");
        System.out.println("5. Thoát");
        System.out.print("Chọn chức năng (1-5): ");
    }
    
    // Main
    public static void main(String[] args) {
        int chon;
        
        do {
            hienThiMenu();
            chon = sc.nextInt();
            sc.nextLine(); // Xóa bộ nhớ đệm
            
            switch(chon) {
                case 1:
                    themSinhVien();
                    break;
                case 2:
                    hienThiDanhSach();
                    break;
                case 3:
                    timKiemTheoTen();
                    break;
                case 4:
                    xoaTheoMSSV();
                    break;
                case 5:
                    System.out.println("Tạm biệt!");
                    break;
                default:
                    System.out.println("Chọn sai, vui lòng chọn lại!");
            }
            
        } while(chon != 5);
        
        sc.close();
    }
}