package priv.samera2022.functions.minecraft_server.minecraft_plugin;

import priv.samera2022.utils.Utilities;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class TcpSocketServer {

    /**
     * 服务端程序
     */
    public void server() throws IOException {
        Scanner scanner = new Scanner(System.in);
        // 服务端监听 1111 端口
        ServerSocket serverSocket = new ServerSocket(1111);
        System.out.println("Waiting for Connection");
        Socket client = serverSocket.accept();
        System.out.println("Connect Successfully");
        Thread receive = new Thread(() -> {
            while (client.isConnected()) {
                try {
                    System.out.println(NetworkHandler.receive(client));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread send = new Thread(() -> {
            while (client.isConnected()) {
                try {
                    // 给客户端发端消息
                    System.out.print("please enter: ");
                    String nextLine = scanner.next();
                    if ("out".equals(nextLine)) {
                        break;
                    }
                    client.getOutputStream().write(Utilities.GB2312ToUTF8(nextLine).getBytes(StandardCharsets.UTF_8));
                } catch (IOException e){
                    e.printStackTrace();
                }
            }
        });
        receive.start();
        send.start();
    }

    public static void main(String[] args) throws IOException {
        TcpSocketServer tcpSocketServer = new TcpSocketServer();
        tcpSocketServer.server();;
    }
}