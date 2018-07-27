package six;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.SortedMap;
import java.util.TreeMap;

/**
 * Created by martin on 17-9-19.
 */
public class SeventySeven {
    class MapSum {
        TreeMap<String, Integer> kv;
        public MapSum() {
            kv = new TreeMap<>();
        }

        public void insert(String key, int val) {
            kv.put(key,val);
        }

        public int sum(String prefix) {
            int res = 0;
            SortedMap<String, Integer> s;
            if(prefix.length() == 0){
                s = kv;
            }else{
                 s = kv.subMap(prefix, true, next(prefix), false);
            }
            for(Integer i: s.values()){
                    res += i;
                }
            return res;
        }

        private String next(String s){
            if(s.length() == 1){
                return Character.toString((char)(s.charAt(0) + 1));
            }else {
                return s.substring(0, s.length() - 1) +  Character.toString((char)(s.charAt(s.length() - 1) + 1));
            }
        }
    }

    private void test(){
        MapSum a = new MapSum();
        a.insert("fortheen", 3);
        a.insert("b", 2);
        System.out.println(a.sum("fortheen"));
        a.insert("apple", 10);
        System.out.println(a.sum("ap"));
        System.out.println(a.next("asdfasdf"));

    }

    public static void main(String[] args) {
        SeventySeven ss = new SeventySeven();
        ss.test();
        String a ="";
        String b="1";
        System.out.println(a.compareTo(b));
    }
}
