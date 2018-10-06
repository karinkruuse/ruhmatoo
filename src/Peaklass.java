import java.util.Scanner;

public class Peaklass {

    public static Scanner s = new Scanner(System.in);

    public static void main(String args[]) {

        testManager();

    }

    public static void testManager() {

        String[] testid = {"[0] Lõpeta!", "[1]", "[2]"};

        System.out.println("Millist testi soovite teha?");
        for (String elem: testid) {
            System.out.println(elem);
        }
        int test = s.nextInt();

        while(test != 0) {
            test = s.nextInt();
            System.out.println("Millist testi soovite teha?");
        }

    }


}
