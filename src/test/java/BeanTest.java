import org.FwTgt.botprofileEditor.Application;
import org.FwTgt.botprofileEditor.config.DefaultConfig;
import org.FwTgt.botprofileEditor.utils.BotProfileHandler;
import org.FwTgt.botprofileEditor.utils.ContextWrapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.context.ContextLoader;

import javax.activation.DataHandler;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class BeanTest {
    @Autowired
    private DefaultConfig defaultINF;
    @Test
    public void showINF(){
    }

}
