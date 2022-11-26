package mcquick.agentApiDemo.entity.response;

public class ModifyMerSettleCardRsp {
    /**
     * 商户编号
     */
    private Long merchantCode;
    /**
     * 修改结算卡结果
     *  成功(100)
     *  失败(200)
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