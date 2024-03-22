package Collections;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Objects;

class Name{
    private String firstName;
    private String lastName;

    public Name(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Name name = (Name) o;
        return Objects.equals(firstName, name.firstName) && Objects.equals(lastName, name.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName);
    }
}
public class MapMain {
    public static void main(String[] args) {
        /* Map : Map interface 상속받아 만들어짐.
        순서 보장 x(index 없음, get(key)사용, iterator 로 출력), 키와 밸류로 이루어진 자료구조. 중복(동등)은 키는 x 밸류는 허용
        HashTable(sync), HashMap(async) : key 들을 16개의 버킷으로 나누어 관리. key 의 해시코드를 통해 어떤 버킷에 배정할지 결정한다.
        Collections.synchronizedMap()으로 비동기 자료의 동기처리 가능.
        Map<K,V> syncMap = Collections.synchronizedMap(new HashMap<>());
        HashTable<K,V> hashtable = new HashTable<>();
        */

        HashMap<String, Integer> hm = new HashMap<>();
        System.out.println(hm.put("a1",10)); //put()은 해당 키의 이전에 있던 value 값을 리턴한다.
        hm.put("a2",20);
        hm.put("a3",30);
        hm.put("a3",40); //키 값이 중복되면 덮어씌운다. 문자열 상수
        hm.put(new String("a3"),50); //문자열 객체 모두 중복으로 인식한다.
        hm.put("a4",40); //밸류 값은 중복이 허용된다.

        //출력할 때 하나하나 값을 get으로 받아오지 않는다.
//        System.out.println(hm.get("a1"));
//        System.out.println(hm.get("a2"));
//        System.out.println(hm.get("a3"));

        //key 들을 한꺼번에 가져와서 출력한다. 이때 keySet()을 사용한다.
        //keySet()은 set 타입이다.
        //1. iterator 활용
        Iterator<String> iterKey = hm.keySet().iterator();
        while(iterKey.hasNext()){
            String key = iterKey.next();
            System.out.printf("%s : %d\n",key,hm.get(key));
            //get 을 하는 순간 key 의 해시코드를 통해 key 가 담겨있는 버킷에 가서 버킷 내에서 key-value 탐색을 시작한다.
        }
        System.out.println("--------------------------");
        //2. 향상된 for문 활용
        for(String s:hm.keySet())
            System.out.println(s+" : "+hm.get(s));

        HashMap<Name,Integer> hm2 = new HashMap<>();
        hm2.put(new Name("hong","gildong"),10);
        hm2.put(new Name("hong","gildong"),20);
        hm2.put(new Name("park","gildong"),25);
        int num = hm2.get(new Name("hong","gildong"));
        System.out.println(num);
        /* hong gildong 3개는 본래 모두 해시코드가 다른 새로운 객체이다.
        이것을 값이 같으면 같은 것으로 만들려면 Name 이라는 클래스에 equals 와 hashcode 메서드를 오버라이딩 하여
        값이 같으면 같은 객체로 인식하도록 만들어야 한다.
        */



    }
}