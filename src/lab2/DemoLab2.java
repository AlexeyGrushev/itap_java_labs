package lab2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DemoLab2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<ComputerPeripheral> devices = new ArrayList<>();

        System.out.println("Creating default devices...");
        Keyboard k1 = new Keyboard();
        Headphones h1 = new Headphones();
        GraphicTablet g1 = new GraphicTablet();

        devices.add(k1);
        devices.add(h1);
        devices.add(g1);

        System.out.println("--- Device info (defaults) ---");
        for (ComputerPeripheral d : devices) {
            d.printInfo();
            d.connect();
            System.out.println();
        }

        // Demonstrate static counter for Keyboard
        System.out.println("Keyboards created: " + Keyboard.getCreatedCount());

        // Create a custom keyboard using console input
        System.out.println("\nCreate a custom keyboard (enter values) :");
        Keyboard custom = new Keyboard("LogiCorp", "K100", 79.99, true, 87, "ANSI");
        devices.add(custom);

        System.out.println("Custom keyboard info:");
        custom.printInfo();
        System.out.println("Mechanical: " + custom.isMechanical());
        System.out.println("Keys: " + custom.getKeyCount());

        System.out.println("Keyboards created after custom: " + Keyboard.getCreatedCount());

        // Polymorphism demo: call subclass-specific methods via casting
        System.out.println("\nPolymorphism and behavior demo:");
        for (ComputerPeripheral d : devices) {
            if (d instanceof Keyboard) {
                ((Keyboard) d).typeText("Hello");
            } else if (d instanceof Headphones) {
                ((Headphones) d).playSound("Song A");
            } else if (d instanceof GraphicTablet) {
                ((GraphicTablet) d).draw("Circle");
            }
        }

        // Simple I/O: update one device from console
        System.out.println("\nUpdate first headphone using console input:");
        Headphones hh = new Headphones();
        hh.inputInfoFromConsole();
        System.out.println("You entered:");
        hh.printInfo();

        sc.close();
    }
}
