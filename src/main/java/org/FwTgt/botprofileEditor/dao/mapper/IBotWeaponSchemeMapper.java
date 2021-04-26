package org.FwTgt.botprofileEditor.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.FwTgt.botprofileEditor.domain.BotAttribute;
import org.FwTgt.botprofileEditor.domain.BotWeaponScheme;
import org.apache.ibatis.annotations.*;

import java.math.BigInteger;
import java.util.List;

public interface IBotWeaponSchemeMapper extends BaseMapper<BotWeaponScheme> {
    @Insert("insert into botprofile_weaponschemes values (#{botprofileId},#{weaponSchemeId})")
    public void addRelation(@Param("botprofileId") BigInteger botprofileId,
                                        @Param("weaponSchemeId") BigInteger weaponSchemeId) throws Exception;

    @Select("select * from weaponschemes where id in (" +
            "select weaponSchemeId from botprofile_weaponschemes where botprofileId = #{botprofileId}" +
            ")")
    @Results({
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "name",property = "name"),
            @Result(column = "weapons",property = "weaponPreferences",javaType = java.lang.String.class)
    })
    public List<BotWeaponScheme> selectByBotprofileId(int botprofileId) throws Exception;
}
