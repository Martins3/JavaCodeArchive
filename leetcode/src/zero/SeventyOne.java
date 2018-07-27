package zero;

import one.SeventyNine;

import java.util.Stack;

/**
 * Created by olddriver on 17-4-3.
 * if(path.charAt(i)=='/'&&i!=path.length()-1&&path.charAt(i+1)!='/'){
 start=i;
 }
 */
public class SeventyOne {
    public String simplifyPath(String path) {
        int start=0;
        int end=0;
        Stack<String> S=new Stack<>();
        String paths=path.concat("/");
        for (int i = 0; i <paths.length() ; i++) {
            if(paths.charAt(i)=='/'){
                if(start!=end){
                    String m=paths.substring(start,end+1);
                    if(m.equals("/..")){
                       if(!S.isEmpty()){
                           S.pop();
                       }
                    }else if(!m.equals("/.")){
                        S.push(m);
                    }
                }
                start=i;
                end=i;
            }else {
                end++;
            }
        }
        Stack<String> res=new Stack<>();
        while (!S.isEmpty()){
            res.push(S.pop());
        }
        StringBuilder sb=new StringBuilder();
        while (!res.isEmpty()){
            sb.append(res.pop());
        }
        if(sb.length()==0){
            return "/";
        }else {
            return sb.toString();
        }
    }
    private SeventyOne(){
        System.out.println(simplifyPath("/."));
    }
    public static void main(String[] args) {
        new SeventyOne();
    }
}
