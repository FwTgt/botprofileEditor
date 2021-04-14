package org.FwTgt.domain;

import org.FwTgt.domain.enums.EDifficulty;
import org.FwTgt.domain.enums.EWeapon;

import java.util.List;

//botprofile.db的模板
public abstract class Template {
    private int skill;
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

    public int getSkill() {
        return skill;
    }

    public void setSkill(int skill) {
        this.skill = skill;
    }

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

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public org.FwTgt.domain.enums.EDifficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(org.FwTgt.domain.enums.EDifficulty difficulty) {
        this.difficulty = difficulty;
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
}
