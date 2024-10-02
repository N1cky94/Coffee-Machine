package machine;

import java.util.Scanner;

public class KeyboardUtil {
    private final static Scanner KEYBOARD = new Scanner(System.in);

    public static String askForString(String message) {
        System.out.println(message);
        return KEYBOARD.nextLine();
    }

    public static int askForInteger(String message) {
        return Integer.parseInt(askForString(message));
    }
}
