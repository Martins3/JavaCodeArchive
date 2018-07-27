package seventeen.three;


import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Main {
    public static void main(String[] args) throws FileNotFoundException, URISyntaxException {
        Main main = new Main();
        main.four();

    }

    private void one() throws FileNotFoundException, URISyntaxException {
        URL url = Main.class.getResource("input.txt");
        File file = new File(url.toURI());
        Scanner in = new Scanner(file); // submit , just change to System.in

        int cakeNum = in.nextInt();
        int cakeWeight = in.nextInt();
        int[] cakes = new int[cakeNum];
        for (int i = 0; i < cakeNum; i++) {
            cakes[i] = in.nextInt();
        }

        int friends = 0;
        int residualWeight = 0;
        for (int i = 0; i < cakeNum; i++) {
            if(residualWeight == 0){
                friends ++;
                residualWeight = cakeWeight;
            }
            residualWeight = Math.max(0, residualWeight  - cakes[i]);
        }
        System.out.println(friends);
    }

    private void two() throws URISyntaxException, FileNotFoundException {
        URL url = Main.class.getResource("input.txt");
        File file = new File(url.toURI());
        Scanner in = new Scanner(file); // submit , just change to System.in

        int studentNum = in.nextInt();
        // init locations, 1 - > 1
        int[] location = new int[studentNum + 1];
        int[] queue = new int[studentNum + 1];

        for (int i = 1; i < studentNum + 1; i++) {
            location[i] = i;
            queue[i] = i;
        }

        int modificationTimes = in.nextInt();
        for (int i = 0; i < modificationTimes; i++) {
            int id = in.nextInt();
            int move = in.nextInt();
            int pos = location[id];

            if(move > 0){
                location[id] += move; // we can not refer location array any more
                for (int j = pos + 1; j  <= pos + move; j++) {
                    location[queue[j]] --;
                }

                for (int j = pos; j < pos + move; j++) {
                    int t = queue[j];
                    queue[j] = queue[j + 1];
                    queue[j + 1] = t;
                }
            }else{
                move = - move;
                location[id] -= move;


                for (int j = pos - 1; j  >= pos - move; j--) {
                    location[queue[j]] ++;
                }

                for (int j = pos; j > pos - move; j--) {
                    int t = queue[j - 1];
                    queue[j - 1] = queue[j];
                    queue[j] = t;
                }
            }
        }

        for (int i = 1; i < studentNum + 1; i++) {
            System.out.print(queue[i] + " ");
        }
    }

    /**
     * 区块: 空行分割, 使用两个分隔符号
     *
     * 连续多行构成区块, 除非是什么 ?
     *
     * 标题: #  然后多个空行  一行  #的数目 深度限制
     *
     * 无序列表 * 开头 空格个数  没有嵌套列表
     *
     * 行里面的处理 : 强调(em)  个数为偶数 , 使用 _.*_的方法检查
     * 超链接的处理: []()
     *
     * 策略: 区分区块的类型 在行中间使用正则表达式的处理
     *
     *  前后不一定的是空
     *
     *  检查连续的换行实现状态的转换
     *
     *
     * 1. 段落的种类
     *      1. head
     *      2. paragraph
     *      3. *
     *     -> with the same method for 1 and 3 to handle
     *     -> paragraph ending will not add more line
     *     -> make a new line and make a blank line
     * 2. 不会删除行的个数, 也就是实现为根据当前的状态修改行的处理,
     * 3. detect the inline
     *      -> link
     *      -> _.+_
     *
     *
     * head  单个成行的, list stage 检查的空行
     *  那些位置的换行必须让上部分处理: 段落
     *  last line  maybe append the label
     *
     * 如何换行:
     * */
    private void three() throws URISyntaxException, FileNotFoundException {
        URL url = Main.class.getResource("input.txt");
        File file = new File(url.toURI());
        Scanner in = new Scanner(file); // submit , just change to System.in

        String line = null;
        String stage = "BlockOver";
        Pattern list = Pattern.compile("[*]+[ ]+[\\S]+");
        Pattern head = Pattern.compile("[#]+[ ]+[\\S]+");

        while (in.hasNext()){
            line = in.nextLine();

            switch (stage){
                // we had read a empty line just now !
                case "BlockOver":
                    // begin find the new block !
                    Matcher matchList = list.matcher(line);
                    Matcher matchHead = head.matcher(line);
                    if(matchList.matches()){
                        // list head
                        stage = "List";
                        System.out.println("<ui>");
                        // list item body
                        for (int i = 1; i < line.length(); i++) {
                            if(line.charAt(i) != ' '){
                                System.out.print("<li>");
                                System.out.print(line.substring(i, line.length()));
                                System.out.println("</li>");
                                break;
                            }
                        }
                    }else if(matchHead.matches()){
                        int headClass = 0;
                        boolean sharpOver = false;
                        for (int i = 0; i < line.length(); i++) {
                            if(sharpOver && line.charAt(i) != ' '){
                                System.out.print("<h" + headClass + ">");
                                System.out.println(line.substring(i, line.length()));
                                System.out.println("</h" + headClass + ">");
                                break;
                            }

                            if (line.charAt(i) == '#') {
                                headClass++;
                                continue;
                            }

                            if (line.charAt(i) == ' '){
                                sharpOver = true;
                            }
                        }
                    }else if(line.length() !=0 ){
                        // 遇到普通的行
                        System.out.print("<p>");
                        System.out.print(line);
                        stage = "Paragraph";
                    }else{
                        // find the empty line again !
                        System.out.println();
                    }
                    break ;
                case "List":
                    // empty or not
                    if(line.length() == 0) {
                        System.out.println(); // help the last one
                        System.out.println("</ui>");
                        System.out.println();
                        stage = "BlockOver";
                    }else{
                        for (int i = 1; i < line.length(); i++) {
                            if(line.charAt(i) != ' '){
                                System.out.print("<li>");
                                System.out.print(line.substring(i, line.length()));
                                System.out.print("</li>");
                            }
                        }
                    }
                    break ;
                case "Paragraph":
                    if(line.length() == 0){
                        System.out.println("</p>");
                        System.out.println();
                        stage = "BlockOver";
                    }else{
                        System.out.println(); // help the last line
                        System.out.print(line);
                    }
                    break;
                default:
                    System.out.println("-----------impossble---------------");
                    break;
            }
        }

        // depend on last line should add more
        switch (stage){
        case "List":
            System.out.println("</ui>");
            System.out.println();
        break ;
        case "Paragraph":
            System.out.println("</p>");
            System.out.println();
            break;
        default:
            System.out.println("-----------impossble---------------");
            break;
        }
    }


    private void four() throws FileNotFoundException, URISyntaxException {
        URL url = Main.class.getResource("../input.txt");
        File file = new File(url.toURI());
        Scanner in = new Scanner(file); // submit , just change to System.in

        int N = in.nextInt();
        int M = in.nextInt();
        // long !
        class Edge{
            int x;
            int y;
            int days;

            Edge(int x, int y, int days){
                this.x = x;
                this.y = y;
                this.days = days;
            }
        }

        LinkedList<Edge>[] adj = new LinkedList[N + 1];
        for (int i = 1; i < adj.length; i++) {
            adj[i] = new LinkedList<>();
        }

        for (int i = 0; i < M; i++) {
            int x = in.nextInt();
            int y = in.nextInt();
            int days = in.nextInt();

            Edge a = new Edge(x, y, days);
            Edge b = new Edge(y, x, days);

            adj[x].add(a);
            adj[y].add(b);
        }

        // sp 算法
        // long 保存数据

        boolean[] visited = new boolean[N + 1]; // 表示已经确定
        int [] disTo = new int[N + 1];
        for (int i = 1; i < disTo.length; i++) {
           disTo[i] = Integer.MAX_VALUE;
        }

        // need a new Point !
        // find the minimal and ok

        class Point implements Comparable<Point>{
           int node;
           int len;

            private Point(int node, int len) {
                this.node = node;
                this.len = len;
            }

            @Override
            public int compareTo(Point o) {
                return len - o.len;
            }
        }

        PriorityQueue<Point> points = new PriorityQueue<>(200000);
        disTo[1] = 0;
        points.add(new Point(1, 0));

        while (!points.isEmpty()){
            Point p = points.poll();
            int node = p.node;

            if(!visited[node]){
                visited[node] = true;
                for(Edge e: adj[node]){
                    int end = e.y;
                    int edgeWeight = e.days;
                    if(!visited[end]){
                        int fromThisPoint = Math.max(disTo[node], edgeWeight);
                        if(fromThisPoint < disTo[end]){
                            disTo[end] = fromThisPoint;
                            points.add(new Point(end, disTo[end]));
                        }
                    }
                }
            }
        }
        System.out.println(disTo[N]);
    }
}
