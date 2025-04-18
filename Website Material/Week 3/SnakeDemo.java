
public class SnakeDemo {
    /** Constant for how many pixels wide we'll draw the points */
    private static final int POINT_SIZE = 5;
    /** How many points will be in the trace initially. */
    private static final int TRACE_LENGTH = 100;

    public static void main(String[] args) {
        // Create new display object
        DisplayWindow panel = new DisplayWindow(POINT_SIZE, TRACE_LENGTH);

        // Points snake back and forth, switching direction on alternate rows
        for (int y = 0; y < panel.getHeight(); y += POINT_SIZE) {

            if (y / POINT_SIZE % 2 == 0) {
                // moving from left to right
                for (int x = 0; x < panel.getWidth(); x += POINT_SIZE) {
                    panel.addPoint(x, y);
                }
            } else {
                // moving from right to left
                for (int x = panel.getWidth(); x >= 0; x -= POINT_SIZE) {
                    panel.addPoint(x, y);
                }
            }

        }
    }
}
