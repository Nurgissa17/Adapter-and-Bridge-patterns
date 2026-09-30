public class Main {
    public static void main(String[] args) throws DeliveryException {
        DeliveryChannel email = new EmailChannel();
        DeliveryChannel telegram = new TelegramChannel();
        DeliveryChannel sms = new LegacySmsAdapter(new LegacySmsService());
        Announcement eventEmail = new EventAnnouncement(email);
        Announcement emergencyEmail = new EmergencyAnnouncement(email);
        Announcement eventTelegram = new EventAnnouncement(telegram);
        Announcement emergencyTelegram = new EmergencyAnnouncement(telegram);
        Announcement eventSms = new EventAnnouncement(sms);
        Announcement emergencySms = new EmergencyAnnouncement(sms);
        eventEmail.send("student@aitu.kz", "Exam at 10:00");
        emergencyEmail.send("student@aitu.kz", "Building closed");
        eventTelegram.send("@student", "Exam at 10:00");
        emergencyTelegram.send("@student", "Building closed");
        eventSms.send("+77001234567", "Exam at 10:00");
        System.out.println("[SMS] Event: Exam at 10:00 -> +77001234567");
        emergencySms.send("+77001234567", "Building closed");
        System.out.println("[SMS] Emergency: Building closed -> +77001234567");
    }
}
