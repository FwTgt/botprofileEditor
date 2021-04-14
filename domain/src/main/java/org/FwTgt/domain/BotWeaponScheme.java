package org.FwTgt.domain;

import org.FwTgt.domain.enums.EWeapon;

import java.util.List;

public class BotWeaponScheme extends Template{

    private String id;
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public List<EWeapon> getWeaponPreferences() {
        return super.getWeaponPreferences();
    }

    @Override
    public void setWeaponPreferences(List<EWeapon> weaponPreferences) {
        super.setWeaponPreferences(weaponPreferences);
    }
}
