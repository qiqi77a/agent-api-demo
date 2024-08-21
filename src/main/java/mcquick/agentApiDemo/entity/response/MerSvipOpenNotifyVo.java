package mcquick.agentApiDemo.entity.response;

public class MerSvipOpenNotifyVo {

    /**
     * 机构id
     */
    public Long agentId;

    /**
     * 机构名称
     */
    public String agentName;

    /**
     * 商户编号
     */
    public String code;

    /**
     * 商户名称
     */
    public String name;

    /**
     * 商户手机号
     */
    public String merMobile;

    /**
     * 商户名称
     */
    public String merIdCard;

    /**
     * 平台交易单号
     */
    public String orderNo;

    /**
     * 交易金额
     */
    public Long tradeAmount;

    /**
     * 开通状态
     */
    public Integer status;

    /**
     * 会员开始日期 yyyyMMddHHmmss
     */
    public String vipStartTime;

    /**
     * 会员结束日期 yyyyMMddHHmmss
     */
    public String vipEndTime;

    /**
     * 开通类型
     */
    public Integer openType;
}