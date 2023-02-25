package priv.samera2022.functions.minecraft_server.minecraft_plugin.item;

public class Items {
    public static Item MASCOT_TOAME = new Item();
    public static Item COAL = new Item();
    public static void init(){
        Item Toame = new Item();
        Toame.setDescription("Just A Toame!");
        Toame.setDisplayName("Mascot Toame");
        Toame.setPrice(1);
        Toame.setRegisterName("mascot_toame");
        Toame.setMaxBoughtTimes(2);

        Item coal = new Item();
        coal.setDescription("A coal... Maybe it can be used to set a fire in the group?");
        coal.setDisplayName("Coal");
        coal.setPrice(10000);
        coal.setRegisterName("coal");

        MASCOT_TOAME = Toame;
        COAL = coal;
    }
}
