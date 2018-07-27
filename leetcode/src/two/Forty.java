package two;

import java.util.Arrays;

/**
 * Created by martin on 17-9-28.
 * @似乎含有更加的算法
 * 1. 说好的不检查数组大小的,怎么又开始检查的了
 * 2. bianarySearh 分析错误
 */
public class Forty {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0 || matrix[0].length == 0)
            return false;
        for(int[] arr: matrix){
            if(target < arr[0]){
                break;
            }

            if(target > arr[arr.length - 1]){
                continue;
            }

            if(Arrays.binarySearch(arr, target) >= 0){
                return true;
            }

        }
        return false;
    }
}
