public class Operator {
    public static void main(String[] args) {
        byte a = 10;
        int b = -a; //byte b는 될 수 없다. 부호연산자는 int

        //증감연산자 전위/후위 차이에 대해 분명히 할 것
        int c = 10;
        int d = ++c; // 증가를 하고, 그 자체를 할당. c는 11, d는 11
        int e = c++; // 할당을 한 뒤, 원값을 증가. c는 12, e는 11
        System.out.println(c);

        //이항연산자
        int su1 = 10;
        int su2 = 3;
        int add, sub, mul, div, mod;
        add = su1+su2;
        sub = su1-su2;
        mul = su1*su2;
        div = su1/su2;
        mod = su1%su2;
        System.out.println("add: "+add);
        System.out.println("sub: "+sub);
        System.out.println("mul: "+mul);
        System.out.println("div: "+div); //int
        System.out.println("mod: "+mod);
        //NaN, infinity 의 경우는 ArithmeticException 발생

        //논리연산자
        boolean r1 = true;
        boolean r2 = false;
        System.out.println(r1 && r2); //false가 나올 가능성이 많은 것을 앞에다 두면 연산시간 감소
        System.out.println(r1 || r2); //true가 나올 가능성이 많은 것을 앞에다 두면 연산시간 감소
        System.out.println(!r1);
        System.out.println(r1^r2); // xor

        //조건연산자 (삼항연산자)
        int su3 = 80;
        String result = (su3>=60)? "yes":"no";
        System.out.println(result);

        //비교 연산자는 primitive type에서만 가능. String은 primitive가 아니므로 .equals()를 쓰는 것이다.

    }
}
