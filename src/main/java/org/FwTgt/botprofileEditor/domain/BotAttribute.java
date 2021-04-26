package org.FwTgt.botprofileEditor.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.FwTgt.botprofileEditor.domain.enums.EDifficulty;

import java.math.BigInteger;

/**
 * 存放Bot属性的全部信息
 */

@Data
@TableName("attributes")
public class BotAttribute{

    @TableId(type = IdType.AUTO)
    @TableField("id")
    private BigInteger id;

    @TableField("name")
    private String name;

    @TableField("skill")
    private int skill;

    @TableField("aggression")
    private int aggression;

    @TableField("reactionTime")
    private float reactionTime;

    @TableField("difficulty")
    private String difficulty;

    @TableField("attackDelay")
    private float attackDelay;

    @TableField("aimFocusInitial")
    private float aimFocusInitial;

    @TableField("aimFocusDecay")
    private float aimFocusDecay;

    @TableField("aimFocusOffsetScale")
    private float aimFocusOffsetScale;

    @TableField("aimfocusInterval")
    private float aimfocusInterval;

}
