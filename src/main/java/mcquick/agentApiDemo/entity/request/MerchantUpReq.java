package mcquick.agentApiDemo.entity.request;

public class MerchantUpReq {

    //商户基本信息
    /**
     * 商户手机号
     */
    public String merPhone;

    //身份证信息
    /**
     * 身份证正面照片地址
     */
    public String idCardFrontFilepath;
    /**
     * 身份证反面照片地址
     */
    public String idCardBackFilepath;
    /**
     * 真实姓名
     */
    public String realName;
    /**
     * 身份证号
     */
    public String idCardNo;
    /**
     * 身份证有效期 "yyyyMMdd-yyyyMMdd" 或 "yyyyMMdd-长期"
     */
    public String idCardValidRange;
    /**
     * 银行卡号
     */
    public String bankCardNo;
    /**
     * 银行预留手机号
     */
    public String phone;
}