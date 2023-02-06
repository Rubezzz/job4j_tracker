package ru.job4j.early;

public class PasswordValidator {

    public static String validate(String password) {
        if (password == null) {
            throw new IllegalArgumentException("Password can't be null");
        }
        if (password.length() < 8 || password.length() > 32) {
            throw new IllegalArgumentException("Password should be length [8, 32]");
        }
        if (containsSubStr(password)) {
            throw new IllegalArgumentException("Password shouldn't contain substrings: qwerty, 12345, password, admin, user");
        }
        validateSymbols(password);
        return password;
    }

    private static void validateSymbols(String str) {
        boolean upperCase = false;
        boolean lowerCase = false;
        boolean number = false;
        boolean special = false;
        for (char symbol : str.toCharArray()) {
            if (!upperCase && Character.isUpperCase(symbol)) {
                upperCase = true;
            }
            if (!lowerCase && Character.isLowerCase(symbol)) {
                lowerCase = true;
            }
            if (!number && Character.isDigit(symbol)) {
                number = true;
            }
            if (!special && !Character.isDigit(symbol) && !Character.isAlphabetic(symbol)) {
                special = true;
            }
        }
        if (!upperCase) {
            throw new IllegalArgumentException("Password should contain at least one uppercase letter");
        }
        if (!lowerCase) {
            throw new IllegalArgumentException("Password should contain at least one lowercase letter");
        }
        if (!number) {
            throw new IllegalArgumentException("Password should contain at least one figure");
        }
        if (!special) {
            throw new IllegalArgumentException("Password should contain at least one special symbol");
        }
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
