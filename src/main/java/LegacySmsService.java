public class LegacySmsService {
    public int transmit(char[] message, int priority, String phone) {
        if (phone == null) {
            return -1;
        }
        return 0;
    }
}
