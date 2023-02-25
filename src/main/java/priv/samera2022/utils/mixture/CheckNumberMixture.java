package priv.samera2022.utils.mixture;

public class CheckNumberMixture extends Mixture{
    private int code;
    private String output;
    public static final int CODE_IS_NULL = 0;
    public static final int CODE_CONTAINS_NON_NUMBER = 1;
    public static final int CODE_IS_NUMBER = 2;
    public CheckNumberMixture(int code, String output){
        super(code,output);
        this.code = code;
        this.output = output;
    }
    public int getCode() {
        return code;
    }
    public String getOutput() {
        return output;
    }
}
