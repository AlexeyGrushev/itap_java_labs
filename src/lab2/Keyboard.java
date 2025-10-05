package lab2;

/**
 * Keyboard peripheral
 */
public class Keyboard extends ComputerPeripheral {
    private boolean mechanical;
    private int keyCount;
    private String layout;

    // Static counter of created Keyboard objects
    private static int createdCount = 0;

    public Keyboard() {
        super();
        this.mechanical = false;
        this.keyCount = 104;
        this.layout = "QWERTY";
        createdCount++;
    }

    public Keyboard(String manufacturer, String model, double price, boolean mechanical, int keyCount, String layout) {
        super(manufacturer, model, price);
        this.mechanical = mechanical;
        this.keyCount = keyCount;
        this.layout = layout;
        createdCount++;
    }

    @Override
    public void connect() {
        System.out.println("Keyboard connected via USB or Bluetooth.");
    }

    @Override
    public void disconnect() {
        System.out.println("Keyboard disconnected.");
    }

    public void typeText(String text) {
        System.out.println("Typing on keyboard: " + text);
    }

    // Getters/setters
    public boolean isMechanical() { return mechanical; }
    public void setMechanical(boolean mechanical) { this.mechanical = mechanical; }
    public int getKeyCount() { return keyCount; }
    public void setKeyCount(int keyCount) { this.keyCount = keyCount; }
    public String getLayout() { return layout; }
    public void setLayout(String layout) { this.layout = layout; }

    public static int getCreatedCount() { return createdCount; }
}
