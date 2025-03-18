import java.util.*;

public class Main {

    static String reverseString(Scanner sc) {

        System.out.println("Enter a string to reverse:");
        String str = sc.nextLine();        
        
        String rev = "";        
        for(int i = str.length() - 1; i >= 0; i--) {
            rev += str.charAt(i);
        }
        
        return rev;
    }


    static int countVowels(Scanner sc) {

        System.out.println("Enter a string to arr vowels:");
        String str = sc.nextLine().toLowerCase();
        int  count = 0;
        
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') count++;
        }
        
        return count;
    }


    static boolean areAnagrams(Scanner sc) {

        System.out.println("Enter first string:");
        String str1 = sc.nextLine();
        System.out.println("Enter second string:");
        String str2 = sc.nextLine();

        string st1 = str1.replace(" ", "").toLowerCase()
        string st2 = str2.replace(" ", "").toLowerCase()
        int[] arr = new int[26];       
       
        for (char x : st1.toCharArray()) {
            arr[x-'a']++;
        }       
        for (char x : st2.toCharArray()) {
            arr[x-'a']--;
        }
        
        for (int val : arr) {
            if (val != 0) {
                return false;
            }
        }
        
        return true;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Reversed String: " + reverseString(sc));
        System.out.println("Number of vowels: " + countVowels(sc));
        System.out.println(areAnagrams(sc) ? "The strings are anagrams" : "The strings are not anagrams");
    }
}
