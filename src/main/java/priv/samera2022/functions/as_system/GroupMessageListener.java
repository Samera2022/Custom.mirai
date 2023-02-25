package priv.samera2022.functions.as_system;

import net.mamoe.mirai.console.data.Value;
import net.mamoe.mirai.contact.MemberPermission;
import net.mamoe.mirai.event.EventHandler;
import net.mamoe.mirai.event.SimpleListenerHost;
import net.mamoe.mirai.event.events.GroupMessageEvent;
import priv.samera2022.utils.FileHandler;
import priv.samera2022.utils.Utilities;
import priv.samera2022.utils.mixture.CheckNumberMixture;
import priv.samera2022.utils.yaml.YamlConfigHandler;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class GroupMessageListener extends SimpleListenerHost {
    protected static int AS_SYSTEM_MODE = 0;
    @EventHandler
    public void asSystem(GroupMessageEvent event) throws IOException {
        String prefix = YamlConfigHandler.getConfig().getMessage().getAs_system_prefix();
//        String prefix = "as_";
        if (AS_SYSTEM_MODE == 0) {
            String content = event.getMessage().contentToString();
            if (content.indexOf(prefix) == 0) {
                if (event.getSender().getPermission().getLevel() != 0) {
                    String qq = content.split(prefix,2)[1];
                    CheckNumberMixture checkNumberMixture = Utilities.checkMessage(qq);
                    int result = checkNumberMixture.getCode();
                    switch (result){
                        case CheckNumberMixture.CODE_IS_NULL:
                            event.getGroup().sendMessage(YamlConfigHandler.getConfig().getMessage().getAs_system_empty_code());
                            break;
                        case CheckNumberMixture.CODE_CONTAINS_NON_NUMBER:
                            event.getGroup().sendMessage(YamlConfigHandler.getConfig().getMessage().getAs_system_error_code() + checkNumberMixture.getOutput());
                            break;
                        case CheckNumberMixture.CODE_IS_NUMBER:
                            long qqNumber = Long.parseLong(qq);
//                          event.getGroup().sendMessage("正在进行操作：将 " + qqNick + "(" + qqNumber + ")" + " 列入黑名单...");
                            event.getGroup().sendMessage("正在进行操作：将 " + qqNumber + " 列入黑名单...");
//                          if (FileHandler.readTxt().contains(qqNick)) {
                            if (Utilities.readFile(new File(Utilities.CUSTOM_FOLDER_PATH),FileHandler.ANTI_LIST_NAME).contains(String.valueOf(qqNumber))) {
                                event.getGroup().sendMessage(YamlConfigHandler.getConfig().getMessage().getAs_system_list_already_include());
                            } else {
//                              FileHandler.outputContent(qqNick + ":" + qq);
                                Utilities.appendContent(new File(Utilities.CUSTOM_FOLDER_PATH),FileHandler.ANTI_LIST_NAME,"|" + qqNumber + "|");
                                event.getGroup().sendMessage(YamlConfigHandler.getConfig().getMessage().getAs_system_verify_operation());
                                if (Utilities.readFile(new File(Utilities.CUSTOM_FOLDER_PATH), FileHandler.ANTI_LIST_NAME).contains(qq)) {
                                    event.getGroup().sendMessage(YamlConfigHandler.getConfig().getMessage().getAs_system_operation_completed());
                                } else {
                                    event.getGroup().sendMessage(YamlConfigHandler.getConfig().getMessage().getAs_system_operation_failed());
                                }
                            }
                    }
                } else {
                    event.getGroup().sendMessage(YamlConfigHandler.getConfig().getMessage().getAs_system_insufficient_permission());
                }
            }
        }
    }
    @EventHandler
    public void asSystem_Switch(GroupMessageEvent event){
        if (event.getPermission() != MemberPermission.MEMBER){
            Utilities.switchMode(AS_SYSTEM_MODE);
        }
    }
    @EventHandler
    public void asSystem_Ultimate(GroupMessageEvent event) throws FileNotFoundException {
        String prefix = YamlConfigHandler.getConfig().getMessage().getAs_system_prefix();
        if (AS_SYSTEM_MODE==1) {
            Value<List<String>> theList = asData.INSTANCE.list;
            List<String> actualList = theList.get();
            String content = event.getMessage().contentToString();
            if (content.indexOf(prefix) == 0) {
                if (event.getSender().getPermission().getLevel() != 0) {
                    String qq = content.split(prefix,2)[1];
                    CheckNumberMixture checkNumberMixture = Utilities.checkMessage(qq);
                    int result = checkNumberMixture.getCode();
                    switch (result){
                        case CheckNumberMixture.CODE_IS_NULL:
                            event.getGroup().sendMessage(YamlConfigHandler.getConfig().getMessage().getAs_system_empty_code());
                            break;
                        case CheckNumberMixture.CODE_CONTAINS_NON_NUMBER:
                            event.getGroup().sendMessage(YamlConfigHandler.getConfig().getMessage().getAs_system_error_code() + checkNumberMixture.getOutput());
                            break;
                        case CheckNumberMixture.CODE_IS_NUMBER:
                            long qqNumber = Long.parseLong(qq);
                            String turnedQQ = String.valueOf(qqNumber);
                            event.getGroup().sendMessage("正在进行操作：将 " + qqNumber + " 列入黑名单...");
                            if (actualList.contains(turnedQQ)) {
                                event.getGroup().sendMessage(YamlConfigHandler.getConfig().getMessage().getAs_system_list_already_include());
                            } else {
                                actualList.add(turnedQQ);
                                theList.set(actualList);
                                event.getGroup().sendMessage(YamlConfigHandler.getConfig().getMessage().getAs_system_verify_operation());
                                List<String> actuallyList2 = theList.get();
                                if (actuallyList2.contains(turnedQQ)) {
                                    event.getGroup().sendMessage(YamlConfigHandler.getConfig().getMessage().getAs_system_operation_completed());
                                } else {
                                    event.getGroup().sendMessage(YamlConfigHandler.getConfig().getMessage().getAs_system_operation_failed());
                                }
                            }
                    }
                } else {
                    event.getGroup().sendMessage((String) YamlConfigHandler.getConfig().getMessage().getAs_system_insufficient_permission());
                }
            }
        }
    }
}
