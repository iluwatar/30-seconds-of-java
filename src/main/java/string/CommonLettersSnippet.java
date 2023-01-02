package string;

import java.util.HashSet;
import java.util.Set;

/**
 * CommonLettersSnippet.
 */
public class CommonLettersSnippet {
    /**
     * Find Common Characters inside given two strings
     *
     * @param firstStr
     * @param secondStr
     * @return Common Characters
     */
    public static String getCommonLetters(String firstStr, String secondStr) {
        Set<String> commonLetters = new HashSet<>();
        for (Character currentCharacter : firstStr.toCharArray()) {
            if (isCommonLetter(secondStr, currentCharacter)) {
                commonLetters.add(currentCharacter.toString());
            }
        }
        return String.join(" ", commonLetters);
    }

    private static boolean isCommonLetter(String secondStr, Character currentCharacter) {
        return secondStr.contains(currentCharacter.toString()) && Character.isLetter(currentCharacter);
    }
}
