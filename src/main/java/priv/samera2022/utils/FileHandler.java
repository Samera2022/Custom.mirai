package priv.samera2022.utils;

import java.io.File;
import java.io.IOException;

public class FileHandler {
    public static final String CONFIG_NAME = "config.yml";
    public static final String ANTI_LIST_NAME = "anti_list.txt";
    public static final String PLAYER_QQ_LIST_NAME = "player_qq_list.yml";
    public static final String MARKET_NAME = "market.yml";
    public static final String GROUP_PERMISSION_NAME = "group_permission.yml";
    public static void init() throws IOException {
        File folder_config = new File(Utilities.CUSTOM_FOLDER_PATH);
        fixError(folder_config,true);
        File config = new File(Utilities.CUSTOM_FOLDER_PATH+FileHandler.CONFIG_NAME);
        fixError(config,false);
        File anti_list = new File(Utilities.CUSTOM_FOLDER_PATH+ANTI_LIST_NAME);
        fixError(anti_list,false);
        File player_qq_list = new File(Utilities.CUSTOM_FOLDER_PATH+PLAYER_QQ_LIST_NAME);
        fixError(player_qq_list,false);
        File folder_config_playerdata = new File(Utilities.CUSTOM_FOLDER_PATH+"playerdata/");
        fixError(folder_config_playerdata,true);
        File market = new File(Utilities.CUSTOM_FOLDER_PATH+MARKET_NAME);
        fixError(market,false);
        File group_permission = new File(Utilities.CUSTOM_FOLDER_PATH+GROUP_PERMISSION_NAME);
        fixError(group_permission,false);
    }
    private static void fixError(File file, boolean isDictionary) throws IOException {
        if (file.isDirectory()!=isDictionary) file.delete();
        if (!file.exists()) {
            if (isDictionary){
                file.mkdirs();
            } else {
                file.createNewFile();
            }
        }
    }
}
