package org.FwTgt.data.file;

import org.FwTgt.data.buffer.IDataBuffer;
import org.FwTgt.data.buffer.impl.DataBuffer;
import org.FwTgt.domain.Team;

//IFileManager接口定义了用于本地文件交互的对象FileManager应该实现的方法
public interface IFileManager {
    public void setCSGOPath(String gamePath);   //设置csgo游戏路径
    public IDataBuffer openBotProfile(String filePath) throws Exception;   //打开botprofile.db
    public void saveBotProfile(DataBuffer dataBuffer) throws Exception;   //保存botprofile.db
    public void backupBotProfile();     //备份当前的配置文件内容
    public void backupBotProfile(DataBuffer dataBuffer);     //备份指定的配置文件内容
    public void makeTeamAddCfg(Team team) throws Exception;  //生成一键加入队伍cfg
}
