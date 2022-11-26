package mcquick.agentApiDemo.entity.response;

public class PayCallBack {
    /**
     * 交易状态
     *  SUCCESS
     */
    public String trxStatus;
    /**
     * 交易状态描述
     *  出款成功
     */
    public String msg;
    /**
     * 请求流水号
     */
    public String ReqNo;

    /**
     * 商户编号
     */
    public Long merchantCode;
    /**
     * 交易订单号
     */
    public String orderNo;
    /**
     * 交易金额(分)
     */
    public Long amount;
    /**
     * 交易手续费(分)
     */
    public Long tradeFee;
    /**
     * 结算手续费(分)
     */
    public Long settleFee;
    /**
     * 下单时间 yyyyMMddhhmmss
     */
    public Long createTime;
    /**
     * 支付时间 yyyyMMddhhmmss
     */
    public Long tranTime;
    /**
     * 真实姓名
     */
    public String realName;
    /**
     * 支付卡号
     */
    public String cardNo;
}
