package mcquick.agentApiDemo.entity.request;

public class ModifyMerSettleCardReq {
    /**
     * 商户编号
     */
    public Long merchantCode;
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