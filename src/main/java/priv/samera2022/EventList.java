package priv.samera2022;

import kotlin.coroutines.CoroutineContext;
import net.mamoe.mirai.contact.Contact;
import net.mamoe.mirai.contact.Group;
import net.mamoe.mirai.contact.MemberPermission;
import net.mamoe.mirai.event.EventHandler;
import net.mamoe.mirai.event.SimpleListenerHost;
import net.mamoe.mirai.event.events.GroupMessageEvent;
import net.mamoe.mirai.event.events.MemberJoinEvent;
import net.mamoe.mirai.event.events.MemberSpecialTitleChangeEvent;
import org.jetbrains.annotations.NotNull;
import priv.samera2022.functions.minecraft_server.MinecraftServer;
import priv.samera2022.functions.reception.MessageHandler;
import priv.samera2022.utils.Utilities;
import priv.samera2022.utils.mixture.CheckNumberMixture;
import priv.samera2022.utils.yaml.YamlConfigHandler;
import priv.samera2022.utils.yaml.config.minecraft_server.MinecraftRcon;

import java.io.IOException;
import java.text.ParseException;

public class EventList extends SimpleListenerHost {
    private static int WELCOME_MODE = 0;

    public void handleException(@NotNull CoroutineContext context, @NotNull Throwable exception) {
    }

    /*
    @EventHandler
    public void test(GroupMessageEvent event) {
        if (event.getMessage().contentToString().equals("test")) {
            System.out.println(utils.getNick(event, 572360179));
        }
    }
    @EventHandler
    public void kill(GroupMessageEvent event){
        if (event.getMessage().contentToString().equals("清理人员")&&event.getSender().getPermission()==MemberPermission.OWNER){
            ContactList<NormalMember> list = event.getGroup().getMembers();
            for (NormalMember member : list){
                int getLastSpeak = member.getLastSpeakTimestamp();
                if (getLastSpeak<1658224844){
                    member.kick("人口清理，您被界定为6个月以上未发言的人");
                }
            }
        }
    }
    @EventHandler
    public void check(GroupMessageEvent event){
        if (event.getMessage().contentToString().contains("查询")&&event.getSender().getPermission()==MemberPermission.OWNER){
            String qqID = event.getMessage().contentToString().substring(2);
            long qq = Long.parseLong(qqID);
            NormalMember mm = event.getGroup().getMembers().get(qq);
            int time = event.getGroup().getMembers().get(qq).getLastSpeakTimestamp();
            event.getGroup().sendMessage("最后一次发言时间距今（单位：秒）:"+time);
            event.getGroup().sendMessage("换算时间："+timeTranslate(qq));
            if (time<1658224844) event.getGroup().sendMessage("已被界定为超时人员");
        }
    }
    */
    @EventHandler
    public void minecraft_qq(GroupMessageEvent event) throws IOException, ParseException {
        System.out.println("method works!");
        String content = event.getMessage().contentToString();
        MinecraftRcon[] rcons = YamlConfigHandler.getConfig().getServer().getRcon();
        String rconPrefix = "";
        String pluginPrefix = YamlConfigHandler.getConfig().getMessage().getMinecraft_plugin_prefix();
        MinecraftRcon targetRcon = new MinecraftRcon();
        for (MinecraftRcon rcon : rcons) {
            if (content.indexOf(rcon.getPrefix()) == 0) {
                rconPrefix = rcon.getPrefix();
                targetRcon = rcon;
                break;
            }
        }
        if ((content.indexOf(rconPrefix)==0)&&(!rconPrefix.equals(""))) {
            System.out.println("rconPrefix!");
            String reply = MinecraftServer.rconCommandHandler(targetRcon, content.split(rconPrefix, 2)[1], event.getSender().getPermission().getLevel());
            String output = reply.isEmpty() ? "------来自" + targetRcon.getName() + "的执行结果------\n" + reply +
                    "\n------来自" + targetRcon.getName() + "的执行结果------" : "";
            event.getGroup().sendMessage(output);
        } else if (content.indexOf(pluginPrefix) == 0) {
            System.out.println("pluginPrefix!");
            String[] messages = MinecraftServer.localPluginCommandHandler(event.getSender().getId(), content.split(pluginPrefix, 2)[1], event.getSender().getPermission().getLevel());
            for (String message : messages) {
                event.getGroup().sendMessage(message);
            }
        }
    }

