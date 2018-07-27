package zero;

import java.util.HashMap;


/**
 * Created by olddriver on 17-4-8.
 *
 */
public class Three {
    public int lengthOfLongestSubstring(String s) {
        int res=0;
        int max=0;
        HashMap<Character,Integer> times=new HashMap<>();
        int left=0;
        int right=0; // right means the pos that haven't been checked!
        //if the charctor appear twice,then left keeps going right until
        while (left<s.length()&&right<s.length()){
            if(!times.containsKey(s.charAt(right))||times.get(s.charAt(right))==0){
                times.put(s.charAt(right),1);
                max=max+1;
                res=Math.max(res,max);
                right++;
            }else if(times.get(s.charAt(right))==1){ //find someone appear twice
                char cur=s.charAt(left);
                while (cur!=s.charAt(right)){
                    left++;
                    max--;
                    times.put(cur,0);
                    cur=s.charAt(left);
                }
                //we have found the char the same with the right
                right++; //move the right
                left++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int a=new Three().lengthOfLongestSubstring("abcabcbb");
        System.out.println(a);
    }
}
