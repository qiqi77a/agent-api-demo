package mcquick.agentApiDemo.entity.response;

public class MerUpStatusRsp {
    /**
     * 平台商户编号
     */
    private Long merchantCode;
    /**
     * 进件状态
     * 进件失败(0),已注册未实名(100),已实名未绑卡(200), 正常(300),禁用(400),注销(500);
     */
    private Integer status;
    /**
     * 信息
     */
    private String msg;

    public Long getMerchantCode() {
        return merchantCode;
    }

    public void setMerchantCode(Long merchantCode) {
        this.merchantCode = merchantCode;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}