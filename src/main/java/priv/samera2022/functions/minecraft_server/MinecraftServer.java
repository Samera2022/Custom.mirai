package priv.samera2022.functions.minecraft_server;


import org.ho.yaml.Yaml;
import org.ho.yaml.YamlDecoder;
import priv.samera2022.functions.minecraft_server.minecraft_plugin.Player;
import priv.samera2022.functions.minecraft_server.minecraft_plugin.item.Item;
import priv.samera2022.functions.minecraft_server.minecraft_plugin.item.ItemNameStack;
import priv.samera2022.functions.minecraft_server.minecraft_plugin.item.Items;
import priv.samera2022.functions.minecraft_server.rcon.Rcon;
import priv.samera2022.utils.Utilities;
import priv.samera2022.utils.mixture.SearchItemMixture;
import priv.samera2022.utils.yaml.YamlMarketHandler;
import priv.samera2022.utils.yaml.YamlPlayerQQHandler;
import priv.samera2022.utils.yaml.config.minecraft_server.MinecraftRcon;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class MinecraftServer {
    public static void main(String[] args) throws IOException, ParseException {
        String[] st = localPluginCommandHandler(572360179L, "签到", 2);
        for (String output : st) {
            System.out.println(output);
        }
    }

    public static String rconCommandHandler(MinecraftRcon configRcon, String command, int permission) throws IOException {
        Rcon rcon = Rcon.open(configRcon.getHost(), configRcon.getPort());
        String output = "";
        if (rcon.authenticate(configRcon.getPassword())) {
            if (command.equalsIgnoreCase("list")) {
                output = rcon.sendCommand("list");
            } else if (permission == 2) {
                output = rcon.sendCommand(command);
            }
        } else {
            output = "Failed to authenticate!";
        }
        return output;
    }

    public static String[] localPluginCommandHandler(long senderID, String command, int permission) throws IOException, ParseException {
//        Socket socket = new Socket(((String) ((HashMap<?,?>)YamlHandler.getConfig("server").get("plugin")).get("host")),((int) ((HashMap<?,?>)YamlHandler.getConfig("server").get("plugin")).get("port")));
        String[] content = new String[2];
        HashMap<Long, String> hashMap = YamlPlayerQQHandler.readUserMCQQ();//读取所有人的QQ-PlayerName表
        switch (command) {
            case "签到":
                if (hashMap.containsKey(senderID)) {
                    Calendar calendar = Calendar.getInstance();
                    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    String time = formatter.format(calendar.getTime());
                    Player playerInfo = getPlayer(new File(Utilities.PLAYER_DATA_PATH), senderID + ".yml");
                    String lastLoginDate = playerInfo.getLastLoginDate();
                    String lastSignInDate = playerInfo.getLastSignInDate();
                    String playerName = playerInfo.getPlayerName();
                    List<ItemNameStack> iNSs = playerInfo.getBackpack();
                    long samCoin = playerInfo.getSamCoin();
                    if (!lastSignInDate.equals("null")) {
                        HashMap<String, Long> timeDiff = Utilities.findDiff(time, lastSignInDate);
                        long seconds = timeDiff.get("second");
                        long minutes = timeDiff.get("minute");
                        long hours = timeDiff.get("hour");
                        long days = timeDiff.get("day");
                        long years = timeDiff.get("year");
                        long total = seconds + minutes * 60 + hours * 60 * 60 + days * 24 * 60 * 60 + years * 365 * 24 * 60 * 60;
                        if (total >= 86400) {
                            Random random = new Random();
                            int getCoin = random.nextInt(4) + 1;
                            content = new String[]{"签到成功！获得「" + getCoin + "个SamCoin」！"};
                            Player player = new Player();
                            player.setPlayerName(playerName);
                            player.setSamCoin(samCoin + getCoin);
                            player.setLastLoginDate(lastLoginDate);
                            player.setLastSignInDate(time);
                            player.setBackpack(iNSs);
                            Yaml.dump(player, new File(Utilities.PLAYER_DATA_PATH + senderID + ".yml"));
                        } else {
                            content = new String[]{"啊啦~签到太频繁了嘛，下次签到请等待" + (24 - hours - 1) + "小时" + (60 - minutes - 1) + "分钟" + (60 - seconds) + "秒"};
                        }
                    } else {
                        Random random = new Random();
                        int getCoin = random.nextInt(4) + 1;
                        content = new String[]{"签到成功！获得「" + getCoin + "个SamCoin」！"};
                        Player player = new Player();
                        player.setPlayerName(playerName);
                        player.setSamCoin(samCoin + getCoin);
                        player.setLastLoginDate(lastLoginDate);
                        player.setLastSignInDate(time);
                        player.setBackpack(iNSs);
                        Yaml.dump(player, new File(Utilities.PLAYER_DATA_PATH + senderID + ".yml"));
                    }
                } else {
                    content = new String[]{"执行出错！用户尚未绑定游戏角色名！"};
                }
                break;
            case "查看个人信息":
                if (hashMap.containsKey(senderID)) {
                    Player playerInfo = getPlayer(new File(Utilities.PLAYER_DATA_PATH), senderID + ".yml");
                    String lastLoginDate = playerInfo.getLastLoginDate();
                    String playerName = playerInfo.getPlayerName();
                    long samCoin = playerInfo.getSamCoin();
                    String lastSignInDate = playerInfo.getLastSignInDate();
                    content = new String[]{"----个人信息----\n" +
                            "绑定玩家名称：" + playerName + "\n" +
                            "上次上线日期：" + lastLoginDate + "\n" +
                            "上次签到日期：" + lastSignInDate + "\n" +
                            "山姆币：" + samCoin};
                } else {
                    content = new String[]{"执行出错！用户尚未绑定游戏角色名！"};
                }
                break;
            case "查看背包":
                if (hashMap.containsKey(senderID)) {
                    Player playerInfo = getPlayer(new File(Utilities.PLAYER_DATA_PATH), senderID + ".yml");
                    String playerName = playerInfo.getPlayerName();
                    List<ItemNameStack> itemStacks = playerInfo.getBackpack();
                    String output = "";
                    for (ItemNameStack iNS : itemStacks) {
                        output = output + "\n" + iNS.getAmount() + "个「" + iNS.getDisplayName() + "」";
                    }
                    content = new String[]{"----" + playerName + "的背包----" + output};
                } else {
                    content = new String[]{"执行出错！用户尚未绑定游戏角色名！"};
                }
                break;
            default:
                if (command.indexOf("绑定") == 0) {
                    String bindPlayerName = command.split("绑定", 2)[1];
                    if (!bindPlayerName.isEmpty()) {
                        char[] elements = bindPlayerName.toCharArray();
                        StringBuilder errorElements = new StringBuilder();
                        boolean isCorrect = true;
                        for (char element : elements) {
                            if ((!Character.isLetterOrDigit(element)) && element != '_') {
                                isCorrect = false;
                                errorElements.append(" " + element);
                            }
                        }
                        if (isCorrect) {
                            if (hashMap.containsKey(senderID)) {
                                content = new String[]{"执行出错！原表已有绑定信息！请联系服务器拥有者进行修改！"};
                            } else if (hashMap.containsValue(bindPlayerName)) {
                                long qqID = 0;
                                for (long i : hashMap.keySet()) {
                                    if (hashMap.get(i).equals(bindPlayerName)) {
                                        qqID = i;
                                        break;
                                    }
                                }
                                content = new String[]{"执行出错！该用户名已绑定QQ号为" + qqID + "的群员！"};
                            } else {
                                YamlPlayerQQHandler.writeUserMCQQ(senderID, bindPlayerName);
                                File file = new File(Utilities.PLAYER_DATA_PATH + senderID + ".yml");
                                file.createNewFile();
                                Player player = new Player();
                                player.setPlayerName(bindPlayerName);
                                player.setSamCoin(5);
                                player.setLastLoginDate("null");
                                player.setLastSignInDate("null");

                                List<ItemNameStack> iNSs = new ArrayList<>();
                                ItemNameStack iNS = new ItemNameStack();
                                iNS.setDisplayName(Items.MASCOT_TOAME.getDisplayName());
                                iNS.setAmount(1);
                                iNSs.add(iNS);

                                player.setBackpack(iNSs);
                                Yaml.dump(player, file);
                                content = new String[]{"绑定成功！"};
                            }
                        } else {
                            content = new String[]{"执行出错！发现错误字符" + errorElements.toString()};
                        }
                    } else {
                        content = new String[]{"执行出错！绑定玩家名不能为空！"};
                    }
                } else if (command.indexOf("购买物品") == 0) {
                    String displayName = command.split("购买物品", 2)[1];
                    SearchItemMixture searchItemMixture = YamlMarketHandler.searchByDisplayName(displayName);
                    if (searchItemMixture.isContained()) {
                        Item item = searchItemMixture.getItem();
                        Player playerInfo = getPlayer(new File(Utilities.PLAYER_DATA_PATH), senderID + ".yml");
                        long samCoin = playerInfo.getSamCoin();
                        long price = item.getPrice();
                        long delta = samCoin - price;
                        if (delta > 0) {
                            List<ItemNameStack> iNSs = playerInfo.getBackpack();
                            boolean canBuy = true;
                            for (int j = 0; j < iNSs.size(); j++) {
                                ItemNameStack playerINS = iNSs.get(j);
                                if (playerINS.getDisplayName().equals(displayName)) {
                                    if (item.getMaxBoughtTimes() > playerINS.getAmount()) {
                                        iNSs.remove(playerINS);
                                        playerINS.setAmount(playerINS.getAmount() + 1);
                                        iNSs.add(playerINS);
                                    } else {
                                        content = new String[]{"执行出错！当前用户已达到该物品的购买上限！"};
                                        canBuy = false;
                                    }
                                } else if ((j == iNSs.size() - 1) && (!playerINS.getDisplayName().equals(displayName))) {
                                    ItemNameStack iNS = new ItemNameStack();
                                    iNS.setDisplayName(item.getDisplayName());
                                    iNS.setAmount(1);
                                    iNSs.add(iNS);
                                }
                            }
                            if (canBuy) {
                                samCoin = delta;
                                content = new String[]{"购买成功！当前余额为" + samCoin + "个「SamCoin」"};
                                playerInfo.setBackpack(iNSs);
                                Player player = new Player();
                                player.setPlayerName(playerInfo.getPlayerName());
                                player.setLastSignInDate(playerInfo.getLastSignInDate());
                                player.setLastLoginDate(playerInfo.getLastLoginDate());
                                player.setSamCoin(samCoin);
                                player.setBackpack(playerInfo.getBackpack());
                                Yaml.dump(player, new File(Utilities.PLAYER_DATA_PATH + senderID + ".yml"));
                            }
                        } else {
                            content = new String[]{"执行出错！余额不足以购买该物品！", "「" + item.getDisplayName() + "」仍需要" + (-delta) + "个「SamCoin」"};
                        }
                    } else {
                        content = new String[]{"执行出错！本地市场暂未上架该物品！"};
                    }
                } else if (command.indexOf("查看物品描述") == 0) {
                    String displayName = command.split("查看物品描述", 2)[1];
                    SearchItemMixture searchItemMixture = YamlMarketHandler.searchByDisplayName(displayName);
                    System.out.println("开始方法");
                    if (searchItemMixture.isContained()) {
                        System.out.println("查询到物品");
                        Item item = searchItemMixture.getItem();
                        content = new String[]{item.getDescription()};
                    } else {
                        System.out.println("没有该物品");
                        content = new String[]{"执行出错！本地市场尚未上架该商品！"};
                    }
                }
                break;
        }
//        NetworkHandler.send("content",socket);

        return content;
    }

    private static Player getPlayer(File folder, String fileName) throws FileNotFoundException {
        Player map_1 = new Player();
        YamlDecoder dec = new YamlDecoder(new FileInputStream(folder.getPath() + "/" + fileName));
        while (true) {
            try {
                map_1 = (Player) dec.readObject();
            } catch (EOFException e) {
                break;
            }
        }
        return map_1;
    }
}
