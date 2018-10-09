import java.util.Scanner;
import java.util.ArrayList;

public class Peaklass {

    public static Scanner s = new Scanner(System.in);

    public static void main(String args[]) throws Exception {


        ArrayList<String[]> testid = TxtKüsimusteks.testiNimed();  // [testi nimi, testi fail], [testi nimi2, testi fail2] ...

        int test = 0;

        // Siin algab nn game-loop
        do {
            System.out.println("Millist testi soovite teha?");
            for (String[] elem: testid) {  // Prindib testid välja
                System.out.println(elem[0]);
            }

            test = s.nextInt();
            testManager(test);

        } while(test != 0);

    }

    public static void testManager(int testiNr) {

        if (testiNr == 0) {
            return;
        }

        // saab testi numbi, testi nimes peab olema see nr ehk ss avab testi "test" + testinr
        String test = "test" + testiNr + ".txt";
        System.out.println("Valisite testi " + test);


    }


}
