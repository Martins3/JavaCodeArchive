package two;

/**
 * Created by olddriver on 17-3-25.
 * 可能和字串匹配问题有关系!!
 */
/**      //find out who're the symmertic
        //keep the endpoint then from then endpoint to the last should be added
        int end;
        int flag;
        int j;
        for (end = s.length()-1; end >0 ; end--) {
            j=end;
            flag=1;
            for (int i = 0; j-i>0 ; i++,j--) {
                if(s.charAt(i)!=s.charAt(j)){
                    flag=0;
                    break;
                }
            }
            if(flag==1)
                break;
        }

        //find the end point and continue add the frontier
        char[] front=new char[s.length()-end-1];
        for (int i = 0; i <front.length ; i++) {
            front[i]=s.charAt(s.length()-1-i);
        }

        return String.valueOf(front)+s;*/
public class Fourty {
    public String shortestPalindrome(String s) {
        return null;
    }

    public static void main(String[] args) {
        System.out.println("123456".charAt(1));
        Fourty f=new Fourty();
        System.out.println(f.shortestPalindrome("cbabcdef"));
    }
}
