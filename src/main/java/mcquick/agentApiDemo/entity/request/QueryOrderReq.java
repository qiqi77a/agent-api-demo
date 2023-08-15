package mcquick.agentApiDemo.entity.request;

public class QueryOrderReq {
    /**
     * 商户编号
     */
    public Long merchantCode;
    /**
     * 订单号
     */
    public String orderNo;
    /**
     * 服务商订单号(上送的订单号)
     */
    public String agentOrderNo;
    /**
     * 下单时间
     */
    public Long payOrderTime;
}
