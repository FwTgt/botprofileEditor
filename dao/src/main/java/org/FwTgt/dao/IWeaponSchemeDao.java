package org.FwTgt.dao;


import org.FwTgt.domain.BotWeaponScheme;

import java.util.List;

public interface IWeaponSchemeDao {
    public void insertBot(BotWeaponScheme weaponScheme) throws Exception;
    public List<BotWeaponScheme> getBotById(String id) throws Exception;
}
