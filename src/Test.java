import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;


class Test {

    public static Scanner s = new Scanner(System.in);


    public static boolean isInt(String strNum) { // võtsime selle internetist, tundus lihtne ja loogiline

        boolean ret = true;
        try {
            Integer.parseInt(strNum);
        }
        catch (NumberFormatException e) {
            ret = false;
        }
        return ret;
    }


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

        // lugesin https://docs.oracle.com/javase/tutorial/essential/concurrency/sleep.html
        // usun, et antud juhul on Thread.sleep turvaline kasutada
        // Stack overflows oli keegi öelnud et see ei ole
        try { Thread.sleep(500); }
        catch (InterruptedException e) { }


        for (int i = 1; i < küsimus.length; i++) {
            System.out.println("[" + i + "] " + küsimus[i]);
        }

        // user input
        String vastus = "";
        do {
            vastus = s.nextLine();
        } while (!isInt(vastus));
        int vastusInt = Integer.parseInt(vastus);
        vastused.add(küsimuseNr-1, vastusInt);



    }


    public void genereeriTulemus() {
        System.out.println(testiFail.suvalineTulemus());
    }


    public int getPikkus() {
        return pikkus;
    }



}