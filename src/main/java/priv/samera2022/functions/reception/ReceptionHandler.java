package priv.samera2022.functions.reception;

import net.mamoe.mirai.message.data.MessageChainBuilder;

import java.util.ArrayList;

import static priv.samera2022.functions.reception.Reception.*;

public class ReceptionHandler {
    public static ArrayList<Reception> ONLY_REQUIRE_ALL = new ArrayList();
    public static ArrayList<ReceptionIllustrative> ILLUSTRATOR_WHAT = new ArrayList();
    public static ArrayList<ReceptionIllustrative> ILLUSTRATOR_HOW = new ArrayList();
    public static ArrayList<ReceptionIllustrative> ILLUSTRATOR_ERROR = new ArrayList();
    public static ArrayList<ReceptionIllustrative> ILLUSTRATOR_ELSE = new ArrayList();

    public static void init() {
        ILLUSTRATOR_ELSE.add(new ReceptionIllustrative(new String[]{"测试口令"}, 1, new MessageChainBuilder().append("测试成功"),MESSAGE_ELSE));
        ILLUSTRATOR_HOW.add(new ReceptionIllustrative(new String[]{"Java", "java"}, 1, new MessageChainBuilder()
                .append("群文件中的Java安装文件夹有哦~\n下载之后安装完就可以了。1.16.5及以下要用Java8，1.16.5以上要用Java17"), MESSAGE_HOW));
        ILLUSTRATOR_ERROR.add(new ReceptionIllustrative(new String[]{"Java", "java"}, 1, new MessageChainBuilder()
                .append("Java安装还能出问题啊......\n试试下载群里面的离线安装包安装试试吧...再出问题我也不会了(/doge)"), MESSAGE_ERROR));
        ILLUSTRATOR_HOW.add(new ReceptionIllustrative(new String[]{"游戏","启动"}, 2, new MessageChainBuilder()
                .append("先下载对应版本的Java，然后双击打开启动器。打开启动器之后找到安装版本的地方，" +
                        "选择好是否安装Forge Fabric Optifine LiteLoader之后点击安装就好了。安装完之后登录你的账户，" +
                        "选择对应启动的版本就好啦~\n" +
                        "具体的操作详见群文件中Minecraft教程里的《我的世界教程广版》序章：开始游戏(启动游戏 P6)\n" +
                        "或者也可以点击https://www.bilibili.com/read/cv12422013/?from=readlist直接查看教程"),MESSAGE_HOW));
        ONLY_REQUIRE_ALL.add(new Reception(new String[]{"账户分类"}, 1, new MessageChainBuilder()
                .append("我的世界所有类型账户分类：\n1.微软账户(自微软收购MOJANG后开始使用的一种正版账户)\n2.Mojang账户(最开始的正版账户)\n" +
                        "3.外置账户(也被称为皮肤站账户，是一种第三方账户)\n4.通行证账户(统一通行证账户，也是一种第三方账户)\n" +
                        "5.离线账户(不联网都能用的账户，应该算是第三方账户吧)\n" +
                        "查看哪些账户可以进哪些服务器请输入(账户查看)" +
                        "具体账户间的区别详见群文件中Minecraft教程里的《我的世界教程广版》第一张：本地个性化设置(账户 P7)\n" +
                        "或者也可以点击https://www.bilibili.com/read/cv12445111/?from=readlist直接查看教程")));
        ONLY_REQUIRE_ALL.add(new Reception(new String[]{"账户查看"}, 1, new MessageChainBuilder()
                .append("准确地说，服务器有下述方法来限制账户。\n" +
                        "1.开启正版认证(只允许正版玩家进入)\n" +
                        "2.开启白名单认证(只允许所有玩家中的白名单玩家进入)\n" +
                        "3.开启皮肤站认证(只有指定皮肤站的玩家可以进入)\n" +
                        "4.开启统一通行证认证(只有统一通行证玩家可以进入)\n" +
                        "5.其他认证方式(属于自定义服务器核心，详情询问服主)\n" +
                        "特别注意！\n" +
                        "如果你是选择加入房间的话，需要使用外置或正版！如果房主是外置的话那么你可以使用外置或正版，" +
                        "如果房主是正版的话你只能使用正版加入！")));
        ILLUSTRATOR_WHAT.add(new ReceptionIllustrative(new String[]{"微软账户","Microsoft账户"}, 1, new MessageChainBuilder()
                .append("微软账户应该算是占比比较大的一种账户类型了，它在微软收购Mojang之后出现。并且还在一段时间要求Mojang账户迁移到微软账户，" +
                        "但之后不了了之了。\n它属于正版账户，但是登陆方式异于Mojang账户。它需要在启动器(旧版启动器并不支持微软登录)或其他地方中打开一个Microsoft的界面，验证完账户密码才可以，" +
                        "有时候还会要求验证邮箱或输入验证代码。\n请注意区分微软我的世界账户和微软商店我的世界账户的区别！前者是Java版我的世界的账户，后者为基岩版我的世界的账户\n" +
                        "它可以在我的世界Mojang官网购买，并且从2022年之后所有在我的世界Mojang官网购买的账户都是微软账户。\n"+
                        "具体的分类详见群文件中Minecraft教程里的《我的世界教程广版》第一章：本地个性化设置(账户 P7)\n" +
                        "或者也可以点击https://www.bilibili.com/read/cv12445111/?from=readlist直接查看教程\n" +
                        "查看具体分类请输入(账户分类)"),MESSAGE_WHAT));
        ILLUSTRATOR_WHAT.add(new ReceptionIllustrative(new String[]{"Mojang账户"}, 1, new MessageChainBuilder()
                .append("Mojang账户其实是最早的正版账户，但是在微软收购Mojang后被要求迁移到微软账户了(但是至少到现在还没有对未转移的用户做出什么限制)\n" +
                        "它可以在旧的任何启动器上登录，但似乎新的启动器不再支持这一古老的账户了。只需要在启动器中输入账户和密码就可以了。" +
                        "它现在已经无法在官网上被购买，但是还可以在各个启动器上登录。\n" +
                        "具体的分类详见群文件中Minecraft教程里的《我的世界教程广版》第一章：本地个性化设置(账户 P7)\n" +
                        "或者也可以点击https://www.bilibili.com/read/cv12445111/?from=readlist直接查看教程\n" +
                        "查看具体分类请输入(账户分类)"),MESSAGE_WHAT));
        ILLUSTRATOR_WHAT.add(new ReceptionIllustrative(new String[]{"皮肤站账户","外置账户","外置"}, 1, new MessageChainBuilder()
                .append("外置账户其实也可以被称之为皮肤站账户，是独立于正版(MOJANG和MICROSOFT)账户和离线账户，通行证账户" +
                        "之外的一种账户。它可以从网上搜索到注册的方法，这边推荐LittleSkin和BlessingSkin。\n" +
                        "具体的分类详见群文件中Minecraft教程里的《我的世界教程广版》第一章：本地个性化设置(账户 P7)\n" +
                        "或者也可以点击https://www.bilibili.com/read/cv12445111/?from=readlist直接查看教程\n" +
                        "查看具体分类请输入(账户分类)"),MESSAGE_WHAT));
        ILLUSTRATOR_WHAT.add(new ReceptionIllustrative(new String[]{"通行证账户"}, 1, new MessageChainBuilder()
                .append("通行证账户很少见，它起源于一个名为统一通行证的计划。以下文本节自统一通行证官网↓" +
                        "无需在游戏中输入/login，可直接在启动器登录，支持Spigot、PaperSpigot、TacoSpigot、Thermos、(K)Cauldron、(K)Bungeecord群组、SpongeVanilla、Torch、" +
                        "纯Forge、CraftBukkit、官方服务器等所有服务端、客户端，防压测、防假人，一个账号通行所有服务器，无需重复注册，不存在游戏ID冲突的情况。" +
                        "\n选自https://login2.nide8.com:233/account/login\n" +
                        "具体的分类详见群文件中Minecraft教程里的《我的世界教程广版》第一章：本地个性化设置(账户 P7)\n"+
                        "或者也可以点击https://www.bilibili.com/read/cv12445111/?from=readlist直接查看教程\n"+
                        "查看具体分类请输入(账户分类)"),MESSAGE_WHAT));
        ILLUSTRATOR_WHAT.add(new ReceptionIllustrative(new String[]{"离线账户"}, 1, new MessageChainBuilder()
                .append("离线账户其实可以不联网也能用。这玩意没啥特殊得功能，也没啥特殊得注册方法。启动器上输入名字就结了。\n" +
                        "具体的分类详见群文件中Minecraft教程里的《我的世界教程广版》第一章：本地个性化设置(账户 P7)\n" +
                        "或者也可以点击https://www.bilibili.com/read/cv12445111/?from=readlist直接查看教程\n" +
                        "查看具体分类请输入(账户分类)"),MESSAGE_WHAT));
        ILLUSTRATOR_WHAT.add(new ReceptionIllustrative(new String[]{"正版账户","正版"}, 1, new MessageChainBuilder()
                .append("其实微软账户和Mojang账户都属于正版账户，分别查询他俩试试啦~"),MESSAGE_WHAT));
        ILLUSTRATOR_WHAT.add(new ReceptionIllustrative(new String[]{"材质包","资源包","数据包","resource-pack","data-pack"},1,new MessageChainBuilder()
                .append("资源包一般都是zip格式的压缩文件。一般它能够修改原版的材质，纹理的我们都称其为材质包(resource-pack)。\n" +
                        "而能够在一定程度上修改游戏的规则，以特殊的方式添加特殊的方块的，一般称之为数据包(data-pack)。\n" +
                        "材质包可以全版本通用，但是可能会出一些意料之外的小bug。但是它不会是导致游戏崩溃的原因。\n" +
                        "而数据包目前尚不清楚。" +
                        "具体的关系详见群文件中Minecraft教程里的《我的世界教程广版》第一章：本地个性化设置(材质包 P9)\n" +
                        "或者也可以点击https://www.bilibili.com/read/cv12445329/?from=readlist直接查看教程"),MESSAGE_WHAT));
        ILLUSTRATOR_HOW.add(new ReceptionIllustrative(new String[]{"材质包","资源包","数据包","resource-pack","data-pack"}, 1, new MessageChainBuilder()
                .append("资源包一般都是zip格式的压缩文件。在游戏的菜单(指在服务器或存档中按esc调出的页面)或主页面中选择设置便能看到资源包设置。" +
                        "把你获得的压缩文件放进游戏目录中(指.minecraft/version/xxx/resource-packs版本隔离启动器)" +
                        "(若为非版本隔离启动器则在游戏中资源包设置中选择打开资源包文件夹)" +
                        "，之后将鼠标(光标)移动到那个资源包" +
                        "的图片上，等看到一个向左的箭头后点击那个向左的箭头，按完成就好了。可能会卡一会，但很快就会好。\n" +
                        "具体的关系详见群文件中Minecraft教程里的《我的世界教程广版》第一章：本地个性化设置(材质包 P9)\n" +
                        "或者也可以点击https://www.bilibili.com/read/cv12445329/?from=readlist直接查看教程"),MESSAGE_WHAT));
        ILLUSTRATOR_WHAT.add(new ReceptionIllustrative(new String[]{"模组","mod"}, 1, new MessageChainBuilder()
                .append("mod是我的世界极其重要的一个组成部分。甚至可以说，没有模组就没有MC的今日。模组主要分为三大类：" +
                        "Forge Fabric和LiteLoader。这三类分别对应三类模组加载器啦~" +
                        "具体的关系详见群文件中Minecraft教程里的《我的世界教程广版》第一章：本地个性化设置(模组 P10)\n" +
                        "或者也可以点击https://www.bilibili.com/read/cv12445943/?from=readlist直接查看教程\n" +
                        "查看具体分类请输入(模组加载器分类)"),MESSAGE_WHAT));
        ILLUSTRATOR_ELSE.add(new ReceptionIllustrative(new String[]{"模组","加载器","分类"}, 3, new MessageChainBuilder()
                .append("我的世界所有类型模组加载器分类：\n1.Forge(最老牌的模组加载器，模组以jar和zip结尾)\n2.Fabric(新兴模组加载器，模组以jar结尾)\n" +
                        "3.LiteLoader(轻型模组加载器，模组以litemod结尾)\n" +
                        "注意事项1：Optifine不是模组加载器！它和Iris都是光影加载器！\n" +
                        "注意事项2：在1.12.2以上，Forge和Fabric不再兼容。这意味着不论你使用什么方法都不能在1.12.2以上同时安装Forge和" +
                        "Fabric！\n" +
                        "注意事项3：Optifine可以以模组或外置加载器的方式安装在Forge和Fabric中。\n" +
                        "具体的关系详见群文件中Minecraft教程里的《我的世界教程广版》第一章：本地个性化设置(模组 P10)\n" +
                        "或者也可以点击https://www.bilibili.com/read/cv12445943/?from=readlist直接查看教程"),MESSAGE_ELSE));
        ILLUSTRATOR_HOW.add(new ReceptionIllustrative(new String[]{"模组","mod"}, 1, new MessageChainBuilder()
                .append("模组安装.......(真的有人会考虑在机器人中设置模组安装这个回答吗?)\n" +
                        "建议去看群文件中Minecraft教程里的《我的世界教程广版》第一章：本地个性化设置(模组 P10)\n" +
                        "或者也可以点击https://www.bilibili.com/read/cv12445943/?from=readlist直接查看教程"),MESSAGE_HOW));
        ILLUSTRATOR_WHAT.add(new ReceptionIllustrative(new String[]{"光影"}, 1, new MessageChainBuilder()
                .append("光影是一种显著提升游戏画质的方法，但是还是建议参照自己电脑的配置酌情使用" +
                        "(显卡烧了就不好玩了)\n目前已知的光影加载器有Optifine和Iris(光影加载器在某种意义上也可以优化游戏的):\n" +
                        "Optifine(支持绝大多数版本，且同时支持Fabric和Forge)\n" +
                        "Iris(仅支持高版本，且只支持Fabric，优化效果明显)"),MESSAGE_WHAT));
        ILLUSTRATOR_HOW.add(new ReceptionIllustrative(new String[]{"光影"}, 1, new MessageChainBuilder()
                .append("光影一般都是zip格式的文件。在安装光影加载器后(不知道光影加载器可以发(光影是什么))" +
                        "可以在游戏的菜单(指在服务器或存档中按esc调出的页面)或主页面中选择设置->视频设置->光影。打开这个界面之后就可以" +
                        "点击左下角打开光影包文件夹，把你的光影放进去。之后点击完成，再进去一次就能在列表里找到你放的光影的名字啦~\n" +
                        "点击你放的光影的名字，再点完成。可能会卡一会，但很快就会好。\n" +
                        "建议去看群文件中Minecraft教程里的《我的世界教程广版》第一章：本地个性化设置(光影 P14)\n" +
                        "或者也可以点击https://www.bilibili.com/read/cv12450055/?from=readlist直接查看教程"),MESSAGE_HOW));
        ILLUSTRATOR_WHAT.add(new ReceptionIllustrative(new String[]{"地图","存档"}, 1, new MessageChainBuilder()
                .append("地图一般指存档(save)，是我的世界的一个重要组成部分。它可以在不同的启动器和客户端服务端中使用，但要求版本和模组必须一致。" +
                        "否则会出现缺失元素的提示。"),MESSAGE_WHAT));
        ILLUSTRATOR_HOW.add(new ReceptionIllustrative(new String[]{"地图","存档"}, 1, new MessageChainBuilder()
                .append("地图一般都是以文件夹的形式出现的。如果你拿到的是压缩包格式，请尝试把他解压(如果里面只有一个文件夹的话)。" +
                        "把你获得的文件夹放进游戏目录中(指.minecraft/version/xxx/saves版本隔离启动器)" +
                        "(若为非版本隔离启动器，请参照各大启动器的设置)\n"+
                        "在完成上述操作后再打开游戏，进入单人游戏就可以看到了。\n" +
                        "建议去看群文件中Minecraft教程里的《我的世界教程广版》第一章：本地个性化设置(存档 P15)\n" +
                        "或者也可以点击https://www.bilibili.com/read/cv12882303/?from=readlist直接查看教程"),MESSAGE_HOW));
        ILLUSTRATOR_HOW.add(new ReceptionIllustrative(new String[]{"联机"}, 1, new MessageChainBuilder()
                .append("目前的联机方式有很多方式，按照通信方式的话可以划分为公网ip联机，内网穿透联机，启动器所支持的联机。\n" +
                        "按照服务端的类型还可以分为服务器联机和共享存档(即开房)联机。\n" +
                        "注意：ipv6联机方法在亘古之前被认为是不可以的，现在尚不确定。\n" +
                        "建议去看群文件中Minecraft教程里的《我的世界教程广版》第二章：联机 P16\n" +
                        "或者也可以点击https://www.bilibili.com/read/cv12498928/?from=readlist直接查看教程\n" +
                        "问我这些联机方式如何进行的话，可以问我(咋开房联机?咋开服?)"),MESSAGE_HOW));
        ILLUSTRATOR_HOW.add(new ReceptionIllustrative(new String[]{"穿透","映射"}, 1, new MessageChainBuilder()
                .append("(真的有人会把这么长的映射放到一句回答里面吗?)\n" +
                        "建议去看群文件中Minecraft教程里的《我的世界教程广版》第二章：联机 (映射 P16)\n" +
                        "或者也可以点击https://www.bilibili.com/read/cv12518757/?from=readlist直接查看教程"),MESSAGE_HOW));
        ONLY_REQUIRE_ALL.add(new Reception(new String[]{"咋开房"}, 1, new MessageChainBuilder()
                .append("在完成《映射》章节之后，可以在游戏的菜单(指在存档中按esc调出的页面)->开放到局域网。\n" +
                        "这时候就可以发现游戏的左下角文本栏里面出现了一行字，找到里面的数字端口并抄下来，填在《映射》章节中的本地端口中。\n" +
                        "这时候再打开隧道，把(地址:远程端口)发送给需要联机的人就可以了哦~\n" +
                        "(不知道啥是《映射》章节？试试输入内网穿透咋整吧~)\n" +
                        "注意！开房联机有限制！详情输入(账户查看)\n" +
                        "建议去看群文件中Minecraft教程里的《我的世界教程广版》第二章：联机 (开房联机 P18)\n" +
                        "或者也可以点击https://www.bilibili.com/read/cv12500724/?from=readlist直接查看教程")));
        ONLY_REQUIRE_ALL.add(new Reception(new String[]{"咋开服"}, 1, new MessageChainBuilder()
                .append("服务器哪有这么容易开啊.......\n" +
                        "建议去看群文件中Minecraft教程里的《我的世界教程广版》第二章：联机 (服务器联机 P19)\n" +
                        "或者也可以点击https://www.bilibili.com/read/cv12500859/?from=readlist直接查看教程")));
        ILLUSTRATOR_HOW.add(new ReceptionIllustrative(new String[]{"服","房","加"}, 2, new MessageChainBuilder()
                .append("首先需要准备好目标服务器所需要的客户端。(如果你是开房联机的话，需要准备和房主一样的客户端)\n" +
                        "模组必须要和服务器、开房的人同步，你可以多加模组，但是多的模组的内容将不会出现在游戏中。\n" +
                        "但是诸如一些功能性的模组，比如JEI，小地图，高清修复等仍然可以发挥作用。\n" +
                        "准备好这些之后进入游戏，选择多人游戏。然后选择添加服务器，输入你想要的备注名称和对方所给你的ip。\n" +
                        "点击完成，再选择刚创建的服务器，点击加入就可以啦~\n" +
                        "建议去看群文件中Minecraft教程里的《我的世界教程广版》第二章：联机 (如何进入别人的房间/服务器 P20)\n" +
                        "或者也可以点击https://www.bilibili.com/read/cv12500878/?from=readlist直接查看教程"),MESSAGE_HOW));
        ILLUSTRATOR_WHAT.add(new ReceptionIllustrative(new String[]{"插件"}, 1, new MessageChainBuilder()
                .append("插件是一种仅能用在服务器上的游戏附加内容。它可以有限地为服务器提供额外的玩法，但是它无法添加新的物品，实体等。"),MESSAGE_WHAT));
        ILLUSTRATOR_HOW.add(new ReceptionIllustrative(new String[]{"插件"}, 1, new MessageChainBuilder()
                .append("插件(绝对)都是jar格式的，打开你(必须要启动过的)服务器的目录，可以找到一个名叫plugins的文件夹。\n" +
                        "把插件放到这个文件夹里，再启动一下服务器就可以啦~\n" +
                        "建议去看群文件中Minecraft教程里的《我的世界教程广版》第三章：服务器个性化设置 (插件 P21)\n" +
                        "或者也可以点击https://www.bilibili.com/read/cv12803744/?from=readlist直接查看教程"),MESSAGE_WHAT));
        ILLUSTRATOR_HOW.add(new ReceptionIllustrative(new String[]{"server.properties"}, 1, new MessageChainBuilder()
                .append("server.properties太长啦~" +
                        "建议去看群文件中Minecraft教程里的《我的世界教程广版》第三章：服务器个性化设置 (server.properties个性化 P21)\n" +
                        "或者也可以点击https://www.bilibili.com/read/cv12804181/?from=readlist直接查看教程"),MESSAGE_HOW));
        ILLUSTRATOR_HOW.add(new ReceptionIllustrative(new String[]{"服","图标"}, 2, new MessageChainBuilder()
                .append("首先需要准备一个64*64大小的png文件。并且把这个文件改名叫server-icon.png。" +
                        "把他放到服务器目录中再重新启动一次服务器，就可以在多人游戏界面看到这个图标了。" +
                        "建议去看群文件中Minecraft教程里的《我的世界教程广版》第三章：服务器个性化设置 (图标设置 P23)\n" +
                        "或者也可以点击https://www.bilibili.com/read/cv12804379/?from=readlist直接查看教程"),MESSAGE_HOW));
        //注意：服务器如何添加模组已被删除。
        ILLUSTRATOR_HOW.add(new ReceptionIllustrative(new String[]{"整合包"}, 1, new MessageChainBuilder()
                .append("整合包的话一般有三种结构，所以出现三种安装方式。" +
                        "首先你需要解压你获得的整合包，并且观察这个整合包的结构。\n" +
                        "1.如果解压出的文件夹里有名叫(modpack)的压缩包，那么把原来的压缩包直接拖进启动器就可以安装了，之后看启动器的提示进行后续操作即可。\n" +
                        "2.如果解压出的文件夹里有名叫(.minecraft)的文件夹，那么找到里面的启动器，双击打开设置好个人信息就可以了。" +
                        "如果里面没有启动器，就放一个自己的启动器进去。\n" +
                        "3.如果没有观察到上述现象，请向你所在的群的管理求助。"),MESSAGE_HOW));
        ILLUSTRATOR_ERROR.add(new ReceptionIllustrative(new String[]{"游戏"}, 1, new MessageChainBuilder()
                .append("如果游戏发生崩溃了的话，可以去群文件中的报错检索表进行排查啦~"), MESSAGE_ERROR));

        ONLY_REQUIRE_ALL.add(new Reception(new String[]{"版号检查"},1,new MessageChainBuilder().append("版号1.0.1-stable")));
    }
}
