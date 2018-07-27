package one;

import java.util.LinkedList;
import java.util.Vector;


/**
 *
 * Created by martin on 17-9-26.
 * 1. 结束的原因没有分析清楚
 * 2. 没有分析就是开始编译,失去训练效果
 * 3. 出现错误没有仔细分析 从 数据组(2 3) ,修改之后没有review
 * 4. 很有可能是前面的位置不是一个循环体的一部分
 * 5. indexOutofBound 没有检查
 * 6. 再次没有分析清除 对于1 3 的就是没有检查, 设计的框架含有问题
 * 7. 未经思考, 1 99 的情况没有考察
 */
public class SixtySix {
    public static void main(String[] args) {
        SixtySix ss = new SixtySix();
        int a = 1;
        int b = 3;
        System.out.println(ss.fractionToDecimal(a, b));
        System.out.println(1 / 6.0);
    }
    public String fractionToDecimal(int numerator, int denominator) {
        if(denominator == 0)
            return null;

        int integer = numerator / denominator;
        int fraction = numerator % denominator;
        if(fraction == 0)
            return "" + integer;

        Vector<Integer> s = new Vector<>();
        fraction = 10 * fraction;
        s.add(fraction / denominator);
        fraction = fraction % denominator;
        Vector<Integer> residual = new Vector<>();
        residual.add(fraction);

        while (fraction !=0){
            fraction = 10 * fraction;
            s.add(fraction / denominator);
            fraction = fraction % denominator;


            if(residual.contains(fraction)){
                StringBuilder first = new StringBuilder();
                StringBuilder second = new StringBuilder();
                boolean check = true;
                for (int i = 0; i < residual.size() + 1 ; i++) {
                    if(check && residual.get(i) == fraction){
                        check = false;
                        first.append(s.get(i));
                    }else{
                        second.append(s.get(i));
                    }
                }

                // 补丁
                if(second.length() == 1){
                    if(first.length() == 1 && first.charAt(0) == second.charAt(0)){
                        return integer + "." + "(" + first.toString() + ")";
                    }
                }
                return integer + "."  + first.toString() + "(" + second.toString() + ")";
            }
            residual.add(fraction);
        }

        StringBuilder sb = new StringBuilder();
        for(int i:s){
            sb.append(""+i);
        }
        return integer + "." + sb.toString();
    }
}
