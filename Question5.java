import java.util.Scanner;

public class Question5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] oxygenLevels = new int[9];
        boolean validInput = true;

        // Input for oxygen levels
        for (int i = 0; i < 9; i++) {
            int oxygen = scanner.nextInt();
            if (oxygen < 1 || oxygen > 100) {
                System.out.println("INVALID INPUT");
                validInput = false;
                break;
            }
            oxygenLevels[i] = oxygen;
        }

        if (validInput) {
            // Calculate average oxygen levels for each trainee
            int[] traineeAvg = new int[3];
            traineeAvg[0] = Math.round((oxygenLevels[0] + oxygenLevels[3] + oxygenLevels[6]) / 3.0f);
            traineeAvg[1] = Math.round((oxygenLevels[1] + oxygenLevels[4] + oxygenLevels[7]) / 3.0f);
            traineeAvg[2] = Math.round((oxygenLevels[2] + oxygenLevels[5] + oxygenLevels[8]) / 3.0f);

            // Determine the highest average oxygen level
            int maxAvg = Math.max(traineeAvg[0], Math.max(traineeAvg[1], traineeAvg[2]));

            // Check if all trainees are unfit
            if (maxAvg < 70) {
                System.out.println("All trainees are unfit");
            } else {
                // Find the trainees with the highest average oxygen level
                for (int i = 0; i < 3; i++) {
                    if (traineeAvg[i] == maxAvg) {
                        System.out.println("Trainee Number : " + (i + 1));
                    }
                }
            }
        }

        scanner.close();
    }
}
