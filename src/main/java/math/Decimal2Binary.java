import java.util.Scanner;
/** Binary to Decimal Conversion
 * Snippet
 */
public class Decimal2Binary {
    /**
     * reverse a string
     * @param str string
     * @return rev reversed string
     */
    public static String reverse(String str) {
        String rev="";
        for (int i = str.length()-1; i >= 0; i--) {
            char ch = str.charAt(i);
            rev += ch;
        }
        return rev;
    }

    /**
     * converts decimal to binary
     * @param n number
     */
    public static void decimalToBinary(int n) {
        int d;
        String dec="";
        while(n!=0) {
            d = n%2;
            dec += Integer.toString(d);
            n /= 2;
        }

        String binary = reverse(dec);
        System.out.println(binary);
    }
}
