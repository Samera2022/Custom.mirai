package priv.samera2022.functions.reception;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

import static priv.samera2022.functions.reception.Reception.*;
import static priv.samera2022.functions.reception.ReceptionHandler.*;

public class MessageHandler {
    private static String REPLY = null;
    private static final String[] WHAT = new String[]{"什么","啥"};
    private static final String[] HOW_BY_ASKING = new String[]{"怎么","如何","如果","怎样","咋"};
    private static final String[] HOW_TO_DO = new String[]{"下载","导入","开房","联机","解决","启动","设置","办","整","弄","搞","装","安","进","加","下","存档"};
    private static final String[] ERROR = new String[]{"报错","错误","异常","崩溃"};
    public static String getTutorialReply(String message) {
        int messageType = MESSAGE_DEFAULT;
        boolean isRequireAll = false;
        for (Reception reception : ONLY_REQUIRE_ALL) {
            for (String requireWord : reception.getRequireWords()) {
                if (requireWord.equals(message)) {
                    messageType = MESSAGE_MUST_INCLUDE;
                    REPLY = reception.getReply().asMessageChain().contentToString();
                    isRequireAll = true;
                    break;
                }
            }
        }
        if (!isRequireAll) {
            if ((repeatTimes(message, WHAT) >= 1) && contain(message, "是")) {
                messageType = MESSAGE_WHAT;
            } else if ((repeatTimes(message, HOW_BY_ASKING) >= 1) && (repeatTimes(message, HOW_TO_DO) >= 1)) {
                if (repeatTimes(message, ERROR) >= 1) {
                    messageType = MESSAGE_ERROR;
                } else {
                    messageType = MESSAGE_HOW;
                }
            } else if (loop(MESSAGE_ELSE, message) != null) {
                messageType = MESSAGE_ELSE;
            }
        }
        String finalReturn = null;
        if (REPLY == null) {
            finalReturn = loop(messageType, message);
        }
        else {
            finalReturn = REPLY;
            REPLY = null;
        }
        return finalReturn;
    }
    private static String loop(int num, String message){
        String replyText = null;
        ArrayList<ReceptionIllustrative> RI = null;
        switch (num){
            case MESSAGE_DEFAULT:
                break;
            case MESSAGE_WHAT:
                RI = ILLUSTRATOR_WHAT;
                break;
            case MESSAGE_ERROR:
                RI = ILLUSTRATOR_ERROR;
                break;
            case MESSAGE_HOW:
                RI = ILLUSTRATOR_HOW;
                break;
            case MESSAGE_ELSE:
                RI = ILLUSTRATOR_ELSE;
        }
        if (RI!=null) {
            for (ReceptionIllustrative illustrator : RI) {
                if (repeatTimes(message, illustrator.getRequireWords())>=illustrator.getRepeatTimes()) {
                    replyText = illustrator.getReply().asMessageChain().contentToString();
                    break;
                }
            }
        }
        return replyText;
    }
    private static boolean contain(@NotNull String string1, String string2) {
        //string2在string1中
        int code = string1.indexOf(string2);
        return (code != -1);
    }

    private static int repeatTimes(String string1, @NotNull String[] strings2) {
        //string1中出现过多少次strings2中的内容
        //注意：strings2中的一个内容如果在string1中出现多次不会重复计数
        int i = 0;
        int repeat = 0;
        while (i < strings2.length) {
            String content = strings2[i];
            if (contain(string1, content)) {
                repeat++;
            } else if (i == strings2.length - 1) {
                break;
            }
            i++;
        }
        return repeat;
    }
}
