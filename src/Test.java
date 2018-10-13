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

        List<String> list = new ArrayList<String>(Arrays.asList(küsimus));
        list.remove(küsimus[0]);
        küsimus = list.toArray(new String[0]);
        String[] segatud = u.shuffle(küsimus);


        for (int i = 0; i < küsimus.length; i++) {
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

        int punkte = Arrays.asList(küsimus).indexOf(segatud[vastus-1]) + 1;

        vastused.add(küsimuseNr-1, punkte);

    }


    public void genereeriSuvalineTulemus() {
        System.out.println("Tulemus: " + testiFail.suvalineTulemus() + "\n");
    }


    public String genereeriTulemus() {

        int summa = 0;
        for (int e : vastused) {
            summa += e;
        }

        System.out.println(summa);

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