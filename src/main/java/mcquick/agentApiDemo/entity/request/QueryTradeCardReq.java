package mcquick.agentApiDemo.entity.request;

public class QueryTradeCardReq {
    /**
     * 商户编号 和 身份证号 选择其一
     */
    public Long merchantCode;
    /**
     * 身份证号 和 商户编号 选择其一
     */
    public String idCard;
    /**
     * 银行卡号 为空时返回list
     */
    public String bankCardNo;
}
