import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
public class AnnouncementTest {
    private static class StubDeliveryChannel implements DeliveryChannel {
        String recipient;
        String message;
        @Override
        public void send(String recipient, String message) {
            this.recipient = recipient;
            this.message = message;
        }
    }
    @Test
    void eventAnnouncementDelegates() throws DeliveryException {
        StubDeliveryChannel stub = new StubDeliveryChannel();
        Announcement announcement = new EventAnnouncement(stub);
        announcement.send("student", "Hackathon");
        assertEquals("student", stub.recipient);
        assertEquals("Event: Hackathon", stub.message);
    }
    @Test
    void emergencyAnnouncementDelegates() throws DeliveryException {
        StubDeliveryChannel stub = new StubDeliveryChannel();
        Announcement announcement = new EmergencyAnnouncement(stub);
        announcement.send("student", "Building closed");
        assertEquals("student", stub.recipient);
        assertEquals("Emergency: Building closed", stub.message);
    }
    @Test
    void adapterTranslatesFailure() {
        DeliveryChannel deliveryChannel = new LegacySmsAdapter(new LegacySmsService());
        DeliveryException exception = assertThrows(
                DeliveryException.class,
                () -> deliveryChannel.send(null, "Message")
        );
        assertEquals("Invalid phone number", exception.getMessage());
    }
}