import java.util.Scanner;

/** Binary to Decimal Conversion
 * Snippet
 */
public class Binary2Decimal {
    /**
     * function to reverse a string
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
     * converts binary to decimal
     * @param n number
     */
    public static void binaryToDecimal(int n) {
        String s = reverse(Integer.toString(n));
        int decimal=0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(ch=='1') {
                decimal += Math.pow(2, i);
            }
        }
        System.out.println(decimal);
    }

    public static void main(String[] args) {
        System.out.println("Enter a Number: ");
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        binaryToDecimal(number);
    }
}
