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


    private int mitmesKüsimus;
    private List<List<String>> küsimused;


    public VirtualFile(String textFail) throws Exception {
        File fail = new File(textFail);
        Scanner s = new Scanner(fail);
        String rida = "";
        int i = 0;

        while (s.hasNextLine()) {
            rida = s.next();
            küsimused.set(i, Arrays.asList(rida.split(":")));
            i++;
        }

        mitmesKüsimus = 0;
    }


    public List<String> getKüsimus(int küsimuseNr) {
        return küsimused.get(küsimuseNr-1);
    }


    public int getMitmesKüsimus(){
        return mitmesKüsimus;
    }
}