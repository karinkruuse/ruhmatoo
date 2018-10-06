import java.util.Scanner;

public class Peaklass {

    public static Scanner s = new Scanner(System.in);

    public static void main(String args[]) {


        String[] testid = {"[0] Lõpeta!", "[1]", "[2]"};
        int test = 0;
        do {
            System.out.println("Millist testi soovite teha?");
            for (String elem: testid) {
                System.out.println(elem);
            }
            test = s.nextInt();

        } while(test != 0);

    }

    public static void testManager() {


    }


}
