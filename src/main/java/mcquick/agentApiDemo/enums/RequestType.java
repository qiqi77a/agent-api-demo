package mcquick.agentApiDemo.enums;

public enum RequestType {
    POST(1, "post"),
    GET(2, "GET"),
    ;

    private Integer id;
    private String name;

    RequestType(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}
