package mcquick.agentApiDemo.entity.response;

public class MerLoanDataVo {

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
     * 真实姓名
     */
    public String realName;

    /**
     * 申请人手机号
     */
    public String merMobile;

    /**
     * 申请人身份证
     */
    public String merIdCard;

    /**
     * 放款金额
     */
    public Long drawAmount;

    /**
     * 订单状态 300-贷款成功
     */
    public Integer orderStatus;

    /**
     * 贷款期数
     */
    public Integer cycle;

    /**
     * 是否首贷 1-是
     */
    public Integer isFirstLoan;

    /**
     * 贷款时间 yyyyMMddHHmmss
     */
    public String loanDate;
}