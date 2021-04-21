package org.FwTgt.botprofileEditor.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import org.FwTgt.botprofileEditor.domain.enums.EWeapon;

import java.util.List;

@TableName("weaponschemes")
public class BotWeaponScheme {

    @TableId(type = IdType.AUTO)
    @TableField("id")
    private int id;
    @TableField("name")
    private String name;
    @TableField(exist = false)
    private List<EWeapon> weaponPreferences;
    @TableField("weapons")
    private String weaponPreferencesStr;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<EWeapon> getWeaponPreferences() {
        return weaponPreferences;
    }

    public void setWeaponPreferences(List<EWeapon> weaponPreferences) {
        this.weaponPreferences = weaponPreferences;
    }

    public String getWeaponPreferencesStr() {
        weaponPreferencesStr=new String("");
        for (EWeapon w:weaponPreferences){
            weaponPreferencesStr+=w.name()+" ";
        }
        return weaponPreferencesStr;
    }

    public void setWeaponPreferencesStr(String weaponPreferencesStr) {
        this.weaponPreferencesStr = weaponPreferencesStr;
    }
}
