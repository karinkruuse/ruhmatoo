import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.Writer;
import java.util.ArrayList;

public class Lisa {
    public static Scanner sc = new Scanner(System.in);

    private Scanner s;
    private File nimed, test;

    public static void lisaTest() {
        System.out.println("Sisesta test nimi: ");
        String nimi = sc.nextLine();

        output = new BufferedWriter(new FileWriter("nimed.txt", true));
        output.append(nimi);
        output.close;


        //lisab testi nime faili

        while(True) { // küsimuste lisamise loop
            ArrayList<String> küsimuselist = new ArrayList<String>;
            System.out.println("Sisesta küsimus/lõpetamiseks sisesta suvaline number: ");
            String küsimus = sc.nextString();
            if (küsimus.length() == 1 && küsimus.charAt(0).isDigit()) {
                break;
            }
            küsimuselist.add(küsimus);

            while(True) { //vastuste lisamise loop
                System.out.println("Sisesta vastus/lõpetamiseks sisesta suvaline number: ");
                String vastus = sc.nextString();
                if (vastus.length() == 1 && vastus.charAt(0).isDigit()) {
                    break;
                }
                küsimuselist.add(":" + vastus);
            }

            //lisab kusimuse faili

        }
    }
}

