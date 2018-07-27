package two;

/**
 * Created by olddriver on 17-3-29.
 *
 */
public class Four {
    public int countPrimes(int n) {
       if(n<=2) return 0;
        boolean[] isPrime=new boolean[n]; //index means the number
        for (int i = 3; i <n ; i=i+2) {
            isPrime[i]=true;
        }
        isPrime[2]=true;
        for (int i = 0; i <Math.sqrt(n) ; i++) {
            if(isPrime[i]){
                for (int j = i*i; j <n ; j+=i*2) {
                    isPrime[j]=false;
                }
            }
        }
        int res=0;
        for (boolean b:isPrime){
            if(b) res++;
        }

        return res;
    }
    public static void main(String[] args) {
        System.out.println(new Four().countPrimes(3));
    }
}
