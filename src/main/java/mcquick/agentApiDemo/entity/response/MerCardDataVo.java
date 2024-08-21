package mcquick.agentApiDemo.entity.response;

public class MerCardDataVo {

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
     * 联系人电话
     */
    public String merMobile;

    /**
     * 产品名称
     */
    public String productName;

    /**
     * 订单类型 100-推荐申请 200-本人申请
     */
    public Integer orderType;

    /**
     * 运营商类型 100-移动 200-联通 300-电信 400-广电
     */
    public Integer operatorType;

    /**
     * 订单状态 100-成功 200-失败 300-处理中
     */
    public Integer orderStatus;

    /**
     * 下单时间 yyyyMMddHHmmss
     */
    public String createTime;

    /**
     * 新卡激活状态 100-未激活 200-已激活 300-激活失败
     */
    public Integer actStatus;

    /**
     * 激活时间
     */
    public String actTime;

    /**
     * 新卡首充状态 100-未首充 200-已首充
     */
    public Integer rechargeStatus;

    /**
     * 首充时间
     */
    public String rechargeTime;

    /**
     * 首充金额
     */
    public Long rechargeAmt;

    /**
     * 新手机号
     */
    public String newMobile;

    /**
     * 身份证号
     */
    public String idCardNo;

    /**
     * 身份证名字
     */
    public String cardName;

    /**
     * 套餐金额
     */
    public Long monthlyAmt;

    /**
     * 佣金金额
     */
    public Long commissionAmount;

    /**
     * 奖励方式: 100-单次，200-长期
     */
    public Integer rwdCycle;
}