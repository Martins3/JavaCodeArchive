package seventeen.nine;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException, URISyntaxException {

        Main main = new Main();
        main.three();

    }

    private void one() throws FileNotFoundException, URISyntaxException {
        URL url = Main.class.getResource("../input.txt");
        File file = new File(url.toURI());
        Scanner in = new Scanner(file); // submit , just change to System.in


       int num = in.nextInt() / 10;

       int five = num / 5;
       int residual = num % 5;
       int res = num + five * 2;
       int three = 0;
       switch (residual){
           case 0:
               three = 0;
               break;
           case 1:
               three = 0;
               break;
           case 2:
               three = 0;
               break;
           case 3:
               three = 1;
               break;
           case 4:
               three = 1;
               break;
           default:
               break;
       }

        System.out.println(res + three);

    }

    private void two() throws FileNotFoundException, URISyntaxException {
        URL url = Main.class.getResource("../input.txt");
        File file = new File(url.toURI());
        Scanner in = new Scanner(file); // submit , just change to System.in


        class Operation implements Comparable<Operation>{
            boolean isReturn;
            int keyNum;
            int time;

            /**
             * 1. 时间顺序
             * 2. 放置的操作高于取出的操作
             * 3. 钥匙从小号还
             */
            @Override
            public int compareTo(Operation o) {
                if(this.time < o.time) return -1;
                if(this.time > o.time) return 1;

                if(this.isReturn && (!o.isReturn)) return -1;
                if(o.isReturn && (!this.isReturn)) return  1;

                // 时间相同, 都是取钥匙或者 还钥匙
                return this.keyNum - o.keyNum;
            }

            private Operation(boolean isReturn, int keyNum, int time) {
                this.isReturn = isReturn;
                this.keyNum = keyNum;
                this.time = time;
            }
        }

        int N = in.nextInt();
        int K = in.nextInt();

        PriorityQueue<Operation> operations = new PriorityQueue<>();
        int[] box = new int[N];
        for (int i = 0; i < box.length; i++) {
           box[i] = i + 1;
        }

        int[] keyPos = new int[N + 1];
        for (int i = 1; i < keyPos.length; i++) {
            keyPos[i] = i - 1;
        }

        PriorityQueue<Integer> blank = new PriorityQueue<>();

        for (int i = 0; i < K; i++) {

            int keyNum = in.nextInt();
            int start = in.nextInt();
            int last = in.nextInt();

            Operation take = new Operation(false, keyNum, start);

            Operation ret = new Operation(true, keyNum, start + last);

            operations.add(take);
            operations.add(ret);
        }

        Operation op;
        // test the sort !
        while (!operations.isEmpty()){
            op = operations.poll();

            if(op.isReturn){
                int pos = blank.poll();
                box[pos] = op.keyNum;
                // 刷新钥匙的位置
                keyPos[op.keyNum] = pos;
            }else{
                // 查询钥匙的位置
                int pos = keyPos[op.keyNum];
                // 释放钥匙的位置
                blank.add(pos);
            }
        }

        // print
        for(int i: box) {
            System.out.print(i + " ");
        }
    }



    private void three() throws FileNotFoundException, URISyntaxException {
        URL url = Main.class.getResource("../input.txt");
        File file = new File(url.toURI());
        Scanner in = new Scanner(file); // submit , just change to System.in


        int N = in.nextInt();

        // first
        boolean[][] connection = new boolean[N + 1][N + 1];

        boolean[] visited;
        LinkedList<Integer>[] adj = new LinkedList[N + 1];
        for (int i = 1; i < adj.length; i++) {
            adj[i] = new LinkedList<>();
        }
        int M = in.nextInt();
        for (int i = 0; i < M; i++) {
            int x = in.nextInt();
            int y = in.nextInt();
            adj[x].add(y);
        }


        for (int i = 1; i <= N ; i++) {
            visited = new boolean[N + 1];
            dfs_two(adj, i, i, connection, visited);
        }

        int res = 0;
        for (int i = 1; i <= N; i++) {
            boolean ok = true;
            for (int j = 1; j <= N ; j++) {
               if(!connection[i][j]){
                   ok = false;
                   break;
               }
            }
            if(ok) res ++;
        }
        System.out.println(res);
    }

    // keep the i same
    private void dfs_two(LinkedList<Integer>[] adj, int i, int s, boolean[][] connection, boolean[] visited){
        visited[s] = true;
        connection[i][s] = true;
        connection[s][i] = true;

        for(int neighbor: adj[s]){
            // 如果访问过，　直接合并
            if(!visited[neighbor]){
                dfs_two(adj, i, neighbor,connection, visited);
            }
        }
    }
}
