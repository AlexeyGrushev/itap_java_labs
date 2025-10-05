package lab2;

/**
 * Headphones peripheral
 */
public class Headphones extends ComputerPeripheral {
    private boolean wireless;
    private int maxVolume;
    private boolean hasMic;

    public Headphones() {
        super();
        this.wireless = false;
        this.maxVolume = 100;
        this.hasMic = false;
    }

    public Headphones(String manufacturer, String model, double price, boolean wireless, int maxVolume, boolean hasMic) {
        super(manufacturer, model, price);
        this.wireless = wireless;
        this.maxVolume = maxVolume;
        this.hasMic = hasMic;
    }

    @Override
    public void connect() {
        System.out.println("Headphones connected. Streaming audio...");
    }

    @Override
    public void disconnect() {
        System.out.println("Headphones disconnected.");
    }

    public void playSound(String track) {
        System.out.println("Playing: " + track + " at volume " + (maxVolume/10));
    }

    // Getters/setters
    public boolean isWireless() { return wireless; }
    public void setWireless(boolean wireless) { this.wireless = wireless; }
    public int getMaxVolume() { return maxVolume; }
    public void setMaxVolume(int maxVolume) { this.maxVolume = maxVolume; }
    public boolean isHasMic() { return hasMic; }
    public void setHasMic(boolean hasMic) { this.hasMic = hasMic; }
}
