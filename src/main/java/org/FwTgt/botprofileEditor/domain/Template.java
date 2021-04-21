package org.FwTgt.botprofileEditor.domain;

import org.FwTgt.botprofileEditor.domain.enums.EDifficulty;
import org.FwTgt.botprofileEditor.domain.enums.EWeapon;

import java.util.LinkedList;
import java.util.List;

//botprofile.db的模板
public class Template {
    private String name;
    private int skill;
    private int rank;
    private int aggression;
    private float reactionTime;
    private float attackDelay;
    private int teamwork;
    private float aimFocusInitial;
    private float aimFocusDecay;
    private float aimFocusOffsetScale;
    private float aimfocusInterval;
    private List<EWeapon> weaponPreferences;
    private int cost;
    private EDifficulty difficulty;
    private int  voicePitch;
    private int skin;
    private float lookAngleMaxAccelNormal;
    private float lookAngleStiffnessNormal;
    private float lookAngleDampingNormal;
    private float lookAngleMaxAccelAttacking;
    private float lookAngleStiffnessAttacking;
    private float lookAngleDampingAttacking;

    public Template(){weaponPreferences=new LinkedList<>(); }
    public Template(String name){this.name=name;weaponPreferences=new LinkedList<>();}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSkill() {
        return skill;
    }

    public void setSkill(int skill) {
        this.skill = skill;
    }

    public int getRank() { return rank; }

    public void setRank(int rank) { this.rank = rank; }

    public int getAggression() {
        return aggression;
    }

    public void setAggression(int aggression) {
        this.aggression = aggression;
    }

    public float getReactionTime() {
        return reactionTime;
    }

    public void setReactionTime(float reactionTime) {
        this.reactionTime = reactionTime;
    }

    public float getAttackDelay() {
        return attackDelay;
    }

    public void setAttackDelay(float attackDelay) {
        this.attackDelay = attackDelay;
    }

    public int getTeamwork() {
        return teamwork;
    }

    public void setTeamwork(int teamwork) {
        this.teamwork = teamwork;
    }

    public float getAimFocusInitial() {
        return aimFocusInitial;
    }

    public void setAimFocusInitial(float aimFocusInitial) {
        this.aimFocusInitial = aimFocusInitial;
    }

    public float getAimFocusDecay() {
        return aimFocusDecay;
    }

    public void setAimFocusDecay(float aimFocusDecay) {
        this.aimFocusDecay = aimFocusDecay;
    }

    public float getAimFocusOffsetScale() {
        return aimFocusOffsetScale;
    }

    public void setAimFocusOffsetScale(float aimFocusOffsetScale) {
        this.aimFocusOffsetScale = aimFocusOffsetScale;
    }

    public float getAimfocusInterval() {
        return aimfocusInterval;
    }

    public void setAimfocusInterval(float aimfocusInterval) {
        this.aimfocusInterval = aimfocusInterval;
    }

    public List<EWeapon> getWeaponPreferences() {
        return weaponPreferences;
    }

