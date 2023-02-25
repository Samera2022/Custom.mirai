package priv.samera2022.utils.yaml;

import priv.samera2022.utils.FileHandler;
import priv.samera2022.utils.Utilities;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class YamlPlayerQQHandler {
    public static HashMap<Long,String> readUserMCQQ() {
        String content = Utilities.readFile(new File(Utilities.CUSTOM_FOLDER_PATH),FileHandler.PLAYER_QQ_LIST_NAME);
        HashMap<Long,String> hashMap = new HashMap<>();
        while (content.contains("\"")) {
            int keyStart = content.indexOf("\"");
            int keyEnd = content.indexOf("\":");
            String key = content.substring(keyStart + 1, keyEnd);
            String valueStart = content.split("\": ",2)[1];
            int valueEnd = valueStart.indexOf("\"");
            String value = "";
            if (valueEnd != -1) {
                value = valueStart.substring(0, valueEnd);
                char[] elements = value.toCharArray();
                content = valueStart.substring(valueEnd);
                hashMap.put(Long.parseLong(key),toLetterAndDigit(value));
            } else {
                value = valueStart;
                hashMap.put(Long.parseLong(key),toLetterAndDigit(value));
                break;
            }
        }
        return  hashMap;
    }
    private static String toLetterAndDigit(String input){
        StringBuilder output = new StringBuilder();
        char[] elements = input.toCharArray();
        for (char element : elements){
            if (Character.isLetterOrDigit(element)){
                output.append(element);
            }
        }
        return output.toString();
    }
    public static void writeUserMCQQ(long qqID, String playerName) throws IOException {
        Utilities.appendContent(new File(Utilities.CUSTOM_FOLDER_PATH), FileHandler.PLAYER_QQ_LIST_NAME,("\""+qqID+"\""+": "+playerName));
    }

    @Deprecated
    public static String Minecraft_QQ_List(long senderID, String command) throws IOException {
        String content = "";
        if (command.indexOf("绑定") == 0) {
            String playerName = command.split("绑定",2)[1];
            if (!playerName.isEmpty()) {
                HashMap<Long, String> hashMap = YamlPlayerQQHandler.readUserMCQQ();
                if (hashMap.containsKey(senderID)) {
                    content = "执行出错！原表已有绑定信息！请联系服务器拥有者进行修改！";
                } else if (hashMap.containsValue(playerName)) {
                    long key = 0;
                    for (long getKey : hashMap.keySet()) {
                        if (hashMap.get(getKey).equals(playerName)) {
                            key = getKey;
                        }
                    }
                    content = "执行出错！该用户名已绑定QQ号为" + key + "的群员！";
                } else {
                    YamlPlayerQQHandler.writeUserMCQQ(senderID, playerName);
                    content = "绑定成功！";
                }
            } else {
                content = "执行出错！绑定玩家名不能为空！";
            }
        }
        return content;
    }

}
