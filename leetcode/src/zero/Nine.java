package zero;

/**
 * Created by olddriver on 17-4-12.
 */
public class Nine {
    public boolean isPalindrome(int x) {
        if(x<0) return false;
        int weishu=0;
        int num=x;
        while (num!=0){
            num=num/10;
            weishu++;
        }
        int i=0;
        int j=weishu-1;
        while (i<=j){
            int a=x/(int)Math.pow(10,i);
            a=a%10;
            int b=x/(int)Math.pow(10,j);
            b=b%10;
            if(a!=b) return false;
            i++;
            j--;
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(new Nine().isPalindrome(12331));
    }
}
