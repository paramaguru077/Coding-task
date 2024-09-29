import java.util.Scanner;

public class Question2 {
    
    // Function to calculate number of frogs between two stones for each query
    public static int[] countFrogsBetweenStones(String s, int[] startIndices, int[] endIndices, int n) {
        int[] result = new int[n];
        int len = s.length();
        
        // Preprocessing to get the number of stars (*) up to each index
        int[] starPrefix = new int[len];
        int[] leftStone = new int[len];
        int[] rightStone = new int[len];
        
        int starCount = 0;
        int lastLeftStone = -1;
        
        // Calculate prefix sum of stars and nearest left stones
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == '*') {
                starCount++;
            } else if (s.charAt(i) == '|') {
                lastLeftStone = i;
            }
            starPrefix[i] = starCount;
            leftStone[i] = lastLeftStone;
        }
        
        // Calculate nearest right stones
        int nextRightStone = -1;
        for (int i = len - 1; i >= 0; i--) {
            if (s.charAt(i) == '|') {
                nextRightStone = i;
            }
            rightStone[i] = nextRightStone;
        }

        // Process each query
        for (int i = 0; i < n; i++) {
            // Convert 1-based index to 0-based index
            int start = startIndices[i] - 1;
            int end = endIndices[i] - 1;
            
            // Find the leftmost bar after start and the rightmost bar before end
            int left = rightStone[start];
            int right = leftStone[end];
            
            if (left != -1 && right != -1 && left < right) {
                // If valid bars are found, count the stars between them
                result[i] = starPrefix[right] - starPrefix[left];
            } else {
                result[i] = 0; // No valid bars or no stars between bars
            }
        }
        
        return result;
    }

    public static void main(String[] args) {
        // Input handling
        Scanner sc = new Scanner(System.in);
        
        // Read the string
        String s = sc.nextLine();
        
        // Read the number of queries
        int n = sc.nextInt();
        
        // Read start indices
        int[] startIndices = new int[n];
        for (int i = 0; i < n; i++) {
            startIndices[i] = sc.nextInt();
        }
        
        // Read end indices
        int[] endIndices = new int[n];
        for (int i = 0; i < n; i++) {
            endIndices[i] = sc.nextInt();
        }
        
        // Calculate the result
        int[] result = countFrogsBetweenStones(s, startIndices, endIndices, n);
        
        // Print the results
        for (int res : result) {
            System.out.println(res);
        }
        
        sc.close();
    }
}

