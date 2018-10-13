import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;


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

        for (int i = 1; i < küsimus.length; i++) {
            System.out.println("[" + i + "] " + küsimus[i]);
        }

        // user input
        String vastus = "";
        do {
            vastus = s.nextLine();
        } while (!u.isInt(vastus));
        int vastusInt = Integer.parseInt(vastus);
        vastused.add(küsimuseNr-1, vastusInt);

    }


    public void genereeriSuvalineTulemus() {
        System.out.println(testiFail.suvalineTulemus());
    }


    public void genereeriTulemus() {

    }


    public int getPikkus() {
        return pikkus;
    }



}