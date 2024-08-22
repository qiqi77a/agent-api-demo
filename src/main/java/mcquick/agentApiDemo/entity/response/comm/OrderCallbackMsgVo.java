package mcquick.agentApiDemo.entity.response.comm;

/**
 * 通讯卡订单回调参数
 */
public class OrderCallbackMsgVo {
    /**
     * 服务商编号
     */
    public Long agentId;
    /**
     * 	平台订单号
     */
    public String orderNo;
    /**
     * 合作方订单号
     */
    public String tradeNo;
    /**
     * 订单状态 100-成功 200-失败 300-处理中
     */
    public Integer status;
    /**
     * 结果消息
     */
    public String message;
    /**
     * 供应商订单号
     */
    public String spOrderNo;
    /**
     * 新手机号
     */
    public String mobile;
    /**
     * 物流名称
     */
    public String expressName;
    /**
     * 	物流单号
     */
    public String expressNo;
    /**
     * 激活状态 100-未激活 200-已激活 300-激活失败
     */
    public Integer activateStatus;
    /**
     * 激活时间 格式：yyyyMMddHHmmss
     */
    public Long activateTime;
    /**
     * 首充状态 100-未首充 200-已首充
     */
    public Integer rechargeStatus;
    /**
     * 首充时间 格式：yyyyMMddHHmmss
     */
    public Long rechargeTime;
    /**
     * 首充面值（单位:分）
     */
    public Long rechargeFace;
    /**
     * 	照片后补上传地址（联通）
     */
    public String uploadAddress;
    /**
     * 	附加自定义参数
     */
    public String extMsg;
    /**
     * 下单链接
     */
    public String pageUrl;
}