package five;

/**
 * Created by martin on 17-4-25.
 */
public class FiftyTwo {
    private long countRecord(long[] origin,int n){
        final int di=1000000000+7;
        long x=origin[0];
        long y=origin[1];
        long yy=origin[2];
        long xma=origin[3];
        long yma=origin[4];
        long yyma=origin[5];
        long a=origin[6];
        int i= 1;
        long _x,_y,_yy,_xma,_yma,_yyma,_a;
        while (i!=n){
            i++;
            _x=x+y+yy+a;
            _y=x+a;
            _yy=y;
            _xma=xma+yma+yyma;
            _yma=xma;
            _yyma=yma;
            _a=xma+yma+yyma;

            x=_x%di;
            y=_y%di;
            yy=_yy%di;
            xma=_xma%di;
            yma=_yma%di;
            yyma=_yyma%di;
            a=_a%di;
        }
        return (int)((x+y+yy+xma+yma+yyma+a)%di);
    }
    public int checkRecord(int n) {
        long res1=countRecord(new long[]{0,0,0,1,0,0,0},n);
        long res2=countRecord(new long[]{0,0,0,0,1,0,0},n);
        long res4=countRecord(new long[]{0,0,0,0,0,0,1},n);
        return (int)((res1+res2+res4)%(1000000000+7));
    }
}
