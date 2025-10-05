package lab2;

/**
 * Graphic Tablet peripheral
 */
public class GraphicTablet extends ComputerPeripheral {
    private double activeAreaWidth;
    private double activeAreaHeight;
    private int pressureLevels;

    public GraphicTablet() {
        super();
        this.activeAreaWidth = 200.0;
        this.activeAreaHeight = 150.0;
        this.pressureLevels = 2048;
    }

    public GraphicTablet(String manufacturer, String model, double price, double w, double h, int pressureLevels) {
        super(manufacturer, model, price);
        this.activeAreaWidth = w;
        this.activeAreaHeight = h;
        this.pressureLevels = pressureLevels;
    }

    @Override
    public void connect() {
        System.out.println("Graphic tablet connected. Ready to draw.");
    }

    @Override
    public void disconnect() {
        System.out.println("Graphic tablet disconnected.");
    }

    public void draw(String shape) {
        System.out.println("Drawing: " + shape + " on area " + activeAreaWidth + "x" + activeAreaHeight);
    }

    // Getters/setters
    public double getActiveAreaWidth() { return activeAreaWidth; }
    public void setActiveAreaWidth(double activeAreaWidth) { this.activeAreaWidth = activeAreaWidth; }
    public double getActiveAreaHeight() { return activeAreaHeight; }
    public void setActiveAreaHeight(double activeAreaHeight) { this.activeAreaHeight = activeAreaHeight; }
    public int getPressureLevels() { return pressureLevels; }
    public void setPressureLevels(int pressureLevels) { this.pressureLevels = pressureLevels; }
}
