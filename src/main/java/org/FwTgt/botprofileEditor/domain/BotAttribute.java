package org.FwTgt.botprofileEditor.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import org.FwTgt.botprofileEditor.domain.enums.EDifficulty;

@TableName("attributes")
public class BotAttribute{

    @TableId(type = IdType.AUTO)
    @TableField("id")
    private int id;
    @TableField("name")
    private String name;
    @TableField("skill")
    private int skill;
    @TableField("aggression")
    private int aggression;
    @TableField("reactionTime")
    private float reactionTime;
    @TableField(exist = false)
    private EDifficulty difficulty;
    @TableField("difficulty")
    private String difficultyStr;
    @TableField("attackDelay")
    private float attackDelay;
    @TableField("teamwork")
    private int teamwork;
    @TableField("aimFocusInitial")
    private float aimFocusInitial;
    @TableField("aimFocusDecay")
    private float aimFocusDecay;
    @TableField("aimFocusOffsetScale")
    private float aimFocusOffsetScale;
    @TableField("aimfocusInterval")
    private float aimfocusInterval;
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

    public String getDifficultyStr() {
        if(difficulty!=null){
            return difficulty.name();
        }
        return null;
    }

    public void setDifficultyStr(String difficultyStr) {
        this.difficultyStr = difficultyStr;
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
