interface MessageService {
    void sendMessage(String message, String recipient);
}

class EmailService implements MessageService {
    @Override
    public void sendMessage(String message, String recipient) {
        System.out.println("Email sent to " + recipient + " with message: " + message);
    }
}

class SMSService implements MessageService {
    @Override
    public void sendMessage(String message, String recipient) {
        System.out.println("SMS sent to " + recipient + " with message: " + message);
    }
}

class MessageSender {
    private final MessageService messageService;

    // Injection de dépendance via le constructeur
    public MessageSender(MessageService messageService) {
        this.messageService = messageService;
    }

    public void send(String message, String recipient) {
        messageService.sendMessage(message, recipient);
    }
}

public class InjectExample {
    public static void main(String[] args) {
        // Injection de dépendance avec EmailService
        MessageService emailService = new EmailService();
        MessageSender emailSender = new MessageSender(emailService);
        emailSender.send("Hello via Email", "john.doe@example.com");

        // Injection de dépendance avec SMSService
        MessageService smsService = new SMSService();
        MessageSender smsSender = new MessageSender(smsService);
        smsSender.send("Hello via SMS", "+1234567890");
    }
}