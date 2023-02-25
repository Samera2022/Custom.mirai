package priv.samera2022.functions.minecraft_server.minecraft_plugin;

import priv.samera2022.utils.Utilities;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class NetworkHandler {
    public static InetSocketAddress LOCAL_PORT;
    public static InetSocketAddress SERVER_PORT;

    public static void init() throws FileNotFoundException {
        LOCAL_PORT = new InetSocketAddress(25576);
        SERVER_PORT = new InetSocketAddress(25577);
//        LOCAL_PORT = new InetSocketAddress((int) ((HashMap<?,?>)YamlHandler.getConfig("server").get("minecraft_plugin")).get("local_port"));
//        SERVER_PORT = new InetSocketAddress((int) ((HashMap<?,?>)YamlHandler.getConfig("server").get("minecraft_plugin")).get("server_port"));
    }

    public static void send(String content, Socket socket) throws IOException {
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write(Utilities.GB2312ToUTF8(content).getBytes(StandardCharsets.UTF_8));
    }
    public static String receive(Socket socket) throws IOException {
        byte[] bytes = new byte[1024];
        InputStream inputStream = socket.getInputStream();
        int read = inputStream.read(bytes);
        return Utilities.UTF8ToGB2312(new String(bytes, 0, read, StandardCharsets.UTF_8));
    }
}
