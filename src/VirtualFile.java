import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
import java.lang.Math;

public class VirtualFile {


    public static List<String[]> testiNimed() throws Exception {

        File fail = new File("nimed.txt");
        Scanner sc = new Scanner(fail);
        List<String[]> testideNimed = new ArrayList<>();

        int i  = 0;
        while(sc.hasNextLine()) {
            i++;
            String[] test = sc.nextLine().trim().split(":");
            testideNimed.add(test);
        }
        sc.close();
        return testideNimed;

    }


    private List<String[]> küsimused = new ArrayList<>();
    private List<String> tulemused = new ArrayList<>();
    private int pikkus;
    private int tulemusteArv;


    public VirtualFile(String textFail) throws Exception {
        File fail = new File(textFail);
        Scanner s = new Scanner(fail);

        // küsimused
        String rida = "";
        int i = 0;
        while (s.hasNextLine()) {
            rida = s.nextLine().trim();
            if (rida.isEmpty()) { break; }
            küsimused.add(i, rida.split(";"));
            i++;
        }

        pikkus = i;

        while (s.hasNextLine()) {
            rida = s.nextLine().trim();
            tulemused.add(rida);
            i++;
        }

        tulemusteArv = i - pikkus;


    }


    public String[] getKüsimus(int küsimuseNr) {
        return küsimused.get(küsimuseNr-1);
    }


    public int getPikkus() {
        return pikkus;
    }

    public String suvalineTulemus() {
        int r = (int)Math.floor((Math.random() * tulemusteArv));
        return tulemused.get(r);
    }
}