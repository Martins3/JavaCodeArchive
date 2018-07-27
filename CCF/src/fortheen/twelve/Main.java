package fortheen.twelve;


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

    private void one() throws FileNotFoundException, URISyntaxException {
        URL url = Main.class.getResource("../input.txt");
        File file = new File(url.toURI());
        Scanner in = new Scanner(file); // submit , just change to System.in

        int numRecord = in.nextInt();
        TreeMap<Integer, Integer> t = new TreeMap<>();
        LinkedList<Integer> res = new LinkedList<>();
        for (int i = 0; i < numRecord; i++) {
            int x = in.nextInt();
            if(t.containsKey(x)){
                t.put(x, t.get(x) + 1);
                res.add(t.get(x));
            }else {
                t.put(x, 1);
                res.add(1);
            }
        }
        for(int x: res){
            System.out.print(x + " ");
        }
    }

    private void two() throws URISyntaxException, FileNotFoundException {

        URL url = Main.class.getResource("seventeen/input.txt");
        File file = new File(url.toURI());
        Scanner in = new Scanner(file); // submit , just change to System.in

        int size = in.nextInt();
        int[][] nums = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                nums[i][j] = in.nextInt();
            }
        }

        // i 表示行, j 表示列
        // 只有两种方向  两种转向的方法
        int i = 0;
        int j = 0;
        LinkedList<Integer> res = new LinkedList<>();
        boolean up = true;
        while (true){
            // 添加用户的位置
            res.add(nums[i][j]);
            if(i == size -1 && j == size - 1) break;


            // 右边界 more serious
            // 下边界高于左边界

            if(up){
                // 此时只有遇到右上的边界的问题
                if(j == size - 1){
                    up = false;
                    i++;
                }else if(i == 0){
                    up = false;
                    j++;
                }else{
                    i --;
                    j ++;
                }
            }else {
                if(i == size -1 ){
                    up = true;
                    j ++;
                }else if(j == 0){
                    up = true;
                    i ++;
                }else{
                    i ++;
                    j --;
                }
            }
        }

        for(int s:res){
            System.out.print(s + " ");
        }
    }

    /**
     * 检查数值越界的可能性
     * 下标的取值的范围是什么*/
    private void three() throws URISyntaxException, FileNotFoundException {
        URL url = Main.class.getResource("../input.txt");
        File file = new File(url.toURI());
        Scanner in = new Scanner(file); // submit , just change to System.in


        // 处理 cancel

        // 从 小到大移动, 逐渐减少两边的数值,遍历的过程中间进行逐渐添加

        // 读取出来的过程中间: 1. to linkedList 2. to table with different res

        // 多个cancel 会导致函数的顺序的下标出现错误的
        ArrayList<String> readAll = new ArrayList<>(5200);
        while (in.hasNext()){
            String line = in.nextLine();
            String[] type = line.split(" ");
            if(type[0].equals("cancel")){
                readAll.set(Integer.parseInt(type[1]) - 1, null);
                readAll.add(null);
            }else {
                readAll.add(line);
            }
        }

        ArrayList<String> read = new ArrayList<>(5000);
        for(String s:readAll){
            if(s != null) read.add(s);
        }




        // 如果开盘价为p0，则系统可以将所有出价至少为p0的买单和所有出价至多为p0的卖单进行匹配

        // 都是从小到大的进行排序, buy 从大到小进行累加
        // sell 从小到大进行累加
        class Stock implements Comparable<Stock>{
            private double price;
            private long mount;

            private Stock(double price, long mount) {
                this.price = price;
                this.mount = mount;
            }

            @Override
            public int compareTo(Stock o) {
                return Double.compare(this.price, o.price);
            }
        }


        // we find make the data have same prices will
        // it much more easy to handle it !

        TreeMap<Double, Integer> buyWR = new TreeMap<>();
        TreeMap<Double, Integer> sellWR = new TreeMap<>();
        TreeSet<Double> allPrice = new TreeSet<>();

        for(String s:read){
            String[] m = s.split(" ");
            String type = m[0];
            double price = Double.parseDouble(m[1]);
            int mount = Integer.parseInt(m[2]); // 数值操作不可能变化

            if(type.equals("buy")){
                buyWR.put(price, mount);
            }else {
                sellWR.put(price, mount);
            }
            allPrice.add(price);
        }

        for(double price:allPrice){
            if(!buyWR.containsKey(price)) buyWR.put(price, 0);
            if(!sellWR.containsKey(price)) sellWR.put(price, 0);
        }


        ArrayList<Stock> buy = new ArrayList<>();
        ArrayList<Stock> sell = new ArrayList<>();

        for(Map.Entry<Double, Integer> entry: buyWR.entrySet()){
            buy.add(new Stock(entry.getKey(), entry.getValue()));
        }

        for(Map.Entry<Double, Integer> entry: sellWR.entrySet()){
            sell.add(new Stock(entry.getKey(), entry.getValue()));
        }

        Collections.sort(buy);
        Collections.sort(sell);


        long accumulate = 0;
        for (int i = 0; i < sell.size(); i++) {
            Stock s = sell.get(i);
            long local = s.mount;
            s.mount += accumulate;
            accumulate += local;
        }

        // buy
        accumulate = 0;
        for (int i = buy.size() - 1; i >= 0; i--) {
            Stock s = buy.get(i);
            long local = s.mount;
            s.mount += accumulate;
            accumulate += local;
        }

        long res = -1;
        int index = -1;
        for (int i = 0; i < buy.size(); i++) {
            long temp = Math.min(buy.get(i).mount, sell.get(i).mount);
            if(temp >= res){
                index = i;
                res = temp;
            }
        }
        System.out.printf("%.2f", sell.get(index).price);
        System.out.println(" " + res);

    }
}


