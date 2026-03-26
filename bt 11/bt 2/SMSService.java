public class SMSService implements MessageService {
    
    @Override
    public void sendMessage(String message) {
        System.out.println("========================================");
        System.out.println("📱 ĐANG GỬI SMS 📱");
        System.out.println("========================================");
        System.out.println("Nội dung: " + message);
        System.out.println("Số điện thoại: +84 123 456 789");
        System.out.println("Trạng thái: Gửi thành công!");
        System.out.println("========================================");
    }
}