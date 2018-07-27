package five;

/**
 * Created by martin on 17-4-23.
 *
 */
public class SixtyTwo {
    public int longestLine(int[][] M) {
        if(M.length==0) return 0;
        int max=0;
        int consec=0;

        int hang=M.length;
        int lie=M[0].length;
        // for the  row
        for (int i = 0; i <hang ; i++) {
            for (int j = 0; j <lie ; j++) {
                if(M[i][j]==1){
                    consec++;
                    max=Math.max(consec,max);
                }else {
                    consec=0;
                }
            }
            consec=0;
        }

        // for the column
        for (int i = 0; i <lie ; i++) {
            for (int j = 0; j <hang ; j++) {
                if(M[j][i]==1){
                    consec++;
                    max=Math.max(consec,max);
                }else {
                    consec=0;
                }
            }
            consec=0;
        }

        //for the  diagonal ,just left
        int sx;
        int sy;
        for(sx=0,sy=0;sy<lie;sy++){
            int cx=sx;
            int cy=sy;
            for (; cx<hang&&cy<lie; cx++,cy++) {
                if(M[cx][cy]==1){
                    consec++;
                    max=Math.max(consec,max);
                }else {
                    consec=0;
                }
            }
            consec=0;
            cx=sx;
            cy=sy;
            for (;cx<hang&&cy>=0  ; cx++,cy--) {
                if(M[cx][cy]==1){
                    consec++;
                    max=Math.max(consec,max);
                }else {
                    consec=0;
                }
            }
            consec=0;
        }

        //for the  diagonal ,just right
        for(sx=0,sy=0;sx<hang;sx++){
            int cx=sx;
            int cy=sy;
            for (; cx<hang&&cy<lie; cx++,cy++) {
                if(M[cx][cy]==1){
                    consec++;
                    max=Math.max(consec,max);
                }else {
                    consec=0;
                }
            }
            consec=0;
            cx=sx;
            cy=sy;
            for (; cy<lie&&cx>=0 ; cx--,cy++) {
                if(M[cx][cy]==1){
                    consec++;
                    max=Math.max(consec,max);
                }else {
                    consec=0;
                }
            }
            consec=0;
        }
        return max;
    }

    public static void main(String[] args) {
        int[][]M=new int[][]{
                {1,1,0,0,1,0,0,1,1,0},
                {1,0,0,1,0,1,1,1,1,1},
                {1,1,1,0,0,1,1,1,1,0},
                {0,1,1,1,0,1,1,1,1,1},
                {0,0,1,1,1,1,1,1,1,0},
                {1,1,1,1,1,1,0,1,1,1},
                {0,1,1,1,1,1,1,0,0,1},
                {1,1,1,1,1,0,0,1,1,1},
                {0,1,0,1,1,0,1,1,1,1},
                {1,1,1,0,1,0,1,1,1,1}
        };
        SixtyTwo s=new SixtyTwo();
        s.longestLine(M);
    }
}
