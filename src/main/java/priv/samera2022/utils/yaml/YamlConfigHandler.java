package priv.samera2022.utils.yaml;

import org.ho.yaml.Yaml;
import priv.samera2022.utils.FileHandler;
import priv.samera2022.utils.Utilities;
import priv.samera2022.utils.yaml.config.Config;
import priv.samera2022.utils.yaml.config.Message;
import priv.samera2022.utils.yaml.config.minecraft_server.MinecraftPlugin;
import priv.samera2022.utils.yaml.config.minecraft_server.MinecraftRcon;
import priv.samera2022.utils.yaml.config.minecraft_server.MinecraftServer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class YamlConfigHandler {
    public static void main(String[]args) throws IOException {
        setTest();
//        File file = new File("config.yml");
//        HashMap<Long, String> QQ_PLAYER_LIST = new HashMap<>();
//        QQ_PLAYER_LIST.put(572360179L, "Samera2022");
//        QQ_PLAYER_LIST.put(114514L, "Chou");
//        Yaml.dump(QQ_PLAYER_LIST, file);
    }

    public static void setTest() throws IOException {
        File dumpFile = new File("config.yml");
        if (!dumpFile.exists()) dumpFile.createNewFile();
        Config config = new Config();
        MinecraftServer minecraftServer = new MinecraftServer();

        MinecraftRcon minecraftRcon = new MinecraftRcon();
        minecraftRcon.setPrefix("./");
        minecraftRcon.setName("@Survival Server@");
        minecraftRcon.setHost("@localhost@");
        minecraftRcon.setPort(25575);
        minecraftRcon.setPassword("@pwd@");
        MinecraftRcon minecraftRcon2 = new MinecraftRcon();
        minecraftRcon2.setPrefix("../");
        minecraftRcon2.setName("@PVP Server@");
        minecraftRcon2.setHost("@0.0.0.0@");
        minecraftRcon2.setPort(25575);
        minecraftRcon2.setPassword("@pwd@");
        MinecraftRcon[] minecraftRcons = new MinecraftRcon[]{minecraftRcon,minecraftRcon2};
        minecraftServer.setRcon(minecraftRcons);

        MinecraftPlugin minecraftPlugin = new MinecraftPlugin();
        minecraftPlugin.setHost("@localhost@");
        minecraftPlugin.setPort(25576);
        minecraftPlugin.setPassword("@pwd@");
        minecraftServer.setPlugin(minecraftPlugin);

        Message message = new Message();
        message.setAs_system_prefix("as_");
        message.setAs_system_empty_code("执行出错！目标<qqID>不能为空！");
        message.setAs_system_error_code("执行出错！发现以下错误字符：");
        message.setAs_system_insufficient_permission("执行出错！当前用户组暂无该权限！");
        message.setAs_system_list_already_include("执行出错！原表已有该用户！");
        message.setAs_system_operation_completed("操作已完成！");
        message.setAs_system_operation_failed("操作失败！");
        message.setAs_system_verify_operation("正在校验操作是否完成...");
        message.setAs_system_member_request_deny("ERROR CODE：404");
        message.setMinecraft_plugin_prefix("@!@");


        config.setServer(minecraftServer);
        config.setMessage(message);

        Yaml.dump(config, dumpFile);
        replaceCharTo(new File("D:/_S_A_M/Desktop/Bot/[MCL] Custom Robot"), FileHandler.CONFIG_NAME, '@', '\'');
    }

    public static Config getConfig() throws FileNotFoundException {
        return Yaml.loadType(new File(Utilities.CUSTOM_FOLDER_PATH+FileHandler.CONFIG_NAME), Config.class);    }

    public static void setDefault() throws IOException {
        File folder = new File(Utilities.CUSTOM_FOLDER_PATH);
        File dumpFile = new File(Utilities.CUSTOM_FOLDER_PATH+FileHandler.CONFIG_NAME);
        if (!folder.exists()) folder.mkdirs();
        if (!dumpFile.exists()) dumpFile.createNewFile();
        Config config = new Config();
        MinecraftServer minecraftServer = new MinecraftServer();

        MinecraftRcon minecraftRcon = new MinecraftRcon();
        minecraftRcon.setPrefix("./");
        minecraftRcon.setName("@Survival Server@");
        minecraftRcon.setHost("@localhost@");
        minecraftRcon.setPort(25575);
        minecraftRcon.setPassword("@pwd@");
        MinecraftRcon minecraftRcon2 = new MinecraftRcon();
        minecraftRcon2.setPrefix("../");
        minecraftRcon2.setName("@PVP Server@");
        minecraftRcon2.setHost("@0.0.0.0@");
        minecraftRcon2.setPort(25575);
        minecraftRcon2.setPassword("@pwd@");
        MinecraftRcon[] minecraftRcons = new MinecraftRcon[]{minecraftRcon,minecraftRcon2};
        minecraftServer.setRcon(minecraftRcons);

//        minecraftServer.setRcon(minecraftRcon);

        MinecraftPlugin minecraftPlugin = new MinecraftPlugin();
        minecraftPlugin.setHost("@localhost@");
        minecraftPlugin.setPort(25576);
        minecraftPlugin.setPassword("@pwd@");
        minecraftServer.setPlugin(minecraftPlugin);

        Message message = new Message();
        message.setAs_system_prefix("as_");
        message.setAs_system_empty_code("执行出错！目标<qqID>不能为空！");
        message.setAs_system_error_code("执行出错！发现以下错误字符：");
        message.setAs_system_insufficient_permission("执行出错！当前用户组暂无该权限！");
        message.setAs_system_list_already_include("执行出错！原表已有该用户！");
        message.setAs_system_operation_completed("操作已完成！");
        message.setAs_system_operation_failed("操作失败！");
        message.setAs_system_verify_operation("正在校验操作是否完成...");
        message.setAs_system_member_request_deny("ERROR CODE：404");
        message.setMinecraft_plugin_prefix("@!@");

        config.setServer(minecraftServer);
        config.setMessage(message);

        Yaml.dump(config, dumpFile);
        replaceCharTo(folder, FileHandler.CONFIG_NAME, '@', '\'');
    }

    private static void replaceCharTo(File folder, String fileName, char target, char replacement) throws IOException {
        //change target into replacement
        String content = Utilities.readFile(folder, fileName);
        content = java.net.URLDecoder.decode(content.replaceAll("@", "'"), "UTF-8");
        Utilities.write(folder, fileName, content);
    }

}
