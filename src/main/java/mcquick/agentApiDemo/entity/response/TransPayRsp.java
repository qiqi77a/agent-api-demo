package mcquick.agentApiDemo.entity.response;

public class TransPayRsp {
    /**
     * 商户编号
     */
    private Long merchantCode;
    /**
     * 支付订单号
     */
    private String orderNo;
    /**
     * 支付金额 分
     */
    private Long amount;
    /**
     * 快捷支付(100)
     */
    private Integer payType;
    /**
     * 订单状态 200-处理中 300-成功 400-失败
     */
    private Integer transStatus;
    /**
     * 订单失败原因
     */
    private String transMsg;
    /**
     * 下单时间  20220402000000
     */
    private Long payOrderTime;

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public Integer getTransStatus() {
        return transStatus;
    }

    public void setTransStatus(Integer transStatus) {
        this.transStatus = transStatus;
    }

    public Long getPayOrderTime() {
        return payOrderTime;
    }

    public void setPayOrderTime(Long payOrderTime) {
        this.payOrderTime = payOrderTime;
    }

    public Long getMerchantCode() {
        return merchantCode;
    }

    public void setMerchantCode(Long merchantCode) {
        this.merchantCode = merchantCode;
    }

    public String getTransMsg() {
        return transMsg;
    }

    public void setTransMsg(String transMsg) {
        this.transMsg = transMsg;
    }
}
