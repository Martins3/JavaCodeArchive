package two;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by olddriver on 17-3-31.
 *
 */
public class SeventyFour {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int index = 1;
        for (int i = citations.length-1; i >=0 ; i--,index++) {
            if(citations[i]<index){
                return index-1;
            }
        }
        return citations.length;

    }
    private void test(){
        int[] a=new int[]{10,8,5,4,3};
        int[] b=new int[]{25,8,5,3,3};
        int[] c=new int[]{3,0,6,1,5};
        System.out.println(hIndex(a));
        System.out.println(hIndex(b));
        System.out.println(hIndex(c));
    }
    public static void main(String[] args) {
        new SeventyFour().test();
    }
}
