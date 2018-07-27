package two;

/**
 * Created by olddriver on 17-4-8.
 *
 */
public class ThirtyOne {
    public boolean isPowerOfTwo(int n) {
        if(n<0) return false;
        int bits=0;
        String bitInt=Integer.toBinaryString(Math.abs(n));
        for (int i = 0; i <bitInt.length() ; i++) {
            if(bitInt.charAt(i)=='1') bits++;
        }
        return bits==1;
    }

    public static void main(String[] args) {
        System.out.println(new ThirtyOne().isPowerOfTwo(-2147483648));
        System.out.println(Integer.toBinaryString(-2147483648));

    }
}
