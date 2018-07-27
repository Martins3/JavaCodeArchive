package zero;

/**
 * Created by olddriver on 17-4-3.
 */
public class FortyTwo {
    public int trap(int[] height) {
        int[] left=new int[height.length];
        int max=0;
        int sum=0;
        int trap=0;
        for (int i = 0; i <height.length ; i++) {
            max=Math.max(max,height[i]);
            left[i]=max;
            sum+=height[i];
        }
        max=0;
        for (int i = height.length-1; i >=0 ; i--) {
            max = Math.max(max, height[i]);
            trap+=Math.min(max,left[i]);
        }

        return trap-sum;
    }
    private  FortyTwo(){
        System.out.println(trap(new int[]{1,0,2}));
    }

    public static void main(String[] args) {
        new FortyTwo();
    }
}
