package mcquick.agentApiDemo.enums;

/**
 * @author wz
 * Date: 2022/3/25 14:43
 * Description: 文件上传枚举
 */
public enum FileUploadType {
    结算卡(200),
    身份证正面(300),
    身份证背面(400),
    商户交易认证卡(700),
    ;

    public final int id;
    FileUploadType(int id){
        this.id = id;
    }
}
