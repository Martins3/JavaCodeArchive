package five;

import java.util.HashSet;

/**
 * Created by martin on 17-9-30.
 * 虽然看过 hashset, 但是hashSet 的数值和treeSet 的性能到底如何 ?
 * 1. 不要无脑的粘贴, 首先观察中间的变化到底是什么 ?
 */
public class SixtySeven {
    public boolean checkInclusion(String s1, String s2) {
        // 宛如智障的检查
        if(s1 == null || s2 == null)
            return true;
        if(s2.length() < s1.length())
            return false;
        if(s1.length() == 0)
            return true;

        // 由于都是简单的lower case letters
        int[] target = new int[26];
        int[] res = new int[26];
        int i;
        for ( i = 0; i < s1.length(); i++) {
            target[s1.charAt(i) - 'a']++;
            res[s2.charAt(i) - 'a']++;
        }
        // 移动一次需要全部检查一次的吗 ?
        HashSet<Integer> uncompatiable = new HashSet<>();
        for (int j = 0; j < target.length; j++) {
            if(target[j] != res[j]){
                uncompatiable.add(j);
            }
        }

        if(uncompatiable.size() == 0){
            return true;
        }

        int dis = s1.length();
        for (; i < s2.length(); i++) { // 如果两者的长度相等, 那么就是直接进行跳过了
            int  added =  s2.charAt(i) - 'a';
            int  subtract = s2.charAt(i - dis) - 'a';

            boolean origin = target[added] == res[added];
            res[added] ++;
            boolean now = target[added] == res[added];
            if(now){
                // 现在, 那么之前一定就是错的
                uncompatiable.remove(added);
            }else{
                // 有可能之前是错的, 也有可能不是
                if(origin){
                    uncompatiable.add(added);
                }
            }

            origin = target[subtract] == res[subtract];
            res[subtract] --;
            now = target[subtract] == res[subtract];

            if(now){
                uncompatiable.remove(subtract);
            }else{
                if(origin){
                    uncompatiable.add(subtract);
                }
            }

            if(uncompatiable.size() == 0){
                return true;
            }
        }
        return false;
    }



    public static void main(String[] args) {
        SixtySeven ss = new SixtySeven();
        boolean s =ss.checkInclusion("ab", "cccab");
        System.out.println(s);
    }
}
