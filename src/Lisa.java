import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.Writer;
import java.util.ArrayList;

public class Lisa {
    static Scanner sc = new Scanner(System.in);
    static Utilities u = new Utilities();

    public static void lisaTest() throws Exception {
        System.out.println("Sisesta test nimi: ");
        String nimi = sc.next();

        Writer output1 = new BufferedWriter(new FileWriter("nimed.txt"));
        output1.write(nimi); //lisab testi nime faili
        output1.close();

        while(true) { // küsimuste lisamise loop
            ArrayList<String> küsimuselist = new ArrayList<>();
            System.out.println("Sisesta küsimus/lõpetamiseks sisesta suvaline number: ");
            String küsimus = sc.next();
            if (küsimus.length() == 1 && u.isInt(küsimus)) {
                break;
            }
            küsimuselist.add(küsimus);

            while(true) { //vastuste lisamise loop
                System.out.println("Sisesta vastus/lõpetamiseks sisesta suvaline number: ");
                String vastus = sc.next();
                if (vastus.length() == 1 && u.isInt(vastus)) {
                    break;
                }
                küsimuselist.add(";" + vastus);
            }
            StringBuilder koguküsimus = new StringBuilder();
            for (String s : küsimuselist) {
                koguküsimus.append(s);
            }

            Writer output2 = new BufferedWriter(new FileWriter("test.txt"));
            output2.write(koguküsimus.toString());
            output2.close();

        }
    }
}

