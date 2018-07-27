package zero;

/**
 * Created by martin on 17-10-5.
 * 使用余数的方法
 */
public class Sixty {
    public String getPermutation(int n, int k) {
        // n 只有 1 到 9, 创建对应的数组
        int[] stair = new int[8];
        stair[0] = 1;
        for (int i = 1; i < stair.length; i++) {
            stair[i] = stair[i - 1] * (i + 1);
        }
        return null;
    }
}
