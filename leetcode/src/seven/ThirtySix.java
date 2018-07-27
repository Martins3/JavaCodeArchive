package seven;

import javafx.scene.control.TreeTableCell;

import java.util.Stack;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ThirtySix {
    /**
     *
     * @param expression
     * @return expression's value
     *
     * let
     * add
     * assign
     * integer
     * multiply
     *
     * 1. start with lower case number and followed with digit and numbers !
     * 2. add mult and let is kept as protected
     *
     *
     * after the "(" : let add mult
     * every () ending, we will get a value !
     *
     * every time we goes into a circle: we add a new symbol table , every time we goes up, we free the table
     *
     * use a matcher to find all "(" and ")" and return
     *
     * if we found "(" call the function, the kernel part
     *
     * 1. how to make the string transfer by ref !
     */
    public int evaluate(String expression) {
        Stack<TreeMap<String, Integer>> symbolTable = new Stack<>();

        // find the all the start and ending pairs
        TreeMap<Integer, Integer> ending = new TreeMap<>();
        Stack<Integer> open = new Stack<>();
        for (int i = 0; i < expression.length(); i++) {
            if(expression.charAt(i) == '('){
                open.push(i);
            }else if(expression.charAt(i) == ')'){
                ending.put(open.pop(), i);
            }
        }

        // 向下传递数值的时候, 去除所有括号


        return 0;
    }

    private int calculate(Stack<TreeMap<String, Integer>> symbolTable,
                          TreeMap<Integer, Integer> ending, String expr){
        // 本地创建的符号表3
        // find out op
        String[] segments = expr.split(" ", 2);
        String op = segments[0];
        if(op.equals("add") || op.equals("mult")){
            // 确定两个参数的数值的, 然后返回

            // 检查到底是数值 还是 变量
        }else{
            // 从右边向坐逐渐检查, 如果查找多有v e 队列的,


        }
        return  0;

    }

    public static void main(String[] args) {
       String a = "a asdf asdf";
       for(String s: a.split(" ", 2)){
           System.out.println("--------");
           System.out.println(s);
           System.out.println("--------");
       }
    }
}
