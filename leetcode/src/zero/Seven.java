package zero;

/**
 * Created by martin on 17-6-23.
 *
 */
public class Seven {
    public int reverse(int x) {
        StringBuilder s = new StringBuilder(String.valueOf(x));

        String str;
        if(x>=0){
            str = s.reverse().toString();
        }else{
            s = s.delete(0,1);
            s = s.reverse();
            s.insert(0,"-");
            str = s.toString();
        }
        Integer a;
        try
        {
            a = new Integer(str);
        }
        catch (NumberFormatException e‏)
        {
            a = 0;
        }

        return a;
    }
    public static void main(String[] args) {
        System.out.println(new Seven().reverse(-1));
    }
}
