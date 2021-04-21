package org.FwTgt.botprofileEditor.domain;

import org.FwTgt.botprofileEditor.domain.enums.EDifficulty;

public class BotAttribute{

    private int id;
    private String name;
    private int skill;
    private int aggression;
    private float reactionTime;
    private float attackDelay;
    private int teamwork;
    private EDifficulty difficulty;
    private float aimFocusInitial;
    private float aimFocusDecay;
    private float aimFocusOffsetScale;
    private float aimfocusInterval;
    private float lookAngleMaxAccelNormal;
    private float lookAngleStiffnessNormal;
    private float lookAngleDampingNormal;
    private float lookAngleMaxAccelAttacking;
    private float lookAngleStiffnessAttacking;
    private float lookAngleDampingAttacking;

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


    public EDifficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(EDifficulty difficulty) {
        this.difficulty = difficulty;
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
