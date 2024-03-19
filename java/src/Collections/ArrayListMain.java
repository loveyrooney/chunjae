package Collections;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

public class ArrayListMain {
    public static void main(String[] args) {
        /* List : List interface 를 상속받아 만들어짐. 순서를 보장하고, 중복이 허용되는 자료구조.
        ArrayList : 객체 배열, 가변 배열, async, 검색빠름, 추가/삭제 느림 (vector : sync)
        LinkedList : 노드와 노드의 연결, 검색느림, 추가/삭제 빠름
        Collections.synchronized어쩌구()를 쓰면 비동기 자료의 동기화 가능
        */

        //제네릭을 사용하지 않으면 어떤 타입의 객체도 추가 가능.
        ArrayList al = new ArrayList();
        al.add("hong");
        al.add(true);  //이것도 boolean 이 아니라 Boolean wrapper 객체
        al.add(new Date());
        al.add(10);
        for(int i=0; i<al.size(); i++){
            System.out.println(al.get(i)); //배열 요소가 Object 이기 때문에 .get()으로 받아온다.
        }
        String data = (String) al.get(0); //배열 요소가 Object 이기 때문에 강제 형변환 필요
        System.out.println(data);

        //제네릭 사용 : <type> 을 붙이면 꺽쇠 안의 타입으로만 배열 요소들을 구성한다.
        ArrayList<String> gal = new ArrayList(); // 예전에는 new ArrayList<String>(); 으로 썼음.
        gal.add("gong");
        gal.add(new String(new char[]{'g','o','n','g'}));

        String gdata = gal.get(1); //배열 요소를 모두 String으로 지정했기 때문에 형변환 필요 없음
        System.out.println(gdata);
        System.out.println(gal.get(0).hashCode() == gal.get(1).hashCode());
        System.out.println(gal.get(0).equals(gal.get(1)));

        /* ArrayList<int> 라는 것을 쓰고 싶은데 int는 Object 가 아니라서 넣을 수 없다.
        그때 사용하는 것이 Wrapper class 이다. primitive type을 감싸는 클래스
        int => Integer, char => Character 제외하고 primitive type의 앞글자를 Uppercase로 쓰면 된다.
        Wrapper class 는 primitive 와 Object 를 변환해 주는 boxing 기능이 있다.
        */
        ArrayList<Integer> gints = new ArrayList<>();
        gints.add(10); //gints.add(new Integer(10)); 으로 인식 : autoboxing
        int gintsdata = gints.get(0); //(int)gints.get(0); 로 인식 : autoUnboxing
        System.out.println(gintsdata);

        Integer one = 1; //autoboxing
        int one1 = 1; //autoUnboxing
        System.out.println(one.hashCode() == one1);

        //methods
        System.out.println("--------------");
        gal.add("park");
        boolean re = gal.add("kim");
        System.out.println(re);
        re = gal.contains("park");
        System.out.println(re);
        System.out.println(gal.indexOf("park"));

        for(String i: gal){
            System.out.print(i+"\t");
        }
        System.out.println();
        gal.remove(3);
        for(String i:gal){
            System.out.print(i+"\t");
        }
        System.out.println();
        gal.add("lee");
        gal.add("lee");
        for(String i:gal){
            System.out.print(i+"\t");
        }
        System.out.println();
        gal.remove("lee"); //처음 나오는 인덱스 값만 삭제된다.
        for(String i:gal){
            System.out.print(i+"\t");
        }

        System.out.println();
        System.out.println(gal.isEmpty());
        System.out.println(gal.size()); //length 는 정해져있지만 size()는 가변적

        Iterator<String> it = gal.iterator();
        while(it.hasNext()){
            String i = it.next();
            System.out.print(i+"\t");
        }

        System.out.println();
        System.out.println("--------------");
        ArrayList<String> arr = new ArrayList<>(3);
        arr.add("a1");
        arr.add("a2");
        arr.add("a3");
        arr.add("a4");
        arr.add("a5");
        System.out.println(arr.size());
        for(String i: arr){
            System.out.println(i);
        }





    }
}
