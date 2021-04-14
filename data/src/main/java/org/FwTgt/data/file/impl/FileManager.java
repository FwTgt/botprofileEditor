package org.FwTgt.data.file.impl;

import org.FwTgt.data.buffer.IDataBuffer;
import org.FwTgt.data.buffer.impl.DataBuffer;
import org.FwTgt.data.file.IFileManager;
import org.FwTgt.domain.Team;

public class FileManager implements IFileManager {

    @Override
    public void setCSGOPath(String gamePath) {

    }

    @Override
    public IDataBuffer openBotProfile(String filePath) throws Exception {
        return null;
    }

    @Override
    public void saveBotProfile(DataBuffer dataBuffer) throws Exception {

    }

    @Override
    public void backupBotProfile() {

    }

    @Override
    public void backupBotProfile(DataBuffer dataBuffer) {

    }

    @Override
    public void makeTeamAddCfg(Team team) throws Exception {

    }
}
