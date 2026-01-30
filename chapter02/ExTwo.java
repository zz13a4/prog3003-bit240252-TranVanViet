interface Notification {
    void notifyUser(String message);
}

class SMSNotification implements Notification {
    @Override
    public void notifyUser(String message) {
        System.out.println("SMS: " + message);
    }
}

class EmailNotification implements Notification {
    @Override
    public void notifyUser(String message) {
        System.out.println("Email: " + message);
    }
}

class PushNotification implements Notification {
    @Override
    public void notifyUser(String message) {
        System.out.println("Push Notification: " + message);
    }
}

class NotificationFactory {
    public Notification createNotification(String channel) {
        if (channel == null || channel.isEmpty()) {
            return null;
        }
        
        switch (channel.toLowerCase()) {
            case "sms":
                return new SMSNotification();
            case "email":
                return new EmailNotification();
            case "push":
                return new PushNotification();
            default:
                throw new IllegalArgumentException("Unknown channel: " + channel);
        }
    }
}

public class NotificationSystem {
    public static void main(String[] args) {
        NotificationFactory factory = new NotificationFactory();
        System.out.println("=== HỆ THỐNG THÔNG BÁO ===");
        String[] messages = {
            "Đơn hàng đã được xác nhận",
            "Có 3 sản phẩm mới bạn có thể quan tâm",
            "Nhận ưu đãi 20% cho lần mua tiếp theo"
        };
        
        String[] channels = {"sms", "email", "push"};
        
        for (int i = 0; i < channels.length; i++) {
            Notification notification = factory.createNotification(channels[i]);
            notification.notifyUser(messages[i]);
        }
        
        System.out.println("\n=== TEST LỖI ===");
        try {
            factory.createNotification("telegram");
        } catch (IllegalArgumentException e) {
            System.out.println("Thất bại " + e.getMessage());
        }
    }
}