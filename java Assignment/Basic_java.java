import java.util.*;

public class Main {
    
    static double calculateArea(String shape, double a, double b) {   
             
        if (shape.equalsIgnoreCase("circle")) return 3.14 * a * a;
        else if (shape.equalsIgnoreCase("triangle")) return a*b * 0.5;
        else if (shape.equalsIgnoreCase("rectangle")) return a * b;
        else return -1;
        
    }
    
    static boolean isEven(int num) {
        return num%2 == 0;
    }
    
    static long factorial(int n) {
        long fact = 1;
        for (int i = 2; i<= n; i++) fact *= i;
        return fact;
    }
    
    static void Fibonacci(int n) {
        int a = 0, b = 1;
        System.out.print(a + " " + b + " ");
        for (int i = 2; i < n; i++) {
            int next = a + b;
            System.out.print(next + " ");
            a = b;
            b = next;
            
        }
        System.out.println();
    }
    
    static void Pattern(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("enter the Shape(Circle/Triangle/Rectangle) : ");
        String shape = sc.next();
        System.out.print("Enter Parameters a : ");
        double a = sc.nextDouble();
        System.out.print("Enter Parameters b : ");
        double b = sc.nextDouble();
        System.out.println("the area is " + calculateArea(shape, a, b)); 
        
        
        System.out.println("Enter the number to check whether its even or odd : ");
        int num = sc.nextInt();
        System.out.println(isEven(num) ? " is Even" : " is Odd");
        
        
        System.out.println("Enter the number to check Factorial : " );
        int factNum = sc.nextInt();
        System.out.println(factorial(factNum));
        
        
        System.out.println("Enter the number for Fibonacchi series: ");
        int fibNum = sc.nextInt();
        Fibonacci(fibNum);
        
        
        System.out.println("Enter the number to see Star Pattern ");
        int patNum = sc.nextInt();
        Pattern(patNum);
        
        
    }
}