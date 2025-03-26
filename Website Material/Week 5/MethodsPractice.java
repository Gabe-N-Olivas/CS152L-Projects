/**
 * CS152 Lab 4 -- Welcome to Methods.
 *
 * Implement the methods described below with TODO comments
 *
 * Student name: YOUR NAME GOES HERE.
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

    // You have to implement the methods below


    /**
     * Returns smallest of its arguments.
     * @param x First argument
     * @param y Second argument
     * @param z Third argument
     * @return Minimum of x, y and z
     */
    public static int minOfThree( int x, int y, int z) {
        // TODO: implement this method

        // This is an obviously wrong return value
        // that exists only to allow the file to compile
        return 1000;
    }


    /**
     * Create a new string containing the characters of the
     * given string in reverse order.
     * @param s The string to reverse
     * @return Reversed string.
     */
    public static String reverseString(String s) {
        // TODO: REPLACE THE METHOD BODY

        return "something must be returned so this compiles";
    }


    // TODO: implement isLetterOrDigit as described in PDF

    // TODO: implement getLettersAndDigits as described in PDF

    // TODO: implement isPalindromePhrase as described in PDF


    /**
     * Average up to five odd numbers. Any even values are
     * not included in the average.
     * @param a First value
     * @param b Second value
     * @param c Third value
     * @param d Fourth value
     * @param e Fifth value
     * @return Average of the odd input values. If none are odd, returns -1000.
     */
    public static double averageOddNumbers( int a, int b, int c, int d, int e ) {
        // TODO: REPLACE THE METHOD BODY

        // Return a value to make the file compile
        return -4.2;
    }


    // TODO: implement getTotalBill as described in PDF

    // TODO: implement solveQuadratic as described in PDF


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
        // clearCounts();
        // countTest( !isLetterOrDigit(' '));
        // countTest( isLetterOrDigit('a'));
        // countTest( isLetterOrDigit('M'));
        // countTest( isLetterOrDigit('5'));
        // countTest( !isLetterOrDigit('&'));
        // countTest( !isLetterOrDigit('\t'));
        // if(checkResults("isLetterOrDigit")) { goodMethods++; }

        // Uncomment these tests AFTER IMPLEMENTING getLettersAndDigits
        // clearCounts();
        // countTest( getLettersAndDigits("Hello 1234 %^&*").equals("Hello1234"));
        // countTest( getLettersAndDigits("\\o/ yay! \\o/").equals("oyayo"));
        // countTest( getLettersAndDigits("Look at that! We've seen 7 seas, see?").equals("LookatthatWeveseen7seassee"));
        // countTest( getLettersAndDigits("\tSphinx of Black Quartz,\nJudge My Vow").equals("SphinxofBlackQuartzJudgeMyVow"));
        // if(checkResults("getLettersAndDigits")) { goodMethods++; }

        // Uncomment these tests AFTER IMPLEMENTING isPalindromePhrase
        // clearCounts();
        // countTest( isPalindromePhrase(""));
        // countTest( !isPalindromePhrase("bid"));
        // countTest( !isPalindromePhrase("banana"));
        // countTest( isPalindromePhrase("madam"));
        // countTest( isPalindromePhrase("Madam"));
        // countTest( isPalindromePhrase("racecar"));
        // countTest( isPalindromePhrase("123 456 ABCCBA 654 321"));
        // countTest( isPalindromePhrase("A man, a plan, a canal, Panama!"));
        // countTest( isPalindromePhrase("\\o/ yay! \\o/"));
        // countTest( isPalindromePhrase("So many dynamos!"));
        // countTest( !isPalindromePhrase("Too many dynamos!"));
        // countTest( !isPalindromePhrase("867-5309"));
        // countTest( isPalindromePhrase("555-122-1555"));
        // if(checkResults("isPalindromePhrase")) { goodMethods++; }

        clearCounts();
        countTest( averageOddNumbers(12, 13, 12, 13, 12) == 13.0);
        countTest( averageOddNumbers(-1, 3, -5, 7, 9) == 2.6);
        countTest( averageOddNumbers(-3, 7, 15, 0, -1) == 4.5);
        countTest( averageOddNumbers(100, -3, 402, -2, 10) == -3.0);
        countTest( averageOddNumbers(2, 0, 0, 0, -2) == -1000.0);
        if(checkResults("averageOddNumbers")) { goodMethods++; }

        // Uncomment these tests AFTER IMPLEMENTING getTotalBill
        // clearCounts();
        // countTest( getTotalBill(0, 0.3) == -1.0);
        // countTest( getTotalBill(10, 0.25) == 12.5);
        // countTest( getTotalBill(100, 0.5) == 150.0);
        // countTest( getTotalBill(100, 0.9) == 190.0);
        // countTest( getTotalBill(100, 0.91) == -1.0);
        // countTest( getTotalBill(120, 0.32) == 158.4);
        // if(checkResults("getTotalBill")) { goodMethods++; }

        // Uncomment these tests AFTER IMPLEMENTING solveQuadratic
        // clearCounts();
        // countTest( solveQuadratic(1, -1, -1) == 1.618033988749895);
        // countTest( solveQuadratic(1, 2, 1) == -1.0);
        // countTest( solveQuadratic(-2, 4, -2) == 1.0);
        // countTest( solveQuadratic(1.234, 56.78, 90) == -1.6437886348704391);
        // countTest( solveQuadratic(0.11, -0.22, 0.033) == 1.8366600265340756);
        // if(checkResults("solveQuadratic")) { goodMethods++; }

        System.out.println();
        System.out.println(goodMethods + "/8 methods pass tests");
    }

}
