package mcquick.agentApiDemo.entity.request;

public class BindTradeCardConfirmReq {
    /**
     * 商户编号
     */
    public Long merchantCode;
    /**
     * 银行卡号
     */
    public String bankCardNo;
    /**
     * 验证码
     */
    public String smsCode;
    /**
     * 渠道标识
     */
    public Integer payChannel;
}
