import com.chunjae.auto.Autowire1;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Autowire1Test {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:auto.xml");
//        Autowire1 ins = ctx.getBean("byName",Autowire1.class);
//        Autowire1 ins = ctx.getBean("byType",Autowire1.class);
        Autowire1 ins = ctx.getBean("byConstructor",Autowire1.class);
        ins.prt();
    }
}
