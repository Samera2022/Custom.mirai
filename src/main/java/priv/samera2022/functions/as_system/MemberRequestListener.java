package priv.samera2022.functions.as_system;

import net.mamoe.mirai.event.EventHandler;
import net.mamoe.mirai.event.SimpleListenerHost;
import net.mamoe.mirai.event.events.MemberJoinRequestEvent;
import priv.samera2022.utils.FileHandler;
import priv.samera2022.utils.Utilities;
import priv.samera2022.utils.yaml.YamlConfigHandler;

import java.io.File;
import java.io.IOException;

public class MemberRequestListener extends SimpleListenerHost {
    @EventHandler
    public void MemberJoin(MemberJoinRequestEvent event) throws IOException {
        long qqNumber = event.getFromId();
        if (Utilities.readFile(new File(Utilities.CUSTOM_FOLDER_PATH), FileHandler.ANTI_LIST_NAME).contains(String.valueOf(qqNumber))){
            event.reject(true, (String) YamlConfigHandler.getConfig().getMessage().getAs_system_member_request_deny());
        }
    }

}
