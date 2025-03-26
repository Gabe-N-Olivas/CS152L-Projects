/**
 * This assignment asks us to make a program which picks a random number and
 * compares that to another number a user chooses. If the numbers are the same
 * they win!
 * @author Gabe Olivas
 */
import java.util.Scanner;

public class NumberGuesser {
    public static final int NUMBER_LIM = 15;
    /**
     * This program asks the user for their name, and then their number guess.
     * it then compares the two to see if they got it right. It can also check
     * if user input is outside the guessing range.
     * @param args Command - line arguments are ignored .
     */
    public static void main(String[] args) {
        Scanner scanIn = new Scanner(System.in);

        // Getting the user's name
        System.out.println("Hello! What is your name?");
        String userName = scanIn.nextLine();

        // Gets the user's number guess and then prints it
        System.out.println("\n"+userName+", guess a number from 1-"+NUMBER_LIM);
        int guess = scanIn.nextInt();
        System.out.println("\nYou guessed " + guess + "!");

        /*
         * Adding 1 to NUMBER_LIM eliminates two problems. One. It prevents 0
         * from being an option the program uses Two. math.random() doesnt reach
         * 1 so without it the upper limit would be NUMBER_LIM - 1
         */

        // The program gets and prints its number
        int randomNumber = (int) (Math.random() * NUMBER_LIM + 1);
        System.out.println("The number I chose was " + randomNumber + "!");

        if (guess == randomNumber) {
            System.out.println("Congratulations! " + userName);
            System.out.println("You guessed it!");
        } else if (0 > guess || guess > 15) {
            // Scolds the user for not following basic instructions
            System.out.println(userName + "...");
            System.out.println(guess + " isn't between 1-"+ NUMBER_LIM +".");
        } else {
            System.out.println("Sorry, " + userName);
            System.out.println("That wasn't what I was thinking of...");
        }
    }
}
