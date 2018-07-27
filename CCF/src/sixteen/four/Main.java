package sixteen.four;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException, URISyntaxException {
        Main main = new Main();
        main.two();
    }

    private void one() throws URISyntaxException, FileNotFoundException {
        URL url = Main.class.getResource("input.txt");
        File file = new File(url.toURI());
        Scanner in = new Scanner(file); // submit , just change to System.in

        int size = in.nextInt();
        int[] sells = new int[size];

        for (int i = 0; i < sells.length; i++) {
           sells[i] = in.nextInt();
        }

        if(sells.length <= 2){
            System.out.println("0");
            return;
        }

        int last = sells[0];
        int next = sells[2];
        int res = 0;
        for (int i = 1; i < sells.length - 1; i++) {
            if(sells[i] > last && sells[i] > next) res ++;

            if(sells[i] < last && sells[i] < next) res ++;

            if(i == sells.length - 2) break;
            last = sells[i];
            next = sells[i + 2];
        }

        System.out.println(res);

    }


    private void two() throws URISyntaxException, FileNotFoundException {
        URL url = Main.class.getResource("../input.txt");
        File file = new File(url.toURI());
        Scanner in = new Scanner(file);

        // the y is the first
        // we will add more four 1 for detect
        int row = 15 + 4;
        int[][] board = new int[row][10];
        int[][] block = new int[4][4];
        int left;

        // normal reading
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 10; j++) {
                board[i][j] = in.nextInt();
            }
        }

        // adding more 1 for edge case
        for(int i = 15; i < row ; i++){
            for (int j = 0; j < 10; j++) {
               board[i][j] = 1;
            }
        }

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                block[i][j] = in.nextInt();
            }
        }

        left = in.nextInt();


        // cal the real base of the block


        // how to analyze for the base or collide !


        // the meaning of k, the depth the block sink !
        int k;
        for ( k = 0; k <= 15; k++) {
            if(!merge(board, block, left, k)) break;
        }


        k--;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                int reX = k + i;
                int reY = left + j - 1;
                board[reX][reY] = board[reX][reY] + block[i][j];
            }
        }

        // print the board

        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }

    }


    // we can modify the board, make a new one
    private boolean merge(int[][] board, int[][] block, int x, int y){
        int[][] mergeBoard = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            System.arraycopy(board[i], 0, mergeBoard[i], 0, board[0].length);
        }


        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                int reX = y + i;
                int reY = x + j - 1;
                mergeBoard[reX][reY] = board[reX][reY] + block[i][j];
                if(mergeBoard[reX][reY] > 1) return false;
            }
        }
        return true;
    }
}
