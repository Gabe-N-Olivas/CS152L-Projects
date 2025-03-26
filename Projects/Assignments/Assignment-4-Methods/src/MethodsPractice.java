/**
 * CS152 Lab 4 -- Welcome to Methods.
 * @author Gabe Olivas
 */
public class MethodsPractice {

    // The next few methods are just for keeping track of test
    // results, so leave them alone.

    // Variables to keep track of the tests in main
    private static int correctTests = 0;
    private static int totalTests = 0;

    /** Clear test count variables */
    private static void clearCounts() {
        correctTests = 0;
        totalTests = 0;
    }

    /**
     * Update test count variables depending on if test passed.
     * @param correct True if test counts as correct.
     */
    private static void countTest(boolean correct) {
        if(correct) {
            correctTests++;
        }
        totalTests++;
    }

    /**
     * Print the testing results and return if all passed.
     * @param name Name of test group
     * @return True if all tests passed.
     */
    private static boolean checkResults(String name) {
        System.out.println(name + " passes " + correctTests +
                " out of " + totalTests + " tests");
        return correctTests == totalTests;
    }


    // Methods Practice Below

    /**
     * Returns smallest of its arguments.
     * @param x First argument
     * @param y Second argument
     * @param z Third argument
     * @return Minimum of x, y and z
     */
    public static int minOfThree( int x, int y, int z) {
        if (x < y && x < z){
            return x;
        }
        else return Math.min(y, z);

    }

    /**
     * Create a new string containing the characters of the
     * given string in reverse order.
     * @param s The string to reverse
     * @return Reversed string.
     */
    public static String reverseString(String s) {
        /*
         * Gets the length of the string so we know where the end of the string
         * is located
         */
        int stringLength = s.length();

        String reversed = "";
        for (int i = 0; i < stringLength; i++) {
            /*
             * To get to the end we take the length (the last part of the string
             * index) and subtract it by `i`. Since in the charAt method the
             * index starts at 0 and stringLength starts at 1 we need to
             * subtract 1 in order for them to match up. Then using this number
             * we get the char in the `s` index and append it to `reversed`
             * which is our return value
             */
            reversed += s.charAt(stringLength - i - 1);
        }
        return reversed;
    }

    /**
     * Takes in a character and returns a boolean value whether it is a letter
     * A-Z or a-z, or a digit 0-9.
     * @param character the character to test
     * @return boolean value; true if it is a letter or digit, false if not
     */
    public static boolean isLetterOrDigit(char character) {
        return Character.isLetter(character) || Character.isDigit(character);
    }

    /**
     * This method takes in a phrase and interprets each character by calling
     * on isLetterOrDigit. This method only checks for characters described in
     * isLetterOrDigit (This includes returning false for whitespace)
     * @param phrase the phrase to get only letters and digits
     * @return String of phrase which has no punctuation, whitespace, etc., only
     * characters and digits.
     */
    public static String getLettersAndDigits(String phrase){
        int phraseLength = phrase.length();
        String lettersAndDigits = "";

        for (int i = 0; i < phraseLength; i++) {
            if (isLetterOrDigit(phrase.charAt(i))){
                lettersAndDigits += phrase.charAt(i);
            }
        }
        return lettersAndDigits;
    }

    /**
     * This method takes in a phrase and checks to see if it is a palindrome (a
     * phrase which is spelled the same way when reversed) It ignores all non
     * characters and numbers including whitespace
     * @param phrase the string to check for if it is a palindrome
     * @return boolean value; true if it is a palindrome false if not
     */
    public static boolean isPalindromePhrase(String phrase){
        /*
         * Since this method is case-insensitive we make the `phrase` lowercase
         * so when we compare the chars they won't return false if it compares
         * an upper case letter to a lower case letter.
         */
        phrase = phrase.toLowerCase();
        phrase = getLettersAndDigits(phrase);

        int stringLength = phrase.length();
        for (int i = 0; i < (stringLength / 2); i++) {
            if (phrase.charAt(i) != phrase.charAt(stringLength-i-1))
                return false;
        }
        return true;
    }

    /**
     * Average up to five odd numbers. Any even values are not included in the
     * average.
     * @param a First value
     * @param b Second value
     * @param c Third value
     * @param d Fourth value
     * @param e Fifth value
     * @return Average of the odd input values. If none are odd, returns -1000.
     */
    public static double averageOddNumbers(int a, int b, int c, int d, int e) {
        int runningSum = 0;
        int runningTotal = 0;
        int[] numbers = {a, b, c, d, e};

        for (int i = 0; i < numbers.length; i++) {
            if (Math.abs(numbers[i]) % 2 == 1){
                runningSum += numbers[i];
                // This is to increment the divisor to get the average
                runningTotal++;
            }
        }

        if (runningSum != 0){
            /* We have to typecast these as doubles otherwise it would truncate
             * the decimal even if the return type is a double.
             */
            return (double)runningSum / (double)runningTotal;
        } else return -1000; // This runs if no numbers are odd
    }

    /**
     * This method takes in the cost of a meal and provides the total with a tip
     * @param mealCost Subtotal of your meal before a tip. Must be greater than
     *                 zero
     * @param tip The percent in decimal form of the tip you want to leave. The
     *            tip must be equal or greater than 0% but many not be more than
     *            90%
     * @return Total cost of the meal including tip
     */
    public static double getTotalBill(int mealCost, double tip){
        if (mealCost <= 0 || (tip < 0 || tip > 0.90)) {
            // Returns if meal cost is less than zero or if tip is outside range
            return -1;
        }
        return mealCost * (1+tip);
    }

