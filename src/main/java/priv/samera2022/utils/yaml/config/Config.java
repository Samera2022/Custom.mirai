package priv.samera2022.utils.yaml.config;

import priv.samera2022.utils.yaml.config.minecraft_server.MinecraftServer;

public class Config {
    private MinecraftServer minecraft_server;
    private Message message;
    public Config(){
    }
    public void setServer(MinecraftServer minecraft_server) {
        this.minecraft_server = minecraft_server;
    }
    public void setMessage(Message message) {
        this.message = message;
    }
    public MinecraftServer getServer() {
        return minecraft_server;
    }
    public Message getMessage() {
        return message;
    }
}
