public class Test {
    public static final int NUMBER_LIM = 15;
    public static void main(String[] args) {
        for (int i = 0; i <= 10000; i++) {
            int randomNumber = (int) (Math.random() * NUMBER_LIM + 1);
            System.out.println(i + ": " + randomNumber);
            if (randomNumber == 16) { break;}
        }
    }
}