    public void setWeaponPreferences(List<EWeapon> weaponPreferences) {
        this.weaponPreferences = weaponPreferences;
    }

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

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public EDifficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(EDifficulty difficulty) {
        this.difficulty = difficulty;
    }
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
    }

    public int getVoicePitch() {
        return voicePitch;
    }

    public void setVoicePitch(int voicePitch) {
        this.voicePitch = voicePitch;
    }

    public int getSkin() {
        return skin;
    }

    public void setSkin(int skin) {
        this.skin = skin;
    }

    public float getLookAngleMaxAccelNormal() {
        return lookAngleMaxAccelNormal;
    }

    public void setLookAngleMaxAccelNormal(float lookAngleMaxAccelNormal) {
        this.lookAngleMaxAccelNormal = lookAngleMaxAccelNormal;
    }

    public float getLookAngleStiffnessNormal() {
        return lookAngleStiffnessNormal;
    }

    public void setLookAngleStiffnessNormal(float lookAngleStiffnessNormal) {
        this.lookAngleStiffnessNormal = lookAngleStiffnessNormal;
    }

    public float getLookAngleDampingNormal() {
        return lookAngleDampingNormal;
    }

    public void setLookAngleDampingNormal(float lookAngleDampingNormal) {
        this.lookAngleDampingNormal = lookAngleDampingNormal;
    }

    public float getLookAngleMaxAccelAttacking() {
        return lookAngleMaxAccelAttacking;
    }

    public void setLookAngleMaxAccelAttacking(float lookAngleMaxAccelAttacking) {
        this.lookAngleMaxAccelAttacking = lookAngleMaxAccelAttacking;
    }

    public float getLookAngleStiffnessAttacking() {
        return lookAngleStiffnessAttacking;
    }

    public void setLookAngleStiffnessAttacking(float lookAngleStiffnessAttacking) {
        this.lookAngleStiffnessAttacking = lookAngleStiffnessAttacking;
    }

    public float getLookAngleDampingAttacking() {
        return lookAngleDampingAttacking;
    }

    public void setLookAngleDampingAttacking(float lookAngleDampingAttacking) {
        this.lookAngleDampingAttacking = lookAngleDampingAttacking;
    }

    public void setAttribute(String attributeName,String value){
        if(attributeName.equals("weaponpreference")){
            addWeaponPreference(value);
        }
        else if(attributeName.equals("difficulty")){
            setDifficulty(EDifficulty.valueOf(value.toUpperCase()));
        }
        else{ }
    }
    public void setAttribute(String attributeName,float value) {
        attributeName=attributeName.toLowerCase();
        Float packagedValue=value;

        if(attributeName.equals("skill")){
            setSkill(packagedValue.intValue());
        }
        else if(attributeName.equals("rank")){
            setRank(packagedValue.intValue());
        }
        else if(attributeName.equals("aggression")){
            setAggression(packagedValue.intValue());
        }
        else if(attributeName.equals("reactiontime")){
            setReactionTime(packagedValue);
        }
        else if(attributeName.equals("attackdelay")){
            setAttackDelay(packagedValue);
        }
        else if(attributeName.equals("teamwork")){
            setTeamwork(packagedValue.intValue());
        }
        else if(attributeName.equals("aimfocusinitial")){
            setAimFocusInitial(packagedValue);
        }
        else if(attributeName.equals("aimfocusdecay")){
            setAimFocusDecay(packagedValue);
        }
        else if(attributeName.equals("aimfocusoffsetscale")){
            setAimFocusOffsetScale(packagedValue);
        }
        else if(attributeName.equals("aimfocusinterval")){
            setAimfocusInterval(packagedValue);
        }
        else if(attributeName.equals("cost")){
            setCost(packagedValue.intValue());
        }
        else if(attributeName.equals("voicepitch")){
            setVoicePitch(packagedValue.intValue());
        }
        else if(attributeName.equals("skin")){
            setSkin(packagedValue.intValue());
        }
        else if(attributeName.equals("lookanglemaxaccelnormal")){
            setLookAngleMaxAccelNormal(value);
        }
        else if(attributeName.equals("lookanglestiffnessnormal")){
            setLookAngleStiffnessNormal(value);
        }
        else if(attributeName.equals("lookangledampingnormal")){
            setLookAngleDampingNormal(value);
        }
        else if(attributeName.equals("lookanglemaxaccelattacking")){
            setLookAngleMaxAccelAttacking(value);
        }
        else if(attributeName.equals("lookanglestiffnessattacking")){
            setLookAngleStiffnessAttacking(value);
        }
        else if(attributeName.equals("lookangledampingattacking")){
            setLookAngleDampingAttacking(value);
        }
        else {}
    }
    public BotAttribute toBotAttribute(){
        BotAttribute attribute=new BotAttribute();
        attribute.setName(name);
        attribute.setSkill(skill);
        attribute.setAggression(aggression);
        attribute.setReactionTime(reactionTime);
        attribute.setAttackDelay(attackDelay);
        attribute.setTeamwork(teamwork);
        attribute.setAimFocusInitial(aimFocusInitial);
        attribute.setAimFocusDecay(aimFocusDecay);
        attribute.setAimFocusOffsetScale(aimFocusOffsetScale);
        attribute.setAimfocusInterval(aimfocusInterval);
        attribute.setDifficulty(difficulty);
        attribute.setLookAngleMaxAccelNormal(lookAngleMaxAccelNormal);
        attribute.setLookAngleStiffnessNormal(lookAngleStiffnessNormal);
        attribute.setLookAngleDampingNormal(lookAngleDampingNormal);
        attribute.setLookAngleMaxAccelAttacking(lookAngleMaxAccelAttacking);
        attribute.setLookAngleStiffnessAttacking(lookAngleStiffnessAttacking);
        attribute.setLookAngleDampingAttacking(lookAngleDampingAttacking);
        return attribute;
    }
    public BotWeaponScheme toBotWeaponScheme(){
        BotWeaponScheme botWeaponScheme=new BotWeaponScheme();
        botWeaponScheme.setName(name);
        botWeaponScheme.setWeaponPreferences(weaponPreferences);
        return botWeaponScheme;
    }
}
