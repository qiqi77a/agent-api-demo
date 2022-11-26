package mcquick.agentApiDemo.entity.response;

public class TransSendMsgRsp {
    /**
     * 商户编号
     */
    private Long merchantCode;
    /**
     * 订单号
     */
    private String orderNo;

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
}