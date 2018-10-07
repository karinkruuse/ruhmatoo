import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;

public class TxtKüsimusteks {


    public static ArrayList<String[]> testiNimed() throws Exception {

        File fail = new File("nimed.txt");
        Scanner s = new Scanner(fail);
        ArrayList<String[]> testideNimed = new ArrayList<>();

        int i  = 0;
        while(s.hasNextLine()) {
            i++;
            String[] test = s.nextLine().trim().split(":");
            test[0] = "[" + i + "] " + test[0];
            testideNimed.add(test);
        }
        return testideNimed;

    }



}
