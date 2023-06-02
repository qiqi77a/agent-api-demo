package mcquick.agentApiDemo.entity.response;

public class QueryOrderRsp {
    /**
     * 交易状态
     * 100-待支付 200-交易处理中 300-交易成功 400-交易失败 500-出款中 600-出款成功 700-出款失败 800-出款冻结
     */
    public String transStatus;
    /**
     * 交易状态描述
     */
    public String transMsg;
    /**
     * 交易订单号
     */
    public String orderNo;
    /**
     * 服务商订单号(上送的订单号)
     */
    public String agentOrderNo;
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
     * 支付时间 yyyyMMddhhmmss
     */
    public Long tranTime;

    public String getTransStatus() {
        return transStatus;
    }

    public void setTransStatus(String transStatus) {
        this.transStatus = transStatus;
    }

    public String getTransMsg() {
        return transMsg;
    }

    public void setTransMsg(String transMsg) {
        this.transMsg = transMsg;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getAgentOrderNo() {
        return agentOrderNo;
    }

    public void setAgentOrderNo(String agentOrderNo) {
        this.agentOrderNo = agentOrderNo;
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
}
