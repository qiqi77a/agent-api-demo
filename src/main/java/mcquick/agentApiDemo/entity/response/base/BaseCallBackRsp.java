package mcquick.agentApiDemo.entity.response.base;

public class BaseCallBackRsp {
    /**
     * 响应状态
     *  验签成功(100)
     *  验签失败(200)
     */
    private Integer status;
    /**
     * 请求流水号
     */
    private String ReqNo;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getReqNo() {
        return ReqNo;
    }

    public void setReqNo(String reqNo) {
        ReqNo = reqNo;
    }
}
