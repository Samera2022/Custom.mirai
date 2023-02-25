package priv.samera2022;

import net.mamoe.mirai.console.plugin.jvm.JavaPlugin;
import net.mamoe.mirai.console.plugin.jvm.JvmPluginDescriptionBuilder;
import net.mamoe.mirai.event.Event;
import net.mamoe.mirai.event.EventChannel;
import net.mamoe.mirai.event.GlobalEventChannel;
import net.mamoe.mirai.event.ListenerHost;
import net.mamoe.mirai.event.events.BotEvent;
import net.mamoe.mirai.event.events.MemberJoinRequestEvent;
import priv.samera2022.functions.as_system.GroupMessageListener;
import priv.samera2022.functions.as_system.MemberRequestListener;
import priv.samera2022.functions.as_system.asData;
import priv.samera2022.functions.as_system.asUtils;
import priv.samera2022.functions.minecraft_server.minecraft_plugin.NetworkHandler;
import priv.samera2022.functions.minecraft_server.minecraft_plugin.item.Items;
import priv.samera2022.functions.reception.ReceptionHandler;
import priv.samera2022.utils.FileHandler;
import priv.samera2022.utils.Utilities;
import priv.samera2022.utils.yaml.YamlConfigHandler;
import priv.samera2022.utils.yaml.YamlMarketHandler;

import java.io.File;
import java.io.IOException;

public final class Custom extends JavaPlugin {
    private static final long DEVELOPER_ID = 572360179L;
    private static final long BOT_ID = 2328790565L;
    public static long START_TIME;
    //private static final long BOT_ID = 2328790565L;

    public static final Custom INSTANCE = new Custom();

    private Custom() {
        super((new JvmPluginDescriptionBuilder("priv.samera2022.customRobot", "0.0.5"))
                .name("Custom")
                .info("A Private Mirai Plugin.")
                .author("Samera2022")
                .build());
    }

    @Override
    public void onEnable() {
        getLogger().info("Plugin qqRobot loaded!");
        START_TIME = System.currentTimeMillis();
        EventChannel<Event> eventChannel = GlobalEventChannel.INSTANCE.filter(ev -> Boolean.valueOf((ev instanceof BotEvent && ((BotEvent)ev).getBot().getId() == BOT_ID)));
        eventChannel.registerListenerHost((ListenerHost)new EventList());
        //AS系统注册
        eventChannel.registerListenerHost((ListenerHost)new GroupMessageListener());
        eventChannel.filter(event ->
        {
            boolean result = false;
            try {
                result = asUtils.isNotDeny(((MemberJoinRequestEvent)event).getFromId());
            } catch (IOException e) {
                e.printStackTrace();
            }
            return result;
        }).registerListenerHost((ListenerHost)new MemberRequestListener());

        System.out.println("path: "+Utilities.getCustomFolderPath());
        ReceptionHandler.init();
        UpdateInfo.init();
        Items.init();
        try {
            NetworkHandler.init();
            FileHandler.init();
            if (Utilities.readFile(new File(Utilities.CUSTOM_FOLDER_PATH),FileHandler.CONFIG_NAME).isEmpty()){
                YamlConfigHandler.setDefault();
            }
            if (Utilities.readFile(new File(Utilities.CUSTOM_FOLDER_PATH),FileHandler.MARKET_NAME).isEmpty()){
                YamlMarketHandler.setDefault();
            }
        } catch (IOException e){
            e.printStackTrace();
        }
        this.reloadPluginData(asData.INSTANCE); // 读取文件等
    }
}