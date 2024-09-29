import java.util.HashMap;
import java.util.Scanner;

public class Question4 {

    public static void findOddBalloon(int n, char[] balloons) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(balloons[i], map.getOrDefault(balloons[i], 0) + 1);
        }
        for (int i = 0; i < n; i++) {
            if (map.get(balloons[i]) % 2 != 0) {
                System.out.println(balloons[i]);
                return;
            }
        }
        System.out.println("All are even");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter the number of balloons:");
        int n = sc.nextInt();
        
        char[] balloons = new char[n];
        System.out.println("Enter the colours of the balloons:");
        for (int i = 0; i < n; i++) {
            balloons[i] = sc.next().charAt(0);
        }
        
        findOddBalloon(n, balloons);
        
        sc.close();
    }
}
