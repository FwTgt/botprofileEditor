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

    @Autowired(required = false)
    private IRelationMapper relationMapper;

    @Transactional
    public void loadProfile(File profile) throws Exception {
        BotProfile botProfile;
        try{
            botProfile = BotProfileHandler.getData(profile);
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
        botProfile.setName(profile.getName());
        profileMapper.insert(botProfile);
        int profileKey = botProfile.getId();

        for(BotAttribute a:botProfile.getAttributes()){
            attributeMapper.insert(a);
            relationMapper.addAttributeRelation(profileKey,a.getId());
        }
        for(BotWeaponScheme w:botProfile.getWeaponSchemes()){
            weaponSchemeMapper.insert(w);
            relationMapper.addWeaponSchemeRelation(profileKey,w.getId());
        }
        for(Bot b:botProfile.getBots()){
            botMapper.insert(b);
            relationMapper.addBotRelation(profileKey,b.getId());
        }

    }
}
