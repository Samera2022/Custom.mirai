package priv.samera2022.functions.minecraft_server.minecraft_plugin.item;

public class Item {
    private String registerName;
    private long price;
    private String displayName;
    private String description;
    private long maxBoughtTimes = 32767;
    public Item(){}
    public void setRegisterName(String registerName) {
        this.registerName = registerName;
    }
    public void setPrice(long price) {
        this.price = price;
    }
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setMaxBoughtTimes(long maxBoughtTimes) {
        this.maxBoughtTimes = maxBoughtTimes;
    }
    public String getRegisterName() {
        return registerName;
    }
    public long getPrice() {
        return price;
    }
    public String getDisplayName() {
        return displayName;
    }
    public String getDescription() {
        return description;
    }
    public long getMaxBoughtTimes() {
        return maxBoughtTimes;
    }
}
