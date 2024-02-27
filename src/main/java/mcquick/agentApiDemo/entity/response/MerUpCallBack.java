package mcquick.agentApiDemo.entity.response;

public class MerUpCallBack {
    /**
     * 服务商ID
     */
    public Long agentId;
    /**
     * 商户编号
     */
    public Long merId;
    /**
     * 商户姓名
     */
    public String merMame;
    /**
     * 登录注册手机号码
     */
    public String phone;
    /**
     * 身份证号
     */
    public String idCardNo;
    /**
     * 推荐商户Id
     */
    public Long recMerId;
    /**
     * 注册来源 100-应用市场注册 200-分享推荐注册
     */
    public Integer source;
    /**
     * 品牌类型 400-合小盟
     */
    public Integer brandType;
    /**
     * 注册时间
     */
    public Long createTime;
}
