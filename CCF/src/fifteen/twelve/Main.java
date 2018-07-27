package fifteen.twelve;

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
        URL url = Main.class.getResource("../input.txt");
        File file = new File(url.toURI());
        Scanner in = new Scanner(file); // submit , just change to System.in

        int num = in.nextInt();
        int ans = 0;

        while (num != 0){
            ans += num % 10;
            num = num / 10;
        }
        System.out.println(ans);
    }


    private void two() throws URISyntaxException, FileNotFoundException {
        URL url = Main.class.getResource("../input.txt");
        File file = new File(url.toURI());
        Scanner in = new Scanner(file); // submit , just change to System.in

        // check the row and column

        int N = in.nextInt();
        int M = in.nextInt();
        int[][] board = new int[N][M];


        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                board[i][j] = in.nextInt();
            }
        }

        boolean[][] clear = new boolean[N][M];

        // for the row
        for (int i = 0; i < N; i++) {
            int consecutive = 0;
            int last = board[i][0];
            int j;
            for (j = 0; j < M; j++) {
               if(board[i][j] == last){
                   consecutive ++;
               }else{
                   if(consecutive >= 3){
                       // clear the node
                       for (int k = 0; k < consecutive; k++) {
                           clear[i][j - 1 - k] = true;
                       }
                   }
                   consecutive = 1;
               }
               last = board[i][j];
            }

            // if at the ending, we find the consecutive is greater than 3
            if(consecutive >= 3){
                // clear the node
                for (int k = 0; k < consecutive; k++) {
                    clear[i][j - 1 - k] = true;
                }
            }

        }


        // for the column
        for (int j = 0; j < M; j++) {
           int consecutive = 0;
           int last = board[0][j];
           int i;
            for (i = 0; i < N; i++) {
                if(board[i][j] == last) {
                    consecutive++;
                }else{
                    if(consecutive >= 3){
                        // clear
                        for (int k = 0; k < consecutive; k++) {
                           clear[i - 1 - k][j] = true;
                        }
                    }
                    consecutive = 1;
                }
                last = board[i][j];
            }

            if(consecutive >= 3){
                // clear
                for (int k = 0; k < consecutive; k++) {
                    clear[i - 1 - k][j] = true;
                }
            }


        }


        // print
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(clear[i][j]){
                    System.out.print("0 ");
                }else{
                    System.out.print(board[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
    private void four() throws URISyntaxException, FileNotFoundException {

        URL url = Main.class.getResource("../input.txt");
        File file = new File(url.toURI());
        Scanner in = new Scanner(file); // submit , just change to System.in
    }


}
