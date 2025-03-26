/**
 * This program uses DisplayWindow to display four pictures each in their own
 * quadrant. They are from left to right, top to bottom: a box, a spiral, a
 * circle on a circle, and a fancy drawing which I choose to be a cat.
 * @author Gabe Olivas
 */

public class PointPictures {
    /**
     * Creates four pictures using DisplayWindow
     * @param args Command-line arguments are ignored.
     */
    public static void main(String[] args) {
        DisplayWindow window = new DisplayWindow(3, 400);

        // Box Drawing

        // Placed in the top-left quadrant
        int boxX = 50;
        int boxY = 1;

        int boxDirection = 1;

        /*
        My solution for this wat to create two actions on for width, and
        another for height. Then I reversed the direction once the two
        are finished
        */

        for (int boxLoop = 0; boxLoop != 2; boxLoop++) {
            for (int i = 0; i < 100; i++) {
                window.addPoint(boxX += boxDirection, boxY);
                }
            for (int i = 0; i < 200; i++) {
                window.addPoint(boxX, boxY += boxDirection);
                }
            boxDirection *= -1;
            }

        // Spiral Drawing

        // I made this a double so that the subtraction increments can be >1
        double spiralRadius = 100;

        // Placed in the top-right quadrant
        int spiralX = 400;
        int spiralY = 100;

        double spiralAngle = 0.0;

        while (spiralRadius > 0) {
            window.addPoint(spiralX, spiralY);
            spiralAngle -= Math.toRadians(5);
            spiralRadius -= 0.5;

            // 300 and 100 represent the center x and center y respectively
            spiralX = (int)(spiralRadius * Math.cos(spiralAngle))+300;
            spiralY = (int)(spiralRadius * Math.sin(spiralAngle))+100;
        }

        // Circle on Circle Drawing

        int circleRadius = 100;
        int circleX;
        int circleY;
        boolean miniCircle = false;
        double circleAngle = 0.0;

        // Placed in the bottom-left quadrant
        int circleCenterX = 100;
        int circleCenterY = 300;

        do {
            /*
            We have to adjust the angle first or else the while statement will
            not be satisfied
             */
            circleAngle -= Math.toRadians(2);
            circleX = (int)(circleRadius * Math.cos(circleAngle))+circleCenterX;
            circleY = (int)(circleRadius * Math.sin(circleAngle))+circleCenterY;
            window.addPoint(circleX, circleY);

            /*
            This if statement runs when `circleX` reaches 0 which is where I
            want it to loop onto itself. for the mini-circle we have to change
            the `circleCenterX` to draw it. Once the mini-circle is drawn
            `circleX` will reach 0 again triggering the if statement and
            changing `circleRadius` and `circleCenterX` back to it's default
             */

            if (circleX == 0) {
                miniCircle = !miniCircle;
                if (miniCircle) {
                    circleRadius = 50;
                    circleCenterX = 50;
                } else {
                    circleRadius = 100;
                    circleCenterX = 100;
                }
            }
        } while (circleX != 200 || circleY != 300);

        // Fancy Drawing / Cat Drawing

        // Placed in the bottom-right quadrant
        int catX;
        int catY;

        double catAngle = 0.0;

        // Draws the Cat's Head
        while (catAngle < 2 * Math.PI) {
            catX = (int)(80 * Math.cos(catAngle)) + 300;
            catY = (int)(80 * Math.sin(catAngle)) + 300;
            catAngle += Math.toRadians(2);
            window.addPoint(catX, catY);
        }

        // Draws the Cat's Ears
        int catEarRun = 0;
        int catEarRise = 0;
        catX = 225;
        catY = 270;
        int catEarDirection = 1;

        /*
        This was the most efficient way I found to draw the ears. It could have
        been more efficient with a method call, but I don't know to construct
        one in Java. It works by constantly checking for the `catX` value and
        changing the rise and run of the drawing point. It also checks which
        direction `catEarRise` should be via `catEarDirection`
         */
        while (catX != 375 || catY != 270) {
            if (catX < 230 || (catX >= 370 && catEarDirection == -1)) {
                catEarRun = 1;
                catEarRise = -10*catEarDirection;
            }
            else if (catX < 260|| (catX < 370 && catEarDirection == -1)) {
                catEarRun = 3;
                catEarRise = catEarDirection;
            }

            /*
            This is the most essential part of this loop. It sets in place the
            jump in the point which draws the ears, and mirrors the rise so the
            right ear can be drawn. We then skip the rest to avoid assigning
            `catX` and `catY` a value other than what's in the `if` statement
            */

            if (catX == 260){
                catX = 340;
                catY = 230;
                catEarDirection = -1;
                continue;
            }

            catX += catEarRun;
            catY += catEarRise;
            window.addPoint(catX, catY);
        }

        // Draws cat's mouth

        /*
        This `for` loop draws three semicircles and is just an absolute function
        of `delta`. `delta` affects the centers of these semicircles by shifting
        `catX` by `delta` and catY by the function |delta-10|
         */
        for (int delta = 0; delta < 30; delta +=10) {
            catAngle = 0.0;
            while (catAngle <= Math.PI) {
                catX = (int) (10 * Math.cos(catAngle)) + 290 + delta;
                catY = (int) (10 * Math.sin(catAngle)) + 330-Math.abs(delta-10);
                catAngle += Math.toRadians(20);
                window.addPoint(catX, catY);
            }
        }

        // Draws cat's nose
        catAngle = 0.0;
        while (catAngle <= 2*Math.PI) {
            catX = (int) (5 * Math.cos(catAngle)) + 300;
            catY = (int) (5 * Math.sin(catAngle)) + 315;
            catAngle += Math.toRadians(20);
            window.addPoint(catX, catY);
        }

        // Draws the Cat's Eyes
        window.addPoint(270,280);
        window.addPoint(330,280);
    }
}