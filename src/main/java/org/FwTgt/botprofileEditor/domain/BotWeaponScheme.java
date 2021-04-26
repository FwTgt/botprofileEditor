package org.FwTgt.botprofileEditor.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.FwTgt.botprofileEditor.domain.enums.EWeapon;

import java.math.BigInteger;
import java.util.List;

/**
 * 存放bot武器模式的全部内容
 */

@Data
@TableName("weaponschemes")
public class BotWeaponScheme {

    @TableId(type = IdType.AUTO)
    @TableField("id")
    private BigInteger id;

    @TableField("name")
    private String name;


    @TableField("weapons")
    private String weaponPreferences;
}
