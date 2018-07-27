package zero;

/**
 * Created by martin on 17-6-23.
 * 没有必要上升为dp,对于每一个位置仅仅搜索一次即可
 *
 */
public class Five {
    public String longestPalindrome(String s) {
        if(s==null){
            return null;
        }else if(s.length()==1){
            return s;
        }
        // the egde side handling 0 should only have even
        String res=null;
        int resLen = 0;
        int len = s.length();
        for (int i = 0; i < len ; i++) {
            // find the odd; be careful about the api of substring
            int left = i;
            int right = i;
            while (left >= 0 && right < len){
                if(s.charAt(left)==s.charAt(right)){
                    if(left==0 || right==(len-1)){
                        break;
                    }
                    left--;
                    right++;
                }else{
                    left++;
                    right--;
                    break;
                }
            }
            if(resLen < (right + 1 - left)){
                res = s.substring(left, right + 1);
                resLen = right + 1   - left;
            }
            // for the odd
            left = i;
            right = i + 1;
            while (left >= 0 && right < len){
                if(s.charAt(left)==s.charAt(right)){
                    if(left==0 || right==(len-1)){
                        break;
                    }
                    left--;
                    right++;
                }else{
                    left++;
                    right--;
                    break;
                }
            }
            if(resLen < (right + 1 - left) && right < len){
                res = s.substring(left, right + 1);
                resLen = right + 1 - left;
            }
        }
        return  res;
    }

    public static void main(String[] args) {
        String s = "12345";
       // System.out.println(s.substring(1,2));
        Five f= new Five();
        System.out.println(f.longestPalindrome(s));
        //System.out.println(s.substring(0,9));
    }
}
