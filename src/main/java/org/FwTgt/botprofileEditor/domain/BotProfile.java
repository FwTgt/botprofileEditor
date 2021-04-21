package org.FwTgt.botprofileEditor.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BotProfile {
    private Set<BotWeaponScheme> weaponSchemes;
    private Set<BotAttribute> attributes;
    private Set<Bot> bots;

    public BotProfile(){
        weaponSchemes=new HashSet<>();
        attributes=new HashSet<>();
        bots=new HashSet<>();
    }

    public boolean insertWeaponScheme(BotWeaponScheme weaponScheme) {
        return weaponSchemes.add(weaponScheme);
    }

    public boolean insertAttribute(BotAttribute attribute) {
        return attributes.add(attribute);
    }

    public boolean insertBot(Bot bot) {
        return bots.add(bot);
    }


    public List<BotWeaponScheme> getWeaponSchemes() {
        return new ArrayList<>(weaponSchemes);
    }

    public List<BotAttribute> getAttributes() {
        return new ArrayList<>(attributes);
    }

    public List<Bot> getBots() {
        return new ArrayList<>(bots);
    }

    //是否具有特定的属性
    public boolean hasSpecificAttribute(String attributeName) {
        for(BotAttribute a:attributes){
            if(a.getName().equals(attributeName));
            return true;
        }
        return false;
    }

    //是否具有特定的武器模式
    public boolean hasSpecificWeaponScheme(String weaponSchemeName) {
        for(BotWeaponScheme w:weaponSchemes){
            if(w.getName().equals(weaponSchemeName));
            return true;
        }
        return false;
    }

    //取得特定属性，没有则返回null
    public BotAttribute getAttributeByName(String attributeName) {
        for(BotAttribute a:attributes){
            if(a.getName().equals(attributeName)){
                return a;
            }
        }
        return null;
    }

    //取得特定武器模式，没有则返回null
    public BotWeaponScheme getWeaponSchemeByName(String weaponSchemeName) {
        for(BotWeaponScheme w:weaponSchemes){
            if(w.getName().equals(weaponSchemeName)){
                return w;
            }
        }
        return null;
    }



    //获得当前对象存储的信息
    public String getStatus(){
        String status = new String();
        status+="## attributes:\n";
        status+="# count: "+attributes.size()+"\n";
        status+="# values:\n";
        for(BotAttribute i:attributes){
            status+=i.getName()+"\n";
        }
        status+="## weaponSchemes:\n";
        status+="# count: "+weaponSchemes.size()+"\n";
        status+="# values:\n";
        for(BotWeaponScheme i:weaponSchemes){
            status+=i.getName()+"\n";
        }
        status+="## bots:\n";
        status+="# count: "+bots.size()+"\n";
        status+="# values:\n";
        for(Bot i:bots){
            status+=i.getBotAttribute().getName()+" "+i.getName()+": ";
            if(i.getBotWeaponScheme()!=null){
                status+=i.getBotWeaponScheme().getName();
            }
            status+="\n";
        }
        return status;
    }
}
