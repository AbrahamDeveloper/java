import java.util.Random;
import java.util.Scanner;

public class DiceRollGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Dice Rolling Game");
        System.out.println("-----------------");

        System.out.print("Enter the number of dice rolls: ");
        int numRolls = scanner.nextInt();

        int totalScore = 0;
        for (int i = 0; i < numRolls; i++) {
            int diceRoll = random.nextInt(6) + 1;
            System.out.println("Roll " + (i + 1) + ": " + diceRoll);
            totalScore += diceRoll;
        }

        System.out.println();
        System.out.println("Total Score: " + totalScore);
    }
}
