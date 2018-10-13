import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Peaklass {

    public static Scanner s = new Scanner(System.in);

    
    public static void main(String args[]) throws Exception {


        List<String[]> testid = Fail.testiNimed();  // [testi nimi, testi fail], [testi nimi2, testi fail2] ...

        // Siin algab nn game-loop
        while (true) {
            System.out.println("Millist testi soovite teha?");
            for (String[] elem : testid) {  // Prindib testid välja
                System.out.print("[" + (testid.indexOf(elem) + 1) + "] ");
                System.out.println(elem[0]);
            }

            int test = s.nextInt();
            if (test == 0) {
                break;
            }
            String nimi = testid.get(test - 1)[0];
            System.out.println(nimi);

        }

    }


    public static void testManager(int testiNr, String testiNimi) {

        // tuleb selgeks teha kas on kaküsimustega vms
        // vb see on juba varem selgeks tegtud, oleneb, kuidas me seda kategoriseerimist implementime
        // print(Alustasid seda testi)

        //

        // for (int i = 0; i < test.pikkus)



    }


}
