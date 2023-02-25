package priv.samera2022.functions.reception;

import net.mamoe.mirai.message.data.MessageChainBuilder;


public class Reception {
    public static final int MESSAGE_DEFAULT = -1;
    public static final int MESSAGE_MUST_INCLUDE = 1;
    public static final int MESSAGE_WHAT = 2;
    public static final int MESSAGE_ERROR = 3;
    public static final int MESSAGE_HOW = 4;
    public static final int MESSAGE_ELSE = 5;
    //此处requireWords指必须全部包含的词
    private String[] requireWords;
    private int repeatTimes;
    private MessageChainBuilder reply;
    public Reception(String[] requireWords, int repeatTimes, MessageChainBuilder reply){
        this.requireWords = requireWords;
        this.repeatTimes = repeatTimes;
        this.reply = reply;
    }
    public String[] getRequireWords() {
        return requireWords;
    }

    public int getRepeatTimes() {
        return repeatTimes;
    }

    public MessageChainBuilder getReply(){
        return reply;
    }
}