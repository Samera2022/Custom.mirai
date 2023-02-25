package priv.samera2022.functions.minecraft_server.minecraft_plugin.item;

public class ItemStack {
    private Item item;
    private long amount;
    public ItemStack(){}
    public void setItem(Item item) {
        this.item = item;
    }
    public void setAmount(long amount) {
        this.amount = amount;
    }
    public Item getItem() {
        return item;
    }
    public long getAmount() {
        return amount;
    }
}
