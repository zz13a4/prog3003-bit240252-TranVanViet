public class Main {
    
    public static void main(String[] args) {
        
        System.out.println("═══════════════════════════════════════");
        System.out.println("   DEMO SETTER INJECTION");
        System.out.println("═══════════════════════════════════════\n");
        
        // ========== PHẦN 1: Demo với EmailService ==========
        System.out.println("🔷 PHẦN 1: GỬI EMAIL 🔷");
        System.out.println("----------------------------------------");
        
        // Bước 1: Tạo đối tượng Notification
        Notification notification = new Notification();
        
        // Bước 2: Tạo đối tượng EmailService
        EmailService emailService = new EmailService();
        
        // Bước 3: SETTER INJECTION - Inject EmailService vào Notification
        notification.setMessageService(emailService);
        
        // Bước 4: Gửi thông báo qua Email
        notification.sendNotification("Chào bạn! Đây là thông báo quan trọng từ hệ thống.");
        
        // ========== PHẦN 2: Demo với SMSService ==========
        System.out.println("\n\n🔷 PHẦN 2: GỬI SMS 🔷");
        System.out.println("----------------------------------------");
        
        // Tạo đối tượng Notification mới (có thể dùng lại object cũ)
        Notification notification2 = new Notification();
        
        // Tạo đối tượng SMSService
        SMSService smsService = new SMSService();
        
        // SETTER INJECTION - Inject SMSService vào Notification
        notification2.setMessageService(smsService);
        
        // Gửi thông báo qua SMS
        notification2.sendNotification("Mã xác thực của bạn là: 123456");
        
        // ========== PHẦN 3: Demo lỗi khi chưa inject ==========
        System.out.println("\n\n🔷 PHẦN 3: DEMO LỖI (Chưa inject service) 🔷");
        System.out.println("----------------------------------------");
        
        // Tạo Notification nhưng không inject service
        Notification notification3 = new Notification();
        
        // Thử gửi thông báo mà không set service
        notification3.sendNotification("Thông báo này sẽ không được gửi!");
        
        // ========== PHẦN 4: Thay đổi service trong runtime ==========
        System.out.println("\n\n🔷 PHẦN 4: THAY ĐỔI SERVICE TRONG RUNTIME 🔷");
        System.out.println("----------------------------------------");
        
        // Tạo một notification
        Notification flexibleNotification = new Notification();
        
        // Lúc đầu dùng Email
        System.out.println("\n👉 Đang dùng EmailService:");
        flexibleNotification.setMessageService(new EmailService());
        flexibleNotification.sendNotification("Thông báo 1");
        
        // Sau đó đổi sang SMS (thay đổi dependency trong runtime)
        System.out.println("\n👉 Đổi sang SMSService:");
        flexibleNotification.setMessageService(new SMSService());
        flexibleNotification.sendNotification("Thông báo 2");
        
        System.out.println("\n═══════════════════════════════════════");
        System.out.println("   KẾT THÚC DEMO");
        System.out.println("═══════════════════════════════════════");
    }
}