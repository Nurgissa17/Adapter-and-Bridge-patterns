public class EmergencyAnnouncement extends Announcement {
    public EmergencyAnnouncement(DeliveryChannel deliveryChannel) {
        super(deliveryChannel);
    }
    @Override
    public void send(String recipient, String message) throws DeliveryException {
        deliveryChannel.send(recipient, "Emergency: " + message);
    }
}
