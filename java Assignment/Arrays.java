import java.util.Scanner;

public class Main {

    static double averageOfArray(int[] arr) {
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        return (double) sum/arr.length;
    }

    static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n-i-1; j++) {
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    static int linearSearch(int[] arr, int key) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of elements:");
        int n = sc.nextInt();
        int[] arr = new int[n];

        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println("Average of elements: " + averageOfArray(arr));

        bubbleSort(arr);
        System.out.print("Sorted Array: ");
        for (int num : arr) System.out.print(num + " ");
        System.out.println();

        System.out.println("Enter element to search:");
        int key = sc.nextInt();
        int index = linearSearch(arr, key);
        System.out.println(index != -1 ? "Element found at index " + index : "Element not found");
    }
}
