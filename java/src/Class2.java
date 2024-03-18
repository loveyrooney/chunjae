//상속 : 자식 클래스는 하나의 부모 클래스만을 가질 수 있다. (다중 상속 불가)
/* 접근제한자 : 변수나 메서드, 생성자, 클래스(public, default만 사용가능)의 접근 가능 영역을 결정
private : 해당 클래스 내에서만
default (아무것도 안 붙은): 같은 패키지 내에서만
protected : 같은 패키지 내에서, 다른 패키지인 경우 상속관계 클래스만
public : 전체 접근 가능
*/
/* 클래스의 관계
is-A : 상속관계인 클래스 ex) Sub1 클래스는 Super1 클래스이다.
has-A : 클래스를 포함하고 있는 클래스 ex) Super1 클래스는 String 클래스를 포함하고 있다.
*/

//부모클래스
class Super1{
    private String name;
    private int age;
    public Super1(){
        System.out.println("super1 constructor");
    }
    public Super1(String name,int age){
        this.name = name;
        this.age = age;
        System.out.println("super1 constructor:"+name);
    }
    void prt(){
        System.out.println("super1 method:"+name+age);
    }
}

//자식클래스
class Sub1 extends Super1{
    private int age;
    private String address;
    private String tel;

    public Sub1(String name, int age, String address){
        //자식 생성자 맨 윗줄에는 super(); 생성자가 생략되어 있다.
        //부모에 기본생성자가 없는 경우, 부모의 생성자가 요구하는 매개변수를 super에 넣어주면 된다.
        super(name,age);
        this.address = address;
        System.out.println("sub1 constructor:"+address);
    }
    public Sub1(int age, String address){
        this.age = age;
        this.address = address;
    }
    public Sub1(int age, String address, String tel){
        //this 생성자
        this(age, address);
        //this 참조변수
        this.tel = tel;
    }
    /* override : 상속관계에서 부모클래스에 정의된 메서드를 자식클래스에서 재정의한 것
    메서드 이름, 리턴 타입, 매개변수의 타입과 개수, 순서가 모두 같아야 한다.
    구별되지 않는 함수인데 구별을 하는 행위. 어노테이션으로 표시한다.
    부모 메서드의 접근제한자보다 같거나 더 넓은 범주의 접근제한자만 사용 가능.
    부모 메서드의 exception 개수보다 같거나 작아야 오버라이딩 가능. (익셉션의 부모를 가져오면 상속받는 모든 익셉션이 해당된다)
    부모 메서드가 private인 경우 자식 클래스에서 접근할 수 없으므로 오버라이딩 불가.
    */
    @Override
    public void prt(){
        //super 참조변수
        super.prt(); //오버라이딩을 한 상황에서 부모의 내용도 보고 싶으면 (다른 메서드에 새로 정의하기도 가능)
        System.out.println("sub1 override:"+address);
    }
    //함수의 오버로딩은 오버라이딩과 관계 없이 가능하다.
    public void prt(String comment){
        System.out.println("sub1 method :"+comment);
    }



}
public class Class2 {
    public static void main(String[] args) {
        Super1 super1 = new Super1("kim",20);
        super1.prt();
        Sub1 sub1 = new Sub1("lee",10,"seoul");
        System.out.println("------------------");
        sub1.prt();
        //부모의 함수를 상속받아 쓰려는 경우, Sub1의 생성자에서 super로 매개변수 안넘겨주면 값이 없고, 넘겨주면 값이 나온다.
        //오버라이딩 한 경우, super 전달여부와 관계없고 오버라이드 메소드의 내용이 동작한다.
        System.out.println("------------------");
        sub1.prt("hello");

    }
}
