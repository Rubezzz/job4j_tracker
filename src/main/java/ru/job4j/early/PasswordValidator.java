package ru.job4j.early;

public class PasswordValidator {

    public static String validate(String password) {
        if (password == null) {
            throw new IllegalArgumentException("Password can't be null");
        }
        if (password.length() < 8 || password.length() > 32) {
            throw new IllegalArgumentException("Password should be length [8, 32]");
        }
        if (!upperCaseIsThere(password)) {
            throw new IllegalArgumentException("Password should contain at least one uppercase letter");
        }
        if (!lowerCaseIsThere(password)) {
            throw new IllegalArgumentException("Password should contain at least one lowercase letter");
        }
        if (!numberIsThere(password)) {
            throw new IllegalArgumentException("Password should contain at least one figure");
        }
        if (!specialIsThere(password)) {
            throw new IllegalArgumentException("Password should contain at least one special symbol");
        }
        if (containsSubStr(password)) {
            throw new IllegalArgumentException("Password shouldn't contain substrings: qwerty, 12345, password, admin, user");
        }
        return password;
    }

    public static boolean upperCaseIsThere(String str) {
        for (char symbol : str.toCharArray()) {
            if (Character.isUpperCase(symbol)) {
                return true;
            }
        }
        return false;
    }

    public static boolean lowerCaseIsThere(String str) {
        for (char symbol : str.toCharArray()) {
            if (Character.isLowerCase(symbol)) {
                return true;
            }
        }
        return false;
    }

    public static boolean numberIsThere(String str) {
        for (char symbol : str.toCharArray()) {
            if (Character.isDigit(symbol)) {
                return true;
            }
        }
        return false;
    }

    public static boolean specialIsThere(String str) {
        for (char symbol : str.toCharArray()) {
            if (!Character.isDigit(symbol) && !Character.isAlphabetic(symbol)) {
                return true;
            }
        }
        return false;
    }

    public static boolean containsSubStr(String str) {
        String[] subStrings = {"qwerty", "12345", "password", "admin", "user"};
        for (String subString : subStrings) {
            if (str.toLowerCase().contains(subString)) {
                return true;
            }
        }
        return false;
    }
}
