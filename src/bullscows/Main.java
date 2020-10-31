package bullscows;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int codeLength = 0;
        int numberOfSymbols = 0;
        try {
            System.out.println("Please, enter the secret code's length:");
            codeLength = scanner.nextInt();
        } catch (InputMismatchException exception) {
            System.out.println("Error: incorrect input.");
            System.exit(1);
        }
        try {
            System.out.println("Input the number of possible symbols in the code:");
            numberOfSymbols = scanner.nextInt();
        } catch (InputMismatchException exception) {
            System.out.println("Error: incorrect input.");
            System.exit(1);
        }
        scanner.nextLine();
        if (codeLength > 36) {
            System.out.println("Error: can't generate a secret number with a length of " + codeLength + " because there aren't enough unique digits.");
            System.exit(1);
        }
        if (numberOfSymbols > 36) {
            System.out.println("Error: maximum number of possible symbols in the code is 36 (0-9, a-z).");
            System.exit(1);
        }
        if (codeLength > numberOfSymbols || codeLength <= 0) {
            System.out.println("Error: it's not possible to generate a code with a length of 6 with 5 unique symbols.");
            System.exit(1);
        }
        String secretCode = generateSecretCode(codeLength, numberOfSymbols);
        System.out.print("The secret code is prepared: ");
        for (int i = 0; i < codeLength; i++) {
            System.out.print('*');
        }
        if (numberOfSymbols < 11) {
            System.out.print(" (0 - " + (numberOfSymbols - 1) + ")\n");
        } else {
            System.out.print(" (0 - 9) (" + (char) 97 + " - " + (char) (97 + numberOfSymbols - 11) + ")\n");
        }
        System.out.println("Okay, let's start a game!");
        int i = 1;
        System.out.println("Turn " + i + ":");
        String userCode = scanner.nextLine();
        while (!checkCode(secretCode, userCode, codeLength)) {
            i++;
            System.out.println("Turn " + i + ":");
            userCode = scanner.nextLine();
        }
        System.out.println("Congratulations! You guessed the secret code.");
    }

    static boolean checkCode(String secretCode, String userCode, int codeLength) {
        int numberOfBulls = 0;
        int numberOfCows = 0;
        for (int i = 0; i < secretCode.length(); i++) {
            if (secretCode.charAt(i) == userCode.charAt(i)) {
                numberOfBulls++;
            } else if ((secretCode.indexOf(userCode.charAt(i))) != -1) {
                numberOfCows++;
            }
        }
        if (numberOfBulls == codeLength) {
            printGrade(numberOfBulls, numberOfCows);
            return true;
        } else {
            printGrade(numberOfBulls, numberOfCows);
            return false;
        }
    }

    static void printGrade(int numberOfBulls, int numberOfCows) {
        if (numberOfBulls > 0 && numberOfCows > 0) {
            System.out.println("Grade: " + numberOfBulls + " bull(s) and " + numberOfCows + " cow(s).");
        } else if (numberOfBulls > 0 && numberOfCows == 0) {
            System.out.println("Grade: " + numberOfBulls + " bull(s).");
        } else if (numberOfBulls == 0 && numberOfCows > 0) {
            System.out.println("Grade: " + numberOfCows + " cow(s).");
        } else {
            System.out.println("Grade: None.");
        }
    }

    static String generateSecretCode(int length, int numberOfSymbols) {
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