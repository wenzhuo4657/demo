
import org.example.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class text_mp {


    @Autowired
    private UserMapper user;


    @Test
    public  void test(){
        System.out.println(user.selectList(null));

    }
}
