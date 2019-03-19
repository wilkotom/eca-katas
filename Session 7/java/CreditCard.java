public class CreditCard {

    public static Boolean validate1(String ccnum) {
        int total = 0;
        for(int pos = ccnum.length()-1; pos>=0; pos-=2) {
            total += ccnum.charAt(pos) - '0';
        }
        for(int pos = ccnum.length()-2; pos>=0; pos-=2) {
            int val = (ccnum.charAt(pos) - '0') * 2;
            total += (val > 9) ? val-9 : val;
        }
        return (total % 10) == 0 && ccnum.length() > 0;
    }

    public static Boolean validate2(String ccnum) {
        int total = 0;
        if (ccnum.length() % 2 == 1) {
            ccnum = "0" + ccnum;
        }
        for(int pos=0; pos < ccnum.length(); pos++){
            int digit = Character.getNumericValue(ccnum.charAt(pos));
            total += digit;
            if (pos % 2 == 0){  
                total += digit - (digit < 5 ? 0 : 9);
            }
        }
        return (total % 10) == 0 && ccnum.length() > 0;
    }

    public static Boolean validate(String ccnum) {
        int total = 0;
        for(int pos=ccnum.length()-1; pos >=0 ; pos--){
            int digit = Character.getNumericValue(ccnum.charAt(pos));
            total += digit + (
                (pos % 2 != ccnum.length() % 2) ? 
                0 : digit - (digit < 5 ? 0 : 9));
        }
        return (total % 10) == 0 && ccnum.length() > 0;
    }
}

