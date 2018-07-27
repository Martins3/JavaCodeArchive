package zero;

import java.util.*;

public class FiftyOne {
    /**
     * https://leetcode.com/problems/n-queens/description/
     * Terminate: The first line exhaust
     * @param n Size
     * @return Possible permutation
     */
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new LinkedList<>();

        Stack<boolean []> noStanding = new Stack<>();
        int[] pos = new int[n];

        noStanding.push(new boolean[n]);
        Arrays.fill(pos, -1);
        int depth = 0;

        while (true){
            boolean[] occupy = noStanding.peek();

            boolean findPos = false;
            int thePos = -1;
            for (int i = pos[depth] + 1; i < n; i++) {
                if(!occupy[i]){
                    findPos = true;
                    thePos = i;
                    break;
                }
            }

            if(findPos){
                if(depth == n - 1){
                    // print the res and go up
                    LinkedList<String> oneRes = new LinkedList<>();
                    for (int i = 0; i < n; i++) {
                        char[] charArray = new char[n];
                        Arrays.fill(charArray, ' ');
                        charArray[pos[i]] = 'Q';
                        String str = new String(charArray);
                        oneRes.add(str);
                    }
                    res.add(oneRes);


                    noStanding.pop();
                    pos[depth] = 0;
                    depth --;
                    pos[depth] ++;
                }

                boolean[] newOccupy = new boolean[n];
                for (int i = 0; i < n; i++) {
                    int left = Math.max(0, i - 1);
                    int right = Math.min(n - 1, i + 1);
                    newOccupy[left] = newOccupy[right] = newOccupy[i] = true;
                    noStanding.push(newOccupy);
                }
                noStanding.push(newOccupy);

                pos[depth] = thePos;
                depth ++;
            }else{
                if(depth == 0){
                    break;
                }

                noStanding.pop();
                pos[depth] = -1;
                depth --;
                pos[depth] ++;
            }
        }
        return res;
    }
}
