import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.Writer;

public class Lisa {
    static Scanner sc = new Scanner(System.in);
    static Utilities u = new Utilities();
    

    public static void lisaTest() throws Exception {
        int punktidearv = 0;

        System.out.println("Sisesta test nimi: ");
        String nimi = sc.nextLine();

        String failinimi = nimi.replace("?", "") + ".txt";
        File file = new File(failinimi);


        BufferedWriter output1 = new BufferedWriter(new FileWriter("nimed.txt", true));
        output1.newLine();
        output1.write(nimi); //lisab testi nime faili
        output1.close();


        BufferedWriter output2 = new BufferedWriter(new FileWriter(failinimi, true));
        while(true) { // küsimuste lisamise loop
            ArrayList<String> küsimuselist = new ArrayList<>();
            System.out.println("Sisesta küsimus/lõpetamiseks sisesta suvaline number: ");
            String küsimus = sc.nextLine();
            if (küsimus.length() == 1 && u.isInt(küsimus)) {
                break;
            }
            küsimuselist.add(küsimus);

            int i = 0;
            while(true) { //vastuste lisamise loop
                System.out.println("Sisesta " + i +" punkti andev vastus/lõpetamiseks sisesta suvaline number: ");
                String vastus = sc.nextLine();
                if (vastus.length() == 1 && u.isInt(vastus)) {
                    break;
                }
                küsimuselist.add(";" + vastus);
                i++;
            }
            punktidearv = punktidearv + i;
            StringBuilder koguküsimus = new StringBuilder();
            for (String s : küsimuselist) {
                koguküsimus.append(s);
            }

            output2.write(koguküsimus.toString());
            output2.newLine();
        }
        output2.newLine();
        output2.close();

        //tulemuste lisamine
        int aluminepiir = 0;
        int üleminepiir = 0;

        while(true) {
            System.out.println("Sisesta tulemuse punktisumma ülemine piir n (tulemus punktisummale "
                    + aluminepiir + " - " + üleminepiir +"); max n = " + punktidearv);
            üleminepiir = sc.nextInt();

            System.out.println("Sisesta tulemus:" );
            String tulemus = sc.nextLine();

            BufferedWriter output3 = new BufferedWriter(new FileWriter(failinimi, true));
            output3.write(tulemus +";"+ aluminepiir + ";" + üleminepiir);
            output3.newLine();
            output3.close();

            aluminepiir = üleminepiir+1;

            if (üleminepiir == punktidearv) {
                break;
            }
        }
    }
}

