package lk.kaushalya.practical;

/*
 * Practical 06
 * Flyweight Pattern
 *
 * A flyweight is an object that minimizes the memory usage by sharing as much data
 * as possible with other similar objects.
 *
 * "NanoPaint" is a car painting shop. Write a program to demonstrate the car
 * painting process by creating different car objects and paint using different colors.
 * Make sure to use color as a Flyweight object.
 *
 */

import java.util.HashMap;
import java.util.Map;

// Abstract Car class
abstract class AbstractCar {
    public abstract void paint();
}

// Shared Flyweight object for color
class Color {
    private String colorName;

    public Color(String colorName) {
        this.colorName = colorName;
    }

    public String getColorName() {
        return colorName;
    }
}

// Unique Car objects
class Car extends AbstractCar {

    // Extrinsic State
    private String ownerName;
    private String carModel;
    private String licensePlateNo;

    // Intrinsic State
    private Color color;

    public Car(String ownerName, String carModel, String licensePlateNo, String color) {
        this.ownerName = ownerName;
        this.carModel = carModel;
        this.licensePlateNo = licensePlateNo;
        this.color = ColorFactoryPool.getColor(color);
    }

    @Override
    public void paint() {
        System.out.println();
        System.out.println("Painting Car...");
        System.out.println("Car Model: " + this.carModel);
        System.out.println("Owner Name: " + this.ownerName);
        System.out.println("License Plate No: " + this.licensePlateNo);
        System.out.println("Car Color: " + this.color.getColorName());
        System.out.println();
        System.out.println("Color Object: " + this.color);
        System.out.println("Car painted successfully!");
        System.out.println("-----------------------------");
    }
}

// Shared Flyweight Factory for Color objects
class ColorFactoryPool {

    private static final Map<String, Color> colorPool = new HashMap<>();

    public static Color getColor(String colorName) {
        if (!colorPool.containsKey(colorName)) {
            System.out.println(">> Creating new Color object for: " + colorName);
            colorPool.put(colorName, new Color(colorName));
        }
        return colorPool.get(colorName);

    }

    public static int getTotalColorsCreated() {
        return colorPool.size();
    }

}

public class Practical {
    public static void main(String[] args) {
        System.out.println("NanoPaint Car Painting Shop\n");
        System.out.println("Creating different car objects and painting them using different colors...\n");
        System.out.println("-----------------------------------\n");

        Car car1 = new Car("John Doe", "Toyota Camry", "ABC-1234", "Red");
        Car car2 = new Car("Jane Smith", "Honda Civic", "XYZ-5678", "Blue");
        Car car3 = new Car("Alice Johnson", "Ford Mustang", "LMN-9101", "Red");
        Car car4 = new Car("Bob Brown", "Chevrolet Camaro", "PQR-2345", "Green");
        Car car5 = new Car("Charlie Davis", "Nissan Altima", "STU-6789", "Blue");

        car1.paint();
        car2.paint();
        car3.paint();
        car4.paint();
        car5.paint();

        System.out.println("Total unique Color objects created: " + ColorFactoryPool.getTotalColorsCreated());
        System.out.println("All cars painted successfully!");
    }
}
