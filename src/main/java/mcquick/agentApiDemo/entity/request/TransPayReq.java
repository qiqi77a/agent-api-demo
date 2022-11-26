package mcquick.agentApiDemo.entity.request;

public class TransPayReq {
    /**
     * 商户编号
     */
    public Long merchantCode;
    /**
     * 短信验证码
     */
    public String smsCode;
    /**
     * 订单号
     */
    public String orderNo;
}
