package priv.samera2022.utils.yaml.config.minecraft_server;

public class MinecraftServer {
    private MinecraftRcon[] minecraft_rcon;
    private MinecraftPlugin minecraft_plugin;
    public MinecraftServer(){}
    public void setRcon(MinecraftRcon[] minecraft_rcon) {
        this.minecraft_rcon = minecraft_rcon;
    }
    public void setPlugin(MinecraftPlugin minecraft_plugin) {
        this.minecraft_plugin = minecraft_plugin;
    }
    public MinecraftRcon[] getRcon() {
        return minecraft_rcon;
    }
    public MinecraftPlugin getPlugin() {
        return minecraft_plugin;
    }
}
