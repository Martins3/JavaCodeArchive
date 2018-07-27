package four;

/**
 * Created by olddriver on 17-3-24.
 *
 */
public class SixtyOne {
    private int[] tobinary(int num){
        int[] bits=new int[32];
        int pos = 0;
        while(num!=0){
            bits[pos]=num%2;
            num=num/2;
            pos++;
        }
        return bits;
    }
    public int hammingDistance(int x, int y) {
        int diff=0;
        int[] bx=tobinary(x);
        int[] by=tobinary(y);
        for (int i = 0; i <bx.length ; i++) {
            if (bx[i]!=by[i]){
                diff++;
            }
        }
        return diff;
    }
    public static void main(String[] args) {
        SixtyOne f=new SixtyOne();
        System.out.println(f.hammingDistance(1,4));
    }
}
