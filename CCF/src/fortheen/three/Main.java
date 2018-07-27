package fortheen.three;


import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.*;

/**
 * Created by martin on 17-10-27.
 *
 */
public class Main {
    public static void main(String[] args) throws FileNotFoundException, URISyntaxException {
        Main main = new Main();
        main.three();
    }

    private void three() throws URISyntaxException, FileNotFoundException {
        URL url = Main.class.getResource("fifteen/input.txt");
        File file = new File(url.toURI());
        Scanner in = new Scanner(file); // submit , just change to System.in

        String document = in.nextLine();
        TreeSet<Character> bare = new TreeSet<>();
        TreeSet<Character> full = new TreeSet<>();

        boolean isFull = false;
        for (int i = document.length() - 1 ; i >= 0; i--) {
            // if full, then this char must be a alphat
            if(isFull){
                full.add(document.charAt(i));
                isFull = false;
            }else {
                char c = document.charAt(i);
                if(c == ':'){
                    isFull = true;
                }else {
                    bare.add(c);
                }
            }
        }
        int time = in.nextInt();
        ArrayList<String> inputs = new ArrayList<>();
        in.nextLine();
        for (int i = 0; i < time; i++) {
           inputs.add(in.nextLine());
        }

        int index = 0;
        TreeMap<Character, String> res;
        for(String a: inputs){
            index ++;
            res = new TreeMap<>();
            String[] elements = a.split( "(?<!\\s)\\s(?!\\s)", -1);

            String stage = "name"; // 表示期待的项目
            char lastCommand = 'A';
            label:
            for (String s : elements) {
                switch (stage) {
                    case "name":
                        stage = "command";
                        break;
                    case "command":
                        boolean isCommand = s.matches("-[a-z]");
                        if (!isCommand) {
                            break label;
                        }

                        char c = s.charAt(1);
                        if (bare.contains(c)) {
                            // 添加命令
                            res.put(c, "");
                        } else if (full.contains(c)) {
                            stage = "para";
                            lastCommand = c;
                        } else {
                            // 出现位置命令
                            break label;
                        }
                        break;
                    default:
                        stage = "command";
                        res.put(lastCommand, s);
                        break;
                }
            }

            // output
            System.out.print("Case " + index + ": ");
            for(Map.Entry<Character, String> entry: res.entrySet()){
                if(entry.getValue().length() == 0){
                    System.out.print("-" + entry.getKey() + " ");
                }else{
                    System.out.print("-" + entry.getKey() + " " + entry.getValue() + " ");
                }
            }
            System.out.println();
        }
    }



    private void one() throws URISyntaxException, FileNotFoundException {
//        URL url = Main.class.getResource("input.txt");
//        File file = new File(url.toURI());
        Scanner in = new Scanner(System.in); // submit , just change to System.in

        int length = in.nextInt();
        int[] nums = new int[length];
        for (int i = 0; i < length; i++) {
            nums[i] = in.nextInt();
        }

        int total = 0;
        for(int i: nums){
            for(int j: nums){
                if( i + j == 0){
                    total ++;
                }
            }
        }
        System.out.println(total / 2);
    }




    private void two() throws URISyntaxException, FileNotFoundException {
//        URL url = Main.class.getResource("input.txt");
//        File file = new File(url.toURI());
        Scanner in = new Scanner(System.in); // submit , just change to System.in

        class Point{
            int x;
            int y;
            private Point(int x, int y){
                this.x = x;
                this.y = y;
            }
        }

        class Window{
            private Point left;
            private Point right;
            private Window(Point left, Point right){
                this.left = left;
                this.right = right;
            }

            private boolean inWindow(Point a){
                if(a.x >= left.x && a.x <= right.x){
                    if(a.y >= left.y && a.y <=right.y){
                        return true;
                    }
                }
                return false;
            }
        }



        int N = in.nextInt();
        int M = in.nextInt();
        Window[] windows = new Window[N];
        Point[] clicks = new Point[M];

        for (int i = 0; i < N; i++) {
            int x = in.nextInt();
            int y = in.nextInt();
            Point left = new Point(x, y);
            x = in.nextInt();
            y = in.nextInt();
            Point right = new Point(x, y);
            windows[i] = new Window(left, right);
        }

        // query from the last one

        for (int i = 0; i < M; i++) {
            int x = in.nextInt();
            int y = in.nextInt();
            clicks[i] = new Point(x, y);
        }

        Window window;
        int[] windowIndex = new int[N];

        for (int i = 0; i < N ; i++) {
            windowIndex[i] = i + 1;
        }
        for(Point click:clicks){
            boolean ignore = true;
            for (int i = N - 1; i >= 0 ; i--) {
                window = windows[i];
                if(window.inWindow(click)){
                    System.out.println(windowIndex[i]);
                    int index = i;
                    while (index < N - 1){
                        Window temp = windows[index];
                        windows[index] = windows[index + 1];
                        windows[index + 1] = temp;

                        int intTemp = windowIndex[index];
                        windowIndex[index] = windowIndex[index + 1];
                        windowIndex[index + 1] = intTemp;

                        index ++;
                    }
                    ignore = false;
                    break;
                }
            }
            if(ignore) System.out.println("IGNORED");
        }
    }
}


