package mcquick.agentApiDemo.entity.request;

public class TransSendMsgReq {
    /**
     * 平台商户编号
     */
    public Long merchantCode;
    /**
     * 交易金额(分)
     */
    public Long amount;
    /**
     * 交易卡号
     */
    public String cardNo;
    /**
     * 交易卡校验码（银行卡背面三位校验码）
     */
    public String cvn;
    /**
     * 交易卡有效期 MMyy
     */
    public String validPeriod;
    /**
     * 银行预留手机号
     */
    public String phone;
    /**
     * 商户交易费率（如:万分之56，此处填5600）
     */
    public Long tradeRate;
    /**
     * 商户结算手续费（分）
     */
    public Long settleFee;
    /**
     * 商户ip
     */
    public String clientIP;
    /**
     * 商户交易所在地区省编码
     */
    public Integer provCode;
    /**
     * 商户交易所在地区市编码
     */
    public Integer cityCode;
}
