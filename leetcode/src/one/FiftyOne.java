package one;

/**
 * Created by martin on 17-9-26.
 * 1. 没有出去中间的空格
 *
 */
public class FiftyOne {
    public static void main(String[] args) {
        FiftyOne fo = new FiftyOne();
        String s = fo.reverseWords("      fortheen b     asdfa d  ");
        System.out.println(s);
    }
    public String reverseWords(String s) {
        s = s.trim().replaceAll(" +", " ");
        String[] a = s.split(" ");
        StringBuilder res = new StringBuilder();
        for (int i = a.length - 1; i >= 0; i--) {
            res.append(a[i]);
            res.append(" ");
        }
        return res.toString().trim();
    }
}
