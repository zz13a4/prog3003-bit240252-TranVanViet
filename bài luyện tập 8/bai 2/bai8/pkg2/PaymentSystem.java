import java.util.Scanner;

public class PaymentSystem {
    
    // 1. INTERFACE PAYMENT
    interface Payment {
        void processPayment(double amount);
    }
    
    // 2. CREDIT CARD PAYMENT
    static class CreditCardPayment implements Payment {
        @Override
        public void processPayment(double amount) {
            System.out.println("\n=== XỬ LÝ THANH TOÁN BẰNG CREDIT CARD ===");
            System.out.println("Số tiền: $" + amount);
            System.out.println("Kiểm tra thông tin thẻ tín dụng...");
            System.out.println("Xác thực giao dịch...");
            System.out.println("Kết nối cổng thanh toán Visa/Mastercard...");
            System.out.println("Giao dịch thành công! Mã giao dịch: CC" + System.currentTimeMillis());
            System.out.println("Vui lòng ký xác nhận");
        }
    }
    
    // 3. PAYPAL PAYMENT
    static class PayPalPayment implements Payment {
        @Override
        public void processPayment(double amount) {
            System.out.println("\n=== XỬ LÝ THANH TOÁN BẰNG PAYPAL ===");
            System.out.println("Số tiền: $" + amount);
            System.out.println("Chuyển hướng đến trang đăng nhập PayPal...");
            System.out.println("Xác thực tài khoản PayPal...");
            System.out.println("Xác nhận giao dịch qua email/SMS...");
            System.out.println("Giao dịch thành công! Mã giao dịch: PP" + System.currentTimeMillis());
        }
    }
    
    // 4. CASH PAYMENT
    static class CashPayment implements Payment {
        @Override
        public void processPayment(double amount) {
            System.out.println("\n=== XỬ LÝ THANH TOÁN BẰNG TIỀN MẶT ===");
            System.out.println("Số tiền: $" + amount);
            System.out.println("Kiểm tra tiền mặt...");
            System.out.println("Đếm tiền và kiểm tra tiền giả...");
            System.out.println("Nhập số tiền khách đưa: $" + (amount + 50));
            System.out.println("Tiền thừa: $50");
            System.out.println("In hóa đơn cho khách");
            System.out.println("Giao dịch hoàn tất!");
        }
    }
    
    // 5. ABSTRACT FACTORY
    abstract static class PaymentFactory {
        public abstract Payment createPayment();
        
        public void processTransaction(double amount) {
            Payment payment = createPayment();
            payment.processPayment(amount);
        }
    }
    
    // 6. CREDIT CARD FACTORY
    static class CreditCardFactory extends PaymentFactory {
        @Override
        public Payment createPayment() {
            return new CreditCardPayment();
        }
    }
    
    // 7. PAYPAL FACTORY
    static class PayPalFactory extends PaymentFactory {
        @Override
        public Payment createPayment() {
            return new PayPalPayment();
        }
    }
    
    // 8. CASH FACTORY
    static class CashFactory extends PaymentFactory {
        @Override
        public Payment createPayment() {
            return new CashPayment();
        }
    }
    
    // 9. MAIN METHOD
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PaymentFactory factory = null;
        
        System.out.println("==========================================");
        System.out.println("   HỆ THỐNG THANH TOÁN - FACTORY METHOD");
        System.out.println("==========================================");
        
        // Tạo sẵn một vài giao dịch mẫu
        System.out.println("\n=== CÁC GIAO DỊCH MẪU ===");
        
        // Giao dịch 1: Credit Card
        factory = new CreditCardFactory();
        System.out.println("\n[GIAO DỊCH 1] Thanh toán Credit Card $150.50");
        factory.processTransaction(150.50);
        
        // Giao dịch 2: PayPal
        factory = new PayPalFactory();
        System.out.println("\n[GIAO DỊCH 2] Thanh toán PayPal $75.25");
        factory.processTransaction(75.25);
        
        // Giao dịch 3: Cash
        factory = new CashFactory();
        System.out.println("\n[GIAO DỊCH 3] Thanh toán tiền mặt $45.30");
        factory.processTransaction(45.30);
        
        // Phần tương tác với người dùng
        System.out.println("   PHẦN TƯƠNG TÁC VỚI NGƯỜI DÙNG");

        while (true) {
            System.out.println("\nChọn phương thức thanh toán:");
            System.out.println("1. Credit Card (Thẻ tín dụng)");
            System.out.println("2. PayPal");
            System.out.println("3. Cash (Tiền mặt)");
            System.out.println("4. Thoát");
            System.out.print("Lựa chọn của bạn: ");
            
            int choice = scanner.nextInt();
            
            if (choice == 4) {
                System.out.println("\nCảm ơn bạn đã sử dụng dịch vụ!");
                break;
            }
            
            switch (choice) {
                case 1:
                    factory = new CreditCardFactory();
                    System.out.println("\n[Bạn đã chọn thanh toán bằng Credit Card]");
                    break;
                case 2:
                    factory = new PayPalFactory();
                    System.out.println("\n[Bạn đã chọn thanh toán bằng PayPal]");
                    break;
                case 3:
                    factory = new CashFactory();
                    System.out.println("\n[Bạn đã chọn thanh toán bằng tiền mặt]");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
                    continue;
            }
            
            System.out.print("Nhập số tiền cần thanh toán: $");
            double amount = scanner.nextDouble();
            
            System.out.println("\nĐANG XỬ LÝ GIAO DỊCH...");
            factory.processTransaction(amount);
            
            System.out.println("\n-------------------------------");
        }
        
        scanner.close();
    }
}