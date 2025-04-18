import java.util.Arrays;

/**
 * Class to test the Wordle methods separately.
 */
public class WordleTester {
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
        } else {
            // Uncomment next line of code to see which test(s) are failing,
            // but don't do it unless you are only failing a few
            //new Exception().printStackTrace(System.out);
        }
        totalTests++;
    }

    /** 
     * Print the testing results.
     * @param methodName The name of the method tested.
     */
    private static void printResults(String methodName) {
        String msg = "";
        if(correctTests < totalTests) {
            // I want failed tests to really jump out at you.
            msg = " INCORRECT!";
        }
        System.out.println("testing " + methodName + ": passes " +
                           correctTests + " of " + totalTests + " tests" + msg);
    }

    private static void testSelectRandomWord() {
        // Make a tiny dictionary
        String[] dictionary = { "foo", "bar", "baz", "qux", "quux" };
        testSelectRandomWord(dictionary, 10000);
        // two letter word list is also small enough for testing with more samples
        testSelectRandomWord(WordleDictionary.TWO_LETTER_WORDS, 100000);
        // Larger word lists may require more samples than we want to bother with
    }

    /**
     * Make sure each word is selected roughly the same number of times.
     * @param words Words to pick from
     * @param n Number of times to pick words
     */
    private static void testSelectRandomWord(String[] words, int n) {
        String[] dictionary = Arrays.copyOf(words, words.length);
        // Sort so I'll be able to use binarySearch
        Arrays.sort(dictionary);
        String[] dictionaryCopy = Arrays.copyOf(dictionary, dictionary.length);

        int[] counts = new int[dictionary.length];
        // Many times, choose a random word from this dictionary
        for (int i = 0; i < n; i++) {
            String word = Wordle.selectRandomWord(dictionary);
            // dictionary should not have changed
            countTest(Arrays.equals(dictionary, dictionaryCopy));
            // Word selected better be in the dictionary
            int index = word == null ? -1 : Arrays.binarySearch(dictionary, word);
            countTest(index >= 0);
            // Update a counter for each word when it appears
            if(index >= 0) { counts[index]++; }
        }
        // All words in the dictionary should appear with similar frequency        
        double expected = (double)n / dictionary.length;
        for (int i = 0; i < counts.length; i++) {
            countTest(counts[i] > expected * 0.9);
            countTest(counts[i] < expected * 1.1);
        }
    }

    private static void testIsKnownWord() {
        String[] dictionary = { "foo", "bar", "baz", "qux" };
        testKnownWords(dictionary, true, dictionary);
        testKnownWords(dictionary, false, new String[]{"boo", "bat", "qui"});

        testKnownWords(WordleDictionary.FIVE_LETTER_WORDS, true,
                       WordleDictionary.FIVE_LETTER_WORDS);
        testKnownWords(WordleDictionary.FIVE_LETTER_WORDS, false,
                       new String[] {"qwert", "abcde", "asdfg", "12345"});

        testKnownWords(WordleDictionary.TWO_LETTER_WORDS, true,
                       WordleDictionary.TWO_LETTER_WORDS);
        testKnownWords(WordleDictionary.TWO_LETTER_WORDS, false,
                       new String[]{"ab", "ek", "zz", "12", "hx", "oz"});
    }

    private static void testKnownWords(String[] dictionary,
                                       boolean expectedResult,
                                       String[] testWords) {
        String[] dictionaryCopy = Arrays.copyOf(dictionary, dictionary.length);

        for(String word : testWords) {
            countTest(Wordle.isKnownWord(dictionary, new String(word)) == expectedResult);
            // dictionary should not have changed
            countTest(Arrays.equals(dictionary, dictionaryCopy));
        }
    }

    private static void testGetGuessResult() {
        countTest(Arrays.equals("oo.X.".toCharArray(), Wordle.getGuessResult("glass", "sassy"))); // FAIL
        countTest(Arrays.equals("...XX".toCharArray(), Wordle.getGuessResult("those", "geese"))); // FAIL
        countTest(Arrays.equals("oo.oX".toCharArray(), Wordle.getGuessResult("dread", "added"))); // FAIL
        countTest(Arrays.equals("ooooo".toCharArray(), Wordle.getGuessResult("trade", "rated"))); // Pass
        countTest(Arrays.equals("...X..".toCharArray(), Wordle.getGuessResult("potato", "banana"))); // FAIL
        countTest(Arrays.equals("oo.".toCharArray(), Wordle.getGuessResult("car", "arm"))); // Pass
        countTest(Arrays.equals("oooo".toCharArray(), Wordle.getGuessResult("evil", "live"))); // Pass
        countTest(Arrays.equals("....".toCharArray(), Wordle.getGuessResult("evil", "doom"))); // Pass

        countTest(Arrays.equals("X.".toCharArray(), Wordle.getGuessResult("ah", "aa"))); // Pass
        countTest(Arrays.equals("oo".toCharArray(), Wordle.getGuessResult("ah", "ha"))); // Pass
        countTest(Arrays.equals("..".toCharArray(), Wordle.getGuessResult("ah", "ox"))); // Pass
    }

    private static void testIsWinning() {
        countTest(!Wordle.isWinning(".....".toCharArray()));
        countTest(!Wordle.isWinning(".........".toCharArray()));
        countTest(!Wordle.isWinning("XXXXX....".toCharArray()));
        countTest(!Wordle.isWinning("XoX.XoX.X".toCharArray()));
        countTest(!Wordle.isWinning("ooooo".toCharArray()));
        countTest(!Wordle.isWinning("oXoXoX".toCharArray()));
        countTest(!Wordle.isWinning("XXXoX".toCharArray()));
        countTest(!Wordle.isWinning("XXXX.".toCharArray()));
        countTest(!Wordle.isWinning(".XXXX".toCharArray()));
        countTest(Wordle.isWinning("XXXXX".toCharArray()));
        countTest(Wordle.isWinning("XXXXXXXXXXX".toCharArray()));
        countTest(Wordle.isWinning("XX".toCharArray()));
    }

    public static void main(String[] args) {
        clearCounts();
        testSelectRandomWord();
        printResults("selectRandomWord");

        clearCounts();
        testIsKnownWord();
        printResults("isKnownWord");

        clearCounts();
        testGetGuessResult();
        printResults("getGuessResult");

        clearCounts();
        testIsWinning();
        printResults("isWinning");
    }

}
