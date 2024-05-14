import com.chunjae.aop.service.Service1;
import com.chunjae.aop.service.Service2;
import com.chunjae.aop.service.Service3;
import com.chunjae.aop.target.Target1;
import com.chunjae.aop.target.Target2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.IOException;

@ExtendWith(SpringExtension.class)
@ContextConfiguration({"classpath:aopapp/aopapp1.xml","classpath:aopapp/aopapp2.xml"})
public class aopTest {
    // aspect1 test
    @Autowired
    private Target1 target1;
    @Autowired
    private Target2 target2;
    @Test
    public void t1(){
        target1.target1_prt1();
        target1.target1_prt2();
        target2.target2_prt1();
        target2.target2_prt2();
    }
    // aspect2 test
    @Autowired
    @Qualifier(value = "s1")
    private Service1 service1;

    @Test
    public void t2(){
        service1.prt();
        service1.view();
        try{
            service1.show(2);
            service1.show(-3); // 해당 메서드는 예외 발생하는데, catch block 가기 전에 joinpoint 가 먼저 동작함
        } catch (IOException e){
            System.out.println("test..."+e);
        }
        // after 가 after-returning 이나 after-throwable 보다 먼저 동작함
    }
    // aspect4 (Advice2) test
    @Autowired
    @Qualifier(value = "s2")
    private Service2 service2;
    @Autowired
    @Qualifier(value = "s3")
    private Service3 service3;

    @Test
    public void t3(){
        // before/after 와 around 가 동시에 있으면 around 만 동작한다, after-returning/throwable 은 around 후에 동작한다.
        // 다른 aspect 가 중복 적용되는 경우 모두 동작한다.
        // a1 around - a3 before - business method - a3 after-returning - a3 after - a1 around - a1 after returning
        service2.write();
        int result = service2.read(new String[]{"a1","a2"});
        System.out.println("sout:"+result);
    }

    @Test
    public void t4(){
        service3.write();
    }
    // java aspect (Advice3) test
    @Test
    public void t5(){
        service2.write();
        service2.read();
        int result = service2.read(new String[]{"b1","b2"});
        System.out.println("sout:"+result);
    }

}
