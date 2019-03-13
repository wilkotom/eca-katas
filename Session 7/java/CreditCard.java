public class CreditCard {

    public static Boolean validate(String ccnum) {
        int total = 0;
        char[] digits = ccnum.toCharArray();
        for(int pos = digits.length-1; pos>=0; pos-=2) {
            total += digits[pos] - '0';
        }
        for(int pos = digits.length-2; pos>=0; pos-=2) {
            int val = (digits[pos] - '0') * 2;
            total += val > 9 ? val -9 : val;
        }
        return (total % 10) == 0 && digits.length > 0;
    }
}