package lesson13.container;

@Config(prefix = "some")
public class SomeClassConfig {
    private String name;
    private int version;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public static void main(String[] args) {
        SomeClassConfig config = new SomeClassConfig();
        config.setName("someClass");
        config.setVersion(2);
    }
}

@Config(prefix = "other")
class OtherConfig{
    private String name;
}


