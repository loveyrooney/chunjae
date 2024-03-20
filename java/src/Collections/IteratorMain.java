package Collections;

import java.util.Enumeration;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Vector;

public class IteratorMain {
    public static void main(String[] args) {
        /* 열거자 : Enumeration
        순서가 보장되어 있지 않은 자료를 나열하는 것.
        Enumeration
        반복자 : Iterator, ListIterator

        */
        Vector<String> vector = new Vector<>();
        vector.add("hong");
        vector.add("kim");
        vector.add("park");
        vector.add("hello");

        //for문 출력
        for(int i=0; i<vector.size(); i++){
            System.out.print(vector.get(i)+" ");
        }
        //Enumeration 출력
        System.out.println();
        Enumeration<String> enu = vector.elements();
        while(enu.hasMoreElements()){
            System.out.print(enu.nextElement()+" ");
        }
        //Iterator 출력
        System.out.println();
        Iterator<String> ita = vector.iterator();
        while(ita.hasNext()){
            System.out.print(ita.next()+" ");
        }

        System.out.println();
        HashSet<Integer> hs = new HashSet<>();
        hs.add(2);
        hs.add(12);
        hs.add(27);
        hs.add(238);
        hs.add(null);

        Iterator<Integer> ita2 = hs.iterator();
        while(ita2.hasNext()){
            System.out.print(ita2.next()+" ");
        }
        System.out.println();
        //향상된 for문에는 hasNext 기능 탑재 되어있다. 출력시에는 사용 가능, 조작할 땐 지양할 것
        for(Integer i:hs) {
            System.out.print(i+" ");
        }


    }
}
