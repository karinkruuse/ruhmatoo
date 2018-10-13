// Siin klasssis on meetodid, mis võivad üleüldiselt kasulikud olla, aga mis väga kuhugi ei sobi

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

}
