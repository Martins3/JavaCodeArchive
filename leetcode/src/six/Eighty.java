package six;



/**
 * Created by martin on 17-9-18.
 */
public class Eighty {
    public static void main(String[] args) {
        Eighty a = new Eighty();
        boolean s= a.validPalindrome("deeee");
        System.out.println(s);

    }

    public boolean validPalindrome(String s) {
        if(s.length() == 0)
            return true;
        if(testPalidrome(s))
            return true;
        int a = 0;
        int b = s.length() - 1;
        while (a <= b){
            if(s.charAt(a) == s.charAt(b)){
                a ++ ;
                b -- ;
            }else{
                if(testPalidrome(s.substring(a, b)) || testPalidrome(s.substring(a + 1, b + 1))){
                    return true;
                }else {
                    return false;
                }
            }
        }
        return true;
    }
    private static boolean testPalidrome(String s){
        // string should be empty !
        for (int i = 0; i < s.length() / 2; i++) {
            if(s.charAt(i) != s.charAt(s.length() - 1 - i)){
                return false;
            }
        }
        return true;
    }
}
