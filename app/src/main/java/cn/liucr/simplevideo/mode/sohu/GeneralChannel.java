package cn.liucr.simplevideo.mode.sohu;

import java.util.List;

/**
 * Created by Administrator on 2017/3/29/029.
 */

public class GeneralChannel {

    private int itemType;
    private List<Channel> channels;

    public GeneralChannel(int itemType, List<Channel> channels) {
        this.itemType = itemType;
        this.channels = channels;
    }

    public int getItemType() {
        return itemType;
    }

    public void setItemType(int itemType) {
        this.itemType = itemType;
    }

    public List<Channel> getChannels() {
        return channels;
    }

    public void setChannels(List<Channel> channels) {
        this.channels = channels;
    }
}
