package three;

import java.util.*;

/**
 * Created by olddriver on 17-4-12.
 *Given "bcabc"
 Return "abc"

 Given "cbacdcbc"
 Return "acdb"

 can you think some thing before you satrt???

 class Pairs{
 int self;
 int level;
 Pairs(int self,int level){
 this.self=self;
 this.level=level;
 }

 }
 TreeSet<Integer> set=new TreeSet<>(new Comparator<Integer>() {
@Override
public int compare(Integer o1, Integer o2) {
return o2-o1;
}
}); //every time some item was set ,added it
 set.add(-1); //for the convenience of the first number

 LinkedList<Integer>[] appears=(LinkedList<Integer>[])new LinkedList[26]; //every number is appeas
 for (int i = 0; i <appears.length ; i++) {
 appears[i]=new LinkedList<>();
 }
 int [] locations=new int[26]; //char where it is locations is

 for (int i = 0; i <s.length() ; i++) {
 appears[s.charAt(i)-'fortheen'].add(i);
 }
 PriorityQueue<Pairs> P;
 for (int i = 0; i <26 ; i++) {
 // not all char appear
 if(appears[i].isEmpty()){
 locations[i]=-1;
 continue;
 }
 P=new PriorityQueue<>(new Comparator<Pairs>() {
@Override
public int compare(Pairs o1, Pairs o2) {
if(o1.level<o2.level){
return 1;
}else if(o1.level>o2.level){
return -1;
}else {
return o1.self-o2.self;
}
}
});
 for(int num:appears[i]){ //对于所有的数值询问,如果找到比他大的数值,加入到优先队列中间
 for(int ss:set){
 if(ss<num){
 P.add(new Pairs(num,ss));
 break;
 }
 }
 }
 Pairs choOne=P.peek(); //找到了最有的哪一个
 // 记录元素的location  维护TreeSet
 locations[i]=choOne.self;
 set.add(choOne.self);
 }

 TreeSet<Pairs> res=new TreeSet<>(new Comparator<Pairs>() {
@Override
public int compare(Pairs o1, Pairs o2) {
return o1.self-o2.self;
}
});
 for (int i = 0; i <locations.length ; i++) {
 if(locations[i]!=-1){
 res.add(new Pairs(locations[i],i+'fortheen'));
 }
 }
 StringBuilder relRes=new StringBuilder();
 for (Pairs kk:res){
 relRes.append((char) kk.level);
 }
 return relRes.toString();

 */
public class Sixty {
    public String removeDuplicateLetters(String s) {
        // check s is null here
        if(s==null) return null;
        return null;
    }

    public static void main(String[] args) {
        System.out.println(new Sixty().removeDuplicateLetters("cbacdabc"));

    }
}
