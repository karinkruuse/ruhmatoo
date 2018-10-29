import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.Writer;

//testide loomine
public class Lisa {

    static Scanner sc = new Scanner(System.in);
    static Utilities u = new Utilities();


    public static void lisaTest() throws Exception {
        int punktidearv = 0; // arvutab max punktide arvu, mis on võimalik testist saada (punktidearv ongi max punktide arv)
        int küsimustearv = 0; //vajalik tulemuse minimaalse punktisumma arvutamiseks

        System.out.println("Sisesta test nimi: ");
        String nimi = sc.nextLine();

        String failinimi = nimi.replace("?", "") + ".txt";
        File file = new File(failinimi);


        BufferedWriter output1 = new BufferedWriter(new FileWriter("nimed.txt", true));
        output1.newLine();
        output1.write(nimi); //lisab testi nime faili
        output1.close();


        BufferedWriter output2 = new BufferedWriter(new FileWriter(failinimi, true));
        //küsimuste lisamise loop
        while(true) {
            ArrayList<String> küsimuselist = new ArrayList<>(); //küsimuselist on txt failis see rida, kus küsimus ja vastused kirjas
            System.out.println("Sisesta küsimus/lõpetamiseks sisesta suvaline number: ");
            String küsimus = sc.nextLine();
            if (küsimus.length() == 1 && u.isInt(küsimus)) {
                break;
            }
            küsimustearv++;
            küsimuselist.add(küsimus);

            int i = 1;
            //vastuste lisamise loop
            while(true) {
                System.out.println("Sisesta " + i +" punkti andev vastus/lõpetamiseks sisesta suvaline number: ");
                String vastus = sc.nextLine();
                if (vastus.length() == 1 && u.isInt(vastus)) {
                    break;
                }
                küsimuselist.add(";" + vastus);
                i++;
            }
            punktidearv = punktidearv + i - 1;
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
        int aluminepiir = küsimustearv; //alumine piir antud tulemusele

        while(true) {
            System.out.println("Sisesta tulemuse punktisumma ülemine piir n (max n = " + punktidearv + ")");
            int üleminepiir = Integer.parseInt(sc.nextLine());

            System.out.println("Sisesta tulemus punktisummale " + aluminepiir + " - " + üleminepiir );
            String tulemus = sc.nextLine();

            //kirjutab faili tulemuse koos punktisumma vahemikuga
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
