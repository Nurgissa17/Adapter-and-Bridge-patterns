public class LegacySmsAdapter implements DeliveryChannel {
    private final LegacySmsService legacySmsService;
    public LegacySmsAdapter(LegacySmsService legacySmsService) {
        this.legacySmsService = legacySmsService;
    }
    @Override
    public void send(String recipient, String message) throws DeliveryException {
        int result = legacySmsService.transmit(message.toCharArray(), 1, recipient);

        if (result == -1) {
            throw new DeliveryException("Invalid phone number");
        }
    }
}