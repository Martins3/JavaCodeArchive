package one;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by martin on 17-9-20.
 */
public class ThirtyNine {
    class Pair{
        /*
        * start and end are all included*/
        int start;
        int end;
        Pair(int start, int end){
            this.start = start;
            this.end = end;
        }

        public int getEnd() {
            return end;
        }

        public int getStart() {
            return start;
        }
    }
    public static void main(String[] args) {
        ThirtyNine tn = new ThirtyNine();
        LinkedList<String> s = new LinkedList<>();
        s.add("leet");
        s.add("code");
        tn.wordBreak("leetcode", s);


    }
    public boolean wordBreak(String s, List<String> wordDict) {
        return false;
    }

    private  List<Pair> getRange(String text, String word){
        LinkedList<Pair> rs = new LinkedList<>();
        for (int i = -1; (i = text.indexOf(word, i + 1)) != -1; i++) {
            rs.add(new Pair(i, word.length() - 1));
        }
        return rs;
    }
}
