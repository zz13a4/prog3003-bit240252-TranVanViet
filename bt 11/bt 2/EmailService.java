public class EmailService implements MessageService {
    @Override
    public void sendMessage(String message) {
        System.out.println("========================================");
        System.out.println("📧 ĐANG GỬI EMAIL 📧");
        System.out.println("========================================");
        System.out.println("Nội dung: " + message);
        System.out.println("Địa chỉ người nhận: user@example.com");
        System.out.println("Trạng thái: Gửi thành công!");
        System.out.println("========================================");
    }
}