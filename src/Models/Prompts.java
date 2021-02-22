package Models;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Prompts {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static int promptForInt(int min, int max, String prompt) {
        if (min > max) {
            throw new IllegalArgumentException("The min cannot be greater than the max. min: " + min + ", max: " + max);
        }
        int userNum = -1;
        String input;
        boolean isInvalid = true;
        do {
            System.out.print(prompt);
            try {
                input = reader.readLine();
                userNum = Integer.parseInt(input);
                isInvalid = userNum < min || userNum > max;
            } catch (IOException ioe) {
                System.out.println("Whoa! Something technical went wrong. Let's try that again.");
            } catch (NumberFormatException nfe) {
                System.out.println("\n\nPlease enter a value\n\n");
            }
            if (isInvalid) {
                System.out.println("You entered an invalid value. Please, try again.");
            }
        } while (isInvalid);
        return userNum;
    }

    public static String promptForText(String prompt) {
        String userText = null;
        boolean isInvalid = true;
        do {
            System.out.print(prompt);
            try {
                userText = reader.readLine();
                isInvalid = (userText.isBlank()) || userText.toLowerCase().contains("the null") || (userText.replaceAll("\\s+", "").length() == 0);
            } catch (IOException ioe) {
                System.out.println("Whoa! Something technical went wrong. Let's try that again.");
            } catch (NumberFormatException nfe) {
                System.out.println("\n\nPlease enter a value\n\n");
            }
            if (isInvalid) {
                System.out.println("You entered an invalid value. Please, try again.");
            }
        } while (isInvalid);
        return userText;
    }
}
