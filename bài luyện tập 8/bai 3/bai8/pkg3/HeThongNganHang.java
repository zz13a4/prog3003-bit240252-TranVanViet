import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class HeThongNganHang {
    
    // Lớp đại diện cho tài khoản ngân hàng
    static class TaiKhoan {
        String soTaiKhoan;
        String tenKhachHang;
        double soDu;
        String matKhau;
        
        public TaiKhoan(String soTaiKhoan, String tenKhachHang, double soDu, String matKhau) {
            this.soTaiKhoan = soTaiKhoan;
            this.tenKhachHang = tenKhachHang;
            this.soDu = soDu;
            this.matKhau = matKhau;
        }
        
        @Override
        public String toString() {
            return "TK: " + soTaiKhoan + " | KH: " + tenKhachHang + " | Số dư: $" + soDu;
        }
    }
    
    // Lớp đại diện cho giao dịch
    static class GiaoDich {
        TaiKhoan taiKhoanNguon;
        TaiKhoan taiKhoanDich;
        double soTien;
        String maGiaoDich;
        
        public GiaoDich(TaiKhoan nguon, TaiKhoan dich, double soTien) {
            this.taiKhoanNguon = nguon;
            this.taiKhoanDich = dich;
            this.soTien = soTien;
            this.maGiaoDich = "GD" + System.currentTimeMillis();
        }
    }
    
    // DANH SÁCH TÀI KHOẢN MẪU
    static TaiKhoan[] danhSachTK = {
        new TaiKhoan("123456", "Nguyen Van A", 5000, "123"),
        new TaiKhoan("789012", "Tran Thi B", 3000, "456"),
        new TaiKhoan("345678", "Le Van C", 1000, "789")
    };
    
    static Random random = new Random();
    static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        System.out.println("==========================================");
        System.out.println("   HỆ THỐNG NGÂN HÀNG - GIAO DỊCH BẤT ĐỒNG BỘ");
        System.out.println("==========================================");
        
        // Hiển thị danh sách tài khoản
        System.out.println("\n=== DANH SÁCH TÀI KHOẢN ===");
        for (TaiKhoan tk : danhSachTK) {
            System.out.println(tk);
        }
        
        // Thực hiện giao dịch
        while (true) {
            System.out.println("\n=== THỰC HIỆN GIAO DỊCH CHUYỂN TIỀN ===");
            System.out.println("1. Thực hiện giao dịch mới");
            System.out.println("2. Thoát");
            System.out.print("Chọn: ");
            
            int chon = scanner.nextInt();
            scanner.nextLine();
            
            if (chon == 2) {
                System.out.println("Cảm ơn bạn đã sử dụng dịch vụ!");
                break;
            }
            
            // Nhập thông tin giao dịch
            System.out.print("Nhập số tài khoản nguồn: ");
            String soTKChuyen = scanner.nextLine();
            
            System.out.print("Nhập mật khẩu: ");
            String matKhau = scanner.nextLine();
            
            System.out.print("Nhập số tài khoản đích: ");
            String soTKNhan = scanner.nextLine();
            
            System.out.print("Nhập số tiền cần chuyển: $");
            double soTien = scanner.nextDouble();
            scanner.nextLine();
            
            // Tìm tài khoản
            TaiKhoan tkNguon = timTaiKhoan(soTKChuyen);
            TaiKhoan tkDich = timTaiKhoan(soTKNhan);
            
            if (tkNguon == null || tkDich == null) {
                System.out.println("LỖI: Không tìm thấy tài khoản!");
                continue;
            }
            
            // Tạo đối tượng giao dịch
            GiaoDich gd = new GiaoDich(tkNguon, tkDich, soTien);
            
            System.out.println("\nĐANG XỬ LÝ GIAO DỊCH " + gd.maGiaoDich + "...");
            
            // Thực hiện giao dịch bất đồng bộ
            thucHienGiaoDich(gd, matKhau)
                .thenAccept(result -> {
                    System.out.println("\n✓ GIAO DỊCH THÀNH CÔNG!");
                    System.out.println("Mã giao dịch: " + gd.maGiaoDich);
                    System.out.println("Số tiền: $" + gd.soTien);
                    System.out.println("Từ: " + gd.taiKhoanNguon.tenKhachHang + " (" + gd.taiKhoanNguon.soTaiKhoan + ")");
                    System.out.println("Đến: " + gd.taiKhoanDich.tenKhachHang + " (" + gd.taiKhoanDich.soTaiKhoan + ")");
                    System.out.println("Số dư mới: $" + gd.taiKhoanNguon.soDu);
                })
                .exceptionally(error -> {
                    System.out.println("\n✗ GIAO DỊCH THẤT BẠI!");
                    System.out.println("Lý do: " + error.getMessage());
                    return null;
                })
                .join(); // Chờ giao dịch hoàn tất
        }
        
        scanner.close();
    }
    
    // Hàm thực hiện giao dịch bất đồng bộ
    public static CompletableFuture<String> thucHienGiaoDich(GiaoDich gd, String matKhau) {
        
        // Bước 1: Xác thực thông tin (1-3 giây)
        CompletableFuture<String> xacThuc = CompletableFuture.supplyAsync(() -> {
            sleep(random.nextInt(2000) + 1000); // 1-3 giây
            System.out.println("✓ [1/3] Đã xác thực thông tin khách hàng");
            
            // Kiểm tra mật khẩu
            if (!gd.taiKhoanNguon.matKhau.equals(matKhau)) {
                throw new RuntimeException("Mật khẩu không chính xác!");
            }
            
            return "Xác thực thành công";
        });
        
        // Bước 2: Kiểm tra số dư (sau khi xác thực thành công)
        CompletableFuture<String> kiemTraSoDu = xacThuc.thenCompose(ketQuaXacThuc -> {
            return CompletableFuture.supplyAsync(() -> {
                sleep(random.nextInt(1500) + 500); // 0.5-2 giây
                System.out.println("✓ [2/3] Đã kiểm tra số dư tài khoản");
                
                // Kiểm tra số dư
                if (gd.taiKhoanNguon.soDu < gd.soTien) {
                    throw new RuntimeException("Số dư không đủ! Số dư hiện tại: $" + gd.taiKhoanNguon.soDu);
                }
                
                return "Số dư hợp lệ";
            });
        });
        
        // Bước 3: Thực hiện chuyển tiền (sau khi kiểm tra số dư thành công)
        CompletableFuture<String> chuyenTien = kiemTraSoDu.thenCompose(ketQuaKiemTra -> {
            return CompletableFuture.supplyAsync(() -> {
                sleep(random.nextInt(2000) + 1000); // 1-3 giây
                
                // Thực hiện chuyển tiền
                gd.taiKhoanNguon.soDu -= gd.soTien;
                gd.taiKhoanDich.soDu += gd.soTien;
                
                System.out.println("✓ [3/3] Đã thực hiện chuyển tiền thành công");
                
                return "Chuyển tiền thành công";
            });
        });
        
        return chuyenTien;
    }
    
    // Hàm tìm tài khoản theo số tài khoản
    public static TaiKhoan timTaiKhoan(String soTK) {
        for (TaiKhoan tk : danhSachTK) {
            if (tk.soTaiKhoan.equals(soTK)) {
                return tk;
            }
        }
        return null;
    }
    
    // Hàm giả lập độ trễ
    public static void sleep(int milliseconds) {
        try {
            TimeUnit.MILLISECONDS.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}