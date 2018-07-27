package four;

import mytools.DoArray;

/**
 * Created by olddriver on 17-4-15.
 *
 *
 */
public class NintySix {
  /*  public int[] nextGreaterElement(int[] findNums, int[] nums) {
        Map<Integer, Integer> map = new HashMap<>(); // map from x to next greater element of x
        Stack<Integer> stack = new Stack<>();
        for (int num : nums) {
            while (!stack.isEmpty() && stack.peek() < num)
                map.put(stack.pop(), num);
            stack.push(num);
        }
        for (int i = 0; i < findNums.length; i++)
            findNums[i] = map.getOrDefault(findNums[i], -1);
        return findNums;
    }*/
    public int[] nextGreaterElement(int[] findNums, int[] nums) {
        boolean found;
        boolean bigger;
        for (int i = 0; i <findNums.length ; i++) {
            found=false;
            bigger=false;
            for (int j = 0; j <nums.length ; j++) {
                if(findNums[i]==nums[j]){
                    found=true;
                }else if(found){
                    if(nums[j]>findNums[i]){
                        findNums[i]=nums[j];
                        bigger=true;
                        break;
                    }
                }
            }
            if(!bigger){
                findNums[i]=-1;
            }
        }
        return findNums;
    }
    public static void main(String[] args) {
        DoArray.printIntArray(new NintySix().nextGreaterElement(new int[]{4,1,2},new int[]{1,3,4,2}));
    }
}
