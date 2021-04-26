package org.FwTgt.botprofileEditor.service;

import org.FwTgt.botprofileEditor.dao.mapper.*;
import org.FwTgt.botprofileEditor.domain.*;
import org.FwTgt.botprofileEditor.utils.BotProfileHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.InputStream;
import java.math.BigInteger;

@Service
public class BotProfileService {


    //@Resource
    @Autowired(required = false)
    private IBotProfileMapper profileMapper;

    @Autowired(required = false)
    private IBotWeaponSchemeMapper weaponSchemeMapper;

    @Autowired(required = false)
    private IBotMapper botMapper;

    @Autowired(required = false)
    private IBotAttributeMapper attributeMapper;


    /**
     * 根据上传文件的输入流读取、分析、提取bot配置文件内容到数据库
     * @param fileName 上传文件原本的名字
     * @param profileStream 上传文件的输入流
     */
    @Transactional
    public void loadProfile(String fileName,InputStream profileStream) throws Exception {
        BotProfile botProfile;
        try{
            botProfile = BotProfileHandler.getData(profileStream);
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
        botProfile.setName(fileName);
        profileMapper.insert(botProfile);
        BigInteger profileKey = botProfile.getId();

        for(BotAttribute a:botProfile.getAttributes().values()){
            attributeMapper.insert(a);
            attributeMapper.addRelation(profileKey,a.getId());
        }
        for(BotWeaponScheme w:botProfile.getWeaponSchemes().values()){
            weaponSchemeMapper.insert(w);
            weaponSchemeMapper.addRelation(profileKey,w.getId());
        }
        for(Bot b:botProfile.getBots()){
            b.setAttributeId(b.getAttribute().getId());
            if(b.hasWeaponScheme()){
                b.setWeaponSchemeId(b.getWeaponScheme().getId());
            }
            botMapper.insert(b);
            botMapper.addRelation(profileKey,b.getId());
        }
    }

    /**
     * 根据指定的数据库中的bot配置文件id，来生成一个botprofile文件字符流
     * @param botprofileId 指定的bot配置文件id
     * @return 生成的bot配置文件所有内容
     * @throws Exception sql语句出现错误时抛出
     */
    public StringBuilder getBotprofile(int botprofileId) throws Exception {
        BotProfile botProfile = profileMapper.selectById(botprofileId);
        for(BotAttribute a:attributeMapper.selectByBotprofileId(botprofileId)){
            botProfile.insertAttribute(a);
        }
        for(BotWeaponScheme w:weaponSchemeMapper.selectByBotprofileId(botprofileId)){
            botProfile.insertWeaponScheme(w);
        }
        for(Bot b:botMapper.selectByBotprofileId(botprofileId)){
            botProfile.insertBot(b);
        }
        return BotProfileHandler.packageBotprofile(botProfile);
    }

}
