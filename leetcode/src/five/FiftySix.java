package five;

/**
 * Created by martin on 17-10-5.
 * 1. 如果排好序, 结束
 * 2. 如果没有排好序, 排序, 直转化为 string , 然后转化为char[]
 * 3. 仅仅使用一次交换吗 ?
 */
public class FiftySix {
    public static void main(String[] args) {
        int a = new FiftySix().nextGreaterElement(12222333);
        System.out.println(a);
    }
    public int nextGreaterElement(int n) {
        char[] nums = ("" + n).toCharArray();
        if(nums.length == 1) return -1;
        // 从右向左, 查找下降的数值
        int index = -1;
        int len = nums.length;
        int pre = nums[len - 1];
        for (int i = len - 2; i >= 0 ; i--) {
            if(nums[i] < pre){
                index = i;
                break;
            }
            pre = nums[i];
        }
        if(index == -1) return -1;
        for (int i = len - 1; i >= 0 ; i--) {
            // 第一个大于index 的数值
            if(nums[i] > nums[index]){
                char t = nums[i];
                nums[i] = nums[index];
                nums[index] = t;
            }
        }
        String k = String.valueOf(nums);
        String max = "" + Integer.MAX_VALUE;
        System.out.println(k.length() + " " + max.length() + "  " + k.compareTo(max));
        if(k.length() == max.length() && k.compareTo(max) > 0) return -1;
        return Integer.parseInt(k);
    }
}
