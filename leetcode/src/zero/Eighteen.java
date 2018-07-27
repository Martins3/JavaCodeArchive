package zero;

import mytools.DoArray;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by olddriver on 17-3-23.
 * Given an array S of n integers, are there elements fortheen, b, c,
 * and d in S such that fortheen + b + c + d = target?
 * Find all unique quadruplets in the array which gives the sum of target.
 */

/**
 *quesiotn like this should be analyzed systemly
 *
*/

/** others' answer haven't been read
* */
public class Eighteen {
    public List<List<Integer>> fourSum(int[] nums, int target) {


        /*what haven't been carefully thought about:
        * if the same one: should jump it */
        List<List<Integer>> res=new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i <nums.length-3 ; i++) {
            if(i!=0 && nums[i]==nums[i-1]) continue;// add for because the same result is unceppted!
            for (int j = i+1; j <nums.length-2 ; j++) {
                if(j!=i+1 && nums[j]==nums[j-1]) continue;
                for (int k = j+1; k <nums.length-1 ; k++) {
                    if(k!=j+1 && nums[k]==nums[k-1]) continue;
                    int index=Arrays.binarySearch(nums,k+1,nums.length,target-nums[i]-nums[j]-nums[k]);
                    if(index>0){
                        List<Integer> temp=new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);
                        temp.add(nums[index]);
                        res.add(temp);
                    }

                }

            }
            
        }


        return res;
    }
    public void testSyntax(){
        int[] a={1,2,3,4,5,6,8,6,345};
        Arrays.sort(a);
        DoArray.printIntArray(a);
        int b = Arrays.binarySearch(a,2,8,2);
        System.out.println(b);

    }
    public static void main(String[] args) {
        Eighteen eighteen=new Eighteen();
        eighteen.testSyntax();

        // do some basic test
        int[] S ={-3,-2,-1,0,0,1,2,3};
        DoArray.printIntArray(S);
        for(List<Integer> a:eighteen.fourSum(S,0)){
            for(Integer m:a){
                System.out.print(m+" ");
            }
            System.out.println();
        }

    }


}
