package zero;

import three.TwentyFour;

import java.util.Stack;

/**
 * Created by olddriver on 17-4-3.
 *
 */
public class Twenty {
    public boolean isValid(String s) {
        if(s.length()==0) return true;
        Stack<Character> A=new Stack<>();
        for (int i = 0; i <s.length() ; i++) {
            char a=s.charAt(i);
            if(a=='('||a=='['||a=='{'){
                A.push(a);
            }else {
                if(A.size()==0) return false;
                char m=A.pop();
                if(a-m!=2&&a-m!=1) return false;
            }
        }
       return A.size()==0;
    }
    private Twenty(){
        int a='(';
        int b=')';
        System.out.println(a+" "+b);
        System.out.println(isValid("()"));
    }
    public static void main(String[] args) {
        new Twenty();
    }
}
