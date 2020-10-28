package bullscows;
import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please, enter the secret code's length:");
        int codeLength = scanner.nextInt();
        System.out.println("Input the number of possible symbols in the code:");
        int numberOfSymbols = scanner.nextInt();
        scanner.nextLine();
        while (codeLength > 36) {
            System.out.println("Error: can't generate a secret number with a length of " + codeLength + " because there aren't enough unique digits.");
            System.out.println("Please enter a number not greater than 36:");
            codeLength = scanner.nextInt();
            scanner.nextLine();
        }
        String secretCode = generateRandomCode(codeLength, numberOfSymbols);
        System.out.print("The secret code is prepared: ");
        for (int i = 0; i < codeLength; i++) {
            System.out.print('*');
        }
        if (numberOfSymbols < 11) {
            System.out.print(" (0 - " + (numberOfSymbols - 1) + ")\n");
        } else {
            System.out.print(" (0 - 9) (" + (char) 97 + " - " + (char) (97 + numberOfSymbols - 11) + ")\n");
        }
        int i = 1;
        System.out.println("Okay, let's start a game!");
        System.out.println("Turn " + i + ":");
        String userCode = scanner.nextLine();
        while (!check(secretCode, userCode)) {
            i++;
            System.out.println("Turn " + i + ":");
            userCode = scanner.nextLine();
        }
        System.out.println("Congratulations! You guessed the secret code.");
    }

    static boolean check(String secretCode, String userCode) {
        int numberOfBulls = 0;
        int numberOfCows = 0;
        for (int i = 0; i < secretCode.length(); i++) {
            if (secretCode.charAt(i) == userCode.charAt(i)) {
                numberOfBulls++;
            } else if ((secretCode.indexOf(userCode.charAt(i))) != -1) {
                numberOfCows++;
            }
        }
        if (numberOfBulls > 0 && numberOfCows > 0) {
            System.out.println("Grade: " + numberOfBulls + " bull(s) and " + numberOfCows + " cow(s).");
            return false;
        } else if (numberOfBulls > 0 && numberOfCows == 0) {
            System.out.println("Grade: " + numberOfBulls + " bull(s).");
            return numberOfBulls == secretCode.length();
        } else if (numberOfBulls == 0 && numberOfCows > 0) {
            System.out.println("Grade: " + numberOfCows + " cow(s).");
            return false;
        } else {
            System.out.println("Grade: None.");
            return false;
        }
    }

    static String generateRandomCode(int length, int numberOfSymbols) {
        String chars = "0123456789abcdefghijklmnopqrstuvwxyz";
        Random random = new Random();
        StringBuilder code = new StringBuilder();
        while (code.length() != length) {
            int index = random.nextInt(numberOfSymbols);
            char digit = chars.charAt(index);
            if (!code.toString().contains(String.valueOf(digit))) {
                code.append(digit);
            }
        }
        return code.toString();
    }
}