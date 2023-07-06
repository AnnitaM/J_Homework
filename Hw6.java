import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class Hw6 {
    public static void main(String[] args) {
        MySet myobj = new MySet();
        System.out.println(myobj.isEmpty());
        System.out.println(myobj.add(1));
        System.out.println(myobj.add(1));
        System.out.println(myobj.add(2));
        HashSet<Integer> myHS = new HashSet<>();
        myHS.add(10);
        System.out.println(myobj.del(2));
        System.out.println(myobj.del(11));
        System.out.println(myobj.isEmpty());
        System.out.println(myobj.contains(0));
        myobj.add(20);
        System.out.println(myobj.get(1));

        Iterator<Integer>iterator = myobj.iterator();
        while (iterator.hasNext()) {
            int i=iterator.next();
            System.out.println(i);
        }
    }
}

class MySet {
    private HashMap<Integer, Object> myDB = new HashMap<>();
    private static Object MYOBJ = new Object();

    public boolean add(int elem) {
        return myDB.put(elem, MYOBJ) == null;
    }

    public boolean del(int elem) {
        return myDB.remove(elem) == MYOBJ;
    }

    public boolean isEmpty() {
        return myDB.size() == 0;
    }

    public boolean contains(int elem) {
        return myDB.containsKey(elem);
    }

    public int get(int index) {
        Object[] a = myDB.keySet().toArray();
        return (int) a[index];
    }

    public Iterator<Integer> iterator() {
        return myDB.keySet().iterator();
    }
}