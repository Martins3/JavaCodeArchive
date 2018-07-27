package three;

import java.util.Stack;

/**
 * Created by olddriver on 17-4-12.
 * 为什么会有默认都是个位数的
 */
public class ThirtyOne {
    public boolean isValidSerialization(String order) {
        if(order.equals("#")) return true;
        String preorder=order.concat(",");
        Stack<String> S=new Stack<>();
        int start=0;
        int end=0;
        String sub;
        while (end<preorder.length()){
            if(preorder.charAt(end)==','){
                sub=preorder.substring(start,end);
                if(sub.equals("#")){
                    if(S.isEmpty()){
                      break;
                    }else {
                        S.pop();
                    }
                }else {
                    S.push(sub);
                }
                end++;
                start=end;
            }else {
                end++;
            }
        }
        System.out.println(end);
        System.out.println(preorder.length());
        return end==preorder.length()-1&&S.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(new ThirtyOne().isValidSerialization("1,2,3,4 ,5,#,#,#,#,#,#"));
    }
}
