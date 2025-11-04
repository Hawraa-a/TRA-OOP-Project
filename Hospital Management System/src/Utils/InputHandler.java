package Utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class InputHandler {
    private static final Scanner scanner = new Scanner(System.in);
    private static final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public static String getStringInput(String prompt) {
        if (!HelperUtils.isNotNull(prompt)) {
            throw new IllegalArgumentException("Prompt cannot be null or empty.");
        }
        String input;
        while (true) {
            System.out.print(prompt);
            input = scanner.nextLine().trim();
            if (HelperUtils.isValidString(input)) {
                return input;
            }
            System.out.println("Input cannot be empty. Please try again.");
        }
    }

    public static Integer getIntInput(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();

            if (HelperUtils.isNull(input)) {
                System.out.println("Input cannot be empty. Please enter an integer.");
                continue;
            }
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
            }
        }
    }

    public static Integer getIntInput(String prompt, int min, int max) {
        while (true) {
            int input = getIntInput(prompt);
            if (HelperUtils.isValidNumber(input, min, max)) {
                return input;
            }
            System.out.println("Input must be between " + min + " and " + max + ".");
        }
    }

    public static Double getDoubleInput(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            if (HelperUtils.isNull(input)) {
                System.out.println("Input cannot be empty. Please enter a number.");
                continue;
            }
            try {
                return Double.parseDouble(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
    }

    public static LocalDate getDateInput(String prompt) {
        while (true) {
            System.out.print(prompt + " (yyyy-MM-dd): ");
            String input = scanner.nextLine().trim();
            if (!HelperUtils.isValidDate(input)) {
                System.out.println("Invalid date format. Please use yyyy-MM-dd.");
                continue;
            }
            try {
                return LocalDate.parse(input, dateFormatter);
            } catch (DateTimeParseException e) {
                System.out.println("Invalid date format. Please use yyyy-MM-dd.");
            }
        }
    }

    public static Boolean getConfirmation(String prompt) {
        while (true) {
            System.out.print(prompt + "  (true/false): ");
            String input = scanner.nextLine().trim().toLowerCase();
            if (HelperUtils.isNull(input)) {
                System.out.println("Please answer with 'true' or 'false'.");
                continue;
            }
            if (input.equals("true") || input.equals("t")) {
                return true;
            } else if (input.equals("false") || input.equals("f")) {
                return false;
            } else {
                System.out.println("Please answer with 'true' or 'false'.");
            }
        }
    }
}