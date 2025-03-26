/**
 * This is used for API documentation
 * It is also multiline compatible
 */

// This type of comment is ued for one line comments

/*
 * This is used for
 * multiline comments
 */

public class HelloWorld{
    public static void main(String[] args){
        System.out.println("Hello, world!");
//      System.out.println("Hello, again!");
//      Cmd+/ can comment out a line

//      Variables must have a data type declared in this instance x and y are "int" variables
        int x = 5;
        int y = x / 2;
        System.out.println("x is " + x);
        System.out.println("y is " + y); // Since we used an "int" type y wll be 2 rather than 2.5 because the decimal is truncated
        double z = x + .25; // double is a float data type which will allow you to use decimals
        System.out.println("z is " + z);
        int z_int = (int) z; // You can convert data types using "new_var = (data_type) variable"
        System.out.println("the integer value of z is " + z_int);

    }
}

/*
 *Most Java statements are followed by a semicolon
 *Some statements like if statements and loops, are not followed with a semicolon
 *Semicolons indicate that a command is over
 */

/*
 *Braces indicate a block of code like in a class, if, or loop
 *This is analogous to pythons indentations
 */

