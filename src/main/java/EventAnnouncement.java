public class EventAnnouncement extends Announcement {
    public EventAnnouncement(DeliveryChannel deliveryChannel) {
        super(deliveryChannel);
    }
    @Override
    public void send(String recipient, String message) throws DeliveryException {
        deliveryChannel.send(recipient, "Event: " + message);
    }
}
