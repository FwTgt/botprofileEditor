package org.FwTgt.dao;

import org.FwTgt.domain.BotAttribute;

import java.util.List;

public interface IAttributeDao {
    public void insertAttribute(BotAttribute attribute) throws Exception;
    public List<BotAttribute> getAttributeById(String id) throws Exception;
}
