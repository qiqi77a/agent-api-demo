package mcquick.agentApiDemo.entity.response;

public class MerPayDataVo {

    /**
     * 机构id
     */
    public Long agentId;

    /**
     * 机构名称
     */
    public String agentName;

    /**
     * 平台交易单号
     */
    public String orderNo;

    /**
     * 商户编号
     */
    public String code;

    /**
     * 商户名称
     */
    public String name;

    /**
     * 交易类型 100-快捷支付 200-银二支付 300-微信支付 400-支付宝支付 500银二大额支付
     */
    public Integer tradeType;

    /**
     * 订单状态 100-待支付 200-交易处理中 300-交易成功 400-交易失败 500-出款中 600-出款成功 700-出款失败 800-出款冻结
     */
    public String transStatus;

    /**
     * 买单金额
     */
    public Long tradeAmount;

    /**
     * 折扣金额
     */
    public Long disCountAmt;

    /**
     * 交易时间 yyyyMMddHHmmss
     */
    public String tradeDate;

    /**
     * 交易店铺ID
     */
    public String tradeShopId;

    /**
     * 交易店铺名称
     */
    public String tradeShopName;
}