    @EventHandler
    public void MemberJoin(@NotNull MemberJoinEvent event) {
        if (event.getGroup().getId()==54207229L) {
            MessageOutput(event.getMember().getNick(), event.getGroup());
        }
    }
//    @Deprecated
//    @EventHandler
//    public void sortMessage(GroupMessageEvent event){
//        String message = event.getMessage().contentToString();
//        if (message.indexOf("绑定")==0){
//            String playerName = Utilities.getSubString("绑定",message);
//        }
//    }

    public static void MessageOutput(String sender, Group activeGroup) {
        String content = null;
        String content2 = null;
        switch (WELCOME_MODE) {
            case 0:
                content = "欢迎" + sender + "加群啦~\n" +
                        "主群865907066 主要提供基础的视频教程与文本教程\n" +
                        "1群955061228 主要提供插件开发教程与Mirai设置\n" +
                        "2群829314911 主要提供模组开发教程与ServerSync设置\n" +
                        "3群565669662 主要用于沟通与交流(大白话就是闲聊群啦)\n" +
                        "4群849920970 主要也用于沟通与交流(还是闲聊群啦)\n" +
                        "群频道https://qun.qq.com/qqweb/qunpro/share?_wv=3&_wwv=128&appChannel=share&inviteCode=1W5F6Nm&appChannel=share&businessType=9&from=246610&biz=ka" +
                        "如果觉得群不错的话可以推荐给朋友哦OvO!\n" +
                        "在聊天框输入(菜单)可以进入机器人的联机等待大厅哦";
                content2 = "但是切忌白嫖党！忌进来找完资源就退！";
                break;
            case 1:
                content = "欢迎来到这个群聊~\n" +
                        "群内可能时常没人在线，要学会自己看群文件的教程哦~";
                content2 = "如果看不懂的话也可以来问问我(虽然我只是一个机器人)";
        }
        activeGroup.sendMessage(content);
        activeGroup.sendMessage(content2);
    }

