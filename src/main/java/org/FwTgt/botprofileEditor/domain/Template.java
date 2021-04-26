package org.FwTgt.botprofileEditor.domain;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import org.FwTgt.botprofileEditor.domain.enums.EDifficulty;
import org.FwTgt.botprofileEditor.domain.enums.EWeapon;
import org.apache.ibatis.annotations.Param;

import javax.accessibility.Accessible;
import java.util.LinkedList;
import java.util.List;

/**
 * 统一用来接收信息，并生成BotAttribute和BotWeaponScheme的模板
 */
@Data
public class Template {
    private String name;
    private int skill;
    private int aggression;
    private float reactionTime;
    private float attackDelay;
    private float aimFocusInitial;
    private float aimFocusDecay;
    private float aimFocusOffsetScale;
    private float aimfocusInterval;

    @Setter(AccessLevel.NONE)
    private List<EWeapon> weaponPreferences;

    @Setter(AccessLevel.NONE)
    private EDifficulty difficulty;

    public Template(){weaponPreferences=new LinkedList<>(); }
    public Template(String name){this.name=name;weaponPreferences=new LinkedList<>();}

    /**
     * 添加武器到weaponPreferences中
     * @param weapon 要添加的武器
     */
    public void addWeaponPreference(String weapon){
        EWeapon[] weapons = EWeapon.values();
        boolean isWeapon=false;
        for(EWeapon w:weapons){
            if(w.name().equals(weapon)){
                isWeapon=true;
                break;
            }
        }
        if(isWeapon){
            weaponPreferences.add(EWeapon.valueOf(weapon));
        }
    }

    /**
     * 把weaponPreferences用空格拼接为一个字符串类型后返回
     * @return
     */
    public String getWeaponPreferencesStr(){
        String weaponPreferencesStr ="";
        for (EWeapon w:weaponPreferences){
            weaponPreferencesStr+=w.name()+" ";
        }
        return weaponPreferencesStr;
    }

    /**
     * 比较要设定的难度类别是否是合法的，合法则加入，不合法则默认设置为EXPERT
     * @param value 要设置的难度类别
     */
    public void setDifficulty(String value){
        EDifficulty[] difficulties=EDifficulty.values();
        boolean isDifficulty=false;
        for(EDifficulty d:difficulties){
            if(d.name().equals(value)){
                isDifficulty=true;
                break;
            }
        }
        if(isDifficulty){
            this.difficulty=EDifficulty.valueOf(value);
        }
        else this.difficulty=EDifficulty.EXPERT;
    }

    /**
     * 把difficulty属性的字符串值直接返回
     * @return 难度枚举的字符串值
     */
    public String getDifficultyStr(){
        return this.difficulty.name();
    }

    /**
     * 把字符类型数据武器和难度加入到模板中
     * @param propertyName 字段名
     * @param value 字段值
     */
    public void setProperty(String propertyName,String value){
        if(propertyName.equals("WeaponPreference")){
            addWeaponPreference(value);
        }
        else if(propertyName.equals("Difficulty")){
            setDifficulty(value.toUpperCase());
        }
    }

    /**
     * 把数字类型数据加入到模板中
     * @param propertyName 字段名
     * @param value 字段值
     */
    public void setProperty(String propertyName,float value) {
        if(value<0.0001){
            value=0.0001f;
        }
        if(value>1000000){
            value = 10000000f;
        }

        Float packagedValue=value;

        if(propertyName.equals("Skill")){
            setSkill(packagedValue.intValue());
        }
        else if(propertyName.equals("Aggression")){
            setAggression(packagedValue.intValue());
        }
        else if(propertyName.equals("ReactionTime")){
            setReactionTime(packagedValue);
        }
        else if(propertyName.equals("AttackDelay")){
            setAttackDelay(packagedValue);
        }
        else if(propertyName.equals("AimFocusInitial")){
            setAimFocusInitial(packagedValue);
        }
        else if(propertyName.equals("AimFocusDecay")){
            setAimFocusDecay(packagedValue);
        }
        else if(propertyName.equals("AimFocusOffsetScale")){
            setAimFocusOffsetScale(packagedValue);
        }
        else if(propertyName.equals("AimfocusInterval")){
            setAimfocusInterval(packagedValue);
        }
    }
    public BotAttribute toBotAttribute(){
        BotAttribute attribute=new BotAttribute();
        attribute.setName(this.name);
        attribute.setSkill(this.skill);
        attribute.setAggression(this.aggression);
        attribute.setReactionTime(this.reactionTime);
        attribute.setAttackDelay(this.attackDelay);
        attribute.setAimFocusInitial(this.aimFocusInitial);
        attribute.setAimFocusDecay(this.aimFocusDecay);
        attribute.setAimFocusOffsetScale(this.aimFocusOffsetScale);
        attribute.setAimfocusInterval(this.aimfocusInterval);
        attribute.setDifficulty(this.getDifficultyStr());
        return attribute;
    }
    public BotWeaponScheme toBotWeaponScheme(){
        BotWeaponScheme botWeaponScheme=new BotWeaponScheme();
        botWeaponScheme.setName(this.name);
        botWeaponScheme.setWeaponPreferences(this.getWeaponPreferencesStr());
        return botWeaponScheme;
    }
}
