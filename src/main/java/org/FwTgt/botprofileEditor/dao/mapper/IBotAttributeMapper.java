package org.FwTgt.botprofileEditor.dao.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.FwTgt.botprofileEditor.domain.BotAttribute;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface IBotAttributeMapper extends BaseMapper<BotAttribute> {
    @Insert("insert into botprofile_attributes values (#{botprofileId},#{attributeId})")
    public void addRelation(@Param("botprofileId") BigInteger botprofileId,
                            @Param("attributeId") BigInteger attributeId) throws Exception;

    @Select("select * from attributes where id in (" +
            "select attributeId from botprofile_attributes where botprofileId = #{botprofileId}" +
            ")")
    public List<BotAttribute> selectByBotprofileId(int botprofileId) throws Exception;
}
