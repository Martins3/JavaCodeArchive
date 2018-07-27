package six;

import java.util.Comparator;
import java.util.List;
import java.util.Stack;
import java.util.TreeSet;

/**
 * Created by martin on 17-10-5.
 */
public class Ninty {
    class Employee {
        // It's the unique id of each node;
        // unique id of this employee
        public int id;
        // the importance value of this employee
        public int importance;
        // the id of direct subordinates
        public List<Integer> subordinates;
    }
    public int getImportance(List<Employee> employees, int id) {
        return 1;
    }

}