    @EventHandler
    public void GroupMessageHandler(GroupMessageEvent event) {
        String content = event.getMessage().contentToString();
        String tutorialReply = MessageHandler.getTutorialReply(content);
        switch (event.getMessage().contentToString()) {
            case "欢迎测试":
                MessageOutput(event.getSender().getNick(), event.getGroup());
                break;
            case "口令弹出":
                event.getGroup().sendMessage("收到中止指令！正在传递口令信息！");
                long endTime = System.currentTimeMillis();
                for (Contact contact : event.getBot().getGroups()) {
                    contact.sendMessage("程序遭到中止！详细信息如下:\n" +
                            "中止口令: 「弹出」\n" +
                            "中止发起群: 「" + event.getGroup().getName() + "(" + event.getGroup().getId() + ")" + "」\n" +
                            "中止发起源: 「" + event.getSender().getNick() + "(" + event.getSender().getId() + ")" + "」\n" +
                            "系统运行时间: " + timeTranslate(endTime - Custom.START_TIME));
                }
                System.exit(0);
                break;
            case "更新日志":
                event.getGroup().sendMessage(UpdateInfo.CurrentUpdateInfo);
                break;
            case "菜单":
                event.getGroup().sendMessage("「伪菜单」\n" +
                        "1.更新日志\n" +
                        "2.欢迎测试\n" +
                        "3.执行标准<code>\n" +
                        "4.查看更新日志<code>\n" +
                        "5.欢迎语切换（仅群主可用）\n" +
                        "6.口令弹出（仅紧急情况可用）\n" +
                        "「AS系统菜单（仅管理可用）」\n" +
                        "1.as_<qqID>\n" +
                        "2.as模式切换\n" +
                        "「Minecraft Plugin系统菜单」\n" +
                        "1.签到\n" +
                        "2.查看背包\n" +
                        "3.查看个人信息\n" +
                        "4.购买物品<displayName>\n" +
                        "5.查看物品描述<displayName>\n");
                break;
            case "欢迎语切换":
                if (event.getSender().getPermission() == MemberPermission.OWNER) {
                    Utilities.switchMode(WELCOME_MODE);
                    event.getGroup().sendMessage("欢迎语切换成功！");
                }
                break;
            default:
                if (tutorialReply != null) {
                    event.getGroup().sendMessage(tutorialReply);
                } else if (content.indexOf("查看更新日志") == 0) {
                    String code = content.split("查看更新日志", 2)[1];
                    CheckNumberMixture checkNumberMixture = Utilities.checkMessage(code);
                    int result = checkNumberMixture.getCode();
                    switch (result) {
                        case CheckNumberMixture.CODE_IS_NULL:
                            event.getGroup().sendMessage("执行出错！目标<code>不能为空！");
                            break;
                        case CheckNumberMixture.CODE_CONTAINS_NON_NUMBER:
                            event.getGroup().sendMessage("执行出错！发现以下错误字符:" + checkNumberMixture.getOutput());
                            break;
                        case CheckNumberMixture.CODE_IS_NUMBER:
                            String updateInfo = UpdateInfo.UpdateInfo[Integer.parseInt(code) - 1];
                            event.getGroup().sendMessage(updateInfo);
                            break;
                    }
                } else if (content.indexOf("执行标准") == 0) {
                    String code = content.split("执行标准", 2)[1];
                    if (!code.equals("")) {
                        String result = "------执行标准";
                        String _result = "";
                        boolean goOn = true;
                        boolean goOn2 = true;
                        boolean messageTooLong = false;
                        if (code.contains("A")) {
                            _result = "A------";
                        } else if (code.contains("B")) {
                            _result = "B------";
                        } else if (code.contains("C")) {
                            _result = "C------";
                        } else {
                            goOn = false;
                        }//技术问题，暂不能实现。原因：消息过长
                        if (code.equals("A") || code.equals("B") || code.equals("C")) {
                            messageTooLong = true;
                        }
                        if (goOn && (!messageTooLong)) {
                            result = result + _result + "\n";
                            String __result = "";
                            switch (code) {
                                case "A":
                                    __result = "1.讨论国家、道德上禁止讨论的东西\n" +
                                            "譬如:祖国分裂言论\n" +
                                            "惩罚措施:举报+踢\n" +
                                            "----------------------" +
                                            "2.广告、宣传\n" +
                                            "譬如:未经同意却宣传服务器\n" +
                                            "惩罚措施:禁言7+天\n" +
                                            "----------------------" +
                                            "3.辱骂他人\n" +
                                            "譬如:******\n" +
                                            "惩罚措施:禁言1+天\n" +
                                            "----------------------" +
                                            "4.歧视\n" +
                                            "譬如:yoyoyo~原来是用盗版的小鬼啊\n" +
                                            "P.S. 你所见到的五种我的世界账号，都是MOJANG所认可或默许的，不存在“盗版账户”。\n" +
                                            "惩罚措施:踢\n" +
                                            "----------------------" +
                                            "5.挑衅,引战,钓鱼\n" +
                                            "譬如:其实我的世界是抄袭迷你世界的\n" +
                                            "惩罚措施:禁言29+天，一般建议丢出去\n" +
                                            "----------------------" +
                                            "6.宣传邪教\n" +
                                            "譬如:来来来~法轮功招新人了(P.S.邪教的定义请自己查询网络)\n" +
                                            "惩罚措施:行走的三十万？快快来举报吧~\n";
                                    break;
                                case "A.1":
                                    __result = "1.讨论国家、道德上禁止讨论的东西\n" +
                                            "譬如:祖国分裂言论\n" +
                                            "惩罚措施:举报+踢\n";
                                    break;
                                case "A.2":
                                    __result = "2.广告、宣传\n" +
                                            "譬如:未经同意却宣传服务器\n" +
                                            "惩罚措施:禁言7+天\n";
                                    break;
                                case "A.3":
                                    __result = "3.辱骂他人\n" +
                                            "譬如:******\n" +
                                            "惩罚措施:禁言1+天\n";
                                    break;
                                case "A.4":
                                    __result = "4.歧视、挑衅(引战)\n" +
                                            "譬如:yoyoyo~原来是用盗版的小鬼啊\n" +
                                            "惩罚措施:踢\n";
                                    break;
                                case "A.5":
                                    __result = "5.钓鱼\n" +
                                            "譬如:其实我的世界是抄袭迷你世界的\n" +
                                            "惩罚措施:禁言29+天，一般建议丢出去\n";
                                    break;
                                case "A.6":
                                    __result = "6.宣传邪教\n" +
                                            "譬如:来来来~法轮功招新人了(P.S.邪教的定义请自己查询网络)\n" +
                                            "惩罚措施:行走的三十万？快快来举报吧~\n";
                                    break;
                                case "B":
                                    __result = "1.涉黄、暴力\n" +
                                            "譬如：发涉黄、暴力的消息/图片/视频\n" +
                                            "惩罚措施：举报+踢 或 禁言1+天\n" +
                                            "----------------------" +
                                            "2.血腥、恐怖\n" +
                                            "譬如：发血腥、恐怖的消息/图片/视频\n" +
                                            "惩罚措施：举报+踢 或 禁言1+天\n" +
                                            "----------------------" +
                                            "3.精神污染\n" +
                                            "譬如 发/说 精神污染/暴击 的 图片/视频/聊天记录/消息\n" +
                                            "比如：武器A\n" +
                                            "惩罚措施：举报+踢\n";
                                    break;
                                case "B.1":
                                    __result = "1.涉黄、暴力\n" +
                                            "譬如：发涉黄、暴力的消息/图片/视频\n" +
                                            "惩罚措施：举报+踢 或 禁言1+天\n";
                                    break;
                                case "B.2":
                                    __result = "2.血腥、恐怖\n" +
                                            "譬如：发血腥、恐怖的消息/图片/视频\n" +
                                            "惩罚措施：举报+踢 或 禁言1+天\n";
                                    break;
                                case "B.3":
                                    __result = "3.精神污染\n" +
                                            "譬如 发/说 精神污染/暴击 的 图片/视频/聊天记录/消息\n" +
                                            "比如：武器A\n" +
                                            "惩罚措施：举报+踢\n";
                                    break;
                                case "C":
                                    __result = "1.大量/重复 的各种形式消息(无具体意义)\n" +
                                            "譬如:一长串的哦/表情包\n" +
                                            "注意:如果本来就是一段逻辑通顺的消息，但碍于实际语境只能分段发送的，不在此列。\n" +
                                            "消息形式:\n" +
                                            "礼物[超过5条必禁言][超过3条若他人举报即禁言]\n" +
                                            "图片/视频[超过4张]\n" +
                                            "文本[超过5条]\n" +
                                            "任何其他的形式[均不得超过5条]\n" +
                                            "超出的部分乘50为实际禁言时间，如果单次刷屏消息量超过10条，建议踢出。\n" +
                                            "----------------------" +
                                            "2. 长条消息(特指一条消息中无意义的部分)\n" +
                                            "以5行(háng)为上限，超出的部分乘50为实际禁言时间。\n" +
                                            "如果是连续的多段消息符合无意义的前提，则可以叠加计算。\n";
                                    break;
                                case "C.1":
                                    __result = "1.大量/重复 的各种形式消息(无具体意义)\n" +
                                            "譬如:一长串的哦/表情包\n" +
                                            "注意:如果本来就是一段逻辑通顺的消息，但碍于实际语境只能分段发送的，不在此列。\n" +
                                            "消息形式:\n" +
                                            "礼物[超过5条必禁言][超过3条若他人举报即禁言]\n" +
                                            "图片/视频[超过4张]\n" +
                                            "文本[超过5条]\n" +
                                            "任何其他的形式[均不得超过5条]\n" +
                                            "超出的部分乘50为实际禁言时间，如果单次刷屏消息量超过10条，建议踢出。\n";
                                    break;
                                case "C.2":
                                    __result = "2. 长条消息(特指一条消息中无意义的部分)\n" +
                                            "以5行(háng)为上限，超出的部分乘50为实际禁言时间。\n" +
                                            "如果是连续的多段消息符合无意义的前提，则可以叠加计算。\n";
                                    break;
                                default:
                                    goOn2 = false;
                                    break;
                            }
                            if (__result.length() != 0) {
                                result = result + __result + "本条内的禁言时间如未特别说明，单位均为小时\n" +
                                        "解释权归群主和管理所有\n" +
                                        "如果对处置结果不满意，请自行联系群主处理。\n" +
                                        "------执行标准" + _result;
                                event.getGroup().sendMessage(result);
                            }
                        } else if (messageTooLong) {
                            event.getGroup().sendMessage("由于技术原因，执行标准A/B/C暂不支持全文发送，请等待以后更新。");
                        }
                        if (!(goOn && goOn2)) {
                            event.getGroup().sendMessage("未知的执行标准代码！");
                        }
                    } else {
                        event.getGroup().sendMessage("执行标准代码不能为空！");
                    }
                }
                break;
        }
    }

