package priv.samera2022.functions.minecraft_server.minecraft_plugin.item;

public class ItemNameStack {
    private String displayName;
    private long amount;
    public ItemNameStack(){}
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }
    public void setAmount(long amount) {
        this.amount = amount;
    }
    public String getDisplayName() {
        return displayName;
    }
    public long getAmount() {
        return amount;
    }
}
