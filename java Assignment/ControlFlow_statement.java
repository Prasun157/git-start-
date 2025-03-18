import java.util.Scanner;

public class Main{
    
    static boolean isPrime(Scanner sc){
        
        System.out.println("enter your Number : ");
        int n = sc.nextInt();
    
        for(int i=2 ; i<n ; i++){
            if(n%i == 0){
                return false;
            }
        }
        return true;
    }

    static int GreatestOfThree(Scanner sc){

        System.out.println("enter 1st Number : ");
        int a = sc.nextInt();
        System.out.println("enter 2nd Number : ");
        int b = sc.nextInt();
        System.out.println("enter 3rd Number : ");
        int c = sc.nextInt();

        if(a>=b && a>=c) return a;
        else if( b>=a && b>=c) return b;
        else return c;                 

    }


    static void MultiplicationTable(Scanner sc){

        System.out.println("enter Number : ");
        int a = sc.nextInt();

        for(int i = 1 ; i <= 20 ; i++){
            System.out.println(a + " x " + i + " = " + a*i);
        }
    }

    static int Suminator(){
        int i = 1;
        int sum = 0;

        while(i <= 10){
            if(i%2 == 0)sum+=i;
            i++;
        }        
        return sum;
    }


    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println(isPrime(sc) ? "is Prime Number" : "Not a Prime Number");
        System.out.println("The Largest of all Three is " + GreatestOfThree(sc)  );
        System.out.println("Here is your Table:" );
        MultiplicationTable(sc);
        System.out.println("the sum of even numbers from 1 to 10 " + Suminator());

    }
}

