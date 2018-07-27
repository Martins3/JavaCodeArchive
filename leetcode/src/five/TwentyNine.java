package five;

import java.util.Stack;

/**
 * Created by martin on 17-9-27.
 * 1. 边界处理, y < board[0].length
 * 2. 边界处理分析错误, 应该是全部都是 &&
 * 3. 写成死循环, 因为没有处理对于被点击的项目需要设置为 'B'
 */
public class TwentyNine {

    public static void main(String[] args) {
        TwentyNine tn = new TwentyNine();
        tn.updateBoard(new char[][]{{'E', 'E', 'E', 'E', 'E'}, {'E', 'E', 'E', 'E', 'E'}, {'E', 'E', 'E', 'E', 'E'}, {'E', 'E', 'E', 'E', 'E'}, {'E', 'E', 'E', 'E', 'E'}, }, new int[]{3,0});
    }
    public char[][] updateBoard(char[][] board, int[] click) {
        int i = click[0];
        int j = click[1];
        if (board[i][j] == 'M') {
            board[i][j] = 'X';
            return board;
        }

        // 传播过程
        Stack<int[]> checkList = new Stack<>();
        checkList.add(click);
        while (!checkList.isEmpty()) {
            click = checkList.pop();
            i = click[0];
            j = click[1];
            int bombs = surroundingMine(board, i, j);
            if(bombs !=0){
                board[i][j] = (char)(bombs + '0');
            }else{
                int[] xs = new int[]{i - 1, i, i + 1};
                int[] ys = new int[]{j - 1, j, j + 1};
                for(int x: xs) {
                    for (int y : ys) {
                        if((x >= 0 && x < board.length) && (y >= 0 && y < board[0].length)){
                            // 对于 E
                            if(board[x][y] == 'E')
                                checkList.push(new int[]{x, y});
                        }
                    }
                }
                board[i][j] = 'B';
            }


        }
        return board;
    }

    private static int surroundingMine(char[][] board, int i, int j){
        // 边角的检查的
        int count = 0;
        int[] xs = new int[]{i - 1, i, i + 1};
        int[] ys = new int[]{j - 1, j, j + 1};
        for(int x: xs){
            for(int y:ys){
                if((x >= 0 && x < board.length) &&(y >= 0 && y < board[0].length)){
                    if(board[x][y] == 'M')
                        count ++;
                }
            }
        }
        return  count;
    }

}
