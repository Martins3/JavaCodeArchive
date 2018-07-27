package one;

import java.util.*;

/**
 * Created by olddriver on 17-3-27.
 *
 */
public class SeventyNine {

    public String largestNumber(int[] nums) {
        int edge=0;
        for(int a:nums){
            if(a!=0){
                edge=1;
                break;
            }
        }
        if(edge==1){
            List<Integer> l=new ArrayList<>();
            for (int a:nums){
                l.add(a);
            }
            Collections.sort(l, new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    String a=o1.toString();
                    String b=o2.toString();
                    int minLen=Math.min(a.length(),b.length());
                    for (int i = 0; i <minLen ; i++) {
                        if(a.charAt(i)>b.charAt(i)){
                            return -1;
                        }else if(a.charAt(i)<b.charAt(i)){
                            return 1;
                        }
                    }
                    if(a.length()==b.length()) return 0;
                    String B;
                    String A;
                    int flag=1;
                    if(a.length()<b.length()){
                        A=a;
                        B=b.substring(minLen);
                    }else {
                        A=b;
                        B=a.substring(minLen);
                        flag=-1;
                    }
                    String AB=A.concat(B);
                    String BA=B.concat(A);
                    return BA.compareTo(AB)*flag;
                }
            });
            StringBuilder res=new StringBuilder();
            for (Integer a:l){
                res.append(a);
            }
            return res.toString();
        }else {
            return "0";
        }
    }

    public static void main(String[] args) {
        SeventyNine s=new SeventyNine();
        System.out.println(s.largestNumber(new int[]{12,128}));
    }
}
