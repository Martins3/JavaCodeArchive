package five;

/**
 * Created by martin on 17-5-7.
 *
 */
public class SeventyThree {
    private int treeNut(int[] tree,int [] nut){
        int a=Math.abs(tree[0]-nut[0]);
        int b=Math.abs(tree[1]-nut[1]);
        return a*2+b*2;
    }
    private int SquireTreeNut(int[] squir,int[] tree,int [] nut){
        int a=treeNut(squir,nut)/2;
        int b=treeNut(nut,tree)/2;
        return a+b;
    }
    public int minDistance(int height, int width, int[] tree, int[] squirrel, int[][] nuts) {
        int all=0;
        int min=Integer.MAX_VALUE;
        for (int i = 0; i <nuts.length; i++) {
            all=SquireTreeNut(squirrel,tree,nuts[i])+all;
            int aa=SquireTreeNut(squirrel,tree,nuts[i]);
            int bb=treeNut(tree,nuts[i]);
            if(aa-bb<min){
                min = aa-bb;
            }
        }
        return all+min;

    }
}
