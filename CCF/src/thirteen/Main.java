package thirteen;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException, URISyntaxException {
        Main main = new Main();
        main.three();
    }

    private void two() throws URISyntaxException, FileNotFoundException {
        URL url = Main.class.getResource("input.txt");
        File file = new File(url.toURI());
        Scanner in = new Scanner(file); // submit , just change to System.in

        String isbn = in.nextLine();
        char[] isbnChar = isbn.toCharArray();

        int[] index = new int[]{0, 2, 3, 4, 6, 7, 8, 9, 10};
        int sum = 0;
        for (int i = 0; i < 9; i++) {
           sum += (isbnChar[index[i]] - '0') * (i + 1);
        }
        sum = sum % 11;

        if(isbnChar[12] == 'X'){
            if(sum == 10) {
                System.out.println("Right");
            }else{
                isbnChar[12] = (char)('0' + sum);
                System.out.println(String.valueOf(isbnChar));
            }
        }else{
            if(sum == (isbnChar[12] - '0')){
                System.out.println("Right");
            }else if(sum == 10) {
                isbnChar[12] = 'X';
                System.out.println(String.valueOf(isbnChar));
            }else{
                isbnChar[12] = (char)('0' + sum);
                System.out.println(String.valueOf(isbnChar));
            }
        }
    }


    private void three() throws URISyntaxException, FileNotFoundException {
        URL url = Main.class.getResource("input.txt");
        File file = new File(url.toURI());
        Scanner in = new Scanner(file); // submit , just change to System.in


        // 区间最小值
        int size = in.nextInt();
        int[] nums = new int[size];

        int[][] mini = new int[size][size];

        for (int i = 0; i < size; i++) {
           nums[i] = in.nextInt();
        }

        for(int len = 0; len <= size - 1; len ++){
            for (int i = 0; i < size - len; i++) { // start point
                // basic case
                if(len == 0){
                    mini[i][i] = nums[i];
                }

                // dp
                else{
                   mini[i][i + len] = Math.min(mini[i][i + len -1], mini[i + 1][i + len]);
                }
            }
        }

        int res = 0;
        for(int len = 0; len <= size - 1; len ++) {
            for (int i = 0; i < size - len; i++) {
                res = Math.max((len + 1)* mini[i][i + len], res);
            }
        }

        System.out.println(res);

    }
}
