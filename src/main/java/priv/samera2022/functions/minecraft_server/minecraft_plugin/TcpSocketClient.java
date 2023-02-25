package priv.samera2022.functions.minecraft_server.minecraft_plugin;
import priv.samera2022.utils.Utilities;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class TcpSocketClient {

    /**
     * 客户端程序
     */
    public void client() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Waiting for connection");
        Socket socket = new Socket("127.0.0.1", 1111);
        System.out.println("Already connected to the Server!");
        Thread send = new Thread(() -> {
            while (true) {
                if (socket.isConnected()) {
                    try {
                        NetworkHandler.send("Hello From Client!",socket);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        Thread receive = new Thread(() -> {
            while (true) {
                if (socket.isConnected()) {
                    try {
                        byte[] bytes = new byte[1024];
                        // 读一下服务端发来的信息
                        InputStream inputStream = socket.getInputStream();
                        int read = inputStream.read(bytes);
                        String message = Utilities.UTF8ToGB2312(new String(bytes, 0, read, StandardCharsets.UTF_8));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        send.start();
        receive.start();
    }


    public static void main(String[] args) throws IOException {
        TcpSocketClient tcpSocketServer = new TcpSocketClient();
        tcpSocketServer.client();
    }
}