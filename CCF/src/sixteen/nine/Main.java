package sixteen.nine;

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

        int days = in.nextInt();
        int[] prices = new int[days];

        for (int i = 0; i < days; i++) {
            prices[i] = in.nextInt();
        }

        int last = prices[0];
        int res = 0;
        for (int i = 1; i < days; i++) {
           res = Math.max(res, Math.abs(prices[i] -  last));
           last = prices[i];
        }
        System.out.println(res);
    }


    private void two() throws URISyntaxException, FileNotFoundException {
        URL url = Main.class.getResource("../input.txt");
        File file = new File(url.toURI());
        Scanner in = new Scanner(file); // submit , just change to System.in

        int requestNum = in.nextInt();
        int[] row = new int[20]; // indicate the remaining seats in the every pai
        for (int i = 0; i < row.length; i++) {
           row[i] = 5;
        }
        for (int i = 0; i < requestNum; i++) {
            int request = in.nextInt();

            // we check there is api empty for the request
            boolean great = false;
            for (int j = 0; j < row.length; j++) {
                if(row[j] >= request){

                    // out put the res
                    // bug here
                    for (int k = 0; k < request; k++) {
                        System.out.print(j * 5 + 5 - row[j] + k + 1 );
                        System.out.print(" ");
                    }

                    // take the seat
                    row[j] = row[j] - request;

                    System.out.println();
                    great = true;
                    break;
                }
            }

            // just add the to minimal seats
            if(!great){
                int searchNum = 0; // find the sparse table
                while (request != 0){
                   if(row[searchNum] != 0){
                       // enough
                       if(row[searchNum] > request){
                           for (int j = 0; j < request; j++) {
                               System.out.print(searchNum * 5 + 5 - row[searchNum] + j + 1);
                               System.out.print(" ");
                           }
                           System.out.println();
                           row[searchNum] -= request;
                           request = 0;
                       }
                       // not enough
                       else{
                           for (int j = 5 - row[searchNum]; j < 5; j++) {
                               System.out.print(searchNum * 5 + j + 1);
                               System.out.print(" ");
                           }
                           request = request - row[searchNum];
                           row[searchNum] = 0;
                       }
                   }
                   searchNum ++;
                }
                System.out.println();
            }

        }
    }
}
