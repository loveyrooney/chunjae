public class Variable {
    public static void main(String[] args) {
        /* 전역변수와 지역변수
           지역변수는 jvm 메모리의 stack에 저장이 된다.
         */
        int su=10;
        {
            int su2=20;
            System.out.println(su+","+su2);
        }
        //System.out.println(su+","+su2);  su2는 지역변수기 때문에 여기서 불러올 수 없다.

        //final, 변경 불가능한 상수. js에서 const이다.
        final int su3=5;
        final int su4; su4=6;
        //final 상수는 할당을 하기 전에는 아예 메모리에 올리지 않는다. js는 할당이 없으면 undefined를 할당
        //변수는 선언만 해도 메모리에 올림.

    }
}
