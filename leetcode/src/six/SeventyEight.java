package six;

import java.util.Set;
import java.util.TreeSet;

/**
 * Created by martin on 17-9-19.
 */
public class SeventyEight {
    public boolean checkValidString(String s) {

        if(s.length() == 0)
            return true;
        Set<Integer> possible = new TreeSet<Integer>();
        Set<Integer> another;
        for (int i = 0; i < s.length() ; i++) {
            char c = s.charAt(i);
            int bias;
            if(c == '('){
                bias = 1;
            }else if(c == ')'){
                bias = -1;
            }else {
                bias = 2;
            }
            if(possible.isEmpty()){
                if(bias == 2){
                    possible.add(1);
                    possible.add(-1);
                    possible.add(0);
                }else{
                    possible.add(bias);
                }
            }else{
                another = new TreeSet<>();
                for(Integer p:possible){
                    if(p >= 0){
                        if(bias == 2){
                            another.add(p + 1);
                            another.add(p - 1);
                            another.add(p);
                        }else{
                        another.add(p + bias);
                        }
                    }
                }
                if(another.isEmpty()){
                    return false;
                }
                possible = another;
            }
        }
        for(Integer i:possible){
            if(i == 0){
                return true;
            }
        }
        return false;
    }
}
