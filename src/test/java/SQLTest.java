import org.FwTgt.botprofileEditor.Application;
import org.FwTgt.botprofileEditor.dao.mapper.IBotMapper;
import org.FwTgt.botprofileEditor.domain.Bot;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class SQLTest {
    @Autowired(required = false)
    private IBotMapper botMapper;
    /*@Test
    public void getBotsTest() throws Exception {
        List<Bot> bots = botMapper.selectByBotprofileId(1);
        for(Bot b:bots){
            System.out.print(b.getName()+"-"+b.getBotAttribute().getName()+"+");
            if(b.getBotWeaponScheme()!=null){
                System.out.print(b.getBotWeaponScheme().getName());
            }
            System.out.println();
        }
    }*/
}
