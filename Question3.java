import java.util.Scanner;

public class Question3 {

    public static int findMaxOfMins(int[] space, int k) {
        int maxMin = Integer.MIN_VALUE;
        for (int i = 0; i <= space.length - k; i++) {
            int currentMin = Integer.MAX_VALUE;
            for (int j = i; j < i + k; j++) {
                currentMin = Math.min(currentMin, space[j]);
            }
            maxMin = Math.max(maxMin, currentMin);
        }
        return maxMin;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter the length of the segment:");
        int k = sc.nextInt();
        
        System.out.println("Enter the size of the array:");
        int n = sc.nextInt();
        
        int[] space = new int[n];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            space[i] = sc.nextInt();
        }
        
        int result = findMaxOfMins(space, k);
        System.out.println(result);
        
        sc.close();
    }
}
