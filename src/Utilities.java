// Siin klassis on meetodid, mis võivad üleüldiselt kasulikud olla, aga mis väga kuhugi ei sobi

import java.lang.Math;

public class Utilities {

    public static boolean isInt(String strNum) {

        boolean r = true;
        try {
            Integer.parseInt(strNum);
        }
        catch (NumberFormatException e) {
            r = false;
        }
        return r;
    }


    public static void delay(int ms) {
        // lugesin https://docs.oracle.com/javase/tutorial/essential/concurrency/sleep.html
        // usun, et antud juhul on Thread.sleep turvaline kasutada
        // Stack overflows oli keegi öelnud et see ei ole
        try {
            Thread.sleep(ms);
        }
        catch (InterruptedException e) { }
    }


    public static String[] shuffle(String[] segada) {


        for (int i = segada.length - 1; i > 0; i--)
        {
            int index = (int) Math.floor(Math.random()*(i+1));
            String a = segada[index];
            segada[index] = segada[i];
            segada[i] = a;
        }
        return segada;
    }

}
