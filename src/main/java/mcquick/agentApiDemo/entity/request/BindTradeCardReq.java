package mcquick.agentApiDemo.entity.request;

public class BindTradeCardReq {
    /**
     * 商户编号
     */
    public Long merchantCode;
    /**
     * 银行卡号
     */
    public String bankCardNo;
    /**
     * 银行预留手机号
     */
    public String phone;
    /**
     * 卡有效期
     */
    public String valiDate;
    /**
     * 校验码
     */
    public String checkNo;
    /**
     * 银行卡正面照片文件地址
     */
    public String bankCardFilepath;
    /**
     * 渠道标识
     */
    public Integer payChannel;
}
