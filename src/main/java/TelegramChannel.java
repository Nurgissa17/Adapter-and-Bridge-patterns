public class TelegramChannel implements DeliveryChannel {
    @Override
    public void send(String recipient, String message) {
        System.out.println("[Telegram] " + message + " -> " + recipient);
    }
}
