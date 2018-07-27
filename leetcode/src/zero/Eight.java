package zero;

/**
 * Created by martin on 17-6-23.
 * https://docs.oracle.com/javase/tutorial/networking/sockets/index.html
 *
 */
public class Eight {
    public int myAtoi(String str) {
        if (str == null || str.length() < 1)
            return 0;


        for (int i = 0; i < str.length() ; i++) {
            char c = str.charAt(i);
            if(c < '0' || c >'9') {
                if (i != 0 || str.charAt(i) == '-')
                    return 0;
            }
        }

        boolean sign = str.charAt(0) == '-';
        // 对于溢出的情况
        StringBuilder builder = new StringBuilder(str);
        while (builder.charAt(0)=='-'&&builder.length()>=2){
            builder = builder.delete(0,1);
        }
        int res = 0;
        if(sign){
            if(str.compareTo("-2147483648")==1||str.length()>10){
                return -2147483648;
            }
            for (int i = 1; i < str.length() ; i++) {
                res += (str.charAt(i) - '0')*Math.pow(10,str.length() - 1 - i);
            }
            return -res;
        }else{
            if(str.compareTo("2147483647")==1||str.length()>10){
                return 2147483647;
            }
            for (int i = 0; i < str.length() ; i++) {
                res += (str.charAt(i) - '0')*Math.pow(10,str.length() - 1 - i);
            }
            return res;
        }
    }
    public static void main(String[] args) {
        System.out.println("22".compareTo("21"));
        System.out.println(new Eight().myAtoi("-123"));
        System.out.println(new Eight().myAtoi("123"));
        System.out.println(new Eight().myAtoi("3"));
        System.out.println(new Eight().myAtoi("-0"));
        System.out.println(new Eight().myAtoi("0111111111111"));
        System.out.println(new Eight().myAtoi("-11111111111111111111111111"));


        System.out.println(Integer.parseInt("1231"));

    }
}
