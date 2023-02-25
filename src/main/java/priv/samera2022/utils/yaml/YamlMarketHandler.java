package priv.samera2022.utils.yaml;

import org.ho.yaml.Yaml;
import priv.samera2022.functions.minecraft_server.minecraft_plugin.Market;
import priv.samera2022.functions.minecraft_server.minecraft_plugin.item.Item;
import priv.samera2022.functions.minecraft_server.minecraft_plugin.item.Items;
import priv.samera2022.utils.FileHandler;
import priv.samera2022.utils.Utilities;
import priv.samera2022.utils.mixture.SearchItemMixture;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class YamlMarketHandler {
    public static void main(String[] args) throws FileNotFoundException {
//        setDefault();
        Item coal = new Item();
        coal.setDescription("A coal... Maybe it can be used to set a fire in the group?");
        coal.setDisplayName("Coal");
        coal.setPrice(1);
        coal.setRegisterName("coal");
        System.out.println(deleteItem(coal));
    }
    public static void setDefault() throws FileNotFoundException {
        Market market = new Market();
        List<Item> list = new ArrayList<>();
        list.add(Items.MASCOT_TOAME);
        list.add(Items.COAL);
        market.setList(list);
        Yaml.dump(market,new File(Utilities.CUSTOM_FOLDER_PATH+FileHandler.MARKET_NAME));
    }
    public static Market getMarket() throws FileNotFoundException {
        return Yaml.loadType(new File(Utilities.CUSTOM_FOLDER_PATH+FileHandler.MARKET_NAME), Market.class);
    }
    public static String addItem(Item item) throws FileNotFoundException {
        Market market = getMarket();
        List<Item> list = market.getList();
        if (!list.contains(item)) {
            list.add(item);
            market.setList(list);
            Yaml.dump(market, new File(Utilities.CUSTOM_FOLDER_PATH + FileHandler.MARKET_NAME));
            if (Utilities.readFile(new File(Utilities.CUSTOM_FOLDER_PATH), FileHandler.MARKET_NAME).contains(item.getRegisterName())) {
                return "succeeded";
            } else {
                return "failed";
            }
        } else {
            return "list_already_contains";
        }
    }
    public static String deleteItem(Item item) throws FileNotFoundException {
        Market market = getMarket();
        List<Item> list = market.getList();
        String output = "";
        for (int i = 0; i<list.size(); i++){
            Item each = list.get(i);
            if (item.getRegisterName().equals(each.getRegisterName())){
                list.remove(each);
                market.setList(list);
                Yaml.dump(market,new File(Utilities.CUSTOM_FOLDER_PATH + FileHandler.MARKET_NAME));
                if (Utilities.readFile(new File(Utilities.CUSTOM_FOLDER_PATH), FileHandler.MARKET_NAME).contains(item.getRegisterName())){
                    output = "failed";
                } else {
                    output = "succeeded";
                }
                break;
            } else if (i==list.size()-1){
                output = "item_not_found";
            }
        }
        return output;
    }
    public static SearchItemMixture searchByDisplayName(String displayName) throws FileNotFoundException {
        boolean isContained = false;
        Item item = null;
        List<Item> items = getMarket().getList();
        for (int i = 0; i<items.size(); i++){
            Item itemSearch = items.get(i);
            if (itemSearch.getDisplayName().equals(displayName)){
                isContained = true;
                item = itemSearch;
            }
        }
        return new SearchItemMixture(isContained,item);
    }
}