    /**
     * This method provides an answer to a quadratic inputted into the quadratic
     * formula. Since we can only return one value we will choose the larger of
     * the two values.
     * @param a The "a" value in a quadratic (ax^2, quadratic coefficient)
     * @param b The "b" value in a quadratic (bx, linear coefficient)
     * @param c The "c" value in a quadratic (c, constant)
     * @return The largest of the two values in a quadratic
     */
    public static double solveQuadratic(double a, double b, double c) {
        double radical = Math.sqrt(b * b - 4 * a * c);
        double divisor = 2 * a;
        double solutionPositive = (-b + radical) / divisor;
        double solutionNegative = (-b - radical) / divisor;

        return Math.max(solutionPositive, solutionNegative);
    }


    /**
     * This code tests your program's completeness.
     * @param args Ignored
     */
    public static void main(String[] args) {
        // Some lines in this method may be over 80 chars, but I chose to
        // do that to make it easier to comment out individual
        // tests. The course coding standards still apply to the code
        // that you write in the methods above

        int goodMethods = 0;

        clearCounts();
        countTest( minOfThree(1, 2, 3) == 1);
        countTest( minOfThree(1, 3, 2) == 1);
        countTest( minOfThree(3, 2, 1) == 1);
        countTest( minOfThree(4, -5, 3) == -5);
        countTest( minOfThree(5, 7, 0) == 0);
        countTest( minOfThree(-1, -2, -3) == -3);
        if(checkResults("minOfThree")) { goodMethods++; }

        clearCounts();
        countTest( reverseString("").equals(""));
        countTest( reverseString("abcde").equals("edcba"));
        countTest( reverseString("Hello, World!").equals("!dlroW ,olleH"));
        countTest( reverseString("!boj dooG").equals("Good job!"));
        if(checkResults("reverseString")) { goodMethods++; }

        // Uncomment these tests AFTER IMPLEMENTING isLetterOrDigit
         clearCounts();
         countTest( !isLetterOrDigit(' '));
         countTest( isLetterOrDigit('a'));
         countTest( isLetterOrDigit('M'));
         countTest( isLetterOrDigit('5'));
         countTest( !isLetterOrDigit('&'));
         countTest( !isLetterOrDigit('\t'));
         if(checkResults("isLetterOrDigit")) { goodMethods++; }

        // Uncomment these tests AFTER IMPLEMENTING getLettersAndDigits
         clearCounts();
         countTest( getLettersAndDigits("Hello 1234 %^&*").equals("Hello1234"));
         countTest( getLettersAndDigits("\\o/ yay! \\o/").equals("oyayo"));
         countTest( getLettersAndDigits("Look at that! We've seen 7 seas, see?").equals("LookatthatWeveseen7seassee"));
         countTest( getLettersAndDigits("\tSphinx of Black Quartz,\nJudge My Vow").equals("SphinxofBlackQuartzJudgeMyVow"));
         if(checkResults("getLettersAndDigits")) { goodMethods++; }

        // Uncomment these tests AFTER IMPLEMENTING isPalindromePhrase
         clearCounts();
         countTest( isPalindromePhrase(""));
         countTest( !isPalindromePhrase("bid"));
         countTest( !isPalindromePhrase("banana"));
         countTest( isPalindromePhrase("madam"));
         countTest( isPalindromePhrase("Madam"));
         countTest( isPalindromePhrase("racecar"));
         countTest( isPalindromePhrase("123 456 ABCCBA 654 321"));
         countTest( isPalindromePhrase("A man, a plan, a canal, Panama!"));
         countTest( isPalindromePhrase("\\o/ yay! \\o/"));
         countTest( isPalindromePhrase("So many dynamos!"));
         countTest( !isPalindromePhrase("Too many dynamos!"));
         countTest( !isPalindromePhrase("867-5309"));
         countTest( isPalindromePhrase("555-122-1555"));
         if(checkResults("isPalindromePhrase")) { goodMethods++; }

        clearCounts();
        countTest( averageOddNumbers(12, 13, 12, 13, 12) == 13.0);
        countTest( averageOddNumbers(-1, 3, -5, 7, 9) == 2.6);
        countTest( averageOddNumbers(-3, 7, 15, 0, -1) == 4.5);
        countTest( averageOddNumbers(100, -3, 402, -2, 10) == -3.0);
        countTest( averageOddNumbers(2, 0, 0, 0, -2) == -1000.0);
        if(checkResults("averageOddNumbers")) { goodMethods++; }

        // Uncomment these tests AFTER IMPLEMENTING getTotalBill
         clearCounts();
         countTest( getTotalBill(0, 0.3) == -1.0);
         countTest( getTotalBill(10, 0.25) == 12.5);
         countTest( getTotalBill(100, 0.5) == 150.0);
         countTest( getTotalBill(100, 0.9) == 190.0);
         countTest( getTotalBill(100, 0.91) == -1.0);
         countTest( getTotalBill(120, 0.32) == 158.4);
         if(checkResults("getTotalBill")) { goodMethods++; }

        // Uncomment these tests AFTER IMPLEMENTING solveQuadratics
         clearCounts();
         countTest( solveQuadratic(1, -1, -1) == 1.618033988749895);
         countTest( solveQuadratic(1, 2, 1) == -1.0);
         countTest( solveQuadratic(-2, 4, -2) == 1.0);
         countTest( solveQuadratic(1.234, 56.78, 90) == -1.6437886348704391);
         countTest( solveQuadratic(0.11, -0.22, 0.033) == 1.8366600265340756);
         if(checkResults("solveQuadratic")) { goodMethods++; }

        System.out.println();
        System.out.println(goodMethods + "/8 methods pass tests");
    }

}