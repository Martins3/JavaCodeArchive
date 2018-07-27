package fifteen.nine;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) throws FileNotFoundException, URISyntaxException {
        Main main = new Main();
        main.three();
    }
    private void one() throws URISyntaxException, FileNotFoundException {

        URL url = Main.class.getResource("seventeen/input.txt");
        File file = new File(url.toURI());
        Scanner in = new Scanner(file); // submit , just change to System.in

        int s = in.nextInt();
        int[] nums = new int[s];
        for (int i = 0; i < s; i++) {
            nums[i] = in.nextInt();
        }

        int lastNum = nums[0];
        int res = 1;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] != lastNum){
                res ++;
                lastNum = nums[i];
            }
        }
        System.out.println(res);
    }


    private void two() throws URISyntaxException, FileNotFoundException {

        URL url = Main.class.getResource("seventeen/input.txt");
        File file = new File(url.toURI());
        Scanner in = new Scanner(file); // submit , just change to System.in

        int year = in.nextInt();
        int d = in.nextInt();

        int feb = 28;
        if((year % 4 == 0 && year % 100 !=0) || year % 400 == 0){
            feb = 29;
        }
        int[] monthDays = {31, feb, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        int i = 0;
        int j = 0;
        while (d > 0){
            j = d;
            d = d - monthDays[i];
            i++;
        }


        System.out.println(i);
        System.out.println(j);

    }

    private void three() throws URISyntaxException, FileNotFoundException {
        URL url = Main.class.getResource("../input.txt");
        File file = new File(url.toURI());
        Scanner in = new Scanner(file); // submit , just change to System.in

        StringBuilder sb = new StringBuilder();
        TreeMap<String, String> kv = new TreeMap<>();

        int moduleNums = in.nextInt();
        int kvLines = in.nextInt();
        in.nextLine();

        for (int i = 0; i < moduleNums; i++) {
            sb.append(in.nextLine()).append("\n");
        }

        for (int i = 0; i < kvLines; i++) {
            String[] line = in.nextLine().split(" ", 2);
            String name = line[0];
            String value = line[1].substring(1, line[1].length() - 1);
            kv.put(name, value);
        }



        // 变量值 会出现反复的替换
        String res = sb.toString();
        StringBuilder resSb = new StringBuilder();
        while (true) {
            boolean noMatch = false;
            for (Map.Entry<String, String> entry : kv.entrySet()) {
                String name = entry.getKey();
                String value = entry.getValue();

                String regex = "\\{\\{ " + name + " }}";
                res = res.replaceAll(regex, value);
            }
            if(noMatch) break;
        }

        res = res.replaceAll("\\{\\{.*}}", "");
        System.out.println(res);
    }


    private void four() throws URISyntaxException, FileNotFoundException {
        URL url = Main.class.getResource("../input.txt");
        File file = new File(url.toURI());
        Scanner in = new Scanner(file); // submit , just change to System.in


        // 查找强连通的分量就是的可以的
        // 有必要创建出来的Graph 的类吗 ?
        // directed and undirected 的添加
        int cityNum = in.nextInt();
        int edgeNum = in.nextInt();

        LinkedList<Integer>[] linkedEdges = new LinkedList[cityNum + 1];
        for (int i = 1; i < linkedEdges.length; i++) {
           linkedEdges[i] = new LinkedList<>();
        }

        for (int i = 0; i < edgeNum; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            linkedEdges[a].add(b);
        }

        LinkedList<Integer>[] antiEdges = new LinkedList[cityNum + 1];
        for (int i = 1; i < antiEdges.length; i++) {
           antiEdges[i] = new LinkedList<>();
        }

        for (int i = 1; i < linkedEdges.length; i++) {
            for(int k: linkedEdges[i]){
                // original : i -> k
                antiEdges[k].add(i);
            }
        }


    }
}
