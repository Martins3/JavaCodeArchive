package fifteen.three;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException, URISyntaxException {
        Main main = new Main();
        main.three();
    }
    private void one() throws URISyntaxException, FileNotFoundException {
        URL url = Main.class.getResource("../input.txt");
        File file = new File(url.toURI());
        Scanner in = new Scanner(file); // submit , just change to System.in

        int x = in.nextInt();
        int y = in.nextInt();
        int[][] nums = new int[x][y];

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y ; j++) {
                nums[i][j] = in.nextInt();
            }
        }

        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                System.out.print(nums[j][y - 1 - i] + " ");
            }
            System.out.println();
        }
    }

    private void two() throws FileNotFoundException, URISyntaxException {

        URL url = Main.class.getResource("seventeen/input.txt");
        File file = new File(url.toURI());
        Scanner in = new Scanner(file); // submit , just change to System.in

        int times = in.nextInt();
        LinkedList<Integer> read = new LinkedList<>();
        for (int i = 0; i < times; i++) {
            read.add(in.nextInt());
        }

        class Point implements Comparable<Point>{
            private int num;
            private int times;

            public Point(int num, int times) {
                this.num = num;
                this.times = times;
            }

            @Override
            public int compareTo(Point o) {
                if(o.times < this.times){
                    return -1;
                }else if(o.times > this.times){
                    return 1;
                }else {
                    return this.num - o.num;
                }
            }
        }

        TreeMap<Integer, Integer> frequency = new TreeMap<>();
        for(int i: read){
            if(frequency.containsKey(i)){
                frequency.put(i, frequency.get(i) + 1);
            }else{
                frequency.put(i, 1);
            }
        }

        ArrayList<Point> a = new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry: frequency.entrySet()){
            a.add(new Point(entry.getKey(), entry.getValue()));
        }
        Collections.sort(a);

        for(Point p:a){
            System.out.println(p.num + " " + p.times);
        }
    }


    /**
     * 输出的结果为None 的情况:
     * 时间out of boundary
     * */
    private void three() throws URISyntaxException, FileNotFoundException {
        URL url = Main.class.getResource("../input.txt");
        File file = new File(url.toURI());
        Scanner in = new Scanner(file); // submit , just change to System.in


        int whichMonth = in.nextInt();
        int whichWeek = in.nextInt();
        int whichDate = in.nextInt();
        int startYear = in.nextInt();
        int endYear = in.nextInt();


        // calculate the first year's Jan 1th is what !

        int theDate = 2;
        int yearLength = 0;
        for(int year = 1850; year < startYear; year++){
            yearLength = sum(months(year));
        }
        theDate = (theDate + yearLength) % 7 + 1;


        // calculate one by one


    }

    private int[] months(int year){
        int feb = 28;
        if((year % 4 == 0 && year % 100 !=0) || year % 400 == 0){
            feb = 29;
        }
        return new int[]{31, feb, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    }

    private int sum(int months[]){
        int sum = 0;
        for(int i:months){
            sum += i;
        }
        return sum;
    }
}
