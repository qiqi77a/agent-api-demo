package mcquick.agentApiDemo.entity.request.credit;

public class ApplyCardReq {
    /**
     * 合作方订单号(不超过32个字符)
     */
    public String orderNo;
    /**
     * 产品编码
     */
    public String itemId;
    /**
     * 身份证号
     */
    public String idCardNo;
    /**
     * 身份证名字
     */
    public String idCardName;
    /**
     * 	联系人电话
     */
    public String contactTel;
    /**
     * 联系人省份
     */
    public String contactProv;
    /**
     * 联系人地市
     */
    public String contactCity;
    /**
     * 第三方用户唯一id
     */
    public String userId;
}