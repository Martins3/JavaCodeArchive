package six;

/**
 * Created by martin on 17-6-24.
 */
public class Zero {
    // 如果a[i] 表示 第i位置 数值为1，也就是a[3] 满足条件的为100
    private int[] a = new int[32] ;
    public int findIntegers(int num) {
        String s = Integer.toBinaryString(num);
        int target = s.length();
        a[0] = 1;   // means the zero
        a[1] = 1;   // means the one
        a[2] = 1;
        int i = 3;
        while (i<target){
            for (int j = 0; j < i - 1; j++) {
                a[i]+=a[j];
            }
            i++;
        }
        int res = 0;

        // find the biggest
        boolean[] bg = new boolean[target];
        bg[0] = true;
        for (int j = 1; j < target ; j++) {
            //当前的位置出现连续的1的时候，后面的数值直接生成即可
            if(s.charAt(j)=='1'&&s.charAt(j-1)==1){
                boolean flag = false;
                for (int k = j; k < target ; k++) {
                    bg[k] = flag;
                    flag = !flag;
                }
            }else{
                bg[j] = '1'==s.charAt(j);
            }
        }


        res = getLeast(target - 1);


        return res;
    }
    private int getLeast(int i){
        int res = 0;
        for (int j = 0; j <i ; j++) {
            res += a[j];
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Zero().findIntegers(0xff));
        System.out.println(Integer.toBinaryString(255));
    }
}