    @EventHandler
    public void STChange(MemberSpecialTitleChangeEvent event) {
        String reply = "";
        if (!event.getOrigin().equals("") && !event.getNew().equals("")) {
            reply = event.getMember().getNick() + "(" + event.getMember().getId() + ")" + "的头衔由“" + event.getOrigin() + "”变为了“" + event.getNew() + "”";
        } else if (event.getNew().equals("")) {
            reply = event.getMember().getNick() + "(" + event.getMember().getId() + ")" + "的头衔被群主收回力！原来的头衔是\"" + event.getOrigin() + "\"";
        } else if (event.getOrigin().equals("")) {
            reply = "恭喜" + event.getMember().getNick() + "(" + event.getMember().getId() + ")" + "获得了群主授予的头衔\"" + event.getNew() + "\"";
        }
        event.getGroup().sendMessage(reply);
    }

    private String timeTranslate(long time) {
        String reply = "";
        //获得系统的时间，单位为毫秒,转换为秒
        long totalSeconds = time / 1000;
        //求当前时间的秒
        long totalSecond = totalSeconds % 60;
        //求当前时间的分
        long totalMinutes = totalSeconds / 60;
        long totalMinute = totalMinutes % 60;
        //求当前时间的时
        long totalHours = totalSeconds / 3600;
        long totalHour = totalHours % 24;
        if (totalHour != 0) {
            if (totalMinute != 0) {
                if (totalSecond != 0) {
                    reply = totalHour + "时" + totalMinute + "分" + totalSecond + "秒";
                } else {
                    reply = totalHour + "时" + totalMinute + "分";
                }
            } else {
                if (totalSecond != 0) {
                    reply = totalHour + "时" + totalSecond + "秒";
                } else {
                    reply = totalHour + "时";
                }
            }
        } else {
            if (totalMinute != 0) {
                if (totalSecond != 0) {
                    reply = totalMinute + "分" + totalSecond + "秒";
                } else {
                    reply = totalMinute + "分";
                }
            } else {
                if (totalSecond != 0) {
                    reply = totalSecond + "秒";
                } else {
                    reply = "";
                }
            }
        }
        return reply;
    }
}