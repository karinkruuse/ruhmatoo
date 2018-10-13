import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
import java.util.Arrays;

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
    private int pikkus;


    public VirtualFile(String textFail) throws Exception {
        File fail = new File(textFail);
        Scanner s = new Scanner(fail);
        String rida = "";
        int i = 0;

        while (s.hasNextLine()) {
            rida = s.nextLine().trim();
            küsimused.add(i, rida.split(":"));
            i++;
        }

        pikkus = i;
    }


    public String[] getKüsimus(int küsimuseNr) {
        return küsimused.get(küsimuseNr-1);
    }


    public int getPikkus() {
        return pikkus;
    }
}