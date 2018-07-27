package five;

/**
 * Created by martin on 17-4-25.
 */
public class FiftyOne {
    public boolean checkRecord(String s) {
        int L=0;
        int A=0;
        for (int i = 0; i <s.length() ; i++) {
            if(s.charAt(i)=='L'){
                L++;
                if(L==3){
                    return false;
                }
            }else if(s.charAt(i)=='A'){
                A++;
                if(A==2){
                    return false;
                }
                L=0;
            }else {
                L=0;
            }
        }
        return true;
    }
}
