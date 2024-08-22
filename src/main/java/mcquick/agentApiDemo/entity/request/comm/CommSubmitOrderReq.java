package mcquick.agentApiDemo.entity.request.comm;

/**
 * 不选号订单提交请求
 */
public class CommSubmitOrderReq {
    /**
     * 合作方订单号(不超过32个字符)
     */
    public String tradeNo;
    /**
     * 产品编码
     */
    public Integer itemId;
    /**
     * 身份证号
     */
    public String idCardNo;
    /**
     * 身份证名字
     */
    public String idCardName;
    /**
     * 联系人姓名
     */
    public String contactor;
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
     * 联系人区县
     */
    public String contactArea;
    /**
     * 联系人地址
     */
    public String contactAddr;
    /**
     * 身份证国徽照url
     */
    public String idCardPicFront;
    /**
     * 身份证人像照url
     */
    public String idCardPicBack;
    /**
     * 身份证手持照url
     */
    public String idCardPicHand;
    /**
     * 下单时落地页原始链接
     */
    public String platParams;
    /**
     * 合作方自定义字段
     */
    public String extMsg;
    /**
     * 用户参数(JSON)
     */
    public String userParams;
    /**
     * 用户IP
     */
    public String userIp;

    public static class UserParams {
        /**
         * 归属地省份编码(和收货地编码一致)
         */
        public Integer numberProvinceNo;
        /**
         * 归属地城市编码(和收货地编码一致)
         */
        public Integer numberCityNo;
        /**
         * 收货地省份编码
         */
        public Integer postProvinceNo;
        /**
         * 收货地城市编码
         */
        public Integer postCityNo;
        /**
         * 收货地区县编码
         */
        public Integer postAreaNo;
    }
}
