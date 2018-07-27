package five;


import java.util.*;

/**
 * Created by olddriver on 17-4-2.
 *
 */
public class TwentyFour {
    public String findLongestWord(String s, List<String> d) {
        Collections.sort(d, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.length()-o1.length();
            }
        });


        ArrayList<String> lstring=new ArrayList<>();
        int length=0;
        for(String a:d){
            if(length>a.length()) break;
            int i=0;
            int j=0;
            while (i<a.length()&&j<s.length()){
                if(a.charAt(i)==s.charAt(j)){
                    i++;
                    j++;
                }else {
                    j++;
                }
            }
            if(j==s.length()&&i!=a.length()){
                continue;
            }
            length=a.length();
            lstring.add(a);
        }
        Collections.sort(lstring, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        if(lstring.size()==0){
            return "";
        }
        return lstring.get(0);
    }
    private void test(){
        ArrayList<String> a=new ArrayList<>(Arrays.asList(new String[]{"ale","apple","monkey","plea"}));
        String q=findLongestWord("abpcplea",a );
        System.out.println(q);
    }
    public static void main(String[] args) {
        new TwentyFour().test();
    }
}
