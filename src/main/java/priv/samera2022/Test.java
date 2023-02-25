package priv.samera2022;

import priv.samera2022.utils.FileHandler;
import priv.samera2022.utils.Utilities;
import priv.samera2022.utils.yaml.YamlConfigHandler;
import priv.samera2022.utils.yaml.config.minecraft_server.MinecraftRcon;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;

public class Test {
    public static void main(String[] args) throws FileNotFoundException {
        String content = "./help";
        MinecraftRcon[] rcons = YamlConfigHandler.getConfig().getServer().getRcon();
        String rconPrefix = "";
        MinecraftRcon targetRcon = new MinecraftRcon();
        for (MinecraftRcon rcon : rcons){
            System.out.println(rcon.getPrefix());
            if (content.indexOf(rcon.getPrefix())==0){
                rconPrefix = rcon.getPrefix();
                targetRcon = rcon;
                System.out.println(targetRcon.getName());
            }
        }
        //        String[] arr = "^list^ss".split("\\^",2);
//        System.out.println(arr[1]);
//        for (int i = 0; i<arr.length; i++) {
//            String command = arr[i];
//            System.out.println("time: "+i+" Content:"+command);
//        }
//        System.out.println(readUserMCQQ());
//     System.out.println(get(new File("D:/_S_A_M/Desktop/Bot/iTXTech_MCL_Coldy/config/priv.samera2022/config.yml"),"message").get("minecraft_plugin_prefix"));
    }

    public static HashMap<Long, String> readUserMCQQ() {
        String content = Utilities.readFile(new File("D:/_S_A_M/Desktop/Bot/[MCL] Custom Robot/"), FileHandler.CONFIG_NAME);
        HashMap<Long, String> hashMap = new HashMap<>();
        while (content.contains("\"")) {
            int keyStart = content.indexOf("\"");
            int keyEnd = content.indexOf("\":");
            String key = content.substring(keyStart + 1, keyEnd);
            String valueStart = content.split("\": ",2)[1];
            int valueEnd = valueStart.indexOf("\"");
            String value = "";
            if (valueEnd != -1) {
                value = valueStart.substring(0, valueEnd);
                content = valueStart.substring(valueEnd);
                hashMap.put(Long.parseLong(key), value);
            } else {
                value = valueStart;
                hashMap.put(Long.parseLong(key), value);
                break;
            }
        }
        return hashMap;
    }
}