package four;

/**
 * Created by martin on 17-4-26.
 * wo cao
 */
public class Forty {
    private int[] sortThree(int[] nums,int s){ //numbs increase
        int temp;
        if(s<nums[0]){
            nums[2]=nums[1];
            nums[1]=nums[0];
            nums[0]=s;
        }else if(s>nums[0]&&s<nums[1]){
            nums[2]=nums[1];
            nums[1]=s;
        }else if(s>nums[1]&&s<nums[2]){
            nums[2]=s;
        }
        return nums;
    }
    public int thirdMax(int[] nums) {

        if(nums.length==1) return nums[0];
        if(nums.length==2) return Math.max(nums[0],nums[1]);
        int[] s=new int[]{nums[0],Integer.MAX_VALUE,Integer.MAX_VALUE};
        for (int i = 1; i <nums.length ; i++) {
            sortThree(s,nums[i]);
        }

        if(nums.length==3)return s[0];
        if(nums.length==4) return s[1];
        if(nums.length>=5) return s[2];
        return Integer.MIN_VALUE;
    }

    public static void main(String[] args) {
        int a=new Forty().thirdMax(new int[]{1,2,2,3,4,5,6,7,8,9});
        System.out.println(a);
    }
}
