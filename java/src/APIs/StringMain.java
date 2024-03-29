package APIs;

import java.util.StringTokenizer;

public class StringMain {
    public static void main(String[] args) {
        String name = new String(new char[]{'b','y','e'});
        String name2 = new String("hello");
        String name3 = "hong";

        System.out.println(name);
        System.out.println(name2);
        System.out.println(name3);
        System.out.println("------------------");

        String name4 = "hong";
        String name5 = new String("hong");
        //값의 비교
        System.out.println(name3.equals(name4));
        System.out.println(name3.equals(name5));
        //메모리주소 비교
        System.out.println(name3 == name4); //같은 문자열 상수를 가리키고 있다.
        System.out.println(name3 == name5); //다른 문자열 객체를 가리키고 있다.
        //메모리주소와 값이 모두 같은 객체는 동일하다고 하고, 메모리주소는 다르지만 값이 같은 것을 동등하다고 한다.
        /* 문자열 상수(문자열 리터럴)는 heap 메모리 내의 String constant pool에 저장된다.
        일반 인스턴스처럼 계속해서 새롭게 만들지 않고, 같은 문자열을 가리키게 되며, 수정 불가 (immutable)
        "hong"+"gildong" 을 사용하면 기존 "hong"이란 상수가 변경되는 게 아니라 "honggildong"이라는 새로운 문자열 상수 생성.
        new String()은 문자열 객체.
        */

        /* StringBuffer(sync), StringBuilder(async)
        문자열 객체. 각각은 다른 문자열이고, 수정 가능 (mutable)
        append를 이용해 문자열 변경 가능.
        */
        System.out.println("------------------");
        StringBuffer sbf = new StringBuffer(5);
        System.out.println(sbf.capacity());
        System.out.println(sbf.length());
        System.out.println(name3.contentEquals(sbf)); //문자열 상수와 StringBuffer 객체는 달라서, 값의 비교를 위한.
        System.out.println(sbf.hashCode()+","+sbf);
        sbf.append("gildong");
        System.out.println(sbf.hashCode()+","+sbf);
        System.out.println(sbf.capacity());
        System.out.println(sbf.length());
        sbf.append("hong");
        System.out.println(sbf.capacity());

        System.out.println("------------------");
        StringBuilder sbd = new StringBuilder();
        StringBuilder sbd2 = new StringBuilder(10);
        StringBuilder sbd3 = new StringBuilder("hello");
        System.out.println(sbd.capacity()+","+sbd.length());
        System.out.println(sbd2.capacity()+","+sbd2.length());
        System.out.println(sbd3.capacity()+","+sbd3.length());

        sbd.append("hello, world");
        sbd.insert(6,"this is");
        System.out.println(sbd.capacity()+","+sbd.length());
        sbd.trimToSize(); //capacity를 length와 같게 만들어줌
        System.out.println(sbd.capacity()+","+sbd.length());

        /*StringBuilder(CharSequence seq) : CharSequence interface를 상속받고 있는 모든 클래스타입이 들어갈 수 있음.
        즉 저 안에는 new String(""), new StringBuffer() 도 들어갈 수 있다는 것임.
        StringBuilder(String str)은 문자열 상수와 클래스 객체와는 다르므로 오버로딩 한 것
        StringBuilder charSeq = new StringBuilder(new String(new char[]{'b','y','e'}));
        */

        System.out.println("------------------");
        //그 외 여러 api들
        String st = "hello, this is string api";
        char ch = st.charAt(0);
        System.out.println(ch);
        System.out.println(st.indexOf('s',0)); //0번째 인덱스부터 s가 처음으로 나타나는 인덱스
        System.out.println("A".equalsIgnoreCase("a"));
        System.out.println(st.contains("api"));
        System.out.println(st.startsWith("h"));
        System.out.println(st.endsWith("api"));

        //compareTo : 문자열의 인덱스마다 각 문자의 정수값을 비교
        System.out.println("------------------");
        int ct = st.compareTo("hello");
        int ct2 = st.compareTo("string");
        System.out.println(ct);
        System.out.println(ct2);

        //concat : "string"+"string" 과 같은 결과. 새로운 문자열 상수를 만들어 낸다.
        System.out.println("------------------");
        String hello = "hello";
        String data = hello.concat("123"); //hello = data 하는 경우 메모리 누수 발생 가능.
        String data2 = hello+"123";
        System.out.println(data);
        System.out.println(data2);
        System.out.println(data.equals(data2));
        //subString() : 파이썬 슬라이스랑 비슷함
        System.out.println("------------------");
        System.out.println(data.substring(3)); // 3번째부터 끝까지
        System.out.println(data.substring(3,5)); //3번째부터 5번째까지
        String slice = data.substring(3,5);
        System.out.println(slice);
        System.out.println(data==slice);
        System.out.println("------------------");
        String[] split = data2.split("1");
        System.out.println(split[0]);
        System.out.println(split[1]);

        //isBlank(), isEmpty()
        System.out.println("------------------");
        String blank = "   ";
        System.out.println(blank.isBlank());
        System.out.println(blank.isEmpty());

        //StringTokenizer
        System.out.println("------------------");
        StringTokenizer tok = new StringTokenizer("a1 a2 a3");
        System.out.println(tok);
        System.out.println(tok.countTokens());
        boolean hasMore = tok.hasMoreTokens();
        System.out.println(hasMore);
        while(tok.hasMoreTokens()){
            String next = tok.nextToken(); //한번만 사용할 수 있다.
            System.out.println(next);
        }

        tok = new StringTokenizer("b1,b2,b3",",");
        while(tok.hasMoreElements()){
            String next = (String) tok.nextElement();
            System.out.println(next);
        }

    }
}
