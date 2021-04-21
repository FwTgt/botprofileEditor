package org.FwTgt.botprofileEditor.domain;

public class Bot {
    private int id;
    private String name;
    private BotAttribute botAttribute;
    private BotWeaponScheme botWeaponScheme;

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
