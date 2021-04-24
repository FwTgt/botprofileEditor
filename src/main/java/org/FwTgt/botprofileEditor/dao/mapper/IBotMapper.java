package org.FwTgt.botprofileEditor.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.FwTgt.botprofileEditor.domain.Bot;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IBotMapper extends BaseMapper<Bot> {
    @Insert("insert into botprofile_bots values (#{botprofileId},#{botId})")
    public void addRelation(@Param("botprofileId") int botprofileId,
                               @Param("botId") int botId) throws Exception;

    @Select("select * from bots where id in (" +
            "select botId from botprofile_bots where botprofileId = #{botprofileId}" +
            ")")
    @Results({
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "name", property = "name"),
            @Result(column = "attributeId", property = "attributeId"),
            @Result(column = "weaponSchemeId", property = "weaponSchemeId"),
            @Result(column = "attributeId", property = "botAttribute",
                    javaType = org.FwTgt.botprofileEditor.domain.BotAttribute.class,
                    one = @One(select = "org.FwTgt.botprofileEditor.dao.mapper.IBotAttributeMapper.selectById")),
            @Result(column = "weaponSchemeId", property = "botWeaponScheme",
                    javaType = org.FwTgt.botprofileEditor.domain.BotWeaponScheme.class,
                    one = @One(select = "org.FwTgt.botprofileEditor.dao.mapper.IBotWeaponSchemeMapper.selectById"))
    })
    public List<Bot> selectByBotprofileId(int botprofileId) throws Exception;

}
