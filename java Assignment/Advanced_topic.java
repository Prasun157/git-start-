import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Exception Handling
        try {
            System.out.println("Enter car speed: ");
            int speed = sc.nextInt();
            Car tesla = new Car("Tesla cyber truck", speed, 99);

            tesla.start();
            tesla.fuelType();
            tesla.chargeBattery();
            tesla.stop();
            
        } catch (InputMismatchException e) {
            System.out.println("Invalid input! Please enter a number.");
            
        }
        
        System.out.println();
        
        // File I/O 
        try {
            BufferedReader br = new BufferedReader(new FileReader("notepad1.txt"));
            System.out.println("File Content:");
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            br.close();
        } catch (IOException e) {
            System.out.println("Error reading file.");
        }
        
        System.out.println();
        
        // Multithreading 
        Thread t1 = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                System.out.println("Task 1 - " + i);
                try { Thread.sleep(1000); } catch (InterruptedException e) {}
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                System.out.println("Task 2 - " + i);
                try { Thread.sleep(1000); } catch (InterruptedException e) {}
            }
        });

        t1.start();
        t2.start();
    }
}


interface Electric {
    void chargeBattery();
}

abstract class Vehicle {
    String brand;
    int speed;

    Vehicle(String brand, int speed) {
        this.brand = brand;
        this.speed = speed;
    }

    abstract void fuelType();

    void start() {
        System.out.println(brand + " is starting...");
    }

    void stop() {
        System.out.println(brand + " is stopping...");
    }
}

class Car extends Vehicle implements Electric {
    int batteryLevel;

    Car(String brand, int speed, int batteryLevel) {
        super(brand, speed);
        this.batteryLevel = batteryLevel;
    }

    void fuelType() {
        System.out.println(brand + " runs on electricity.");
    }

    public void chargeBattery() {
        System.out.println("Charging battery... Current level: " + batteryLevel + "%");
    }
}
