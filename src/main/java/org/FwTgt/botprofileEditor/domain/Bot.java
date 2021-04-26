package org.FwTgt.botprofileEditor.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigInteger;

/**
 * 存放一个bot全部的信息
 */
@Data
@TableName("bots")
public class Bot {
    @TableId(type = IdType.AUTO)
    @TableField("id")
    private BigInteger id;

    @TableField("name")
    private String name;

    @TableField("attributeId")
    private BigInteger attributeId;

    @TableField("weaponSchemeId")
    private BigInteger weaponSchemeId;

    @TableField(exist = false)
    private BotAttribute attribute;

    @TableField(exist = false)
    private BotWeaponScheme weaponScheme;

    public boolean hasWeaponScheme(){
        return this.weaponScheme != null;
    }

}
