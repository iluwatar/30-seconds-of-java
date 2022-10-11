/* this program is use to convert string to number.  

for example 
  string1 is "12345" then using this function we get output as integer 12345. */
public class stringtoatoi {
    public int atoi(String str) {
        // Start typing your Java solution below
        // DO NOT write main() function
        // string start with -
        // string is overflow the Integer.MAX_VALUE
        if(str.length() == 0) return 0;
        
        int right = str.length() - 1;
        int res = 0;
        int digit = 1;
        
        if(right == 0){
            return str.charAt(right) - '0';
        }
        
        while(right >= 0){
            char c = str.charAt(right);
            //System.out.println(res);
            if(c == '+') {
                right--;
            } else if (c == '-'){
                res *= -1;
                right--;
            } else if (('0' <= c) && (c <= '9')) {
                //System.out.println(c);
                res += ((c - '0') * digit);
                digit *= 10;
                right--;
            } else {
                right--;
            }
        }
        
        return res;
    }
}
