package five;

/**
 * Created by martin on 17-9-29.
 */
public class ThirtySeven {
    public static void main(String[] args) {
        ThirtySeven ts = new ThirtySeven();
        ts.resolve("12+123i");
    }
    class Complex{
         int x;
         int y;
         Complex(int x, int y){
             this.x = x;
             this.y = y;
         }
    }
    public String complexNumberMultiply(String a, String b) {
        return null;
    }


    private boolean isNum(char c){
        if(c >= '0' && c <='9')
            return true;
        return false;
    }


    private Complex resolve(String a){
        int r;
        int x;
        String[] rx = a.split("[+]", 0);
        if(isNum(rx[0].charAt(0))){
            r = Integer.parseInt(rx[0]);
        }else{
            // 我们认为第一个数字不会含有 +
            r =  - Integer.parseInt(rx[0].substring(1, rx[0].length()));

        }

        rx[1] = rx[1].substring(0, rx[1].length() - 1);
        if(isNum(rx[1].charAt(0))){
            x = Integer.parseInt(rx[1]);
        }else{
            // 我们认为第一个数字不会含有 +
            x =  - Integer.parseInt(rx[1].substring(1, rx[1].length()));
        }
        return new Complex(r, x);
    }

    private Complex Multiple(Complex a, Complex b){
        int r = a.x * b.x  - a.y * a.y;
        int s = a.x * b.y +  a.y * b.x;
        return new Complex(r, s);
    }
}
