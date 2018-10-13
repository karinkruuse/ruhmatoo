public class Utilities {

    public static boolean isInt(String strNum) { // võtsime selle internetist, tundus lihtne ja loogiline

        boolean ret = true;
        try {
            Integer.parseInt(strNum);
        }
        catch (NumberFormatException e) {
            ret = false;
        }
        return ret;
    }

    public static void delay(int ms) {
        try {
            Thread.sleep(ms);
        }
        catch (InterruptedException e) { }
    }

}
