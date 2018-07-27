package five;

import mytools.DoArray;

import java.util.Arrays;

/**
 * Created by martin on 17-5-7.
 */
public class SeventyFive {
    public int distributeCandies(int[] candies) {
        Arrays.sort(candies);
        int count=1;
        int check=candies[0];
        for (int i = 1; i <candies.length ; i++) {
            if(check!=candies[i]){
                count++;
            }
            check=candies[i];
        }
        return Math.min(candies.length/2,count);
    }

    public static void main(String[] args) {
        int a=new SeventyFive().distributeCandies(new int[]{1,1,1,1,2,2,2,3,3,3});
        System.out.println(a);
    }
}
