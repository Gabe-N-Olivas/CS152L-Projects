/**
 * Class for playing with Lights Out puzzles.
 * @author Gabe Olivas
 */
public class LightsOutGame {

    /** Default number of rows in a puzzle. */
    public static final int DEFAULT_ROWS = 5;

    /** Default number of columns in a puzzle. */
    public static final int DEFAULT_COLS = 5;

    /** Character for light on in string representation. */
    public static final char LIGHT_ON = '*';

    /** Character for light off in string representation. */
    public static final char LIGHT_OFF = '-';

    /**
     * Create a lights out puzzle grid of given dimensions with all lights off.
     * @param rows Number of rows
     * @param cols Number of columns
     * @return 2D array of booleans with all values set to false.
     */
    public static boolean[][] createEmptyPuzzle(int rows, int cols) {
        return new boolean[rows][cols];
    }

    /**
     * Given a 2D array of booleans, how many rows does it have?
     * @param arr The array in question
     * @return The number of rows in the array.
     */
    public static int numRows(boolean[][] arr) {
        return arr.length;
    }

    /**
     * Given a 2D array of booleans, how many columns does it have?
     * @param arr The array in question
     * @return The number of columns in the array.
     */
    public static int numCols(boolean[][] arr) {
        // In the arrays created in our game there will be at least two keys
        // so returning the length of arr[0] should be a safe bet
        return arr[0].length;
    }

    /**
     * Creates a string representation of the game board.
     * Rows end with a newline character.
     * @param grid The grid of lights
     * @return String representation of the board
     */
    public static String gridToString(boolean[][] grid) {
        String output = "";
        for (int row = 0; row < numRows(grid); row++) {
            for (int col = 0; col < numCols(grid); col++) {
                if (!grid[row][col]) {
                    output += LIGHT_OFF;
                } else {
                    output += LIGHT_ON;
                }
            }
            output += "\n";
        }
        return output;
    }

    /**
     * Is this puzzle solved?
     * In other words, are all the lights off?
     * @param puzzle The puzzle grid
     * @return True if all lights are off, false if any are on.
     */
    public static boolean isPuzzleSolved(boolean[][] puzzle) {
        for (int row = 0; row < numRows(puzzle); row++) {
            for (int col = 0; col < numCols(puzzle); col++) {
                if (puzzle[row][col]) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Toggle the status of a single light, if possible.
     *
     * @param row  The row of the light location
     * @param col  The column of the light location
     * @param grid The game board
     * @return Turns light at location on if it was off and off it was on and
     *         returns true. Returns false without changing the board if the
     *         location was invalid.
     */
    public static boolean toggleSingleLight(int row, int col, boolean[][] grid){
            if ((row >= 0 && col >= 0) &&
                (row < numRows(grid) && col < numCols(grid))){
                grid[row][col] = !grid[row][col];
                return true;
            } else {
                return false;
            }
    }

    /**
     * Toggle the status of a light and its neighbors, if possible, and
     * return how many lights were toggled.
     *
     * @param row  The row of the light location
     * @param col  The column of the light location
     * @param puzzle The game board
     * @return Toggles on/off status of light and its vertical and horizontal
     *         neighbors and returns number of lights toggled. Returns 0 without
     *         changing the board if the location was invalid.
     */
    public static int toggleLightWithNeighbors(int row, int col, boolean[][] puzzle) {
        int lightsChanged = 0;
        if (toggleSingleLight(row, col, puzzle)){
            lightsChanged++;
            for (int numerator = 0; numerator < 4; numerator++) {
                // This for loop computes the output of cosine and sine of the
                // iteration*pi over 2 to get all four neighbors with a single
                // call of toggleSingleLight within the for loop
                int dX = (int)Math.cos((numerator * Math.PI) / 2);
                int dY = (int)Math.sin((numerator * Math.PI) / 2);
                if (toggleSingleLight(row + dX, col + dY, puzzle)) {
                    lightsChanged++;
                }
            }
        }
        return lightsChanged;
    }

    /**
     * Selects a random location on the board and toggles it with its neighbors.
     * @param board The game board.
     * @return Number of lights toggled
     */
    public static int toggleRandomLocationWithNeighbors(boolean[][] board) {
        int col = (int)(Math.random() * numCols(board));
        int row = (int)(Math.random() * numRows(board));
        return toggleLightWithNeighbors(row, col, board);
    }

    /**
     * Create a random solvable puzzle of desired size.
     *
     * To make a solvable puzzle, turn on lights by toggling a random location
     * with its neighbors. (The solution will be to toggle those same positions.)
     * Toggle roughly half the locations. (It's okay if you toggle the same place
     * more than once, undoing your earlier random toggle.)
     *
     * @param rows Number of rows
     * @param cols Number of columns
     * @return Game board with some lights turned on.
     */
    public static boolean[][] createRandomPuzzle(int rows, int cols) {
        boolean[][] puzzle = createEmptyPuzzle(rows, cols);
        // Calculates how many squares are on the board and divides by half
        // to find out how many to toggle
        for (int iterations = 0; iterations < (rows*cols)/2; iterations++) {
            toggleRandomLocationWithNeighbors(puzzle);
        }
        return puzzle;
    }

    /** Creates puzzle array and starts game GUI. */
    public static void main(String[] args) {
        boolean[][] b = createRandomPuzzle(DEFAULT_ROWS, DEFAULT_COLS);
        LightsOutGUI.showGUI(b);
    }
}
