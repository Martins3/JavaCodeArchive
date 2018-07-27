package zero;

import java.util.*;

/**
 * Created by olddriver on 17-3-28.
 *
 */
public class FiftySeven {
    class Interval {
        int start;
        int end;
        Interval() {
            start = 0;
            end = 0;
        }
        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        class Point {
            private int pos;
            private int es;
            private Point(int pos,int es){
                this.pos=pos;
                this.es=es;
            }
        }
        List<Point> all=new ArrayList<>();
        int size=0;
        for(Interval a:intervals){
            all.add(new Point(a.start,1));
            all.add(new Point(a.end,0));
            size+=2;
        }

        int s=newInterval.start;
        int e=newInterval.end;
        boolean bs=true;
        boolean es=true;
        Queue<Point> S=new LinkedList<Point>();
        int newsize=0;
        for (Point p:all){
            //if pos is equal,set the first
            if(bs&&p.pos>=s){
                S.add(new Point(s,1));
                newsize++;
                bs=false;
            }
            if(es&&p.pos>e){
                S.add(new Point(e,0));
                newsize++;
                es=false;
            }
            S.add(p);
            newsize++;
        }
        if(newsize==(size+1)){
            S.add(new Point(e,0));
        }else if(newsize==size){
            S.add(new Point(s,1));
            S.add(new Point(e,0));
        }
        Queue<Point> q=new ArrayDeque<Point>();
        int starts=0;
        for(Point p:S){
            if(p.es==1){
                starts++;
                if(starts==1) q.add(p);
            }else {
                starts--;
                if(starts==0) q.add(p);
            }
        }
        List<Interval> res=new ArrayList<>();
        while (!q.isEmpty()) {
            int a = q.poll().pos;
            int b = q.poll().pos;
            res.add(new Interval(a, b));
        }
        return res;
    }
    private void test(){
        List<Interval> a=new ArrayList<>();
        a.add(new Interval(1,5));
       // fortheen.add(new Interval(4,5));
        a = insert(a,new Interval(2,3));
        for (Interval s:a){
            System.out.print("("+s.start+" "+s.end+")");
        }
    }

    public static void main(String[] args) {
        new FiftySeven().test();
    }
}
