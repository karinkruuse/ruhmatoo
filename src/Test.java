import java.util.List;
import java.util.ArrayList;


class Test{

    private int pikkus;
    List<Integer> vastused = new ArrayList<>();
    VirtualFile testiFail;

    public Test(String failiNimi) throws Exception {
        testiFail = new VirtualFile(failiNimi);
        // pikkuse leidmine

    }

    public void esitaKüsimus(int küsimuseNr) {

    }


}