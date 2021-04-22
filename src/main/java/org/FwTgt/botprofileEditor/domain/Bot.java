package org.FwTgt.botprofileEditor.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName("bots")
public class Bot {
    @TableId(type = IdType.AUTO)
    @TableField("id")
    private int id;
    @TableField("name")
    private String name;
    @TableField("attributeId")
    private int attributeId;
    @TableField("weaponschemeId")
    private int weaponSchemeId;
    @TableField(exist = false)
    private BotAttribute botAttribute;
    @TableField(exist = false)
    private BotWeaponScheme botWeaponScheme;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAttributeId() {
        return botAttribute.getId();
    }

    public void setAttributeId(int attributeId) {
        this.attributeId = attributeId;
    }

    public int getWeaponSchemeId() {
        if(botWeaponScheme!=null){
            return botWeaponScheme.getId();
        }
        return -1;
    }

    public void setWeaponSchemeId(int weaponSchemeId) {
        this.weaponSchemeId = weaponSchemeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BotAttribute getBotAttribute() {
        return botAttribute;
    }

    public void setBotAttribute(BotAttribute botAttribute) {
        this.botAttribute = botAttribute;
    }

    public BotWeaponScheme getBotWeaponScheme() {
        return botWeaponScheme;
    }

    public void setBotWeaponScheme(BotWeaponScheme botWeaponScheme) {
        this.botWeaponScheme = botWeaponScheme;
    }

}
