package org.FwTgt.data.memory;

import org.FwTgt.data.buffer.IDataBuffer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("memory")
public class DataMemory {

    private IDataBuffer currentDataBuffer;  //当前操作的bot配置文件的全部内容
    private String gamePath;    //csgo的游戏路径

    public String getGamePath() {
        return gamePath;
    }

    public void setGamePath(String gamePath) {
        this.gamePath = gamePath;
    }
}
