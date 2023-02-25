package priv.samera2022.utils.yaml.config.minecraft_server;

public class MinecraftRcon {
    private String prefix;
    private String name;
    private String host;
    private int port;
    private String password;
    public MinecraftRcon(){ }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setHost(String host) {
        this.host = host;
    }
    public void setPort(int port) {
        this.port = port;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getPrefix() {
        return prefix;
    }
    public String getName() {
        return name;
    }
    public String getHost() {
        return this.host;
    }
    public int getPort() {
        return this.port;
    }
    public String getPassword() {
        return password;
    }

}
