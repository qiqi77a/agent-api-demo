package mcquick.agentApiDemo.enums;

public enum Gender {
    男(100), 女(200);

    public final int id;

    Gender(int id) {
        this.id = id;
    }
}
