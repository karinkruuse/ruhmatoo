import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Peaklass {

    public static Scanner s = new Scanner(System.in);

    
    public static void main(String args[]) throws Exception {


        List<String[]> testid = VirtualFile.testiNimed();  // [testi nimi, testi fail], [testi nimi2, testi fail2] ...

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
            testManager(test, nimi);

        }

    }


    public static void testManager(int testiNr, String testiNimi) throws Exception {

       System.out.println("Valisite tesit: " + testiNimi);

       String failiNimi = "test" + testiNr + ".txt";
       Test test = new Test(failiNimi);

       int pikkus = test.getPikkus();
       for (int i = 0; i < pikkus; i++) {
           test.küsi(i+1);
       }

       test.genereeriTulemus();
       System.out.println("Test tehtud!");
       try { Thread.sleep(1000); }
       catch (InterruptedException e) { }




    }


}
