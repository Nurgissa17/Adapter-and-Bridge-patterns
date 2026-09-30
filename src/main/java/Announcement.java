public abstract class Announcement {
    protected final DeliveryChannel deliveryChannel;
    public Announcement(DeliveryChannel deliveryChannel) {
        this.deliveryChannel = deliveryChannel;
    }
    public abstract void send(String recipient, String message) throws DeliveryException;
}