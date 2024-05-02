import com.chunjae.beans1.Component1;
import com.chunjae.beans2.Component2;
import org.springframework.context.support.GenericXmlApplicationContext;

public class ComponentMain {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:component.xml");
        Component1 com1 = ctx.getBean("com1",Component1.class);
        Component2 component2 = ctx.getBean("component2",Component2.class);
        com1.prt();
        component2.view();
    }
}
