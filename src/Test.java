import java.util.List;
import java.util.ArrayList;


class Test{

    private int pikkus;
    List<Integer> vastused = new ArrayList<>();
    Fail testiFail;

    public Test(String failiNimi) throws Exception {
        testiFail = new Fail(failiNimi);
        // pikkuse leidmine

    }


}