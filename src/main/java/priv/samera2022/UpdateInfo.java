package priv.samera2022;

public class UpdateInfo {
    public static String[] UpdateInfo;
    private static final String version_0_0_1 =
            " - [Unreleased] - [0.0.1] - [Unknown]\n" +
            "### [Added]\n" +
            " - 教程系统正式上线！具体详见Description。\n" +
            " - 增加头衔系统！（但是好像除了提示更改的头衔也就没啥用了）\n" +
            " - 增加入群欢迎系统！\n" +
            " - 增加反智械暴动系统：「口令弹出」！该系统慎用，当且仅当明显看出机器人异常时立即使用。\n" +
            " - 出现更新日志系统(雏形，尚未正式使用)！将从version0.0.2开始记录更新信息！(从0.0.2开始才记录更新信息，那这篇0.0.1是怎么写的呢？啊没错，是后面补的~所以日期写的是[Unknown]嘛)\n" +
            "### [Description]\n" +
            " - 教程系统整合了《我的世界教程广版》中绝大多数的教程，并且即将推出报错处理系统。" +
            "系统采用独特的模糊/全识别系统，只要在群里直接问问题机器人就会解答。";
    private static final String version_0_0_2 =
            " - [Unreleased] - [0.0.2] - 2023-01-16 20:42\n" +
            "### [Added]\n" +
            " - AS系统正式上线！具体详见Description！\n" +
            " - 更新日志系统正式完成！将从该版本开始记录更新信息！\n" +
            "### [Changed]\n" +
            " - 包结构正式由com.samcream改为priv.samera2022。\n" +
            "### [Description]\n" +
            " - AS系统是一个用于群管理的系统，它的作用相当于一个黑名单。" +
            "机器人将会自动将[qqID]存入下述路径中plugins/config/priv.samera2022.qqRobot/anti_list.txt中，" +
            "并在加群事件中自动侦测该QQ号是否加群。\n" +
            "Usage:as_[qqID]\n" +
            "示例：as_114514";
    private static final String version_0_0_3 =
            " - [Unreleased] - [0.0.3] - 2023-01-23 13:25\n" +
            "### [Added]\n" +
            " - 将群规-执行标准添加到了机器人的自动回复中。查询方法详见Description。\n" +
            " - 为AS系统添加了JAutoSavePluginData的储存机制。\n" +
            " - 为AS系统的储存机制添加了选择的功能，即可以选择txt储存或JAutoSavePluginData储存。但后者不建议使用。\n" +
            "### [Fixed]\n" +
            " - 完善了AS系统的判定与回复。\n" +
            "### [Description]\n" +
            " - 群规查询方法：\n" +
            "Usage:执行标准[code]\n" +
            "示例：执行标准A.1\n" + "" +
            "### [Warns]\n" +
            " - 目前JAutoSavePluginData不建议启用，可能会伴随不可控结果。\n" +
            " - 目前AS系统不确定是否能够正常工作，缺乏试验。\n" +
            " - 群规-执行标准的A/B/C系列无法直接完整发出，推测应该是消息过长的缘故。已使用messageToLong(at EventList.java Line 145)暂时锁止该逻辑。";
    private static final String version_0_0_4 =
            " - [Unreleased] - [0.0.4] - 2023-01-31 16:40\n" +
            "### [Added]\n" +
            " - 以Rcon协议为基础，支持在QQ群中执行服务器指令！\n" +
            " - 增加yaml配置文件！详情见Description。\n" +
            "### [Changed]\n" +
            " - 项目正式更名为Custom Robot，原项目QQ Robot因为设置错误已报废。\n" +
            " - 包结构改为priv.samera2022.functions和priv.samera2022.utils两个大包：" +
            "functions包下分as_system、minecraft_server和reception；" +
            "utils包下分mixture和yaml。\n" +
            "### [Description]\n" +
            " - 服务器指令触发前缀为”!“。目前提供给所有人的指令仅有!list指令，后续会考虑开放更多指令。\n" +
            " - yaml配置文件位置为.../config/priv.samera2022/config.yml。" +
            "目前config.yml支持AS系统的绝大多数回复的自定义" +
            "与Minecraft Rcon协议的服务器host，port和password的自定义。";
    private static final String version_0_0_5 =
            " - [Released] - [0.0.5] - 2023-02-25 15:08\n" +
            "### [Added]\n" +
            " - 增加本地插件系统，为服务器通信打下基础！详情见Description。\n" +
            " - 增加群权限类，但尚未准备开发。\n" +
            "### [Changed]\n" +
            " - Rcon协议的yaml格式进行修改，使其支持多个服务器。\n" +
            "### [Description]\n" +
            " - 增加本地插件系统指令有：签到、查看背包、查看个人信息、购买物品、查询物品描述等。";
    public static final String CurrentUpdateInfo = version_0_0_4;
    public static void init(){
        UpdateInfo = new String[]{version_0_0_1,version_0_0_2,version_0_0_3,version_0_0_4};
    }
}