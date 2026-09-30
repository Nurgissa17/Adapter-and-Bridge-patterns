public class Main {
    public static void main(String[] args) throws DeliveryException {
        DeliveryChannel deliveryChannel;
        if ("email".equals(args[0])) {
            deliveryChannel = new EmailChannel();
        } else if ("telegram".equals(args[0])) {
            deliveryChannel = new TelegramChannel();
        } else {
            deliveryChannel = new LegacySmsAdapter(new LegacySmsService());
        }
        Announcement announcement = new EventAnnouncement(deliveryChannel);
        announcement.send(args[1], args[2]);
    }
}
