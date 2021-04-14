package org.FwTgt.data.buffer;

import org.FwTgt.domain.Bot;
import org.FwTgt.domain.BotAttribute;
import org.FwTgt.domain.BotWeaponScheme;

//IDataBuffer接口定义了用来缓存botprofile.db数据所需要的DataBuffer对象应该实现的方法
public interface IDataBuffer {
    public boolean insertWeaponScheme(BotWeaponScheme weaponScheme);    //插入武器优先级
    public boolean insertAttribute(BotAttribute attribute);     //插入bot属性
    public boolean insertBot(Bot bot);      //插入bot
}
