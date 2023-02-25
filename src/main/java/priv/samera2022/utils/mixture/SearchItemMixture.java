package priv.samera2022.utils.mixture;

import priv.samera2022.functions.minecraft_server.minecraft_plugin.item.Item;

public class SearchItemMixture extends Mixture{
    private boolean contained;
    private Item item;
    public SearchItemMixture(boolean contained, Item item){
        super(contained,item);
        this.contained = contained;
        this.item = item;
    }
    public boolean isContained() {
        return contained;
    }
    public Item getItem() {
        return item;
    }
}
