package org.FwTgt.dao;

import org.FwTgt.domain.Bot;

import java.util.List;

public interface IBotDao {
    public void insertBot(Bot bot) throws Exception;
    public List<Bot> getBotById(String id) throws Exception;
}
