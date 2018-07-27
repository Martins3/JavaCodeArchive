package zero;

/**
 * Created by olddriver on 17-3-29.
 *
 */
public class Fifty {
    private double pos(double x,int n){
        if(n==0)return 1;
        if(n==1) return x;
        double a;
        if(n%2==1){
            a=pos(x,n/2);
            return a*a*x;
        }else {
            a=pos(x,n/2);
            return a*a;
        }
    }
    public double myPow(double x, int n) {
        if(n>0) return pos(x,n);
        return 1/pos(x,-n);
    }

    public static void main(String[] args) {
        System.out.println(new Fifty().myPow(12,3));
    }
}
