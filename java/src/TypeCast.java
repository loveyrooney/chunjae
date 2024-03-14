public class TypeCast {
    public static void main(String[] args) {
        //byte short int long float double \n char \n boolean
        //작은 타입은 큰 타입으로 형변환이 가능, 그 역은 성립하지 않는다.
        byte a = 10;
        System.out.println("a is "+a);
        int su = a; //a는 int로 자동 형변환이 일어난다.
        System.out.println("su is "+su);

        double d = 10.8;
        int d2 = (int)d; //강제 형변환
        System.out.println(d2); //소수점 이하 버림

        //2147483647 이하는 int이고, long보다 작으므로 l을 쓰지 않으면 int로 자동형변환
        long e = 2147483648l;
        //f를 쓰지 않는 소수는 double이 디폴트인데, float보다 크므로 에러 발생
        float f = 10.2f;

        //연산자가 포함되면 연산 대상의 타입 중 가장 큰 것으로 결과값의 타입이 결정된다.
        byte b1 = 10;
        byte b2 = 20;
        byte b3 = (byte)(b1+b2); //더한 것이 byte에 해당하면 강제형변환 해줄 수도 있음.
        System.out.println(b3);

        int d1 = 90;
        int e1 = 95;
        int f1 = 83;
        System.out.println((d1+e1+f1)/3); //int type, 연산결과의 소수점 버림
        System.out.println((d1+e1+f1)/3.0); //double type
        System.out.println((d1+e1+f1)/3f); //float type
        //정수의 연산결과가 실수여도 실수로 자동 형변환되지 않는다.

        //char와 int 관계
        char char1 = 'A';
        int data = char1;
        System.out.println(data);
        int data2 = 103;
        char char2 = (char)data2; //char는 int보다 작으므로 강제 형변환을 해야만 가능
        System.out.println(char2);

        //switch문에 들어갈 수 있는 타입 : int(byte,short,char), String, enum
    }
}
