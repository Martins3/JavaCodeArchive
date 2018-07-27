package five;

/**
 * Created by martin on 17-9-29.
 * 1. 动态规划的时候仅仅是保存了 中间的计算值, 放置反复计算而已
 * 2. 非要使用 递归吗 ?
 *
 * 1. 长度理解错误, 数组越界
 * 2. 书写错误
 */
public class Sixteen {

    int[][] longest;
    String s;
    public int longestPalindromeSubseq(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        int len = s.length() - 1;
        longest = new int[len][len];
        this.s = s;
        return search(0, s.length() - 1);
    }

    private int search(int i, int j){
        if(longest[i][j] != 0)
            return longest[i][j];

        if(i == j){
            longest[i][j] = 1;
            return 1;
        }


        if(s.charAt(i) == s.charAt(j)){
            if(j - i == 1){
                longest[i][j] = 2;
                return 2;
            }

            longest[i][j] = search(i + 1, j - 1) + 2;
            return longest[i][j];
        }else{
            longest[i][j] = Math.max(search(i + 1, j), search(i, j - 1));
            return longest[i][j];
        }
    }
}
