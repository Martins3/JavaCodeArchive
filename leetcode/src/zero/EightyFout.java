package zero;

/**
 * Created by olddriver on 17-4-5.
 * 长方体必定是包含有底部的
 *
 */
public class EightyFout {
    public int largestRectangleArea(int[] heights) {
        //find the maxinum fo the array
        int max=0;
        for(int a:heights){
            if(a>max) max=a;
        }
        if(max==0) return 0;
        int[] blocks;
        int min;
        int maxrec=0;
        for (int i = 0; i <heights.length; i++) {
            // 测定所有的行开始的
            blocks=new int[max];
            min=max;
            for (int j = i; j <heights.length  ; j++) {
                min=Math.min(heights[j],min);
                for (int k = 0; k <min ; k++) {
                    blocks[k]++;
                }
            }
            for (int j = 0; j <max ; j++) {
                maxrec=Math.max(maxrec,blocks[j]*(j+1));
            }
        }
        return maxrec;
    }
    private EightyFout(){
        int a=largestRectangleArea(new int[]{1,1});
        System.out.println(a);
    }
    public static void main(String[] args) {
        new EightyFout();
    }
}
