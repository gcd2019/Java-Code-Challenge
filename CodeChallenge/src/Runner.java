import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Runner {

    public static void main(String[] args) {
        int numPlays = 1000000;
        int numRolls1 = 4;
        int numRolls2 = 24;
        int payout = 1;
        Random rand = new Random();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // Display menu
            System.out.println("Choose a game to simulate (1000000) times:");
            System.out.println("1. Roll one die four times, win if at least one six appears");
            System.out.println("2. Roll two dice 24 times, win if double sixes appear at least once");
            System.out.println("3. Quit");

            // Read user input
            int choice;
            try {
                choice = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.\n");
                scanner.nextLine(); // clear the scanner buffer
                continue; // go back to the beginning of the loop
            }

            // Play the selected game or quit
            if (choice == 1) {
                Game game1 = new OneDieGame(numRolls1, payout, rand);
                game1.simulate(numPlays);
            } else if (choice == 2) {
                Game game2 = new TwoDiceGame(numRolls2, payout, rand);
                game2.simulate(numPlays);
            } else if (choice == 3) {
                break; // Exit the loop and end the program
            } else {
                System.out.println("Invalid choice. Please choose 1, 2, or 3.");
            }
        }

        System.out.println("Thanks for playing!");
    }
}