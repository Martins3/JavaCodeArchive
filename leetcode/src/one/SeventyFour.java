package one;

import java.util.Arrays;

/**
 * Created by martin on 17-9-28.
 * 似乎是一个更加高效的查找算法
 * 1.
 */
public class SeventyFour {
    public static void main(String[] args) {
        SeventyFour sf = new SeventyFour();
        int a = sf.checkSwithc();
        System.out.println(a);
        boolean s = sf.searchMatrix(new int[][]{{1, 3}}, 2);
        System.out.println(s);
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length ==0 || matrix[0].length == 0){
            return false;
        }
        int low = 0;
        int height = matrix.length - 1;
        int mid = (low + height) / 2;
        boolean flag = false;
        while (low <= height){
            switch (pos(target, matrix[mid])){
                case -1:
                    height = mid - 1;
                    mid = (height + low) / 2;
                    break;
                case 1:
                    low = mid + 1;
                    mid = (height + low) / 2;
                    break;
                case 0:
                        flag = true;
                        break;

            }
            if(flag) {
                if (Arrays.binarySearch(matrix[mid], target) >= 0){
                    return true;
                }else {
                    return false;
                }
            }

        }

        return false;
    }

    private static int pos(int num, int[] arr){
        // 左边返回 - 1 , 右边返回 1
        if(num < arr[0])
            return -1;

        if(num > arr[arr.length - 1])
            return 1;

        return 0;
    }

    private int checkSwithc(){
        int i = 0;
        switch (i){
            case 0:
                return 1;
        }
        return 0;
    }
}
