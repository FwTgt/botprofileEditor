package org.FwTgt.botprofileEditor.config;

import lombok.Data;
import org.FwTgt.botprofileEditor.domain.BotProfile;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

/**
 * 用来生成bot配置文件中default字段的内容
 */
@Data
@Configuration()
@PropertySource(value = "classpath:/default/defaultINF.properties")
public class DefaultConfig {
    @Value("${default.Skill}")
    private int skill;
    @Value("${default.Aggression}")
    private int aggression;
    @Value("${default.ReactionTime}")
    private float reactionTime;
    @Value("${default.AttackDelay}")
    private float attackDelay;
    @Value("${default.AimFocusInitial}")
    private float aimFocusInitial;
    @Value("${default.AimFocusDecay}")
    private float aimFocusDecay;
    @Value("${default.AimFocusOffsetScale}")
    private float aimFocusOffsetScale;
    @Value("${default.AimfocusInterval}")
    private float aimfocusInterval ;
    @Value("${default.WeaponPreference}")
    private String weaponPreference ;
    @Value("${default.Cost}")
    private int cost ;
    @Value("${default.Difficulty}")
    private String difficulty;
    @Value("${default.VoicePitch}")
    private int voicePitch ;
    @Value("${default.Skin}")
    private int skin ;

    private StringBuilder stablePart;      //一些固定的字段存放在这里

    /**
     * 加入default里面的固定信息，作为bean
     * @return 把自身当作一个Bean返回，存放着需要的固定信息
     */
    @Bean
    public DefaultConfig defaultINF(){
        stablePart = new StringBuilder();
        stablePart.append("Default");
        stablePart.append("\n\tSkill = ").append(this.getSkill());
        stablePart.append("\n\tAggression = ").append(this.getAggression());
        stablePart.append("\n\tReactionTime = ").append(String.format("%f",this.getReactionTime()));
        stablePart.append("\n\tAttackDelay = ").append(String.format("%f",this.getAttackDelay()));
        stablePart.append("\n\tAimFocusInitial = ").append(String.format("%f",this.getAimFocusInitial()));
        stablePart.append("\n\tAimFocusDecay = ").append(String.format("%f",this.getAimFocusDecay()));
        stablePart.append("\n\tAimFocusOffsetScale = ").append(String.format("%f",this.getAimFocusOffsetScale()));
        stablePart.append("\n\tAimfocusInterval = ").append(String.format("%f",this.getAimfocusInterval()));
        stablePart.append("\n\tWeaponPreference = ").append(this.getWeaponPreference());
        stablePart.append("\n\tCost = ").append(this.getCost());
        stablePart.append("\n\tDifficulty = ").append(this.getDifficulty());
        stablePart.append("\n\tVoicePitch = ").append(this.getVoicePitch());
        stablePart.append("\n\tSkin = ").append(this.getSkin());
        return this;
    }


    /**
     * 把送来的BotProfile对象中的default信息和这个bean中固定的信息进行拼接
     * @param botProfile 要拼接default字段的配置文件类
     * @return 拼接好的数据，可以直接用字字符流写入
     */
    public StringBuilder compose(BotProfile botProfile) {
        StringBuilder userPart = new StringBuilder();
        userPart.append("\n\tTeamwork = ").append(botProfile.getTeamwork());
        userPart.append("\n\tLookAngleMaxAccelNormal = ").append(String.format("%f",botProfile.getLookAngleMaxAccelNormal()));
        userPart.append("\n\tLookAngleStiffnessNormal = ").append(String.format("%f",botProfile.getLookAngleStiffnessNormal()));
        userPart.append("\n\tLookAngleDampingNormal = ").append(String.format("%f",botProfile.getLookAngleDampingNormal()));
        userPart.append("\n\tLookAngleMaxAccelAttacking = ").append(String.format("%f",botProfile.getLookAngleMaxAccelAttacking()));
        userPart.append("\n\tLookAngleStiffnessAttacking = ").append(String.format("%f",botProfile.getLookAngleStiffnessAttacking()));
        userPart.append("\n\tLookAngleDampingAttacking = ").append(String.format("%f",botProfile.getLookAngleDampingAttacking()));
        userPart.append("\nEnd\n\n\n");
        StringBuilder builder = new StringBuilder();
        builder.append(stablePart);
        builder.append(userPart);
        return builder;
    }
}
