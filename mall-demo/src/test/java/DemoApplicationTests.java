import com.bee.mall.demo.DemoApplication;
import com.bee.mall.demo.controller.UserController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * description: 用户测试类 <br>
 * date: 2021/1/21 23:09 <br>
 * author: Administrator
 * version: 1.0 <br>
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class DemoApplicationTests {

    @Resource
    private UserController userController;

    @Test
    public void testGetList() {
        System.out.println(userController.getList());
    }
}
