package priv.samera2022.functions.minecraft_server.minecraft_plugin;

import priv.samera2022.functions.minecraft_server.minecraft_plugin.item.Item;

import java.util.List;

public class Market {
    private List<Item> list;
    public Market(){}
    public void setList(List<Item> list) {
        this.list = list;
    }
    public List<Item> getList() {
        return list;
    }
}
