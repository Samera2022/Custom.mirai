package priv.samera2022.utils.yaml.config.minecraft_server;

public class MinecraftPlugin {
    private String host;
    private int port;
    private String password;
    public MinecraftPlugin(){}
    public void setHost(String host) {
        this.host = host;
    }
    public void setPort(int port) {
        this.port = port;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getHost() {
        return host;
    }
    public int getPort() {
        return port;
    }
    public String getPassword() {
        return password;
    }
}
