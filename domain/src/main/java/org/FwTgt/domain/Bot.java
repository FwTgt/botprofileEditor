package org.FwTgt.domain;

public class Bot {
    private String id;
    private String name;
    private BotAttribute botAttribute;
    private BotWeaponScheme botWeaponScheme;

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

    public BotAttribute getDifficulty() {
        return botAttribute;
    }

    public void setDifficulty(BotAttribute botAttribute) {
        this.botAttribute = botAttribute;
    }

    public BotWeaponScheme getLocation() {
        return botWeaponScheme;
    }

    public void setLocation(BotWeaponScheme botWeaponScheme) {
        this.botWeaponScheme = botWeaponScheme;
    }
}
