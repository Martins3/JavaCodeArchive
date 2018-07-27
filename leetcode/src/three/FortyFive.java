package three;

import java.util.TreeSet;

/**
 * Created by martin on 17-9-30.
 * 1. 没有分析使用不含有所有的内容,直接跳过的情况
 * 2. 完全不分析就提交
 *
 */
public class FortyFive {
    public String reverseVowels(String s) {
        if(s == null || s.length() == 0){
            return s;
        }
        char[] vowel = new char[]{'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};
        TreeSet<Character> dic = new TreeSet<>();
        for(char c:vowel){
            dic.add(c);
        }
        int len = s.length();
        int i = 0;
        int j = len -1;
        char[] k = s.toCharArray();
        boolean noVowel = false;
        while (i < j){
            while (!dic.contains(k[i])) {
                i ++;
                if(i >= len) {
                    noVowel = true;
                    break;
                }
            }
            if(noVowel){
                break;
            }
            while (!dic.contains(k[j])) j --;

            if(i >= j) break;
            char t = k[i];
            k[i] = k[j];
            k[j] = t;
            i ++;
            j --;
        }
        return String.copyValueOf(k);
    }

    private FortyFive(){
        System.out.println(reverseVowels("hello"));
    }


    public static void main(String[] args) {
        new FortyFive();
    }
}
