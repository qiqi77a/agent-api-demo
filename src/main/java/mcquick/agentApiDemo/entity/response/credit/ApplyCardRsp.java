package mcquick.agentApiDemo.entity.response.credit;

public class ApplyCardRsp {
    /**
     * 激活价格，单位分
     */
    public Long activePrice;
    /**
     * 申请卡片链接
     */
    public String applyUrl;
    /**
     * 核卡价格，单位分
     */
    public Long approvePrice;
    /**
     * 首刷价格，单位分
     */
    public Long firstUsedPrice;
    /**
     * 机构订单号
     */
    public String orderNo;
    /**
     * 平台订单号
     */
    public String platOrderNo;
}