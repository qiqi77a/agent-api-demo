package mcquick.agentApiDemo.entity.response;

public class FileUploadRsp {
    /**
     * 图片链接
     */
    private String uri;
    /**
     * 文件路径
     */
    private String filepath;

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getFilepath() {
        return filepath;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }
}
