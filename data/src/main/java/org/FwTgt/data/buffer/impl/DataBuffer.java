package org.FwTgt.data.buffer.impl;

import org.FwTgt.data.buffer.IDataBuffer;
import org.FwTgt.domain.Bot;
import org.FwTgt.domain.BotAttribute;
import org.FwTgt.domain.BotWeaponScheme;

import java.util.Set;

public class DataBuffer implements IDataBuffer {

    private Set<BotWeaponScheme> weaponSchemes;
    private Set<BotAttribute> attributes;
    private Set<Bot> bots;

    @Override
    public boolean insertWeaponScheme(BotWeaponScheme weaponScheme) {
        return weaponSchemes.add(weaponScheme);
    }

    @Override
    public boolean insertAttribute(BotAttribute attribute) {
        return attributes.add(attribute);
    }

    @Override
    public boolean insertBot(Bot bot) {
        return bots.add(bot);
    }
}
