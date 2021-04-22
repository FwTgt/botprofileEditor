import org.FwTgt.botprofileEditor.Application;
import org.FwTgt.botprofileEditor.service.BotProfileService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class RWTest {
    @Autowired(required = false)
    private BotProfileService botProfileService;
    @Test
    public void readFile() throws Exception {
        //File file = new File(String.valueOf(this.getClass().getResource("/botprofile/source.db")));
        File file = new File("C:\\Users\\callm\\Documents\\botprofile\\source\\source.db");
        botProfileService.loadProfile(file);
    }
}
