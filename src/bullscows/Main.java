package bullscows;
import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please, enter the secret code's length:");
        int codeLength = scanner.nextInt();
        scanner.nextLine();
        while (codeLength > 10) {
            System.out.println("Error: can't generate a secret number with a length of 11 because there aren't enough unique digits.");
            System.out.println("Please enter a number not greater than 10:");
            codeLength = scanner.nextInt();
            scanner.nextLine();
        }
        String secretCode = generateRandomCode(codeLength);
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

    static String generateRandomCode(int length) {
        Random random = new Random();
        StringBuilder code = new StringBuilder();
        while (code.length() != length) {
            String num = String.valueOf(random.nextInt(10));
            if (!code.toString().contains(num)) {
                code.append(num);
            }
        }
        return code.toString();
    }
}