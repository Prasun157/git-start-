import java.util.Scanner;

public class Main {
    public static void arithmeticOperations(Scanner sc) {
        System.out.println("Enter a: ");
        int a = sc.nextInt();
        System.out.println("Enter b: ");
        int b = sc.nextInt();
        System.out.println(a + b);
        System.out.println(a - b);
        System.out.println(a * b);
        System.out.println(a / b);
        System.out.println(a % b);
    }

    public static void logicalOperations(Scanner sc) {
        System.out.println("Enter boolean a: ");
        
        boolean x = sc.nextBoolean();
        System.out.println("Enter boolean b: ");
        boolean y = sc.nextBoolean();
        System.out.println(x && y);
        System.out.println(x || y);
        System.out.println(!x);
    }

    public static void relationalOperations(Scanner sc) {
        System.out.println("Enter a: ");
        int a = sc.nextInt();
        System.out.println("Enter b: ");
        int b = sc.nextInt();
        System.out.println(a > b);
        System.out.println(a < b);
        System.out.println(a == b);
        System.out.println(a != b);
        System.out.println(a >= b);
        System.out.println(a <= b);
    }

    public static double celsiusToFahrenheit(double celsius) {
        return (celsius * 9/5) + 32;
    }

    public static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5/9;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        arithmeticOperations(sc);
        logicalOperations(sc);
        relationalOperations(sc);
        
        System.out.println("Enter temp in Celsius: ");
        double a = sc.nextDouble();
        System.out.println("temp in Fahrenheit is " + celsiusToFahrenheit(a));
        
         System.out.println("Enter temp in Fahrenheit: ");
         double b = sc.nextDouble();
        System.out.println("temp in Celsius is " + fahrenheitToCelsius(b));
       
    }
}

// Primitive types hold true values directly (example int, boolean), 
// and are copied when assigned. Reference types hold addresses 
// (example String, arrays),so assignments make aliases referring 
// to the same data.