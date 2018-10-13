import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
import java.util.Arrays;

public class Fail {



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


    private Scanner s;
    private File textFail;
    private int mitmesKüsimus;


    public Fail(String textFail) throws Exception {
        this.textFail = new File(textFail);
        mitmesKüsimus = 0;
        s = new Scanner(textFail);
    }


    public Fail(File textFail) throws Exception {
        this.textFail = textFail;
        mitmesKüsimus = 0;
        s = new Scanner(textFail);
    }


    public List<String> küsimus(int küsimuseNr) {
        String rida = "";
        for (int i = 0; i < küsimuseNr; i++) {
            rida = s.next();
        }
        List<String> küsimusVastusevariantidega = Arrays.asList(rida.split(":"));
        List<String> valmis = new ArrayList<>(küsimusVastusevariantidega);

        return valmis;
    }


    public int getMitmesKüsimus(){
        return mitmesKüsimus;
    }
}
