package mcquick.agentApiDemo.entity.response.base;

public class BaseRsp<T> {
    /**
     * 返回状态码
     */
    private Integer code;
    /**
     * 返回状态描述
     */
    private String msg;

    /**
     * 返回数据
     */
    private T data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
