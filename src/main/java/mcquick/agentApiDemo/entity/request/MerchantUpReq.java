package mcquick.agentApiDemo.entity.request;

public class MerchantUpReq {

    //商户基本信息
    /**
     * 商户手机号
     */
    public String merPhone;

    //身份证信息
    /**
     * 身份证正面照片文件地址
     */
    public String idCardFrontFilepath;
    /**
     * 身份证反面照片文件地址
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
     * Gender
     * 性别 男-100, 女-200
     */
    public Integer gender;
    /**
     * 身份证有效期 "yyyyMMdd-yyyyMMdd" 或 "yyyyMMdd-长期"
     */
    public String idCardValidRange;
    //商户所在地区信息
    /**
     * 商户所在地区省编码
     */
    public Integer provinceCode;
    /**
     * 商户所在地区市编码
     */
    public Integer cityCode;
    /**
     * 商户所在地区区编码
     */
    public Integer districtCode;
    /**
     * 商户所在地区详细地址
     */
    public String address;

    //结算卡信息
    /**
     * 银行卡正面照片文件地址
     */
    public String bankCardFilepath;
    /**
     * 银行卡号
     */
    public String bankCardNo;
    /**
     * 支行联行号
     */
    public String zBankCode;
    /**
     * 银行预留手机号
     */
    public String phone;
    //开户行所在地区信息
    /**
     * 开户行所在地区省编码
     */
    public Integer bankProvinceCode;
    /**
     * 开户行所在地区市编码
     */
    public Integer bankCityCode;
    /**
     * 开户行所在地区区编码
     */
    public Integer bankDistrictCode;
}