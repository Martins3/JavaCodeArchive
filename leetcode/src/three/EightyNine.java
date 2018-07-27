package three;

/**
 * Created by olddriver on 17-4-15.
 *
 */
public class EightyNine {
    public char findTheDifference(String s, String t) {
        int []table=new int[26];
        for (int i = 0; i <s.length() ; i++) {
            table[s.charAt(i)-'a']++;
        }
        for (int i = 0; i <t.length() ; i++) {
            table[s.charAt(i)-'a']--;
        }
        for (int i = 0; i <table.length ; i++) {
            if(table[i]==-1) return (char)(i+'a');
        }
        return 'a';
    }
}
