/* singleton pattern
인스턴스를 새로 만들지 않고, 클래스에서 static으로 만들어둔 인스턴스를 가져다 쓰는 디자인 패턴 기법.
DBCP (DataBase Connection Pool), 등의 객체 생성시 시간이 오래 걸리는 특수한 경우에 사용.
상속관계 형성 x
*/
class Super2{
    //클래스 변수로 인스턴스를 만든다.
    private static Super2 instance = new Super2();
    //getter
    public static Super2 getInstance() {
        return instance;
    }
    //생성자로 인스턴스를 만들 수 없도록 private 지정한다.
    private Super2(){}
}
public class Class3 {
    public static void main(String[] args) {
        Super2 ins = Super2.getInstance();
        Super2 ins2 = Super2.getInstance();
        System.out.println(ins==ins2); //클래스에서 이미 만든 인스턴스는 하나이다.

    }
}
