/**
 * This assignment asks us to create ASCII Art of our name
 * @author Gabe Olivas
 */

public class AsciiArt {
    /**
     * Prints my name in ASCII Art to the console.
     * @param args Command - line arguments are ignored .
     */
    public static void main(String[] args) {
        /*
        I remember from Python using a triple quote allows you to use a single
        print statement (or in this case a System.out.println) for a multiline
        string
         */

        System.out.println(""" 
                 .d8888b.           888               888
                d88P  Y88b          888               888
                888    888          888               888
                888         8888b.  88888b.   .d88b.  888
                888  88888     "88b 888 "88b d8P  Y8b 888
                888    888 .d888888 888  888 88888888 Y8P
                Y88b  d88P 888  888 888 d88P Y8b.      "
                 "Y8888P88 "Y888888 88888P"   "Y8888  888
                
                         \\    /\\       /\\    /
                          )  ( ')     (' )  (
                         (  /  )       (  \\  )
                          \\(__)|       |(__)/
                """);
    }
}