package org.FwTgt.botprofileEditor.dao.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

public interface IRelationMapper {

    @Insert("insert into botprofile_bots values (#{botprofileId},#{botId})")
    public void addBotRelation(@Param("botprofileId") int botprofileId,
                               @Param("botId") int botId) throws Exception;

    @Insert("insert into botprofile_attributes values (#{botprofileId},#{attributeId})")
    public void addAttributeRelation(@Param("botprofileId") int botprofileId,
                                     @Param("attributeId") int attributeId) throws Exception;

    @Insert("insert into botprofile_weaponschemes values (#{botprofileId},#{weaponSchemeId})")
    public void addWeaponSchemeRelation(@Param("botprofileId") int botprofileId,
                                        @Param("weaponSchemeId") int weaponSchemeId) throws Exception;
}
