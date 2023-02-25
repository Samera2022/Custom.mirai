package priv.samera2022.functions.minecraft_server.minecraft_plugin;

import priv.samera2022.functions.minecraft_server.minecraft_plugin.item.ItemNameStack;

import java.util.List;

public class Player {
    private String playerName;
    private long SamCoin;
    private String lastLoginDate;
    private String lastSignInDate;
    private List<ItemNameStack> backpack;
    public Player(){}
    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }
    public void setSamCoin(long samCoin) {
        SamCoin = samCoin;
    }
    public void setLastLoginDate(String lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }
    public void setLastSignInDate(String lastSignInDate) {
        this.lastSignInDate = lastSignInDate;
    }
    public void setBackpack(List<ItemNameStack> backpack) {
        this.backpack = backpack;
    }
    public String getPlayerName() {
        return playerName;
    }
    public long getSamCoin() {
        return SamCoin;
    }
    public String getLastLoginDate() {
        return lastLoginDate;
    }
    public String getLastSignInDate() {
        return lastSignInDate;
    }
    public List<ItemNameStack> getBackpack() {
        return backpack;
    }
}
