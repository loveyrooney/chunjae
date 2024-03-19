package Collections;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Stack;

public class ListMain {
    public static void main(String[] args) {
        /* List : List interface 를 상속받아 만들어짐. 순서를 보장하고, 중복이 허용되는 자료구조.
        ArrayList : 객체 배열, 가변 배열, async, 검색빠름, 추가/삭제 느림 (vector : sync)
        LinkedList : 노드와 노드의 연결, 검색느림, 추가/삭제 빠름
        Collections.synchronizedList()를 쓰면 비동기 자료의 동기처리 가능
        */
        //Linked List
        LinkedList<String> arr = new LinkedList<>();
        arr.add("hong");
        arr.add("park");
        arr.add(1,"kim");
        System.out.println(arr.size());
        for (int i=0; i<arr.size(); i++)
            System.out.print(arr.get(i)+" ");
        System.out.println();
        System.out.printf("%s, %s\n",arr.getFirst(),arr.getLast());
        System.out.println(arr.pollFirst());
        System.out.println(arr.peekFirst());
        System.out.println(arr.pop());
        System.out.println(arr.getFirst());

        //Stack : Vector를 상속받음
        System.out.println("-------------------");
        Stack<String> stack = new Stack<>();
        System.out.println(stack.empty());
        String data = stack.push("a1");
        System.out.println(data);
        stack.push("a2");
        stack.push("a3");
        System.out.println(stack.pop()); //스택 최상위 요소 꺼내서 리턴
        System.out.println(stack.indexOf("a2"));
        System.out.println(stack.peek()); //스택 최상위 요소를 리턴

        //Queue
        System.out.println("-------------------");
        PriorityQueue<Integer> q = new PriorityQueue<>();
        q.offer(10);
        q.offer(20);
        q.offer(30);
        Iterator<Integer> iterator = q.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println(q.poll());
        System.out.println(q.poll());
        System.out.println(q.poll());
        System.out.println(q.poll());
        System.out.println(q.offer(100));
        q.offer(200);
        System.out.println(q.peek()); //큐의 최상위 요소 리턴

    }
}
