package three;

/**
 * Created by martin on 17-9-30.
 */
public class FortyFour {
    public String reverseString(String s) {
        if(s == null || s.length() == 0){
            return s;
        }
        char[] a = s.toCharArray();
        int i = 0;
        int j = a.length - 1;
        while (i < j){
            char c = a[i];
            a[i] = a[j];
            a[j] = c;
            i ++;
            j --;
        }
        return String.copyValueOf(a);
    }
}
