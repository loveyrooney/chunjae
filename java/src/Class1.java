class Student1 {
    /*
    클래스 안에있는 변수들을 필드(멤버변수) 라고 한다. 필드에는 인스턴스 변수와 클래스 변수가 있다.
    클래스 변수와 클래스 메서드는 static을 붙여 선언하며, 클래스명.변수명/메서드명 으로 사용한다. 인스턴스 변수는 객체명.변수명/메서드명 으로 사용
    인스턴스, 인스턴스 변수는 jvm 메모리의 힙 영역, 인스턴스 메서드/클래스 변수/클래스 메서드는 메서드 영역에 생성.
    */
    String eno;  //계산하지 않는 숫자는 string으로 쓴다.
    String name;
    int age;

    /*
    클래스명과 똑같고, 리턴타입이 없는 메서드 : 생성자
    생성자의 역할은 인스턴스를 만들면서 동시에 매개변수를 통해 받은 값으로 초기화를 할 수 있도록 만든다.
    생성자 함수는 인스턴스가 만들어질 때 자동으로 호출된다. (클래스 메서드는 호출을 별도로 해야 함)
    인스턴스가 만들어질 때 초기에 해야되는 작업들이 생성자 함수에 들어간다.

    오버로딩 : 매개변수의 타입이 다른(개수 및 순서) 함수들을 같은 이름으로 사용할 수 있는 것. (리턴 타입 무관)
    밑에서는 매개변수 없는 생성자와 매개변수 2개 있는 생성자의 이름을 같은 Student로 사용했다. (생성자 오버로딩)
     */

    //기본 생성자. 생성자 함수가 없는 경우 매개변수 없는 기본 생성자가 디폴트로 만들어진다.
    Student1(){
        System.out.println("default constructor");
    }
    Student1(String name, int age){  //필요한 매개변수만 넣어 만든 생성자.
        this.name= name;
        this.age = age;
        System.out.println("this is name/age constructor");
    }

    /* final
    final 변수는 상수(재할당 불가), 최초에 초기화를 하거나, 생성자에서 초기화를 할 수 있도록.
    클래스에 final 변수가 있고 초기화되지 않은경우, 모든 생성자에 매개변수로 넣어줘야 한다.
    final 메서드는 자식클래스에서 재정의 할 수 없으므로 오버라이딩 불가
    final 클래스는 상속이 불가능한 종단클래스
     */

    /* static
    클래스변수(Student1.arr 로 사용), jvm 메모리의 메서드 영역에 생성, 클래스가 로드될때 1회만 최초 실행
    static block에서 static 변수를 초기화 하거나 클래스 로드시 최초 실행 로직 작성
    static method 안에는 인스턴스 변수나 메서드를 사용할 수 없다.

    private final : 객체마다 처음 정의는 다른데 이후에 변경 안하는거, 인스턴스 내 상수
    private static final : 객체마다 처음 정의도 같고 이후에 변경도 안하는 거, 클래스 내 상수
    */
    public static final int[] arr;
    static {
        arr=new int[4];
        for(int i=1; i<arr.length; i++){
            arr[i]=i*10;
        }
    }

    //인스턴스 메서드
    void prt(String word){
        System.out.print(word);
    }
    int prt2(int a, int b){
        System.out.println("this is prt2 method");
        return a+b;
    }
}

public class Class1 {
    public static void main(String[] args) {
        Student1 s1 = new Student1();
        s1.eno = "1111";
        s1.name = "hong";
        s1.age = 10;
        System.out.println(s1); // new Student()의 메모리 주소
        System.out.printf("%s %s %d\n",s1.eno,s1.name,s1.age);

        Student1 s2 = new Student1();
        s2.age = 10;
        System.out.println(s1.age == s2.age); //값이 같다
        System.out.println(s1.equals(s2)); //서로 다른 인스턴스

        s2.age = 20;
//        s1 = s2; //s1이 s2가 가리키는 인스턴스 메모리 주소를 가리키도록 할당
//        System.out.println(s1.equals(s2); //true

        Student1 s3 = s2;
        System.out.println(s3.equals(s2));
        s3.name = "kim";
        System.out.println(s2.name);
        //s2, s3이 같은 인스턴스를 가리키고 있기 때문에 여기저기서 조작할 수 있다.

        s1.prt("hi this is s1 instance");
        s2.prt("hi this is s2 instance");
        System.out.println(s1.prt2(100,90));

        Student1 s4 = new Student1("kim",25);
        System.out.println(s4.name);

        System.out.println(Student1.arr[3]); //static block에서 초기화된 값
        Student1.arr[3] = 365; //배열의 값은 final이 아니다
        System.out.println(Student1.arr[3]);



    }

}
