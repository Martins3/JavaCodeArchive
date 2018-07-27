package fortheen.nine;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws FileNotFoundException, URISyntaxException {
        Main main = new Main();
        main.three();
    }

    private void one() throws FileNotFoundException, URISyntaxException {
        URL url = Main.class.getResource("fifteen/input.txt");
        File file = new File(url.toURI());
        Scanner in = new Scanner(file); // submit , just change to System.in

        int num = in.nextInt();
        int[] nums = new int[num];
        for (int i = 0; i < num; i++) {
           nums[i] = in.nextInt();
        }
        Arrays.sort(nums);

        int last = nums[0];
        int res = 0;
        for (int i = 1; i < num; i++) {
            if(nums[i] - last == 1){
                res ++;
            }
            last = nums[i];
        }
        System.out.println(res);
    }

    private void two() throws URISyntaxException, FileNotFoundException {
        URL url = Main.class.getResource("fifteen/input.txt");
        File file = new File(url.toURI());
        Scanner in = new Scanner(file); // submit , just change to System.in


        int rectangeNum = in.nextInt();
        int[][] pin = new int[100 + 1][100 + 1];
        for (int i = 0; i < rectangeNum; i++) {
            // 左下角的横坐标与纵坐标，以及右上角的横坐标与纵坐标。
            int left_x = in.nextInt();
            int left_y = in.nextInt();
            int right_x = in.nextInt();
            int right_y = in.nextInt();
            for (int j = left_x; j < right_x; j++) {
                for (int k = left_y; k < right_y ; k++) {
                    pin[j][k] = 1;
                }
            }
        }

        int so = 0;
        for (int i = 0; i < 101 ; i++) {
            for (int j = 0; j < 101 ; j++) {
               if(pin[i][j] == 1){
                   so ++;
               }
            }
        }
        System.out.println(so);
    }

    private void three() throws URISyntaxException, FileNotFoundException {

        URL url = Main.class.getResource("fifteen/input.txt");
        File file = new File(url.toURI());
        Scanner in = new Scanner(file); // submit , just change to System.in

        final String pattern = in.nextLine();

        int caseSensitive = in.nextInt();
        in.nextLine();
        boolean sensitive = caseSensitive == 1;

        int nums = in.nextInt();
        in.nextLine();

        String local;

        for (int i = 0; i < nums ; i++) {
            String text = in.nextLine();
            String primitive = text;
            if(!sensitive){
                text = text.toUpperCase();
                local = pattern.toUpperCase();
            }else{
                local = pattern;
            }
            Pattern p = Pattern.compile(local);
            Matcher m = p.matcher(text);
            if(m.find()){
                System.out.println(primitive);
            }
        }
    }
}

