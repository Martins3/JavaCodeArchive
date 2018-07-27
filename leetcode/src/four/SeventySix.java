package four;

/**
 * Created by olddriver on 17-3-25.
 *
 */
public class SeventySix {
    public int findComplement(int num) {
        int[] bits=new int[31];
        int pos=0;
        while (num!=0){
            bits[pos++]=num%2;
            num=num/2;
        }
        int res=0;
        for (int i = 0; i <pos ; i++) {
            if(bits[i]==0) {
                res += Math.pow(2, i);
            }
        }
       return res;
    }

    public static void main(String[] args) {
        SeventySix s=new SeventySix();
        System.out.println(s.findComplement(5)+" "+s.findComplement(1));
    }

}
