import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;


class Test {

    public static Scanner s = new Scanner(System.in);
    public static Utilities u = new Utilities();

    private int pikkus;
    List<Integer> vastused = new ArrayList<>();
    VirtualFile testiFail;


    public Test(String failiNimi) throws Exception {
        testiFail = new VirtualFile(failiNimi);
        pikkus = testiFail.getPikkus();

    }


    public void küsi(int küsimuseNr) {

        // Küsimuse ja vastusevariantide väljastamine
        String[] küsimus = testiFail.getKüsimus(küsimuseNr);
        System.out.println(küsimus[0]);

        u.delay(500);

        List<String> list = new ArrayList<String>(Arrays.asList(küsimus));  // küsimuste list
        list.remove(küsimus[0]);  // esimene on küsimus
        String[] segatud = list.toArray(new String[0]);  // see on segamiseks list
        segatud = u.shuffle(segatud);  // siin toimbu päriselt segamine


        for (int i = 0; i < segatud.length; i++) {  // segatud list pinditakse
            System.out.println("[" + (i+1) + "] " + segatud[i]);
        }

        // user input
        int vastus = 0;
        while (true) {
            try {
                vastus = Integer.parseInt(s.nextLine());
                break;
            }
            catch (NumberFormatException e) {
                System.out.println("Palun sisestage vastusevariandi number!");
            }
        }

        int punkte = Arrays.asList(küsimus).indexOf(segatud[vastus-1]);
        // leitakse antud variandi asukohe algses listis ja seellest tuleneb saadav punktide arv

        vastused.add(küsimuseNr-1, punkte);

    }


    public void genereeriSuvalineTulemus() {
        System.out.println("Tulemus: " + testiFail.suvalineTulemus() + "\n");
    }


    public String genereeriTulemus() {

        int summa = 0;
        // Vastuste listi on küsimustest saadud punktid salvestatud ja nende summa järgi tuleb tulemus
        for (int e : vastused) {
            summa += e;
        }


        for (int i = 0; i < testiFail.getTulemusteArv(); i++) {
            if (summa >= testiFail.getVahemikAlampiir(i) && summa <= testiFail.getVahemikÜlempiir(i)) {
                return testiFail.getTulemus(i);
            }
        }

        return "";

    }


    public int getPikkus() {
        return pikkus;
    }

}