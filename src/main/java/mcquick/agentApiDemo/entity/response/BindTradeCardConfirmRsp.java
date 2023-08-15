package mcquick.agentApiDemo.entity.response;

public class BindTradeCardConfirmRsp {
    /**
     * 绑定状态  1 待签约确认  2 绑定成功 3 短信验证 4-绑定失败
     */
    public String bindStatus;
    /**
     * 绑卡标识
     */
    public String bindCardId;
    /**
     * 银行卡号
     */
    public String bankCardNo;
    /**
     * 拓展字段
     */
    public String extField;
}
