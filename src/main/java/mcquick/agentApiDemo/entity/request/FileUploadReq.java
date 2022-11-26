package mcquick.agentApiDemo.entity.request;

import java.io.File;

public class FileUploadReq {
    /**
     * 文件
     */
    public File file;
    /**
     * FileUploadType
     * 结算卡(200),
     * 身份证正面(300),
     * 身份证背面(400),
     * 商户交易认证卡(700),
     */
    public Integer fileType;
}
