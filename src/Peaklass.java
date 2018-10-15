import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Peaklass {

    public static Scanner s = new Scanner(System.in);
    public static Utilities u = new Utilities();

    
    public static void main(String args[]) throws Exception {


        List<String[]> testid = VirtualFile.testiNimed();  // [testi nimi, testi fail], [testi nimi2, testi fail2] ...

        // Siin algab nn game-loop
        while (true) {
            System.out.println("Millist testi soovite teha?");
            System.out.println("[0] Välju");
            for (String[] elem : testid) {  // Prindib testid välja
                System.out.print("[" + (testid.indexOf(elem) + 1) + "] ");
                System.out.println(elem[0] + "?");
            }

            int test = s.nextInt();
            if (test == 0) {
                break;
            }
            String nimi = testid.get(test - 1)[0];
            testManager(nimi);

            u.delay(1000);
            System.out.println("Kas soovite veel testi teha?\n[1] Jah\n[2] Ei");
            int vastus = s.nextInt();
            if (vastus  == 2) {
                break;
            }


        }

    }


    public static void testManager(String testiNimi) throws Exception {

        System.out.println("Valisite testi: " + testiNimi + "?");

        String failiNimi = testiNimi + ".txt";
        Test test = new Test(failiNimi);

        int pikkus = test.getPikkus();
        for (int i = 0; i < pikkus; i++) {
            test.küsi(i+1);
        }

        System.out.println(test.genereeriTulemus());
        u.delay(1000);



    }


}
