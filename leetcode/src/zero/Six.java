package zero;

/**
 * Created by martin on 17-6-23.
 *
 */
public class Six {
    public String convert(String s, int numRows) {
        if(s.length()==0){
            return s;
        }
        if(numRows==1){
            return s;
        }
        boolean inval;
        int i = 0;
        int bias;
        StringBuilder res = new StringBuilder();
        while (i < numRows){
            boolean  jump = false;
            if(i == 0 || i == numRows - 1){
                inval = false;
                bias = numRows * 2 - 2;
            }else{
                inval = true;
                bias = numRows * 2 - 2 - 2 * i;
            }

            int interval = 2 * i;
            int j = i;
            while (j < s.length()){
                res.append(s.charAt(j));
                if(inval){
                    if(jump){
                        j = j + interval;
                        jump = false;
                    }else{
                        j = j + bias;
                        jump = true;
                    }
                }else{
                    j = j + bias;
                }
            }
            i++;
        }
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Six().convert("ABCD",4));
        System.out.println("PAYPALISHIRINGabc".length());
    }
}
