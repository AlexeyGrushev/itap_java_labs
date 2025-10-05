package lab2;

import java.util.Scanner;

/**
 * Abstract base class for computer peripherals
 */
public abstract class ComputerPeripheral {
    protected String manufacturer;
    protected String model;
    protected double price;

    public ComputerPeripheral() {
        this.manufacturer = "Unknown";
        this.model = "Unknown";
        this.price = 0.0;
    }

    public ComputerPeripheral(String manufacturer, String model, double price) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.price = price;
    }

    // Abstract behavior methods
    public abstract void connect();
    public abstract void disconnect();

    // Common methods
    public void inputInfoFromConsole() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Manufacturer: ");
        this.manufacturer = sc.nextLine();
        System.out.print("Model: ");
        this.model = sc.nextLine();
        System.out.print("Price: ");
        try {
            this.price = Double.parseDouble(sc.nextLine());
        } catch (NumberFormatException e) {
            this.price = 0.0;
        }
        sc.close();
    }

    public void printInfo() {
        System.out.println("Manufacturer: " + manufacturer);
        System.out.println("Model: " + model);
        System.out.println("Price: " + price);
    }

    // Getters and setters
    public String getManufacturer() { return manufacturer; }
    public void setManufacturer(String manufacturer) { this.manufacturer = manufacturer; }
    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
}
