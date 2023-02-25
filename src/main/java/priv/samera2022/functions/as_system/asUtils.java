package priv.samera2022.functions.as_system;

import net.mamoe.mirai.console.data.Value;
import net.mamoe.mirai.event.events.BotEvent;
import priv.samera2022.utils.FileHandler;
import priv.samera2022.utils.Utilities;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class asUtils {
    @Deprecated
    public static String getNick(BotEvent event,long qqNumber){
        System.out.println("Bot:"+event.getBot().getId());
        System.out.println(event.getBot().getStranger(qqNumber));
        System.out.println("ID:"+event.getBot().getStranger(qqNumber).getNick());
        return event.getBot().getStranger(qqNumber).getNick();
    }//注意！这个方法不能使用！使用会导致后续指令无法执行！等待后续测试！
    //证实：event.getBot().getStranger(qqNumber)=null
    public static boolean isNotDeny(long qqNumber) throws IOException {
        Value<List<String>> theList = asData.INSTANCE.list;
        List<String> actualList = theList.get();
        boolean deny = false;
        switch (GroupMessageListener.AS_SYSTEM_MODE) {
            case 0:
                deny = Utilities.readFile(new File(Utilities.CUSTOM_FOLDER_PATH), FileHandler.ANTI_LIST_NAME).contains(String.valueOf(qqNumber));
                break;
            case 1:
                deny = actualList.contains(String.valueOf(qqNumber));
        }
        return deny;
    }
}
