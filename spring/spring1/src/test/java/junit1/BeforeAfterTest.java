package junit1;

import org.junit.jupiter.api.*;

public class BeforeAfterTest {
    // 각각의 테스트 메서드들은 순서의 보장이 되지 않는다. 그래서 before 와 after를 사용한다.
    @BeforeAll
    public static void beforeAll(){
        System.out.println("before All");
    }
    @AfterAll
    public static void afterAll(){
        System.out.println("after All");
    }
    @BeforeEach // 각 단위 테스트 메서드의 실행 전에 항상 동작
    public void b1(){
        System.out.println("this is before");
    }
    @AfterEach // 각 단위 테스트 메서드의 실행 후에 항상 동작
    public void a1(){
        System.out.println("this is after");
    }
    @Test
    public void t1(){
        System.out.println("this is t1");
    }
    @Test
    public void t2(){
        System.out.println("this is t2");
    }
}
