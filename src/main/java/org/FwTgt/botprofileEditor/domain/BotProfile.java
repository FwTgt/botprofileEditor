package org.FwTgt.botprofileEditor.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.lang.reflect.Type;
import java.math.BigInteger;
import java.util.*;

/**
 * 一个BotProfile类可以完整存储一个botprofile.db文件到内存中。
 */

@Data
@TableName("botprofiles")
public class BotProfile {

    @TableId(type = IdType.AUTO)
    @TableField("id")
    private BigInteger id;

    @TableField("name")
    private String name;

    @TableField(exist = false)
    private Map<String,BotWeaponScheme> weaponSchemes;

    @TableField(exist = false)
    private Map<String,BotAttribute> attributes;

    @TableField(exist = false)
    private Set<Bot> bots;

    @TableField("teamwork")
    private int teamwork;

    @TableField("lookAngleMaxAccelNormal")
    private float lookAngleMaxAccelNormal;

    @TableField("lookAngleStiffnessNormal")
    private float lookAngleStiffnessNormal;

    @TableField("lookAngleDampingNormal")
    private float lookAngleDampingNormal;

    @TableField("lookAngleMaxAccelAttacking")
    private float lookAngleMaxAccelAttacking;

    @TableField("lookAngleStiffnessAttacking")
    private float lookAngleStiffnessAttacking;

    @TableField("lookAngleDampingAttacking")
    private float lookAngleDampingAttacking;

    public BotProfile() {
        this.weaponSchemes = new LinkedHashMap<>();
        this.attributes = new LinkedHashMap<>();
        this.bots = new LinkedHashSet<>();
    }

    public void insertWeaponScheme(BotWeaponScheme weaponScheme) {
        this.weaponSchemes.put(weaponScheme.getName(),weaponScheme);
    }

    public void insertAttribute(BotAttribute attribute) {
        this.attributes.put(attribute.getName(),attribute);
    }
    public void insertBot(Bot bot) {
        this.bots.add(bot);
    }

    /**
     * 查找是否存在该名字的属性，存在则返回这个属性，否则就返回null
     * @param attributeName 查找的属性名字
     * @return  属性存在返回属性，不存在返回null
     */
    public BotAttribute getAttributeByName(String attributeName) {
        return this.attributes.get(attributeName);
    }


    /**
     * 查找是否存在该名字的武器模式，存在则返回这个武器模式，否则就返回null
     * @param weaponSchemeName 查找的武器模式名字
     * @return  武器模式存在返回属性，不存在返回null
     */
    public BotWeaponScheme getWeaponSchemeByName(String weaponSchemeName) {
        return this.weaponSchemes.get(weaponSchemeName);
    }

    /**
     * 把default中的有效字段加入到对象中
     * @param propertyName 字段名
     * @param value 字段值
     */
    public void setProperty(String propertyName, float value){
        if(value<0.0001){
            value=0.0001f;
        }
        if(value>1000000){
            value = 10000000f;
        }
        Float packagedValue = new Float(value);
        if(propertyName.equals("Teamwork")){
            setTeamwork(packagedValue.intValue());
        }
        else if(propertyName.equals("LookAngleMaxAccelNormal")){
            setLookAngleMaxAccelNormal(value);
        }
        else if(propertyName.equals("LookAngleStiffnessNormal")){
            setLookAngleStiffnessNormal(value);
        }
        else if(propertyName.equals("LookAngleDampingNormal")){
            setLookAngleDampingNormal(value);
        }
        else if(propertyName.equals("LookAngleMaxAccelAttacking")){
            setLookAngleMaxAccelAttacking(value);
        }
        else if(propertyName.equals("LookAngleStiffnessAttacking")){
            setLookAngleStiffnessAttacking(value);
        }
        else if(propertyName.equals("LookAngleDampingAttacking")){
            setLookAngleDampingAttacking(value);
        }
    }

    /**
     * 获取BotProfile对象全部信息，封装成可以直接输出的字符串
     * @return 当前BotProfile对象信息
     */
    public String getStatus(){
        String status = new String();
        status+="## attributes:\n";
        status+="# count: "+this.attributes.size()+"\n";
        status+="# values:\n";
        for(BotAttribute i:this.attributes.values()){
            status+=i.getName()+"\n";
        }
        status+="## weaponSchemes:\n";
        status+="# count: "+this.weaponSchemes.size()+"\n";
        status+="# values:\n";
        for(BotWeaponScheme i:this.weaponSchemes.values()){
            status+=i.getName()+"\n";
        }
        status+="## bots:\n";
        status+="# count: "+this.bots.size()+"\n";
        status+="# values:\n";
        for(Bot i:this.bots){
            status+=i.getAttribute().getName()+" "+i.getName()+": ";
            if(i.getWeaponScheme()!=null){
                status+=i.getWeaponScheme().getName();
            }
            status+="\n";
        }
        status+=String.valueOf(this.lookAngleMaxAccelNormal)+"\n";
        status+=String.valueOf(this.lookAngleStiffnessNormal)+"\n";
        status+=String.valueOf(this.lookAngleDampingNormal)+"\n";
        status+=String.valueOf(this.lookAngleMaxAccelAttacking)+"\n";
        status+=String.valueOf(this.lookAngleStiffnessAttacking)+"\n";
        status+=String.valueOf(this.lookAngleDampingAttacking)+"\n";
        return status;
    }
}
