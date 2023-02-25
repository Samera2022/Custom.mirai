package priv.samera2022.functions.reception;

import net.mamoe.mirai.message.data.MessageChainBuilder;


public class ReceptionIllustrative extends Reception{
    private String[] requireWords;
    private int repeatTimes;
    private MessageChainBuilder reply;
    private int receptionType;
    public ReceptionIllustrative(String[] requireWords, int repeatTimes, MessageChainBuilder reply, int receptionType) {
        super(requireWords, repeatTimes, reply);
        this.requireWords = requireWords;
        this.repeatTimes = repeatTimes;
        this.reply = reply;
        this.receptionType = receptionType;
    }
    public int getReceptionType() {
        return receptionType;
    }
}
