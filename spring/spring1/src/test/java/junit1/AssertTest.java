package junit1;

import org.junit.jupiter.api.Assertions;
// static import 를 쓰면 메서드 이름만 사용가능
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

// unit test 는 test 메서드에 하나의 기능만을 테스트 한다.
public class AssertTest {
    @Test
    public void equals_same_stringLiteral(){
        String name  = "hong";
        String irum = "hong";
        // assert : 비교, 조건, null 확인 등에 활용
        assertEquals(name,irum); // 두 매개변수의 값이 같은지
        Assertions.assertSame(name,irum); // 두 객체의 메모리 주소가 같은지
    }
    @Test
    public void equals_same_stringObj(){
        String name = "hong";
        String name2 = new String("hong");
        assertEquals(name,name2);
        Assertions.assertSame(name,name2);
    }
    @Test
    public void notNull(){
        String[] result = new String[2];
        Assertions.assertNull(result[0]); // not null check
    }
    @Test
    public void arrayEquals_same(){
        int[] ints = new int[2];
        int[] ints2 = new int[2];
        Assertions.assertArrayEquals(ints,ints2); // 두 배열의 값이 같은지
        Assertions.assertSame(ints,ints2);
    }
    @Test
    public void exception_test(){
        String[] arr = {"hong","kim",null};
        // 기대되는 에러가 발생하면 test 성공. 정상동작 뿐 아니라 예상되는 예외를 테스트 할 수 있어야 한다.
        assertThrows(ArrayIndexOutOfBoundsException.class,()->{
            arr[2] = "park";
        });
    }
    @Test
    public void exception_test2(){
        assertThrows(NumberFormatException.class,()->{
            int num = Integer.parseInt("a");
        });

    }

}
