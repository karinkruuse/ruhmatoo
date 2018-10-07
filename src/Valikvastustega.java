import java.io.File;
import java.util.Scanner;

public class Valikvastustega implements Test{

    public static Scanner s = new Scanner(System.in);

    @Override
    public int küsiVastus(String küsimus) {

        int vastuseNr = s.nextInt();
        return vastuseNr;
    }

    @Override
    public String[] loeKüsimused(File fail, int küsimuseNr) {
        return new String[0];
    }
}
