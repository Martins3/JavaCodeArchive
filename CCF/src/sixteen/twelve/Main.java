package sixteen.twelve;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Arrays;
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


        int num = in.nextInt();
        int[] points = new int[num];
        for (int i = 0; i < num; i++) {
            points[i] = in.nextInt();
        }

        Arrays.sort(points);
        // 1 2 3 4 5
        int mid = points[num / 2];
        int less = 0;
        int bigger = 0;

        for(int i: points){
            if(i < mid) less ++;
            if(i > mid) bigger ++;
        }

        if(less == bigger) System.out.println(mid);

        if(less != bigger) System.out.println("-1");
    }
      /**
         1） 个人所得税起征点为3500元，若S不超过3500，则不交税，3500元以上的部分才计算个人所得税，令A=S-3500元；
　　      2） A中不超过1500元的部分，税率3%；
　　      3） A中超过1500元未超过4500元的部分，税率10%；
　　      4） A中超过4500元未超过9000元的部分，税率20%；
　　      5） A中超过9000元未超过35000元的部分，税率25%；
　　      6） A中超过35000元未超过55000元的部分，税率30%；
　　      7） A中超过55000元未超过80000元的部分，税率35%；
　　      8） A中超过80000元的部分，税率45%；
       */
    private void two() throws URISyntaxException, FileNotFoundException {
        URL url = Main.class.getResource("input.txt");
        File file = new File(url.toURI());
        Scanner in = new Scanner(file); // submit , just change to System.in

        // find the S belongs to which range
        // find the left amount
        int a = 3500; // 3500
        int b = a + (int)(1500 * 0.97);
        int c = b + (int)(3000 * 0.9);
        int d = c + (int)(4500 * 0.8);
        int e = d + (int)(26000 * 0.75);
        int f = e + (int)(20000 * 0.7);
        int g = f + (int)(25000 * 0.65);


        int afterTax = in.nextInt();
        int remain;
        int beforeTax;
        // edge case check
        if(afterTax > g){
            remain = afterTax - g;
            remain = (int)Math.round(remain / 0.55);
            beforeTax = 3500 + 80000 + remain;
        }else if(afterTax > f){
            remain = afterTax - f;
            remain = (int)Math.round(remain / 0.65);
            beforeTax = 3500 + 55000 + remain;
        }else if(afterTax > e){
            remain = afterTax - e;
            remain = (int)Math.round(remain / 0.70);
            beforeTax = 3500 + 35000 + remain;
        }else if(afterTax > d){
            remain = afterTax - d;
            remain = (int)Math.round(remain / 0.75);
            beforeTax = 3500 + 9000 + remain;
        }else if(afterTax > c){
            remain = afterTax - c;
            remain = (int)Math.round(remain / 0.8);
            beforeTax = 3500 + 4500 + remain;
        }else if(afterTax > b){
            remain = afterTax - b;
            remain = (int)Math.round(remain / 0.9);
            beforeTax = 3500 + 1500 + remain;
        }else if(afterTax > a){
            remain = afterTax - a;
            remain = (int)Math.round(remain / 0.97);
            beforeTax = 3500 + remain;
        }else{
            beforeTax = afterTax;
        }
        System.out.println(beforeTax);
    }

    /**
     *
     * @throws URISyntaxException
     * @throws FileNotFoundException
     *
     * 用户名 和角色名 都是小写字母
     *
     *
     */
    private void three() throws URISyntaxException, FileNotFoundException {
        URL url = Main.class.getResource("input.txt");
        File file = new File(url.toURI());
        Scanner in = new Scanner(file); // submit , just change to System.in



    }
}
