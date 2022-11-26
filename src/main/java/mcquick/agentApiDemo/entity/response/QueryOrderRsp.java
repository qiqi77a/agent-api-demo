package mcquick.agentApiDemo.entity.response;

public class QueryOrderRsp {
    /**
     * 交易状态
     * SUCCESS	成功（出款成功）
     * FAIL	失败（扣款失败或订单截止时间未付款成功）
     * PROCESSING	处理中（在 FAIL 之外的情况下在出款成功之前都是此状态）
     */
    public String trxStatus;
    /**
     * 交易状态描述
     */
    public String msg;

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

    public String getTrxStatus() {
        return trxStatus;
    }

    public void setTrxStatus(String trxStatus) {
        this.trxStatus = trxStatus;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Long getMerchantCode() {
        return merchantCode;
    }

    public void setMerchantCode(Long merchantCode) {
        this.merchantCode = merchantCode;
    }

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

    public Long getTradeFee() {
        return tradeFee;
    }

    public void setTradeFee(Long tradeFee) {
        this.tradeFee = tradeFee;
    }

    public Long getSettleFee() {
        return settleFee;
    }

    public void setSettleFee(Long settleFee) {
        this.settleFee = settleFee;
    }

    public Long getTranTime() {
        return tranTime;
    }

    public void setTranTime(Long tranTime) {
        this.tranTime = tranTime;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }
}
