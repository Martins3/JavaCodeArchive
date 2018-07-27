package six;

/**
 * Created by martin on 17-9-24.
 * 1. 大于号 小于号错位
 * 2.
 */
public class EightyOne {
    public static void main(String[] args) {
        EightyOne eo = new EightyOne();
        System.out.println(eo.nextClosestTime("01:32"));
    }
    public String nextClosestTime(String time) {
        int[] n = new int[]{time.charAt(0) - '0', time.charAt(1) - '0', time.charAt(3) - '0', time.charAt(4) - '0'};
        int[] res = new int[2];
        int max = 100000;
        int[] origin = new int[]{n[0] * 10 + n[1], n[2] * 10 + n[3]};
        for(int i:n){
            for(int j:n){
                for(int k:n){
                    for (int l:n){
                        int[] next = new int[]{10 * i + j, 10 * k + l};
                        if(vaild(next)){
                            int gap = cal(origin, next);
                            if(gap != 0 && gap < max){
                                max = gap;
                                res = next;
                            }
                        }
                    }
                }
            }
        }
        return makeString(res);
    }

    private static String makeString(int[] time){
        String h = time[0] <= 9 ? "0"+time[0] : "" + time[0];
        String m = time[1] <= 9 ? "0"+time[1] : "" + time[1];
        return h + ":" + m;
    }
    private static boolean vaild(int[] time){
        if(time[0] >23)
            return false;
        if(time[1] > 59)
            return false;
        return true;
    }
    private static int cal(int[] time, int[] next){
       int h1 = time[0];
       int m1 = time[1];

       int h2 = next[0];
       int m2 = next[1];

       if(h1 < h2){
           return m2 - m1 + (h2 - h1) * 60;
       }else if(h1 > h2){
           return (23 - h1)  * 60 + (60 - m1) + h2 * 60 + m2;
       }else{
           if(m1 < m2){
               return  m2 - m1;
           }else{
               return  24 * 60 + m1 - m2;
           }
       }
    }
}
