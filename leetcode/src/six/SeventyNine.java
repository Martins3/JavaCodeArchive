package six;

/**
 * Created by martin on 17-9-20.
 */
public class SeventyNine {
    public static void main(String[] args) {
        SeventyNine i = new SeventyNine();
        boolean s = i.judgePoint24(new int[]{9, 1, 1, 2});
        System.out.println(s);
}
    public boolean judgePoint24(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if(j == i){
                    continue;
                }
                for (int k = 0; k < nums.length ; k++) {
                    if(k == i || k == j){
                        continue;
                    }
                    for (int l = 0; l < nums.length; l++) {
                        if(l == i || l == j || l == k){
                            continue;
                        }
                        for (int m = 1; m <= 6; m++) {
                            for (int n = 1; n <=6 ; n++) {
                                for (int o = 1; o <=6 ; o++) {
                                        float r1 = calculator(nums[i], nums[j], m);
                                        if(r1 == Float.MAX_VALUE)
                                            continue;
                                        float r2 = calculator(r1, nums[k], n);
                                        if(r2 == Float.MAX_VALUE)
                                            continue;
                                        float r3 = calculator(r2, nums[l], o);
                                        if(Math.abs(r3 - 24) < 0.01)
                                            return true;

                                        r1 = calculator(nums[i], nums[j], m);
                                        if(r1 == Float.MAX_VALUE)
                                            continue;
                                        r2 = calculator(nums[k], nums[l], n);
                                        if(r2 == Float.MAX_VALUE)
                                            continue;
                                        r3 = calculator(r1, r2, o);
                                        if(Math.abs(r3 - 24) < 0.01)
                                            return true;

                                }
                            }
                        }
                    }
                }
            }
        }
        return  false;
    }

    private static float calculator(float num1, float num2, int op){
        switch (op){
            case 1:
                return num1 + num2;
            case 2:
                return num1 - num2;
            case 3:
                return num1 * num2;
            case 4:
                if(num2 == 0)
                    return Float.MAX_VALUE;
                return num1 / num2;
            case 5:
                return num2 - num1;
            case 6:
                if(num1 == 0)
                    return Float.MAX_VALUE;
                return num2 / num1;
            default:
                System.out.println("wrong");
        }
        return 0;
    }
}
