public class Notification {
    private MessageService messageService;
    public Notification() {
        System.out.println("Đã tạo đối tượng Notification");
    }
    public void setMessageService(MessageService messageService) {
        this.messageService = messageService;
        System.out.println("Đã inject MessageService vào Notification");
    }
    public void sendNotification(String message) {
        // Kiểm tra xem đã inject service chưa
        if (messageService != null) {
            System.out.println("\n🔄 Đang xử lý gửi thông báo...");
            messageService.sendMessage(message);
        } else {
            System.out.println("❌ LỖI: Chưa thiết lập dịch vụ gửi tin nhắn!");
            System.out.println("Vui lòng gọi setMessageService() trước khi gửi thông báo.");
        }
    }
    public MessageService getMessageService() {
        return messageService;
    }
}