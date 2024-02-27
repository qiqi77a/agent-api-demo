package mcquick.agentApiDemo.entity.response;

public class MerBindSnCallBack {
    /**
     * 服务商ID
     */
    public Long agentId;
    /**
     * 商户编号
     */
    public Long merId;
    /**
     * sn
     */
    public String sn;
    /**
     * 终端类型 100-虚拟码牌 200-实体码牌
     */
    public Integer deviceType;
    /**
     * 绑定时间
     */
    public Long bindTime;
}
