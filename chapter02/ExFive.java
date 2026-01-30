interface MessageService {
    void sendMessage(String message);
    String getServiceType();
}

class EmailService implements MessageService {
    private String email;
    
    public EmailService(String email) {
        this.email = email;
    }
    @Override
    public void sendMessage(String message) {
        System.out.println(" Email to: " + email);
        System.out.println(" Message: " + message);
        System.out.println(" Status: Sent ");
    }
    @Override
    public String getServiceType() {
        return "Email";
    }
}

class SMSService implements MessageService {
    private String phone;
    
    public SMSService(String phone) {
        this.phone = phone;
    }
    @Override
    public void sendMessage(String message) {
        System.out.println(" SMS to: " + phone);
        System.out.println(" Message: " + message);
        System.out.println(" Status: Delivered");
    }
    @Override
    public String getServiceType() {
        return "SMS";
    }
}

class Notification {
    private MessageService messageService;
    public void setMessageService(MessageService service) {
        this.messageService = service;
        System.out.println("Service set to: " + service.getServiceType());
    }
    public void send(String message) {
        if (messageService == null) {
            System.out.println("Error: No message service configured!");
            return;
        }
        
        System.out.println("\n--- Sending Notification ---");
        messageService.sendMessage(message);
    }
}

public class NotificationSystem {
    public static void main(String[] args) {
        System.out.println("=== SETTER INJECTION DEMO ===\n");
        EmailService emailService = new EmailService("user@example.com");
        SMSService smsService = new SMSService("0123-456-789");
        Notification notifier = new Notification();
        
        System.out.println("\n[Demo 1: Email Notification]");
        notifier.setMessageService(emailService);
        notifier.send("Welcome to our service!");
        
        System.out.println("\n[Demo 2: SMS Notification]");
        notifier.setMessageService(smsService);
        notifier.send("Your verification code is 123456");
        
        System.out.println("\n[Demo 3: Back to Email]");
        notifier.setMessageService(emailService);
        notifier.send("Monthly newsletter is here!");
        
        System.out.println("\n[Demo 4: Multiple Notifications]");
        Notification notif1 = new Notification();
        Notification notif2 = new Notification();
        notif1.setMessageService(emailService);
        notif2.setMessageService(smsService);
        System.out.println("\nSending multiple notifications:");
        notif1.send("Order confirmation");
        notif2.send("Delivery update");
        
        System.out.println("\n[Demo 5: Error Handling]");
        Notification errorNotif = new Notification();
        errorNotif.send("This will fail");
    }
}