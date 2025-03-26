/**
 * CS 152 Lab 5 - Wordle
 *
 * Implement the methods needed to play a Wordle-like game.
 *
 * Student name: Gabe Olivas
 */
import java.util.Scanner;

/** Contains methods for a wordle clone */
public class Wordle {

    /**
     * Represents a letter in the guess in the correct position.
     */
    public static final char CORRECT = 'X';

    /**
     * Represents a letter in the guess that is present, but in wrong place.
     */
    public static final char PRESENT = 'o';

    /**
     * Represents a letter in the guess does not occur in the word at all.
     */
    public static final char MISSING = '.';

    /**
     * How many guesses do we get to solve the puzzle?
     */
    public static final int NUMBER_OF_GUESSES = 6;

    /**
     * Picks a random word from the word list.
     *
     * @param gameWords An array of words to pick from.
     * @return Randomly chosen word from the word list.
     */
    public static String selectRandomWord(String[] gameWords) {
        int lengthOfArray = gameWords.length;
        String randomWord = gameWords[(int) (Math.random() * (lengthOfArray))];
        return randomWord;

    }

    /**
     * Is the guess a recognized word?
     *
     * @param validWords Array of known words.
     * @param userGuess  The guess word.
     * @return True if userGuess is in validWords, false if not.
     */
    public static boolean isKnownWord(String[] validWords, String userGuess) {
        for (int i = 0; i < validWords.length; i++) {
            if (validWords[i].equals(userGuess)) {
                return true;
            }
        }
        return false;
    }

    /**
     * How close is the guess to the secret word?
     *
     * @param secret The secret word
     * @param guess  Guessed word
     * @return Array of characters corresponding to the letters of guess,
     * where the char at a given index is:
     * CORRECT if the guess letter appears at that position in secret word
     * PRESENT if the guess letter is present in secret word elsewhere
     * MISSING if the guess letter does not occur in secret word
     */
    public static char[] getGuessResult(String secret, String guess) {
        /*
         * This method uses a temporary `secretArray` which is the charArray of
         * secret. This helps us when we iterate through present characters
         * First it checks for correct characters and places the correct
         * variable in the result array. Then in our temporary array it sets
         * that position to null. This is important because when we go over
         * present characters we don't want to count correct characters as also
         * being present.
         */

        char[] secretArray = secret.toCharArray();
        char[] result = new char[secretArray.length];

        for (int i = 0; i < secretArray.length; i++) {
            if (guess.charAt(i) == secretArray[i]) {
                result[i] = CORRECT;
                secretArray[i] = '\0'; // Sets the character to null
            }
        }
            for (int i = 0; i < secretArray.length; i++) {
                for (int j = 0; j < secretArray.length; j++) {
                    if (result[i] != CORRECT && (guess.charAt(i)
                    == secretArray[j])) {
                        result[i] = PRESENT;
                        secretArray[j] = '\0';
                        break;
                    }
                }
                if (result[i] == '\0') {
                    result[i] = MISSING;
                }
            }
        return result;
    }

    /**
     * Is this a winning result?
     * @param guessResult Array as returned by getGuessResult
     * @return True if all places are CORRECT, false if not
     */
    public static boolean isWinning (char[] guessResult) {
        for (int i = 0; i < guessResult.length; i++) {
            if (guessResult[i] != CORRECT) {
                return false;
            }
        }
        return true;
    }

    /**
     * Plays a console based Wordle game
     * @param args Ignored
     */
    public static void main (String[]args){

        System.out.println("Let's play Wordle!");
        System.out.println();


        Scanner in = new Scanner(System.in);

// The big array of words is in a separate file
        String[] words;
// Prompt user for which word array to use
        System.out.println("Play with 5 letter words? (y/n)");
        if (in.nextLine().trim().toLowerCase().startsWith("y")) {
            System.out.println("Using five letter words");
            words = WordleDictionary.FIVE_LETTER_WORDS;
        } else {
            System.out.println("Using two letter words (for quick testing)");
            words = WordleDictionary.TWO_LETTER_WORDS;
        }
        System.out.println();

        String secret = selectRandomWord(words);
        int guesses = NUMBER_OF_GUESSES;

        boolean winning;

        do {
            System.out.println("Guesses remaining: " + guesses);
            System.out.println("What is your guess?");

            String guess = in.nextLine().trim().toLowerCase();

            while (!isKnownWord(words, guess)) {
                System.out.println("Not a recognized word! Try again");
                guess = in.nextLine().trim().toLowerCase();
            }

            char[] guessResult = getGuessResult(secret, guess);
            System.out.println(new String(guessResult));

            winning = isWinning(guessResult);
            guesses--;

        } while (guesses > 0 && !winning);

        System.out.println("The word was " + secret);
    }
}

