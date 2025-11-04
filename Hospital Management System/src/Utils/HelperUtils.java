package Utils;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.UUID;

public class HelperUtils {
    //Null Check Methods (Overloaded)
    public static boolean isNull(Object obj) {
        return obj == null;
    }

    public static boolean isNull(String str) {
        return str == null || str.isEmpty();
    }

    public static boolean isNotNull(Object obj) {
        return !isNull(obj);
    }

    public static boolean isNotNull(String str) {
        return !isNull(str);
    }

    //String Validation Methods (Overloaded)
    public static boolean isValidString(String str) {
        return str != null && !str.trim().isEmpty();
    }

    public static boolean isValidString(String str, int minLength) {
        return isValidString(str) && str.length() >= minLength;
    }

    public static boolean isValidString(String str, int minLength, int maxLength) {
        if (str != null && str.length() >= minLength && str.length() <= maxLength) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isValidString(String str, String regex) {
        return isValidString(str) && str.matches(regex);
    }

    //ID Generation Methods (Overloaded)
    public static String generateId() {
        return UUID.randomUUID().toString();
    }

    public static String generateId(String prefix) {
        return prefix + "-" + UUID.randomUUID().toString().substring(0, 5);
    }

    public static String generateId(String prefix, int length) {
        if (isNull(prefix)) {
            prefix = "ID";
        }

        if (length <= 0) {
            throw new IllegalArgumentException("Length must be greater than 0.");
        }
        String randomPart = UUID.randomUUID().toString().replace("-", "");
        while (randomPart.length() < length) {
            randomPart += UUID.randomUUID().toString().replace("-", "");
        }

        randomPart = randomPart.substring(0, length);

        return prefix + "-" + randomPart;
    }

    public static String generateId(String prefix, String suffix) {
        return prefix + "-" + UUID.randomUUID().toString().substring(0, 5) + "-" + suffix;
    }

    //Date Validation Methods (Overloaded)
    public static boolean isValidDate(Date date) {
        return date != null;
    }

    public static boolean isValidDate(String dateStr) {
        if (isNull(dateStr)) {
            return false;
        }
        try {
            LocalDate.parse(dateStr, DateTimeFormatter.ISO_DATE);
            return true;
        } catch (DateTimeException error) {
            return false;
        }
    }

    public static boolean isValidDate(Date date, Date minDate, Date maxDate) {
        if (date != null && (minDate == null || !date.before(minDate)) && (maxDate == null || !date.after(maxDate))) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isFutureDate(Date date) {
        Date today = new Date();
        if (date != null && date.after(today)) {
            return true;
        }
        return false;

    }

    public static boolean isPastDate(Date date) {
        Date today = new Date();
        if (date != null && date.before(today)) {
            return true;
        }
        return false;
    }

    public static boolean isToday(Date date) {
        Date today = new Date();
        if (date != null && date.equals(today)) {
            return true;
        }
        return false;
    }

    //Numeric Validation Methods (Overloaded)
    public static boolean isValidNumber(int num, int min, int max) {
        return num >= min && num <= max;
    }

    public static boolean isValidNumber(double num, double min, double max) {
        return num >= min && num <= max;
    }

    public static boolean isPositive(int num) {
        return num > 0;
    }

    public static boolean isPositive(double num) {
        return num > 0;
    }

    public static boolean isNegative(int num) {
        return num < 0;
    }

    public static boolean isNegative(double num) {
        return num < 0;
    }

    //Input Validation Methods (Overloaded)
    public static boolean isValidAge(int age) {
        return isValidNumber(age, 0, 150);
    }

    public static boolean isValidAge(LocalDate dateOfBirth) {
        if (dateOfBirth == null) {
            return false;
        }
        int age = LocalDate.now().getYear() - dateOfBirth.getYear();
        return isValidAge(age);
    }
}
