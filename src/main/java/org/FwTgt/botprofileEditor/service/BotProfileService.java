package org.FwTgt.botprofileEditor.service;

import org.FwTgt.botprofileEditor.dao.mapper.*;
import org.FwTgt.botprofileEditor.domain.Bot;
import org.FwTgt.botprofileEditor.domain.BotAttribute;
import org.FwTgt.botprofileEditor.domain.BotProfile;
import org.FwTgt.botprofileEditor.domain.BotWeaponScheme;
import org.FwTgt.botprofileEditor.utils.BotProfileHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.io.InputStream;
import java.util.Set;

@Service
public class BotProfileService {

    @Autowired(required = false)
    private IBotProfileMapper profileMapper;

    @Autowired(required = false)
    private IBotWeaponSchemeMapper weaponSchemeMapper;

    @Autowired(required = false)
    private IBotMapper botMapper;

    @Autowired(required = false)
    private IBotAttributeMapper attributeMapper;

    @Autowired
    byte[] defualtINF;

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
        int profileKey = botProfile.getId();

        for(BotAttribute a:botProfile.getAttributes()){
            attributeMapper.insert(a);
            attributeMapper.addRelation(profileKey,a.getId());
        }
        for(BotWeaponScheme w:botProfile.getWeaponSchemes()){
            weaponSchemeMapper.insert(w);
            weaponSchemeMapper.addRelation(profileKey,w.getId());
        }
        for(Bot b:botProfile.getBots()){
            botMapper.insert(b);
            botMapper.addRelation(profileKey,b.getId());
        }
    }


    public String outputProfile(int botprofileId) throws Exception {
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
        return BotProfileHandler.outputFile(defualtINF,botProfile);
    }

}
