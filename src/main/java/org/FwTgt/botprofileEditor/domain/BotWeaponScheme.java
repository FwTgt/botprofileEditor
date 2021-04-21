package org.FwTgt.botprofileEditor.domain;

import org.FwTgt.botprofileEditor.domain.enums.EWeapon;

import java.util.List;

public class BotWeaponScheme {

    private int id;
    private String name;
    private List<EWeapon> weaponPreferences;
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
