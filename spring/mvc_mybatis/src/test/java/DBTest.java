import com.zaxxer.hikari.HikariConfig;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.sql.DataSource;

@ExtendWith(SpringExtension.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/applicationContext.xml")
public class DBTest {
    @Autowired
    @Qualifier("dbconf")
    private HikariConfig hikariConfig;

    @Test
    public void t1(){
        Assertions.assertNotNull(hikariConfig);
    }

    @Autowired
    @Qualifier("ds")
    private DataSource ds;

    @Test
    public void t2(){
        Assertions.assertNotNull(ds);
    }

    @Autowired
    private SqlSessionFactoryBean factory;

    @Test
    public void t3(){
        Assertions.assertNotNull(factory);
    }

}
