public interface DeliveryChannel {
    void send(String recipient, String message) throws DeliveryException;
}
