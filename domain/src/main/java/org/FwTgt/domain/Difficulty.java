package org.FwTgt.domain;

import org.FwTgt.domain.enums.EDifficulty;

public class Difficulty extends Template{

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
    public int getSkill() {
        return super.getSkill();
    }

    @Override
    public void setSkill(int skill) {
        super.setSkill(skill);
    }

    @Override
    public int getAggression() {
        return super.getAggression();
    }

    @Override
    public void setAggression(int aggression) {
        super.setAggression(aggression);
    }

    @Override
    public float getReactionTime() {
        return super.getReactionTime();
    }

    @Override
    public void setReactionTime(float reactionTime) {
        super.setReactionTime(reactionTime);
    }

    @Override
    public float getAttackDelay() {
        return super.getAttackDelay();
    }

    @Override
    public void setAttackDelay(float attackDelay) {
        super.setAttackDelay(attackDelay);
    }

    @Override
    public int getTeamwork() {
        return super.getTeamwork();
    }

    @Override
    public void setTeamwork(int teamwork) {
        super.setTeamwork(teamwork);
    }

    @Override
    public float getAimFocusInitial() {
        return super.getAimFocusInitial();
    }

    @Override
    public void setAimFocusInitial(float aimFocusInitial) {
        super.setAimFocusInitial(aimFocusInitial);
    }

    @Override
    public float getAimFocusDecay() {
        return super.getAimFocusDecay();
    }

    @Override
    public void setAimFocusDecay(float aimFocusDecay) {
        super.setAimFocusDecay(aimFocusDecay);
    }

    @Override
    public float getAimFocusOffsetScale() {
        return super.getAimFocusOffsetScale();
    }

    @Override
    public void setAimFocusOffsetScale(float aimFocusOffsetScale) {
        super.setAimFocusOffsetScale(aimFocusOffsetScale);
    }

    @Override
    public float getAimfocusInterval() {
        return super.getAimfocusInterval();
    }

    @Override
    public void setAimfocusInterval(float aimfocusInterval) {
        super.setAimfocusInterval(aimfocusInterval);
    }

    @Override
    public int getCost() {
        return super.getCost();
    }

    @Override
    public void setCost(int cost) {
        super.setCost(cost);
    }

    @Override
    public EDifficulty getDifficulty() {
        return super.getDifficulty();
    }

    @Override
    public void setDifficulty(EDifficulty difficulty) {
        super.setDifficulty(difficulty);
    }

    @Override
    public int getVoicePitch() {
        return super.getVoicePitch();
    }

    @Override
    public void setVoicePitch(int voicePitch) {
        super.setVoicePitch(voicePitch);
    }

    @Override
    public int getSkin() {
        return super.getSkin();
    }

    @Override
    public void setSkin(int skin) {
        super.setSkin(skin);
    }

    @Override
    public float getLookAngleMaxAccelNormal() {
        return super.getLookAngleMaxAccelNormal();
    }

    @Override
    public void setLookAngleMaxAccelNormal(float lookAngleMaxAccelNormal) {
        super.setLookAngleMaxAccelNormal(lookAngleMaxAccelNormal);
    }

    @Override
    public float getLookAngleStiffnessNormal() {
        return super.getLookAngleStiffnessNormal();
    }

    @Override
    public void setLookAngleStiffnessNormal(float lookAngleStiffnessNormal) {
        super.setLookAngleStiffnessNormal(lookAngleStiffnessNormal);
    }

    @Override
    public float getLookAngleDampingNormal() {
        return super.getLookAngleDampingNormal();
    }

    @Override
    public void setLookAngleDampingNormal(float lookAngleDampingNormal) {
        super.setLookAngleDampingNormal(lookAngleDampingNormal);
    }

    @Override
    public float getLookAngleMaxAccelAttacking() {
        return super.getLookAngleMaxAccelAttacking();
    }

    @Override
    public void setLookAngleMaxAccelAttacking(float lookAngleMaxAccelAttacking) {
        super.setLookAngleMaxAccelAttacking(lookAngleMaxAccelAttacking);
    }

    @Override
    public float getLookAngleStiffnessAttacking() {
        return super.getLookAngleStiffnessAttacking();
    }

    @Override
    public void setLookAngleStiffnessAttacking(float lookAngleStiffnessAttacking) {
        super.setLookAngleStiffnessAttacking(lookAngleStiffnessAttacking);
    }

    @Override
    public float getLookAngleDampingAttacking() {
        return super.getLookAngleDampingAttacking();
    }

    @Override
    public void setLookAngleDampingAttacking(float lookAngleDampingAttacking) {
        super.setLookAngleDampingAttacking(lookAngleDampingAttacking);
    }
}
