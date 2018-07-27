package four;

import java.util.*;

/**
 * Created by martin on 17-9-27.
 */
public class FiftyOne {
    public static void main(String[] args) {
        FiftyOne fo = new FiftyOne();
        System.out.println(fo.frequencySort("aacaabbdfbb"));
    }
    public String frequencySort(String s) {
        TreeMap<Character, Integer> a = new TreeMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(a.containsKey(c)){
                a.put(c, a.get(c) + 1);
            }else{
                a.put(c, 1);
            }
        }

        TreeMap<Integer, Vector<Character>> frenquency = new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for(Map.Entry<Character, Integer> cf: a.entrySet()){
            Vector<Character> vector;
            Character c = cf.getKey();
            Integer i = cf.getValue();

            if(frenquency.containsKey(i)){
                vector = frenquency.get(i);
                vector.add(c);
                frenquency.put(i, vector);
            }else{
                vector = new Vector<>();
                vector.add(c);
                frenquency.put(i,vector);
            }
        }
        StringBuilder sb = new StringBuilder();
        for(Map.Entry<Integer, Vector<Character>> i: frenquency.entrySet()){
            for(char j:i.getValue()){
                for (int k = 0; k < i.getKey(); k++) {
                    sb.append(j);
                }
            }
        }
        return sb.toString();
    }
}
