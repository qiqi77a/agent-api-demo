package mcquick.agentApiDemo.entity.response.credit;

public class QueryOrderRsp {
    /**
     * 平台订单号
     */
    public String orderNo;
    /**
     * 合作方订单号
     */
    public String tradeNo;

    /**
     * 核卡状态 100-未核卡 200-已核卡
     */
    public Integer approveStatus;

    /**
     * 核卡时间
     */
    public Long approveTime;

    /**
     * 核卡结算标识 100-未结算 200-已结算
     */
    public Integer approveSettleFlag;

    /**
     * 核卡价格 分
     */
    public Long approvePrice;

    /**
     * 激活状态 100-未激活 200-已激活
     */
    public Integer activeStatus;

    /**
     * 激活时间
     */
    public Long activeTime;

    /**
     * 激活结算标识 100-未结算 200-已结算
     */
    public Integer activeSettleFlag;

    /**
     * 激活价格 分
     */
    public Long activePrice;

    /**
     * 首刷状态 100-未首刷 200-已首刷
     */
    public Integer firstUsedStatus;

    /**
     * 首刷时间
     */
    public Long firstUsedTime;

    /**
     * 首刷结算标识 100-未结算 200-已结算
     */
    public Integer firstUsedSettleFlag;

    /**
     * 首刷价格 分
     */
    public Long firstUsedPrice;

    /**
     * 拒件状态 100-未拒件 200-已拒件
     */
    public Integer refuseStatus;

    /**
     * 拒件时间
     */
    public Long refuseTime;

    /**
     * 订单关闭状态 100-未关闭 200-已关闭
     */
    public Integer closeStatus;

    /**
     * 订单关闭时间
     */
    public Long closeTime;

    /**
     * 是否新户 0-否 1-是
     */
    public Boolean newUserFlag;

    /**
     * 结算类型 100-非周期 200-周期
     */
    public Integer settleType;

    /**
     * settleType == 200 有值，周期核卡结算第几阶段。周期结算订单如果字段值为空，代表超时结算
     */
    public Integer checkStage;

    /**
     * settleType == 200 有值，周期激活结算第几阶段。周期结算订单如果字段值为空，代表超时结算
     */
    public Integer activeStage;

    /**
     * settleType == 200 有值，周期首刷结算第几阶段。周期结算订单如果字段值为空，代表超时结算
     */
    public Integer brushStage;

    /**
     * 第三方用户唯一id
     */
    public String userId;

    /**
     * 办卡人手机号，脱敏信息
     */
    public String phone;

    /**
     * 办卡人姓名，脱敏信息
     */
    public String name;

    /**
     * 申请时间
     */
    public Long applyTime;
}
