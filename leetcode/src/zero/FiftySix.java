package zero;

import java.util.*;


/**
 * Created by olddriver on 17-3-28.
 *
 */

public class FiftySix {
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



    public List<Interval> merge(List<Interval> intervals) {
        class Point {
            private int pos;
            private int es;
            private Point(int pos,int es){
                this.pos=pos;
                this.es=es;
            }
        }
        List<Point> all=new ArrayList<>();
        for(Interval a:intervals){
            all.add(new Point(a.start,1));
            all.add(new Point(a.end,0));
        }
        Collections.sort(all, new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                if(o1.pos>o2.pos){
                    return 1;
                }else if(o1.pos<o2.pos){
                    return -1;
                }else if(o1.es>o2.es){
                    return -1;
                }else if(o1.es==o2.es){
                    return 0;
                }else {
                    return 1;
                }

            }
        });
        Queue<Point> q=new ArrayDeque<Point>();
        int starts=0;
        for(Point p:all){
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
        a.add(new Interval(1,4));
        a.add(new Interval(4,5));
        a=merge(a);
        for (Interval i:a){
            System.out.printf("%d %d ",i.start,i.end);
        }
    }

    public static void main(String[] args) {
        FiftySix f=new FiftySix();
        f.test();
    }
}
