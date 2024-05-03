import com.chunjae.config.ConnectionProvider;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@ExtendWith(SpringExtension.class)
@ContextConfiguration("classpath:jdbc_dbcp.xml")
public class DbcpTest {
    @Autowired
    private ConnectionProvider connectionProvider;
    @Test
    public void t1(){
        Assertions.assertEquals("root",connectionProvider.getUser());
    }

    @Autowired
    @Qualifier("dbmanager_ds")
    private DataSource dataSource;
    @Test
    public void t2() throws SQLException {
        Connection conn = dataSource.getConnection();
        Assertions.assertNotNull(conn);
    }
      //커넥션 생성에서의 예외를 검사하고 싶으면
//    @Test
//    public void t2(){
//        Assertions.assertThrows(SQLException.class,()=>{
//            Connection conn = dataSource.getConnection();
//            Assertions.assertNotNull(conn);
//        });
//    }

}
