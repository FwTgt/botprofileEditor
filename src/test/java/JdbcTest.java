import org.FwTgt.botprofileEditor.Application;
import org.FwTgt.botprofileEditor.dao.mapper.IBotAttributeMapper;
import org.FwTgt.botprofileEditor.dao.mapper.IBotWeaponSchemeMapper;
import org.FwTgt.botprofileEditor.domain.BotAttribute;
import org.FwTgt.botprofileEditor.domain.BotWeaponScheme;
import org.FwTgt.botprofileEditor.domain.enums.EWeapon;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.LinkedList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class JdbcTest {
    @Autowired(required = false)
    private IBotWeaponSchemeMapper weaponSchemeMapper;
    @Autowired(required = false)
    private IBotAttributeMapper attributeMapper;

    @Test
    public void insertWeaponScheme(){
        BotWeaponScheme scheme = new BotWeaponScheme();
        scheme.setName("test");
        List<EWeapon> weaponList =new LinkedList<>();
        weaponList.add(EWeapon.deagle);
        //scheme.setWeaponPreferences(weaponList);

        weaponSchemeMapper.insert(scheme);
    }

    @Test
    public void insertAttribute(){
        BotAttribute attribute = new BotAttribute();
        attribute.setName("test");
        attributeMapper.insert(attribute);
    }

}
