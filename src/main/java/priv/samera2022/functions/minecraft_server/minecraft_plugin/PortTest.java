package priv.samera2022.functions.minecraft_server.minecraft_plugin;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.Socket;

public class PortTest {
    public static void main(String[] args) throws FileNotFoundException {
        NetworkHandler.init();

    }
    public static void connectMinecraftServer() throws IOException {
        Socket socket = new Socket();
        socket.bind(NetworkHandler.LOCAL_PORT);
        socket.connect(NetworkHandler.SERVER_PORT);
    }
}